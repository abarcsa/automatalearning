package hu.bme.mit.automatalearning.algorithm.dhc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import de.learnlib.api.AccessSequenceTransformer;
import de.learnlib.api.query.DefaultQuery;
import de.learnlib.api.query.Query;
import de.learnlib.oracle.membership.SULOracle;
import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable;
import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.algorithm.dhc.DirectHypothesisConstructionMealy.QueueElement;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.AdaptiveTeacher;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.util.SULWrapper;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;
import net.automatalib.automata.concepts.SuffixOutput;
import net.automatalib.words.Word;

public class AdaptiveDirectHypothesisConstructionMealy<I, O, M, S, T> extends DirectHypothesisConstructionMealy<I, O, M, S,T>{

	public AdaptiveDirectHypothesisConstructionMealy(AdaptiveTeacher<I, O, DHCHypothesis<I, O, M, S, T>, ?, ?> teacher,
			Collection<? extends I> alphabet, DHCHypothesis<I, O, M, S, T> hypothesis) {
		super(teacher, alphabet, hypothesis);
		
		
	}
	
	AdaptionCommand currCommand = AdaptionCommand.OPTIMISTIC;
	
	@Override
	public DHCHypothesis<I, O, M, S, T> execute() {
		List<? extends I> counterExample = null;
		DHCHypothesis<I, O, M, S, T> h = null;
		do {
			if(counterExample != null) {
				refineHypothesis(counterExample);
			}
			h = constructHypothesis();
			Utils.logHypothesisToJSON((Hypothesis<String, String, MealyMachine, State, Transition>) h, "DHC");
			if(!reset) counterExample = teacher.equivalenceQuery(h, alphabet);
			else reset = false;
		}while(counterExample != null);
		
		return h;
	}
	
	boolean reset = false;
	
	@Override
	public DHCHypothesis<I, O, M, S, T> constructHypothesis() {
		hypothesis.resetHypothesis();
		ArrayDeque<QueueElement<I, O, S>> statesToComplete = new ArrayDeque<>();
		statesToComplete.add(new QueueElement<I, O, S>(null, null, null, null));
		Map<List<O>, S> signatures = new HashMap<>();
		
		while(!statesToComplete.isEmpty()) {
			QueueElement<I, O, S> currentElement = statesToComplete.pop();
			
			List<I> currSequence = getAccessSequence(currentElement);
			
			LinkedHashMap<I, O> currAlphabetSignature = findAlphabetOutputSignature(currSequence);
			if(currCommand == AdaptionCommand.RESET) {
				reset = true;
				break;
			}
			List<O> currSignature = new ArrayList<>(currAlphabetSignature.values());
			currSignature.addAll(findSplitterOutputSignature(currSequence));
			if(currCommand == AdaptionCommand.RESET) {
				reset = true;
				break;
			}
			
			S sibling = findStateWithSameSignature(signatures, currSignature);
			
			if(sibling != null) {	//If a sibling exists, merge currState to sibling
				hypothesis.addTransition(currentElement.parentState, sibling, currentElement.input, currentElement.output);
			}else {	//If there are no siblings, the targetState of all transitions going from currentState is set to a new state
				S newState = currentElement.parentElement == null ? hypothesis.addInitialState() : hypothesis.createNewState();
				this.accessSequences.put(newState, currSequence);
                if (currentElement.parentElement != null) {
                    hypothesis.addTransition(currentElement.parentState, newState, currentElement.input, currentElement.output);
                }
                signatures.put(currSignature, newState);
                if(currCommand.equals(AdaptionCommand.PESSIMISTIC)) {
                	for(I symbol : hypothesis.getHypothesisInputAlphabet()) {
                    	statesToComplete.add(new QueueElement<I, O, S>(newState, currentElement, symbol, currAlphabetSignature.get(symbol)));
                    }
                }
			}
		}
		return hypothesis;
	}
	
	@Override
	protected LinkedHashMap<I, O> findAlphabetOutputSignature(List<I> accessSequence){
		LinkedHashMap<I, O> currSignature = new LinkedHashMap<>();
		for(I symbol : this.alphabet) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.add(symbol);
			
			O outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			currCommand = ((AdaptiveTeacher)this.teacher).getCommand();
			if(currCommand.equals(AdaptionCommand.RESET)) break;
			
			currSignature.put(symbol, outputSymbol);
		}
		return currSignature;
	}
	
	@Override
	protected List<O> findSplitterOutputSignature(List<I> accessSequence){
		List<O> retVal = new ArrayList<>();
		for(List<? extends I> splitter : this.splitters) {
			List<I> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.addAll(splitter);
			
			O outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			currCommand = ((AdaptiveTeacher)this.teacher).getCommand();
			if(currCommand.equals(AdaptionCommand.RESET)) break;
			
			retVal.add(outputSymbol);
		}
		return retVal;
	}
	
	@Override
	public void refineHypothesis(List<? extends I> counterExample) {
		for(Word<I> w : suffixHelper(counterExample)) {
			List<? extends I> currSuffix = w.asList();
			if(currSuffix.size() != 0 && currSuffix.size() != 1 && !splitters.stream().anyMatch(l -> l.equals(currSuffix))) {
				this.splitters.add(new ArrayList<>(currSuffix));
			}
		}
		
	}
	
	private Collection<Word<I>> suffixHelper(List<? extends I> counterExample) {
		Query<String, Word<String>> q = new DefaultQuery<String, Word<String>>(Word.fromList((List<String>)counterExample));
		q.answer(Word.fromSymbols(((String)teacher.membershipQuery(counterExample))));
		AccessSequenceTransformer<String> asT = new AccessSequenceTransformer<String>() {

			@Override
			public Word<String> transformAccessSequence(Word<String> word) {
				return Word.fromList((List<String>)(accessSequences.get(((DHCHypothesisMealy)AdaptiveDirectHypothesisConstructionMealy.this.hypothesis).queryState(word.asList()))));
			}

			@Override
			public boolean isAccessSequence(Word<String> word) {
				return transformAccessSequence(word).equals(word);
			}
		};
		SuffixOutput<String, Word<String>> sO = new SuffixOutput<String, Word<String>>() {

			@Override
			public Word<String> computeSuffixOutput(Iterable<? extends String> prefix,
					Iterable<? extends String> suffix) {
				return (Word<String>) Word.fromSymbols(hypothesis.query((List<? extends I>) Lists.newArrayList(Iterables.concat(prefix, suffix))));
			}
		};
		return de.learnlib.counterexamples.GlobalSuffixFinders.RIVEST_SCHAPIRE.findSuffixes(q, asT, sO, new SULOracle<>(new SULWrapper(teacher)));
	}

}
