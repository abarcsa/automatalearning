package hu.bme.mit.ltl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.ltl.services.LtlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLtlParser extends AbstractInternalAntlrParser {
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

        public InternalLtlParser(TokenStream input, LtlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "LTLExpression";
       	}

       	@Override
       	protected LtlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleLTLExpression"
    // InternalLtl.g:64:1: entryRuleLTLExpression returns [EObject current=null] : iv_ruleLTLExpression= ruleLTLExpression EOF ;
    public final EObject entryRuleLTLExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLTLExpression = null;


        try {
            // InternalLtl.g:64:54: (iv_ruleLTLExpression= ruleLTLExpression EOF )
            // InternalLtl.g:65:2: iv_ruleLTLExpression= ruleLTLExpression EOF
            {
             newCompositeNode(grammarAccess.getLTLExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLTLExpression=ruleLTLExpression();

            state._fsp--;

             current =iv_ruleLTLExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLTLExpression"


    // $ANTLR start "ruleLTLExpression"
    // InternalLtl.g:71:1: ruleLTLExpression returns [EObject current=null] : this_ArrowExpression_0= ruleArrowExpression ;
    public final EObject ruleLTLExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ArrowExpression_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:77:2: (this_ArrowExpression_0= ruleArrowExpression )
            // InternalLtl.g:78:2: this_ArrowExpression_0= ruleArrowExpression
            {

            		newCompositeNode(grammarAccess.getLTLExpressionAccess().getArrowExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ArrowExpression_0=ruleArrowExpression();

            state._fsp--;


            		current = this_ArrowExpression_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLTLExpression"


    // $ANTLR start "entryRuleArrowExpression"
    // InternalLtl.g:89:1: entryRuleArrowExpression returns [EObject current=null] : iv_ruleArrowExpression= ruleArrowExpression EOF ;
    public final EObject entryRuleArrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrowExpression = null;


        try {
            // InternalLtl.g:89:56: (iv_ruleArrowExpression= ruleArrowExpression EOF )
            // InternalLtl.g:90:2: iv_ruleArrowExpression= ruleArrowExpression EOF
            {
             newCompositeNode(grammarAccess.getArrowExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrowExpression=ruleArrowExpression();

            state._fsp--;

             current =iv_ruleArrowExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrowExpression"


    // $ANTLR start "ruleArrowExpression"
    // InternalLtl.g:96:1: ruleArrowExpression returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )? ) ;
    public final EObject ruleArrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject this_OrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;

        EObject lv_rightOperand_6_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:102:2: ( (this_OrExpression_0= ruleOrExpression ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )? ) )
            // InternalLtl.g:103:2: (this_OrExpression_0= ruleOrExpression ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )? )
            {
            // InternalLtl.g:103:2: (this_OrExpression_0= ruleOrExpression ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )? )
            // InternalLtl.g:104:3: this_OrExpression_0= ruleOrExpression ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )?
            {

            			newCompositeNode(grammarAccess.getArrowExpressionAccess().getOrExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_3);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;


            			current = this_OrExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLtl.g:112:3: ( ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) ) | ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) ) )?
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            switch (alt1) {
                case 1 :
                    // InternalLtl.g:113:4: ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) )
                    {
                    // InternalLtl.g:113:4: ( () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) ) )
                    // InternalLtl.g:114:5: () otherlv_2= '->' ( (lv_rightOperand_3_0= ruleArrowExpression ) )
                    {
                    // InternalLtl.g:114:5: ()
                    // InternalLtl.g:115:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getArrowExpressionAccess().getImplyExpressionLeftOperandAction_1_0_0(),
                    							current);
                    					

                    }

                    otherlv_2=(Token)match(input,11,FOLLOW_4); 

                    					newLeafNode(otherlv_2, grammarAccess.getArrowExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_0_1());
                    				
                    // InternalLtl.g:125:5: ( (lv_rightOperand_3_0= ruleArrowExpression ) )
                    // InternalLtl.g:126:6: (lv_rightOperand_3_0= ruleArrowExpression )
                    {
                    // InternalLtl.g:126:6: (lv_rightOperand_3_0= ruleArrowExpression )
                    // InternalLtl.g:127:7: lv_rightOperand_3_0= ruleArrowExpression
                    {

                    							newCompositeNode(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_3_0=ruleArrowExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getArrowExpressionRule());
                    							}
                    							set(
                    								current,
                    								"rightOperand",
                    								lv_rightOperand_3_0,
                    								"hu.bme.mit.ltl.Ltl.ArrowExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:146:4: ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) )
                    {
                    // InternalLtl.g:146:4: ( () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) ) )
                    // InternalLtl.g:147:5: () otherlv_5= '<->' ( (lv_rightOperand_6_0= ruleArrowExpression ) )
                    {
                    // InternalLtl.g:147:5: ()
                    // InternalLtl.g:148:6: 
                    {

                    						current = forceCreateModelElementAndSet(
                    							grammarAccess.getArrowExpressionAccess().getEquivalenceExpressionLeftOperandAction_1_1_0(),
                    							current);
                    					

                    }

                    otherlv_5=(Token)match(input,12,FOLLOW_4); 

                    					newLeafNode(otherlv_5, grammarAccess.getArrowExpressionAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1_1());
                    				
                    // InternalLtl.g:158:5: ( (lv_rightOperand_6_0= ruleArrowExpression ) )
                    // InternalLtl.g:159:6: (lv_rightOperand_6_0= ruleArrowExpression )
                    {
                    // InternalLtl.g:159:6: (lv_rightOperand_6_0= ruleArrowExpression )
                    // InternalLtl.g:160:7: lv_rightOperand_6_0= ruleArrowExpression
                    {

                    							newCompositeNode(grammarAccess.getArrowExpressionAccess().getRightOperandArrowExpressionParserRuleCall_1_1_2_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_6_0=ruleArrowExpression();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getArrowExpressionRule());
                    							}
                    							set(
                    								current,
                    								"rightOperand",
                    								lv_rightOperand_6_0,
                    								"hu.bme.mit.ltl.Ltl.ArrowExpression");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrowExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalLtl.g:183:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalLtl.g:183:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalLtl.g:184:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalLtl.g:190:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:196:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )* ) )
            // InternalLtl.g:197:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )* )
            {
            // InternalLtl.g:197:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )* )
            // InternalLtl.g:198:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_5);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLtl.g:206:3: ( () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLtl.g:207:4: () otherlv_2= '|' ( (lv_rightOperand_3_0= ruleAndExpression ) )
            	    {
            	    // InternalLtl.g:207:4: ()
            	    // InternalLtl.g:208:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrExpressionAccess().getOrExpressionLeftOperandAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getVerticalLineKeyword_1_1());
            	    			
            	    // InternalLtl.g:218:4: ( (lv_rightOperand_3_0= ruleAndExpression ) )
            	    // InternalLtl.g:219:5: (lv_rightOperand_3_0= ruleAndExpression )
            	    {
            	    // InternalLtl.g:219:5: (lv_rightOperand_3_0= ruleAndExpression )
            	    // InternalLtl.g:220:6: lv_rightOperand_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightOperandAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_5);
            	    lv_rightOperand_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"rightOperand",
            	    							lv_rightOperand_3_0,
            	    							"hu.bme.mit.ltl.Ltl.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalLtl.g:242:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalLtl.g:242:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalLtl.g:243:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalLtl.g:249:1: ruleAndExpression returns [EObject current=null] : (this_UntilExpression_0= ruleUntilExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_UntilExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:255:2: ( (this_UntilExpression_0= ruleUntilExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )* ) )
            // InternalLtl.g:256:2: (this_UntilExpression_0= ruleUntilExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )* )
            {
            // InternalLtl.g:256:2: (this_UntilExpression_0= ruleUntilExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )* )
            // InternalLtl.g:257:3: this_UntilExpression_0= ruleUntilExpression ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getUntilExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_6);
            this_UntilExpression_0=ruleUntilExpression();

            state._fsp--;


            			current = this_UntilExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLtl.g:265:3: ( () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalLtl.g:266:4: () otherlv_2= '&' ( (lv_rightOperand_3_0= ruleUntilExpression ) )
            	    {
            	    // InternalLtl.g:266:4: ()
            	    // InternalLtl.g:267:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftOperandAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAmpersandKeyword_1_1());
            	    			
            	    // InternalLtl.g:277:4: ( (lv_rightOperand_3_0= ruleUntilExpression ) )
            	    // InternalLtl.g:278:5: (lv_rightOperand_3_0= ruleUntilExpression )
            	    {
            	    // InternalLtl.g:278:5: (lv_rightOperand_3_0= ruleUntilExpression )
            	    // InternalLtl.g:279:6: lv_rightOperand_3_0= ruleUntilExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_rightOperand_3_0=ruleUntilExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"rightOperand",
            	    							lv_rightOperand_3_0,
            	    							"hu.bme.mit.ltl.Ltl.UntilExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleUntilExpression"
    // InternalLtl.g:301:1: entryRuleUntilExpression returns [EObject current=null] : iv_ruleUntilExpression= ruleUntilExpression EOF ;
    public final EObject entryRuleUntilExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUntilExpression = null;


        try {
            // InternalLtl.g:301:56: (iv_ruleUntilExpression= ruleUntilExpression EOF )
            // InternalLtl.g:302:2: iv_ruleUntilExpression= ruleUntilExpression EOF
            {
             newCompositeNode(grammarAccess.getUntilExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUntilExpression=ruleUntilExpression();

            state._fsp--;

             current =iv_ruleUntilExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUntilExpression"


    // $ANTLR start "ruleUntilExpression"
    // InternalLtl.g:308:1: ruleUntilExpression returns [EObject current=null] : (this_FutureGloballyExpression_0= ruleFutureGloballyExpression ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )? ) ;
    public final EObject ruleUntilExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_FutureGloballyExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:314:2: ( (this_FutureGloballyExpression_0= ruleFutureGloballyExpression ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )? ) )
            // InternalLtl.g:315:2: (this_FutureGloballyExpression_0= ruleFutureGloballyExpression ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )? )
            {
            // InternalLtl.g:315:2: (this_FutureGloballyExpression_0= ruleFutureGloballyExpression ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )? )
            // InternalLtl.g:316:3: this_FutureGloballyExpression_0= ruleFutureGloballyExpression ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )?
            {

            			newCompositeNode(grammarAccess.getUntilExpressionAccess().getFutureGloballyExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_7);
            this_FutureGloballyExpression_0=ruleFutureGloballyExpression();

            state._fsp--;


            			current = this_FutureGloballyExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLtl.g:324:3: ( () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalLtl.g:325:4: () otherlv_2= 'U' ( (lv_rightOperand_3_0= ruleUntilExpression ) )
                    {
                    // InternalLtl.g:325:4: ()
                    // InternalLtl.g:326:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getUntilExpressionAccess().getUntilExpressionLeftOperandAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,15,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getUntilExpressionAccess().getUKeyword_1_1());
                    			
                    // InternalLtl.g:336:4: ( (lv_rightOperand_3_0= ruleUntilExpression ) )
                    // InternalLtl.g:337:5: (lv_rightOperand_3_0= ruleUntilExpression )
                    {
                    // InternalLtl.g:337:5: (lv_rightOperand_3_0= ruleUntilExpression )
                    // InternalLtl.g:338:6: lv_rightOperand_3_0= ruleUntilExpression
                    {

                    						newCompositeNode(grammarAccess.getUntilExpressionAccess().getRightOperandUntilExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_rightOperand_3_0=ruleUntilExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUntilExpressionRule());
                    						}
                    						set(
                    							current,
                    							"rightOperand",
                    							lv_rightOperand_3_0,
                    							"hu.bme.mit.ltl.Ltl.UntilExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUntilExpression"


    // $ANTLR start "entryRuleFutureGloballyExpression"
    // InternalLtl.g:360:1: entryRuleFutureGloballyExpression returns [EObject current=null] : iv_ruleFutureGloballyExpression= ruleFutureGloballyExpression EOF ;
    public final EObject entryRuleFutureGloballyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFutureGloballyExpression = null;


        try {
            // InternalLtl.g:360:65: (iv_ruleFutureGloballyExpression= ruleFutureGloballyExpression EOF )
            // InternalLtl.g:361:2: iv_ruleFutureGloballyExpression= ruleFutureGloballyExpression EOF
            {
             newCompositeNode(grammarAccess.getFutureGloballyExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFutureGloballyExpression=ruleFutureGloballyExpression();

            state._fsp--;

             current =iv_ruleFutureGloballyExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFutureGloballyExpression"


    // $ANTLR start "ruleFutureGloballyExpression"
    // InternalLtl.g:367:1: ruleFutureGloballyExpression returns [EObject current=null] : ( (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) ) | (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) ) | this_NextExpression_6= ruleNextExpression ) ;
    public final EObject ruleFutureGloballyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_operand_2_0 = null;

        EObject lv_operand_5_0 = null;

        EObject this_NextExpression_6 = null;



        	enterRule();

        try {
            // InternalLtl.g:373:2: ( ( (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) ) | (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) ) | this_NextExpression_6= ruleNextExpression ) )
            // InternalLtl.g:374:2: ( (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) ) | (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) ) | this_NextExpression_6= ruleNextExpression )
            {
            // InternalLtl.g:374:2: ( (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) ) | (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) ) | this_NextExpression_6= ruleNextExpression )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
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
                    // InternalLtl.g:375:3: (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) )
                    {
                    // InternalLtl.g:375:3: (otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) ) )
                    // InternalLtl.g:376:4: otherlv_0= 'F' () ( (lv_operand_2_0= ruleNextExpression ) )
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getFutureGloballyExpressionAccess().getFKeyword_0_0());
                    			
                    // InternalLtl.g:380:4: ()
                    // InternalLtl.g:381:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFutureGloballyExpressionAccess().getFutureExpressionAction_0_1(),
                    						current);
                    				

                    }

                    // InternalLtl.g:387:4: ( (lv_operand_2_0= ruleNextExpression ) )
                    // InternalLtl.g:388:5: (lv_operand_2_0= ruleNextExpression )
                    {
                    // InternalLtl.g:388:5: (lv_operand_2_0= ruleNextExpression )
                    // InternalLtl.g:389:6: lv_operand_2_0= ruleNextExpression
                    {

                    						newCompositeNode(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleNextExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFutureGloballyExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_2_0,
                    							"hu.bme.mit.ltl.Ltl.NextExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:408:3: (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) )
                    {
                    // InternalLtl.g:408:3: (otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) ) )
                    // InternalLtl.g:409:4: otherlv_3= 'G' () ( (lv_operand_5_0= ruleNextExpression ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getFutureGloballyExpressionAccess().getGKeyword_1_0());
                    			
                    // InternalLtl.g:413:4: ()
                    // InternalLtl.g:414:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getFutureGloballyExpressionAccess().getGloballyExpressionAction_1_1(),
                    						current);
                    				

                    }

                    // InternalLtl.g:420:4: ( (lv_operand_5_0= ruleNextExpression ) )
                    // InternalLtl.g:421:5: (lv_operand_5_0= ruleNextExpression )
                    {
                    // InternalLtl.g:421:5: (lv_operand_5_0= ruleNextExpression )
                    // InternalLtl.g:422:6: lv_operand_5_0= ruleNextExpression
                    {

                    						newCompositeNode(grammarAccess.getFutureGloballyExpressionAccess().getOperandNextExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_5_0=ruleNextExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFutureGloballyExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_5_0,
                    							"hu.bme.mit.ltl.Ltl.NextExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalLtl.g:441:3: this_NextExpression_6= ruleNextExpression
                    {

                    			newCompositeNode(grammarAccess.getFutureGloballyExpressionAccess().getNextExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_NextExpression_6=ruleNextExpression();

                    state._fsp--;


                    			current = this_NextExpression_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFutureGloballyExpression"


    // $ANTLR start "entryRuleNextExpression"
    // InternalLtl.g:453:1: entryRuleNextExpression returns [EObject current=null] : iv_ruleNextExpression= ruleNextExpression EOF ;
    public final EObject entryRuleNextExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextExpression = null;


        try {
            // InternalLtl.g:453:55: (iv_ruleNextExpression= ruleNextExpression EOF )
            // InternalLtl.g:454:2: iv_ruleNextExpression= ruleNextExpression EOF
            {
             newCompositeNode(grammarAccess.getNextExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNextExpression=ruleNextExpression();

            state._fsp--;

             current =iv_ruleNextExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextExpression"


    // $ANTLR start "ruleNextExpression"
    // InternalLtl.g:460:1: ruleNextExpression returns [EObject current=null] : ( (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) ;
    public final EObject ruleNextExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_operand_2_0 = null;

        EObject this_PrimaryExpression_3 = null;



        	enterRule();

        try {
            // InternalLtl.g:466:2: ( ( (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) )
            // InternalLtl.g:467:2: ( (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            {
            // InternalLtl.g:467:2: ( (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||LA6_0==19||(LA6_0>=21 && LA6_0<=23)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalLtl.g:468:3: (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) )
                    {
                    // InternalLtl.g:468:3: (otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) ) )
                    // InternalLtl.g:469:4: otherlv_0= 'X' () ( (lv_operand_2_0= rulePrimaryExpression ) )
                    {
                    otherlv_0=(Token)match(input,18,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getNextExpressionAccess().getXKeyword_0_0());
                    			
                    // InternalLtl.g:473:4: ()
                    // InternalLtl.g:474:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNextExpressionAccess().getNextExpressionAction_0_1(),
                    						current);
                    				

                    }

                    // InternalLtl.g:480:4: ( (lv_operand_2_0= rulePrimaryExpression ) )
                    // InternalLtl.g:481:5: (lv_operand_2_0= rulePrimaryExpression )
                    {
                    // InternalLtl.g:481:5: (lv_operand_2_0= rulePrimaryExpression )
                    // InternalLtl.g:482:6: lv_operand_2_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getNextExpressionAccess().getOperandPrimaryExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNextExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_2_0,
                    							"hu.bme.mit.ltl.Ltl.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:501:3: this_PrimaryExpression_3= rulePrimaryExpression
                    {

                    			newCompositeNode(grammarAccess.getNextExpressionAccess().getPrimaryExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_3=rulePrimaryExpression();

                    state._fsp--;


                    			current = this_PrimaryExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalLtl.g:513:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalLtl.g:513:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalLtl.g:514:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalLtl.g:520:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) ) | this_LiteralExpression_6= ruleLiteralExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LTLExpression_1 = null;

        EObject lv_operand_5_0 = null;

        EObject this_LiteralExpression_6 = null;



        	enterRule();

        try {
            // InternalLtl.g:526:2: ( ( (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) ) | this_LiteralExpression_6= ruleLiteralExpression ) )
            // InternalLtl.g:527:2: ( (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) ) | this_LiteralExpression_6= ruleLiteralExpression )
            {
            // InternalLtl.g:527:2: ( (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) ) | this_LiteralExpression_6= ruleLiteralExpression )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt7=1;
                }
                break;
            case 21:
                {
                alt7=2;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case 22:
            case 23:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalLtl.g:528:3: (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' )
                    {
                    // InternalLtl.g:528:3: (otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')' )
                    // InternalLtl.g:529:4: otherlv_0= '(' this_LTLExpression_1= ruleLTLExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLTLExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_8);
                    this_LTLExpression_1=ruleLTLExpression();

                    state._fsp--;


                    				current = this_LTLExpression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLtl.g:547:3: ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) )
                    {
                    // InternalLtl.g:547:3: ( () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) ) )
                    // InternalLtl.g:548:4: () otherlv_4= '!' ( (lv_operand_5_0= rulePrimaryExpression ) )
                    {
                    // InternalLtl.g:548:4: ()
                    // InternalLtl.g:549:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNotExpressionAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_4=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getExclamationMarkKeyword_1_1());
                    			
                    // InternalLtl.g:559:4: ( (lv_operand_5_0= rulePrimaryExpression ) )
                    // InternalLtl.g:560:5: (lv_operand_5_0= rulePrimaryExpression )
                    {
                    // InternalLtl.g:560:5: (lv_operand_5_0= rulePrimaryExpression )
                    // InternalLtl.g:561:6: lv_operand_5_0= rulePrimaryExpression
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperandPrimaryExpressionParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_5_0=rulePrimaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_5_0,
                    							"hu.bme.mit.ltl.Ltl.PrimaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalLtl.g:580:3: this_LiteralExpression_6= ruleLiteralExpression
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralExpression_6=ruleLiteralExpression();

                    state._fsp--;


                    			current = this_LiteralExpression_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalLtl.g:592:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalLtl.g:592:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalLtl.g:593:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
             newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;

             current =iv_ruleLiteralExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalLtl.g:599:1: ruleLiteralExpression returns [EObject current=null] : (this_AtomicProposition_0= ruleAtomicProposition | this_TrueExpression_1= ruleTrueExpression | this_FalseExpression_2= ruleFalseExpression ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AtomicProposition_0 = null;

        EObject this_TrueExpression_1 = null;

        EObject this_FalseExpression_2 = null;



        	enterRule();

        try {
            // InternalLtl.g:605:2: ( (this_AtomicProposition_0= ruleAtomicProposition | this_TrueExpression_1= ruleTrueExpression | this_FalseExpression_2= ruleFalseExpression ) )
            // InternalLtl.g:606:2: (this_AtomicProposition_0= ruleAtomicProposition | this_TrueExpression_1= ruleTrueExpression | this_FalseExpression_2= ruleFalseExpression )
            {
            // InternalLtl.g:606:2: (this_AtomicProposition_0= ruleAtomicProposition | this_TrueExpression_1= ruleTrueExpression | this_FalseExpression_2= ruleFalseExpression )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 23:
                {
                alt8=2;
                }
                break;
            case 22:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalLtl.g:607:3: this_AtomicProposition_0= ruleAtomicProposition
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getAtomicPropositionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AtomicProposition_0=ruleAtomicProposition();

                    state._fsp--;


                    			current = this_AtomicProposition_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLtl.g:616:3: this_TrueExpression_1= ruleTrueExpression
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getTrueExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrueExpression_1=ruleTrueExpression();

                    state._fsp--;


                    			current = this_TrueExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLtl.g:625:3: this_FalseExpression_2= ruleFalseExpression
                    {

                    			newCompositeNode(grammarAccess.getLiteralExpressionAccess().getFalseExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FalseExpression_2=ruleFalseExpression();

                    state._fsp--;


                    			current = this_FalseExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleFalseExpression"
    // InternalLtl.g:637:1: entryRuleFalseExpression returns [EObject current=null] : iv_ruleFalseExpression= ruleFalseExpression EOF ;
    public final EObject entryRuleFalseExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFalseExpression = null;


        try {
            // InternalLtl.g:637:56: (iv_ruleFalseExpression= ruleFalseExpression EOF )
            // InternalLtl.g:638:2: iv_ruleFalseExpression= ruleFalseExpression EOF
            {
             newCompositeNode(grammarAccess.getFalseExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFalseExpression=ruleFalseExpression();

            state._fsp--;

             current =iv_ruleFalseExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFalseExpression"


    // $ANTLR start "ruleFalseExpression"
    // InternalLtl.g:644:1: ruleFalseExpression returns [EObject current=null] : ( () otherlv_1= 'false' ) ;
    public final EObject ruleFalseExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalLtl.g:650:2: ( ( () otherlv_1= 'false' ) )
            // InternalLtl.g:651:2: ( () otherlv_1= 'false' )
            {
            // InternalLtl.g:651:2: ( () otherlv_1= 'false' )
            // InternalLtl.g:652:3: () otherlv_1= 'false'
            {
            // InternalLtl.g:652:3: ()
            // InternalLtl.g:653:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFalseExpressionAccess().getFalseExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFalseExpressionAccess().getFalseKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFalseExpression"


    // $ANTLR start "entryRuleTrueExpression"
    // InternalLtl.g:667:1: entryRuleTrueExpression returns [EObject current=null] : iv_ruleTrueExpression= ruleTrueExpression EOF ;
    public final EObject entryRuleTrueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueExpression = null;


        try {
            // InternalLtl.g:667:55: (iv_ruleTrueExpression= ruleTrueExpression EOF )
            // InternalLtl.g:668:2: iv_ruleTrueExpression= ruleTrueExpression EOF
            {
             newCompositeNode(grammarAccess.getTrueExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrueExpression=ruleTrueExpression();

            state._fsp--;

             current =iv_ruleTrueExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrueExpression"


    // $ANTLR start "ruleTrueExpression"
    // InternalLtl.g:674:1: ruleTrueExpression returns [EObject current=null] : ( () otherlv_1= 'true' ) ;
    public final EObject ruleTrueExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalLtl.g:680:2: ( ( () otherlv_1= 'true' ) )
            // InternalLtl.g:681:2: ( () otherlv_1= 'true' )
            {
            // InternalLtl.g:681:2: ( () otherlv_1= 'true' )
            // InternalLtl.g:682:3: () otherlv_1= 'true'
            {
            // InternalLtl.g:682:3: ()
            // InternalLtl.g:683:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrueExpressionAccess().getTrueExpressionAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getTrueExpressionAccess().getTrueKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrueExpression"


    // $ANTLR start "entryRuleAtomicProposition"
    // InternalLtl.g:697:1: entryRuleAtomicProposition returns [EObject current=null] : iv_ruleAtomicProposition= ruleAtomicProposition EOF ;
    public final EObject entryRuleAtomicProposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicProposition = null;


        try {
            // InternalLtl.g:697:58: (iv_ruleAtomicProposition= ruleAtomicProposition EOF )
            // InternalLtl.g:698:2: iv_ruleAtomicProposition= ruleAtomicProposition EOF
            {
             newCompositeNode(grammarAccess.getAtomicPropositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAtomicProposition=ruleAtomicProposition();

            state._fsp--;

             current =iv_ruleAtomicProposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicProposition"


    // $ANTLR start "ruleAtomicProposition"
    // InternalLtl.g:704:1: ruleAtomicProposition returns [EObject current=null] : ( () ( (lv_proposition_1_0= ruleEString ) ) ) ;
    public final EObject ruleAtomicProposition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_proposition_1_0 = null;



        	enterRule();

        try {
            // InternalLtl.g:710:2: ( ( () ( (lv_proposition_1_0= ruleEString ) ) ) )
            // InternalLtl.g:711:2: ( () ( (lv_proposition_1_0= ruleEString ) ) )
            {
            // InternalLtl.g:711:2: ( () ( (lv_proposition_1_0= ruleEString ) ) )
            // InternalLtl.g:712:3: () ( (lv_proposition_1_0= ruleEString ) )
            {
            // InternalLtl.g:712:3: ()
            // InternalLtl.g:713:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAtomicPropositionAccess().getAtomicPropositionAction_0(),
            					current);
            			

            }

            // InternalLtl.g:719:3: ( (lv_proposition_1_0= ruleEString ) )
            // InternalLtl.g:720:4: (lv_proposition_1_0= ruleEString )
            {
            // InternalLtl.g:720:4: (lv_proposition_1_0= ruleEString )
            // InternalLtl.g:721:5: lv_proposition_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAtomicPropositionAccess().getPropositionEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_proposition_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAtomicPropositionRule());
            					}
            					set(
            						current,
            						"proposition",
            						lv_proposition_1_0,
            						"hu.bme.mit.ltl.Ltl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicProposition"


    // $ANTLR start "entryRuleEString"
    // InternalLtl.g:742:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalLtl.g:742:47: (iv_ruleEString= ruleEString EOF )
            // InternalLtl.g:743:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalLtl.g:749:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalLtl.g:755:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalLtl.g:756:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalLtl.g:756:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalLtl.g:757:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalLtl.g:765:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000EF0030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});

}