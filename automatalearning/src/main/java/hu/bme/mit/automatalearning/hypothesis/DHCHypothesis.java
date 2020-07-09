package hu.bme.mit.automatalearning.hypothesis;

public abstract class DHCHypothesis<I, O, M, S, T> implements Hypothesis<I, O, M, S, T>{
	
	M automaton;
	
public abstract S getInitialState();
	
	public abstract S addInitialState();
	
	public abstract S createNewState();
	
	public abstract void addTransition(S from, S to, I inputSymbol, O outputSymbol);
	
	public abstract void resetHypothesis();
	
	@Override
	public M getHypothesis() {
		return automaton;
	}

}
