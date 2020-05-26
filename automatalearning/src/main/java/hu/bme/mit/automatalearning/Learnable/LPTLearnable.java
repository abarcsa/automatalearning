package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

import hu.bme.mit.lpt_xtend.LPT;

/**
 * Learnable which uses Loopable Prefix Trees (LPTs) as a System Under Learning (SUL)
 * @author Aron Barcsa-Szabo
 *
 */
public class LPTLearnable extends StringSequenceLearnable{
	private LPT lpt;
	
	public LPTLearnable(LPT lpt) {
		this.lpt = lpt;
	}

	@Override
	public String getOutput(List<? extends String> inputs) {
		return lpt.getOutput(inputs);
	}
	
	public Set<String> getInputAlphabet(){
		return lpt.getInputAlphabet();
	}
	
	
}
