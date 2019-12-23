package hu.bme.mit.automatalearning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.google.common.base.Stopwatch;

import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.algorithm.TTT.TTT;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;


public class Main {

	public static void main(String[] args) {
		//EXAMPLES. AFTER EVERY DESCRIPTION THERE IS A METHOD TO UNCOMMENT TO RUN SAID EXAMPLE.
		
			//Alternating bit protocol in the form of a String input formalism, learned by DHC, outputs to /learnedmachine.mealy
		//alternatingbit();
		
			//Coffee machine Mealy machine using Xtext input formalism, learned by DHC, outputs to /learnedmachine.mealy
		//coffeeMealyDHC();
		
			//Coffee machine Mealy machine using Xtext input formalism, learned by TTT, outputs to /learnedmachine.mealy
		//coffeeMealyTTT();
		
			//4i-3a accepting Mealy machine using Xtext, learned by DHC, otputs to /learnedmachine.mealy
		//fouriaMealyDHC();
		
			//4i-3a accepting Mealy machine using Xtext, learned by TTT, otputs to /learnedmachine.mealy
		//fouriaMealyTTT();
		
		
		//EXPERIMENTAL EVALUATION METHODS USED IN THE THESIS. ALL OUTPUT TO /src/expeval_results.csv. SHOULD BE STOPPED MANUALLY WHEN A SATISFIABLE AMOUNT OF RESULTS ARE DONE.
		
		//experimentalEvaluationDHCState();
		
		//experimentalEvaluationTTTState();
		
		//experimentalEvaluationDHCAlphabet();
		
		//experimentalEvaluationTTTAlphabet();
	}
	
	public static void alternatingbit() {
		String sequence = 
				"null|send0|ack1|send0|ack0|send1"
				+ "|ack0null|send1|ack0ack0|send1|ack0ack1|send0"
				+ "|ack1null|send0|ack1ack0|send1|ack1ack1|send0"
				+ "|nullnull|send0|nullack0|send1|nullack1|send0"
				+ "|ack0nullnull|send1|ack0nullack0|send1|ack0nullack1|send0"
				+ "|ack0ack0null|send1|ack0ack0ack0|send1|ack0ack0ack1|send0"
				+ "|ack0ack1null|send0|ack0ack1ack0|send1|ack0ack1ack1|send0"
				+ "|ack1nullnull|send0|ack1nullack0|send1|ack1nullack1|send0"
				+ "|ack1ack0null|send1|ack1ack0ack0|send1|ack1ack0ack1|send0"
				+ "|ack1ack1null|send0|ack1ack1ack0|send1|ack1ack1ack1|send0"
				+ "|nullnullnull|send0|nullnullack0|send1|nullnullack1|send0"
				+ "|nullack0null|send1|nullack0ack0|send1|nullack0ack1|send0"
				+ "|nullack1null|send0|nullack1ack0|send1|nullack1ack1|send0";
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().add("null");
		inputAlphabet.getCharacters().add("ack0");
		inputAlphabet.getCharacters().add("ack1");
		DHCHypothesis<String, String, MealyMachine, State, Transition> hypo = new DHCHypothesisMealy(inputAlphabet);
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = new Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, StringSequenceToMealyAdapter<DHCHypothesis<String, String, MealyMachine, State, Transition>>>(new StringSequenceToMealyAdapter(new StringSequenceLearnable(sequence)));
		DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new DirectHypothesisConstructionMealy<>(teacher, inputAlphabet.getCharacters(), hypo);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		MealyModelReader.output(h.getHypothesis());
	}
	
	public static void coffeeMealyDHC() {
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/coffeemachine.mealy");
		
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = new Teacher<>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
		DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new DirectHypothesisConstructionMealy<>(teacher, m.getInputAlphabet().getCharacters(), new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		MealyModelReader.output(h.getHypothesis());
	}
	
	public static void coffeeMealyTTT() {
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/coffeemachine.mealy");
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());

		Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>> teacher = new Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
		TTT algo = new TTT(teacher, inputAlphabet.getCharacters());
		
		TTTHypothesis<String, String, MealyMachine, State, Transition> h = algo.execute();
		
		MealyModelReader.output(h.getHypothesis());
	}
	
	public static void fouriaMealyDHC() {
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> hypo = new DHCHypothesisMealy(inputAlphabet);
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = new Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, StringSequenceToMealyAdapter<DHCHypothesis<String, String, MealyMachine, State, Transition>>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
		DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition>(teacher, m.getInputAlphabet().getCharacters(), hypo);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		MealyModelReader.output(h.getHypothesis());
	}
	
	public static void fouriaMealyTTT() {
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());

		Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>> teacher = new Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
		TTT algo = new TTT(teacher, inputAlphabet.getCharacters());
		
