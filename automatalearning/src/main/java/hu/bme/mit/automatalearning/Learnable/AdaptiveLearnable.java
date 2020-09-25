package hu.bme.mit.automatalearning.Learnable;

public abstract class AdaptiveLearnable<I, O, L extends Learnable<I, O>> implements Learnable<I, AdaptiveLearnable.AdaptiveLearnableOutput<O>>{
	
	protected L wrappedLearnable;
	
	public AdaptiveLearnable(L wrappedLearnable) {
		this.wrappedLearnable = wrappedLearnable;
	}
	
	public enum AdaptionCommand{
		OPTIMISTIC,
		PESSIMISTIC,
		RESET
	}
	
	public static class AdaptiveLearnableOutput<O>{
		O output;
		AdaptionCommand command;
		
		public AdaptiveLearnableOutput(O output, AdaptionCommand command) {
			this.output = output;
			this.command = command;
		}

		public O getOutput() {
			return output;
		}

		public void setOutput(O output) {
			this.output = output;
		}

		public AdaptionCommand getCommand() {
			return command;
		}

		public void setCommand(AdaptionCommand command) {
			this.command = command;
		}		
	}
}