package hu.bme.mit.automatalearning.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable;
import hu.bme.mit.automatalearning.Learnable.Learnable;
import hu.bme.mit.automatalearning.Learnable.MemoizingLearnable;
import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptiveLearnableOutput;
import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

public class AdaptiveLearnableAdapter<HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>, LI, LO, L extends Learnable<LI, LO>, LA extends AdaptiveLearnable<LI, LO, ?>>
{
	
	protected LearnableAdapter<HI, HO, H, LI, LO, L> wrappedAdapter;
	
	protected LA learnable;
	
	public AdaptiveLearnableAdapter(LearnableAdapter<HI, HO, H, LI, LO, L> wrappedAdapter, LA learnable) {
		this.wrappedAdapter = wrappedAdapter;
		this.learnable = learnable;
	}
	
	AdaptionCommand command = AdaptionCommand.OPTIMISTIC;
	
	public AdaptionCommand getCommand() {
		return command;
	}
	
	public HO membershipQuery(List<? extends HI> sequence) {
		List<LI> query = new ArrayList<>(); 
		for(HI i : sequence) {
			query.add(this.wrappedAdapter.convertHypothesisInput(i));
		}
		AdaptiveLearnableOutput<LO> output = this.learnable.getOutput(query);
		command = output.getCommand();
		return this.wrappedAdapter.convertLearnableOutput(output.getOutput());
	}
	
	public AdaptiveLearnableAdapter(LearnableAdapter<HI, HO, H, LI, LO, L> wrappedAdapter) {
		this.wrappedAdapter = wrappedAdapter;
	}

	public List<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet) {
		if(wrappedAdapter.learnable instanceof MemoizingLearnable && ((MemoizingLearnable) wrappedAdapter.learnable).getDelegate() instanceof InteractiveLearnable) {
			return (List<? extends HI>) ((InteractiveLearnable) ((MemoizingLearnable) wrappedAdapter.learnable).getDelegate()).interactiveEQ((DHCHypothesisMealy) hypothesis);
		}
		return wrappedAdapter.equivalenceQuery(hypothesis, alphabet);
	}

}
