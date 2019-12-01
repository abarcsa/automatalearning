package hu.bme.mit.mealeymodel.dhc.algorithm;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.bme.mit.mealeymodel.Alphabet;
import hu.bme.mit.mealeymodel.MealeymodelFactory;
import hu.bme.mit.mealeymodel.State;
import hu.bme.mit.mealeymodel.dhc.hypothesis.Hypothesis;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;
import hu.bme.mit.mealeymodel.dhc.teacher.Teacher;
import hu.bme.mit.mealeymodel.Transition;

public class DirectHypothesisConstruction {
	Teacher<String, String, MealeyMachineHypothesis> teacher;	
	Collection<? extends String> alphabet;
	HashSet<List<? extends String>> splitters;
	
	public DirectHypothesisConstruction(Teacher<String, String, MealeyMachineHypothesis> teacher, Collection<? extends String> alphabet) {
		this.teacher = teacher;
		this.alphabet = alphabet;
		this.splitters = new HashSet<>();
	}
	
	public MealeyMachineHypothesis execute() {
		List<? extends String> counterExample = null;
		MealeyMachineHypothesis h = null;
		do {
			if(counterExample != null) {
				refineHypothesis(counterExample);
			}
			h = constructHypothesis();

			counterExample = teacher.equivalenceQuery(h, alphabet);
		}while(counterExample != null);
		
		return h;
	}
	
	public MealeyMachineHypothesis constructHypothesis() {
		MealeyMachineHypothesis hypothesis = new MealeyMachineHypothesis(alphabet);
		ArrayDeque<QueueElement<String, String>> statesToComplete = new ArrayDeque<>();
		statesToComplete.add(new QueueElement<String, String>(null, null, null, null));
		Map<List<String>, State> signatures = new HashMap<>();
		
		while(!statesToComplete.isEmpty()) {
			QueueElement<String, String> currentElement = statesToComplete.pop();
			
			List<String> currSequence = getAccessSequence(currentElement);
			
			LinkedHashMap<String, String> currAlphabetSignature = findAlphabetOutputSignature(currSequence);
			List<String> currSignature = new ArrayList<String>(currAlphabetSignature.values());
			currSignature.addAll(findSplitterOutputSignature(currSequence));
			
			State sibling = findStateWithSameSignature(signatures, currSignature);
			
			if(sibling != null) {	//If a sibling exists, merge currState to sibling
				hypothesis.addTransition(currentElement.parentState, sibling, currentElement.input, currentElement.output);
			}else {	//If there are no siblings, the targetState of all transitions going from currentState is set to a new state
				State newState = currentElement.parentElement == null ? hypothesis.addInitialState() : hypothesis.createNewState();
                if (currentElement.parentElement != null) {
                    hypothesis.addTransition(currentElement.parentState, newState, currentElement.input, currentElement.output);
                }
                signatures.put(currSignature, newState);

                for(String symbol : hypothesis.getInputAlphabet()) {
                	statesToComplete.add(new QueueElement<String, String>(newState, currentElement, symbol, currAlphabetSignature.get(symbol)));
                }
			}
		}
		return hypothesis;
	}
	
	private LinkedHashMap<String, String> findAlphabetOutputSignature(List<String> accessSequence){
		LinkedHashMap<String, String> currSignature = new LinkedHashMap<>();
		for(String symbol : this.alphabet) {
			List<String> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.add(symbol);
			
			String outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			currSignature.put(symbol, outputSymbol);
		}
		return currSignature;
	}
	
	private List<String> findSplitterOutputSignature(List<String> accessSequence){
		List<String> retVal = new ArrayList<>();
		for(List<? extends String> splitter : this.splitters) {
			List<String> currSequenceWithSymbol = new ArrayList<>(accessSequence);
			currSequenceWithSymbol.addAll(splitter);
			
			String outputSymbol = teacher.membershipQuery(currSequenceWithSymbol);
			
			retVal.add(outputSymbol);
		}
		return retVal;
	}
	
