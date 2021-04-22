package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.adapter.LearnableAdapter;
import hu.bme.mit.automatalearning.adapter.NDLearnableAdapter;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

public class NDTeacher <HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>, LA extends NDLearnableAdapter<HI, HO, H, ?, ?, ?>>{

	public NDLearnableAdapter<HI, HO, H, ?, ?, ?> adapter;
	
	public NDTeacher(LA adapter) {
		this.adapter = adapter;
	}
	
	public NDTeacher() {}
	
	public List<HO> membershipQuery(List<? extends HI> sequence) {
		List<HO> out = adapter.membershipQuery(sequence);
		return out;
	}

	public List<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet){
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}
	
}
