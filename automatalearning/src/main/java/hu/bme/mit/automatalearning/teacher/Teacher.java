package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.adapter.LearnableAdapter;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <HI>	The input type of the Hypothesis
 * @param <HO>	The output type of the Hypothesis
 * @param <H>	The Hypothesis
 */
public class Teacher <HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>, LA extends LearnableAdapter<HI, HO, H, ?, ?, ?>>{

	public LearnableAdapter<HI, HO, H, ?, ?, ?> adapter;
	
	public Teacher(LA adapter) {
		this.adapter = adapter;
	}
	
	public Teacher() {}
	
	public HO membershipQuery(List<? extends HI> sequence) {
		HO out = adapter.membershipQuery(sequence);
		return out;
	}

	public List<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet){
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}
	
}
