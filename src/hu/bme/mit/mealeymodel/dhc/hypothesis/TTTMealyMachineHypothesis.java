package hu.bme.mit.mealeymodel.dhc.hypothesis;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.Transition;

public class TTTMealyMachineHypothesis extends Hypothesis<String, String, MealeyMachine, State, Transition>{
	
	int nameNum = 0;
	
	public TTTMealyMachineHypothesis(Alphabet inputAlphabet) {
		this.automaton = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		
		State initialState = MealeymodelFactory.eINSTANCE.createState();
		State initialState2 = MealeymodelFactory.eINSTANCE.createState();
		initialState.setName("state" + nameNum);
		initialState2.setName("state" + nameNum++);
		automaton.setInitialState(initialState);
		automaton.getStates().add(initialState2);
				
		automaton.setInputAlphabet(inputAlphabet);
		Alphabet outputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		automaton.setOutputAlphabet(outputAlphabet);
	}
	
	public TTTMealyMachineHypothesis(Alphabet inputAlphabet, Alphabet outputAlphabet, State initialState, List<State> states, List<Transition> transitions) {
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
	
	@Override
	public Collection<String> getInputAlphabet() {
		return automaton.getInputAlphabet().getCharacters();
	}

	@Override
	public Collection<String> getOutputAlphabet() {
		return automaton.getOutputAlphabet().getCharacters();
	}
	
	public Transition getTransition(String state, String input) {
		for(Transition t : automaton.getTransitions()) {
			if(t.getSourceState().getName().equals(input)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public String query(List<String> inputs) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
