package hu.bme.mit.ltl.serializer

import hu.bme.mit.ltl.LTLExpression
import hu.bme.mit.ltl.TrueExpression
import hu.bme.mit.ltl.FalseExpression
import hu.bme.mit.ltl.AtomicProposition
import hu.bme.mit.ltl.AndExpression
import hu.bme.mit.ltl.OrExpression
import hu.bme.mit.ltl.ImplyExpression
import hu.bme.mit.ltl.EquivalenceExpression
import hu.bme.mit.ltl.NotExpression
import hu.bme.mit.ltl.FutureExpression
import hu.bme.mit.ltl.GloballyExpression
import hu.bme.mit.ltl.NextExpression
import hu.bme.mit.ltl.UntilExpression

class BasicSerializer {
	
	private String opParenthesis = ""
	private String clParenthesis = ""
	
	new() {
		
	}
	
	new(boolean parenthesized) {
		if (parenthesized) {
			opParenthesis = "("
			clParenthesis = ")"
		}
	}
	
	public def dispatch String serialize(UntilExpression expression) {
		return opParenthesis + expression.leftOperand.serialize 
				+ 'U' 
				+ expression.rightOperand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(NextExpression expression) {
		return 'X' + opParenthesis + expression.operand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(GloballyExpression expression) {
		return 'G' + opParenthesis + expression.operand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(FutureExpression expression) {
		return 'F' + opParenthesis + expression.operand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(ImplyExpression expression) {
		return opParenthesis + expression.leftOperand.serialize + '->' + expression.rightOperand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(EquivalenceExpression expression) {
		return opParenthesis + expression.leftOperand.serialize + '<->' + expression.rightOperand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(OrExpression expression) {
		return opParenthesis + expression.leftOperand.serialize + '|' + expression.rightOperand.serialize + clParenthesis
	}
	
	public def dispatch String serialize(AndExpression expression) {
		return expression.leftOperand.serialize + '&' + expression.rightOperand.serialize
	}
	
	public def dispatch String serialize(NotExpression expression) {
		return  '!' + expression.operand.serialize
	}
	
	public def dispatch String serialize(AtomicProposition expression) {
		return expression.proposition
	}
	
	public def dispatch String serialize(TrueExpression expression) {
		return "true"
	}
	
	public def dispatch String serialize(FalseExpression expression) {
		return "false"
	}
	
}