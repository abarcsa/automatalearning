package hu.bme.mit.automatalearning.adapter;

import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;

public class StringSequenceToTTTMealyAdapter extends StringSequenceAdapter<String, String, TTTHypothesisMealyEMF>{
	
	public StringSequenceToTTTMealyAdapter(StringSequenceLearnable learnable) {
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
