package hu.bme.mit.automatalearning.adapter.output;

import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

/**
 * 
 * @author Aron
 *
 * @param <F> From type
 * @param <T> To type
 */
public interface OutputAdapter<F, T> {
	public T adapt(F from);
}
