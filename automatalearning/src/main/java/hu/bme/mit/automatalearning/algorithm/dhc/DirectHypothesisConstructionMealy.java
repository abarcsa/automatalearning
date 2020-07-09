package hu.bme.mit.automatalearning.algorithm.dhc;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
public class DirectHypothesisConstructionMealy<I, O, M, S, T> extends ActiveLearningAlgorithm<I, O, DHCHypothesis<I, O, M, S, T>>{
	Collection<? extends I> alphabet;
	List<List<? extends I>> splitters;
	DHCHypothesis<I, O, M, S, T> hypothesis;
	
	public DirectHypothesisConstructionMealy(Teacher<I, O, DHCHypothesis<I, O, M, S, T>, ?> teacher, Collection<? extends I> alphabet, DHCHypothesis<I, O, M, S, T> hypothesis) {
		this.teacher = teacher;
		this.alphabet = alphabet;
		this.splitters = new ArrayList<>();
		this.hypothesis = hypothesis;
	}
	
	public DHCHypothesis<I, O, M, S, T> execute() {
		List<? extends I> counterExample = null;
		DHCHypothesis<I, O, M, S, T> h = null;
		do {
			if(counterExample != null) {
				refineHypothesis(counterExample);
			}
			h = constructHypothesis();
			Utils.logHypothesisToJSON((Hypothesis<String, String, MealyMachine, State, Transition>) h, "DHC");
			counterExample = teacher.equivalenceQuery(h, alphabet);
		}while(counterExample != null);
		
		return h;
	}
	
	public DHCHypothesis<I, O, M, S, T> constructHypothesis() {
		hypothesis.resetHypothesis();
		ArrayDeque<QueueElement<I, O, S>> statesToComplete = new ArrayDeque<>();
		statesToComplete.add(new QueueElement<I, O, S>(null, null, null, null));
		Map<List<O>, S> signatures = new HashMap<>();
		
		while(!statesToComplete.isEmpty()) {
			QueueElement<I, O, S> currentElement = statesToComplete.pop();
			
			List<I> currSequence = getAccessSequence(currentElement);
			
			LinkedHashMap<I, O> currAlphabetSignature = findAlphabetOutputSignature(currSequence);
			List<O> currSignature = new ArrayList<>(currAlphabetSignature.values());
			currSignature.addAll(findSplitterOutputSignature(currSequence));
			
			S sibling = findStateWithSameSignature(signatures, currSignature);
			
			if(sibling != null) {	//If a sibling exists, merge currState to sibling
				hypothesis.addTransition(currentElement.parentState, sibling, currentElement.input, currentElement.output);
			}else {	//If there are no siblings, the targetState of all transitions going from currentState is set to a new state
				S newState = currentElement.parentElement == null ? hypothesis.addInitialState() : hypothesis.createNewState();
                if (currentElement.parentElement != null) {
                    hypothesis.addTransition(currentElement.parentState, newState, currentElement.input, currentElement.output);
                }
                signatures.put(currSignature, newState);

                for(I symbol : hypothesis.getHypothesisInputAlphabet()) {
                	statesToComplete.add(new QueueElement<I, O, S>(newState, currentElement, symbol, currAlphabetSignature.get(symbol)));
                }
			}
		}
		return hypothesis;
	}
	
