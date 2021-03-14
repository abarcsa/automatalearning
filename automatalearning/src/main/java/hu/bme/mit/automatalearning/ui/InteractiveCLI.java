package hu.bme.mit.automatalearning.ui;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.IOPairModel;
import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable;
import hu.bme.mit.automatalearning.Learnable.InvalidTraceModel;
import hu.bme.mit.automatalearning.Learnable.LTLExpressionParser;
import hu.bme.mit.automatalearning.Learnable.LTLModel;
import hu.bme.mit.automatalearning.Learnable.PartialModel;
import hu.bme.mit.automatalearning.Learnable.ValidTraceModel;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.ltl.LTLExpression;
import hu.bme.mit.ltl.serializer.EventSemanticSerializer;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class InteractiveCLI implements InteractiveUI<String, String, MealyMachine, State, Transition>{

	private InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable;
	private List<? extends String> inputAlphabet;
	private List<String> outputAlphabet;
	
	public InteractiveCLI() {
		// TODO?
	}
	
	public InteractiveCLI(InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable) {
		this.interactiveLearnable = interactiveLearnable;
	}
	
	@Override
	public InteractiveLearnable<String, String, MealyMachine, State, Transition> getInteractiveLearnable() {
		return interactiveLearnable;
	}
	
	@Override
	public void setInteractiveLearnable(InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable) {
		this.interactiveLearnable = interactiveLearnable;
	}
	
	@Override
	public List<? extends String> getInputAlphabet(){
		return inputAlphabet;
	}
	
	@Override 
	public void setInputAlphabet(List<? extends String> inputAlphabet) {
		this.inputAlphabet = inputAlphabet;
	}
	
	@Override
	public List<String> getOutputAlphabet(){
		return outputAlphabet;
	}
	
	@Override
	public void setOutputAlphabet(List<String> outputAlphabet) {
		this.outputAlphabet = outputAlphabet;
	}
	
	@Override
	public PartialModel<String, String> requireModel(List<? extends String> inputSequence) {
		System.out.println("Unknown output for input sequence: " + inputSequence);
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
			return new IOPairModel(inputAlphabet, outputAlphabet, inputSequence, input.substring(0,1).toLowerCase() + input.substring(1));
		} else if (input.equals("L")) {
			System.out.println("Please provide an LTL expression:");
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			//TODO REFACTOR THIS
			LTLExpressionParser dt = new LTLExpressionParser();
			try {
				LTLExpression parsed = dt.parse(new ByteArrayInputStream(input.getBytes()));
				EventSemanticSerializer bs = new EventSemanticSerializer(inputAlphabet, outputAlphabet);
				//System.out.println("Re-serialized:");
				String serialized = bs.serialize(parsed);
				//System.out.println(serialized);
				return new LTLModel(inputAlphabet, outputAlphabet, serialized);
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
			return createValidTraceModelFromString(input);
		} else if (input.equals("N")) {
			System.out.println("Please provide an invalid trace:");
			//inputs/output input/output ...
			try {
				input = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return createInValidTraceModelFromString(input);
		}
		return null;	//TODO more elegant solution
	}

	@Override
	public List<? extends String> executeEQ(Hypothesis<String, String, MealyMachine, State, Transition> hypothesis) {
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

	@Override
	public int resolveConflict(List<Integer> requirementIndices, List<PartialModel<String, String>> partialModels, List<? extends String> inputSequence) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/// TODO extract into factory object
	private PartialModel<String, String> createValidTraceModelFromString(String trace) {
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
	
	private PartialModel<String, String> createInValidTraceModelFromString(String trace) {
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

}
