package hu.bme.mit.automatalearning.teacher;

import java.util.Collection;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptiveLearnableOutput;
import hu.bme.mit.automatalearning.adapter.AdaptiveLearnableAdapter;
import hu.bme.mit.automatalearning.adapter.LearnableAdapter;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;

public class AdaptiveTeacher<HI, HO, H extends Hypothesis<HI, HO, ?, ?, ?>, L extends LearnableAdapter<HI, HO, H, ?, ?, ?>, LA extends AdaptiveLearnableAdapter<HI, HO, H, ?, ?, ?, ?>>
	extends Teacher<HI, HO, H, L>{

	public LA adaptiveAdapter;
	
	public AdaptiveTeacher(LA adapter) {
		this.adaptiveAdapter = adapter;
	}
	
	public HO membershipQuery(List<? extends HI> sequence) {
		HO out = adaptiveAdapter.membershipQuery(sequence);
		command = adaptiveAdapter.getCommand();
		return out;
	}

	public List<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet){
		return adaptiveAdapter.equivalenceQuery(hypothesis, alphabet);
	}
	
	AdaptionCommand command = AdaptionCommand.OPTIMISTIC;
	
	public AdaptionCommand getCommand() {
		return command;
	}
}
