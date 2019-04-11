package hu.bme.mit.mealeymodel.dhc;

import hu.bme.mit.mealeymodel.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		MealeyMachine m = MealeyModelReader.getMealeyModelFromXtext();
		List<String> l = new ArrayList<>();
		m.getInitialState();
		m.getInitialState();
		MealeyModelReader.output(learnMealeyMachine(m).getHypothesisedMachine());
		/*for(State s : ) {
			System.out.println(s.getName());
		}*/
	}
	
	public static Hypothesis learnMealeyMachine(MealeyMachine machine) {
		int numberOfStates = 0;
		Hypothesis hypo = new Hypothesis(machine);
		ArrayDeque<State> statesToComplete = new ArrayDeque<>();
		State initialState = MealeymodelFactory.eINSTANCE.createState();
		initialState = hypo.getHypothesisedMachine().getInitialState();
		statesToComplete.add(initialState);
		
		while(!statesToComplete.isEmpty()) {
			State curr = statesToComplete.remove();
			List<String> seq = hypo.getAccessSequence(curr);
			List<State> successorsOfCurr = new ArrayList<>();
			for(String symbol : hypo.getHypothesisedMachine().getInputAlphabet().getCharacters()) {
				List<String> sequence = new ArrayList<>(seq);
				sequence.add(symbol);
				String output = membershipQuery(sequence, machine);
				State s =  MealeymodelFactory.eINSTANCE.createState();
				s.setName("s" + ++numberOfStates);
				
				hypo.addInOut(curr,symbol,output);	
				hypo.setAccessSequence(s, sequence);
				successorsOfCurr.add(s);
				hypo.getHypothesisedMachine().getStates().add(s);
			}
			
			State sibling = hypo.findSibling(curr);
			if(sibling != null) {
				hypo.rerouteAllTransitions(curr, sibling);
			}else {
				for(State s : successorsOfCurr) {
					statesToComplete.add(s);
					
					
				}
			}
		}
		hypo.createTransitions();
		return hypo;
	}
	
	public static String membershipQuery(List<String> symbols, MealeyMachine machine){
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
