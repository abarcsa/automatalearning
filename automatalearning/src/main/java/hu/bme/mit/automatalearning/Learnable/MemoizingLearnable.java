package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
	
	public StringSequenceLearnable getDelegate() {
		return delegate;
	}

}
