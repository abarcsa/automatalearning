package hu.bme.mit.automatalearning.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.learnlib.api.query.DefaultQuery;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.words.Word;
import net.automatalib.words.impl.Alphabets;

/**
 * Adapter for the StringSequenceLearnable
 * @author Aron Barcsa-Szabo
 *
 * @param <I>	The input type of the Hypothesis
 * @param <O>	The output type of the Hypothesis
 * @param <H>	The hypothesis
 */
public abstract class StringSequenceAdapter<I, O, H extends Hypothesis<I, O, ?, ?, ?>> extends LearnableAdapter<I, O, H, String, String, StringSequenceLearnable> {
	

	@Override
	public List<? extends I> equivalenceQuery(H hypothesis, Collection<? extends I> alphabet) {
		for(Set<I> s : com.google.common.collect.Sets.powerSet(new HashSet<I>(alphabet))) {
			if(!s.isEmpty()) {
				for(List<I> permutation : com.google.common.collect.Collections2.permutations(s)) {
					if(!hypothesis.query(permutation).equals(this.membershipQuery(permutation))) {
						O a = hypothesis.query(permutation);
						O b = this.membershipQuery(permutation);
						return permutation;
					}
				}
			}
		}
		return null;
	}
}
	
	

