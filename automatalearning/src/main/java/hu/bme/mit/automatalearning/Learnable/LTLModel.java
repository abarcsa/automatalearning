package hu.bme.mit.automatalearning.Learnable;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.BiFunction;

import owl.automaton.Automaton;
import owl.automaton.acceptance.BuchiAcceptance;
import owl.automaton.acceptance.OmegaAcceptance;
import owl.automaton.edge.Edge;
import owl.ltl.EquivalenceClass;
import owl.ltl.LabelledFormula;
import owl.ltl.parser.LtlParser;
import owl.run.Environment;
import owl.translations.ltl2ldba.AnnotatedLDBA;
import owl.translations.ltl2ldba.SymmetricLDBAConstruction;
import owl.translations.ltl2ldba.SymmetricProductState;
import owl.translations.mastertheorem.SymmetricEvaluatedFixpoints;

public class LTLModel implements PartialModel{
	
	List<String> inputAlphabet;
	List<String> outputAlphabet;
	Automaton<?, ?> automaton;

	public LTLModel(List<String> inputAlphabet, List<String> outputAlphabet, String formula) {
		// Save parameters
		this.inputAlphabet = inputAlphabet;
		this.outputAlphabet = outputAlphabet;
		// Create Buchi automaton from LTL formula
		List<String> atomicPropositions = new ArrayList<>();
		atomicPropositions.addAll(inputAlphabet);
		atomicPropositions.addAll(outputAlphabet);
		LabelledFormula lf= LtlParser.parse(formula, atomicPropositions);
		SymmetricLDBAConstruction<BuchiAcceptance> slc = SymmetricLDBAConstruction.of(Environment.standard(), BuchiAcceptance.class);
		AnnotatedLDBA<Map<Integer, EquivalenceClass>, SymmetricProductState, BuchiAcceptance, SortedSet<SymmetricEvaluatedFixpoints>, BiFunction<Integer, EquivalenceClass, Set<SymmetricProductState>>> aut = slc.apply(lf);
		automaton = aut.copyAsMutable();
		//MutableAutomaton<?,?> a1 = aut.copyAsMutable();
	}
	
	@Override
	public Set<String> getPossibleOutputs(List<String> inputSequence) {
		return getAutomatonOutput(automaton, inputSequence);
	}
	
	public <S, A extends OmegaAcceptance> Set<String>  getAutomatonOutput(Automaton<S, A> automaton, List<? extends String> inputs) {
		// TODO refactor so these can be deleted:
		Map<String, Integer> alphabetMap = new HashMap<>(); 
		List<String> atomicPropositions = new ArrayList<>();
		atomicPropositions.addAll(inputAlphabet);
		atomicPropositions.addAll(outputAlphabet);
		for(String s : atomicPropositions) {
			alphabetMap.put(s, atomicPropositions.indexOf(s));
		}
		int outputStart = inputAlphabet.size();
		
		// Helper variables for automaton traversal
		Set<S> currentStates = automaton.initialStates();
		Set<Edge<S>> currentEdges = new HashSet<Edge<S>>();
		Map<Edge<S>, List<Integer>> edgeMap = new HashMap<>();
		// Running the automaton
		for (String i : inputs) {
			//System.out.println("Input: " + i);
			edgeMap = new HashMap<>();
			Set<S> newCurrentStates = new HashSet<S>();
			Set<Edge<S>> newCurrentEdges = new HashSet<Edge<S>>();
			
			for (S state : currentStates) {
				BitSet valuation = new BitSet(alphabetMap.size());
				// Try the 'only-input' valuation
				valuation.set(alphabetMap.get(i));
				newCurrentStates.addAll(automaton.successors(state, valuation));
				newCurrentEdges.addAll(automaton.edges(state, valuation));
				for(Edge<S> ed : automaton.edges(state, valuation)) {
					if(!edgeMap.containsKey(ed)) {
						edgeMap.put(ed, new ArrayList<Integer>());
					}
					edgeMap.get(ed).add(valuation.nextSetBit(outputStart));
					//System.out.println(ed + " acc: " + ed.hasAcceptanceSets() + " val: " + valuation);				
				}
				// Try for every possible output combination
				for (int j = outputStart; j < alphabetMap.size(); ++j) {
					valuation.clear();
					valuation.set(j);
					valuation.set(alphabetMap.get(i));
					newCurrentStates.addAll(automaton.successors(state, valuation));
					newCurrentEdges.addAll(automaton.edges(state, valuation));
					for(Edge<S> ed : automaton.edges(state, valuation)) {
						if(!edgeMap.containsKey(ed)) {
							edgeMap.put(ed, new ArrayList<Integer>());
						}
						edgeMap.get(ed).add(valuation.nextSetBit(outputStart));
						//System.out.println(ed + " acc: " + ed.hasAcceptanceSets() + " val: " + valuation);
					}
				}
			}
			currentStates = newCurrentStates;
			currentEdges = newCurrentEdges;
		}
		//System.out.println("EM: " + edgeMap.keySet().size());
		//System.out.println(edgeMap.values());
		// Filter non-accepting edges
		Set<Integer> possibleOutputs = new HashSet<>();
		//System.out.println("Current edges:");
		for(Edge<S> e : currentEdges) {
			if(e.hasAcceptanceSets()) {
				possibleOutputs.addAll(edgeMap.get(e));
			}
			//System.out.println(e + " acc: " + e.hasAcceptanceSets() + " val: " + edgeMap.get(e));
		}
		// Transform the atomic propositions back to Strings
		Set<String> result = new HashSet<>();
		//System.out.println(possibleOutputs);
		for(String key : alphabetMap.keySet()) {
			for(Integer op : possibleOutputs) {
				if(alphabetMap.get(key).equals(op)) {
					//System.out.println("OP: " + key);
					result.add(key);
				}
			}
		}
		return result;
		//System.out.println(new BitSet(7).nextSetBit(0));
	}

	@Override
	public void setInputAlphabet(List<String> inputAlphabet) {
		this.inputAlphabet = inputAlphabet;
	}

	@Override
	public List<String> getInputAlphabet() {
		return this.inputAlphabet;
	}

	@Override
	public void setOutputAlphabet(List<String> outputAlphabet) {
		this.outputAlphabet = outputAlphabet;
	}

	@Override
	public List<String> getOutputAlphabet() {
		return this.outputAlphabet;
	}
}
