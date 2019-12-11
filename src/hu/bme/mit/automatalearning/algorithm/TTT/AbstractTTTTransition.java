package hu.bme.mit.automatalearning.algorithm.TTT;

import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.base.TTTTransition;
import hu.bme.mit.mealeymodel.MealeyMachine;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.Transition;
import net.automatalib.words.Word;

public class AbstractTTTTransition<I, O> extends TTTTransition<I, Word<O>>{
		
	O output;
    public AbstractTTTTransition(TTTState<I, Word<O>> source, I input) {
        super(source, input);
    }

    public O getOutput() {
        return this.output;
    }

    @Override
    public Object getProperty() {
        return output;
    }
}
