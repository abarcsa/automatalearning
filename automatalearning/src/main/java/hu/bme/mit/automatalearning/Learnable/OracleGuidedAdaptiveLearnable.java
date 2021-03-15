package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Random;

public class OracleGuidedAdaptiveLearnable<I, O> extends AdaptiveLearnable<I, O, InteractiveMemoizingLearnable<I, O, ?>>{

	public OracleGuidedAdaptiveLearnable(InteractiveMemoizingLearnable<I, O, ?> wrappedLearnable) {
		super(wrappedLearnable);
	}
	
	private AdaptionCommand currentCommand = AdaptionCommand.OPTIMISTIC;
	
	public void nextCommand(AdaptionCommand command) {
		if(command != null) {
			this.currentCommand = command;
		}
	}

	@Override
	public AdaptiveLearnableOutput<O> getOutput(List<? extends I> inputs) {		
		InteractiveLearnable<I, O, ?, ?, ?> interactiveLearnable = this.wrappedLearnable.delegate;
		return new AdaptiveLearnableOutput<O>(this.wrappedLearnable.getOutput(inputs), interactiveLearnable.getCommand());
	}

}


