package hu.bme.mit.ltl.serializer

import java.util.List
import hu.bme.mit.ltl.UntilExpression
import hu.bme.mit.ltl.NextExpression
import hu.bme.mit.ltl.GloballyExpression
import hu.bme.mit.ltl.FutureExpression
import hu.bme.mit.ltl.ImplyExpression
import hu.bme.mit.ltl.EquivalenceExpression
import hu.bme.mit.ltl.OrExpression
import hu.bme.mit.ltl.AndExpression
import hu.bme.mit.ltl.NotExpression
import hu.bme.mit.ltl.AtomicProposition
import hu.bme.mit.ltl.FalseExpression
import hu.bme.mit.ltl.TrueExpression
import java.util.Set
import java.util.HashSet
import java.util.Map
import java.util.HashMap
import java.util.ArrayList
import hu.bme.mit.ltl.LTLExpression

class EventSemanticSerializer {
	List<? extends String> inputAlphabet
	List<String> outputAlphabet
	var boolean grouping = true	//TODO fix this
	
	
	new(List<? extends String> inputAlphabet, List<String> outputAlphabet) {
		this.inputAlphabet = inputAlphabet
		this.outputAlphabet = outputAlphabet
	}
	
	public def String serialize(LTLExpression expression) {
		return expression.build.serialized
	}
	
