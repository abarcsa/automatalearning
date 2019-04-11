package hu.bme.mit.mealeymodel.dhc.general;

import java.util.Collection;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <I> I is the type used as input characters
 * @param <O> O is the type used as output characters
 */
public interface Learnable<I, O> {
	O getOutput(Collection<? extends I> inputs);
}
