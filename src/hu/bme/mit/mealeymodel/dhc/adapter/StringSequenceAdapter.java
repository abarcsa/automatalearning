package hu.bme.mit.mealeymodel.dhc.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.bme.mit.mealeymodel.dhc.Learnable.StringSequenceLearnable;

/**
 * Adapter for the StringSequenceLearnable
 * @author Aron B.-Szabo
 *
 * @param <I>	The input type of the Hypothesis
 * @param <O>	The output type of the Hypothesis
 * @param <H>	The hypothesis
 */
public abstract class StringSequenceAdapter<I, O, H> extends LearnableAdapter<I, O, H, String, String, StringSequenceLearnable> {

	@Override
	public O membershipQuery(Collection<? extends I> sequence) {
		List<String> query = new ArrayList<>(); 
		for(I i : sequence) {
			query.add(this.convertHypothesisInput(i));
		}
		return this.convertLearnableOutput(this.learnable.getOutput(query));
	}

	@Override
	public Collection<? extends I> equivalenceQuery(H hypothesis, Collection<? extends I> alphabet) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	

