package hu.bme.mit.mealeymodel.dhc.general;

import java.util.Collection;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <S> S is the type used as input characters
 * @param <O> O is the type used as output characters
 */
public interface Learnable<I, O> {
	/**
	 * 
	 * @param sequence The input sequence
	 * @return The output given by the Learnable to the input sequence
	 */
	public O membershipQuery(Collection<? extends I> sequence);
}
