package hu.bme.mit.automatalearning;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import hu.bme.mit.automatalearning.Learnable.GenericPartialModel;
import hu.bme.mit.automatalearning.Learnable.InteractiveLearnable;
import hu.bme.mit.automatalearning.Learnable.InteractiveMemoizingLearnable;
import hu.bme.mit.automatalearning.Learnable.LPTLearnable;
import hu.bme.mit.automatalearning.Learnable.Learnable;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.Learnable.MemoizingLearnable;
import hu.bme.mit.automatalearning.Learnable.OracleGuidedAdaptiveLearnable;
import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.adapter.AdaptiveLearnableAdapter;
import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.algorithm.TTT.TTT;
import hu.bme.mit.automatalearning.algorithm.dhc.AdaptiveDirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.algorithm.dhc.InitializableAdaptiveDirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.algorithm.lstar.IALStarM;
import hu.bme.mit.automatalearning.algorithm.lstar.LStarMealy;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy.QueueElement;
import hu.bme.mit.automatalearning.algorithm.dhc.IADHCM;
import hu.bme.mit.automatalearning.datastructures.LPT;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTLoopedNode;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTRootNode;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTUnloopedNode;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.hypothesis.InitializableDHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.AdaptiveTeacher;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.ui.InteractiveCLI;
import hu.bme.mit.automatalearning.ui.InteractiveUI;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;


public class Main {

	public static void main(String[] args) throws Exception{
		//EXAMPLES. AFTER EVERY DESCRIPTION THERE IS A METHOD TO UNCOMMENT TO RUN SAID EXAMPLE.
		
			//Alternating bit protocol in the form of a String input formalism, learned by DHC, outputs to /learnedmachine.mealy
		//alternatingbitDHC();
		
			//Alternating bit protocol in the form of a String input formalism, learned by TTT, outputs to /learnedmachine.mealy
		//alternatingbitTTT();
		
		//fullyInteractiveComponentLearning();
		
			//Coffee machine Mealy machine using Xtext input formalism, learned by DHC, outputs to /learnedmachine.mealy
		//coffeeMealyDHC();
		
		//coffeeMealyAdaptiveDHC();
		
		// TODO clean up cache initialization
		//cacheInitializedCoffeeMealyDHC();
		// TODO clean up DHC initialization
		//dhcPseudoInitializedCoffeeMealyDHC();
		//dhcInitializedCoffeeMealyDHC();
		//dhcInitializedCoffeeMealyDHC2();
		//dhcInitializedCoffeeMealyDHC3();
		// TODO clean up L* initialization
		//coffeeMealyLStar();
		lStarInitializedCoffeeMealyDHC();
		
			//Coffee machine Mealy machine using Xtext input formalism, learned by TTT, outputs to /learnedmachine.mealy
		//coffeeMealyTTT();
		
			//4i-3a accepting Mealy machine using Xtext, learned by DHC, otputs to /learnedmachine.mealy
		//fouriaMealyDHC();
		
			//4i-3a accepting Mealy machine using Xtext, learned by TTT, otputs to /learnedmachine.mealy
		//fouriaMealyTTT();
		
			/* Uses LPT to model the alternating bit protocol */
		//alternatingBitLPTTT();
		
			/* USES LPT to model different components of parity bit error detection */
		//paritybitLPTTTT();
		
		//EXPERIMENTAL EVALUATION METHODS USED IN THE THESIS. ALL OUTPUT TO /src/expeval_results.csv. SHOULD BE STOPPED MANUALLY WHEN A SATISFIABLE AMOUNT OF RESULTS ARE DONE.
		
		//experimentalEvaluationDHCState();
		
		//experimentalEvaluationTTTState();
		
		//experimentalEvaluationDHCAlphabet();
		
		//experimentalEvaluationTTTAlphabet();
	}
	
	public static void lStarInitializedCoffeeMealyDHC() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("none");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		Alphabet ia = MealymodelFactory.eINSTANCE.createAlphabet();
		ia.getCharacters().addAll(inputAlphabet);
		Alphabet oa = MealymodelFactory.eINSTANCE.createAlphabet();
		oa.getCharacters().addAll(outputAlphabet);
		
