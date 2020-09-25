package hu.bme.mit.automatalearning.Learnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IOPairModel implements PartialModel {
	
	private List<String> inputAlphabet;
	private List<String> outputAlphabet;
	
	private List<String> inputSequence;
	private String output;
	
	public IOPairModel(List<String> inputAlphabet, List<String> outputAlphabet, List<String> inputSequence, String output) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
		
		this.inputSequence = inputSequence;
		this.output = output;
	}

	@Override
	public Set<String> getPossibleOutputs(List<String> inputSequence) {
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
	public void setInputAlphabet(List<String> inputAlphabet) {
		this.inputAlphabet = inputAlphabet;
		
	}

	@Override
	public List<String> getInputAlphabet() {
		return this.inputAlphabet;
	}

	@Override
	public void setOutputAlphabet(List<String> outputAlphabet) {
		this.outputAlphabet = outputAlphabet;
		
	}

	@Override
	public List<String> getOutputAlphabet() {
		return this.outputAlphabet;
	}

	@Override
	public boolean isInputProximityKnown(List<String> inputs) {
		return false;
	}
	
	@Override
	public String toString() {
		return "IO Pair Model: " + this.inputSequence + "/" + this.output;
	}

}
