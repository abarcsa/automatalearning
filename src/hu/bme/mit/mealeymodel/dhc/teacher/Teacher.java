package hu.bme.mit.mealeymodel.dhc.teacher;

import java.util.Collection;

import hu.bme.mit.mealeymodel.dhc.general.adapter.LearnableAdapter;


public class Teacher <I, O, H>{
	
	LearnableAdapter<I,O,H> adapter;
	
	public Teacher(LearnableAdapter<I, O, H> adapter) {
		this.adapter = adapter;
	}
	
	public O membershipQuery(Collection<? extends I> sequence) {
		return adapter.membershipQuery(sequence);
	}

	public Collection<? extends I> equivalenceQuery(H hypothesis, Collection<? extends I> alphabet){
		return adapter.equivalenceQuery(hypothesis, alphabet);
	}
	
}
