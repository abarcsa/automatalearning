package hu.bme.mit.automatalearning.hypothesis;

import java.util.Collection;
import java.util.List;



/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <I>	The input character type
 * @param <O>	The output character type
 * @param <M>	The automaton (machine) type
 * @param <S>	The state type of the automaton
 * @param <T>	The transition type of the automaton
 */
public abstract interface Hypothesis<I, O, M, S, T> {
	
	public abstract Collection<S> getHypothesisStates();
	
	public abstract Collection<T> getHypothesisTransitions();
	
	public abstract Collection<I> getHypothesisInputAlphabet();
	
	public abstract Collection<O> getHypothesisOutputAlphabet();
	
	public abstract M getHypothesisAutomaton();
	
	public abstract O query(List<? extends I> inputs);
	
	public M getHypothesis();
}
