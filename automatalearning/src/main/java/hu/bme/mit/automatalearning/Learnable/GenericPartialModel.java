package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

public class GenericPartialModel<I,O> implements PartialModel<I,O> {
	
	List<? extends I> inputAlphabet;
	List<O> outputAlphabet;
	OutputGetter<I,O> outputGetter;
	ProximityGetter<I,O> proximityGetter;
	
	/**
	 * 
	 * @param inputAlphabet Contains each possible input character of the partial model.
	 * @param outputAlphabet Contains each possible output character of the partial model.
	 * @param outputGetter Lambda returning the set of possible outputs for each possible input word.
	 * @param proximityGetter Lambda returning if the proximity of each possible input word is also contained in the partial model.
	 */
	public GenericPartialModel(List<? extends I> inputAlphabet, List<O> outputAlphabet, OutputGetter<I,O> outputGetter, ProximityGetter<I,O> proximityGetter) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
		this.outputGetter = outputGetter;
		this.proximityGetter = proximityGetter;
	}
	
	@Override
	public List<? extends I> getInputAlphabet() {
		return inputAlphabet;
	}

	@Override
	public List<O> getOutputAlphabet() {
		return outputAlphabet;
	}
	
	@Override
	public Set<O> getPossibleOutputs(List<? extends I> inputSequence) {
		return outputGetter.getOutputs(inputSequence);
	}

	@Override
	public boolean isProximityContained(List<? extends I> inputSequence) {
		return proximityGetter.isContained(inputSequence);
	}
	
	public interface OutputGetter<I,O> {
		Set<O> getOutputs(List<? extends I> inputSequence);
	}
	
	public interface ProximityGetter<I,O> {
		boolean isContained(List<? extends I> inputSequence);
	}

}
