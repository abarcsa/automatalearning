package hu.bme.mit.mealeymodel.dhc.general.hypothesis;

import java.util.Collection;



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
public abstract class Hypothesis<I, O, M, S, T> {
	
	protected M automaton;
		
	public abstract S getInitialState();
	
	public abstract Collection<S> getStates();
		
	public abstract Collection<T> getTransitions();

}
