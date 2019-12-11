package hu.bme.mit.automatalearning.algorithm.TTT;

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
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import hu.bme.mit.automatalearning.teacher.MealeyMachineTeacherStringSequenceImpl;
import hu.bme.mit.automatalearning.teacher.TTTMealeyMachineTeacherStringSequenceImpl;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.Transition;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.util.automata.builders.AutomatonBuilders;
import net.automatalib.words.Word;
import net.automatalib.words.WordBuilder;
import net.automatalib.words.impl.Alphabets;
import de.learnlib.oracle.membership.SimulatorOmegaOracle.MealySimulatorOmegaOracle;
import de.learnlib.api.oracle.EquivalenceOracle;
import de.learnlib.api.oracle.MembershipOracle;

public class TTT<M, S, T, H extends TTTHypothesis<String, String, M, S, T>> {
	
	Collection<? extends String> alphabet;
	Teacher<String, String, H, ?> teacher;
	
	public TTT(Teacher<String, String, H, ?> teacher, Collection<? extends String> alphabet) {
		this.teacher = teacher;
		this.alphabet = alphabet;
	}

	public MealeyMachine execute() {
		
		
		CompactMealy<String, String> le = getMealy();
		
		
		
		// create an omega membership oracle
        MealyOmegaMembershipOracle<?, String, String> omqOracle = new MealySimulatorOmegaOracle<>(le);

        // create a regular membership oracle
        MealyMembershipOracle<String, String> mqOracle = omqOracle.getMembershipOracle();
        
        //MembershipOracleWrapper oracle = new MembershipOracleWrapper(teacher);
        
        SimulatorEQOracle<String, Word<String>> eqOracle = new SimulatorEQOracle<>(le);
        
        //EquivalenceOracleWrapper eqOracle = new EquivalenceOracleWrapper((TTTMealeyMachineTeacherStringSequenceImpl)teacher);
        
        TTTHypothesisMealyEMF hypo = new TTTHypothesisMealyEMF(Alphabets.fromCollection(alphabet),initMealyMachine());
        
        TTTLearner<String, String> learner = new TTTLearner<String, String>(Alphabets.fromCollection(alphabet), mqOracle, hypo);

        // create an experiment
        Experiment.MealyExperiment<String, String> experiment = new Experiment.MealyExperiment<>(learner, eqOracle, Alphabets.fromCollection(alphabet));

        // run the experiment
        experiment.run();
		
		MealeyMachine r = ((TTTHypothesisMealyEMF)learner.getHypothesisModel()).getHypothesis();
		
		return r;
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
	
	private static class EquivalenceOracleWrapper implements EquivalenceOracle<UniversalDeterministicAutomaton<?, String, ?, ?, ?>, String, Word<String>>{
		
		TTTMealeyMachineTeacherStringSequenceImpl teacher;
		CompactMealy<String, String> reference;
		
		public EquivalenceOracleWrapper(TTTMealeyMachineTeacherStringSequenceImpl teacher, CompactMealy<String, String> reference) {
			this.teacher = teacher;
			this.reference = reference;
		}

		@Override
		public DefaultQuery<String, Word<String>> findCounterExample(UniversalDeterministicAutomaton<?, String, ?, ?, ?> hypothesis,
				Collection<? extends String> inputs) {
			WordBuilder<String> wb = new WordBuilder<>();
			List<? extends String> ce = this.teacher.equivalenceQuery((TTTHypothesisMealyEMF)hypothesis, inputs);
			if(ce == null) return null;
			wb.append(ce);
			DefaultQuery<String, Word<String>> ret = new DefaultQuery<>(wb.toWord(), reference.computeOutput(wb.toWord()));
			return ret;
		}
		
	}
	
	CompactMealy<String, String> getMealy(){
		Map<String, Integer> states = new HashMap<>();
		CompactMealy<String, String> ret = new CompactMealy<String, String>(Alphabets.fromCollection(alphabet));
		MealeyMachine automaton = ((MealyLearnable)this.teacher.adapter.getLearnable()).automaton;
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
	
	
	
	private MealeyMachine initMealyMachine() {
		MealeyMachine m = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		Alphabet a = MealeymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(alphabet);
		m.setInputAlphabet(a);
		Alphabet outputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		m.setOutputAlphabet(outputAlphabet);
		
		return m;
	}

}
