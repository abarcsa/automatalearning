package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.adapter.LearnableAdapter;
import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;

public abstract class MealeyMachineTeacher<LA extends LearnableAdapter<String, String, DHCHypothesisMealy, ?, ?, ?>> extends Teacher<String, String, DHCHypothesisMealy, LA>{

	public MealeyMachineTeacher(LA adapter) {
		super(adapter);
		// TODO Auto-generated constructor stub
	}
}
