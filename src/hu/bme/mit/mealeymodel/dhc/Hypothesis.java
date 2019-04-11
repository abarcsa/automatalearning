package hu.bme.mit.mealeymodel.dhc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import hu.bme.mit.mealeymodel.*;
import hu.bme.mit.mealeymodel.impl.AlphabetImpl;

public class Hypothesis{
	MealeyMachine hypothesisedMachine;
	MealeyMachine realMachine;
	Map<String, List<String>> accessSequences; 
	Map<String, List<InputOutputPair<String>>> transitions;
	
	public Hypothesis(MealeyMachine machine) {
		realMachine = machine;
		hypothesisedMachine = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		State initialState = MealeymodelFactory.eINSTANCE.createState();
		State initialStateToStates = MealeymodelFactory.eINSTANCE.createState();
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		Alphabet outputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		
		initialState.setName("s0");
		initialStateToStates.setName(initialState.getName());
		((AlphabetImpl)inputAlphabet).eSet(MealeymodelPackage.ALPHABET__CHARACTERS, machine.getInputAlphabet().getCharacters());
		((AlphabetImpl)outputAlphabet).eSet(MealeymodelPackage.ALPHABET__CHARACTERS, machine.getOutputAlphabet().getCharacters());

		hypothesisedMachine.setInitialState(initialState);
		hypothesisedMachine.getStates().add(initialStateToStates);
		hypothesisedMachine.setInputAlphabet(inputAlphabet);
		hypothesisedMachine.setOutputAlphabet(outputAlphabet);
		
		
		accessSequences = new HashMap<String, List<String>>();
		accessSequences.put(initialState.getName(), new ArrayList<>());
		transitions = new HashMap<String, List<InputOutputPair<String>>>();
	}
	
	public MealeyMachine getHypothesisedMachine() {
		return hypothesisedMachine;
	}
	
