package hu.bme.mit.mealeymodel.dhc.teacher;

import java.util.Collection;

import hu.bme.mit.mealeymodel.dhc.Learnable.StringSequenceLearnable;
import hu.bme.mit.mealeymodel.dhc.adapter.StringSequenceToMealeyAdapter;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;

public abstract class MealeyMachineTeacher extends Teacher<String, String, MealeyMachineHypothesis>{

	@Override
	public abstract String membershipQuery(Collection<? extends String> sequence);

	@Override
	public abstract Collection<? extends String> equivalenceQuery(MealeyMachineHypothesis hypothesis, Collection<? extends String> alphabet);

}
