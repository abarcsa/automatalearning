package hu.bme.mit.mealeymodel.dhc.general.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.bme.mit.mealeymodel.dhc.general.Learnable;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <I> 	The input character type of the Hypothesis
 * @param <O> 	The output character type of the Hypothesis
 * @param <H> 	The hypothesis
 * @param <LI>	The input character type of the Learnable
 * @param <LO>	The output character type of the Learnable
 * @param <L>	The Learnable
 */
public abstract class LearnableAdapter<I, O, H, LI, LO, L extends Learnable<LI, LO>> {

	L learnable;
	
	
	/**
	 * Used to store the output given by the equivalence query
	 */
	O counterExample;
	
	/**
	 * 
	 * @param sequence The given sequence of inputs
	 * @return The output to the input sequence
	 */
	public O membershipQuery(Collection<? extends I> sequence) {
		List<LI> query = new ArrayList<>(); 
		for(I i : sequence) {
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
	public abstract Collection<? extends I> equivalenceQuery(H hypothesis, Collection<? extends I> alphabet);
	
	/**
	 * 
	 * @return The counter example or, throws an IllegalStateException if called inappropriately
	 */
	public O getCounterExample() {
		if(counterExample == null) {
			throw new IllegalStateException("No previous unsuccessful equivalence query called!");
		}
		return counterExample;
	}
	
	public abstract I convertLearnableInput(LI input);
	
	public abstract LI convertHypothesisInput(I input);
	
	public abstract O convertLearnableOutput(LO output);
	
	public abstract LO convertHypothesisOutput(O outout);
}