		List<State> ss = new ArrayList<>();
		List<Transition> ts = new ArrayList<>();
		
		State i = MealymodelFactory.eINSTANCE.createState();
		i.setName("s1");
		State w = MealymodelFactory.eINSTANCE.createState();
		w.setName("s2");
		State p = MealymodelFactory.eINSTANCE.createState();
		p.setName("s3");
		State b = MealymodelFactory.eINSTANCE.createState();
		b.setName("s4");
		ss.add(i);
		ss.add(w);
		ss.add(p);
		ss.add(b);
		Transition iw = MealymodelFactory.eINSTANCE.createTransition();
		iw.setSourceState(i);
		iw.setTargetState(w);
		iw.setInput("water");
		iw.setOutput("done");
		Transition wp = MealymodelFactory.eINSTANCE.createTransition();
		wp.setSourceState(w);
		wp.setTargetState(p);
		wp.setInput("pod");
		wp.setOutput("done");
		Transition pb = MealymodelFactory.eINSTANCE.createTransition();
		pb.setSourceState(p);
		pb.setTargetState(b);
		pb.setInput("button");
		pb.setOutput("coffee");
		Transition bi = MealymodelFactory.eINSTANCE.createTransition();
		bi.setSourceState(b);
		bi.setTargetState(i);
		bi.setInput("clean");
		bi.setOutput("done");
		ts.add(iw);
		ts.add(wp);
		ts.add(pb);
		ts.add(bi);
		
		InitializableDHCHypothesisMealy hyp = new InitializableDHCHypothesisMealy(ia, oa, i, ss, ts);
		
		Deque<QueueElement<String, String, State>> dek = new ArrayDeque<>();
		
		QueueElement<String, String, State> iq = new QueueElement<String, String, State>(null, null, null, null);
		dek.add(iq);
		QueueElement<String, String, State> wq = new QueueElement<String, String, State>(i, iq, "water", "done");
		dek.add(wq);
		
