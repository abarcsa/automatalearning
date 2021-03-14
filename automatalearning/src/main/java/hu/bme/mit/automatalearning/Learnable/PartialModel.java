package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

public interface PartialModel<I,O>{
	public Set<O> getPossibleOutputs(List<? extends I> inputSequence);
	
	public List<? extends I> getInputAlphabet();
	
	public List<O> getOutputAlphabet();
	
	public boolean isProximityContained(List<? extends I> inputs);
}
