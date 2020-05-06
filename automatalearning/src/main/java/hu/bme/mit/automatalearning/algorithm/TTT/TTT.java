package hu.bme.mit.automatalearning.algorithm.TTT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import de.learnlib.api.oracle.MembershipOracle.MealyMembershipOracle;
import de.learnlib.api.oracle.OmegaMembershipOracle.MealyOmegaMembershipOracle;
import de.learnlib.api.query.DefaultQuery;
import de.learnlib.api.query.Query;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import de.learnlib.oracle.equivalence.mealy.RandomWalkEQOracle;
import de.learnlib.util.Experiment;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.util.automata.builders.AutomatonBuilders;
import net.automatalib.words.Word;
import net.automatalib.words.WordBuilder;
import net.automatalib.words.impl.Alphabets;
import de.learnlib.oracle.membership.SULOracle;
import de.learnlib.oracle.membership.SimulatorOmegaOracle.MealySimulatorOmegaOracle;
import de.learnlib.api.SUL;
import de.learnlib.api.exception.SULException;
import de.learnlib.api.oracle.EquivalenceOracle;
import de.learnlib.api.oracle.EquivalenceOracle.MealyEquivalenceOracle;
import de.learnlib.api.oracle.MembershipOracle;

public class TTT<I, O, M, S, T> extends ActiveLearningAlgorithm<I, O, TTTHypothesis<I, O, M, S, T>>{
	
	Collection<? extends I> alphabet;
	Teacher<I, O, TTTHypothesis<I, O, M, S, T>, ?> teacher;
	TTTHypothesis<I, O, M, S, T> hypothesis;
	private static final double RESET_PROBABILITY = 0.05;
    private static final int MAX_STEPS = 10000;
    private static final int RANDOM_SEED = 89676211;
	
	public TTT(Teacher<I, O, TTTHypothesis<I, O, M, S, T>, ?> teacher, Collection<? extends I> alphabet, TTTHypothesis<I, O, M, S, T> hypothesis) {
		this.teacher = teacher;
		this.alphabet = alphabet;
		this.hypothesis = hypothesis;
	}

	public TTTHypothesis<I, O, M, S, T> execute() {
		
		
		SULWrapper<I,O> sul = new SULWrapper<I,O>(teacher);
		
		SULOracle<I, O> mqOracle = new SULOracle<>(sul);
                
        TTTLearner<I, O> learner = new TTTLearner<I, O>(Alphabets.fromCollection(alphabet), mqOracle, hypothesis);
        
        MealyEquivalenceOracle<I, O> eqOracle =
                new RandomWalkEQOracle<>(sul, // system under learning
                                         RESET_PROBABILITY, // reset SUL w/ this probability before a step
                                         MAX_STEPS, // max steps (overall)
                                         false, // reset step count after counterexample
                                         new Random(RANDOM_SEED) // make results reproducible
                );

        // create an experiment
        Experiment.MealyExperiment<I, O> experiment = new Experiment.MealyExperiment<>(learner, eqOracle, Alphabets.fromCollection(alphabet));

        // run the experiment
        experiment.run();
		
		
		return hypothesis;
	}
	
	private static class SULWrapper<I,O> implements SUL<I,O>{
		
		Teacher<I, O, ?, ?> teacher;
		
		List<I> seq;
		
		public SULWrapper(Teacher<I, O, ?, ?> teacher) {
			this.teacher = teacher;
		}

		@Override
		public void pre() {
			seq = new ArrayList<>();
		}

		@Override
		public void post() {
			seq = null;
		}

		@Override
		public O step(I in) throws SULException {
			seq.add(in);
			return teacher.membershipQuery(seq);
		}
	}

}
