package hu.bme.mit.automatalearning.algorithm.TTT;

import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.base.TTTTransition;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import net.automatalib.words.Word;

//Can be used to construct hypo during TTT learning, not currently used.

public class TTTStateMealyEMF extends TTTState<String, Word<String>>{
	
	MealyMachine hypo;
	
	State mealyState;

	public TTTStateMealyEMF(int initialAlphabetSize, TTTTransition<String, Word<String>> parentTransition, int id, MealyMachine hypo) {
		super(initialAlphabetSize, parentTransition, id);
		/*this.hypo = hypo;
		if(!hypo.getStates().parallelStream().anyMatch(s -> s.getName().contentEquals(super.toString()))) {
			mealyState = MealeymodelFactory.eINSTANCE.createState();
			mealyState.setName(super.toString());
			hypo.getStates().add(mealyState);
		}else {
			mealyState = hypo.getStates().parallelStream().filter(s -> s.getName().contentEquals(super.toString())).findAny().get();
		}
		if(parentTransition != null) {
			((TTTTransitionMealyEMF) parentTransition).getMealyTransition().setTargetState(mealyState);
		}else {
			
		}*/
	}
	public State getMealyState() {
		return mealyState;
	}
	
	
}
