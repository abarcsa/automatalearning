package hu.bme.mit.automatalearning.hypothesis;

import java.util.Collection;
import java.util.List;

public abstract class DHCHypothesis<I, O, M, S, T> implements Hypothesis<I, O, M, S, T>{
	
	M automaton;
	
public abstract S getInitialState();
	
	public abstract O query(List<I> inputs);
	
	public abstract S addInitialState();
	
	public abstract S createNewState();
	
	public abstract void addTransition(S from, S to, I inputSymbol, O outputSymbol);
	
	public abstract void resetHypothesis();
	
	@Override
	public M getHypothesis() {
		return automaton;
	}

}
