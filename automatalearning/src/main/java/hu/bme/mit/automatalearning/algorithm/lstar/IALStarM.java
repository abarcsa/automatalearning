package hu.bme.mit.automatalearning.algorithm.lstar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import hu.bme.mit.automatalearning.algorithm.ActiveLearningAlgorithm;
import hu.bme.mit.automatalearning.algorithm.dhc.IADHCM.Node;
import hu.bme.mit.automatalearning.algorithm.dhc.IADHCM.QueueElement;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesis;
import hu.bme.mit.automatalearning.hypothesis.DHCHypothesisMealy;
import hu.bme.mit.automatalearning.hypothesis.Hypothesis;
import hu.bme.mit.automatalearning.hypothesis.InitializableDHCHypothesisMealy;
import hu.bme.mit.automatalearning.teacher.Teacher;
import hu.bme.mit.automatalearning.util.Utils;
import hu.bme.mit.mealymodel.MealyMachine;
import hu.bme.mit.mealymodel.State;
import hu.bme.mit.mealymodel.Transition;

public class IALStarM<I,O> extends ActiveLearningAlgorithm<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>>{
	protected List<? extends I> inputAlphabet;
	protected LStarTable t;
	
	// a hypothesis must be stored as it cannot be instantiated here due to genericity -> always reset this
	// FIXME own generic hypothesis
	protected DHCHypothesisMealy hypothesis;
	// spanning tree (corresponding to the current state of the hypothesis)
	protected BiMap<State, List<? extends I>> accessSequences;
	protected BiMap<State, List<? extends I>> initAccessSequences;
	
	public IALStarM(Teacher<I, O, DHCHypothesis<I, O, MealyMachine, State, Transition>, ?> teacher,
						List<? extends I> inputAlphabet, 
						InitializableDHCHypothesisMealy initHypo, DHCHypothesisMealy hypothesis) {
		this.teacher = teacher;
		this.inputAlphabet = inputAlphabet;
		this.hypothesis = hypothesis;
		init(initHypo);	//initializes this.t and accessSequences
	}
	
	// reset hypo, based on that reset (accessseqences), signatures, statestocomplete
		private void init(InitializableDHCHypothesisMealy initHypo) {
			this.t =  new LStarTable(inputAlphabet);
			this.initAccessSequences = HashBiMap.create();
			// initialize based on the "original" hypothesis
			MealyMachine m = initHypo.getHypothesisAutomaton();
			
			// build spanning tree
			Node<I,O> root = new Node<>(m.getInitialState().getName(), null, null, null);
			
			List<Node<I,O>> examine = new ArrayList<>();
			List<Node<I,O>> next = new ArrayList<>();
			List<String> marked = new ArrayList<>();
			List<Node> nodes = new ArrayList<>();
			
			examine.add(root);
			marked.add(root.stateName);
			
			// graph must be connected through directed edges from the root TODO
			for(int i = 0; i < m.getStates().size(); ++i) {	//find a better/narrower condition? 
				for(Node<I,O> curr : examine) {
					for(Transition t : m.getTransitions()) {
						if(t.getSourceState().getName().equals(curr.stateName)) {
							if(!marked.contains(t.getTargetState().getName())) {
								State target = t.getTargetState();
								Node<I,O> toAdd = new Node<I,O>(target.getName(), curr, (I)t.getInput(), (O)t.getOutput());
								curr.addChild(toAdd, (I)t.getInput());
								next.add(toAdd);
								marked.add(toAdd.stateName);
								nodes.add(toAdd);
							}
						}
					}
				}
				examine = next;
				next = new ArrayList<>();
			}
			
			//for each initialized node
			for(Node<I,O> node : root.preorder()) {
				// get its access sequence
				State corresponding = m.getStates().stream().filter(s -> s.getName().equals(node.stateName)).findFirst().get();
				List<? extends I> access = node.getAccess();
				if(!initAccessSequences.containsKey(corresponding)) {
					initAccessSequences.put(corresponding, access);
				}
				t.addState(access);
				// get its output signature for the input alphabet
				for(I inp : inputAlphabet) {
					ArrayList<I> inp_list = new ArrayList<>();
					inp_list.add(inp);
					for(Transition tran : m.getTransitions()) {
						if(tran.getSourceState().getName().equals(node.stateName) && 
							tran.getInput().equals(inp)) {
							//System.out.println(inp);
							t.addStateSignatureElement(access, inp_list, (O) tran.getOutput());
							break;
						}
					}
				}
				
			}
			t.finalizeInit(inputAlphabet);
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
	
	// returns the separating input sequence (to be added to the table)
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
		t.print();
		
		hypothesis.resetHypothesis();
		accessSequences = HashBiMap.create();
		/*for(State state : initAccessSequences.keySet()) {
			accessSequences.put(state, initAccessSequences.get(state));
		}*/
		
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
			// sp and lp initialized in finalizeInit() - if needed
			for(I elem : inputAlphabet) {
				ArrayList<I> toAdd = new ArrayList<>();
				toAdd.add(elem);
				d.add(toAdd);
			}
		}
		
