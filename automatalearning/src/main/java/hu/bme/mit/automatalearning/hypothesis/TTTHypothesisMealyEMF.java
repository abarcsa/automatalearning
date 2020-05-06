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
import hu.bme.mit.automatalearning.algorithm.TTT.TTTTransitionImpl;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.MealymodelFactory;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.UniversalDeterministicAutomaton;
import net.automatalib.words.Alphabet;
import net.automatalib.words.Word;
import net.automatalib.words.impl.Alphabets;


public class TTTHypothesisMealyEMF extends TTTHypothesis<String, String, MealyMachine, State, Transition>{
	
	MealyMachine hypo;
	
	public TTTHypothesisMealyEMF(Collection<? extends String> alphabet) {
		super(Alphabets.fromCollection(alphabet));
		this.hypo = initMealyMachine();
	}

	@Override
    public TTTState<String, Word<String>> getSuccessor(TTTTransitionImpl<String, String> transition) {
        return transition.getTarget();
    }

    @Override
    protected TTTTransitionImpl<String, String> mapTransition(TTTTransition<String, Word<String>> internalTransition) {
        return (TTTTransitionImpl<String, String>) internalTransition;
    }

    @Override
    public UniversalDeterministicAutomaton.FullIntAbstraction<TTTTransitionImpl<String, String>, Void, String> fullIntAbstraction(
            Alphabet<String> alphabet) {
        if (alphabet == this.alphabet) {
            return this;
        }
        return super.fullIntAbstraction(alphabet);
    }

    @Override
    public String getTransitionOutput(TTTTransitionImpl<String, String> transition) {
        return transition.getOutput();
    }


    @Override
    public String getTransitionProperty(TTTTransitionImpl<String, String> transition) {
        return transition.getOutput();
    }

	/*@Override
	public Collection<TTTTransitionImpl<String, String>> getTransitions(TTTState<String, Word<String>> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public Set<TTTState<String, Word<String>>> getInitialStates() {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public TTTState<String, Word<String>> getSuccessor(TTTState<String, Word<String>> arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	/*@Override
	public Void getStateProperty(TTTState<String, Word<String>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public String query(List<String> inputs) {
		if(this.getInitialState() != null) {
			Word<String> out = this.computeOutput(inputs);
			return out.lastSymbol();
			//return new MealyLearnable(convertHypo()).getOutput(inputs);
		}else {
			return new MealyLearnable(this.hypo).getOutput(inputs);
		}
		
	}


	@Override
	public MealyMachine convertHypo() {
		hu.bme.mit.mealymodel.Alphabet a = MealymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(hypo.getInputAlphabet().getCharacters());
		this.hypo = MealymodelFactory.eINSTANCE.createMealyMachine();
		this.hypo.setInputAlphabet(a);
		State i = MealymodelFactory.eINSTANCE.createState();
		i.setName(this.getInitialState().toString());
		hypo.setInitialState(i);
		State i2 = MealymodelFactory.eINSTANCE.createState();
		i2.setName(this.getInitialState().toString());
		hypo.getStates().add(i2);
		for(TTTState<String, Word<String>> s : this.getStates()) {
			if(s == null) continue;
			if(!i.getName().equals(s.toString())) {
				State ss = MealymodelFactory.eINSTANCE.createState();
				ss.setName(s.toString());
				hypo.getStates().add(ss);
			}
			for(TTTTransition<String, Word<String>> t : s.getTransitions()) {
				if(t == null) continue;
				Transition tt = MealymodelFactory.eINSTANCE.createTransition();
				tt.setInput(t.getInput());
				tt.setOutput(((TTTTransitionImpl<String, String>)t).getOutput());
				State sss = MealymodelFactory.eINSTANCE.createState();
				sss.setName(t.getSource().toString());
				State sst = MealymodelFactory.eINSTANCE.createState();
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
	public MealyMachine getHypothesisAutomaton() {
		return convertHypo();
	}
	
	private MealyMachine initMealyMachine() {
		MealyMachine m = MealymodelFactory.eINSTANCE.createMealyMachine();
		hu.bme.mit.mealymodel.Alphabet a = MealymodelFactory.eINSTANCE.createAlphabet();
		a.getCharacters().addAll(alphabet);
		m.setInputAlphabet(a);
		hu.bme.mit.mealymodel.Alphabet outputAlphabet = MealymodelFactory.eINSTANCE.createAlphabet();
		m.setOutputAlphabet(outputAlphabet);
		
		return m;
	}
	

}

