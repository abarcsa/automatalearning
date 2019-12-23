package hu.bme.mit.automatalearning.algorithm;

import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.Teacher;

public abstract class ActiveLearningAlgorithm <HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>> {
	protected Teacher<HI, HO, H, ?> teacher;
	public abstract H execute();
}
