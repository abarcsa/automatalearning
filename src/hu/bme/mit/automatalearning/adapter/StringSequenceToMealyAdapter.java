package hu.bme.mit.automatalearning.adapter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.learnlib.api.query.DefaultQuery;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.Learnable.StringSequenceLearnable;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.words.Word;
import net.automatalib.words.impl.Alphabets;

public class StringSequenceToMealyAdapter<H extends Hypothesis<String, String, MealyMachine, State, Transition>> extends StringSequenceAdapter<String, String, H>{

	public StringSequenceToMealyAdapter(StringSequenceLearnable learnable) {
		this.learnable = learnable;
	}
	
	@Override
	public String convertLearnableInput(String input) {
		return input;
	}

	@Override
	public String convertHypothesisInput(String input) {
		return input;
	}

	@Override
	public String convertLearnableOutput(String output) {
		return output;
	}

	@Override
	public String convertHypothesisOutput(String output) {
		return output;
	}

//Override creating optimization for Mealy-based learning. StringSequences are delegated to the unoptimized version in the superclass, since they are usually small and deterministic in description.
	@Override
	public List<? extends String> equivalenceQuery(H hypothesis, Collection<? extends String> alphabet) {
		if(!(this.learnable instanceof MealyLearnable)) return super.equivalenceQuery(hypothesis, alphabet);
		DefaultQuery<String, Word<String>> retval = new SimulatorEQOracle<>(getMealy(((MealyLearnable)(this.learnable)).automaton)).findCounterExample(getMealy(((DHCHypothesisMealy)hypothesis).getAutomaton()), (Collection<? extends String>) alphabet);
		if(retval == null) return null;
		return retval.getInput().asList();
	}
	private CompactMealy<String, String> getMealy(MealyMachine automaton){
		Map<String, Integer> states = new HashMap<>();
		CompactMealy<String, String> ret = new CompactMealy<String, String>(Alphabets.fromCollection(automaton.getInputAlphabet().getCharacters()));
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


}
