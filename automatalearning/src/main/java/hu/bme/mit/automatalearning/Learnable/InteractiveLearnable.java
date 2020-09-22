package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;

public class InteractiveLearnable extends StringSequenceLearnable {
	
	List<String> inputAlphabet;
	List<String> outputAlphabet;
	Set<PartialModel> partialModels = new HashSet<>();

	public InteractiveLearnable(List<String> inputAlphabet, List<String> outputAlphabet) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
	}
	
	@Override
	public String getOutput(List<? extends String> inputs) {
		while(true) {
			List<String> possibleOutputs = queryModels((List<String>)inputs);
			if (possibleOutputs == null || possibleOutputs.size() > 1) {
				requireModel((List<String>)inputs);
			} else if (possibleOutputs.size() < 1) {
				throw new RuntimeException("Conflicting models. Terminating.");
			} else {
				return possibleOutputs.get(0);
			}
		}
	}

	private List<String> queryModels(List<? extends String> inputs) {
		List<String> possibleOutputs = null;
		for (PartialModel model : partialModels) {
			if (possibleOutputs == null) {
				possibleOutputs = new ArrayList<>();
				//TODO refactor without casting
				possibleOutputs.addAll(model.getPossibleOutputs((List<String>)inputs));
			} else {
				//TODO refactor without casting
				possibleOutputs.retainAll(model.getPossibleOutputs((List<String>)inputs));
			}
		}
		return possibleOutputs;
	}
	
	private void requireModel(List<String> inputs) {
		System.out.println("Unknown output for input sequence: " + inputs);
		System.out.println("Would you like to specify the output through an (I)O pair or an (L)TL expression?");
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (input.equals("I")) {
			System.out.println("Please provide the expected output:");
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			partialModels.add(new IOPairModel(inputAlphabet, outputAlphabet, inputs, input));
		} else if (input.equals("L")) {
			System.out.println("Please provide an LTL expression:");
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			partialModels.add(new LTLModel(inputAlphabet, outputAlphabet, input));
		}
	}
	
	public List<? extends String> interactiveEQ(DHCHypothesisMealy hypothesis){
		for(Set<String> s : com.google.common.collect.Sets.powerSet(new HashSet<String>(inputAlphabet))) {
			if(!s.isEmpty()) {
				for(List<String> permutation : com.google.common.collect.Collections2.permutations(s)) {
					String a = hypothesis.query(permutation);
					String b = getOutput(permutation);
					if(!a.equals(b)) return permutation;
				}
			}
		}
		return null;
	}


}
