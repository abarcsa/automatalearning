package hu.bme.mit.mealymodel.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.mealymodel.xtext.services.MealymachineDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMealymachineDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'MealyMachine'", "'{'", "'initialState'", "'states'", "','", "'}'", "'inputAlphabet'", "'outputAlphabet'", "'transitions'", "'State'", "'Alphabet'", "'characters'", "'Transition'", "'input'", "'output'", "'sourceState'", "'targetState'"
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
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMealymachineDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMealymachineDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMealymachineDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMealymachineDsl.g"; }



     	private MealymachineDslGrammarAccess grammarAccess;

        public InternalMealymachineDslParser(TokenStream input, MealymachineDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "MealyMachine";
       	}

       	@Override
       	protected MealymachineDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleMealyMachine"
    // InternalMealymachineDsl.g:64:1: entryRuleMealyMachine returns [EObject current=null] : iv_ruleMealyMachine= ruleMealyMachine EOF ;
    public final EObject entryRuleMealyMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMealyMachine = null;


        try {
            // InternalMealymachineDsl.g:64:53: (iv_ruleMealyMachine= ruleMealyMachine EOF )
            // InternalMealymachineDsl.g:65:2: iv_ruleMealyMachine= ruleMealyMachine EOF
            {
             newCompositeNode(grammarAccess.getMealyMachineRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMealyMachine=ruleMealyMachine();

            state._fsp--;

             current =iv_ruleMealyMachine; 
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
    // $ANTLR end "entryRuleMealyMachine"


    // $ANTLR start "ruleMealyMachine"
    // InternalMealymachineDsl.g:71:1: ruleMealyMachine returns [EObject current=null] : (otherlv_0= 'MealyMachine' otherlv_1= '{' otherlv_2= 'initialState' ( (lv_initialState_3_0= ruleState ) ) otherlv_4= 'states' otherlv_5= '{' ( (lv_states_6_0= ruleState ) ) (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )* otherlv_9= '}' otherlv_10= 'inputAlphabet' ( (lv_inputAlphabet_11_0= ruleAlphabet ) ) otherlv_12= 'outputAlphabet' ( (lv_outputAlphabet_13_0= ruleAlphabet ) ) otherlv_14= 'transitions' otherlv_15= '{' ( (lv_transitions_16_0= ruleTransition ) ) (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )* otherlv_19= '}' otherlv_20= '}' ) ;
    public final EObject ruleMealyMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        EObject lv_initialState_3_0 = null;

        EObject lv_states_6_0 = null;

        EObject lv_states_8_0 = null;

        EObject lv_inputAlphabet_11_0 = null;

        EObject lv_outputAlphabet_13_0 = null;

        EObject lv_transitions_16_0 = null;

        EObject lv_transitions_18_0 = null;



        	enterRule();

        try {
            // InternalMealymachineDsl.g:77:2: ( (otherlv_0= 'MealyMachine' otherlv_1= '{' otherlv_2= 'initialState' ( (lv_initialState_3_0= ruleState ) ) otherlv_4= 'states' otherlv_5= '{' ( (lv_states_6_0= ruleState ) ) (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )* otherlv_9= '}' otherlv_10= 'inputAlphabet' ( (lv_inputAlphabet_11_0= ruleAlphabet ) ) otherlv_12= 'outputAlphabet' ( (lv_outputAlphabet_13_0= ruleAlphabet ) ) otherlv_14= 'transitions' otherlv_15= '{' ( (lv_transitions_16_0= ruleTransition ) ) (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )* otherlv_19= '}' otherlv_20= '}' ) )
            // InternalMealymachineDsl.g:78:2: (otherlv_0= 'MealyMachine' otherlv_1= '{' otherlv_2= 'initialState' ( (lv_initialState_3_0= ruleState ) ) otherlv_4= 'states' otherlv_5= '{' ( (lv_states_6_0= ruleState ) ) (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )* otherlv_9= '}' otherlv_10= 'inputAlphabet' ( (lv_inputAlphabet_11_0= ruleAlphabet ) ) otherlv_12= 'outputAlphabet' ( (lv_outputAlphabet_13_0= ruleAlphabet ) ) otherlv_14= 'transitions' otherlv_15= '{' ( (lv_transitions_16_0= ruleTransition ) ) (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )* otherlv_19= '}' otherlv_20= '}' )
            {
            // InternalMealymachineDsl.g:78:2: (otherlv_0= 'MealyMachine' otherlv_1= '{' otherlv_2= 'initialState' ( (lv_initialState_3_0= ruleState ) ) otherlv_4= 'states' otherlv_5= '{' ( (lv_states_6_0= ruleState ) ) (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )* otherlv_9= '}' otherlv_10= 'inputAlphabet' ( (lv_inputAlphabet_11_0= ruleAlphabet ) ) otherlv_12= 'outputAlphabet' ( (lv_outputAlphabet_13_0= ruleAlphabet ) ) otherlv_14= 'transitions' otherlv_15= '{' ( (lv_transitions_16_0= ruleTransition ) ) (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )* otherlv_19= '}' otherlv_20= '}' )
            // InternalMealymachineDsl.g:79:3: otherlv_0= 'MealyMachine' otherlv_1= '{' otherlv_2= 'initialState' ( (lv_initialState_3_0= ruleState ) ) otherlv_4= 'states' otherlv_5= '{' ( (lv_states_6_0= ruleState ) ) (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )* otherlv_9= '}' otherlv_10= 'inputAlphabet' ( (lv_inputAlphabet_11_0= ruleAlphabet ) ) otherlv_12= 'outputAlphabet' ( (lv_outputAlphabet_13_0= ruleAlphabet ) ) otherlv_14= 'transitions' otherlv_15= '{' ( (lv_transitions_16_0= ruleTransition ) ) (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )* otherlv_19= '}' otherlv_20= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMealyMachineAccess().getMealyMachineKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getMealyMachineAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getMealyMachineAccess().getInitialStateKeyword_2());
            		
            // InternalMealymachineDsl.g:91:3: ( (lv_initialState_3_0= ruleState ) )
            // InternalMealymachineDsl.g:92:4: (lv_initialState_3_0= ruleState )
            {
            // InternalMealymachineDsl.g:92:4: (lv_initialState_3_0= ruleState )
            // InternalMealymachineDsl.g:93:5: lv_initialState_3_0= ruleState
            {

            					newCompositeNode(grammarAccess.getMealyMachineAccess().getInitialStateStateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_initialState_3_0=ruleState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            					}
            					set(
            						current,
            						"initialState",
            						lv_initialState_3_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.State");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getMealyMachineAccess().getStatesKeyword_4());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getMealyMachineAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalMealymachineDsl.g:118:3: ( (lv_states_6_0= ruleState ) )
            // InternalMealymachineDsl.g:119:4: (lv_states_6_0= ruleState )
            {
            // InternalMealymachineDsl.g:119:4: (lv_states_6_0= ruleState )
            // InternalMealymachineDsl.g:120:5: lv_states_6_0= ruleState
            {

            					newCompositeNode(grammarAccess.getMealyMachineAccess().getStatesStateParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
            lv_states_6_0=ruleState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            					}
            					add(
            						current,
            						"states",
            						lv_states_6_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.State");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMealymachineDsl.g:137:3: (otherlv_7= ',' ( (lv_states_8_0= ruleState ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMealymachineDsl.g:138:4: otherlv_7= ',' ( (lv_states_8_0= ruleState ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_5); 

            	    				newLeafNode(otherlv_7, grammarAccess.getMealyMachineAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalMealymachineDsl.g:142:4: ( (lv_states_8_0= ruleState ) )
            	    // InternalMealymachineDsl.g:143:5: (lv_states_8_0= ruleState )
            	    {
            	    // InternalMealymachineDsl.g:143:5: (lv_states_8_0= ruleState )
            	    // InternalMealymachineDsl.g:144:6: lv_states_8_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getMealyMachineAccess().getStatesStateParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_states_8_0=ruleState();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"states",
            	    							lv_states_8_0,
            	    							"hu.bme.mit.mealymodel.xtext.MealymachineDsl.State");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_9=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_9, grammarAccess.getMealyMachineAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_10=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_10, grammarAccess.getMealyMachineAccess().getInputAlphabetKeyword_9());
            		
            // InternalMealymachineDsl.g:170:3: ( (lv_inputAlphabet_11_0= ruleAlphabet ) )
            // InternalMealymachineDsl.g:171:4: (lv_inputAlphabet_11_0= ruleAlphabet )
            {
            // InternalMealymachineDsl.g:171:4: (lv_inputAlphabet_11_0= ruleAlphabet )
            // InternalMealymachineDsl.g:172:5: lv_inputAlphabet_11_0= ruleAlphabet
            {

            					newCompositeNode(grammarAccess.getMealyMachineAccess().getInputAlphabetAlphabetParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_10);
            lv_inputAlphabet_11_0=ruleAlphabet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            					}
            					set(
            						current,
            						"inputAlphabet",
            						lv_inputAlphabet_11_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.Alphabet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_12, grammarAccess.getMealyMachineAccess().getOutputAlphabetKeyword_11());
            		
            // InternalMealymachineDsl.g:193:3: ( (lv_outputAlphabet_13_0= ruleAlphabet ) )
            // InternalMealymachineDsl.g:194:4: (lv_outputAlphabet_13_0= ruleAlphabet )
            {
            // InternalMealymachineDsl.g:194:4: (lv_outputAlphabet_13_0= ruleAlphabet )
            // InternalMealymachineDsl.g:195:5: lv_outputAlphabet_13_0= ruleAlphabet
            {

            					newCompositeNode(grammarAccess.getMealyMachineAccess().getOutputAlphabetAlphabetParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_11);
            lv_outputAlphabet_13_0=ruleAlphabet();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            					}
            					set(
            						current,
            						"outputAlphabet",
            						lv_outputAlphabet_13_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.Alphabet");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,19,FOLLOW_3); 

            			newLeafNode(otherlv_14, grammarAccess.getMealyMachineAccess().getTransitionsKeyword_13());
            		
            otherlv_15=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_15, grammarAccess.getMealyMachineAccess().getLeftCurlyBracketKeyword_14());
            		
            // InternalMealymachineDsl.g:220:3: ( (lv_transitions_16_0= ruleTransition ) )
            // InternalMealymachineDsl.g:221:4: (lv_transitions_16_0= ruleTransition )
            {
            // InternalMealymachineDsl.g:221:4: (lv_transitions_16_0= ruleTransition )
            // InternalMealymachineDsl.g:222:5: lv_transitions_16_0= ruleTransition
            {

            					newCompositeNode(grammarAccess.getMealyMachineAccess().getTransitionsTransitionParserRuleCall_15_0());
            				
            pushFollow(FOLLOW_7);
            lv_transitions_16_0=ruleTransition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            					}
            					add(
            						current,
            						"transitions",
            						lv_transitions_16_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.Transition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMealymachineDsl.g:239:3: (otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMealymachineDsl.g:240:4: otherlv_17= ',' ( (lv_transitions_18_0= ruleTransition ) )
            	    {
            	    otherlv_17=(Token)match(input,15,FOLLOW_12); 

            	    				newLeafNode(otherlv_17, grammarAccess.getMealyMachineAccess().getCommaKeyword_16_0());
            	    			
            	    // InternalMealymachineDsl.g:244:4: ( (lv_transitions_18_0= ruleTransition ) )
            	    // InternalMealymachineDsl.g:245:5: (lv_transitions_18_0= ruleTransition )
            	    {
            	    // InternalMealymachineDsl.g:245:5: (lv_transitions_18_0= ruleTransition )
            	    // InternalMealymachineDsl.g:246:6: lv_transitions_18_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getMealyMachineAccess().getTransitionsTransitionParserRuleCall_16_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_transitions_18_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMealyMachineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"transitions",
            	    							lv_transitions_18_0,
            	    							"hu.bme.mit.mealymodel.xtext.MealymachineDsl.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_19=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_19, grammarAccess.getMealyMachineAccess().getRightCurlyBracketKeyword_17());
            		
            otherlv_20=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_20, grammarAccess.getMealyMachineAccess().getRightCurlyBracketKeyword_18());
            		

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
    // $ANTLR end "ruleMealyMachine"


    // $ANTLR start "entryRuleState"
    // InternalMealymachineDsl.g:276:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalMealymachineDsl.g:276:46: (iv_ruleState= ruleState EOF )
            // InternalMealymachineDsl.g:277:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalMealymachineDsl.g:283:1: ruleState returns [EObject current=null] : ( () otherlv_1= 'State' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalMealymachineDsl.g:289:2: ( ( () otherlv_1= 'State' ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalMealymachineDsl.g:290:2: ( () otherlv_1= 'State' ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalMealymachineDsl.g:290:2: ( () otherlv_1= 'State' ( (lv_name_2_0= ruleEString ) ) )
            // InternalMealymachineDsl.g:291:3: () otherlv_1= 'State' ( (lv_name_2_0= ruleEString ) )
            {
            // InternalMealymachineDsl.g:291:3: ()
            // InternalMealymachineDsl.g:292:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStateAccess().getStateAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getStateAccess().getStateKeyword_1());
            		
            // InternalMealymachineDsl.g:302:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMealymachineDsl.g:303:4: (lv_name_2_0= ruleEString )
            {
            // InternalMealymachineDsl.g:303:4: (lv_name_2_0= ruleEString )
            // InternalMealymachineDsl.g:304:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getStateAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStateRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.EString");
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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAlphabet"
    // InternalMealymachineDsl.g:325:1: entryRuleAlphabet returns [EObject current=null] : iv_ruleAlphabet= ruleAlphabet EOF ;
    public final EObject entryRuleAlphabet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlphabet = null;


        try {
            // InternalMealymachineDsl.g:325:49: (iv_ruleAlphabet= ruleAlphabet EOF )
            // InternalMealymachineDsl.g:326:2: iv_ruleAlphabet= ruleAlphabet EOF
            {
             newCompositeNode(grammarAccess.getAlphabetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlphabet=ruleAlphabet();

            state._fsp--;

             current =iv_ruleAlphabet; 
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
    // $ANTLR end "entryRuleAlphabet"


    // $ANTLR start "ruleAlphabet"
    // InternalMealymachineDsl.g:332:1: ruleAlphabet returns [EObject current=null] : (otherlv_0= 'Alphabet' otherlv_1= '{' otherlv_2= 'characters' otherlv_3= '{' ( (lv_characters_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleAlphabet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_characters_4_0 = null;

        AntlrDatatypeRuleToken lv_characters_6_0 = null;



        	enterRule();

        try {
            // InternalMealymachineDsl.g:338:2: ( (otherlv_0= 'Alphabet' otherlv_1= '{' otherlv_2= 'characters' otherlv_3= '{' ( (lv_characters_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalMealymachineDsl.g:339:2: (otherlv_0= 'Alphabet' otherlv_1= '{' otherlv_2= 'characters' otherlv_3= '{' ( (lv_characters_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalMealymachineDsl.g:339:2: (otherlv_0= 'Alphabet' otherlv_1= '{' otherlv_2= 'characters' otherlv_3= '{' ( (lv_characters_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalMealymachineDsl.g:340:3: otherlv_0= 'Alphabet' otherlv_1= '{' otherlv_2= 'characters' otherlv_3= '{' ( (lv_characters_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAlphabetAccess().getAlphabetKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_1, grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAlphabetAccess().getCharactersKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getAlphabetAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalMealymachineDsl.g:356:3: ( (lv_characters_4_0= ruleEString ) )
            // InternalMealymachineDsl.g:357:4: (lv_characters_4_0= ruleEString )
            {
            // InternalMealymachineDsl.g:357:4: (lv_characters_4_0= ruleEString )
            // InternalMealymachineDsl.g:358:5: lv_characters_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAlphabetAccess().getCharactersEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_characters_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAlphabetRule());
            					}
            					add(
            						current,
            						"characters",
            						lv_characters_4_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMealymachineDsl.g:375:3: (otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMealymachineDsl.g:376:4: otherlv_5= ',' ( (lv_characters_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,15,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getAlphabetAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMealymachineDsl.g:380:4: ( (lv_characters_6_0= ruleEString ) )
            	    // InternalMealymachineDsl.g:381:5: (lv_characters_6_0= ruleEString )
            	    {
            	    // InternalMealymachineDsl.g:381:5: (lv_characters_6_0= ruleEString )
            	    // InternalMealymachineDsl.g:382:6: lv_characters_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getAlphabetAccess().getCharactersEStringParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_characters_6_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAlphabetRule());
            	    						}
            	    						add(
            	    							current,
            	    							"characters",
            	    							lv_characters_6_0,
            	    							"hu.bme.mit.mealymodel.xtext.MealymachineDsl.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_7=(Token)match(input,16,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_8=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getAlphabetAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleAlphabet"


    // $ANTLR start "entryRuleTransition"
    // InternalMealymachineDsl.g:412:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalMealymachineDsl.g:412:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalMealymachineDsl.g:413:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalMealymachineDsl.g:419:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'Transition' otherlv_1= '{' otherlv_2= 'input' ( (lv_input_3_0= ruleEString ) ) otherlv_4= 'output' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'sourceState' ( ( ruleEString ) ) otherlv_8= 'targetState' ( ( ruleEString ) ) otherlv_10= '}' ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_input_3_0 = null;

        AntlrDatatypeRuleToken lv_output_5_0 = null;



        	enterRule();

        try {
            // InternalMealymachineDsl.g:425:2: ( (otherlv_0= 'Transition' otherlv_1= '{' otherlv_2= 'input' ( (lv_input_3_0= ruleEString ) ) otherlv_4= 'output' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'sourceState' ( ( ruleEString ) ) otherlv_8= 'targetState' ( ( ruleEString ) ) otherlv_10= '}' ) )
            // InternalMealymachineDsl.g:426:2: (otherlv_0= 'Transition' otherlv_1= '{' otherlv_2= 'input' ( (lv_input_3_0= ruleEString ) ) otherlv_4= 'output' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'sourceState' ( ( ruleEString ) ) otherlv_8= 'targetState' ( ( ruleEString ) ) otherlv_10= '}' )
            {
            // InternalMealymachineDsl.g:426:2: (otherlv_0= 'Transition' otherlv_1= '{' otherlv_2= 'input' ( (lv_input_3_0= ruleEString ) ) otherlv_4= 'output' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'sourceState' ( ( ruleEString ) ) otherlv_8= 'targetState' ( ( ruleEString ) ) otherlv_10= '}' )
            // InternalMealymachineDsl.g:427:3: otherlv_0= 'Transition' otherlv_1= '{' otherlv_2= 'input' ( (lv_input_3_0= ruleEString ) ) otherlv_4= 'output' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'sourceState' ( ( ruleEString ) ) otherlv_8= 'targetState' ( ( ruleEString ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getTransitionKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getInputKeyword_2());
            		
            // InternalMealymachineDsl.g:439:3: ( (lv_input_3_0= ruleEString ) )
            // InternalMealymachineDsl.g:440:4: (lv_input_3_0= ruleEString )
            {
            // InternalMealymachineDsl.g:440:4: (lv_input_3_0= ruleEString )
            // InternalMealymachineDsl.g:441:5: lv_input_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTransitionAccess().getInputEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_17);
            lv_input_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransitionRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_3_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getOutputKeyword_4());
            		
            // InternalMealymachineDsl.g:462:3: ( (lv_output_5_0= ruleEString ) )
            // InternalMealymachineDsl.g:463:4: (lv_output_5_0= ruleEString )
            {
            // InternalMealymachineDsl.g:463:4: (lv_output_5_0= ruleEString )
            // InternalMealymachineDsl.g:464:5: lv_output_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTransitionAccess().getOutputEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_18);
            lv_output_5_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransitionRule());
            					}
            					set(
            						current,
            						"output",
            						lv_output_5_0,
            						"hu.bme.mit.mealymodel.xtext.MealymachineDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,26,FOLLOW_14); 

            			newLeafNode(otherlv_6, grammarAccess.getTransitionAccess().getSourceStateKeyword_6());
            		
            // InternalMealymachineDsl.g:485:3: ( ( ruleEString ) )
            // InternalMealymachineDsl.g:486:4: ( ruleEString )
            {
            // InternalMealymachineDsl.g:486:4: ( ruleEString )
            // InternalMealymachineDsl.g:487:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getSourceStateStateCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,27,FOLLOW_14); 

            			newLeafNode(otherlv_8, grammarAccess.getTransitionAccess().getTargetStateKeyword_8());
            		
            // InternalMealymachineDsl.g:505:3: ( ( ruleEString ) )
            // InternalMealymachineDsl.g:506:4: ( ruleEString )
            {
            // InternalMealymachineDsl.g:506:4: ( ruleEString )
            // InternalMealymachineDsl.g:507:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getTargetStateStateCrossReference_9_0());
            				
            pushFollow(FOLLOW_13);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getTransitionAccess().getRightCurlyBracketKeyword_10());
            		

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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleEString"
    // InternalMealymachineDsl.g:529:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMealymachineDsl.g:529:47: (iv_ruleEString= ruleEString EOF )
            // InternalMealymachineDsl.g:530:2: iv_ruleEString= ruleEString EOF
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
    // InternalMealymachineDsl.g:536:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMealymachineDsl.g:542:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMealymachineDsl.g:543:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMealymachineDsl.g:543:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMealymachineDsl.g:544:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMealymachineDsl.g:552:3: this_ID_1= RULE_ID
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});

}