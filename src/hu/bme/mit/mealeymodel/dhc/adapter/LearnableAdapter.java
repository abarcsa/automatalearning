package hu.bme.mit.mealeymodel.dhc.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.bme.mit.mealeymodel.dhc.Learnable.Learnable;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <HI> 	The input character type of the Hypothesis
 * @param <HO> 	The output character type of the Hypothesis
 * @param <H> 	The hypothesis
 * @param <LI>	The input character type of the Learnable
 * @param <LO>	The output character type of the Learnable
 * @param <L>	The Learnable
 */
public abstract class LearnableAdapter<HI, HO, H, LI, LO, L extends Learnable<LI, LO>> {

	L learnable;
	
	
	/**
	 * Used to store the output given by the equivalence query
	 */
	HO counterExample;
	
	/**
	 * 
	 * @param sequence The given sequence of inputs
	 * @return The output to the input sequence
	 */
	public HO membershipQuery(Collection<? extends HI> sequence) {
		List<LI> query = new ArrayList<>(); 
		for(HI i : sequence) {
			query.add(this.convertHypothesisInput(i));
		}
		return this.convertLearnableOutput(this.learnable.getOutput(query));
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
}