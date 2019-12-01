package hu.bme.mit.mealeymodel.dhc.algorithm.TTT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;
import hu.bme.mit.mealeymodel.dhc.teacher.Teacher;

public class TTT {
	Teacher<String, String, MealeyMachineHypothesis> teacher;
	MealeyMachineHypothesis hypothesis;
	
	public TTT(Teacher<String, String, MealeyMachineHypothesis> teacher, MealeyMachineHypothesis hypothesis) {
		this.teacher = teacher;
		this.hypothesis = hypothesis;
	}
	
	public MealeyMachineHypothesis execute() {
		boolean done = false;
		MealeyMachineHypothesis hypothesis = null;
		do {
			hypothesis = createNewHypothesis();
			done = true;
			/*List<? extends String> counterExample = teacher.equivalenceQuery(hypothesis, hypothesis.getInputAlphabet());
			if(counterExample == null || counterExample.size() == 0) {
				done = true;
			}else {
				
			}*/
		}while(!done);
		return hypothesis;
	}
	/**
	 * Main algorithm
	 * @return The constructed hypothesis
	 */
	private MealeyMachineHypothesis createNewHypothesis() {
		ArrayDeque<State> statesToComplete = new ArrayDeque<State>();
		Set<State> completedStates = new HashSet<>();
		statesToComplete.add(hypothesis.getInitialState());
		
		while(!statesToComplete.isEmpty()) {
			State currentState = statesToComplete.pop();
			List<String> currSequence = hypothesis.getAccessSequence(currentState);
			
			for(String symbol : hypothesis.getInputAlphabet()) {
				List<String> currSequenceWithSymbol = new ArrayList<>(currSequence);
				currSequenceWithSymbol.add(symbol);
				
				String outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
				
				if(outputSymbol != null) {
					hypothesis.setTransitionOutput(currentState, symbol, outputSymbol);
				}
			}
			
			State sibling = hypothesis.findStateWithSameSignature(currentState);
			if(sibling != null) {	//If a sibling exists, merge currState to sibling
				hypothesis.rerouteAllTransitions(currentState, sibling);
				hypothesis.getStates().remove(currentState);
			}else {	//If there are no siblings, the targetState of all transitions going from currentState is set to a new state
				completedStates.add(currentState); //This state is marked completed
				List<State> newStates = hypothesis.createSuccessorsForEveryTransition(currentState);
				for(State newState : newStates) {
					statesToComplete.add(newState);
				}
			}
		}
		return hypothesis;
	}
	
	
}
