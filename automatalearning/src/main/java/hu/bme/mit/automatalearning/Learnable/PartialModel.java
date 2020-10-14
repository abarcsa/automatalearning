package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

interface PartialModel{
	public Set<String> getPossibleOutputs(List<String> inputSequence);
	
	public List<String> getInputAlphabet();
	
	public List<String> getOutputAlphabet();
	
	public boolean isInputProximityKnown(List<String> inputs);
}
