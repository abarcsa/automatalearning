package hu.bme.mit.automatalearning.hypothesis;

import de.learnlib.algorithms.ttt.base.AbstractTTTHypothesis;
import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.base.TTTTransition;
import de.learnlib.algorithms.ttt.mealy.TTTTransitionMealy;
import hu.bme.mit.automatalearning.algorithm.TTT.TTTTransitionImpl;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.automata.transducers.MealyMachine;
import net.automatalib.words.Alphabet;
import net.automatalib.words.Word;

public abstract class TTTHypothesis<I, O, M, S, T> extends AbstractTTTHypothesis<I, Word<O>, TTTTransitionImpl<I, O>> implements Hypothesis<I, O, M, S, T>, MealyMachine<TTTState<I, Word<O>>, I, TTTTransitionImpl<I, O>, O>, UniversalDeterministicAutomaton.FullIntAbstraction<TTTTransitionImpl<I, O>, Void, O> {
	
	public TTTHypothesis(Alphabet<I> alphabet) {
		super(alphabet);
	}

	M hypo;
	
	public abstract M convertHypo();
	
	@Override
	public M getHypothesis() {
		return convertHypo();
	}
	
	public UniversalDeterministicAutomaton.FullIntAbstraction<TTTTransitionImpl<I, O>, Void, O> fullIntAbstraction(Alphabet<I> alphabet){
		return MealyMachine.super.fullIntAbstraction(alphabet);
	}
	public abstract O getTransitionProperty(TTTTransitionImpl<I, O> transition);
	
}
