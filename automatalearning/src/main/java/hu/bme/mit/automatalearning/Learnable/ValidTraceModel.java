package hu.bme.mit.automatalearning.Learnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidTraceModel implements PartialModel<String, String> {
	
	private List<? extends String> inputAlphabet;
	private List<String> outputAlphabet;
	
	private List<? extends String> inputs;
	private List<String> outputs;

	public ValidTraceModel(List<? extends String> inputAlphabet, List<String> outputAlphabet, List<? extends String> inputSequence, List<String> outputSequence) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
		this.inputs = inputSequence;
		this.outputs = outputSequence;
	}
	
	@Override
	public Set<String> getPossibleOutputs(List<? extends String> inputSequence) {
		Set<String> possibleOutputs = new HashSet<>();
		for (int i = 0; i < inputSequence.size(); ++i) {
			// If the current input is longer than the contained trace, no information
			if (i >= inputs.size()) {
				possibleOutputs.addAll(outputAlphabet);
				return possibleOutputs; 
			}
			// If a mismatch is ever detected, no information
			if (!inputs.get(i).equals(inputSequence.get(i))) {
				possibleOutputs.addAll(outputAlphabet);
				return possibleOutputs;
			}
			// If the end of the current input sequence is reached, return the corresponding output
			if (i == (inputSequence.size() - 1)) {
				possibleOutputs.add(outputs.get(i));
			}
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
	public boolean isProximityContained(List<? extends String> inputSequence) {
		for (int i = 0; i < inputSequence.size(); ++i) {
			// If the current input is longer than the contained trace, no information
			if (i >= inputs.size()) {
				return false;
			}
			// If a mismatch is ever detected, no information
			if (!inputs.get(i).equals(inputSequence.get(i))) {
				return false;
			}
			// If the end of the current input sequence is reached, return the corresponding output
			if (i == (inputSequence.size() - 1) && inputs.size() > inputSequence.size()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Valid Trace model: ");
		for (int i = 0; i < inputs.size(); ++i) {
			sb.append(inputs.get(i));
			sb.append("/");
			sb.append(outputs.get(i));
			sb.append(" ");
		}
		return sb.toString();
	}

}