	public List<String> getAccessSequence(State s){
		return accessSequences.get(s.getName());
	}
	public List<String> setAccessSequence(State s, List<String> seq){
		return accessSequences.put(s.getName(), seq);
	}
	public boolean containsState(State s) {
		return this.hypothesisedMachine.getStates().stream().anyMatch(x -> x.getName().equals(s.getName()));
	}
	public void addInOut(State state, String input, String output) {
		if(!transitions.containsKey(state.getName())) {
			transitions.put(state.getName(), new ArrayList<InputOutputPair<String>>());
		}
		transitions.get(state.getName()).add(new InputOutputPair<String>(input, output));
	}
	public State findSibling(State curr) {
		/*loop:for(State s : this.hypothesisedMachine.getStates()) {
		if(!s.getName().equals(curr.getName()) && accessSequences.get(curr.getName()) != null 
								&& accessSequences.get(s.getName()).size() == accessSequences.get(curr.getName()).size() 
								&& transitions.get(curr.getName()).size() == transitions.get(s.getName()).size() 
								&& transitions.get(curr.getName()).containsAll(transitions.get(s.getName()))) {
			
			for(int i = 0; i < accessSequences.get(curr.getName()).size(); i++) {
				if(!accessSequences.get(curr.getName()).get(i).equals(accessSequences.get(s.getName()).get(i))) {
					continue loop;
				}
			}
			return s;
		}
	}
	return null;*/
		loop:for(State s : this.hypothesisedMachine.getStates()) {
			if(!s.getName().equals(curr.getName()) && transitions.containsKey(s.getName())) {
				List<String> seq = getAccessSequence(curr);
				List<String> seq2 = getAccessSequence(s);
				for(String symbol : getHypothesisedMachine().getInputAlphabet().getCharacters()) {
					List<String> sequence = new ArrayList<>(seq);
					List<String> sequence2 = new ArrayList<>(seq2);
					sequence.add(symbol);
					sequence2.add(symbol);
					String output = this.membershipQuery(sequence, realMachine);
					String output2 = this.membershipQuery(sequence2, realMachine);
					if(!output.equals(output2)) {
						continue loop;
					}
				}
				return s;
			}
		}
	return null;
	}
	public void rerouteAllTransitions(State from, State to) {

		for(InputOutputPair<String> inOut :  transitions.get(from.getName())){
			if(!transitions.get(to.getName()).stream().anyMatch(x -> (x.input.equals(inOut.input) && x.output.equals(inOut.output)))){
				transitions.get(to.getName()).add(inOut);
			}
		}
		transitions.remove(from.toString());
		accessSequences.remove(from.toString());
		/*if(!this.hypothesisedMachine.getStates().removeIf(x -> x.getName().equals(from.getName()))){
			throw new RuntimeException("Gond van!!");
		}*/
		
	}
	public void createTransitions() {
		MealeyMachine hypothesisedMachineFinal = MealeymodelFactory.eINSTANCE.createMealeyMachine();
		
		State initialState = MealeymodelFactory.eINSTANCE.createState();
		State initialStateToStates = MealeymodelFactory.eINSTANCE.createState();
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		Alphabet outputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		
		initialState.setName("s0");
		initialStateToStates.setName(initialState.getName());
		((AlphabetImpl)inputAlphabet).eSet(MealeymodelPackage.ALPHABET__CHARACTERS, hypothesisedMachine.getInputAlphabet().getCharacters());
		((AlphabetImpl)outputAlphabet).eSet(MealeymodelPackage.ALPHABET__CHARACTERS, hypothesisedMachine.getOutputAlphabet().getCharacters());

		hypothesisedMachineFinal.setInitialState(initialState);
		hypothesisedMachineFinal.getStates().add(initialStateToStates);
		hypothesisedMachineFinal.setInputAlphabet(inputAlphabet);
		hypothesisedMachineFinal.setOutputAlphabet(outputAlphabet);
		for(State s : this.hypothesisedMachine.getStates()) {
			if(transitions.containsKey(s.getName())) {
				State newState = MealeymodelFactory.eINSTANCE.createState();
				newState.setName(s.getName());
				hypothesisedMachineFinal.getStates().add(newState);
				for(String character : this.hypothesisedMachine.getInputAlphabet().getCharacters()) {
					List<String> currentAccessSequence = new ArrayList<>(accessSequences.get(s.getName()));
					List<InputOutputPair<String>> inputOutputForCharList = transitions.get(s.getName()).stream()
							.filter(x -> (x != null && x.input != null && x.input.equals(character))).collect(Collectors.toList());
					InputOutputPair<String> inputOutputForChar;
					if(inputOutputForCharList != null) {
						inputOutputForChar = inputOutputForCharList.get(0);
					
						currentAccessSequence.add(character);
						String stateWithSequenceName = "";
						for(Entry<String, List<String>> sequences : accessSequences.entrySet()) {
							if(sequences.getValue().equals(currentAccessSequence)) {
								stateWithSequenceName = sequences.getKey();
							}
						}
						Transition t = MealeymodelFactory.eINSTANCE.createTransition();
						t.setSourceState(s);
						State target = MealeymodelFactory.eINSTANCE.createState();
						target.setName(stateWithSequenceName);
						t.setTargetState(target);
						t.setInput(character);
						t.setOutput(inputOutputForChar.output);
						hypothesisedMachineFinal.getTransitions().add(t);
					}
				}
			}
		}
		this.hypothesisedMachine = hypothesisedMachineFinal;
	}
	
	protected class InputOutputPair<T>{
		T input;
		T output;
		public InputOutputPair(T t1, T t2){
			input = t1;
			output = t2;
		}
		@Override
		public boolean equals(Object o) {
			InputOutputPair<T> o1 = (InputOutputPair<T>)o;
			return o1.input.equals(this.input) && o1.output.equals(this.output);
		}
	}
	
	public String membershipQuery(List<String> symbols, MealeyMachine machine){
		Transition trans = null;
		State currState = machine.getInitialState();
		for(int i = 0; i < symbols.size(); i++) {
			String s = symbols.get(i);
			for(Transition t : machine.getTransitions()) {
				if(t.getSourceState().getName().equals(currState.getName()) && t.getInput().equals(s)){
					trans = t;
					currState = trans.getTargetState();
					break;
				}
			}
		}
		return trans == null ? null : trans.getOutput();
	}
	
}
