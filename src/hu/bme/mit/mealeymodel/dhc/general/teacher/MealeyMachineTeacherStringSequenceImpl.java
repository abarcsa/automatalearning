package hu.bme.mit.mealeymodel.dhc.general.teacher;

import java.util.Collection;

import hu.bme.mit.mealeymodel.dhc.general.adapter.StringSequenceToMealeyAdapter;
import hu.bme.mit.mealeymodel.dhc.general.hypothesis.MealeyMachineHypothesis;

public class MealeyMachineTeacherStringSequenceImpl extends MealeyMachineTeacher{
	
	StringSequenceToMealeyAdapter adapter;
	
	public MealeyMachineTeacherStringSequenceImpl(StringSequenceToMealeyAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public String membershipQuery(Collection<? extends String> sequence) {
		return adapter.membershipQuery(sequence);
	}

	@Override
	public Collection<? extends String> equivalenceQuery(MealeyMachineHypothesis hypothesis, Collection<? extends String> alphabet) {
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}

}
