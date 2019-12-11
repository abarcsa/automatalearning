package hu.bme.mit.automatalearning.algorithm.TTT;

import java.util.HashMap;
import java.util.Map;

import de.learnlib.algorithms.ttt.base.AbstractBaseDTNode;
import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.mealy.TTTDTNodeMealy;
import net.automatalib.words.Word;

public class TTTDTNode<I, O> extends AbstractBaseDTNode<I, Word<O>> {

    public TTTDTNode() {
        this(null, null);
    }

    public TTTDTNode(AbstractBaseDTNode<I, Word<O>> parent, Word<O> parentEdgeLabel) {
        super(parent, parentEdgeLabel);
    }


	@Override
	protected AbstractBaseDTNode<I, Word<O>> createChild(Word<O> outcome, TTTState<I, Word<O>> data) {
		return new TTTDTNodeMealy<>(this, outcome);
	}

	@Override
	protected Map<Word<O>, AbstractBaseDTNode<I, Word<O>>> createChildMap() {
		return new HashMap<>();
	}
}
