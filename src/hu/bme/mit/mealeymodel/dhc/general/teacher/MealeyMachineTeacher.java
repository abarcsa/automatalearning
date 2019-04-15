package hu.bme.mit.mealeymodel.dhc.general.teacher;

import java.util.Collection;

import hu.bme.mit.mealeymodel.dhc.general.Learnable.StringSequenceLearnable;
import hu.bme.mit.mealeymodel.dhc.general.adapter.StringSequenceToMealeyAdapter;
import hu.bme.mit.mealeymodel.dhc.general.hypothesis.MealeyMachineHypothesis;

public abstract class MealeyMachineTeacher extends Teacher<String, String, MealeyMachineHypothesis>{

	@Override
	public abstract String membershipQuery(Collection<? extends String> sequence);

	@Override
	public abstract Collection<? extends String> equivalenceQuery(MealeyMachineHypothesis hypothesis, Collection<? extends String> alphabet);

}
