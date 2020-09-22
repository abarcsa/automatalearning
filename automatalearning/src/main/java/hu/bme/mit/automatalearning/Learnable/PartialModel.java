package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

interface PartialModel{
	public Set<String> getPossibleOutputs(List<String> inputSequence);
	
	public void setInputAlphabet(List<String> inputAlphabet);
	public List<String> getInputAlphabet();
	
	public void setOutputAlphabet(List<String> outputAlphabet);
	public List<String> getOutputAlphabet();
}
