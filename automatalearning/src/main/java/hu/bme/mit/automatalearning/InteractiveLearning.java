package hu.bme.mit.automatalearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable;
import hu.bme.mit.automatalearning.Learnable.InteractiveMemoizingLearnable;
import hu.bme.mit.automatalearning.Learnable.MemoizingLearnable;
import hu.bme.mit.automatalearning.Learnable.OracleGuidedAdaptiveLearnable;
import hu.bme.mit.automatalearning.adapter.AdaptiveLearnableAdapter;
import hu.bme.mit.automatalearning.adapter.CompositeMealyMachineSystemToGSCAdapter;
import hu.bme.mit.automatalearning.adapter.GammaProjectSerializer;
import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.algorithm.dhc.AdaptiveDirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.teacher.AdaptiveTeacher;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class InteractiveLearning {
	
	
	
	// MAKE SURE ALPHABETS ARE INTERFACE QUALIFIED
	public void learn() {
		// Get components
		BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		System.out.println("Please provide the system components (space-separated):");
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> componentNames = Arrays.asList(input.split(" "));
		// For each component learn
		List<MealyMachine> compositeSystem = new ArrayList<>();
		for (String component : componentNames) {
			System.out.println("Please provide the input alphabet for component " + component + " (space-separated):");
			try {
				input = reader.readLine().replace('.', '_');
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] inputs = input.split(" ");
			List<String> inputAlphabet = new ArrayList<>();
			for (String ch : inputs) inputAlphabet.add(ch.substring(0, 1).toLowerCase() + ch.substring(1));
			System.out.println(inputAlphabet);
			System.out.println("Please provide the output alphabet for component " + component + " (space-separated):");
			try {
				input = reader.readLine().replace('.', '_');
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] outputs = input.split(" ");
			List<String> outputAlphabet = new ArrayList<>();
			for (String ch : outputs) outputAlphabet.add(ch.substring(0, 1).toLowerCase() + ch.substring(1));
			System.out.println(outputAlphabet);
			InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(new InteractiveLearnable<>(inputAlphabet, outputAlphabet));
			OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<>(l);
			AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
			
			AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
					new AdaptiveTeacher<>(a);
			
			AdaptiveDirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = 
					new AdaptiveDirectHypothesisConstructionMealy<>(teacher, inputAlphabet, new DHCHypothesisMealy(inputAlphabet));
			
			DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
			compositeSystem.add(h.getHypothesis());
		}
		
		//serialize Gamma
		CompositeMealyMachineSystemToGSCAdapter ad = new CompositeMealyMachineSystemToGSCAdapter(compositeSystem);
		ad.transformInterfaces();
		ad.transformPortBindings();
		GammaProjectSerializer ser = new GammaProjectSerializer(ad, "");
		ser.serialize();
	}

}
