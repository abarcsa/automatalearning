package hu.bme.mit.automatalearning.algorithm.TTT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.learnlib.acex.AcexAnalyzer;
import de.learnlib.acex.analyzers.AcexAnalyzers;
import de.learnlib.algorithms.ttt.base.AbstractBaseDTNode;
import de.learnlib.algorithms.ttt.base.AbstractTTTLearner;
import de.learnlib.algorithms.ttt.base.BaseTTTDiscriminationTree;
import de.learnlib.algorithms.ttt.base.OutputInconsistency;
import de.learnlib.algorithms.ttt.base.TTTState;
import de.learnlib.algorithms.ttt.base.TTTTransition;
import de.learnlib.api.algorithm.LearningAlgorithm;
import de.learnlib.api.oracle.EquivalenceOracle;
import de.learnlib.api.oracle.MembershipOracle;
import de.learnlib.api.query.DefaultQuery;
import de.learnlib.api.query.Query;
import de.learnlib.counterexamples.acex.MealyOutInconsPrefixTransformAcex;
import de.learnlib.counterexamples.acex.OutInconsPrefixTransformAcex;
import de.learnlib.oracle.equivalence.SimulatorEQOracle;
import de.learnlib.util.mealy.MealyUtil;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesis;
import hu.bme.mit.automatalearning.hypothesis.TTTHypothesisMealyEMF;
import net.automatalib.automata.transducers.MealyMachine;
import net.automatalib.automata.transducers.impl.compact.CompactMealy;
import net.automatalib.util.automata.builders.AutomatonBuilders;
import net.automatalib.util.automata.builders.MealyBuilder;
import net.automatalib.words.Alphabet;
import net.automatalib.words.Word;
import net.automatalib.words.WordBuilder;
import net.automatalib.words.impl.Alphabets;

public class TTTLearner<I, O> extends AbstractTTTLearner<MealyMachine<?, I, ?, O>, I, Word<O>> implements LearningAlgorithm.MealyLearner<I, O> {
	
	 public TTTLearner(Alphabet<I> alphabet, MembershipOracle<I, Word<O>> oracle, TTTHypothesis<I, O, ?, ?, ?> hypo) {
	        super(alphabet,
	              oracle,
	              hypo,
	              new BaseTTTDiscriminationTree<>(oracle, TTTDTNode<I,O>::new),
	              AcexAnalyzers.LINEAR_FWD);
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public MealyMachine<?, I, ?, O> getHypothesisModel() {
	        return (TTTHypothesis<I, O, ?, ?, ?>) hypothesis;
	    }

	    @Override
	    protected TTTTransition<I, Word<O>> createTransition(TTTState<I, Word<O>> state, I sym) {
	        TTTTransitionImpl<I, O> trans = new TTTTransitionImpl<I, O>(state, sym);
	        trans.output = query(state, Word.fromLetter(sym)).firstSymbol();
	        return trans;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public boolean refineHypothesisSingle(DefaultQuery<I, Word<O>> ceQuery) {
	        DefaultQuery<I, Word<O>> shortenedCeQuery =
	                MealyUtil.shortenCounterExample((TTTHypothesis<I, O, ?, ?, ?>) hypothesis, ceQuery);
	        return shortenedCeQuery != null && super.refineHypothesisSingle(shortenedCeQuery);
	    }

	    @Override
	    protected OutInconsPrefixTransformAcex<I, Word<O>> deriveAcex(OutputInconsistency<I, Word<O>> outIncons) {
	        TTTState<I, Word<O>> source = outIncons.srcState;
	        Word<I> suffix = outIncons.suffix;

	        OutInconsPrefixTransformAcex<I, Word<O>> acex = new MealyOutInconsPrefixTransformAcex<>(suffix,
	                                                                                                oracle,
	                                                                                                w -> getDeterministicState(
	                                                                                                        source,
	                                                                                                        w).getAccessSequence());

	        acex.setEffect(0, outIncons.targetOut);
	        Word<O> lastHypOut = computeHypothesisOutput(getAnySuccessor(source, suffix.prefix(-1)), suffix.suffix(1));
	        acex.setEffect(suffix.length() - 1, lastHypOut);
	        return acex;
	    }

	    @Override
	    protected Word<O> succEffect(Word<O> effect) {
	        return effect.subWord(1);
	    }

	    @Override
	    protected OutputInconsistency<I, Word<O>> findOutputInconsistency() {
	        OutputInconsistency<I, Word<O>> best = null;

	        for (TTTState<I, Word<O>> state : hypothesis.getStates()) {
	            AbstractBaseDTNode<I, Word<O>> node = state.getDTLeaf();
	            while (!node.isRoot()) {
	                Word<O> expectedOut = node.getParentOutcome();
	                node = node.getParent();
	                Word<I> suffix = node.getDiscriminator();
	                Word<O> hypOut = computeHypothesisOutput(state, suffix);
	                int mismatchIdx = MealyUtil.findMismatch(expectedOut, hypOut);
	                if (mismatchIdx != MealyUtil.NO_MISMATCH && (best == null || mismatchIdx <= best.suffix.length())) {
	                    best = new OutputInconsistency<>(state,
	                                                     suffix.prefix(mismatchIdx + 1),
	                                                     expectedOut.prefix(mismatchIdx + 1));
	                }
	            }
	        }
	        return best;
	    }

	    @Override
	    protected Word<O> predictSuccOutcome(TTTTransition<I, Word<O>> trans,
	                                         AbstractBaseDTNode<I, Word<O>> succSeparator) {
	        TTTTransitionImpl<I, O> mtrans = (TTTTransitionImpl) trans;
	        if (succSeparator == null) {
	            return Word.fromLetter(mtrans.output);
	        }
	        return succSeparator.subtreeLabel(trans.getDTTarget()).prepend(mtrans.output);
	    }

	    @Override
	    protected Word<O> computeHypothesisOutput(TTTState<I, Word<O>> state, Word<I> suffix) {
	        TTTState<I, Word<O>> curr = state;

	        WordBuilder<O> wb = new WordBuilder<>(suffix.length());

	        for (I sym : suffix) {
	            TTTTransitionImpl<I, O> trans = (TTTTransitionImpl<I, O>) hypothesis.getInternalTransition(curr, sym);
	            wb.append(trans.output);
	            curr = getAnyTarget(trans);
	        }

	        return wb.toWord();
	    }

	    @Override
	    protected AbstractBaseDTNode<I, Word<O>> createNewNode(AbstractBaseDTNode<I, Word<O>> parent,
	                                                           Word<O> parentOutput) {
	        return new TTTDTNode<I, O>(parent, parentOutput);
	    }

}
