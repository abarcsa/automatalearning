package hu.bme.mit.automatalearning.ui;

import java.util.List;

import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable;
import hu.bme.mit.automatalearning.Learnable.PartialModel;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

public interface InteractiveUI<I, O, M, S, T> {
	public InteractiveLearnable<I, O, M, S, T> getInteractiveLearnable();
	public void setInteractiveLearnable(InteractiveLearnable<I, O, M, S, T> interactiveLearnable);
	public List<? extends I> getInputAlphabet();
	public void setInputAlphabet(List<? extends I> inputAlphabet);
	public List<O> getOutputAlphabet();
	public void setOutputAlphabet(List<O> outputAlphabet);
	
	public PartialModel<I, O> requireModel(List<? extends I> inputSequence);
	public List<? extends I> executeEQ(Hypothesis<I, O, M, S, T> hypothesis); 
	public int resolveConflict(List<Integer> requirementIndices, List<PartialModel<I,O>> partialModels, List<? extends I> inputSequence);
}