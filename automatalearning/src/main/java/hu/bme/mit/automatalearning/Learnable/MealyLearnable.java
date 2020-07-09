package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class MealyLearnable extends StringSequenceLearnable{
	
	public MealyMachine automaton;
	
	public MealyLearnable(MealyMachine automaton) {
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
					if(currState == null) return output;
					continue outer;
				}
			}
		}
		return output;
	}

}
