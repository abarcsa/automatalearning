package hu.bme.mit.automatalearning.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.NDLearnable;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

public abstract class NDLearnableAdapter <HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>, LI, LO, L extends NDLearnable<LI, LO>> {

	protected L learnable;
	
	
	/**
	 * Used to store the output given by the equivalence query
	 */
	HO counterExample;
	
	/**
	 * 
	 * @param sequence The given sequence of inputs
	 * @return The output to the input sequence
	 */
	public List<HO> membershipQuery(List<? extends HI> sequence) {
		List<LI> query = new ArrayList<>(); 
		for(HI i : sequence) {
			query.add(this.convertHypothesisInput(i));
		}
		List<HO> ret = new ArrayList<>();
		for(LO o : this.learnable.getOutput(query)) {
			ret.add(this.convertLearnableOutput(o));
		}
		return ret;
	}
	/**
	 * 
	 * @param hypothesis The current hypothesis
	 * @param inputs The set of the input alphabet to consider
	 * @return A sequence of inputs which causes a different behavior (output), an empty Collection, if none exist
	 */
	public abstract List<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet);
	
	/**
	 * 
	 * @return The counter example or, throws an IllegalStateException if called inappropriately
	 */
	public HO getCounterExample() {
		if(counterExample == null) {
			throw new IllegalStateException("No previous unsuccessful equivalence query called!");
		}
		return counterExample;
	}
	
	public abstract HI convertLearnableInput(LI input);
	
	public abstract LI convertHypothesisInput(HI input);
	
	public abstract HO convertLearnableOutput(LO output);
	
	public abstract LO convertHypothesisOutput(HO output);
	
	public L getLearnable() {
		return learnable;
	}
}