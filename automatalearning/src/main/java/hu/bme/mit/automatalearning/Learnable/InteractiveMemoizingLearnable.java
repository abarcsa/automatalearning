package hu.bme.mit.automatalearning.Learnable;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable.InteractiveLearnableOutput;
import hu.bme.mit.automatalearning.datastructures.LPT;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTRootNode;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTUnloopedNode;
import hu.bme.mit.automatalearning.util.Utils.BFSHelper;

public class InteractiveMemoizingLearnable<I, O, L extends InteractiveLearnable<I, O, ?, ?, ?>> extends MemoizingLearnable<I, O, I, InteractiveLearnable.InteractiveLearnableOutput<O>, L>{

	public InteractiveMemoizingLearnable(L delegate) {
		super(delegate);
	}
	
	@Override
	public O getOutput(List<? extends I> inputs) {
		O output;
		
		try{
			//Runs correctly if 'inputs' are already memoized
			output = prefixTree.getOutput(inputs);
			if(prefixTree.getNode(inputs).getChildren().size() > 0) {
				delegate.setCommand(AdaptionCommand.OPTIMISTIC);
			}
		}catch(Exception e) {
			//If not memoized query the system under learning using the delegate and memoize the output
			output = delegate.getOutput(inputs).output;
			
			if(delegate.getCommand().equals(AdaptionCommand.RESET)) {
				resetCache();
			}
			
			prefixTree.addSequence(inputs, output);
			
		}
		
		return output;
	}
	
	private void resetCache() {
		LPT<I, O> newPrefixTree = new LPT<I, O>(new LPTRootNode<I, O>());
		LPTRootNode<I, O> root = prefixTree.getRoot();
		Deque<BFSHelper<I, O>> queue = new LinkedList<>();
		for(Entry<I, LPTRootNode<I, O>> entry : root.getChildren().entrySet()) {
			List<I> ins = new ArrayList<>();
			ins.add(entry.getKey());
			queue.add(new BFSHelper<I, O>(ins, (LPTUnloopedNode<I, O>) entry.getValue()));
			newPrefixTree.addSequence(ins, delegate.getOutput(ins).output);
		}
		while(!queue.isEmpty()) {
			BFSHelper<I, O> currElement = queue.poll();
			for(Entry<I, LPTRootNode<I, O>> entry : currElement.node.getChildren().entrySet()) {
				List<I> ins = currElement.currSequence;
				ins.add(entry.getKey());
				queue.add(new BFSHelper<I, O>(ins, (LPTUnloopedNode<I, O>) entry.getValue()));
				newPrefixTree.addSequence(ins, delegate.getOutput(ins).output);
			}
		}
		this.prefixTree = newPrefixTree;
	}
}
