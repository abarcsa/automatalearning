/*
 * generated by Xtext 2.20.0
 */
package hu.bme.mit.mealymodel.parser.antlr;

import com.google.inject.Inject;
import hu.bme.mit.mealymodel.parser.antlr.internal.InternalMealyDslParser;
import hu.bme.mit.mealymodel.services.MealyDslGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class MealyDslParser extends AbstractAntlrParser {

	@Inject
	private MealyDslGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMealyDslParser createParser(XtextTokenStream stream) {
		return new InternalMealyDslParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "MealyMachine";
	}

	public MealyDslGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MealyDslGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
