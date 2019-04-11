package hu.bme.mit.mealeymodel.dhc.general.impl;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.mealeymodel.Transition;
import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.dhc.general.Hypothesis;

public class MealeyMachineHypothesis extends Hypothesis<Alphabet, Alphabet, MealeyMachine, State, Transition>{
	
	public MealeyMachineHypothesis(Alphabet inputAlphabet, Alphabet outputAlphabet, State initialState, List<State> states, List<Transition> transitions) {
		this.automaton = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		automaton.setInitialState(initialState);
		automaton.setInputAlphabet(inputAlphabet);
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

	public List<Alphabet> getAccessSequence(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Transition> getTransitions() {
		return automaton.getTransitions();
	}


	
}
