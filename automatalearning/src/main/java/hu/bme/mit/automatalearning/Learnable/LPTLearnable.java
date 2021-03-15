package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.datastructures.*;

/**
 * Learnable which uses Loopable Prefix Trees (LPTs) as a System Under Learning (SUL)
 * @author Aron Barcsa-Szabo
 *
 */
public class LPTLearnable<I,O> implements Learnable<I,O>{
	private LPT<I, O> lpt;
	
	public LPTLearnable(LPT<I, O> lpt) {
		this.lpt = lpt;
	}

	@Override
	public O getOutput(List<? extends I> inputs) {
		return lpt.getOutput(inputs);
	}
	
	public Set<I> getInputAlphabet(){
		return lpt.getInputAlphabet();
	}
	
	
}