		//call after table initialization
		public void finalizeInit(List<? extends I> inputAlphabet) {
			// initialize sp and lp based on the previous initialization
			if(sp.isEmpty()) { 	// if empty, initialize like in the basic lstar
				sp.add(new ArrayList<>());
				for(I elem : inputAlphabet) {
					ArrayList<I> toAdd = new ArrayList<>();
					toAdd.add(elem);
					lp.add(toAdd);
				}
			} else {	// if not empty, add the continuations of sp to lp (state candidates)
				for (List<I> statePrefix : sp) {
					for (I input : inputAlphabet) {
						List<I> temp = new ArrayList<>(statePrefix);
						temp.add(input);
						if(!sp.contains(temp) || lp.contains(temp)) {
							lp.add(temp);
						}
					}
				}
			}
			
			if(!sp.isEmpty() && !sp.contains(new ArrayList<>())) throw new IllegalStateException("Table does not contain an initial state!");
			for(List<I> s1 : sp) {
				for (List<I> s2 : sp) {
					if (s1 != s2 && getRow(s1).equals(getRow(s2)))
						throw new IllegalStateException("States are not unique!");
				}
			}
			print();
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
				
				// add unique rows to sp and their continuations to lp
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
		
		public void addState(List<? extends I> prefix) {
			if(sp.contains(prefix)) {
				throw new IllegalArgumentException("State already exists in the table!");
			}
			sp.add((List<I>)prefix);
		}
		
		public void addStateSignatureElement(List<? extends I> prefix, List<? extends I> suffix, O output) {
			if(!sp.contains(prefix)) {
				throw new IllegalArgumentException("The state corresponding the prefix does not exist!");
			}
			if(!d.contains(suffix)) {
				throw new IllegalArgumentException("The given suffix is not in the table!");
			}
			
			List<I> inputSequence = new ArrayList<I>(prefix);
			inputSequence.addAll(suffix);
			
			if(table.containsKey(inputSequence) && !table.get(inputSequence).equals(output)) {
				throw new IllegalArgumentException("The input sequence is already mapped and does not correspond the given output!");
			}
			table.put(inputSequence, output);
		}
		
		public void print() {
			// header
			System.out.print("|\t\t|");
			for (List<I> col : d) {
				System.out.print("\t\t|");
			}
			System.out.print("\n");
			//sp
			System.out.print("|");
			for (List<I> s : sp) {
				System.out.print(s + "\t|");
				for (List<I> col : d) {
					List<I> temp = new ArrayList<>(s);
					temp.addAll(col);
					
					System.out.print(table.get(temp) + "\t|");
				}
				System.out.print("\n");
			}
		}
		
	}
	
	public static final class Node <I,O> {
		final String stateName;
		final Node<I,O> parent;
		final I parentAccessI;
		final O parentAccessO;
		
		final List<Node<I,O>> children = new ArrayList<>();
		final List<I> childrenI = new ArrayList<>();
		
		public Node(String s, Node<I,O> parent, I parentAccessI, O parentAccessO) {
			this.stateName = s;
			this.parent = parent;
			this.parentAccessI = parentAccessI;
			this.parentAccessO = parentAccessO;
		}
		public void addChild(Node<I,O> n, I in) {
			this.children.add(n);
			this.childrenI.add(in);
		}
		public List<I> getAccess(){
			List<I> toReturn = new ArrayList<>();
			if(parent != null) {
				toReturn.addAll(parent.getAccess());
				toReturn.add(parentAccessI);
			}
			return toReturn;
		}
		public List<Node<I,O>> preorder() {
			List<Node<I,O>> ret = new ArrayList<>();
			ret.add(this);
			for(Node<I,O> child : children)  {
				ret.addAll(child.preorder());
			}
			return ret;
		}
	}

}
