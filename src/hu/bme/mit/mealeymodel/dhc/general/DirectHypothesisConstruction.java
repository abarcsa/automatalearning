package hu.bme.mit.mealeymodel.dhc.general;

import hu.bme.mit.mealeymodel.dhc.general.hypothesis.MealeyMachineHypothesis;
import hu.bme.mit.mealeymodel.dhc.general.teacher.Teacher;

public class DirectHypothesisConstruction {
	Teacher<String, String, MealeyMachineHypothesis> teacher;
	
	public DirectHypothesisConstruction(Teacher<String, String, MealeyMachineHypothesis> teacher) {
		this.teacher = teacher;
	}
	
	

}
