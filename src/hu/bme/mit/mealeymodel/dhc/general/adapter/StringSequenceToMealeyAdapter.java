package hu.bme.mit.mealeymodel.dhc.general.adapter;

import hu.bme.mit.mealeymodel.dhc.general.hypothesis.MealeyMachineHypothesis;

public class StringSequenceToMealeyAdapter extends StringSequenceAdapter<String, String, MealeyMachineHypothesis>{

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
