package hu.bme.mit.automatalearning.Learnable;

import java.util.List;
import java.util.Random;

public class OracleGuidedAdaptiveLearnable extends AdaptiveLearnable<String, String, MemoizingLearnable>{

	public OracleGuidedAdaptiveLearnable(MemoizingLearnable wrappedLearnable) {
		super(wrappedLearnable);
	}
	
	private AdaptionCommand currentCommand = AdaptionCommand.OPTIMISTIC;
	
	public void nextCommand(AdaptionCommand command) {
		if(command != null) {
			this.currentCommand = command;
		}
	}

	@Override
	public AdaptiveLearnableOutput<String> getOutput(List<? extends String> inputs) {
		Random random = new Random();
		if(random.nextBoolean()) {
			currentCommand = AdaptionCommand.OPTIMISTIC;
		}else {
			currentCommand = AdaptionCommand.PESSIMISTIC;			
		}
		return new AdaptiveLearnableOutput<>(this.wrappedLearnable.getOutput(inputs), currentCommand);
	}
}