		IALStarM<String, String> lstar = 
				new IALStarM<>(teacher, inputAlphabet,  hyp, new DHCHypothesisMealy(ia));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = lstar.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);
	}
	
	public static void coffeeMealyLStar() throws IOException {
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		
		
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
		
		LStarMealy<String, String> lstar = 
				new LStarMealy<>(teacher, 
						m.getInputAlphabet().getCharacters(), 
						new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = lstar.execute();
		
		Utils.output(h.getHypothesis());
		Utils.visualizeEQ((Hypothesis<String, String, MealyMachine, State, Transition>) h);

	}
	
	public static void dhcPseudoInitializedCoffeeMealyDHC() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("none");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		Alphabet ia = MealymodelFactory.eINSTANCE.createAlphabet();
		ia.getCharacters().addAll(inputAlphabet);
		Alphabet oa = MealymodelFactory.eINSTANCE.createAlphabet();
		oa.getCharacters().addAll(outputAlphabet);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> hyp = new InitializableDHCHypothesisMealy(ia);
		
		IADHCM<String, String> dhc = 
				new IADHCM<String, String>(teacher, inputAlphabet, hyp);
		
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);

	}
	
	
	public static void dhcInitializedCoffeeMealyDHC3() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("none");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		Alphabet ia = MealymodelFactory.eINSTANCE.createAlphabet();
		ia.getCharacters().addAll(inputAlphabet);
		Alphabet oa = MealymodelFactory.eINSTANCE.createAlphabet();
		oa.getCharacters().addAll(outputAlphabet);
		
		List<State> ss = new ArrayList<>();
		List<Transition> ts = new ArrayList<>();
		
		State i = MealymodelFactory.eINSTANCE.createState();
		i.setName("s1");
		State w1 = MealymodelFactory.eINSTANCE.createState();
		w1.setName("w1");
		State w2 = MealymodelFactory.eINSTANCE.createState();
		w2.setName("w2");
		State p1 = MealymodelFactory.eINSTANCE.createState();
		p1.setName("p1");
		State p2 = MealymodelFactory.eINSTANCE.createState();
		p2.setName("p2");
		State b = MealymodelFactory.eINSTANCE.createState();
		b.setName("b");
		ss.add(i);
		ss.add(w1);
		ss.add(w2);
		ss.add(p1);
		ss.add(p2);
		ss.add(b);
		Transition iw1 = MealymodelFactory.eINSTANCE.createTransition();
		iw1.setSourceState(i);
		iw1.setTargetState(w1);
		iw1.setInput("water");
		iw1.setOutput("done");
		Transition w1w2 = MealymodelFactory.eINSTANCE.createTransition();
		w1w2.setSourceState(w1);
		w1w2.setTargetState(w2);
		w1w2.setInput("pod");
		w1w2.setOutput("done");
		Transition ip1 = MealymodelFactory.eINSTANCE.createTransition();
		ip1.setSourceState(i);
		ip1.setTargetState(p1);
		ip1.setInput("pod");
		ip1.setOutput("done");
		Transition p1p2 = MealymodelFactory.eINSTANCE.createTransition();
		p1p2.setSourceState(p1);
		p1p2.setTargetState(p2);
		p1p2.setInput("water");
		p1p2.setOutput("done");
		Transition w2b = MealymodelFactory.eINSTANCE.createTransition();
		w2b.setSourceState(w2);
		w2b.setTargetState(b);
		w2b.setInput("button");
		w2b.setOutput("coffee");
		Transition p2b = MealymodelFactory.eINSTANCE.createTransition();
		p2b.setSourceState(p2);
		p2b.setTargetState(b);
		p2b.setInput("button");
		p2b.setOutput("coffee");
		Transition bi = MealymodelFactory.eINSTANCE.createTransition();
		bi.setSourceState(b);
		bi.setTargetState(i);
		bi.setInput("clean");
		bi.setOutput("done");
		
		ts.add(iw1);
		ts.add(w1w2);
		ts.add(ip1);
		ts.add(p1p2);
		ts.add(w2b);
		ts.add(p2b);
		ts.add(bi);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> hyp = new InitializableDHCHypothesisMealy(ia, oa, i, ss, ts);
		
		Deque<QueueElement<String, String, State>> dek = new ArrayDeque<>();
		
		QueueElement<String, String, State> iq = new QueueElement<String, String, State>(null, null, null, null);
		dek.add(iq);
		QueueElement<String, String, State> wq = new QueueElement<String, String, State>(i, iq, "water", "done");
		dek.add(wq);
		
		IADHCM<String, String> dhc = 
				new IADHCM<>(teacher, inputAlphabet,  hyp);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);
	}
	
	public static void dhcInitializedCoffeeMealyDHC2() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("none");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		Alphabet ia = MealymodelFactory.eINSTANCE.createAlphabet();
		ia.getCharacters().addAll(inputAlphabet);
		Alphabet oa = MealymodelFactory.eINSTANCE.createAlphabet();
		oa.getCharacters().addAll(outputAlphabet);
		
		List<State> ss = new ArrayList<>();
		List<Transition> ts = new ArrayList<>();
		
		State i = MealymodelFactory.eINSTANCE.createState();
		i.setName("s1");
		State w = MealymodelFactory.eINSTANCE.createState();
		w.setName("s2");
		State p = MealymodelFactory.eINSTANCE.createState();
		p.setName("s3");
		State b = MealymodelFactory.eINSTANCE.createState();
		b.setName("s4");
		ss.add(i);
		ss.add(w);
		ss.add(p);
		ss.add(b);
		Transition iw = MealymodelFactory.eINSTANCE.createTransition();
		iw.setSourceState(i);
		iw.setTargetState(w);
		iw.setInput("water");
		iw.setOutput("done");
		Transition wp = MealymodelFactory.eINSTANCE.createTransition();
		wp.setSourceState(w);
		wp.setTargetState(p);
		wp.setInput("pod");
		wp.setOutput("done");
		Transition pb = MealymodelFactory.eINSTANCE.createTransition();
		pb.setSourceState(p);
		pb.setTargetState(b);
		pb.setInput("button");
		pb.setOutput("coffee");
		Transition bi = MealymodelFactory.eINSTANCE.createTransition();
		bi.setSourceState(b);
		bi.setTargetState(i);
		bi.setInput("clean");
		bi.setOutput("done");
		ts.add(iw);
		ts.add(wp);
		ts.add(pb);
		ts.add(bi);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> hyp = new InitializableDHCHypothesisMealy(ia, oa, i, ss, ts);
		
		Deque<QueueElement<String, String, State>> dek = new ArrayDeque<>();
		
		QueueElement<String, String, State> iq = new QueueElement<String, String, State>(null, null, null, null);
		dek.add(iq);
		QueueElement<String, String, State> wq = new QueueElement<String, String, State>(i, iq, "water", "done");
		dek.add(wq);
		
		IADHCM<String, String> dhc = 
				new IADHCM<>(teacher, inputAlphabet,  hyp);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);
	}
	
	public static void dhcInitializedCoffeeMealyDHC() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("none");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		Alphabet ia = MealymodelFactory.eINSTANCE.createAlphabet();
		ia.getCharacters().addAll(inputAlphabet);
		Alphabet oa = MealymodelFactory.eINSTANCE.createAlphabet();
		oa.getCharacters().addAll(outputAlphabet);
		
		List<State> ss = new ArrayList<>();
		List<Transition> ts = new ArrayList<>();

		State i = MealymodelFactory.eINSTANCE.createState();
		i.setName("s1");
		ss.add(i);
		State w = MealymodelFactory.eINSTANCE.createState();
		w.setName("s2");
		ss.add(w);
		
		Transition iw = MealymodelFactory.eINSTANCE.createTransition();
		iw.setSourceState(i);
		iw.setTargetState(w);
		iw.setInput("water");
		iw.setOutput("done");
		ts.add(iw);
		Transition wi = MealymodelFactory.eINSTANCE.createTransition();
		wi.setSourceState(w);
		wi.setTargetState(i);
		wi.setInput("clean");
		wi.setOutput("done");
		ts.add(wi);
		
		/*State i = MealymodelFactory.eINSTANCE.createState();
		i.setName("state0");
		State w = MealymodelFactory.eINSTANCE.createState();
		w.setName("state1");
		State p = MealymodelFactory.eINSTANCE.createState();
		p.setName("state3");
		State b = MealymodelFactory.eINSTANCE.createState();
		b.setName("state4");
		List<State> ss = new ArrayList<>();
		ss.add(i);
		ss.add(w);
		ss.add(p);
		ss.add(b);
		Transition iw = MealymodelFactory.eINSTANCE.createTransition();
		iw.setSourceState(i);
		iw.setTargetState(w);
		iw.setInput("water");
		iw.setOutput("done");
		Transition wp = MealymodelFactory.eINSTANCE.createTransition();
		wp.setSourceState(w);
		wp.setTargetState(p);
		wp.setInput("pod");
		wp.setOutput("done");
		Transition pb = MealymodelFactory.eINSTANCE.createTransition();
		pb.setSourceState(p);
		pb.setTargetState(b);
		pb.setInput("button");
		pb.setOutput("coffee");
		Transition bi = MealymodelFactory.eINSTANCE.createTransition();
		bi.setSourceState(b);
		bi.setTargetState(i);
		bi.setInput("clean");
		bi.setOutput("done");
		ts.add(iw);
		ts.add(wp);
		ts.add(pb);
		ts.add(bi);*/
		DHCHypothesis<String, String, MealyMachine, State, Transition> hyp = new InitializableDHCHypothesisMealy(ia, oa, i, ss, ts);
		
		Deque<QueueElement<String, String, State>> dek = new ArrayDeque<>();
		/*QueueElement<String, String, State> iq = new QueueElement<String, String, State>(null, null, null, null);
		dek.add(iq);
		QueueElement<String, String, State> wq = new QueueElement<String, String, State>(i, iq, "water", "done");
		dek.add(wq);
		QueueElement<String, String, State> pq = new QueueElement<String, String, State>(w, wq, "pod", "done");
		dek.add(pq);
		QueueElement<String, String, State> bq = new QueueElement<String, String, State>(p, pq, "button", "coffee");
		dek.add(bq);*/

		QueueElement<String, String, State> iq = new QueueElement<String, String, State>(null, null, null, null);
		dek.add(iq);
		QueueElement<String, String, State> wq = new QueueElement<String, String, State>(i, iq, "water", "done");
		dek.add(wq);
		
		IADHCM<String, String> dhc = 
				new IADHCM<>(teacher, inputAlphabet,  hyp);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);

	}
	
	public static void cacheInitializedCoffeeMealyDHC() throws IOException {
		// Complete automaton to learn
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		MealyLearnable ml = new MealyLearnable(m);
		//
		final List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("water");	//water
		inputAlphabet.add("pod");	//pod
		inputAlphabet.add("button");//button
		inputAlphabet.add("clean");	//clean
		final List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("done");	//done
		outputAlphabet.add("coffee");	//coffee
		outputAlphabet.add("error");	//error
		
		// contains the (cache) initialization automaton
		LPTRootNode<String, String> root = new LPTRootNode<>();
		
		LPTUnloopedNode<String, String> water = new LPTUnloopedNode<>("done");
		Map<String, LPTRootNode<String, String>> waterMap = new HashMap<>();
		waterMap.put("water", water);
		root.setChildren(waterMap);
		
		LPTUnloopedNode<String, String> pod = new LPTUnloopedNode<String, String>("done");
		Map<String, LPTRootNode<String, String>> podMap = new HashMap<>();
		podMap.put("pod", pod);
		water.setChildren(podMap);
		
		LPTUnloopedNode<String, String> button = new LPTUnloopedNode<String, String>("coffee");
		Map<String, LPTRootNode<String, String>> buttonMap = new HashMap<>();
		buttonMap.put("button", button);
		pod.setChildren(buttonMap);
		
		LPTLoopedNode<String, String> clean = new LPTLoopedNode<String, String>(root, "done");
		Map<String, LPTRootNode<String, String>> cleanMap = new HashMap<>();
		cleanMap.put("clean", clean);
		button.setChildren(cleanMap);		
		
		LPT<String, String> init = new LPT<>(root);
		
		
		// returns the outputs of the mealy machine to learn (wrapper for the to-learn)
		GenericPartialModel<String, String> gpm = new GenericPartialModel<String, String>(
				inputAlphabet, 
				outputAlphabet, 
				(inputSequence) -> {
					Set<String> ret = new HashSet<>();
					ret.add(ml.getOutput(inputSequence));
					return ret;
				}, 
				(inputSequence) -> {
					return true;
				}
			);
		//Pseudo-interactive learnable
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveLearnable<String, String, MealyMachine, State, Transition> interactiveLearnable = new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet);
		interactiveLearnable.getPartialModels().add(gpm);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(interactiveLearnable, init);
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		//teacher
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		AdaptiveDirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = 
				new AdaptiveDirectHypothesisConstructionMealy<>(teacher, inputAlphabet,  new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());	
		Utils.visualizeEQ(h);
	}
	
	public static void fullyInteractiveComponentLearning() {
		InteractiveLearning il = new InteractiveLearning();
		il.learn();
	}
	
	/*public static void paritybitLPTTTT() {
		paritybitInputLPTTTT();
		
		paritybitCreateErrLPTTTT();
		
		paritybitDetectorLPTTTT();
	}
	
	public static MealyMachine paritybitInputLPTTTT() {
		LPTLearnable learnable = null;
		try {
			 learnable = new LPTLearnable(
					 new LPT(Utils.getLPT(new File(".").getCanonicalPath() + "/src/main/java/paritymodels/gen-paritybit.lpt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(learnable));
		TTT<String, String, MealyMachine, State, Transition> ttt = 
				new TTT<>(teacher, learnable.getInputAlphabet(), new TTTHypothesisMealyEMF(learnable.getInputAlphabet()));
		
		TTTHypothesis<?,?,MealyMachine,?,?> h = ttt.execute();
		Utils.output(h.getHypothesis(), "paritybit-input.mealy");
		return h.getHypothesis();
	}
	
	public static MealyMachine paritybitCreateErrLPTTTT() {
		LPTLearnable learnable = null;
		try {
			 learnable = new LPTLearnable(
					 new LPT(Utils.getLPT(new File(".").getCanonicalPath() + "/src/main/java/paritymodels/gen-paritybit-createerr.lpt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(learnable));
		TTT<String, String, MealyMachine, State, Transition> ttt = 
				new TTT<>(teacher, learnable.getInputAlphabet(), new TTTHypothesisMealyEMF(learnable.getInputAlphabet()));
		
		TTTHypothesis<?,?,MealyMachine,?,?> h = ttt.execute();
		Utils.output(h.getHypothesis(), "paritybit-createerr.mealy");
		return h.getHypothesis();
	}
	
	public static MealyMachine paritybitDetectorLPTTTT() {
		LPTLearnable learnable = null;
		try {
			 learnable = new LPTLearnable(
					 new LPT(Utils.getLPT(new File(".").getCanonicalPath() + "/src/main/java/paritymodels/gen-paritybit-detector.lpt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(learnable));
		TTT<String, String, MealyMachine, State, Transition> ttt = 
				new TTT<>(teacher, learnable.getInputAlphabet(), new TTTHypothesisMealyEMF(learnable.getInputAlphabet()));
		
		TTTHypothesis<?,?,MealyMachine,?,?> h = ttt.execute();
		Utils.output(h.getHypothesis(), "paritybit-detector.mealy");
		return h.getHypothesis();
	}
	
	public static MealyMachine alternatingBitLPTTT() {
		LPTLearnable learnable = null;
		try {
			 learnable = new LPTLearnable(
					 new LPT(Utils.getLPT(new File(".").getCanonicalPath() + "/src/main/java/gen-alternatingbit.lpt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(learnable));
		TTT<String, String, MealyMachine, State, Transition> ttt = 
				new TTT<>(teacher, learnable.getInputAlphabet(), new TTTHypothesisMealyEMF(learnable.getInputAlphabet()));
		
		TTTHypothesis<?,?,MealyMachine,?,?> h = ttt.execute();
		Utils.output(h.getHypothesis());
		return h.getHypothesis();
	}*/
	
	public static MealyMachine alternatingbitDHC() {
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
		
		Utils.output(h.getHypothesis());
		return h.getHypothesis();
	}
	
	public static MealyMachine alternatingbitTTT() {
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
		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new StringSequenceLearnable(sequence)));
		TTT<String, String, MealyMachine, State, Transition> ttt = 
				new TTT<>(teacher, inputAlphabet.getCharacters(), new TTTHypothesisMealyEMF(inputAlphabet.getCharacters()));
		
		TTTHypothesis<?,?,MealyMachine,?,?> h = ttt.execute();
		
		Utils.output(h.getHypothesis());
		return h.getHypothesis();
	}
	
	/*public static void coffeeMealyDHC() throws IOException {
		MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		
		
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new MemoizingLearnable(new MealyLearnable(m))));
		
		DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = 
				new DirectHypothesisConstructionMealy<>(teacher, m.getInputAlphabet().getCharacters(), new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());
	}*/
	
	public static void coffeeMealyAdaptiveDHC() throws IOException {
		//MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		//
		//Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		//inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("w");	//water
		inputAlphabet.add("p");	//pod
		inputAlphabet.add("b");	//button
		inputAlphabet.add("c");	//clean
		List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("don");	//done
		outputAlphabet.add("cof");	//coffee
		outputAlphabet.add("err");	//error
		
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet));
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		AdaptiveDirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = 
				new AdaptiveDirectHypothesisConstructionMealy<>(teacher, inputAlphabet, new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());
	}
	
	public static void alternatingBitAdaptiveDHC() throws IOException {
		//MealyMachine m = Utils.getMealyModelFromXtext(new File(".").getCanonicalPath() + "/src/main/java/coffeemachine.mealy");
		//
		//Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		//inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		List<String> inputAlphabet = new ArrayList<>();
		inputAlphabet.add("null");	
		inputAlphabet.add("ack0");	
		inputAlphabet.add("ack1");	
		List<String> outputAlphabet = new ArrayList<>();
		outputAlphabet.add("send0");	
		outputAlphabet.add("send1");
		
		InteractiveUI<String, String, MealyMachine, State, Transition> ui = new InteractiveCLI(inputAlphabet, outputAlphabet);
		InteractiveMemoizingLearnable<String, String, ?> l = new InteractiveMemoizingLearnable<>(new InteractiveLearnable<>(ui, inputAlphabet, outputAlphabet));
		OracleGuidedAdaptiveLearnable<String, String> ogal = new OracleGuidedAdaptiveLearnable<String, String>(l);
		AdaptiveLearnableAdapter<String, String,DHCHypothesis<String, String, MealyMachine, State, Transition>,String, String, ?, ?> a = new AdaptiveLearnableAdapter<>(new StringSequenceToMealyAdapter<>(l), ogal);
		
		AdaptiveTeacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?, ?> teacher = 
				new AdaptiveTeacher<>(a);
		
		AdaptiveDirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc = 
				new AdaptiveDirectHypothesisConstructionMealy<>(teacher, inputAlphabet, new DHCHypothesisMealy(inputAlphabet));
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());
	}
	
	public static void coffeeMealyTTT() throws IOException {
		MealyMachine m = Utils.getMealyModelFromXtext("C:\\Users\\Aron\\eclipse-workspace\\automatalearning-proj\\automatalearning\\src\\main\\java\\coffeemachine.mealy");
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());

		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
		
		TTT<String, String, MealyMachine, State, Transition> algo = 
				new TTT<>(teacher, inputAlphabet.getCharacters(), new TTTHypothesisMealyEMF(inputAlphabet.getCharacters()));
		
		TTTHypothesis<String, String, MealyMachine, State, Transition> h = algo.execute();
		
		Utils.output(h.getHypothesis());
	}
	
	public static void fouriaMealyDHC() throws IOException {
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
		
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> hypo = new DHCHypothesisMealy(inputAlphabet);
		Teacher<String, String, DHCHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
		
		DirectHypothesisConstructionMealy<String, String, MealyMachine, State, Transition> dhc =
				new DirectHypothesisConstructionMealy<>(teacher, m.getInputAlphabet().getCharacters(), hypo);
		
		DHCHypothesis<String, String, MealyMachine, State, Transition> h = dhc.execute();
		
		Utils.output(h.getHypothesis());
	}
	
	public static void fouriaMealyTTT() throws IOException {
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
		Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());

		Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
				new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
		
		TTT<String, String, MealyMachine, State, Transition> algo = 
				new TTT<>(teacher, inputAlphabet.getCharacters(), new TTTHypothesisMealyEMF(inputAlphabet.getCharacters()));
		
		TTTHypothesis<String, String, MealyMachine, State, Transition> h = algo.execute();
		
		Utils.output(h.getHypothesis());
	}
	
	public static void experimentalEvaluationDHCState() throws IOException {
		//Read 4ia example
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
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
	
	public static void experimentalEvaluationDHCAlphabet() throws IOException {
		//Read 4ia example
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
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
	
	public static void experimentalEvaluationTTTState() throws IOException {
		//Read 4ia example
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 100000; i++) {
				Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
						new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
				
				Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
				inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
				
				TTT<String, String, MealyMachine, State, Transition> algo = 
						new TTT<>(teacher, inputAlphabet.getCharacters(), new TTTHypothesisMealyEMF(inputAlphabet.getCharacters()));
				
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
	
	public static void experimentalEvaluationTTTAlphabet() throws IOException {
		//Read 4ia example
		MealyMachine m = Utils.getMealyModelFromXtext("./src/4ia.mealy");
		String currAccepting = "q3";
		
		
			for(int i = 0; i < 100000; i++) {
				Teacher<String, String, TTTHypothesis<String, String, MealyMachine, State, Transition>, ?> teacher = 
						new Teacher<>(new StringSequenceToMealyAdapter<>(new MealyLearnable(m)));
				
				Alphabet inputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
				inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
				
				TTT<String, String, MealyMachine, State, Transition> algo = 
						new TTT<>(teacher, inputAlphabet.getCharacters(), new TTTHypothesisMealyEMF(inputAlphabet.getCharacters()));
				
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