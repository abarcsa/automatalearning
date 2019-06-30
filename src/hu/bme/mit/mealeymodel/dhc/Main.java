package hu.bme.mit.mealeymodel.dhc;

import hu.bme.mit.mealeymodel.*;
import hu.bme.mit.mealeymodel.dhc.Learnable.MealeyLearnable;
import hu.bme.mit.mealeymodel.dhc.Learnable.StringSequenceLearnable;
import hu.bme.mit.mealeymodel.dhc.adapter.StringSequenceToMealeyAdapter;
import hu.bme.mit.mealeymodel.dhc.algorithm.DirectHypothesisConstruction;
import hu.bme.mit.mealeymodel.dhc.hypothesis.MealeyMachineHypothesis;
import hu.bme.mit.mealeymodel.dhc.teacher.MealeyMachineTeacherStringSequenceImpl;
import hu.bme.mit.mealeymodel.dhc.teacher.Teacher;


public class Main {

	public static void main(String[] args) {
		/*MealeyMachine m = MealeyModelReader.getMealeyModelFromXtext();
		Teacher<String, String, MealeyMachineHypothesis> teacher = new MealeyMachineTeacherStringSequenceImpl(new StringSequenceToMealeyAdapter(new MealeyLearnable(m)));
		
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().addAll(m.getInputAlphabet().getCharacters());
		MealeyMachineHypothesis hypo = new MealeyMachineHypothesis(inputAlphabet);
		DirectHypothesisConstruction dhc = new DirectHypothesisConstruction(teacher, hypo);
		
		MealeyMachineHypothesis h = dhc.execute();
		
		MealeyModelReader.output(h.getAutomaton());*/
		alternatingbit();
		
	
	}
	
	public static void alternatingbit() {
		String sequence = 
				"null|send0|ack1|send0|ack0|send1"
				+ "|ack0null|send1|ack0ack0|send1|ack0ack1|send0"
				+ "|ack1null|send0|ack1ack0|send1|ack1ack1|send0"
				+ "|nullnull|send0|nullack0|send1|nullack1|send0"
				+ "|ack0nullnull|send1|ack0nullack0|send1|ack0nullack1|send0"
				+ "|ack0ack0null|send1|ack0ack0ack0|send1|ack0ack0ack1|send0"
				+ "|ack0ack1null|send0|ack0ack1ack0|send1|ack0ack1ack1|send0"
				+ "|ack1nullnull|send0|ack1nullack0|send1|ack1nullack1|send0"
				+ "|ack1ack0null|send1|ack1ack0ack0|send1|ack1ack0ack1|send0"
				+ "|ack1ack1null|send0|ack1ack1ack0|send1|ack1ack1ack1|send0"
				+ "|nullnullnull|send0|nullnullack0|send1|nullnullack1|send0"
				+ "|nullack0null|send1|nullack0ack0|send1|nullack0ack1|send0"
				+ "|nullack1null|send0|nullack1ack0|send1|nullack1ack1|send0";
		Alphabet inputAlphabet = MealeymodelFactory.eINSTANCE.createAlphabet();
		inputAlphabet.getCharacters().add("null");
		inputAlphabet.getCharacters().add("ack0");
		inputAlphabet.getCharacters().add("ack1");
		Teacher<String, String, MealeyMachineHypothesis> teacher = new MealeyMachineTeacherStringSequenceImpl(new StringSequenceToMealeyAdapter(new StringSequenceLearnable(sequence)));
		MealeyMachineHypothesis hypo = new MealeyMachineHypothesis(inputAlphabet);
		DirectHypothesisConstruction dhc = new DirectHypothesisConstruction(teacher, hypo);
		
		MealeyMachineHypothesis h = dhc.execute();
		
		MealeyModelReader.output(h.getAutomaton());
	}
	
}