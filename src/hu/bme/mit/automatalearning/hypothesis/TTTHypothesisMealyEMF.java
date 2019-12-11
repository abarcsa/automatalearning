package hu.bme.mit.automatalearning.hypothesis;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.learnlib.algorithms.ttt.base.AbstractBaseDTNode;
import de.learnlib.algorithms.ttt.base.AbstractTTTHypothesis;
import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.base.TTTTransition;
import de.learnlib.algorithms.ttt.mealy.TTTTransitionMealy;
import hu.bme.mit.automatalearning.Learnable.MealyLearnable;
import hu.bme.mit.automatalearning.algorithm.TTT.TTTStateMealyEMF;
import hu.bme.mit.automatalearning.algorithm.TTT.AbstractTTTTransition;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.Transition;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.automata.transducers.MealyMachine;
import net.automatalib.words.Alphabet;
import net.automatalib.words.Word;


public class TTTHypothesisMealyEMF extends TTTHypothesis<String, String, MealeyMachine, State, Transition>{
	
	MealeyMachine hypo;
	
	public TTTHypothesisMealyEMF(Alphabet<String> alphabet, MealeyMachine hypo) {
		super(alphabet);
		this.hypo = hypo;
	}

	@Override
    public TTTState<String, Word<String>> getSuccessor(AbstractTTTTransition<String, String> transition) {
        return transition.getTarget();
    }

    @Override
    protected AbstractTTTTransition<String, String> mapTransition(TTTTransition<String, Word<String>> internalTransition) {
        return (AbstractTTTTransition<String, String>) internalTransition;
    }

    @Override
    public UniversalDeterministicAutomaton.FullIntAbstraction<AbstractTTTTransition<String, String>, Void, String> fullIntAbstraction(
            Alphabet<String> alphabet) {
        if (alphabet == this.alphabet) {
            return this;
        }
        return super.fullIntAbstraction(alphabet);
    }

    @Override
    public String getTransitionOutput(AbstractTTTTransition<String, String> transition) {
        return transition.getOutput();
    }


    @Override
    public String getTransitionProperty(AbstractTTTTransition<String, String> transition) {
        return transition.getOutput();
    }

	@Override
	public Collection<AbstractTTTTransition<String, String>> getTransitions(TTTState<String, Word<String>> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<TTTState<String, Word<String>>> getInitialStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TTTState<String, Word<String>> getSuccessor(TTTState<String, Word<String>> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void getStateProperty(TTTState<String, Word<String>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String query(List<String> inputs) {
		return new MealyLearnable(convertHypo()).getOutput(inputs);
	}


	@Override
	public MealeyMachine convertHypo() {
		State i = MealeymodelFactory.eINSTANCE.createState();
		i.setName(this.getInitialState().toString());
		hypo.setInitialState(i);
		State i2 = MealeymodelFactory.eINSTANCE.createState();
		i2.setName(this.getInitialState().toString());
		hypo.getStates().add(i2);
		for(TTTState<String, Word<String>> s : this.getStates()) {
			if(s == null) continue;
			if(!i.getName().equals(s.toString())) {
				State ss = MealeymodelFactory.eINSTANCE.createState();
				ss.setName(s.toString());
				hypo.getStates().add(ss);
			}
			for(TTTTransition<String, Word<String>> t : s.getTransitions()) {
				if(t == null) continue;
				Transition tt = MealeymodelFactory.eINSTANCE.createTransition();
				tt.setInput(t.getInput());
				tt.setOutput(((AbstractTTTTransition<String, String>)t).getOutput());
				State sss = MealeymodelFactory.eINSTANCE.createState();
				sss.setName(t.getSource().toString());
				State sst = MealeymodelFactory.eINSTANCE.createState();
				sst.setName(t.getTarget().toString());
				tt.setSourceState(sss);
				tt.setTargetState(sst);
				hypo.getTransitions().add(tt);
			}
		}
		return hypo;
	}

	@Override
	public Void getStateProperty(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<State> getHypothesisStates() {
		return convertHypo().getStates();
	}

	@Override
	public Collection<Transition> getHypothesisTransitions() {
		return convertHypo().getTransitions();
	}

	@Override
	public Collection<String> getHypothesisInputAlphabet() {
		return convertHypo().getInputAlphabet().getCharacters();
	}

	@Override
	public Collection<String> getHypothesisOutputAlphabet() {
		return convertHypo().getOutputAlphabet().getCharacters();
	}

	@Override
	public MealeyMachine getHypothesisAutomaton() {
		return convertHypo();
	}
	

}

