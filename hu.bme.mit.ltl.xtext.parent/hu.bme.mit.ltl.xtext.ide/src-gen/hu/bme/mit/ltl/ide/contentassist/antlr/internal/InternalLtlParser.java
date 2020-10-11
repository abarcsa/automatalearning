package hu.bme.mit.ltl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.ltl.services.LtlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLtlParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'->'", "'<->'", "'|'", "'&'", "'U'", "'F'", "'G'", "'X'", "'('", "')'", "'!'", "'false'", "'true'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalLtlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLtlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLtlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLtl.g"; }


    	private LtlGrammarAccess grammarAccess;

    	public void setGrammarAccess(LtlGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleLTLExpression"
    // InternalLtl.g:53:1: entryRuleLTLExpression : ruleLTLExpression EOF ;
    public final void entryRuleLTLExpression() throws RecognitionException {
        try {
            // InternalLtl.g:54:1: ( ruleLTLExpression EOF )
            // InternalLtl.g:55:1: ruleLTLExpression EOF
            {
             before(grammarAccess.getLTLExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleLTLExpression();

            state._fsp--;

             after(grammarAccess.getLTLExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLTLExpression"


    // $ANTLR start "ruleLTLExpression"
    // InternalLtl.g:62:1: ruleLTLExpression : ( ruleArrowExpression ) ;
    public final void ruleLTLExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:66:2: ( ( ruleArrowExpression ) )
            // InternalLtl.g:67:2: ( ruleArrowExpression )
            {
            // InternalLtl.g:67:2: ( ruleArrowExpression )
            // InternalLtl.g:68:3: ruleArrowExpression
            {
             before(grammarAccess.getLTLExpressionAccess().getArrowExpressionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleArrowExpression();

            state._fsp--;

             after(grammarAccess.getLTLExpressionAccess().getArrowExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLTLExpression"


    // $ANTLR start "entryRuleArrowExpression"
    // InternalLtl.g:78:1: entryRuleArrowExpression : ruleArrowExpression EOF ;
    public final void entryRuleArrowExpression() throws RecognitionException {
        try {
            // InternalLtl.g:79:1: ( ruleArrowExpression EOF )
            // InternalLtl.g:80:1: ruleArrowExpression EOF
            {
             before(grammarAccess.getArrowExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleArrowExpression();

            state._fsp--;

             after(grammarAccess.getArrowExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrowExpression"


    // $ANTLR start "ruleArrowExpression"
    // InternalLtl.g:87:1: ruleArrowExpression : ( ( rule__ArrowExpression__Group__0 ) ) ;
    public final void ruleArrowExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:91:2: ( ( ( rule__ArrowExpression__Group__0 ) ) )
            // InternalLtl.g:92:2: ( ( rule__ArrowExpression__Group__0 ) )
            {
            // InternalLtl.g:92:2: ( ( rule__ArrowExpression__Group__0 ) )
            // InternalLtl.g:93:3: ( rule__ArrowExpression__Group__0 )
            {
             before(grammarAccess.getArrowExpressionAccess().getGroup()); 
            // InternalLtl.g:94:3: ( rule__ArrowExpression__Group__0 )
            // InternalLtl.g:94:4: rule__ArrowExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrowExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrowExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalLtl.g:103:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // InternalLtl.g:104:1: ( ruleOrExpression EOF )
            // InternalLtl.g:105:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalLtl.g:112:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:116:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // InternalLtl.g:117:2: ( ( rule__OrExpression__Group__0 ) )
            {
            // InternalLtl.g:117:2: ( ( rule__OrExpression__Group__0 ) )
            // InternalLtl.g:118:3: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // InternalLtl.g:119:3: ( rule__OrExpression__Group__0 )
            // InternalLtl.g:119:4: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalLtl.g:128:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // InternalLtl.g:129:1: ( ruleAndExpression EOF )
            // InternalLtl.g:130:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalLtl.g:137:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:141:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // InternalLtl.g:142:2: ( ( rule__AndExpression__Group__0 ) )
            {
            // InternalLtl.g:142:2: ( ( rule__AndExpression__Group__0 ) )
            // InternalLtl.g:143:3: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // InternalLtl.g:144:3: ( rule__AndExpression__Group__0 )
            // InternalLtl.g:144:4: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleUntilExpression"
    // InternalLtl.g:153:1: entryRuleUntilExpression : ruleUntilExpression EOF ;
    public final void entryRuleUntilExpression() throws RecognitionException {
        try {
            // InternalLtl.g:154:1: ( ruleUntilExpression EOF )
            // InternalLtl.g:155:1: ruleUntilExpression EOF
            {
             before(grammarAccess.getUntilExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleUntilExpression();

            state._fsp--;

             after(grammarAccess.getUntilExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUntilExpression"


    // $ANTLR start "ruleUntilExpression"
    // InternalLtl.g:162:1: ruleUntilExpression : ( ( rule__UntilExpression__Group__0 ) ) ;
    public final void ruleUntilExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:166:2: ( ( ( rule__UntilExpression__Group__0 ) ) )
            // InternalLtl.g:167:2: ( ( rule__UntilExpression__Group__0 ) )
            {
            // InternalLtl.g:167:2: ( ( rule__UntilExpression__Group__0 ) )
            // InternalLtl.g:168:3: ( rule__UntilExpression__Group__0 )
            {
             before(grammarAccess.getUntilExpressionAccess().getGroup()); 
            // InternalLtl.g:169:3: ( rule__UntilExpression__Group__0 )
            // InternalLtl.g:169:4: rule__UntilExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUntilExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUntilExpression"


    // $ANTLR start "entryRuleFutureGloballyExpression"
    // InternalLtl.g:178:1: entryRuleFutureGloballyExpression : ruleFutureGloballyExpression EOF ;
    public final void entryRuleFutureGloballyExpression() throws RecognitionException {
        try {
            // InternalLtl.g:179:1: ( ruleFutureGloballyExpression EOF )
            // InternalLtl.g:180:1: ruleFutureGloballyExpression EOF
            {
             before(grammarAccess.getFutureGloballyExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleFutureGloballyExpression();

            state._fsp--;

             after(grammarAccess.getFutureGloballyExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFutureGloballyExpression"


    // $ANTLR start "ruleFutureGloballyExpression"
    // InternalLtl.g:187:1: ruleFutureGloballyExpression : ( ( rule__FutureGloballyExpression__Alternatives ) ) ;
    public final void ruleFutureGloballyExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:191:2: ( ( ( rule__FutureGloballyExpression__Alternatives ) ) )
            // InternalLtl.g:192:2: ( ( rule__FutureGloballyExpression__Alternatives ) )
            {
            // InternalLtl.g:192:2: ( ( rule__FutureGloballyExpression__Alternatives ) )
            // InternalLtl.g:193:3: ( rule__FutureGloballyExpression__Alternatives )
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getAlternatives()); 
            // InternalLtl.g:194:3: ( rule__FutureGloballyExpression__Alternatives )
            // InternalLtl.g:194:4: rule__FutureGloballyExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFutureGloballyExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFutureGloballyExpression"


    // $ANTLR start "entryRuleNextExpression"
    // InternalLtl.g:203:1: entryRuleNextExpression : ruleNextExpression EOF ;
    public final void entryRuleNextExpression() throws RecognitionException {
        try {
            // InternalLtl.g:204:1: ( ruleNextExpression EOF )
            // InternalLtl.g:205:1: ruleNextExpression EOF
            {
             before(grammarAccess.getNextExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleNextExpression();

            state._fsp--;

             after(grammarAccess.getNextExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNextExpression"


    // $ANTLR start "ruleNextExpression"
    // InternalLtl.g:212:1: ruleNextExpression : ( ( rule__NextExpression__Alternatives ) ) ;
    public final void ruleNextExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:216:2: ( ( ( rule__NextExpression__Alternatives ) ) )
            // InternalLtl.g:217:2: ( ( rule__NextExpression__Alternatives ) )
            {
            // InternalLtl.g:217:2: ( ( rule__NextExpression__Alternatives ) )
            // InternalLtl.g:218:3: ( rule__NextExpression__Alternatives )
            {
             before(grammarAccess.getNextExpressionAccess().getAlternatives()); 
            // InternalLtl.g:219:3: ( rule__NextExpression__Alternatives )
            // InternalLtl.g:219:4: rule__NextExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NextExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNextExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNextExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalLtl.g:228:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // InternalLtl.g:229:1: ( rulePrimaryExpression EOF )
            // InternalLtl.g:230:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalLtl.g:237:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:241:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // InternalLtl.g:242:2: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // InternalLtl.g:242:2: ( ( rule__PrimaryExpression__Alternatives ) )
            // InternalLtl.g:243:3: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // InternalLtl.g:244:3: ( rule__PrimaryExpression__Alternatives )
            // InternalLtl.g:244:4: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalLtl.g:253:1: entryRuleLiteralExpression : ruleLiteralExpression EOF ;
    public final void entryRuleLiteralExpression() throws RecognitionException {
        try {
            // InternalLtl.g:254:1: ( ruleLiteralExpression EOF )
            // InternalLtl.g:255:1: ruleLiteralExpression EOF
            {
             before(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalLtl.g:262:1: ruleLiteralExpression : ( ( rule__LiteralExpression__Alternatives ) ) ;
    public final void ruleLiteralExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:266:2: ( ( ( rule__LiteralExpression__Alternatives ) ) )
            // InternalLtl.g:267:2: ( ( rule__LiteralExpression__Alternatives ) )
            {
            // InternalLtl.g:267:2: ( ( rule__LiteralExpression__Alternatives ) )
            // InternalLtl.g:268:3: ( rule__LiteralExpression__Alternatives )
            {
             before(grammarAccess.getLiteralExpressionAccess().getAlternatives()); 
            // InternalLtl.g:269:3: ( rule__LiteralExpression__Alternatives )
            // InternalLtl.g:269:4: rule__LiteralExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleFalseExpression"
    // InternalLtl.g:278:1: entryRuleFalseExpression : ruleFalseExpression EOF ;
    public final void entryRuleFalseExpression() throws RecognitionException {
        try {
            // InternalLtl.g:279:1: ( ruleFalseExpression EOF )
            // InternalLtl.g:280:1: ruleFalseExpression EOF
            {
             before(grammarAccess.getFalseExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleFalseExpression();

            state._fsp--;

             after(grammarAccess.getFalseExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFalseExpression"


    // $ANTLR start "ruleFalseExpression"
    // InternalLtl.g:287:1: ruleFalseExpression : ( ( rule__FalseExpression__Group__0 ) ) ;
    public final void ruleFalseExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:291:2: ( ( ( rule__FalseExpression__Group__0 ) ) )
            // InternalLtl.g:292:2: ( ( rule__FalseExpression__Group__0 ) )
            {
            // InternalLtl.g:292:2: ( ( rule__FalseExpression__Group__0 ) )
            // InternalLtl.g:293:3: ( rule__FalseExpression__Group__0 )
            {
             before(grammarAccess.getFalseExpressionAccess().getGroup()); 
            // InternalLtl.g:294:3: ( rule__FalseExpression__Group__0 )
            // InternalLtl.g:294:4: rule__FalseExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FalseExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFalseExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFalseExpression"


    // $ANTLR start "entryRuleTrueExpression"
    // InternalLtl.g:303:1: entryRuleTrueExpression : ruleTrueExpression EOF ;
    public final void entryRuleTrueExpression() throws RecognitionException {
        try {
            // InternalLtl.g:304:1: ( ruleTrueExpression EOF )
            // InternalLtl.g:305:1: ruleTrueExpression EOF
            {
             before(grammarAccess.getTrueExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleTrueExpression();

            state._fsp--;

             after(grammarAccess.getTrueExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrueExpression"


    // $ANTLR start "ruleTrueExpression"
    // InternalLtl.g:312:1: ruleTrueExpression : ( ( rule__TrueExpression__Group__0 ) ) ;
    public final void ruleTrueExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:316:2: ( ( ( rule__TrueExpression__Group__0 ) ) )
            // InternalLtl.g:317:2: ( ( rule__TrueExpression__Group__0 ) )
            {
            // InternalLtl.g:317:2: ( ( rule__TrueExpression__Group__0 ) )
            // InternalLtl.g:318:3: ( rule__TrueExpression__Group__0 )
            {
             before(grammarAccess.getTrueExpressionAccess().getGroup()); 
            // InternalLtl.g:319:3: ( rule__TrueExpression__Group__0 )
            // InternalLtl.g:319:4: rule__TrueExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrueExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrueExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrueExpression"


    // $ANTLR start "entryRuleAtomicProposition"
    // InternalLtl.g:328:1: entryRuleAtomicProposition : ruleAtomicProposition EOF ;
    public final void entryRuleAtomicProposition() throws RecognitionException {
        try {
            // InternalLtl.g:329:1: ( ruleAtomicProposition EOF )
            // InternalLtl.g:330:1: ruleAtomicProposition EOF
            {
             before(grammarAccess.getAtomicPropositionRule()); 
            pushFollow(FOLLOW_1);
            ruleAtomicProposition();

            state._fsp--;

             after(grammarAccess.getAtomicPropositionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtomicProposition"


    // $ANTLR start "ruleAtomicProposition"
    // InternalLtl.g:337:1: ruleAtomicProposition : ( ( rule__AtomicProposition__Group__0 ) ) ;
    public final void ruleAtomicProposition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:341:2: ( ( ( rule__AtomicProposition__Group__0 ) ) )
            // InternalLtl.g:342:2: ( ( rule__AtomicProposition__Group__0 ) )
            {
            // InternalLtl.g:342:2: ( ( rule__AtomicProposition__Group__0 ) )
            // InternalLtl.g:343:3: ( rule__AtomicProposition__Group__0 )
            {
             before(grammarAccess.getAtomicPropositionAccess().getGroup()); 
            // InternalLtl.g:344:3: ( rule__AtomicProposition__Group__0 )
            // InternalLtl.g:344:4: rule__AtomicProposition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AtomicProposition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAtomicPropositionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomicProposition"


    // $ANTLR start "entryRuleEString"
    // InternalLtl.g:353:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalLtl.g:354:1: ( ruleEString EOF )
            // InternalLtl.g:355:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalLtl.g:362:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:366:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalLtl.g:367:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalLtl.g:367:2: ( ( rule__EString__Alternatives ) )
            // InternalLtl.g:368:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalLtl.g:369:3: ( rule__EString__Alternatives )
            // InternalLtl.g:369:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "rule__ArrowExpression__Alternatives_1"
    // InternalLtl.g:377:1: rule__ArrowExpression__Alternatives_1 : ( ( ( rule__ArrowExpression__Group_1_0__0 ) ) | ( ( rule__ArrowExpression__Group_1_1__0 ) ) );
    public final void rule__ArrowExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:381:1: ( ( ( rule__ArrowExpression__Group_1_0__0 ) ) | ( ( rule__ArrowExpression__Group_1_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalLtl.g:382:2: ( ( rule__ArrowExpression__Group_1_0__0 ) )
                    {
                    // InternalLtl.g:382:2: ( ( rule__ArrowExpression__Group_1_0__0 ) )
                    // InternalLtl.g:383:3: ( rule__ArrowExpression__Group_1_0__0 )
                    {
                     before(grammarAccess.getArrowExpressionAccess().getGroup_1_0()); 
                    // InternalLtl.g:384:3: ( rule__ArrowExpression__Group_1_0__0 )
                    // InternalLtl.g:384:4: rule__ArrowExpression__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrowExpression__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowExpressionAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:388:2: ( ( rule__ArrowExpression__Group_1_1__0 ) )
                    {
                    // InternalLtl.g:388:2: ( ( rule__ArrowExpression__Group_1_1__0 ) )
                    // InternalLtl.g:389:3: ( rule__ArrowExpression__Group_1_1__0 )
                    {
                     before(grammarAccess.getArrowExpressionAccess().getGroup_1_1()); 
                    // InternalLtl.g:390:3: ( rule__ArrowExpression__Group_1_1__0 )
                    // InternalLtl.g:390:4: rule__ArrowExpression__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrowExpression__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getArrowExpressionAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Alternatives_1"


    // $ANTLR start "rule__FutureGloballyExpression__Alternatives"
    // InternalLtl.g:398:1: rule__FutureGloballyExpression__Alternatives : ( ( ( rule__FutureGloballyExpression__Group_0__0 ) ) | ( ( rule__FutureGloballyExpression__Group_1__0 ) ) | ( ruleNextExpression ) );
    public final void rule__FutureGloballyExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:402:1: ( ( ( rule__FutureGloballyExpression__Group_0__0 ) ) | ( ( rule__FutureGloballyExpression__Group_1__0 ) ) | ( ruleNextExpression ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case 18:
            case 19:
            case 21:
            case 22:
            case 23:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalLtl.g:403:2: ( ( rule__FutureGloballyExpression__Group_0__0 ) )
                    {
                    // InternalLtl.g:403:2: ( ( rule__FutureGloballyExpression__Group_0__0 ) )
                    // InternalLtl.g:404:3: ( rule__FutureGloballyExpression__Group_0__0 )
                    {
                     before(grammarAccess.getFutureGloballyExpressionAccess().getGroup_0()); 
                    // InternalLtl.g:405:3: ( rule__FutureGloballyExpression__Group_0__0 )
                    // InternalLtl.g:405:4: rule__FutureGloballyExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FutureGloballyExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFutureGloballyExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:409:2: ( ( rule__FutureGloballyExpression__Group_1__0 ) )
                    {
                    // InternalLtl.g:409:2: ( ( rule__FutureGloballyExpression__Group_1__0 ) )
                    // InternalLtl.g:410:3: ( rule__FutureGloballyExpression__Group_1__0 )
                    {
                     before(grammarAccess.getFutureGloballyExpressionAccess().getGroup_1()); 
                    // InternalLtl.g:411:3: ( rule__FutureGloballyExpression__Group_1__0 )
                    // InternalLtl.g:411:4: rule__FutureGloballyExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__FutureGloballyExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getFutureGloballyExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLtl.g:415:2: ( ruleNextExpression )
                    {
                    // InternalLtl.g:415:2: ( ruleNextExpression )
                    // InternalLtl.g:416:3: ruleNextExpression
                    {
                     before(grammarAccess.getFutureGloballyExpressionAccess().getNextExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleNextExpression();

                    state._fsp--;

                     after(grammarAccess.getFutureGloballyExpressionAccess().getNextExpressionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Alternatives"


    // $ANTLR start "rule__NextExpression__Alternatives"
    // InternalLtl.g:425:1: rule__NextExpression__Alternatives : ( ( ( rule__NextExpression__Group_0__0 ) ) | ( rulePrimaryExpression ) );
    public final void rule__NextExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:429:1: ( ( ( rule__NextExpression__Group_0__0 ) ) | ( rulePrimaryExpression ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)||LA3_0==19||(LA3_0>=21 && LA3_0<=23)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalLtl.g:430:2: ( ( rule__NextExpression__Group_0__0 ) )
                    {
                    // InternalLtl.g:430:2: ( ( rule__NextExpression__Group_0__0 ) )
                    // InternalLtl.g:431:3: ( rule__NextExpression__Group_0__0 )
                    {
                     before(grammarAccess.getNextExpressionAccess().getGroup_0()); 
                    // InternalLtl.g:432:3: ( rule__NextExpression__Group_0__0 )
                    // InternalLtl.g:432:4: rule__NextExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__NextExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNextExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:436:2: ( rulePrimaryExpression )
                    {
                    // InternalLtl.g:436:2: ( rulePrimaryExpression )
                    // InternalLtl.g:437:3: rulePrimaryExpression
                    {
                     before(grammarAccess.getNextExpressionAccess().getPrimaryExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getNextExpressionAccess().getPrimaryExpressionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // InternalLtl.g:446:1: rule__PrimaryExpression__Alternatives : ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ruleLiteralExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:450:1: ( ( ( rule__PrimaryExpression__Group_0__0 ) ) | ( ( rule__PrimaryExpression__Group_1__0 ) ) | ( ruleLiteralExpression ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case 22:
            case 23:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalLtl.g:451:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    {
                    // InternalLtl.g:451:2: ( ( rule__PrimaryExpression__Group_0__0 ) )
                    // InternalLtl.g:452:3: ( rule__PrimaryExpression__Group_0__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 
                    // InternalLtl.g:453:3: ( rule__PrimaryExpression__Group_0__0 )
                    // InternalLtl.g:453:4: rule__PrimaryExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:457:2: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    {
                    // InternalLtl.g:457:2: ( ( rule__PrimaryExpression__Group_1__0 ) )
                    // InternalLtl.g:458:3: ( rule__PrimaryExpression__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 
                    // InternalLtl.g:459:3: ( rule__PrimaryExpression__Group_1__0 )
                    // InternalLtl.g:459:4: rule__PrimaryExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLtl.g:463:2: ( ruleLiteralExpression )
                    {
                    // InternalLtl.g:463:2: ( ruleLiteralExpression )
                    // InternalLtl.g:464:3: ruleLiteralExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__LiteralExpression__Alternatives"
    // InternalLtl.g:473:1: rule__LiteralExpression__Alternatives : ( ( ruleAtomicProposition ) | ( ruleTrueExpression ) | ( ruleFalseExpression ) );
    public final void rule__LiteralExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:477:1: ( ( ruleAtomicProposition ) | ( ruleTrueExpression ) | ( ruleFalseExpression ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 23:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalLtl.g:478:2: ( ruleAtomicProposition )
                    {
                    // InternalLtl.g:478:2: ( ruleAtomicProposition )
                    // InternalLtl.g:479:3: ruleAtomicProposition
                    {
                     before(grammarAccess.getLiteralExpressionAccess().getAtomicPropositionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAtomicProposition();

                    state._fsp--;

                     after(grammarAccess.getLiteralExpressionAccess().getAtomicPropositionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:484:2: ( ruleTrueExpression )
                    {
                    // InternalLtl.g:484:2: ( ruleTrueExpression )
                    // InternalLtl.g:485:3: ruleTrueExpression
                    {
                     before(grammarAccess.getLiteralExpressionAccess().getTrueExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTrueExpression();

                    state._fsp--;

                     after(grammarAccess.getLiteralExpressionAccess().getTrueExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLtl.g:490:2: ( ruleFalseExpression )
                    {
                    // InternalLtl.g:490:2: ( ruleFalseExpression )
                    // InternalLtl.g:491:3: ruleFalseExpression
                    {
                     before(grammarAccess.getLiteralExpressionAccess().getFalseExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFalseExpression();

                    state._fsp--;

                     after(grammarAccess.getLiteralExpressionAccess().getFalseExpressionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalLtl.g:500:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:504:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalLtl.g:505:2: ( RULE_STRING )
                    {
                    // InternalLtl.g:505:2: ( RULE_STRING )
                    // InternalLtl.g:506:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:511:2: ( RULE_ID )
                    {
                    // InternalLtl.g:511:2: ( RULE_ID )
                    // InternalLtl.g:512:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__ArrowExpression__Group__0"
    // InternalLtl.g:521:1: rule__ArrowExpression__Group__0 : rule__ArrowExpression__Group__0__Impl rule__ArrowExpression__Group__1 ;
    public final void rule__ArrowExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:525:1: ( rule__ArrowExpression__Group__0__Impl rule__ArrowExpression__Group__1 )
            // InternalLtl.g:526:2: rule__ArrowExpression__Group__0__Impl rule__ArrowExpression__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ArrowExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group__0"


    // $ANTLR start "rule__ArrowExpression__Group__0__Impl"
    // InternalLtl.g:533:1: rule__ArrowExpression__Group__0__Impl : ( ruleOrExpression ) ;
    public final void rule__ArrowExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:537:1: ( ( ruleOrExpression ) )
            // InternalLtl.g:538:1: ( ruleOrExpression )
            {
            // InternalLtl.g:538:1: ( ruleOrExpression )
            // InternalLtl.g:539:2: ruleOrExpression
            {
             before(grammarAccess.getArrowExpressionAccess().getOrExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getArrowExpressionAccess().getOrExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group__0__Impl"


    // $ANTLR start "rule__ArrowExpression__Group__1"
    // InternalLtl.g:548:1: rule__ArrowExpression__Group__1 : rule__ArrowExpression__Group__1__Impl ;
    public final void rule__ArrowExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:552:1: ( rule__ArrowExpression__Group__1__Impl )
            // InternalLtl.g:553:2: rule__ArrowExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group__1"


    // $ANTLR start "rule__ArrowExpression__Group__1__Impl"
    // InternalLtl.g:559:1: rule__ArrowExpression__Group__1__Impl : ( ( rule__ArrowExpression__Alternatives_1 )? ) ;
    public final void rule__ArrowExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:563:1: ( ( ( rule__ArrowExpression__Alternatives_1 )? ) )
            // InternalLtl.g:564:1: ( ( rule__ArrowExpression__Alternatives_1 )? )
            {
            // InternalLtl.g:564:1: ( ( rule__ArrowExpression__Alternatives_1 )? )
            // InternalLtl.g:565:2: ( rule__ArrowExpression__Alternatives_1 )?
            {
             before(grammarAccess.getArrowExpressionAccess().getAlternatives_1()); 
            // InternalLtl.g:566:2: ( rule__ArrowExpression__Alternatives_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=11 && LA7_0<=12)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLtl.g:566:3: rule__ArrowExpression__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ArrowExpression__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArrowExpressionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group__1__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__0"
    // InternalLtl.g:575:1: rule__ArrowExpression__Group_1_0__0 : rule__ArrowExpression__Group_1_0__0__Impl rule__ArrowExpression__Group_1_0__1 ;
    public final void rule__ArrowExpression__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:579:1: ( rule__ArrowExpression__Group_1_0__0__Impl rule__ArrowExpression__Group_1_0__1 )
            // InternalLtl.g:580:2: rule__ArrowExpression__Group_1_0__0__Impl rule__ArrowExpression__Group_1_0__1
            {
            pushFollow(FOLLOW_4);
            rule__ArrowExpression__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__0"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__0__Impl"
    // InternalLtl.g:587:1: rule__ArrowExpression__Group_1_0__0__Impl : ( () ) ;
    public final void rule__ArrowExpression__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:591:1: ( ( () ) )
            // InternalLtl.g:592:1: ( () )
            {
            // InternalLtl.g:592:1: ( () )
            // InternalLtl.g:593:2: ()
            {
             before(grammarAccess.getArrowExpressionAccess().getImplyExpressionLeftOperandAction_1_0_0()); 
            // InternalLtl.g:594:2: ()
            // InternalLtl.g:594:3: 
            {
            }

             after(grammarAccess.getArrowExpressionAccess().getImplyExpressionLeftOperandAction_1_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__0__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__1"
    // InternalLtl.g:602:1: rule__ArrowExpression__Group_1_0__1 : rule__ArrowExpression__Group_1_0__1__Impl rule__ArrowExpression__Group_1_0__2 ;
    public final void rule__ArrowExpression__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:606:1: ( rule__ArrowExpression__Group_1_0__1__Impl rule__ArrowExpression__Group_1_0__2 )
            // InternalLtl.g:607:2: rule__ArrowExpression__Group_1_0__1__Impl rule__ArrowExpression__Group_1_0__2
            {
            pushFollow(FOLLOW_5);
            rule__ArrowExpression__Group_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__1"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__1__Impl"
    // InternalLtl.g:614:1: rule__ArrowExpression__Group_1_0__1__Impl : ( '->' ) ;
    public final void rule__ArrowExpression__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:618:1: ( ( '->' ) )
            // InternalLtl.g:619:1: ( '->' )
            {
            // InternalLtl.g:619:1: ( '->' )
            // InternalLtl.g:620:2: '->'
            {
             before(grammarAccess.getArrowExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_0_1()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getArrowExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__1__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__2"
    // InternalLtl.g:629:1: rule__ArrowExpression__Group_1_0__2 : rule__ArrowExpression__Group_1_0__2__Impl ;
    public final void rule__ArrowExpression__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:633:1: ( rule__ArrowExpression__Group_1_0__2__Impl )
            // InternalLtl.g:634:2: rule__ArrowExpression__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__2"


    // $ANTLR start "rule__ArrowExpression__Group_1_0__2__Impl"
    // InternalLtl.g:640:1: rule__ArrowExpression__Group_1_0__2__Impl : ( ( rule__ArrowExpression__RightOperandAssignment_1_0_2 ) ) ;
    public final void rule__ArrowExpression__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:644:1: ( ( ( rule__ArrowExpression__RightOperandAssignment_1_0_2 ) ) )
            // InternalLtl.g:645:1: ( ( rule__ArrowExpression__RightOperandAssignment_1_0_2 ) )
            {
            // InternalLtl.g:645:1: ( ( rule__ArrowExpression__RightOperandAssignment_1_0_2 ) )
            // InternalLtl.g:646:2: ( rule__ArrowExpression__RightOperandAssignment_1_0_2 )
            {
             before(grammarAccess.getArrowExpressionAccess().getRightOperandAssignment_1_0_2()); 
            // InternalLtl.g:647:2: ( rule__ArrowExpression__RightOperandAssignment_1_0_2 )
            // InternalLtl.g:647:3: rule__ArrowExpression__RightOperandAssignment_1_0_2
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__RightOperandAssignment_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowExpressionAccess().getRightOperandAssignment_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_0__2__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__0"
    // InternalLtl.g:656:1: rule__ArrowExpression__Group_1_1__0 : rule__ArrowExpression__Group_1_1__0__Impl rule__ArrowExpression__Group_1_1__1 ;
    public final void rule__ArrowExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:660:1: ( rule__ArrowExpression__Group_1_1__0__Impl rule__ArrowExpression__Group_1_1__1 )
            // InternalLtl.g:661:2: rule__ArrowExpression__Group_1_1__0__Impl rule__ArrowExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ArrowExpression__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__0"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__0__Impl"
    // InternalLtl.g:668:1: rule__ArrowExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__ArrowExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:672:1: ( ( () ) )
            // InternalLtl.g:673:1: ( () )
            {
            // InternalLtl.g:673:1: ( () )
            // InternalLtl.g:674:2: ()
            {
             before(grammarAccess.getArrowExpressionAccess().getEquivalenceExpressionLeftOperandAction_1_1_0()); 
            // InternalLtl.g:675:2: ()
            // InternalLtl.g:675:3: 
            {
            }

             after(grammarAccess.getArrowExpressionAccess().getEquivalenceExpressionLeftOperandAction_1_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__0__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__1"
    // InternalLtl.g:683:1: rule__ArrowExpression__Group_1_1__1 : rule__ArrowExpression__Group_1_1__1__Impl rule__ArrowExpression__Group_1_1__2 ;
    public final void rule__ArrowExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:687:1: ( rule__ArrowExpression__Group_1_1__1__Impl rule__ArrowExpression__Group_1_1__2 )
            // InternalLtl.g:688:2: rule__ArrowExpression__Group_1_1__1__Impl rule__ArrowExpression__Group_1_1__2
            {
            pushFollow(FOLLOW_5);
            rule__ArrowExpression__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__1"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__1__Impl"
    // InternalLtl.g:695:1: rule__ArrowExpression__Group_1_1__1__Impl : ( '<->' ) ;
    public final void rule__ArrowExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:699:1: ( ( '<->' ) )
            // InternalLtl.g:700:1: ( '<->' )
            {
            // InternalLtl.g:700:1: ( '<->' )
            // InternalLtl.g:701:2: '<->'
            {
             before(grammarAccess.getArrowExpressionAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getArrowExpressionAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__1__Impl"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__2"
    // InternalLtl.g:710:1: rule__ArrowExpression__Group_1_1__2 : rule__ArrowExpression__Group_1_1__2__Impl ;
    public final void rule__ArrowExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:714:1: ( rule__ArrowExpression__Group_1_1__2__Impl )
            // InternalLtl.g:715:2: rule__ArrowExpression__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__Group_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__2"


    // $ANTLR start "rule__ArrowExpression__Group_1_1__2__Impl"
    // InternalLtl.g:721:1: rule__ArrowExpression__Group_1_1__2__Impl : ( ( rule__ArrowExpression__RightOperandAssignment_1_1_2 ) ) ;
    public final void rule__ArrowExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:725:1: ( ( ( rule__ArrowExpression__RightOperandAssignment_1_1_2 ) ) )
            // InternalLtl.g:726:1: ( ( rule__ArrowExpression__RightOperandAssignment_1_1_2 ) )
            {
            // InternalLtl.g:726:1: ( ( rule__ArrowExpression__RightOperandAssignment_1_1_2 ) )
            // InternalLtl.g:727:2: ( rule__ArrowExpression__RightOperandAssignment_1_1_2 )
            {
             before(grammarAccess.getArrowExpressionAccess().getRightOperandAssignment_1_1_2()); 
            // InternalLtl.g:728:2: ( rule__ArrowExpression__RightOperandAssignment_1_1_2 )
            // InternalLtl.g:728:3: rule__ArrowExpression__RightOperandAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ArrowExpression__RightOperandAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowExpressionAccess().getRightOperandAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__Group_1_1__2__Impl"


    // $ANTLR start "rule__OrExpression__Group__0"
    // InternalLtl.g:737:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:741:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // InternalLtl.g:742:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0"


    // $ANTLR start "rule__OrExpression__Group__0__Impl"
    // InternalLtl.g:749:1: rule__OrExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:753:1: ( ( ruleAndExpression ) )
            // InternalLtl.g:754:1: ( ruleAndExpression )
            {
            // InternalLtl.g:754:1: ( ruleAndExpression )
            // InternalLtl.g:755:2: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0__Impl"


    // $ANTLR start "rule__OrExpression__Group__1"
    // InternalLtl.g:764:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:768:1: ( rule__OrExpression__Group__1__Impl )
            // InternalLtl.g:769:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1"


    // $ANTLR start "rule__OrExpression__Group__1__Impl"
    // InternalLtl.g:775:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:779:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // InternalLtl.g:780:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // InternalLtl.g:780:1: ( ( rule__OrExpression__Group_1__0 )* )
            // InternalLtl.g:781:2: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // InternalLtl.g:782:2: ( rule__OrExpression__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==13) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalLtl.g:782:3: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getOrExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__0"
    // InternalLtl.g:791:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:795:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // InternalLtl.g:796:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_6);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0"


    // $ANTLR start "rule__OrExpression__Group_1__0__Impl"
    // InternalLtl.g:803:1: rule__OrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:807:1: ( ( () ) )
            // InternalLtl.g:808:1: ( () )
            {
            // InternalLtl.g:808:1: ( () )
            // InternalLtl.g:809:2: ()
            {
             before(grammarAccess.getOrExpressionAccess().getOrExpressionLeftOperandAction_1_0()); 
            // InternalLtl.g:810:2: ()
            // InternalLtl.g:810:3: 
            {
            }

             after(grammarAccess.getOrExpressionAccess().getOrExpressionLeftOperandAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__1"
    // InternalLtl.g:818:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:822:1: ( rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 )
            // InternalLtl.g:823:2: rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__OrExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1"


    // $ANTLR start "rule__OrExpression__Group_1__1__Impl"
    // InternalLtl.g:830:1: rule__OrExpression__Group_1__1__Impl : ( '|' ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:834:1: ( ( '|' ) )
            // InternalLtl.g:835:1: ( '|' )
            {
            // InternalLtl.g:835:1: ( '|' )
            // InternalLtl.g:836:2: '|'
            {
             before(grammarAccess.getOrExpressionAccess().getVerticalLineKeyword_1_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getOrExpressionAccess().getVerticalLineKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__2"
    // InternalLtl.g:845:1: rule__OrExpression__Group_1__2 : rule__OrExpression__Group_1__2__Impl ;
    public final void rule__OrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:849:1: ( rule__OrExpression__Group_1__2__Impl )
            // InternalLtl.g:850:2: rule__OrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__2"


    // $ANTLR start "rule__OrExpression__Group_1__2__Impl"
    // InternalLtl.g:856:1: rule__OrExpression__Group_1__2__Impl : ( ( rule__OrExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__OrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:860:1: ( ( ( rule__OrExpression__RightOperandAssignment_1_2 ) ) )
            // InternalLtl.g:861:1: ( ( rule__OrExpression__RightOperandAssignment_1_2 ) )
            {
            // InternalLtl.g:861:1: ( ( rule__OrExpression__RightOperandAssignment_1_2 ) )
            // InternalLtl.g:862:2: ( rule__OrExpression__RightOperandAssignment_1_2 )
            {
             before(grammarAccess.getOrExpressionAccess().getRightOperandAssignment_1_2()); 
            // InternalLtl.g:863:2: ( rule__OrExpression__RightOperandAssignment_1_2 )
            // InternalLtl.g:863:3: rule__OrExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__RightOperandAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getRightOperandAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__2__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // InternalLtl.g:872:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:876:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // InternalLtl.g:877:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // InternalLtl.g:884:1: rule__AndExpression__Group__0__Impl : ( ruleUntilExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:888:1: ( ( ruleUntilExpression ) )
            // InternalLtl.g:889:1: ( ruleUntilExpression )
            {
            // InternalLtl.g:889:1: ( ruleUntilExpression )
            // InternalLtl.g:890:2: ruleUntilExpression
            {
             before(grammarAccess.getAndExpressionAccess().getUntilExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleUntilExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getUntilExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // InternalLtl.g:899:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:903:1: ( rule__AndExpression__Group__1__Impl )
            // InternalLtl.g:904:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // InternalLtl.g:910:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:914:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // InternalLtl.g:915:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // InternalLtl.g:915:1: ( ( rule__AndExpression__Group_1__0 )* )
            // InternalLtl.g:916:2: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // InternalLtl.g:917:2: ( rule__AndExpression__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalLtl.g:917:3: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__0"
    // InternalLtl.g:926:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:930:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // InternalLtl.g:931:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0"


    // $ANTLR start "rule__AndExpression__Group_1__0__Impl"
    // InternalLtl.g:938:1: rule__AndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:942:1: ( ( () ) )
            // InternalLtl.g:943:1: ( () )
            {
            // InternalLtl.g:943:1: ( () )
            // InternalLtl.g:944:2: ()
            {
             before(grammarAccess.getAndExpressionAccess().getAndExpressionLeftOperandAction_1_0()); 
            // InternalLtl.g:945:2: ()
            // InternalLtl.g:945:3: 
            {
            }

             after(grammarAccess.getAndExpressionAccess().getAndExpressionLeftOperandAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__1"
    // InternalLtl.g:953:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:957:1: ( rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 )
            // InternalLtl.g:958:2: rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__AndExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1"


    // $ANTLR start "rule__AndExpression__Group_1__1__Impl"
    // InternalLtl.g:965:1: rule__AndExpression__Group_1__1__Impl : ( '&' ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:969:1: ( ( '&' ) )
            // InternalLtl.g:970:1: ( '&' )
            {
            // InternalLtl.g:970:1: ( '&' )
            // InternalLtl.g:971:2: '&'
            {
             before(grammarAccess.getAndExpressionAccess().getAmpersandKeyword_1_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getAndExpressionAccess().getAmpersandKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__2"
    // InternalLtl.g:980:1: rule__AndExpression__Group_1__2 : rule__AndExpression__Group_1__2__Impl ;
    public final void rule__AndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:984:1: ( rule__AndExpression__Group_1__2__Impl )
            // InternalLtl.g:985:2: rule__AndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__2"


    // $ANTLR start "rule__AndExpression__Group_1__2__Impl"
    // InternalLtl.g:991:1: rule__AndExpression__Group_1__2__Impl : ( ( rule__AndExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__AndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:995:1: ( ( ( rule__AndExpression__RightOperandAssignment_1_2 ) ) )
            // InternalLtl.g:996:1: ( ( rule__AndExpression__RightOperandAssignment_1_2 ) )
            {
            // InternalLtl.g:996:1: ( ( rule__AndExpression__RightOperandAssignment_1_2 ) )
            // InternalLtl.g:997:2: ( rule__AndExpression__RightOperandAssignment_1_2 )
            {
             before(grammarAccess.getAndExpressionAccess().getRightOperandAssignment_1_2()); 
            // InternalLtl.g:998:2: ( rule__AndExpression__RightOperandAssignment_1_2 )
            // InternalLtl.g:998:3: rule__AndExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__RightOperandAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getRightOperandAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__2__Impl"


    // $ANTLR start "rule__UntilExpression__Group__0"
    // InternalLtl.g:1007:1: rule__UntilExpression__Group__0 : rule__UntilExpression__Group__0__Impl rule__UntilExpression__Group__1 ;
    public final void rule__UntilExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1011:1: ( rule__UntilExpression__Group__0__Impl rule__UntilExpression__Group__1 )
            // InternalLtl.g:1012:2: rule__UntilExpression__Group__0__Impl rule__UntilExpression__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__UntilExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group__0"


    // $ANTLR start "rule__UntilExpression__Group__0__Impl"
    // InternalLtl.g:1019:1: rule__UntilExpression__Group__0__Impl : ( ruleFutureGloballyExpression ) ;
    public final void rule__UntilExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1023:1: ( ( ruleFutureGloballyExpression ) )
            // InternalLtl.g:1024:1: ( ruleFutureGloballyExpression )
            {
            // InternalLtl.g:1024:1: ( ruleFutureGloballyExpression )
            // InternalLtl.g:1025:2: ruleFutureGloballyExpression
            {
             before(grammarAccess.getUntilExpressionAccess().getFutureGloballyExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFutureGloballyExpression();

            state._fsp--;

             after(grammarAccess.getUntilExpressionAccess().getFutureGloballyExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group__0__Impl"


    // $ANTLR start "rule__UntilExpression__Group__1"
    // InternalLtl.g:1034:1: rule__UntilExpression__Group__1 : rule__UntilExpression__Group__1__Impl ;
    public final void rule__UntilExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1038:1: ( rule__UntilExpression__Group__1__Impl )
            // InternalLtl.g:1039:2: rule__UntilExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group__1"


    // $ANTLR start "rule__UntilExpression__Group__1__Impl"
    // InternalLtl.g:1045:1: rule__UntilExpression__Group__1__Impl : ( ( rule__UntilExpression__Group_1__0 )? ) ;
    public final void rule__UntilExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1049:1: ( ( ( rule__UntilExpression__Group_1__0 )? ) )
            // InternalLtl.g:1050:1: ( ( rule__UntilExpression__Group_1__0 )? )
            {
            // InternalLtl.g:1050:1: ( ( rule__UntilExpression__Group_1__0 )? )
            // InternalLtl.g:1051:2: ( rule__UntilExpression__Group_1__0 )?
            {
             before(grammarAccess.getUntilExpressionAccess().getGroup_1()); 
            // InternalLtl.g:1052:2: ( rule__UntilExpression__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalLtl.g:1052:3: rule__UntilExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__UntilExpression__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getUntilExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group__1__Impl"


    // $ANTLR start "rule__UntilExpression__Group_1__0"
    // InternalLtl.g:1061:1: rule__UntilExpression__Group_1__0 : rule__UntilExpression__Group_1__0__Impl rule__UntilExpression__Group_1__1 ;
    public final void rule__UntilExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1065:1: ( rule__UntilExpression__Group_1__0__Impl rule__UntilExpression__Group_1__1 )
            // InternalLtl.g:1066:2: rule__UntilExpression__Group_1__0__Impl rule__UntilExpression__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__UntilExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__0"


    // $ANTLR start "rule__UntilExpression__Group_1__0__Impl"
    // InternalLtl.g:1073:1: rule__UntilExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__UntilExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1077:1: ( ( () ) )
            // InternalLtl.g:1078:1: ( () )
            {
            // InternalLtl.g:1078:1: ( () )
            // InternalLtl.g:1079:2: ()
            {
             before(grammarAccess.getUntilExpressionAccess().getUntilExpressionLeftOperandAction_1_0()); 
            // InternalLtl.g:1080:2: ()
            // InternalLtl.g:1080:3: 
            {
            }

             after(grammarAccess.getUntilExpressionAccess().getUntilExpressionLeftOperandAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__0__Impl"


    // $ANTLR start "rule__UntilExpression__Group_1__1"
    // InternalLtl.g:1088:1: rule__UntilExpression__Group_1__1 : rule__UntilExpression__Group_1__1__Impl rule__UntilExpression__Group_1__2 ;
    public final void rule__UntilExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1092:1: ( rule__UntilExpression__Group_1__1__Impl rule__UntilExpression__Group_1__2 )
            // InternalLtl.g:1093:2: rule__UntilExpression__Group_1__1__Impl rule__UntilExpression__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__UntilExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__1"


    // $ANTLR start "rule__UntilExpression__Group_1__1__Impl"
    // InternalLtl.g:1100:1: rule__UntilExpression__Group_1__1__Impl : ( 'U' ) ;
    public final void rule__UntilExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1104:1: ( ( 'U' ) )
            // InternalLtl.g:1105:1: ( 'U' )
            {
            // InternalLtl.g:1105:1: ( 'U' )
            // InternalLtl.g:1106:2: 'U'
            {
             before(grammarAccess.getUntilExpressionAccess().getUKeyword_1_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getUntilExpressionAccess().getUKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__1__Impl"


    // $ANTLR start "rule__UntilExpression__Group_1__2"
    // InternalLtl.g:1115:1: rule__UntilExpression__Group_1__2 : rule__UntilExpression__Group_1__2__Impl ;
    public final void rule__UntilExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1119:1: ( rule__UntilExpression__Group_1__2__Impl )
            // InternalLtl.g:1120:2: rule__UntilExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UntilExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__2"


    // $ANTLR start "rule__UntilExpression__Group_1__2__Impl"
    // InternalLtl.g:1126:1: rule__UntilExpression__Group_1__2__Impl : ( ( rule__UntilExpression__RightOperandAssignment_1_2 ) ) ;
    public final void rule__UntilExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1130:1: ( ( ( rule__UntilExpression__RightOperandAssignment_1_2 ) ) )
            // InternalLtl.g:1131:1: ( ( rule__UntilExpression__RightOperandAssignment_1_2 ) )
            {
            // InternalLtl.g:1131:1: ( ( rule__UntilExpression__RightOperandAssignment_1_2 ) )
            // InternalLtl.g:1132:2: ( rule__UntilExpression__RightOperandAssignment_1_2 )
            {
             before(grammarAccess.getUntilExpressionAccess().getRightOperandAssignment_1_2()); 
            // InternalLtl.g:1133:2: ( rule__UntilExpression__RightOperandAssignment_1_2 )
            // InternalLtl.g:1133:3: rule__UntilExpression__RightOperandAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__UntilExpression__RightOperandAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getUntilExpressionAccess().getRightOperandAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__Group_1__2__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__0"
    // InternalLtl.g:1142:1: rule__FutureGloballyExpression__Group_0__0 : rule__FutureGloballyExpression__Group_0__0__Impl rule__FutureGloballyExpression__Group_0__1 ;
    public final void rule__FutureGloballyExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1146:1: ( rule__FutureGloballyExpression__Group_0__0__Impl rule__FutureGloballyExpression__Group_0__1 )
            // InternalLtl.g:1147:2: rule__FutureGloballyExpression__Group_0__0__Impl rule__FutureGloballyExpression__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__FutureGloballyExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__0"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__0__Impl"
    // InternalLtl.g:1154:1: rule__FutureGloballyExpression__Group_0__0__Impl : ( 'F' ) ;
    public final void rule__FutureGloballyExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1158:1: ( ( 'F' ) )
            // InternalLtl.g:1159:1: ( 'F' )
            {
            // InternalLtl.g:1159:1: ( 'F' )
            // InternalLtl.g:1160:2: 'F'
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getFKeyword_0_0()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getFutureGloballyExpressionAccess().getFKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__0__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__1"
    // InternalLtl.g:1169:1: rule__FutureGloballyExpression__Group_0__1 : rule__FutureGloballyExpression__Group_0__1__Impl rule__FutureGloballyExpression__Group_0__2 ;
    public final void rule__FutureGloballyExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1173:1: ( rule__FutureGloballyExpression__Group_0__1__Impl rule__FutureGloballyExpression__Group_0__2 )
            // InternalLtl.g:1174:2: rule__FutureGloballyExpression__Group_0__1__Impl rule__FutureGloballyExpression__Group_0__2
            {
            pushFollow(FOLLOW_5);
            rule__FutureGloballyExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__1"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__1__Impl"
    // InternalLtl.g:1181:1: rule__FutureGloballyExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__FutureGloballyExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1185:1: ( ( () ) )
            // InternalLtl.g:1186:1: ( () )
            {
            // InternalLtl.g:1186:1: ( () )
            // InternalLtl.g:1187:2: ()
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getFutureExpressionAction_0_1()); 
            // InternalLtl.g:1188:2: ()
            // InternalLtl.g:1188:3: 
            {
            }

             after(grammarAccess.getFutureGloballyExpressionAccess().getFutureExpressionAction_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__1__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__2"
    // InternalLtl.g:1196:1: rule__FutureGloballyExpression__Group_0__2 : rule__FutureGloballyExpression__Group_0__2__Impl ;
    public final void rule__FutureGloballyExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1200:1: ( rule__FutureGloballyExpression__Group_0__2__Impl )
            // InternalLtl.g:1201:2: rule__FutureGloballyExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__2"


    // $ANTLR start "rule__FutureGloballyExpression__Group_0__2__Impl"
    // InternalLtl.g:1207:1: rule__FutureGloballyExpression__Group_0__2__Impl : ( ( rule__FutureGloballyExpression__OperandAssignment_0_2 ) ) ;
    public final void rule__FutureGloballyExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1211:1: ( ( ( rule__FutureGloballyExpression__OperandAssignment_0_2 ) ) )
            // InternalLtl.g:1212:1: ( ( rule__FutureGloballyExpression__OperandAssignment_0_2 ) )
            {
            // InternalLtl.g:1212:1: ( ( rule__FutureGloballyExpression__OperandAssignment_0_2 ) )
            // InternalLtl.g:1213:2: ( rule__FutureGloballyExpression__OperandAssignment_0_2 )
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getOperandAssignment_0_2()); 
            // InternalLtl.g:1214:2: ( rule__FutureGloballyExpression__OperandAssignment_0_2 )
            // InternalLtl.g:1214:3: rule__FutureGloballyExpression__OperandAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__OperandAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getFutureGloballyExpressionAccess().getOperandAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_0__2__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__0"
    // InternalLtl.g:1223:1: rule__FutureGloballyExpression__Group_1__0 : rule__FutureGloballyExpression__Group_1__0__Impl rule__FutureGloballyExpression__Group_1__1 ;
    public final void rule__FutureGloballyExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1227:1: ( rule__FutureGloballyExpression__Group_1__0__Impl rule__FutureGloballyExpression__Group_1__1 )
            // InternalLtl.g:1228:2: rule__FutureGloballyExpression__Group_1__0__Impl rule__FutureGloballyExpression__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__FutureGloballyExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__0"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__0__Impl"
    // InternalLtl.g:1235:1: rule__FutureGloballyExpression__Group_1__0__Impl : ( 'G' ) ;
    public final void rule__FutureGloballyExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1239:1: ( ( 'G' ) )
            // InternalLtl.g:1240:1: ( 'G' )
            {
            // InternalLtl.g:1240:1: ( 'G' )
            // InternalLtl.g:1241:2: 'G'
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getGKeyword_1_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getFutureGloballyExpressionAccess().getGKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__0__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__1"
    // InternalLtl.g:1250:1: rule__FutureGloballyExpression__Group_1__1 : rule__FutureGloballyExpression__Group_1__1__Impl rule__FutureGloballyExpression__Group_1__2 ;
    public final void rule__FutureGloballyExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1254:1: ( rule__FutureGloballyExpression__Group_1__1__Impl rule__FutureGloballyExpression__Group_1__2 )
            // InternalLtl.g:1255:2: rule__FutureGloballyExpression__Group_1__1__Impl rule__FutureGloballyExpression__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__FutureGloballyExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__1"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__1__Impl"
    // InternalLtl.g:1262:1: rule__FutureGloballyExpression__Group_1__1__Impl : ( () ) ;
    public final void rule__FutureGloballyExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1266:1: ( ( () ) )
            // InternalLtl.g:1267:1: ( () )
            {
            // InternalLtl.g:1267:1: ( () )
            // InternalLtl.g:1268:2: ()
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getGloballyExpressionAction_1_1()); 
            // InternalLtl.g:1269:2: ()
            // InternalLtl.g:1269:3: 
            {
            }

             after(grammarAccess.getFutureGloballyExpressionAccess().getGloballyExpressionAction_1_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__1__Impl"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__2"
    // InternalLtl.g:1277:1: rule__FutureGloballyExpression__Group_1__2 : rule__FutureGloballyExpression__Group_1__2__Impl ;
    public final void rule__FutureGloballyExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1281:1: ( rule__FutureGloballyExpression__Group_1__2__Impl )
            // InternalLtl.g:1282:2: rule__FutureGloballyExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__2"


    // $ANTLR start "rule__FutureGloballyExpression__Group_1__2__Impl"
    // InternalLtl.g:1288:1: rule__FutureGloballyExpression__Group_1__2__Impl : ( ( rule__FutureGloballyExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__FutureGloballyExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1292:1: ( ( ( rule__FutureGloballyExpression__OperandAssignment_1_2 ) ) )
            // InternalLtl.g:1293:1: ( ( rule__FutureGloballyExpression__OperandAssignment_1_2 ) )
            {
            // InternalLtl.g:1293:1: ( ( rule__FutureGloballyExpression__OperandAssignment_1_2 ) )
            // InternalLtl.g:1294:2: ( rule__FutureGloballyExpression__OperandAssignment_1_2 )
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getOperandAssignment_1_2()); 
            // InternalLtl.g:1295:2: ( rule__FutureGloballyExpression__OperandAssignment_1_2 )
            // InternalLtl.g:1295:3: rule__FutureGloballyExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__FutureGloballyExpression__OperandAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getFutureGloballyExpressionAccess().getOperandAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__Group_1__2__Impl"


    // $ANTLR start "rule__NextExpression__Group_0__0"
    // InternalLtl.g:1304:1: rule__NextExpression__Group_0__0 : rule__NextExpression__Group_0__0__Impl rule__NextExpression__Group_0__1 ;
    public final void rule__NextExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1308:1: ( rule__NextExpression__Group_0__0__Impl rule__NextExpression__Group_0__1 )
            // InternalLtl.g:1309:2: rule__NextExpression__Group_0__0__Impl rule__NextExpression__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__NextExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NextExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__0"


    // $ANTLR start "rule__NextExpression__Group_0__0__Impl"
    // InternalLtl.g:1316:1: rule__NextExpression__Group_0__0__Impl : ( 'X' ) ;
    public final void rule__NextExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1320:1: ( ( 'X' ) )
            // InternalLtl.g:1321:1: ( 'X' )
            {
            // InternalLtl.g:1321:1: ( 'X' )
            // InternalLtl.g:1322:2: 'X'
            {
             before(grammarAccess.getNextExpressionAccess().getXKeyword_0_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getNextExpressionAccess().getXKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__0__Impl"


    // $ANTLR start "rule__NextExpression__Group_0__1"
    // InternalLtl.g:1331:1: rule__NextExpression__Group_0__1 : rule__NextExpression__Group_0__1__Impl rule__NextExpression__Group_0__2 ;
    public final void rule__NextExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1335:1: ( rule__NextExpression__Group_0__1__Impl rule__NextExpression__Group_0__2 )
            // InternalLtl.g:1336:2: rule__NextExpression__Group_0__1__Impl rule__NextExpression__Group_0__2
            {
            pushFollow(FOLLOW_5);
            rule__NextExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NextExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__1"


    // $ANTLR start "rule__NextExpression__Group_0__1__Impl"
    // InternalLtl.g:1343:1: rule__NextExpression__Group_0__1__Impl : ( () ) ;
    public final void rule__NextExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1347:1: ( ( () ) )
            // InternalLtl.g:1348:1: ( () )
            {
            // InternalLtl.g:1348:1: ( () )
            // InternalLtl.g:1349:2: ()
            {
             before(grammarAccess.getNextExpressionAccess().getNextExpressionAction_0_1()); 
            // InternalLtl.g:1350:2: ()
            // InternalLtl.g:1350:3: 
            {
            }

             after(grammarAccess.getNextExpressionAccess().getNextExpressionAction_0_1()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__1__Impl"


    // $ANTLR start "rule__NextExpression__Group_0__2"
    // InternalLtl.g:1358:1: rule__NextExpression__Group_0__2 : rule__NextExpression__Group_0__2__Impl ;
    public final void rule__NextExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1362:1: ( rule__NextExpression__Group_0__2__Impl )
            // InternalLtl.g:1363:2: rule__NextExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NextExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__2"


    // $ANTLR start "rule__NextExpression__Group_0__2__Impl"
    // InternalLtl.g:1369:1: rule__NextExpression__Group_0__2__Impl : ( ( rule__NextExpression__OperandAssignment_0_2 ) ) ;
    public final void rule__NextExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1373:1: ( ( ( rule__NextExpression__OperandAssignment_0_2 ) ) )
            // InternalLtl.g:1374:1: ( ( rule__NextExpression__OperandAssignment_0_2 ) )
            {
            // InternalLtl.g:1374:1: ( ( rule__NextExpression__OperandAssignment_0_2 ) )
            // InternalLtl.g:1375:2: ( rule__NextExpression__OperandAssignment_0_2 )
            {
             before(grammarAccess.getNextExpressionAccess().getOperandAssignment_0_2()); 
            // InternalLtl.g:1376:2: ( rule__NextExpression__OperandAssignment_0_2 )
            // InternalLtl.g:1376:3: rule__NextExpression__OperandAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__NextExpression__OperandAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getNextExpressionAccess().getOperandAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__Group_0__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0"
    // InternalLtl.g:1385:1: rule__PrimaryExpression__Group_0__0 : rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 ;
    public final void rule__PrimaryExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1389:1: ( rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1 )
            // InternalLtl.g:1390:2: rule__PrimaryExpression__Group_0__0__Impl rule__PrimaryExpression__Group_0__1
            {
            pushFollow(FOLLOW_5);
            rule__PrimaryExpression__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0"


    // $ANTLR start "rule__PrimaryExpression__Group_0__0__Impl"
    // InternalLtl.g:1397:1: rule__PrimaryExpression__Group_0__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1401:1: ( ( '(' ) )
            // InternalLtl.g:1402:1: ( '(' )
            {
            // InternalLtl.g:1402:1: ( '(' )
            // InternalLtl.g:1403:2: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1"
    // InternalLtl.g:1412:1: rule__PrimaryExpression__Group_0__1 : rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 ;
    public final void rule__PrimaryExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1416:1: ( rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2 )
            // InternalLtl.g:1417:2: rule__PrimaryExpression__Group_0__1__Impl rule__PrimaryExpression__Group_0__2
            {
            pushFollow(FOLLOW_11);
            rule__PrimaryExpression__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1"


    // $ANTLR start "rule__PrimaryExpression__Group_0__1__Impl"
    // InternalLtl.g:1424:1: rule__PrimaryExpression__Group_0__1__Impl : ( ruleLTLExpression ) ;
    public final void rule__PrimaryExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1428:1: ( ( ruleLTLExpression ) )
            // InternalLtl.g:1429:1: ( ruleLTLExpression )
            {
            // InternalLtl.g:1429:1: ( ruleLTLExpression )
            // InternalLtl.g:1430:2: ruleLTLExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLTLExpressionParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleLTLExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getLTLExpressionParserRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2"
    // InternalLtl.g:1439:1: rule__PrimaryExpression__Group_0__2 : rule__PrimaryExpression__Group_0__2__Impl ;
    public final void rule__PrimaryExpression__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1443:1: ( rule__PrimaryExpression__Group_0__2__Impl )
            // InternalLtl.g:1444:2: rule__PrimaryExpression__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__2"


    // $ANTLR start "rule__PrimaryExpression__Group_0__2__Impl"
    // InternalLtl.g:1450:1: rule__PrimaryExpression__Group_0__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1454:1: ( ( ')' ) )
            // InternalLtl.g:1455:1: ( ')' )
            {
            // InternalLtl.g:1455:1: ( ')' )
            // InternalLtl.g:1456:2: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_0__2__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0"
    // InternalLtl.g:1466:1: rule__PrimaryExpression__Group_1__0 : rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 ;
    public final void rule__PrimaryExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1470:1: ( rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1 )
            // InternalLtl.g:1471:2: rule__PrimaryExpression__Group_1__0__Impl rule__PrimaryExpression__Group_1__1
            {
            pushFollow(FOLLOW_12);
            rule__PrimaryExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0"


    // $ANTLR start "rule__PrimaryExpression__Group_1__0__Impl"
    // InternalLtl.g:1478:1: rule__PrimaryExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__PrimaryExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1482:1: ( ( () ) )
            // InternalLtl.g:1483:1: ( () )
            {
            // InternalLtl.g:1483:1: ( () )
            // InternalLtl.g:1484:2: ()
            {
             before(grammarAccess.getPrimaryExpressionAccess().getNotExpressionAction_1_0()); 
            // InternalLtl.g:1485:2: ()
            // InternalLtl.g:1485:3: 
            {
            }

             after(grammarAccess.getPrimaryExpressionAccess().getNotExpressionAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1"
    // InternalLtl.g:1493:1: rule__PrimaryExpression__Group_1__1 : rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 ;
    public final void rule__PrimaryExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1497:1: ( rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2 )
            // InternalLtl.g:1498:2: rule__PrimaryExpression__Group_1__1__Impl rule__PrimaryExpression__Group_1__2
            {
            pushFollow(FOLLOW_5);
            rule__PrimaryExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1"


    // $ANTLR start "rule__PrimaryExpression__Group_1__1__Impl"
    // InternalLtl.g:1505:1: rule__PrimaryExpression__Group_1__1__Impl : ( '!' ) ;
    public final void rule__PrimaryExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1509:1: ( ( '!' ) )
            // InternalLtl.g:1510:1: ( '!' )
            {
            // InternalLtl.g:1510:1: ( '!' )
            // InternalLtl.g:1511:2: '!'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getExclamationMarkKeyword_1_1()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getPrimaryExpressionAccess().getExclamationMarkKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2"
    // InternalLtl.g:1520:1: rule__PrimaryExpression__Group_1__2 : rule__PrimaryExpression__Group_1__2__Impl ;
    public final void rule__PrimaryExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1524:1: ( rule__PrimaryExpression__Group_1__2__Impl )
            // InternalLtl.g:1525:2: rule__PrimaryExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2"


    // $ANTLR start "rule__PrimaryExpression__Group_1__2__Impl"
    // InternalLtl.g:1531:1: rule__PrimaryExpression__Group_1__2__Impl : ( ( rule__PrimaryExpression__OperandAssignment_1_2 ) ) ;
    public final void rule__PrimaryExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1535:1: ( ( ( rule__PrimaryExpression__OperandAssignment_1_2 ) ) )
            // InternalLtl.g:1536:1: ( ( rule__PrimaryExpression__OperandAssignment_1_2 ) )
            {
            // InternalLtl.g:1536:1: ( ( rule__PrimaryExpression__OperandAssignment_1_2 ) )
            // InternalLtl.g:1537:2: ( rule__PrimaryExpression__OperandAssignment_1_2 )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_2()); 
            // InternalLtl.g:1538:2: ( rule__PrimaryExpression__OperandAssignment_1_2 )
            // InternalLtl.g:1538:3: rule__PrimaryExpression__OperandAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpression__OperandAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getOperandAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__Group_1__2__Impl"


    // $ANTLR start "rule__FalseExpression__Group__0"
    // InternalLtl.g:1547:1: rule__FalseExpression__Group__0 : rule__FalseExpression__Group__0__Impl rule__FalseExpression__Group__1 ;
    public final void rule__FalseExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1551:1: ( rule__FalseExpression__Group__0__Impl rule__FalseExpression__Group__1 )
            // InternalLtl.g:1552:2: rule__FalseExpression__Group__0__Impl rule__FalseExpression__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__FalseExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FalseExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseExpression__Group__0"


    // $ANTLR start "rule__FalseExpression__Group__0__Impl"
    // InternalLtl.g:1559:1: rule__FalseExpression__Group__0__Impl : ( () ) ;
    public final void rule__FalseExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1563:1: ( ( () ) )
            // InternalLtl.g:1564:1: ( () )
            {
            // InternalLtl.g:1564:1: ( () )
            // InternalLtl.g:1565:2: ()
            {
             before(grammarAccess.getFalseExpressionAccess().getFalseExpressionAction_0()); 
            // InternalLtl.g:1566:2: ()
            // InternalLtl.g:1566:3: 
            {
            }

             after(grammarAccess.getFalseExpressionAccess().getFalseExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseExpression__Group__0__Impl"


    // $ANTLR start "rule__FalseExpression__Group__1"
    // InternalLtl.g:1574:1: rule__FalseExpression__Group__1 : rule__FalseExpression__Group__1__Impl ;
    public final void rule__FalseExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1578:1: ( rule__FalseExpression__Group__1__Impl )
            // InternalLtl.g:1579:2: rule__FalseExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FalseExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseExpression__Group__1"


    // $ANTLR start "rule__FalseExpression__Group__1__Impl"
    // InternalLtl.g:1585:1: rule__FalseExpression__Group__1__Impl : ( 'false' ) ;
    public final void rule__FalseExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1589:1: ( ( 'false' ) )
            // InternalLtl.g:1590:1: ( 'false' )
            {
            // InternalLtl.g:1590:1: ( 'false' )
            // InternalLtl.g:1591:2: 'false'
            {
             before(grammarAccess.getFalseExpressionAccess().getFalseKeyword_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getFalseExpressionAccess().getFalseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FalseExpression__Group__1__Impl"


    // $ANTLR start "rule__TrueExpression__Group__0"
    // InternalLtl.g:1601:1: rule__TrueExpression__Group__0 : rule__TrueExpression__Group__0__Impl rule__TrueExpression__Group__1 ;
    public final void rule__TrueExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1605:1: ( rule__TrueExpression__Group__0__Impl rule__TrueExpression__Group__1 )
            // InternalLtl.g:1606:2: rule__TrueExpression__Group__0__Impl rule__TrueExpression__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__TrueExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrueExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueExpression__Group__0"


    // $ANTLR start "rule__TrueExpression__Group__0__Impl"
    // InternalLtl.g:1613:1: rule__TrueExpression__Group__0__Impl : ( () ) ;
    public final void rule__TrueExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1617:1: ( ( () ) )
            // InternalLtl.g:1618:1: ( () )
            {
            // InternalLtl.g:1618:1: ( () )
            // InternalLtl.g:1619:2: ()
            {
             before(grammarAccess.getTrueExpressionAccess().getTrueExpressionAction_0()); 
            // InternalLtl.g:1620:2: ()
            // InternalLtl.g:1620:3: 
            {
            }

             after(grammarAccess.getTrueExpressionAccess().getTrueExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueExpression__Group__0__Impl"


    // $ANTLR start "rule__TrueExpression__Group__1"
    // InternalLtl.g:1628:1: rule__TrueExpression__Group__1 : rule__TrueExpression__Group__1__Impl ;
    public final void rule__TrueExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1632:1: ( rule__TrueExpression__Group__1__Impl )
            // InternalLtl.g:1633:2: rule__TrueExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrueExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueExpression__Group__1"


    // $ANTLR start "rule__TrueExpression__Group__1__Impl"
    // InternalLtl.g:1639:1: rule__TrueExpression__Group__1__Impl : ( 'true' ) ;
    public final void rule__TrueExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1643:1: ( ( 'true' ) )
            // InternalLtl.g:1644:1: ( 'true' )
            {
            // InternalLtl.g:1644:1: ( 'true' )
            // InternalLtl.g:1645:2: 'true'
            {
             before(grammarAccess.getTrueExpressionAccess().getTrueKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getTrueExpressionAccess().getTrueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrueExpression__Group__1__Impl"


    // $ANTLR start "rule__AtomicProposition__Group__0"
    // InternalLtl.g:1655:1: rule__AtomicProposition__Group__0 : rule__AtomicProposition__Group__0__Impl rule__AtomicProposition__Group__1 ;
    public final void rule__AtomicProposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1659:1: ( rule__AtomicProposition__Group__0__Impl rule__AtomicProposition__Group__1 )
            // InternalLtl.g:1660:2: rule__AtomicProposition__Group__0__Impl rule__AtomicProposition__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__AtomicProposition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AtomicProposition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicProposition__Group__0"


    // $ANTLR start "rule__AtomicProposition__Group__0__Impl"
    // InternalLtl.g:1667:1: rule__AtomicProposition__Group__0__Impl : ( () ) ;
    public final void rule__AtomicProposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1671:1: ( ( () ) )
            // InternalLtl.g:1672:1: ( () )
            {
            // InternalLtl.g:1672:1: ( () )
            // InternalLtl.g:1673:2: ()
            {
             before(grammarAccess.getAtomicPropositionAccess().getAtomicPropositionAction_0()); 
            // InternalLtl.g:1674:2: ()
            // InternalLtl.g:1674:3: 
            {
            }

             after(grammarAccess.getAtomicPropositionAccess().getAtomicPropositionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicProposition__Group__0__Impl"


    // $ANTLR start "rule__AtomicProposition__Group__1"
    // InternalLtl.g:1682:1: rule__AtomicProposition__Group__1 : rule__AtomicProposition__Group__1__Impl ;
    public final void rule__AtomicProposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1686:1: ( rule__AtomicProposition__Group__1__Impl )
            // InternalLtl.g:1687:2: rule__AtomicProposition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AtomicProposition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicProposition__Group__1"


    // $ANTLR start "rule__AtomicProposition__Group__1__Impl"
    // InternalLtl.g:1693:1: rule__AtomicProposition__Group__1__Impl : ( ( rule__AtomicProposition__PropositionAssignment_1 ) ) ;
    public final void rule__AtomicProposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1697:1: ( ( ( rule__AtomicProposition__PropositionAssignment_1 ) ) )
            // InternalLtl.g:1698:1: ( ( rule__AtomicProposition__PropositionAssignment_1 ) )
            {
            // InternalLtl.g:1698:1: ( ( rule__AtomicProposition__PropositionAssignment_1 ) )
            // InternalLtl.g:1699:2: ( rule__AtomicProposition__PropositionAssignment_1 )
            {
             before(grammarAccess.getAtomicPropositionAccess().getPropositionAssignment_1()); 
            // InternalLtl.g:1700:2: ( rule__AtomicProposition__PropositionAssignment_1 )
            // InternalLtl.g:1700:3: rule__AtomicProposition__PropositionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AtomicProposition__PropositionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAtomicPropositionAccess().getPropositionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicProposition__Group__1__Impl"


    // $ANTLR start "rule__ArrowExpression__RightOperandAssignment_1_0_2"
    // InternalLtl.g:1709:1: rule__ArrowExpression__RightOperandAssignment_1_0_2 : ( ruleArrowExpression ) ;
    public final void rule__ArrowExpression__RightOperandAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1713:1: ( ( ruleArrowExpression ) )
            // InternalLtl.g:1714:2: ( ruleArrowExpression )
            {
            // InternalLtl.g:1714:2: ( ruleArrowExpression )
            // InternalLtl.g:1715:3: ruleArrowExpression
            {
             before(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleArrowExpression();

            state._fsp--;

             after(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__RightOperandAssignment_1_0_2"


    // $ANTLR start "rule__ArrowExpression__RightOperandAssignment_1_1_2"
    // InternalLtl.g:1724:1: rule__ArrowExpression__RightOperandAssignment_1_1_2 : ( ruleArrowExpression ) ;
    public final void rule__ArrowExpression__RightOperandAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1728:1: ( ( ruleArrowExpression ) )
            // InternalLtl.g:1729:2: ( ruleArrowExpression )
            {
            // InternalLtl.g:1729:2: ( ruleArrowExpression )
            // InternalLtl.g:1730:3: ruleArrowExpression
            {
             before(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleArrowExpression();

            state._fsp--;

             after(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrowExpression__RightOperandAssignment_1_1_2"


    // $ANTLR start "rule__OrExpression__RightOperandAssignment_1_2"
    // InternalLtl.g:1739:1: rule__OrExpression__RightOperandAssignment_1_2 : ( ruleAndExpression ) ;
    public final void rule__OrExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1743:1: ( ( ruleAndExpression ) )
            // InternalLtl.g:1744:2: ( ruleAndExpression )
            {
            // InternalLtl.g:1744:2: ( ruleAndExpression )
            // InternalLtl.g:1745:3: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getRightOperandAndExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getRightOperandAndExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__AndExpression__RightOperandAssignment_1_2"
    // InternalLtl.g:1754:1: rule__AndExpression__RightOperandAssignment_1_2 : ( ruleUntilExpression ) ;
    public final void rule__AndExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1758:1: ( ( ruleUntilExpression ) )
            // InternalLtl.g:1759:2: ( ruleUntilExpression )
            {
            // InternalLtl.g:1759:2: ( ruleUntilExpression )
            // InternalLtl.g:1760:3: ruleUntilExpression
            {
             before(grammarAccess.getAndExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUntilExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__UntilExpression__RightOperandAssignment_1_2"
    // InternalLtl.g:1769:1: rule__UntilExpression__RightOperandAssignment_1_2 : ( ruleUntilExpression ) ;
    public final void rule__UntilExpression__RightOperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1773:1: ( ( ruleUntilExpression ) )
            // InternalLtl.g:1774:2: ( ruleUntilExpression )
            {
            // InternalLtl.g:1774:2: ( ruleUntilExpression )
            // InternalLtl.g:1775:3: ruleUntilExpression
            {
             before(grammarAccess.getUntilExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleUntilExpression();

            state._fsp--;

             after(grammarAccess.getUntilExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UntilExpression__RightOperandAssignment_1_2"


    // $ANTLR start "rule__FutureGloballyExpression__OperandAssignment_0_2"
    // InternalLtl.g:1784:1: rule__FutureGloballyExpression__OperandAssignment_0_2 : ( ruleNextExpression ) ;
    public final void rule__FutureGloballyExpression__OperandAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1788:1: ( ( ruleNextExpression ) )
            // InternalLtl.g:1789:2: ( ruleNextExpression )
            {
            // InternalLtl.g:1789:2: ( ruleNextExpression )
            // InternalLtl.g:1790:3: ruleNextExpression
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNextExpression();

            state._fsp--;

             after(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__OperandAssignment_0_2"


    // $ANTLR start "rule__FutureGloballyExpression__OperandAssignment_1_2"
    // InternalLtl.g:1799:1: rule__FutureGloballyExpression__OperandAssignment_1_2 : ( ruleNextExpression ) ;
    public final void rule__FutureGloballyExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1803:1: ( ( ruleNextExpression ) )
            // InternalLtl.g:1804:2: ( ruleNextExpression )
            {
            // InternalLtl.g:1804:2: ( ruleNextExpression )
            // InternalLtl.g:1805:3: ruleNextExpression
            {
             before(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNextExpression();

            state._fsp--;

             after(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FutureGloballyExpression__OperandAssignment_1_2"


    // $ANTLR start "rule__NextExpression__OperandAssignment_0_2"
    // InternalLtl.g:1814:1: rule__NextExpression__OperandAssignment_0_2 : ( rulePrimaryExpression ) ;
    public final void rule__NextExpression__OperandAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1818:1: ( ( rulePrimaryExpression ) )
            // InternalLtl.g:1819:2: ( rulePrimaryExpression )
            {
            // InternalLtl.g:1819:2: ( rulePrimaryExpression )
            // InternalLtl.g:1820:3: rulePrimaryExpression
            {
             before(grammarAccess.getNextExpressionAccess().getOperandPrimaryExpressionParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getNextExpressionAccess().getOperandPrimaryExpressionParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NextExpression__OperandAssignment_0_2"


    // $ANTLR start "rule__PrimaryExpression__OperandAssignment_1_2"
    // InternalLtl.g:1829:1: rule__PrimaryExpression__OperandAssignment_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__PrimaryExpression__OperandAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1833:1: ( ( rulePrimaryExpression ) )
            // InternalLtl.g:1834:2: ( rulePrimaryExpression )
            {
            // InternalLtl.g:1834:2: ( rulePrimaryExpression )
            // InternalLtl.g:1835:3: rulePrimaryExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpression__OperandAssignment_1_2"


    // $ANTLR start "rule__AtomicProposition__PropositionAssignment_1"
    // InternalLtl.g:1844:1: rule__AtomicProposition__PropositionAssignment_1 : ( ruleEString ) ;
    public final void rule__AtomicProposition__PropositionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLtl.g:1848:1: ( ( ruleEString ) )
            // InternalLtl.g:1849:2: ( ruleEString )
            {
            // InternalLtl.g:1849:2: ( ruleEString )
            // InternalLtl.g:1850:3: ruleEString
            {
             before(grammarAccess.getAtomicPropositionAccess().getPropositionEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAtomicPropositionAccess().getPropositionEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicProposition__PropositionAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000EF0030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000030L});

}