	private def dispatch BuilderReturn build(UntilExpression expression) {
		var String newSerialized = "" 
		
		var BuilderReturn left = expression.leftOperand.build
		var BuilderReturn right = expression.rightOperand.build
		newSerialized += "(" + left.getSerialized
		if (left.needsCheck) {
			newSerialized += left.createExtension
		}
		
		newSerialized += ' U '
		
		newSerialized += right.getSerialized
		if (right.needsCheck) {
			newSerialized += right.createExtension
		}
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(NextExpression expression) {
		var String newSerialized = ""
		
		var BuilderReturn operand = expression.operand.build
		newSerialized += "X" + "(" + operand.getSerialized
		if (operand.needsCheck)
			newSerialized += operand.createExtension
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(GloballyExpression expression) {
		var String newSerialized = ""
		
		var BuilderReturn operand = expression.operand.build
		newSerialized += "G" + "(" + operand.getSerialized
		if (operand.needsCheck) {
			newSerialized += operand.createExtension
		}
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(FutureExpression expression) {
		var String newSerialized = ""
		
		var BuilderReturn operand = expression.operand.build
		newSerialized += "F" + "(" + operand.getSerialized
		if (operand.needsCheck)
			newSerialized += operand.createExtension
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(ImplyExpression expression) {
		var String newSerialized = "" 
		
		var BuilderReturn left = expression.leftOperand.build
		var BuilderReturn right = expression.rightOperand.build
		newSerialized += "("
		//if (grouping) newSerialized += "("
		newSerialized += left.getSerialized
		if (left.needsCheck) {
			newSerialized += left.createExtension
		}
		//if (grouping) newSerialized += ")"
		
		newSerialized += '->'
		
		//if (grouping) newSerialized += "("
		newSerialized += right.getSerialized
		if (right.needsCheck) {
			newSerialized += right.createExtension
		}
		//if (grouping) newSerialized += ")"
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(EquivalenceExpression expression) {
		var String newSerialized = "" 
		
		var BuilderReturn left = expression.leftOperand.build
		var BuilderReturn right = expression.rightOperand.build
		newSerialized += "("
		//if (grouping) newSerialized += "("
		newSerialized += left.serialized
		if (left.needsCheck) {
			newSerialized += left.createExtension
		}
		//if (grouping) newSerialized += ")"
		
		newSerialized += '<->'
		
		//if (grouping) newSerialized += "("
		newSerialized += right.getSerialized
		if (right.needsCheck) {
			newSerialized += right.createExtension
		}
		//if (grouping) newSerialized += ")"
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	
	}
	
	private def dispatch BuilderReturn build(OrExpression expression) {
		var String newSerialized = "" 
		
		var BuilderReturn left = expression.leftOperand.build
		var BuilderReturn right = expression.rightOperand.build
		newSerialized += "(" 
		if (grouping) newSerialized += "("
		newSerialized += left.getSerialized
		if (left.needsCheck) {
			newSerialized += left.createExtension
		}
		if (grouping) newSerialized += ")"
		
		newSerialized += '|'
		
		if (grouping) newSerialized += "("
		newSerialized += right.getSerialized
		if (right.needsCheck) {
			newSerialized += right.createExtension
		}
		if (grouping) newSerialized += ")"
		newSerialized += ")"
		
		return new BuilderReturn(newSerialized)
	}
	
	private def dispatch BuilderReturn build(AndExpression expression) {
		
		var String newSerialized = "" 
		var BuilderReturn left = expression.leftOperand.build
		var BuilderReturn right = expression.rightOperand.build
		
		if (left.needsCheck && right.needsCheck) { //if both need check, pass on
			//if (grouping) newSerialized += "("
			newSerialized += left.getSerialized
			newSerialized += "&"
			newSerialized += right.getSerialized
			//if (grouping) newSerialized += ")"
			var Set<AlphabetType> newAlphabetType = new HashSet<AlphabetType>()
			var Map<AlphabetType, Set<Integer>> newTokens = new HashMap
			
			newAlphabetType.addAll(left.getAlphabetType)
			newAlphabetType.addAll(right.getAlphabetType)
			for(t : newAlphabetType) {
				newTokens.put(t, new HashSet)
				if (left.getTokensFound.get(t) !== null)
					newTokens.get(t).addAll(left.getTokensFound.get(t))
				if (right.getTokensFound.get(t) !== null)
					newTokens.get(t).addAll(right.getTokensFound.get(t))
			}
			
			return new BuilderReturn(newSerialized, newAlphabetType, newTokens)
		} else {	//else do check
			//if (grouping) newSerialized += "("
			newSerialized += left.getSerialized
			if (left.needsCheck) {
				newSerialized += left.createExtension
			}
			newSerialized += '&'
			newSerialized += right.getSerialized
			if (right.needsCheck) {
				newSerialized += right.createExtension
			}
			//if (grouping) newSerialized += ")"
			return new BuilderReturn(newSerialized)
		}
	}
	
	private def dispatch BuilderReturn build(NotExpression expression) {
		var BuilderReturn result
		var BuilderReturn operand = expression.operand.build
		
		if (operand.needsCheck) {
			var Map<AlphabetType, Set<Integer>> negated = new HashMap 
			for (alphabet : operand.getTokensFound.keySet) {
				negated.put(alphabet, new HashSet)
				for (token : operand.getTokensFound.get(alphabet)) {
					negated.get(alphabet).add(-1 * token)
				}
			}
			result = new BuilderReturn("!" + operand.serialized, operand.alphabetType, negated)
		} else {
			result = new BuilderReturn("!" + operand.serialized)
		}
		
		return result
	}
	
	private def dispatch BuilderReturn build(AtomicProposition expression) {
		var BuilderReturn result
		var prop = expression.proposition.replace('.', '_')
		prop = prop.substring(0, 1).toLowerCase + prop.substring(1)
		if (inputAlphabet.contains(prop)) {
			result = new BuilderReturn(prop, AlphabetType.INPUT, inputAlphabet.indexOf(prop))
		} else if (outputAlphabet.contains(prop)) {
			result = new BuilderReturn(prop, AlphabetType.OUTPUT, outputAlphabet.indexOf(prop))
		} else {
			throw new IllegalArgumentException("Neither alphabet contains the given proposition: " + prop)
		}
		return result
	}
	
	private def dispatch BuilderReturn build(TrueExpression expression) {
		return new BuilderReturn("true")
	}
	
	private def dispatch BuilderReturn build(FalseExpression expression) {
		return new BuilderReturn("false")
	}
	
	private def String createExtension(BuilderReturn b) {
		var String inRet = ""
		if (b.getAlphabetType.contains(AlphabetType.INPUT)) {
			var boolean containsPositive = false
			for (var i = 0; i < inputAlphabet.size; i++) {
				if (!b.getTokensFound.get(AlphabetType.INPUT).contains(i)) {
					containsPositive = true
				}
			}
			if (containsPositive) {
				for (var i = 0; i < inputAlphabet.size; i++) {
					if (!b.getTokensFound.get(AlphabetType.INPUT).contains(i) && 
						!b.getTokensFound.get(AlphabetType.INPUT).contains(-i)
					) {
						
						inRet += "&!" + inputAlphabet.get(i)
					}
				}
			} else {
				var String temp = null
				for (p : inputAlphabet) {
					if (!b.getTokensFound.get(AlphabetType.INPUT).contains(-inputAlphabet.indexOf(p))) {
						if (temp !== null)
							temp += "|"
						temp += p
						for (q : inputAlphabet) {
							if (!(p == q) && !b.getTokensFound.get(AlphabetType.INPUT).contains(-inputAlphabet.indexOf(q))) {
								temp += "&!" + q
							}
						}
					}
				}
				inRet += "&(" + temp + ")"
			}
		}
		
		var String outRet = ""
		if (b.getAlphabetType.contains(AlphabetType.OUTPUT)) {
			var boolean containsPositive = false
			for (var i = 0; i < outputAlphabet.size; i++) {
				if (!b.getTokensFound.get(AlphabetType.OUTPUT).contains(i)) {
					containsPositive = true
				}
			}
			if (containsPositive) {
				for (var i = 0; i < outputAlphabet.size; i++) {
					if (!b.getTokensFound.get(AlphabetType.OUTPUT).contains(i) && 
						!b.getTokensFound.get(AlphabetType.OUTPUT).contains(-i)
					) {
						outRet += "&!" + outputAlphabet.get(i)
					}
				}
			} else {
				var String temp = null
				for (p : outputAlphabet) {
					if (!b.getTokensFound.get(AlphabetType.OUTPUT).contains(-outputAlphabet.indexOf(p))) {
						if (temp !== null)
							temp += "|"
						temp += p
						for (q : outputAlphabet) {
							if (!(p == q) && !b.getTokensFound.get(AlphabetType.OUTPUT).contains(-outputAlphabet.indexOf(q))) {
								temp += "&!" + q
							}
						}
					}
				}
				outRet += "&(" + temp + ")"
			}
		}
		return inRet + outRet
	}
	
	static class BuilderReturn {
		String serialized = "";
		Map<AlphabetType, Set<Integer>> tokensFound = new HashMap<AlphabetType, Set<Integer>> 
		Set<AlphabetType> alphabetType = new HashSet<AlphabetType>() 
		boolean needsCheck = false
		
		// Basic c'tor
		new(String serialized){
			this.serialized = serialized
		}
		// Atomic c'tor
		new(String serialized, AlphabetType alphabetType, Integer initialToken) {
			this.serialized = serialized
			this.alphabetType.add(alphabetType)
			var temp = new HashSet<Integer>
			temp.add(initialToken)
			this.tokensFound.put(alphabetType, temp)
			needsCheck = true
		}
		// Complex c'tor
		new(String serialized, Set<AlphabetType> alphabetType, Map<AlphabetType,Set<Integer>> tokens) {
			this.serialized = serialized
			this.alphabetType = alphabetType
			this.tokensFound = tokens
			needsCheck = true
		} 
		
		def Set<AlphabetType> getAlphabetType(){
			return alphabetType
		}
		
		def Map<AlphabetType, Set<Integer>> getTokensFound() {
			return tokensFound
		}
		
		def String getSerialized() {
			return serialized
		}
		
		def boolean needsCheck() {
			return needsCheck
		}
		
	} 
	
	enum AlphabetType {
		INPUT, 
		OUTPUT
	}
	
}