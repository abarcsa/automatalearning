package hu.bme.mit.automatalearning.adapter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

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
	
	

