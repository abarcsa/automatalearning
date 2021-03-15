package hu.bme.mit.automatalearning.Learnable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.ui.InteractiveUI;

// AdaptiveLearnable extended with the output types, as this class handles output as well
public class InteractiveLearnable<I, O, M, S, T> implements Learnable<I, InteractiveLearnable.InteractiveLearnableOutput<O>> {
	
	// UI
	private InteractiveUI<I, O, M, S, T> ui;
	
	// Model-related variables
	private List<I> inputAlphabet;
	private List<O> outputAlphabet;
	private List<PartialModel<I, O>> partialModels = new ArrayList<>();
	
	private AdaptionCommand currentCommand = AdaptionCommand.OPTIMISTIC;

	//Query-related variables
	private List<? extends I> lastQueryInput = null;
	private List<Set<O>> lastQueryPossibleOutputs = new ArrayList<>();
	
	
	public InteractiveLearnable(List<I> inputAlphabet, List<O> outputAlphabet) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
	}
	
	@Override
	public InteractiveLearnableOutput<O> getOutput(List<? extends I> inputs) {
		currentCommand = AdaptionCommand.OPTIMISTIC;
		while(true) {
			List<O> possibleOutputs = queryModels(inputs);
			if (possibleOutputs == null || possibleOutputs.size() > 1) {
				PartialModel<I,O> toAdd = ui.requireModel(inputs);
				if (toAdd != null)
					partialModels.add(toAdd);
			} else if (possibleOutputs.size() < 1) {
				// The last model is always one of the conflicting ones (???)
				Set<? extends O> conflictingOutput1 = lastQueryPossibleOutputs.get(lastQueryPossibleOutputs.size() - 1);
				PartialModel<I, O> conflictingModel1 = partialModels.get(lastQueryPossibleOutputs.size() - 1);
				for (int i = 0; i < lastQueryPossibleOutputs.size() - 1; ++i) {
					Set<O> intersection = new HashSet<>(conflictingOutput1);
					intersection.retainAll(lastQueryPossibleOutputs.get(i));
					if (intersection.isEmpty()) {
						List<Integer> automatonIndices = new ArrayList<Integer>();
						automatonIndices.add(lastQueryPossibleOutputs.size() - 1);
						automatonIndices.add(i);
						
						List<PartialModel<I,O>> conflictingModels = new ArrayList<>();
						conflictingModels.add(partialModels.get(lastQueryPossibleOutputs.size() - 1));
						conflictingModels.add(partialModels.get(i));

						int toRemove = ui.resolveConflict(automatonIndices, conflictingModels, inputs);
						
						partialModels.remove(toRemove);
						currentCommand = AdaptionCommand.RESET;
						return null;
					}
				}
				
			} else {
				System.out.println("out: " + possibleOutputs.get(0));
				if(!(currentCommand == AdaptionCommand.RESET)) {	//TODO better error-handling
					currentCommand = isInputProximityKnown(inputs) ? AdaptionCommand.OPTIMISTIC : AdaptionCommand.PESSIMISTIC;
				}
				return new InteractiveLearnableOutput<O>(possibleOutputs.get(0), currentCommand);
			}
		}
	}

	private List<O> queryModels(List<? extends I> inputs) {
		lastQueryInput = inputs;
		lastQueryPossibleOutputs = new ArrayList<Set<O>>();
		List<O> possibleOutputs = null;
		for (PartialModel<I,O> model : partialModels) {
			if (possibleOutputs == null) {
				possibleOutputs = new ArrayList<>();
				Set<O> possibleInThisModel = model.getPossibleOutputs(inputs);
				possibleOutputs.addAll(possibleInThisModel);
				lastQueryPossibleOutputs.add(possibleInThisModel);
			} else {
				Set<O> possibleInThisModel = model.getPossibleOutputs(inputs);
				possibleOutputs.retainAll(possibleInThisModel);
				lastQueryPossibleOutputs.add(possibleInThisModel);
			}
		}
		return possibleOutputs;
	}

	
	
	// TODO remove after refactor
	public boolean isInputProximityKnown(List<? extends I> inputs) {
		boolean result = false;
		for(PartialModel<I,O> model : partialModels) {
			if(model.isProximityContained(inputs)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public AdaptionCommand getCommand() {
		//System.out.println("comm: " + currentCommand);
		return currentCommand;
	}
	public void setCommand(AdaptionCommand command) {
		this.currentCommand = command;
	}
	
	public List<? extends I> interactiveEQ(Hypothesis<I, O, M, S, T> hypothesis){
		return ui.executeEQ(hypothesis);
	}

	public static class InteractiveLearnableOutput<O>{
		O output;
		AdaptionCommand command;
		
		public InteractiveLearnableOutput(O output, AdaptionCommand command) {
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
