package hu.bme.mit.mealeymodel.dhc.hypothesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import hu.bme.mit.mealeymodel.Transition;
import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;

public class MealeyMachineHypothesis extends Hypothesis<String, String, MealeyMachine, State, Transition>{
	
	Map<String, List<String>> accessSequences = new HashMap<>();
	int nameNum = 0;
	public MealeyMachineHypothesis(Alphabet inputAlphabet, Alphabet outputAlphabet) {
		this.automaton = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		
		State initialState = MealeymodelFactory.eINSTANCE.createState();
		State initialState2 = MealeymodelFactory.eINSTANCE.createState();
		initialState.setName("state" + nameNum);
		initialState2.setName("state" + nameNum++);
		automaton.setInitialState(initialState);
		automaton.getStates().add(initialState);
		
		this.accessSequences.put(initialState.getName(), new ArrayList<String>());
		
		automaton.setInputAlphabet(inputAlphabet);
		automaton.setOutputAlphabet(outputAlphabet);
	}

	public MealeyMachineHypothesis(Alphabet inputAlphabet, Alphabet outputAlphabet, State initialState, List<State> states, List<Transition> transitions) {
		this.automaton = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		
		automaton.setInputAlphabet(inputAlphabet);
		automaton.setOutputAlphabet(outputAlphabet);
		
		State initialState2 = MealeymodelFactory.eINSTANCE.createState();
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
	public State getInitialState() {
		return automaton.getInitialState();
	}

	@Override
	public Collection<State> getStates() {
		return automaton.getStates();
	}

	@Override
	public Collection<Transition> getTransitions() {
		return automaton.getTransitions();
	}
	
	public void setTransitionOutput(State from, String outputSymbol) {
		Transition t = MealeymodelFactory.eINSTANCE.createTransition();
		t.setSourceState(from);
		t.setOutput(outputSymbol);
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
	public Collection<String> getInputAlphabet() {
		return automaton.getInputAlphabet().getCharacters();
	}

	@Override
	public Collection<String> getOutputAlphabet() {
		return automaton.getOutputAlphabet().getCharacters();
	}

	/**
	 * Tries to find a State other than the given parameter which has the same output signature so the param. state can be merged into it
	 * @param state	The State which output signature should be compared to all the other states' output signatures
	 * @return	A sibling state with identical output signature to the given state. If none found, then null.
	 */
	public State findStateWithSameSignature(State state) {
		List<State> possibleSiblings = new ArrayList<>();
		List<Transition> outputTransitionsOfState = new ArrayList<>();
		
		//Find possible siblings and all transitions of the given state - both in one loop for optimization
		for(Transition transition : automaton.getTransitions()) {
			if(transition.getTargetState() != null 
					&& transition.getTargetState().getName().equals(state.getName())) {	//Parents of state
				State parent = transition.getSourceState();
				//Find all successors of parent which aren't the given state
				possibleSiblings.addAll(automaton.getTransitions().stream().filter(t -> t.getSourceState().getName().equals(parent.getName())
																							   && !t.getTargetState().getName().equals(state.getName())).map(t -> t.getTargetState()).collect(Collectors.toList()));
			}
			if(transition.getSourceState().getName().equals(state.getName())) {
				outputTransitionsOfState.add(transition);
			}
		}
		//Compare the output signatures of the possible siblings
	    siblingLoop: for(State possibleSibling : possibleSiblings) {
			for(Transition t : automaton.getTransitions()) {
				if(t.getSourceState().getName().equals(possibleSibling.getName())) {	//If the transition starts from the sibling state
					for(Transition outputTransition : outputTransitionsOfState) {
						if(!outputTransition.getInput().equals(t.getInput())
								|| !outputTransition.getOutput().equals(t.getOutput())) {
							//If any output signature of the possible sibling is not equal to the states, it is not a sibling
							continue siblingLoop;
						}
					}
					//If all the transitions of the outputTransition had the same signature, a sibling was found
					return possibleSibling;
				}
			}
		}
		return null;
	}
	
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
	}
	
	public List<State> createSuccessorsForEveryTransition(State from){
		List<State> newStates = new ArrayList<>();
		for(Transition t : automaton.getTransitions()){
			if(t.getSourceState().getName().equals(from.getName())) {
				State newState = MealeymodelFactory.eINSTANCE.createState();;
				newState.setName("state" + nameNum);
				t.setTargetState(newState);
				newStates.add(newState);
			}
		}
		return newStates;
	}
}
