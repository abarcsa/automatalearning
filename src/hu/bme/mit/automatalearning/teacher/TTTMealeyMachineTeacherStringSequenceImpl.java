package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.adapter.StringSequenceToTTTMealyAdapter;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;

public class TTTMealeyMachineTeacherStringSequenceImpl extends Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToTTTMealyAdapter>{
		
	public TTTMealeyMachineTeacherStringSequenceImpl(StringSequenceToTTTMealyAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public List<? extends String> equivalenceQuery(TTTHypothesisMealyEMF hypothesis, Collection<? extends String> alphabet) {
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}

	@Override
	public String membershipQuery(List<? extends String> sequence) {
		return adapter.membershipQuery(sequence);
	}

}