	private State findStateWithSameSignature(Map<List<String>, State> prevSignature, List<String> currSignature) {
		Optional<List<String>> exists = prevSignature.keySet().stream().filter(list -> list.equals(currSignature)).findFirst();
		if(exists.isPresent()) {
			return prevSignature.get(exists.get());
		}
		return null;
	}
	
	private List<String> getAccessSequence(QueueElement<String, String> currElement) {
		List<String> word = new ArrayList<>();

        QueueElement<String, String> parent = currElement.parentElement;
        String in = currElement.input;
        while (parent != null && in != null) {
            word.add(in);
            in = parent.input;
            parent = parent.parentElement;
        }

        Collections.reverse(word);
        return word;
	}
	public void refineHypothesis(List<? extends String> counterExample) {
		for(Set<? extends String> suffixes : Sets.powerSet(new LinkedHashSet<String>(counterExample))) {
			if(suffixes.size() != 0 && suffixes.size() != 1 && !splitters.stream().anyMatch(l -> l.equals(suffixes))) {
				this.splitters.add(new ArrayList<>(suffixes));
			}
		}
		
	}

	
	public static void test() {
		Alphabet in = MealeymodelFactory.eINSTANCE.createAlphabet();
		in.getCharacters().add("I1");
		in.getCharacters().add("I2");
		Alphabet out = MealeymodelFactory.eINSTANCE.createAlphabet();
		out.getCharacters().add("O1");
		out.getCharacters().add("O2");
		List<State> s = new ArrayList<>();
		State s1 = MealeymodelFactory.eINSTANCE.createState();
		State s2 = MealeymodelFactory.eINSTANCE.createState();
		State s3 = MealeymodelFactory.eINSTANCE.createState();
		State s4 = MealeymodelFactory.eINSTANCE.createState();
		State s5 = MealeymodelFactory.eINSTANCE.createState();
		s1.setName("state 1");
		s2.setName("state 2");
		s3.setName("state 3");
		s4.setName("state 4");
		s5.setName("state 5");
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
		hu.bme.mit.mealeymodel.Transition t1 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t2 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t3 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t4 = MealeymodelFactory.eINSTANCE.createTransition();
		hu.bme.mit.mealeymodel.Transition t5 = MealeymodelFactory.eINSTANCE.createTransition();
		t1.setInput("I1");
		t2.setInput("I2");
		t3.setInput("I3");
		t4.setInput("I4");
		t5.setInput("I3");
		t1.setOutput("O1");
		t2.setOutput("O1");
		t3.setOutput("O1");
		t4.setOutput("O2");
		t5.setOutput("O1");
		t1.setSourceState(s1);
		t2.setSourceState(s2);
		t3.setSourceState(s3);
		t4.setSourceState(s2);
		t5.setSourceState(s5);
		t1.setTargetState(s2);
		t2.setTargetState(s3);
		t3.setTargetState(s4);
		t4.setTargetState(s5);
		List<hu.bme.mit.mealeymodel.Transition> trans = new ArrayList<>();
		trans.add(t1);
		trans.add(t2);
		trans.add(t3);
		trans.add(t4);
		trans.add(t5);
		MealeyMachineHypothesis hy = new MealeyMachineHypothesis(in, out, s1, s, trans);
		hy.rerouteAllTransitions(s5, s3);
		System.out.println();
	}
	
	//Great idea of Queue handling from the LearnLib framework
	 static final class QueueElement<I, O> implements Serializable {

	        private final State parentState;
	        private final QueueElement<I, O> parentElement;
	        private final I input;
	        private final O output;
	        private final int depth;

	        QueueElement(State parentState, QueueElement<I, O> parentElement, I input, O output) {
	            this.parentState = parentState;
	            this.parentElement = parentElement;
	            this.input = input;
	            this.output = output;
	            this.depth = (parentElement != null) ? parentElement.depth + 1 : 0;
	        }
	 }

}
