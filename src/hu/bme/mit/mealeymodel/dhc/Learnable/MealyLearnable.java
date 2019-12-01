package hu.bme.mit.mealeymodel.dhc.Learnable;

import java.util.List;

import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.Transition;

public class MealyLearnable extends StringSequenceLearnable{
	
	MealeyMachine automaton;
	
	public MealyLearnable(MealeyMachine automaton) {
		this.automaton = automaton;
	}
	
	@Override
	public String getOutput(List<? extends String> inputs) {
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
		return output;
	}

}
