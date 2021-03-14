package hu.bme.mit.automatalearning.Learnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IOPairModel implements PartialModel<String, String> {
	
	private List<? extends String> inputAlphabet;
	private List<String> outputAlphabet;
	
	private List<? extends String> inputSequence;
	private String output;
	
	public IOPairModel(List<? extends String> inputAlphabet, List<String> outputAlphabet, List<? extends String> inputSequence, String output) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
		
		this.inputSequence = inputSequence;
		this.output = output;
	}

	@Override
	public Set<String> getPossibleOutputs(List<? extends String> inputSequence) {
		Set<String> possibleOutputs = new HashSet<>();
		
		// If the input sequences match, return output, otherwise no information
		if (this.inputSequence.equals(inputSequence)) {
			possibleOutputs.add(output);
		} else {
			possibleOutputs.addAll(outputAlphabet);
		}
		
		return possibleOutputs;
	}

	@Override
	public List<? extends String> getInputAlphabet() {
		return this.inputAlphabet;
	}


	@Override
	public List<String> getOutputAlphabet() {
		return this.outputAlphabet;
	}

	@Override
	public boolean isProximityContained(List<? extends String> inputs) {
		return false;
	}
	
	@Override
	public String toString() {
		return "IO Pair Model: " + this.inputSequence + "/" + this.output;
	}

}
