package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.ltl.LTLExpression;
import hu.bme.mit.ltl.serializer.BasicSerializer;
import hu.bme.mit.ltl.serializer.EventSemanticSerializer;
import jhoafparser.parser.generated.ParseException;

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
				System.out.println("Ambiguous output: " + possibleOutputs + " (input: " + inputs + ")");
				requireModel((List<String>)inputs);
				//currentCommand = AdaptionCommand.RESET;	//TODO this
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
		System.out.println("Would you like to specify the output through an (I)O pair, an (L)TL expression, a (V)alid Trace or an I(N)valid Trace?");
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
				input = reader.readLine().replace('.', '_');
			} catch (IOException e) {
				e.printStackTrace();
			}
			partialModels.add(new IOPairModel(inputAlphabet, outputAlphabet, inputs, input.substring(0,1).toLowerCase() + input.substring(1)));
		} else if (input.equals("L")) {
			System.out.println("Please provide an LTL expression:");
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//partialModels.add(new LTLModel(inputAlphabet, outputAlphabet, input));
			
			//TODO REFACTOR THIS
			LTLExpressionParser dt = new LTLExpressionParser();
			try {
				LTLExpression parsed = dt.parse(new ByteArrayInputStream(input.getBytes()));
				EventSemanticSerializer bs = new EventSemanticSerializer(inputAlphabet, outputAlphabet);
				System.out.println("Re-serialized:");
				String serialized = bs.serialize(parsed);
				System.out.println(serialized);
				partialModels.add(new LTLModel(inputAlphabet, outputAlphabet, serialized));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (input.equals("V")) {
			System.out.println("Please provide a valid trace:");
			//inputs/output input/output ...
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			partialModels.add(createValidTraceModelFromString(input));
		} else if (input.equals("N")) {
			System.out.println("Please provide an invalid trace:");
			//inputs/output input/output ...
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			partialModels.add(createInValidTraceModelFromString(input));
		}
	}
	
	private PartialModel createInValidTraceModelFromString(String trace) {
		List<String> inputSequence = new ArrayList<>();
		List<String> outputSequence = new ArrayList<>();
		List<String> tokenizedTrace = Arrays.asList(trace.replace('.', '_').split("\\s"));
		for (String element : tokenizedTrace) {
			List<String> ioPair = Arrays.asList(element.split("/"));
			inputSequence.add(ioPair.get(0).substring(0,1).toLowerCase() + ioPair.get(0).substring(1));
			outputSequence.add(ioPair.get(1).substring(0,1).toLowerCase() + ioPair.get(1).substring(1));
		}
		return new InvalidTraceModel(inputAlphabet, outputAlphabet, inputSequence, outputSequence);
	}

	private PartialModel createValidTraceModelFromString(String trace) {
		List<String> inputSequence = new ArrayList<>();
		List<String> outputSequence = new ArrayList<>();
		List<String> tokenizedTrace = Arrays.asList(trace.replace('.', '_').split("\\s"));
		for (String element : tokenizedTrace) {
			List<String> ioPair = Arrays.asList(element.split("/"));
			inputSequence.add(ioPair.get(0).substring(0,1).toLowerCase() + ioPair.get(0).substring(1));
			outputSequence.add(ioPair.get(1).substring(0,1).toLowerCase() + ioPair.get(1).substring(1));
		}
		return new ValidTraceModel(inputAlphabet, outputAlphabet, inputSequence, outputSequence);
	}
	
	// TODO remove after refactor
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
		//System.out.println("comm: " + currentCommand);
		return currentCommand;
	}
	public void setCommand(AdaptionCommand command) {
		this.currentCommand = command;
	}
	
	public List<? extends String> interactiveEQ(DHCHypothesisMealy hypothesis){
		/*for(Set<String> s : com.google.common.collect.Sets.powerSet(new HashSet<String>(inputAlphabet))) {
			if(!s.isEmpty()) {
				for(List<String> permutation : com.google.common.collect.Collections2.permutations(s)) {
					String a = hypothesis.query(permutation);
					String b = getOutput(permutation);
					if(!a.equals(b)) return permutation;
				}
			}
		}*/
		String input = null;
		Utils.visualizeEQ(hypothesis);
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		try {
			input = reader.readLine();
			if(input.contentEquals("")) return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] inputTok = input.replace('.', '_').split(" ");
		List<String> tokenizedInput = new ArrayList<>();
		for (String tok : inputTok) tokenizedInput.add(tok.substring(0, 1).toLowerCase() + tok.substring(1));
		return tokenizedInput;
	}


}
