package hu.bme.mit.mealeymodel.dhc.adapter;

import hu.bme.mit.mealeymodel.dhc.Learnable.StringSequenceLearnable;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;

public class StringSequenceToMealeyAdapter extends StringSequenceAdapter<String, String, MealeyMachineHypothesis>{

	public StringSequenceToMealeyAdapter(StringSequenceLearnable learnable) {
		this.learnable = learnable;
	}
	
	@Override
	public String convertLearnableInput(String input) {
		return input;
	}

	@Override
	public String convertHypothesisInput(String input) {
		return input;
	}

	@Override
	public String convertLearnableOutput(String output) {
		return output;
	}

	@Override
	public String convertHypothesisOutput(String output) {
		return output;
	}



	


}
