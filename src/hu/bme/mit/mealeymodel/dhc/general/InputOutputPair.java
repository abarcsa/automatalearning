package hu.bme.mit.mealeymodel.dhc.general;


public class InputOutputPair<I, O>{
	final I input;
	final O output;
	
	public InputOutputPair(I t1, O t2){
		input = t1;
		output = t2;
	}
	@Override
	public boolean equals(Object o) {
		InputOutputPair<I, O> o1 = (InputOutputPair<I, O>)o;
		return o1.input.equals(this.input) && o1.output.equals(this.output);
	}
}