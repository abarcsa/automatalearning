package hu.bme.mit.automatalearning.util;

import java.util.ArrayList;
import java.util.List;

import de.learnlib.api.SUL;
import de.learnlib.api.exception.SULException;
import hu.bme.mit.automatalearning.teacher.Teacher;

/**
 * 
 * @author Aron Barcsa-Szabo
 * 
 * Wrapper over the SUL interface, which creates a 1:1 connection between the SUL (Learnable) reached over the Teacher and a LearnLib SUL.
 *
 * @param <I>
 * @param <O>
 */
public class SULWrapper<I,O> implements SUL<I,O>{
	
	Teacher<I, O, ?, ?> teacher;
	
	List<I> seq;
	
	public SULWrapper(Teacher<I, O, ?, ?> teacher) {
		this.teacher = teacher;
	}

	@Override
	public void pre() {
		seq = new ArrayList<>();
	}

	@Override
	public void post() {
		seq = null;
	}

	@Override
	public O step(I in) throws SULException {
		seq.add(in);
		O out = teacher.membershipQuery(seq);
		return out;
	}
}
