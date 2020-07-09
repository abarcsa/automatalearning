package hu.bme.mit.automatalearning.Learnable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Learnable which uses Strings as both input and output symbols
 * @author Aron B.-Szabo
 *
 */
public class StringSequenceLearnable implements Learnable<String, String>{
	
	/**
	 * The inputSequence->output pairs. 
	 * E.g: a->b, aaa->b, acafg->o, a->oo are all valid inputSequence-output pairs. In the last example oo is a singular output treated as a character
	 */
	private Map<String, String> inputOutputPairs;
	
	/**
	 * To use as super() constructor in subclasses
	 */
	protected StringSequenceLearnable() {
		
	}
	
	/**
	 * 
	 * @param sequence Syntax: inputseq|output|inputseq|output ...
	 * @throws IllegalArgumentException if the sequence is empty or not in inputseq|output pairs
	 */
	public StringSequenceLearnable(String sequence) {
		if(!sequence.matches("[\\w\\d]+\\|([\\w\\d]+\\|[\\w\\d]+\\|)*[\\w\\d]+")) {
			throw new IllegalArgumentException("The given sequence is not valid!");
		}
		
		String[] inouts = sequence.split("\\|");
		this.inputOutputPairs = new HashMap<String, String>();
		
		for(int i = 0; i < inouts.length; i += 2) {
			inputOutputPairs.put(inouts[i], inouts[i+1]);
		}
		
	}

	@Override
	public String getOutput(List<? extends String> inputs) {
		if(inputs.isEmpty()) throw new IllegalArgumentException("No input provided!");
		String in = "";
		String lastOut = "";
		for(String s : inputs) {
			in += s;
			if(inputOutputPairs.get(in) == null) {
				return lastOut; //if queried sequence is longer than what is stored
			}
			lastOut = inputOutputPairs.get(in);
		}
		return inputOutputPairs.get(in);
	}

}
