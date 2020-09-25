package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;

public class InteractiveLearnable extends StringSequenceLearnable {
	
	// Model-related variables
	private List<String> inputAlphabet;
	private List<String> outputAlphabet;
	private List<PartialModel> partialModels = new ArrayList<>();
	
	private AdaptionCommand currentCommand = AdaptionCommand.OPTIMISTIC;

	//Query-related variables
	private List<String> lastQueryInput = null;
	private List<Set<String>> lastQueryPossibleOutputs = new ArrayList<>();
	
	
	public InteractiveLearnable(List<String> inputAlphabet, List<String> outputAlphabet) {
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
	}
	
	@Override
	public String getOutput(List<? extends String> inputs) {
		currentCommand = AdaptionCommand.OPTIMISTIC;
		while(true) {
			List<String> possibleOutputs = queryModels((List<String>)inputs);
			if (possibleOutputs == null || possibleOutputs.size() > 1) {
				requireModel((List<String>)inputs);
				currentCommand = AdaptionCommand.RESET;
			} else if (possibleOutputs.size() < 1) {
				//TODO clean up the code
				//throw new RuntimeException("Conflicting models. Terminating.");
				System.out.println("Possible outputs size: " + lastQueryPossibleOutputs.size() + ", partial models size: " + partialModels.size());
				Set<String> conflictingOutput1 = lastQueryPossibleOutputs.get(lastQueryPossibleOutputs.size() - 1);
				PartialModel conflictingModel1 = partialModels.get(lastQueryPossibleOutputs.size() - 1);
				//System.out.println("Conflict 1: " + conflictingOutput1.toString() + " from model " + conflictingModel1);
				
				for (int i = 0; i < lastQueryPossibleOutputs.size() - 1; ++i) {
					Set<String> intersection = new HashSet<>(conflictingOutput1);
					intersection.retainAll(lastQueryPossibleOutputs.get(i));
					//System.out.println("Possible disjoint: " + lastQueryPossibleOutputs.get(i).toString());
					if (intersection.isEmpty()) {
						System.out.println("The intersection of " + conflictingOutput1 + " and " + lastQueryPossibleOutputs.get(i) + " are empty.");
						System.out.println("Models " + (lastQueryPossibleOutputs.size() - 1) + ") " + conflictingModel1 + " and " 
								+ i + ") " + partialModels.get(i) + " are conflicting.");
						System.out.println("Please choose which model to remove: ");
						BufferedReader reader =
				                new BufferedReader(new InputStreamReader(System.in));
						String input = null;
						try {
							input = reader.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
						int toRemove = Integer.parseInt(input);
						partialModels.remove(toRemove);
						currentCommand = AdaptionCommand.RESET;
						return null;
					}
				}
				
			} else {
				System.out.println("out: " + possibleOutputs.get(0));
				if(!(currentCommand == AdaptionCommand.RESET)) {	//TODO better error-handling
					currentCommand = isInputProximityKnown((List<String>)inputs) ? AdaptionCommand.OPTIMISTIC : AdaptionCommand.PESSIMISTIC;
				}
				return possibleOutputs.get(0);
			}
		}
	}

	private List<String> queryModels(List<? extends String> inputs) {
		lastQueryInput = (List<String>)inputs;
		lastQueryPossibleOutputs = new ArrayList<Set<String>>();
		List<String> possibleOutputs = null;
		for (PartialModel model : partialModels) {
			if (possibleOutputs == null) {
				possibleOutputs = new ArrayList<>();
				//TODO refactor without casting
				Set<String> possibleInThisModel = model.getPossibleOutputs((List<String>)inputs);
				possibleOutputs.addAll(possibleInThisModel);
				lastQueryPossibleOutputs.add(possibleInThisModel);
			} else {
				//TODO refactor without casting
				Set<String> possibleInThisModel = model.getPossibleOutputs((List<String>)inputs);
				possibleOutputs.retainAll(possibleInThisModel);
				lastQueryPossibleOutputs.add(possibleInThisModel);
			}
		}
		return possibleOutputs;
	}
	
	private void requireModel(List<String> inputs) {
		System.out.println("Unknown output for input sequence: " + inputs);
		System.out.println("Would you like to specify the output through an (I)O pair, an (L)TL expression or a (V)alid Trace?");
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
		} else if (input.equals("V")) {
			System.out.println("Please provide a valid trace:");
			//inputs/output input/output ...
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String transformedLTL = transformValidTraceToLTLExpression(input);
			partialModels.add(new LTLModel(inputAlphabet, outputAlphabet, transformedLTL));
		}
	}
	
	// TODO remove
	public boolean isInputProximityKnown(List<String> inputs) {
		boolean result = false;
		for(PartialModel model : partialModels) {
			if(model.isInputProximityKnown(inputs)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public AdaptionCommand getCommand() {
		return currentCommand;
	}
	
	private String transformValidTraceToLTLExpression(String trace) {
		//TODO simplify
		List<String> tokenizedTrace = Arrays.asList(trace.split("\\s"));
		
		StringBuilder inputPart = new StringBuilder();
		StringBuilder outputPart = new StringBuilder();
		inputPart.append("(");
		outputPart.append("(");
		for (int k = 0; k < tokenizedTrace.size(); ++k) {
			// Get the given trace elements
			List<String> ioPair = Arrays.asList(tokenizedTrace.get(k).split("/"));
			// Append the current step to the input part
			for (int j = 0; j < k; ++j)  {
				inputPart.append("X");
			}
			inputPart.append("(");
			for (int i = 0; i < inputAlphabet.size(); ++i) {
				if (inputAlphabet.get(i).equals(ioPair.get(0))) {
					inputPart.append(inputAlphabet.get(i));
				} else {
					inputPart.append("!");
					inputPart.append(inputAlphabet.get(i));
				}
				if (i < inputAlphabet.size() - 1) {
					inputPart.append("&");
				}
			}
			inputPart.append(")");
			if (k < tokenizedTrace.size() - 1) {
				inputPart.append("&");
			}
			// Append the current step to the output part
			for (int j = 0; j < k; ++j)  {
				outputPart.append("X");
			}
			outputPart.append("(");
			for (int i = 0; i < outputAlphabet.size(); ++i) {
				if (outputAlphabet.get(i).equals(ioPair.get(1))) {
					outputPart.append(outputAlphabet.get(i));
				} else {
					outputPart.append("!");
					outputPart.append(outputAlphabet.get(i));
				}
				if(i < outputAlphabet.size() - 1) {
					outputPart.append("&");
				}
			}
			outputPart.append(")");
			if (k < tokenizedTrace.size() - 1) {
				outputPart.append("&");
			}
		}
		inputPart.append(")");
		outputPart.append(")");
		
		return inputPart.toString() + "->" + outputPart.toString();
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
