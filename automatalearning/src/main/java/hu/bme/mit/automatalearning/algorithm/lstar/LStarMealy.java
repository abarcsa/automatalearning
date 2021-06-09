package hu.bme.mit.automatalearning.algorithm.lstar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class LStarMealy<I,O> extends ActiveLearningAlgorithm<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>>{
	protected List<? extends I> inputAlphabet;
	protected LStarTable t;
	
	// a hypothesis must be stored as it cannot be instantiated here due to genericity -> always reset this
	// FIXME own generic hypothesis
	protected DHCHypothesisMealy hypothesis;
	// spanning tree (corresponding to the current state of the hypothesis)
	protected BiMap<State, List<? extends I>> accessSequences;
	
	public LStarMealy(Teacher<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>, ?> teacher,
						List<? extends I> inputAlphabet, 
						DHCHypothesisMealy hypothesis) {
		this.teacher = teacher;
		this.inputAlphabet = inputAlphabet;
		this.hypothesis = hypothesis;
		this.accessSequences = HashBiMap.create();
		this.t =  new LStarTable(inputAlphabet);
	}
	
	@Override
	public DHCHypothesis<I, O, MealyMachine, State, Transition> execute() {
		List<? extends I> counterExample = null;
		do {
			if(counterExample != null) {
				t.addSuffix(processCounterExample(counterExample));
			}
			t.closeTable();
			constructHypothesis(t);
			Utils.logHypothesisToJSON((Hypothesis<String, String, MealyMachine, State, Transition>) hypothesis, "DHC");//TODO remove
			counterExample = teacher.equivalenceQuery((DHCHypothesis<I, O, MealyMachine, State, Transition>) hypothesis, inputAlphabet);
		}while(counterExample != null);
		
		return (DHCHypothesis<I, O, MealyMachine, State, Transition>) hypothesis;
	}
	
	private List<? extends I> processCounterExample(List<? extends I> counterExample) {
		int m = counterExample.size() - 1;
		O oce = teacher.membershipQuery(counterExample);
		int l = 2;
		int u = m - 1;
		while(true) {
			int mid = (l + u) / 2;
			List<? extends I> s = counterExample.subList(0, mid);
			List<I> s_ = (List<I>)accessSequences.get(hypothesis.queryState((List<? extends String>) s));	//TODO no cast
			List<I> d = (List<I>)counterExample.subList(mid, m + 1);
			List<I> s_d = new ArrayList<>(s_);
			s_d.addAll(d);
			O omid = teacher.membershipQuery((List<? extends I>) s_d);
			if (omid.equals(oce)) {
				l = mid + 1;
				if (u < l) {
					return counterExample.subList(mid + 1, m + 1);
				}
			} else {
				u = mid - 1;
				if (u < l) {
					return counterExample.subList(mid, m + 1);
				}
			}
		}
	}
	
	private void constructHypothesis(LStarTable t) {
		hypothesis.resetHypothesis();
		accessSequences = HashBiMap.create();
		
		// the states correspond to the 'sp' rows of the table (initial is the empty access sequence)
		for (List<I> state : t.sp) {
			State s = null;
			if (state.equals(new ArrayList<>())) {
				s = hypothesis.addInitialState();
			} else {
				s = hypothesis.createNewState();
			}
			accessSequences.put(s, state);
		}
		// the transition function ... 
		for (State src : accessSequences.keySet()) {
			for(I input : inputAlphabet) {
				List<I> prefix = new ArrayList<>((List<I>) accessSequences.get(src));	//TODO no cast
				prefix.add(input);
				State tgt = accessSequences.inverse().get(t.getSimilarSpRow(prefix));
				O output = t.get(prefix);
				//System.out.println("Src: " + src + " Tgt: " + tgt + " when: " + input + "/" + output);
				hypothesis.addTransition(src, tgt, (String)input, (String)output);	//TODO no cast
			}
		}
	}
	
	class LStarTable {
		// U (prefixes)
		List<List<I>> sp = new ArrayList<>();
		List<List<I>> lp = new ArrayList<>();
		// D (suffixes)
		List<List<I>> d = new ArrayList<>();
		// Table
		Map<List<I>, O> table = new HashMap<>();
		
		public LStarTable(List<? extends I> inputAlphabet) {
			sp.add(new ArrayList<>());
			for(I elem : inputAlphabet) {
				ArrayList<I> toAdd = new ArrayList<>();
				toAdd.add(elem);
				d.add(toAdd);
				lp.add(toAdd);
			}
		}
		
		// ensure that table is closed
		public void closeTable() {
			do {
				// fill missing values
				List<List<I>> prefixes = new ArrayList<>(sp);
				prefixes.addAll(lp);
				for (List<I> prefix : prefixes) {
					for (List<I> suffix : d) {
						List<I> word = new ArrayList<>(prefix);
						word.addAll(suffix);
						if(table.get(word) == null) {
							table.put(word, teacher.membershipQuery(word));
						}
					}
				}
				
				// add missing rows
				// collect those that are missing
				List<List<I>> noSimilar = new ArrayList<>();
				for (List<I> u : lp) {
					List<I> v = getSimilarSpRow(u);
					if (v == null) {
						noSimilar.add(u);
					}
				}
				// extend the table for each missing
				for(List<I> u : noSimilar) {
					sp.add(u);
					lp.remove(u);
					for(I input : inputAlphabet) {
						List<I> temp = new ArrayList<>(u);
						temp.add(input);
						lp.add(temp);
					}
				}
			} while (!isClosed());
		}
		
		// closed <=> for every element of Lp there exists an element in Sp s.t. the outputs in their rows are the same
		public boolean isClosed() {
			Map<List<I>, Boolean> foundSimilar = new HashMap<>();
			
			for (List<I> u : lp) {
				List<O> uRow = getRow(u);
				foundSimilar.put(u, false);
				for (List<I> v : sp) {
					List<O> vRow = getRow(v);
					if (uRow.equals(vRow)) {
						foundSimilar.put(u, true);
					}
				}
			}
			
			if(foundSimilar.isEmpty() || foundSimilar.values().contains(false)) {
				return false;
			}
			return true;
		}
		
		private O get(List<I> input) {
			return table.get(input);
		}
		
		private List<O> getRow(List<I> u){
			List<O> row = new ArrayList<>();
			
			for (List<I> w : d) {
				List<I> temp = new ArrayList<>(u);
				temp.addAll(w);
				row.add(table.get(temp));
			}
			return row;
		}
		
		private List<I> getSimilarSpRow(List<I> u) {
			List<O> uRow = getRow(u);
			for (List<I> v : sp) {
				List<O> vRow = getRow(v);
				if (uRow.equals(vRow)) {
					return v;
				}
			}
			return null;
		}
		
		public void addSuffix(List<? extends I> list) {
			d.add((List<I>)list);
		}
		
	}

}
