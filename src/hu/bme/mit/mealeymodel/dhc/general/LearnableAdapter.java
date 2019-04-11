package hu.bme.mit.mealeymodel.dhc.general;

import java.util.Collection;

public abstract class LearnableAdapter<I, O, L extends Learnable<I, O>, H> {

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
		return learnable.membershipQuery(sequence);
	}
	/**
	 * 
	 * @param hypothesis The current hypothesis
	 * @param inputs The set of the input alphabet to consider
	 * @return A sequence of inputs which causes a different behavior (output), an empty Collection, if none exist
	 */
	public abstract Collection<? extends I> equivalenceQuery(H hypothesis, Collection<? extends I> inputs);
	
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
}
