package hu.bme.mit.automatalearning.algorithm.TTT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import de.learnlib.api.oracle.MembershipOracle.MealyMembershipOracle;
import de.learnlib.api.oracle.OmegaMembershipOracle.MealyOmegaMembershipOracle;
import de.learnlib.api.query.DefaultQuery;
import de.learnlib.api.query.Query;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import de.learnlib.util.Experiment;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.mealymodel.Alphabet;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.util.automata.builders.AutomatonBuilders;
import net.automatalib.words.Word;
import net.automatalib.words.WordBuilder;
import net.automatalib.words.impl.Alphabets;
import de.learnlib.oracle.membership.SimulatorOmegaOracle.MealySimulatorOmegaOracle;
import de.learnlib.api.oracle.EquivalenceOracle;
import de.learnlib.api.oracle.MembershipOracle;

public class TTT<M, S, T, H extends TTTHypothesis<String, String, M, S, T>> extends ActiveLearningAlgorithm<String, String, TTTHypothesis<String, String, M, S, T>>{
	
	Collection<? extends String> alphabet;
	Teacher<String, String, H, ?> teacher;
	
	public TTT(Teacher<String, String, H, ?> teacher, Collection<? extends String> alphabet) {
		this.teacher = teacher;
		this.alphabet = alphabet;
	}

	public TTTHypothesis<String, String, M, S, T> execute() {
		
		
		CompactMealy<String, String> le = getMealy();
		
		
		
		// create an omega membership oracle
        MealyOmegaMembershipOracle<?, String, String> omqOracle = new MealySimulatorOmegaOracle<>(le);

        // create a regular membership oracle
        MealyMembershipOracle<String, String> mqOracle = omqOracle.getMembershipOracle();
        
        //MembershipOracleWrapper oracle = new MembershipOracleWrapper(teacher);
        
        SimulatorEQOracle<String, Word<String>> eqOracle2 = new SimulatorEQOracle<>(le);
        
        //EquivalenceOracleWrapper eqOracle = new EquivalenceOracleWrapper((Teacher<String, String, TTTHypothesisMealyEMF, ?>)teacher, le, eqOracle2);
        
        TTTHypothesisMealyEMF hypo = new TTTHypothesisMealyEMF(Alphabets.fromCollection(alphabet),initMealyMachine());
        
        TTTLearner<String, String> learner = new TTTLearner<String, String>(Alphabets.fromCollection(alphabet), mqOracle, hypo);

        // create an experiment
        Experiment.MealyExperiment<String, String> experiment = new Experiment.MealyExperiment<>(learner, eqOracle2, Alphabets.fromCollection(alphabet));

        // run the experiment
        experiment.run();
		
		
		return ((TTTHypothesis<String, String, M, S, T>)learner.getHypothesisModel());
	}
	
	private static class MembershipOracleWrapper implements MembershipOracle<String, Word<String>>{
		
		Teacher<String, String, TTTHypothesisMealyEMF, ?> teacher;
		
		public MembershipOracleWrapper(Teacher<String, String, TTTHypothesisMealyEMF, ?> teacher) {
			this.teacher = teacher;
		}

		@Override
		public void processQueries(Collection<? extends Query<String, Word<String>>> queries) {
			for(Query<String, Word<String>> q : queries) {
				List<String> w = q.getInput().asList();
				WordBuilder<String> wb = new WordBuilder<>();
				wb.append(teacher.membershipQuery(q.getInput().asList()));
				q.answer(wb.toWord());
			}
		}
		
	}
	
	public static class EquivalenceOracleWrapper extends SimulatorEQOracle<String, Word<String>>{
		
		Teacher<String, String, TTTHypothesisMealyEMF, ?> teacher;
		CompactMealy<String, String> reference;
		SimulatorEQOracle<String, Word<String>> eqOracle;
		public static int num_queries;
		public static List<TTTHypothesisMealyEMF> listofShame;
		
		public EquivalenceOracleWrapper(Teacher<String, String, TTTHypothesisMealyEMF, ?> teacher, CompactMealy<String, String> reference, SimulatorEQOracle<String, Word<String>> eqOracle) {
			super(reference);
			this.teacher = teacher;
			this.reference = reference;
			this.eqOracle = eqOracle;
			num_queries = 0;
			listofShame = new ArrayList<>();
		}

		@Override
		public DefaultQuery<String, Word<String>> findCounterExample(UniversalDeterministicAutomaton<?, String, ?, ?, ?> hypothesis,
				Collection<? extends String> inputs) {
			WordBuilder<String> wb = new WordBuilder<>();
			//DefaultQuery<String, Word<String>> ret = super.findCounterExample(hypothesis, inputs);
			List<? extends String> ce = this.teacher.equivalenceQuery((TTTHypothesisMealyEMF)hypothesis, inputs);
			if(ce == null) return null;
			wb.append(ce);
			DefaultQuery<String, Word<String>> ret = new DefaultQuery<>(wb.toWord());
			ret.answer(reference.computeOutput(wb.toWord()));
			/*listofShame.add((TTTHypothesisMealyEMF)hypothesis);
			num_queries++;*/
			return ret;
		}
		
	}
	
	CompactMealy<String, String> getMealy(){
		Map<String, Integer> states = new HashMap<>();
		CompactMealy<String, String> ret = new CompactMealy<String, String>(Alphabets.fromCollection(alphabet));
		MealyMachine automaton = ((MealyLearnable)this.teacher.adapter.getLearnable()).automaton;
		states.put(automaton.getInitialState().getName(), ret.addInitialState());
		for(State s : automaton.getStates()) {
			if(!automaton.getInitialState().getName().equals(s.getName())) {
				states.put(s.getName(), ret.addState());
			}
		}
		for(Transition t : automaton.getTransitions()) {
			ret.setTransition(states.get(t.getSourceState().getName()), t.getInput(), states.get(t.getTargetState().getName()), t.getOutput());
		}
		return ret;
	}
	
	
	
	private MealyMachine initMealyMachine() {
		MealyMachine m = MealymodelFactory.eINSTANCE.createMealyMachine();
		Alphabet a = MealymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(alphabet);
		m.setInputAlphabet(a);
		Alphabet outputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		m.setOutputAlphabet(outputAlphabet);
		
		return m;
	}

}
