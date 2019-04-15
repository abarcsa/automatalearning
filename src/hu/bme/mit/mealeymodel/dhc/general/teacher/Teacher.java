package hu.bme.mit.mealeymodel.dhc.general.teacher;

import java.util.Collection;

/**
 * 
 * @author Aron B.-Szabo
 *
 * @param <HI>	The input type of the Hypothesis
 * @param <HO>	The output type of the Hypothesis
 * @param <H>	The Hypothesis
 */
public abstract class Teacher <HI, HO, H>{
	 
	
	public abstract HO membershipQuery(Collection<? extends HI> sequence);

	public abstract Collection<? extends HI> equivalenceQuery(H hypothesis, Collection<? extends HI> alphabet);
	
}
