package hu.bme.mit.automatalearning.util;

import java.util.Collection;
import java.util.Random;

import de.learnlib.api.SUL;
import de.learnlib.api.query.DefaultQuery;
import de.learnlib.oracle.equivalence.mealy.RandomWalkEQOracle;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import net.automatalib.words.Word;

/**
 * 
 * @author Aron Barcsa-Szabo
 * 
 * Wrapper over the RandomWalkEQOracle, so equivalence can be logged and monitored (if needed) wrt. the hypothesis.
 *
 * @param <I>
 * @param <O>
 */
public class EQWrapper<I,O> extends RandomWalkEQOracle<I, O>{
	
	TTTHypothesis<I, O, ?, ?, ?> hypothesis;

	public EQWrapper(SUL<I, O> sul, double restartProbability, long maxSteps, boolean resetStepCount,
			Random random, TTTHypothesis<I, O, ?, ?, ?> hypothesis) {
		super(sul, restartProbability, maxSteps, resetStepCount, random);
		this.hypothesis = hypothesis;
	}
	
	@Override
    public DefaultQuery<I, Word<O>> findCounterExample(net.automatalib.automata.transducers.MealyMachine<?, I, ?, O> hypothesis,
                                                       Collection<? extends I> inputs) {
        DefaultQuery<I, Word<O>> ret = super.findCounterExample(hypothesis, inputs);
        return ret;
    }
	
}
