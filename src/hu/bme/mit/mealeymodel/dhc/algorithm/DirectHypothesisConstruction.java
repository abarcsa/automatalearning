package hu.bme.mit.mealeymodel.dhc.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;
import hu.bme.mit.mealeymodel.dhc.teacher.Teacher;
import hu.bme.mit.mealeymodel.Transition;

public class DirectHypothesisConstruction {
	Teacher<String, String, MealeyMachineHypothesis> teacher;
	MealeyMachineHypothesis hypothesis;
	
	public DirectHypothesisConstruction(Teacher<String, String, MealeyMachineHypothesis> teacher, MealeyMachineHypothesis hypothesis) {
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
	
	
	public static void test() {
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
		MealeyMachineHypothesis hy = new MealeyMachineHypothesis(in, out, s1, s, trans);
		hy.rerouteAllTransitions(s5, s3);
		System.out.println();
	}
	

	

}
