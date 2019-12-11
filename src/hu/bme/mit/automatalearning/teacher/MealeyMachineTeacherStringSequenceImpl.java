package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;

public class MealeyMachineTeacherStringSequenceImpl extends MealeyMachineTeacher<StringSequenceToMealyAdapter>{
		
	public MealeyMachineTeacherStringSequenceImpl(StringSequenceToMealyAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public List<? extends String> equivalenceQuery(DHCHypothesisMealy hypothesis, Collection<? extends String> alphabet) {
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}

	@Override
	public String membershipQuery(List<? extends String> sequence) {
		return adapter.membershipQuery(sequence);
	}

}
