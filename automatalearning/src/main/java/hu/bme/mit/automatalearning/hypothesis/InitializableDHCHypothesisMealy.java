package hu.bme.mit.automatalearning.hypothesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class InitializableDHCHypothesisMealy extends DHCHypothesis<String, String, MealyMachine, State, Transition>{
	
	private int nameNum;
	
	private Alphabet iInputAlphabet;
	private Alphabet iOutputAlphabet;
	private State iInitialState;
	private List<State> iStates;
	private List<Transition> iTransitions;
	
	public InitializableDHCHypothesisMealy(Alphabet inputAlphabet) {
		//
		nameNum = 1;
		iInputAlphabet = inputAlphabet;
		iOutputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		iInitialState = MealymodelFactory.eINSTANCE.createState();
		iInitialState.setName("state0");
		iStates = new ArrayList<>();
		iStates.add(iInitialState);
		iTransitions = new ArrayList<>();
		//
		
		init(inputAlphabet);
	}
	
	public InitializableDHCHypothesisMealy(Collection<? extends String> inputAlphabet) {
		//
		nameNum = 1;
		iInputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		iInputAlphabet.getCharacters().addAll(inputAlphabet);
		iOutputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		iInitialState = MealymodelFactory.eINSTANCE.createState();
		iInitialState.setName("state0");
		iStates = new ArrayList<>();
		iStates.add(iInitialState);
		iTransitions = new ArrayList<>();
		//
		
		
		this.automaton = MealymodelFactory.eINSTANCE.createMealyMachine();
		Alphabet a = MealymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(inputAlphabet);
		automaton.setInputAlphabet(a);
		Alphabet outputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		automaton.setOutputAlphabet(outputAlphabet);
	}
	

	public InitializableDHCHypothesisMealy(Alphabet inputAlphabet, Alphabet outputAlphabet, State initialState, List<State> states, List<Transition> transitions) {
		//
		nameNum = states.size();
		iInputAlphabet = inputAlphabet;
		iOutputAlphabet = outputAlphabet;
		iInitialState = initialState;
		iStates = states;
		iTransitions = transitions;
		//
		
		this.automaton = MealymodelFactory.eINSTANCE.createMealyMachine();
		
		Alphabet a = MealymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(inputAlphabet.getCharacters());
		automaton.setInputAlphabet(a);
		automaton.setOutputAlphabet(outputAlphabet);
		
		State initialState2 = MealymodelFactory.eINSTANCE.createState();
		initialState2.setName(initialState.getName());
		automaton.setInitialState(initialState2);
		
		for (State s : states) {
			automaton.getStates().add(s);
		}
		for (Transition t : transitions) {
			automaton.getTransitions().add(t);
		}
	}
	
	@Override
	public State addInitialState() {
		State initialState = iInitialState;
		//Needed because of the unique feature of EMF
		State initialState2 = MealymodelFactory.eINSTANCE.createState();
		//initialState.setName("state" + nameNum);
		initialState2.setName(initialState.getName());
		automaton.setInitialState(initialState);
		automaton.getStates().add(initialState2);
		return initialState;
	}
	
	@Override
	public State createNewState() {
		State newState = MealymodelFactory.eINSTANCE.createState();
		newState.setName("state" + nameNum++);
		this.automaton.getStates().add(newState);
		return newState;
	}

	@Override
	public State getInitialState() {
		return automaton.getInitialState();
	}

	@Override
	public Collection<State> getHypothesisStates() {
		return automaton.getStates();
	}

	@Override
	public Collection<Transition> getHypothesisTransitions() {
		return automaton.getTransitions();
	}
	
	public void setTransitionOutput(State from, String inputSymbol, String outputSymbol) {
		Transition t = MealymodelFactory.eINSTANCE.createTransition();
		t.setSourceState(from);
		t.setOutput(outputSymbol);
		t.setInput(inputSymbol);
		automaton.getTransitions().add(t);
	}
	
	public void addTransition(State from, State to, String inputSymbol, String outputSymbol) {
		Transition t = MealymodelFactory.eINSTANCE.createTransition();
		t.setSourceState(from);
		t.setTargetState(to);
		t.setOutput(outputSymbol);
		t.setInput(inputSymbol);
		automaton.getTransitions().add(t);
	}
	/**
	 * Uses BFS (could be optimized with Dijkstra) to determine the input sequence to access a state from the initial state
	 * @param s The state which access sequence is needed
	 * @return The access sequence
	 */
	public List<String> getAccessSequence(State s){
		
		final class StateInputPair{
			String state;	//The parent states name
			String input;	//The input from the parent state
			public StateInputPair(String state, String input) {
				this.state = state;
				this.input = input;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((input == null) ? 0 : input.hashCode());
				result = prime * result + ((state == null) ? 0 : state.hashCode());
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if(!(obj instanceof StateInputPair)) {
					return false;
				}
				return ((StateInputPair) obj).state.equals(this.state)
						&& ((StateInputPair) obj).input.equals(this.input);
			}
			
			
		}
		
		Map<String, StateInputPair> stateParentMapping = new HashMap<>();
		ArrayDeque<State> states = new ArrayDeque<>();
		states.add(this.getInitialState());
		List<String> discoveredStates = new ArrayList<>();	//This way the algorithm won't get stuck in a cycle, if the graph has any
		//Flag to see if the BFS was successful
		boolean found = false;
		
		while(!states.isEmpty()) {
			State currState = states.poll();
			
			if(currState.getName().equals(s.getName())) {
				found = true;
				break;
			}
			
			for(Transition t : automaton.getTransitions()) {
				if(t.getTargetState() != null  //If the transition is already fully discovered
						&& t.getSourceState().getName().equals(currState.getName()) 	//And the source of it is the currState
						&& !discoveredStates.contains(t.getTargetState().getName())) {	//And the target state is not yet discovered
					stateParentMapping.put(t.getTargetState().getName(), new StateInputPair(currState.getName(), t.getInput()));
					states.add(t.getTargetState());
					discoveredStates.add(t.getTargetState().getName());
				}
			}

		}
		if(!found) return null;
		
		//Backtrace the path and get the inputs to return
		List<String> returnList = new ArrayList<>();
		String currStateName = s.getName(); //Start from the found end state
		
		while(!currStateName.equals(this.getInitialState().getName())) {	//Backtrace until the initial state
			StateInputPair parent = stateParentMapping.get(currStateName);
			returnList.add(parent.input);
			currStateName = parent.state;
		}
		
		Collections.reverse(returnList);	//So the list is from start state to end state
		
		return returnList;
	}
	


	@Override
	public Collection<String> getHypothesisInputAlphabet() {
		return automaton.getInputAlphabet().getCharacters();
	}

	@Override
	public Collection<String> getHypothesisOutputAlphabet() {
		return automaton.getOutputAlphabet().getCharacters();
	}

	/**
	 * Tries to find a State other than the given parameter which has the same output signature so the param. state can be merged into it
	 * @param state	The State which output signature should be compared to all the other states' output signatures
	 * @return	A sibling state with identical output signature to the given state. If none found, then null.
	 */
	public State findStateWithSameSignature(State state) {
		Set<State> possibleSiblings = new HashSet<>();
		Set<State> possibleBackroutings = new HashSet<>(); //parents' parents - there may be a backrouting between the states parents and its parents' parents
		List<Transition> outputTransitionsOfState = new ArrayList<>();
		
		//Find possible siblings and all transitions of the given state - both in one loop for optimization
		for(Transition transition : automaton.getTransitions()) {
			if(transition.getTargetState() != null 
					&& transition.getTargetState().getName().equals(state.getName())) {	//Parents of state
				State parent = transition.getSourceState();
				possibleSiblings.add(parent);	//state can be merged into one of its parents
				//state can be merged into one of its parents' other states
				possibleSiblings.addAll(automaton.getTransitions().stream().filter(t -> t.getSourceState().getName().equals(parent.getName())
																							   && t.getTargetState() != null 
																							   && !t.getTargetState().getName().equals(state.getName()))
																		   .map(t -> t.getTargetState())
																		   .collect(Collectors.toSet()));
				//state can be merged into one of its parents' parents
				possibleBackroutings.addAll(automaton.getTransitions().stream().filter(t -> t.getTargetState() != null
																						&& t.getTargetState().getName().equals(parent.getName())
																						&& !possibleSiblings.contains(t.getSourceState()))
																		   .map(t -> t.getSourceState()).collect(Collectors.toSet()));
				possibleSiblings.addAll(possibleBackroutings);
			}
			if(transition.getSourceState().getName().equals(state.getName())) {
				outputTransitionsOfState.add(transition);
			}
		}
		//Compare the output signatures of the possible siblings
	    siblingLoop: for(State possibleSibling : possibleSiblings) {
	    	int matchedNum = 0;	//if == transitionNum, sibling was found
			for(Transition t : automaton.getTransitions()) {
				if(t.getSourceState().getName().equals(possibleSibling.getName())) {	//If the transition starts from the sibling state
					boolean match = false;
					for(Transition outputTransition : outputTransitionsOfState) {
						if(outputTransition.getInput().equals(t.getInput())
								&& outputTransition.getOutput().equals(t.getOutput())) {
							match = true;
							matchedNum++;
						}
					}
					//If none of the output signatures were the same, they have a diverging transition, not siblings
					if(!match) continue siblingLoop;
				}
			}
			//if no diverging transitions were found (all the transitions matched exactly), possibleSibling is a sibling
			if(matchedNum != 0 && matchedNum == outputTransitionsOfState.size()) {
				if(possibleBackroutings.contains(possibleSibling)) {//if backrouting
					isBackrouting = true;
				}
				return possibleSibling;
			}
		}
		return null;
	}
	private boolean isBackrouting = false;
	public void rerouteAllTransitions(State from, State to) {
		Iterator<Transition> i = automaton.getTransitions().iterator();
		while(i.hasNext()) {
			Transition t = i.next();
			if(t.getSourceState().getName().equals(from.getName())) {
				//Transitions starting from the "from" state are no longer needed - since the sibling already has the exact same transitions
				i.remove();
			}
			if(t.getTargetState() != null && t.getTargetState().getName().equals(from.getName())) {	
				//Parents of from are rerouted
				t.setTargetState(to);
			}
		}
		if(isBackrouting) {
			isBackrouting = false;
		}else {
			automaton.getStates().remove(from);
		}
	}
	
	public List<State> createSuccessorsForEveryTransition(State from){
		List<State> newStates = new ArrayList<>();
		for(Transition t : automaton.getTransitions()){
			if(t.getSourceState().getName().equals(from.getName())) {
				State newState = MealymodelFactory.eINSTANCE.createState();;
				newState.setName("state" + nameNum++);
				t.setTargetState(newState);
				this.automaton.getStates().add(newState);
				newStates.add(newState);
			}
		}
		return newStates;
	}
	
	public MealyMachine getAutomaton() {
		return this.automaton;
	}

	@Override
	public String query(List<? extends String> inputs) {
		//Since query answering is already implemented in MealyLearnable, it is delegated there.
		return new MealyLearnable(this.automaton).getOutput(inputs);
	}
	
	public State queryState(List<? extends String> inputs) {
		State currState = automaton.getInitialState();
		String output = null;
		outer: for(String input : inputs) {
			for(Transition t : automaton.getTransitions()) {
				if(t.getSourceState().getName().equals(currState.getName())
											&& t.getInput().equals(input)) {
					currState = t.getTargetState();
					output = t.getOutput();
					continue outer;
				}
			}
		}
		return currState;
	}

	@Override
	public void resetHypothesis() {
		this.nameNum = iStates.size();
		this.automaton = null;
		init(null);
		
	}
	private void init(Alphabet a) {		
		this.automaton = MealymodelFactory.eINSTANCE.createMealyMachine();

		Alphabet ab = MealymodelFactory.eINSTANCE.createAlphabet();
		ab.getCharacters().addAll(iInputAlphabet.getCharacters());
		automaton.setInputAlphabet(ab);
		automaton.setInputAlphabet(iInputAlphabet);
		automaton.setOutputAlphabet(iOutputAlphabet);
		
		State initialState2 = MealymodelFactory.eINSTANCE.createState();
		initialState2.setName(iInitialState.getName());
		automaton.setInitialState(initialState2);
		
		for (State s : iStates) {
			automaton.getStates().add(s);
		}
		for (Transition t : iTransitions) {
			automaton.getTransitions().add(t);
		}
	}


	@Override
	public MealyMachine getHypothesisAutomaton() {
		return this.automaton;
	}

	// should only be called on complete automata!
	@Override
	public MealyMachine getHypothesis() {
		Set<String> inputA = new HashSet<>();
		Set<String> outputA = new HashSet<>();
		for(Transition t : this.automaton.getTransitions()) {
			inputA.add(t.getInput());
			outputA.add(t.getOutput());
		}
		Alphabet in = MealymodelFactory.eINSTANCE.createAlphabet();
		Alphabet out = MealymodelFactory.eINSTANCE.createAlphabet();
		in.getCharacters().addAll(inputA);
		out.getCharacters().addAll(outputA);
		this.automaton.setInputAlphabet(in);
		this.automaton.setOutputAlphabet(out);
		return this.automaton;
	}

	@Override
	public void removeTransition(Transition transition) {
		this.automaton.getTransitions().remove(transition);
	}
	
	
}
