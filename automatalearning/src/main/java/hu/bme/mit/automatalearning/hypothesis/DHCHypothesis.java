package hu.bme.mit.automatalearning.hypothesis;

public abstract class DHCHypothesis<I, O, M, S, T> implements Hypothesis<I, O, M, S, T>{
	
	M automaton;
	
	public abstract S getInitialState();
	
	public abstract S addInitialState();
	
	public abstract S createNewState();
	
	public abstract S addInitialState(String idx);
	
	public abstract S createNewState(String idx);
	
	public abstract T addTransition(S from, S to, I inputSymbol, O outputSymbol);
	
	public abstract void resetHypothesis();
	
	public abstract S getState(String idx);
	
	@Override
	public M getHypothesis() {
		return automaton;
	}

}
