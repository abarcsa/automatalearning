package hu.bme.mit.automatalearning.Learnable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import hu.bme.mit.automatalearning.Learnable.AdaptiveLearnable.AdaptionCommand;
import hu.bme.mit.automatalearning.datastructures.LPT;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTRootNode;
import hu.bme.mit.automatalearning.datastructures.LPT.LPTUnloopedNode;

public abstract class MemoizingLearnable<I, O, LI, LO, L extends Learnable<LI, LO>> implements Learnable<I, O>{
	L delegate;
	
	LPT<I, O> prefixTree;
	
	public MemoizingLearnable(L delegate){
		this.delegate = delegate;
		prefixTree = new LPT<I, O>(new LPTRootNode<I, O>());
	}
	
	
	public Learnable<LI, LO> getDelegate() {
		return delegate;
	}

}
