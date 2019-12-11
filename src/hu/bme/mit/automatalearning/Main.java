package hu.bme.mit.automatalearning;

import java.util.function.Function;

import de.learnlib.acex.analyzers.AcexAnalyzers;
import de.learnlib.algorithms.ttt.mealy.TTTLearnerMealy;
import de.learnlib.api.algorithm.LearningAlgorithm.MealyLearner;
import de.learnlib.api.logging.LoggingPropertyOracle;
import de.learnlib.api.oracle.LassoEmptinessOracle;
import de.learnlib.api.oracle.PropertyOracle;
import de.learnlib.api.oracle.EquivalenceOracle.MealyEquivalenceOracle;
import de.learnlib.api.oracle.InclusionOracle.MealyInclusionOracle;
import de.learnlib.api.oracle.MembershipOracle.MealyMembershipOracle;
import de.learnlib.api.oracle.OmegaMembershipOracle.MealyOmegaMembershipOracle;
import de.learnlib.oracle.emptiness.MealyLassoEmptinessOracleImpl;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import de.learnlib.oracle.membership.SimulatorOmegaOracle.MealySimulatorOmegaOracle;
import de.learnlib.oracle.property.MealyLassoPropertyOracle;
import de.learnlib.util.Experiment;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.adapter.StringSequenceToMealyAdapter;
import hu.bme.mit.automatalearning.adapter.StringSequenceToTTTMealyAdapter;
import hu.bme.mit.automatalearning.algorithm.TTT.TTT;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.MealeyMachineTeacherStringSequenceImpl;
import hu.bme.mit.automatalearning.teacher.TTTMealeyMachineTeacherStringSequenceImpl;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import net.automatalib.automata.transducers.MealyMachine;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.modelcheckers.ltsmin.ltl.LTSminLTLIOBuilder;
import net.automatalib.modelchecking.ModelCheckerLasso.MealyModelCheckerLasso;
import net.automatalib.util.automata.builders.AutomatonBuilders;
import net.automatalib.util.automata.equivalence.DeterministicEquivalenceTest;
import net.automatalib.words.Alphabet;
import net.automatalib.words.Word;
import net.automatalib.words.impl.Alphabets;


public class Main {

	public static void main(String[] args) {
		/*MealeyMachine m = MealyModelReader.getMealeyModelFromXtext();
		Teacher<String, String, MealyMachineHypothesis> teacher = new MealeyMachineTeacherStringSequenceImpl(new StringSequenceToMealeyAdapter(new MealyLearnable(m)));
		
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		MealyMachineHypothesis hypo = new MealyMachineHypothesis(inputAlphabet);
		DirectHypothesisConstructionMealy dhc = new DirectHypothesisConstructionMealy(teacher, m.getInputAlphabet().getCharacters());
		
		MealyMachineHypothesis h = dhc.execute();
		
		MealyModelReader.output(h.getAutomaton());*/
		//alternatingbit();
		
		MealeyMachine m = MealyModelReader.getMealeyModelFromXtext();
		Teacher<String, String, TTTHypothesisMealyEMF, StringSequenceToTTTMealyAdapter> teacher = new TTTMealeyMachineTeacherStringSequenceImpl(new StringSequenceToTTTMealyAdapter(new MealyLearnable(m)));
		hu.bme.mit.mealeymodel.Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		TTT algo = new TTT(teacher, inputAlphabet.getCharacters());
		MealeyMachine ma = algo.execute();
		MealyModelReader.output(ma);
		
		/*CompactMealy<String, String> le = AutomatonBuilders.forMealy(new CompactMealy<String, String>(Alphabets.fromCollection(m.getInputAlphabet().getCharacters())))
	            .withInitial("a")
	            .from("a")
	                .on("water").withOutput("done").to("c")
	                .on("pod").withOutput("done").to("b")
	                .on("button").withOutput("none").to("f")
	                .on("clean").withOutput("done").loop()
	            .from("b")
	                .on("water").withOutput("done").to("d")
	                .on("pod").withOutput("done").loop()
	                .on("button").withOutput("none").to("f")
	                .on("clean").withOutput("done").to("a")
	            .from("c")
	                .on("water").withOutput("done").loop()
	                .on("pod").withOutput("done").to("d")
	                .on("button").withOutput("none").to("f")
	                .on("clean").withOutput("done").to("a")
	            .from("d")
	                .on("water", "pod").withOutput("done").loop()
	                .on("button").withOutput("coffee").to("e")
	                .on("clean").withOutput("done").to("a")
	            .from("e")
	                .on("water", "pod", "button").withOutput("none").to("f")
	                .on("clean").withOutput("done").to("a")
	            .from("f")
	                .on("water", "pod", "button", "clean").withOutput("none").loop()
	            .create();*/
		

        /*// define the alphabet
        Alphabet<String> sigma = le.getInputAlphabet();

        // define the Mealy machine to be verified/learned
        MealyMachine<?, String, ?, String> mealy = le;

        // create an omega membership oracle
        MealyOmegaMembershipOracle<?, String, String> omqOracle = new MealySimulatorOmegaOracle<>(mealy);

        // create a regular membership oracle
        MealyMembershipOracle<String, String> mqOracle = omqOracle.getMembershipOracle();

        // create a learner
        MealyLearner<String, String> learner = new TTTLearnerMealy<>(sigma, mqOracle, AcexAnalyzers.LINEAR_FWD);

        

      

        // create an equivalence oracle, that first searches for a counter example using the ltl properties, and next
        // with the W-method.
        @SuppressWarnings("unchecked")
        SimulatorEQOracle<String, Word<String>> eqOracle = new SimulatorEQOracle<>(mealy);

        // create an experiment
        Experiment.MealyExperiment<String, String> experiment = new Experiment.MealyExperiment<>(learner, eqOracle, sigma);

        // run the experiment
        experiment.run();

        // get the final result
        MealyMachine<?, String, ?, ?> result = experiment.getFinalHypothesis();
        
        Word<String> a = DeterministicEquivalenceTest.findSeparatingWord(mealy, result, sigma);*/
        
	}
	public static final Function<String, Character> EDGE_PARSER = s -> s.charAt(0);
	
	public static void alternatingbit() {
		/*String sequence = 
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
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().add("null");
		inputAlphabet.getCharacters().add("ack0");
		inputAlphabet.getCharacters().add("ack1");
		Teacher<String, String, MealyMachineHypothesis> teacher = new MealeyMachineTeacherStringSequenceImpl(new StringSequenceToMealyAdapter(new StringSequenceLearnable(sequence)));
		MealyMachineHypothesis hypo = new MealyMachineHypothesis(inputAlphabet);
		DirectHypothesisConstructionMealy dhc = new DirectHypothesisConstructionMealy(teacher, inputAlphabet.getCharacters());
		
		MealyMachineHypothesis h = dhc.execute();
		
		MealyModelReader.output(h.getAutomaton());*/
	}
	
}