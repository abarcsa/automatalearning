package hu.bme.mit.automatalearning.Learnable;

import java.util.List;

public interface NDLearnable<I,O> {
	List<O> getOutput(List<? extends I> inputs);
}