	private LinkedHashMap<I, O> findAlphabetOutputSignature(List<I> accessSequence){
		LinkedHashMap<I, O> currSignature = new LinkedHashMap<>();
		for(I symbol : this.alphabet) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.add(symbol);
			
			O outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			currSignature.put(symbol, outputSymbol);
		}
		return currSignature;
	}
	
	private List<O> findSplitterOutputSignature(List<I> accessSequence){
		List<O> retVal = new ArrayList<>();
		for(List<? extends I> splitter : this.splitters) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.addAll(splitter);
			
			O outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			retVal.add(outputSymbol);
		}
		return retVal;
	}
	
	private S findStateWithSameSignature(Map<List<O>, S> prevSignature, List<O> currSignature) {
		Optional<List<O>> exists = prevSignature.keySet().stream().filter(list -> list.equals(currSignature)).findFirst();
		if(exists.isPresent()) {
			return prevSignature.get(exists.get());
		}
		return null;
	}
	
	private List<I> getAccessSequence(QueueElement<I, O, S> currElement) {
		List<I> word = new ArrayList<>();

        QueueElement<I, O, S> parent = currElement.parentElement;
        I in = currElement.input;
        while (parent != null && in != null) {
            word.add(in);
            in = parent.input;
            parent = parent.parentElement;
        }

        Collections.reverse(word);
        return word;
	}
	public void refineHypothesis(List<? extends I> counterExample) {
		for(int i = 0; i < counterExample.size(); i++) {
			List<? extends I> currSuffix = counterExample.subList(1+i, counterExample.size());
			if(currSuffix.size() != 0 && currSuffix.size() != 1 && !splitters.stream().anyMatch(l -> l.equals(currSuffix))) {
				this.splitters.add(new ArrayList<>(currSuffix));
			}
		}
		
	}

	
	/*public static void test() {
		Alphabet in = MealeymodelFactory.eINSTANCE.createAlphabet();
		in.getCharacters().add("I1");
		in.getCharacters().add("I2");
		Alphabet out = MealeymodelFactory.eINSTANCE.createAlphabet();
		out.getCharacters().add("O1");
		out.getCharacters().add("O2");
		List<State> s = new ArrayList<>();
		State s1 = MealeymodelFactory.eINSTANCE.createState();
		State s2 = MealeymodelFactory.eINSTANCE.createState();
		State s3 = MealeymodelFactory.eINSTANCE.createState();
		State s4 = MealeymodelFactory.eINSTANCE.createState();
		State s5 = MealeymodelFactory.eINSTANCE.createState();
		s1.setName("state 1");
		s2.setName("state 2");
		s3.setName("state 3");
		s4.setName("state 4");
		s5.setName("state 5");
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
		hu.bme.mit.mealeymodel.Transition t1 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t2 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t3 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t4 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t5 = MealeymodelFactory.eINSTANCE.createTransition();
		t1.setInput("I1");
		t2.setInput("I2");
		t3.setInput("I3");
		t4.setInput("I4");
		t5.setInput("I3");
		t1.setOutput("O1");
		t2.setOutput("O1");
		t3.setOutput("O1");
		t4.setOutput("O2");
		t5.setOutput("O1");
		t1.setSourceState(s1);
		t2.setSourceState(s2);
		t3.setSourceState(s3);
		t4.setSourceState(s2);
		t5.setSourceState(s5);
		t1.setTargetState(s2);
		t2.setTargetState(s3);
		t3.setTargetState(s4);
		t4.setTargetState(s5);
		List<hu.bme.mit.mealeymodel.Transition> trans = new ArrayList<>();
		trans.add(t1);
		trans.add(t2);
		trans.add(t3);
		trans.add(t4);
		trans.add(t5);
		DHCHypothesisMealy hy = new DHCHypothesisMealy(in, out, s1, s, trans);
		hy.rerouteAllTransitions(s5, s3);
		System.out.println();
	}*/
	
	//Great idea of Queue handling from the LearnLib framework
	 static final class QueueElement<I, O, S> implements Serializable {

	        private final S parentState;
	        private final QueueElement<I, O, S> parentElement;
	        private final I input;
	        private final O output;
	        private final int depth;

	        QueueElement(S parentState, QueueElement<I, O, S> parentElement, I input, O output) {
	            this.parentState = parentState;
	            this.parentElement = parentElement;
	            this.input = input;
	            this.output = output;
	            this.depth = (parentElement != null) ? parentElement.depth + 1 : 0;
	        }
	 }

}
