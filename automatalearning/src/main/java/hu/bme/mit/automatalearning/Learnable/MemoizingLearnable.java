package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.lpt.LPTRootNode;
import hu.bme.mit.lpt.LPTUnloopedNode;
import hu.bme.mit.lpt.LptFactory;
import hu.bme.mit.lpt_xtend.LPT;

public class MemoizingLearnable extends StringSequenceLearnable{
	StringSequenceLearnable delegate;
	
	LPT prefixTree;
	
	public MemoizingLearnable(StringSequenceLearnable delegate){
		this.delegate = delegate;
		prefixTree = new LPT(LptFactory.eINSTANCE.createLPTRootNode());
	}

	@Override
	public String getOutput(List<? extends String> inputs) {
		String output;
		
		try{
			//Runs correctly if 'inputs' are already memoized
			output = prefixTree.getOutput(inputs);
		}catch(Exception e) {
			//If not memoized query the system under learning using the delegate and memoize the output
			output = delegate.getOutput(inputs);
			
			if(((InteractiveLearnable)delegate).getCommand().equals(AdaptionCommand.RESET)) {
				resetCache();
			}
			
			try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./logs/MQTest.txt"), true)))
			{
				bW.write("( " + String.join(",", (List<String>)inputs) + " ) -> " + output.toString() + "\n");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
			prefixTree.addSequence(inputs, output);
			
		}
		
		return output;
	}
	
	private void resetCache() {
		LPT newPrefixTree = new LPT(LptFactory.eINSTANCE.createLPTRootNode());
		LPTRootNode root = prefixTree.getRoot();
		Deque<BFSHelper> queue = new LinkedList<>();
		for(Entry<String, LPTRootNode> entry : root.getChildren().entrySet()) {
			List<String> str = new ArrayList<>();
			str.add(entry.getKey());
			queue.add(new BFSHelper(str, (LPTUnloopedNode) entry.getValue()));
			newPrefixTree.addSequence(str, delegate.getOutput(str));
		}
		while(!queue.isEmpty()) {
			BFSHelper currElement = queue.poll();
			for(Entry<String, LPTRootNode> entry : currElement.node.getChildren().entrySet()) {
				List<String> str = currElement.currSequence;
				str.add(entry.getKey());
				queue.add(new BFSHelper(str, (LPTUnloopedNode) entry.getValue()));
				newPrefixTree.addSequence(str, delegate.getOutput(str));
			}
		}
		this.prefixTree = newPrefixTree;
	}
	
	private static class BFSHelper{
		List<String> currSequence;
		LPTUnloopedNode node;
		public BFSHelper(List<String> currSequence, LPTUnloopedNode node) {
			super();
			this.currSequence = currSequence;
			this.node = node;
		}
	}
	
	public StringSequenceLearnable getDelegate() {
		return delegate;
	}

}