		TTTHypothesis<String, String, MealyMachine, State, Transition> h = algo.execute();
		
		MealyModelReader.output(h.getHypothesis());
	}
	
	public static void experimentalEvaluationDHCState() {
		//Read 4ia example
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 10000; i++) {
					Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
					inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
					DHCHypothesis<String, String, MealyMachine, State, Transition> hypo = new DHCHypothesisMealy(inputAlphabet);
					Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = new Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, StringSequenceToMealyAdapter<DHCHypothesis<String, String, MealyMachine, State, Transition>>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
					DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition>(teacher, m.getInputAlphabet().getCharacters(), hypo);
					if(i%50 == 0) {
						Stopwatch sW = Stopwatch.createStarted();
						DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
						sW.stop();
						try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./src/expeval_results.csv"), true))){
						bW.write("" + h.getHypothesis().getStates().size() + ";" + sW.elapsed(TimeUnit.MILLISECONDS));
						bW.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					m = incrementEvaluation(m, currAccepting, i);
					//currAccepting = String.valueOf(((char)'c'+i));
					currAccepting = "q" + (4+i); 
				
			}
	}
	
	public static void experimentalEvaluationDHCAlphabet() {
		//Read 4ia example
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 10000; i++) {
					Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
					inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
					DHCHypothesis<String, String, MealyMachine, State, Transition> hypo = new DHCHypothesisMealy(inputAlphabet);
					Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = new Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, StringSequenceToMealyAdapter<DHCHypothesis<String, String, MealyMachine, State, Transition>>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
					DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = new DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition>(teacher, m.getInputAlphabet().getCharacters(), hypo);
					if(i%50 == 0) {
						Stopwatch sW = Stopwatch.createStarted();
						DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
						sW.stop();
						try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./src/expeval_results.csv"), true))){
						bW.write("" + h.getHypothesis().getInputAlphabet().getCharacters().size() + ";" + sW.elapsed(TimeUnit.MILLISECONDS));
						bW.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					m = incrementEvaluationAlphabet(m, currAccepting, i);
					//currAccepting = String.valueOf(((char)'c'+i));
					currAccepting = "q" + (4+i); 
				
			}
	}
	
	public static void experimentalEvaluationTTTState() {
		//Read 4ia example
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 100000; i++) {
				
				Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>> teacher = new Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
				Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
				inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
				TTT algo = new TTT(teacher, inputAlphabet.getCharacters());
				if(i%250 == 0) {
					Stopwatch sW = Stopwatch.createStarted();
					TTTHypothesis<String, String, MealyMachine, State, Transition> mH = algo.execute();
					sW.stop();
					try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./src/expeval_results.csv"), true))){
					bW.write("" + mH.getHypothesis().getStates().size() + ";" + sW.elapsed(TimeUnit.MILLISECONDS));
					bW.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				m = incrementEvaluation(m, currAccepting, i);
				currAccepting = "q" + (4+i);
				
			}

	}
	
	public static void experimentalEvaluationTTTAlphabet() {
		//Read 4ia example
		MealyMachine m = MealyModelReader.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 100000; i++) {
				
				Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>> teacher = new Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToMealyAdapter<TTTHypothesisMealyEMF>>(new StringSequenceToMealyAdapter(new MealyLearnable(m)));
				Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
				inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
				TTT algo = new TTT(teacher, inputAlphabet.getCharacters());
				if(i%250 == 0) {
					Stopwatch sW = Stopwatch.createStarted();
					TTTHypothesis<String, String, MealyMachine, State, Transition> mH = algo.execute();
					sW.stop();
					try(BufferedWriter bW = new BufferedWriter(new FileWriter(new File("./src/expeval_results.csv"), true))){
					bW.write("" + mH.getHypothesis().getInputAlphabet().getCharacters().size()  + ";" + sW.elapsed(TimeUnit.MILLISECONDS));
					bW.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				m = incrementEvaluationAlphabet(m, currAccepting, i);
				currAccepting = "q" + (4+i);
				
			}

	}
	
	public static MealyMachine incrementEvaluation(MealyMachine m, String currAccepting, int counter) {
		MealyMachine ret = MealymodelFactory.eINSTANCE.createMealyMachine();
		Alphabet in = MealymodelFactory.eINSTANCE.createAlphabet();
		in.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		ret.setInputAlphabet(in);
		
		State init = MealymodelFactory.eINSTANCE.createState();
		init.setName(m.getInitialState().getName());
		ret.setInitialState(init);
		
		for(State s : m.getStates()) {
			State newS = MealymodelFactory.eINSTANCE.createState();
			newS.setName(s.getName());
			ret.getStates().add(newS);
		}
		State newAccepting = MealymodelFactory.eINSTANCE.createState();
		newAccepting.setName("q" + (4+counter));
		ret.getStates().add(newAccepting);
		
		for(Transition t : m.getTransitions()) {
			if(t.getTargetState().getName().equals(currAccepting) && t.getOutput().equals("bot")) {
				Transition newT = MealymodelFactory.eINSTANCE.createTransition();
				State newS = MealymodelFactory.eINSTANCE.createState();
				newS.setName(t.getSourceState().getName());				
				State newS2 = MealymodelFactory.eINSTANCE.createState();
				newS2.setName(t.getTargetState().getName());
				newT.setSourceState(newS);
				newT.setTargetState(newS2);
				newT.setInput(t.getInput());
				newT.setOutput("top");
				ret.getTransitions().add(newT);
			}else if(t.getSourceState().getName().equals(currAccepting) && t.getTargetState().getName().equals("q0")){
				
			}else {
				Transition newT = MealymodelFactory.eINSTANCE.createTransition();
				State newS = MealymodelFactory.eINSTANCE.createState();
				newS.setName(t.getSourceState().getName());				
				State newS2 = MealymodelFactory.eINSTANCE.createState();
				newS2.setName(t.getTargetState().getName());
				newT.setSourceState(newS);
				newT.setTargetState(newS2);
				newT.setInput(t.getInput());
				newT.setOutput(t.getOutput());
				ret.getTransitions().add(newT);
			}
		}
		Transition newT = MealymodelFactory.eINSTANCE.createTransition();
		State newS = MealymodelFactory.eINSTANCE.createState();
		newS.setName(currAccepting);				
		State newS2 = MealymodelFactory.eINSTANCE.createState();
		newS2.setName("q" + (4+counter));
		newT.setSourceState(newS);
		newT.setTargetState(newS2);
		newT.setInput("a");
		newT.setOutput("bot");
		ret.getTransitions().add(newT);
		
		Transition newT2 = MealymodelFactory.eINSTANCE.createTransition();
		State newS3 = MealymodelFactory.eINSTANCE.createState();
		newS3.setName("q" + (4+counter));				
		State newS4 = MealymodelFactory.eINSTANCE.createState();
		newS4.setName("q" + (4+counter));
		newT2.setSourceState(newS3);
		newT2.setTargetState(newS4);
		newT2.setInput("b");
		newT2.setOutput("bot");
		ret.getTransitions().add(newT2);
		
		Transition newT3 = MealymodelFactory.eINSTANCE.createTransition();
		State newS5 = MealymodelFactory.eINSTANCE.createState();
		newS5.setName("q" + (4+counter));				
		State newS6 = MealymodelFactory.eINSTANCE.createState();
		newS6.setName("q0");
		newT3.setSourceState(newS5);
		newT3.setTargetState(newS6);
		newT3.setInput("a");
		newT3.setOutput("top");
		ret.getTransitions().add(newT3);
		
		return ret;
	}
	
	public static MealyMachine incrementEvaluationAlphabet(MealyMachine m, String currAccepting, int counter) {
		MealyMachine ret = MealymodelFactory.eINSTANCE.createMealyMachine();
		Alphabet in = MealymodelFactory.eINSTANCE.createAlphabet();
		in.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		in.getCharacters().add(String.valueOf(((char)('c'+counter))));
		ret.setInputAlphabet(in);
		
		State init = MealymodelFactory.eINSTANCE.createState();
		init.setName(m.getInitialState().getName());
		ret.setInitialState(init);
		for(State s : m.getStates()) {
			State newS = MealymodelFactory.eINSTANCE.createState();
			newS.setName(s.getName());
			ret.getStates().add(newS);
			Transition newT3 = MealymodelFactory.eINSTANCE.createTransition();
			State newS5 = MealymodelFactory.eINSTANCE.createState();
			newS5.setName(s.getName());				
			State newS6 = MealymodelFactory.eINSTANCE.createState();
			newS6.setName(s.getName());
			newT3.setSourceState(newS5);
			newT3.setTargetState(newS6);
			newT3.setInput(String.valueOf(((char)('c'+counter))));
			newT3.setOutput("top");
			ret.getTransitions().add(newT3);
		}
		for(Transition t : m.getTransitions()) {
			Transition newT = MealymodelFactory.eINSTANCE.createTransition();
			State newS = MealymodelFactory.eINSTANCE.createState();
			newS.setName(t.getSourceState().getName());				
			State newS2 = MealymodelFactory.eINSTANCE.createState();
			newS2.setName(t.getTargetState().getName());
			newT.setSourceState(newS);
			newT.setTargetState(newS2);
			newT.setInput(t.getInput());
			newT.setOutput(t.getOutput());
			ret.getTransitions().add(newT);
		}
		return ret;
	}
	
}