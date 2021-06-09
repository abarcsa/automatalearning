package hu.bme.mit.automatalearning.algorithm.dhc;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.checkerframework.checker.units.qual.m;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy.QueueElement;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.AdaptiveTeacher;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class IADHCM<I, O> extends ActiveLearningAlgorithm<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>>{
	
	List<? extends I> inputAlphabet;
	DHCHypothesis<I, O, MealyMachine, State, Transition> hypothesis;
	
	//dhc global 
	List<List<? extends I>> splitters = new ArrayList<>();
	//dhc global that needs initialization
	BiMap<State, List<I>> accessSequences = HashBiMap.create();
	// dhc local that need initialization here
	BiMap<List<Optional<O>>, State> signatures = HashBiMap.create();
	ArrayDeque<QueueElement<I, O, State>> statesToComplete = new ArrayDeque<>();
	
	//adaptive
	boolean reset = false;
	AdaptionCommand currCommand = AdaptionCommand.OPTIMISTIC;

	
	public IADHCM(Teacher<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>, ?> teacher, 
			List<? extends I> inputAlphabet,
			DHCHypothesis<I, O, MealyMachine, State, Transition> hypothesis) {
		this.teacher = teacher;
		this.inputAlphabet = inputAlphabet;
		this.hypothesis = hypothesis;
		
		reset();	//TODO remove, unnecessary
	}
	
	// reset hypo, based on that reset (accessseqences), signatures, statestocomplete
	private void reset() {
		// clean data structures
		hypothesis.resetHypothesis();
		statesToComplete = new ArrayDeque<>();
		signatures = HashBiMap.create();
		
		// initialize based on the "original" hypothesis
		MealyMachine m = hypothesis.getHypothesisAutomaton();
		
		// build spanning tree
		Node<I,O> root = new Node<>(m.getInitialState().getName(), null, null, null);
		
		List<Node<I,O>> examine = new ArrayList<>();
		List<Node<I,O>> next = new ArrayList<>();
		List<String> marked = new ArrayList<>();
		List<Node> nodes = new ArrayList<>();
		
		examine.add(root);
		marked.add(root.stateName);
		
		// graph must be connected through directed edges from the root TODO
		for(int i = 0; i < m.getStates().size(); ++i) {	//find a better/narrower condition? 
			for(Node<I,O> curr : examine) {
				for(Transition t : m.getTransitions()) {
					if(t.getSourceState().getName().equals(curr.stateName)) {
						if(!marked.contains(t.getTargetState().getName())) {
							State target = t.getTargetState();
							Node<I,O> toAdd = new Node<I,O>(target.getName(), curr, (I)t.getInput(), (O)t.getOutput());
							curr.addChild(toAdd, (I)t.getInput());
							next.add(toAdd);
							marked.add(toAdd.stateName);
							nodes.add(toAdd);
						}
					}
				}
			}
			examine = next;
			next = new ArrayList<>();
		}
		
		List<QueueElement<I,O,State>> queueElements = new ArrayList<>();
		//for each initialized node
		for(Node<I,O> node : root.preorder()) {
			// get its access sequence
			State corresponding = m.getStates().stream().filter(s -> s.getName().equals(node.stateName)).findFirst().get();
			if(!accessSequences.containsKey(corresponding)) {
				accessSequences.put(corresponding, node.getAccess());
			}
			// get its output signature for the input alphabet
			List<Optional<O>> sig = new ArrayList<>();
			for(I inp : inputAlphabet) {
				boolean flag = true;
				for(Transition tran : m.getTransitions()) {
					if(tran.getSourceState().getName().equals(node.stateName) && 
						tran.getInput().equals(inp)) {
						//System.out.println(inp);
						sig.add((Optional<O>) Optional.of(tran.getOutput()));
						flag = false;
						break;
					}
				}
				if(flag) sig.add(Optional.empty());
			}
			// get its output signature for the splitters (TODO only the contained in the init hypothesis?)
			sig.addAll(findSplitterOutputSignature(node.getAccess()));
			signatures.put(sig, corresponding);
			// add all non-complete to statesToComplete
			if(sig.stream().anyMatch(o -> o.isEmpty())) {
				QueueElement<I,O,State> qe;
				if(node.parent != null) {
				 qe = new QueueElement<I,O,State>(m.getStates().stream().filter(s -> s.getName().equals(node.parent.stateName)).findFirst().get(), 
						queueElements.stream().filter(e -> e.state.get().getName().equals(node.parent.stateName)).findFirst().get(), 
						node.parentAccessI, node.parentAccessO, 
						m.getStates().stream().filter(s->s.getName().equals(node.stateName)).findFirst());
				} else {
					qe = new QueueElement<I,O,State>(null, 
						null, 
						null, null, 
						m.getStates().stream().filter(s->s.getName().equals(node.stateName)).findFirst());
				}
				queueElements.add(qe);
				statesToComplete.add(qe);
			}
		}
	}
	

	@Override
	public DHCHypothesis<I, O, MealyMachine, State, Transition> execute() {
		List<? extends I> counterExample = null;
		DHCHypothesis<I, O, MealyMachine, State, Transition> h = null;
		do {
			if(counterExample != null) {
				refineHypothesis(counterExample);
			}
			h = constructHypothesis();
			Utils.logHypothesisToJSON((Hypothesis<String, String, MealyMachine, State, Transition>) h, "DHC");
			if(!reset) counterExample = teacher.equivalenceQuery(h, inputAlphabet);
			else reset = false;
			System.out.println("CE: " + counterExample);
		}while(counterExample != null);
		
		return h;
	}
	
	
	public DHCHypothesis<I, O, MealyMachine, State, Transition> constructHypothesis() {
		reset();
		while(!statesToComplete.isEmpty()) {
			QueueElement<I, O, State> currentElement = statesToComplete.pop();
			//System.out.println("Current: " + currentElement.state + " Input: " + currentElement.input);
			List<I> currSequence = getAccessSequence(currentElement);
			LinkedHashMap<I, Optional<O>> currAlphabetSignature = findAlphabetOutputSignature(currSequence);
			if(currCommand == AdaptionCommand.RESET) {
				reset = true;
				break;
			}
			List<Optional<O>> currSignature = new ArrayList<>(currAlphabetSignature.values());
			currSignature.addAll(findSplitterOutputSignature(currSequence));
			if(currCommand == AdaptionCommand.RESET) {
				reset = true;
				break;
			}
			
			if(currentElement.state.isPresent()) {
				// the current state is an existing one
				State currentState = currentElement.state.get();
				// extend with the missing parts of the signature
				List<Optional<O>> prevSignature = signatures.inverse().forcePut(currentState, currSignature);
				// add missing inputAlphabet-related parts of the signature to statesToComplete
				for (int i = 0; i < inputAlphabet.size(); ++i) {
					if(prevSignature.get(i).isEmpty()) {
						I symbol = inputAlphabet.get(i);
						statesToComplete.add(new QueueElement<I, O, State>(currentState, currentElement, symbol, currAlphabetSignature.get(symbol).get(), Optional.empty()));
					}
				}
				//accessSequence already added, as it was initialized that way
			} else {
				State sibling = findStateWithSameSignature(signatures, currSignature);
				if (sibling != null) {
					// the current state was already created and handled elsewhere
					// reroute incoming to that one
					hypothesis.addTransition(currentElement.parentState, sibling, currentElement.input, currentElement.output);
					List<Transition> selected = new ArrayList<>();
					for(Transition t : hypothesis.getHypothesisAutomaton().getTransitions()) {
						if(currentElement.state.isPresent() && t.getSourceState().equals(currentElement.state.get())) {
							selected.add(t);
						}
					}
					for(Transition t : selected) {
						System.out.println(sibling);
						hypothesis.addTransition(sibling, t.getTargetState(), (I)t.getInput(), (O)t.getOutput());
						hypothesis.removeTransition(t);
					}
					// reroute outgoing from that one
					selected = new ArrayList<>();
					for(Transition t : hypothesis.getHypothesisAutomaton().getTransitions()) {
						if(currentElement.state.isPresent() && t.getTargetState().equals(currentElement.state.get())) {
							selected.add(t);
						}
					}
					for(Transition t : selected) {
						hypothesis.removeTransition(t);
					}
				} else {
					// create new state
					State newState  = currentElement.parentElement == null ? 
							hypothesis.addInitialState() : hypothesis.createNewState();
					//	-> accessSeq
					this.accessSequences.forcePut(newState, currSequence);
					//	-> hypothesis transition(s)
					if (currentElement.parentElement != null) {
	                    hypothesis.addTransition(currentElement.parentState, newState, currentElement.input, currentElement.output);
	                }
					//	-> signature
	                signatures.forcePut(currSignature, newState);
					//  -> if not pessimistic, add to statestocomplete
					if(!currCommand.equals(AdaptionCommand.PESSIMISTIC)) {
	                	for(I symbol : hypothesis.getHypothesisInputAlphabet()) {
	                    	statesToComplete.add(new QueueElement<I, O, State>(newState, currentElement, symbol, currAlphabetSignature.get(symbol).get(), Optional.empty()));
	                    }
	                }
				}
			}
		}
		return hypothesis;
	}
	
//	public DHCHypothesis<I, O, MealyMachine, State, Transition> constructHypothesis() {
//		reset();
//		
//		while(!statesToComplete.isEmpty()) {
//			QueueElement<I, O, State> currentElement = statesToComplete.pop();
//			//System.out.println("Current: " + currentElement.state + " Input: " + currentElement.input);
//			
//			List<I> currSequence = getAccessSequence(currentElement);
//			
//			LinkedHashMap<I, Optional<O>> currAlphabetSignature = findAlphabetOutputSignature(currSequence);
//			if(currCommand == AdaptionCommand.RESET) {
//				reset = true;
//				break;
//			}
//			List<Optional<O>> currSignature = new ArrayList<>(currAlphabetSignature.values());
//			currSignature.addAll(findSplitterOutputSignature(currSequence));
//			if(currCommand == AdaptionCommand.RESET) {
//				reset = true;
//				break;
//			}
//			
//			State sibling = findStateWithSameSignature(signatures, currSignature);
//			//System.out.println("Sibling: " + sibling);
//			if(sibling != null) {	//If a sibling exists, merge currState to sibling
//				hypothesis.addTransition(currentElement.parentState, sibling, currentElement.input, currentElement.output);
//				List<Transition> selected = new ArrayList<>();
//				for(Transition t : hypothesis.getHypothesisAutomaton().getTransitions()) {
//					if(currentElement.state.isPresent() && t.getSourceState().equals(currentElement.state.get())) {
//						selected.add(t);
//					}
//				}
//				for(Transition t : selected) {
//					System.out.println(sibling);
//					hypothesis.addTransition(sibling, t.getTargetState(), (I)t.getInput(), (O)t.getOutput());
//					hypothesis.removeTransition(t);
//				}
//				selected = new ArrayList<>();
//				for(Transition t : hypothesis.getHypothesisAutomaton().getTransitions()) {
//					if(currentElement.state.isPresent() && t.getTargetState().equals(currentElement.state.get())) {
//						selected.add(t);
//					}
//				}
//				for(Transition t : selected) {
//					hypothesis.removeTransition(t);
//				}
//			}else {	//If there are no siblings, the targetState of all transitions going from currentState is set to a new state
//				State halfSibling = findStateWithSimilarSignature(signatures, currSignature);
//				//System.out.println("Half-sibling: " + halfSibling);
//				if(halfSibling != null) {
//					hypothesis.addTransition(currentElement.parentState, halfSibling, currentElement.input, currentElement.output);
//					//also reroute!
//				} else {
//					State newState;
//					if(currentElement.state.isEmpty()) {
//						newState = currentElement.parentElement == null ? hypothesis.addInitialState() : hypothesis.createNewState();
//						this.accessSequences.put(newState, currSequence);
//						if (currentElement.parentElement != null) {
//		                    hypothesis.addTransition(currentElement.parentState, newState, currentElement.input, currentElement.output);
//		                }
//					} else {
//						newState = currentElement.state.get();
//					}
//	                signatures.put(currSignature, newState);
//	                /*if(signatures.values().contains(newState)) {
//	                	signature.
//	                }*/
//	                System.out.println("comm: " + currCommand);
//	                if(!currCommand.equals(AdaptionCommand.PESSIMISTIC)) {
//	                	for(I symbol : hypothesis.getHypothesisInputAlphabet()) {
//	                    	statesToComplete.add(new QueueElement<I, O, State>(newState, currentElement, symbol, currAlphabetSignature.get(symbol).get(), Optional.empty()));
//	                    }
//	                }
//				}
//			}
//		}
//		return hypothesis;
//	}
	
	/*
	 * returns a state with a signature strictly identical to the one given
	 * (so each optional value must be present and the same) 
	 */
	protected State findStateWithSameSignature(Map<List<Optional<O>>, State> prevSignature, List<Optional<O>> currSignature) {
		for(List<Optional<O>> sign : prevSignature.keySet()) {
			boolean identical = true;
			for(int i = 0; i < sign.size(); i++) {	//sizes should be equal at this point
				if(!(sign.get(i).isPresent() && currSignature.get(i).isPresent() && sign.get(i).equals(currSignature.get(i)))) {
					identical = false;
				}
			}
			if(identical) {
				return prevSignature.get(sign);
			}
		}
		return null;
	}
	
	/*
	 * returns a state with a signature similar to the one given
	 * (so each present value of the given signature must be present and identical) 
	 */
	protected State findStateWithSimilarSignature(Map<List<Optional<O>>, State> prevSignature, List<Optional<O>> currSignature) {
		for(List<Optional<O>> sign : prevSignature.keySet()) {
			boolean identical = true;
			for(int i = 0; i < sign.size(); i++) {	//sizes should be equal at this point
				if(!((!currSignature.get(i).isPresent()) ||
					(currSignature.get(i).isPresent() && sign.get(i).isPresent() && currSignature.get(i).equals(sign.get(i))))) {
					identical = false;
				}
			}
			if(identical) {
				return prevSignature.get(sign);
			}
		}
		return null;
	}
	
	protected List<I> getAccessSequence(QueueElement<I, O, State> currElement) {
		List<I> word = new ArrayList<>();

        QueueElement<I, O, State> parent = currElement.parentElement;
        I in = currElement.input;
        while (parent != null && in != null) {
            word.add(in);
            in = parent.input;
            parent = parent.parentElement;
        }

        Collections.reverse(word);
        return word;
	}
	
	protected LinkedHashMap<I, Optional<O>> findAlphabetOutputSignature(List<I> accessSequence){
		LinkedHashMap<I, Optional<O>> currSignature = new LinkedHashMap<>();
		for(I symbol : this.inputAlphabet) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.add(symbol);
			
			Optional<O> outputSymbol = Optional.of(teacher.membershipQuery(currSequenceWithSymbol));
			
			currCommand = ((AdaptiveTeacher)this.teacher).getCommand();
			if(currCommand.equals(AdaptionCommand.RESET)) break;
			
			currSignature.put(symbol, outputSymbol);
		}
		return currSignature;
	}
	
	// adds elements to the splitters
	public void refineHypothesis(List<? extends I> counterExample) {
		for(int i = 0; i < counterExample.size(); i++) {
			List<? extends I> currSuffix = counterExample.subList(1+i, counterExample.size());
			if(currSuffix.size() != 0 /*&& currSuffix.size() != 1*/ && !splitters.stream().anyMatch(l -> l.equals(currSuffix))) {
				this.splitters.add(new ArrayList<>(currSuffix));
			}
		}
	}
	
	
	protected List<Optional<O>> findSplitterOutputSignature(List<I> accessSequence){
		List<Optional<O>> retVal = new ArrayList<>();
		for(List<? extends I> splitter : this.splitters) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.addAll(splitter);
			
			Optional<O> outputSymbol = Optional.of(teacher.membershipQuery(currSequenceWithSymbol));
			
			currCommand = ((AdaptiveTeacher)this.teacher).getCommand();
			if(currCommand.equals(AdaptionCommand.RESET)) break;
			
			retVal.add(outputSymbol);
		}
		return retVal;
	}
	
	
	public static final class QueueElement<I, O, S> implements Serializable {

        final S parentState;
        final QueueElement<I, O, S> parentElement;
        final I input;
        final O output;
        final int depth;
        Optional<S> state;

        public QueueElement(S parentState, QueueElement<I, O, S> parentElement, I input, O output, Optional<S> state) {
            this.parentState = parentState;
            this.parentElement = parentElement;
            this.input = input;
            this.output = output;
            this.depth = (parentElement != null) ? parentElement.depth + 1 : 0;
            this.state = state;
        }
        
        public void setState(S state) {
        	this.state = Optional.of(state);
        }
        
        @Override
        public String toString() {
        	return "State: " + (state.isPresent() ? state.get().toString() : "unknown") + 
        			"\n ->Parent State: " + (parentState != null ? parentState.toString() : "null") + 
        			"\n ->Input: " + (input != null ? input.toString() : "null");
        }
	}
	
	public static final class Node <I,O> {
		final String stateName;
		final Node<I,O> parent;
		final I parentAccessI;
		final O parentAccessO;
		
		final List<Node<I,O>> children = new ArrayList<>();
		final List<I> childrenI = new ArrayList<>();
		
		public Node(String s, Node<I,O> parent, I parentAccessI, O parentAccessO) {
			this.stateName = s;
			this.parent = parent;
			this.parentAccessI = parentAccessI;
			this.parentAccessO = parentAccessO;
		}
		public void addChild(Node<I,O> n, I in) {
			this.children.add(n);
			this.childrenI.add(in);
		}
		public List<I> getAccess(){
			List<I> toReturn = new ArrayList<>();
			if(parent != null) {
				toReturn.addAll(parent.getAccess());
				toReturn.add(parentAccessI);
			}
			return toReturn;
		}
		public List<Node<I,O>> preorder() {
			List<Node<I,O>> ret = new ArrayList<>();
			ret.add(this);
			for(Node<I,O> child : children)  {
				ret.addAll(child.preorder());
			}
			return ret;
		}
	}

}
