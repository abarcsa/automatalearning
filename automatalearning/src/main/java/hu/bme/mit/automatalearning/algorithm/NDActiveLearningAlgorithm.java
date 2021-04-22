package hu.bme.mit.automatalearning.algorithm;

import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.NDTeacher;

public abstract class NDActiveLearningAlgorithm <HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>> {
	protected NDTeacher<HI, HO, H, ?> teacher;
	public abstract H execute();
}
