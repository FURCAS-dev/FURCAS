package org.eclipse.ocl.tutorial.eclipsecon2011.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStatesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'initial'", "'statemachine'", "'value'", "'{'", "'events'", "';'", "'}'", "'debug'", "'state'", "'compound'", "'machine'", "'=>'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalStatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g"; }



     	private StatesGrammarAccess grammarAccess;
     	
        public InternalStatesParser(TokenStream input, StatesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Module";	
       	}
       	
       	@Override
       	protected StatesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModule"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:67:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:68:2: (iv_ruleModule= ruleModule EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:69:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); 

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:76:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) ) ( (lv_machines_2_0= ruleStatemachine ) )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        EObject lv_machines_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:79:28: ( (otherlv_0= 'module' ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) ) ( (lv_machines_2_0= ruleStatemachine ) )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:80:1: (otherlv_0= 'module' ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) ) ( (lv_machines_2_0= ruleStatemachine ) )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:80:1: (otherlv_0= 'module' ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) ) ( (lv_machines_2_0= ruleStatemachine ) )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:80:3: otherlv_0= 'module' ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) ) ( (lv_machines_2_0= ruleStatemachine ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleModule122); 

                	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:84:1: ( ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:85:1: ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:85:1: ( (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:86:1: (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:86:1: (lv_name_1_1= RULE_STRING | lv_name_1_2= RULE_ID )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:87:3: lv_name_1_1= RULE_STRING
                    {
                    lv_name_1_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModule141); 

                    			newLeafNode(lv_name_1_1, grammarAccess.getModuleAccess().getNameSTRINGTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_1, 
                            		"STRING");
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:102:8: lv_name_1_2= RULE_ID
                    {
                    lv_name_1_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModule161); 

                    			newLeafNode(lv_name_1_2, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_2, 
                            		"ID");
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:120:2: ( (lv_machines_2_0= ruleStatemachine ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:121:1: (lv_machines_2_0= ruleStatemachine )
            	    {
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:121:1: (lv_machines_2_0= ruleStatemachine )
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:122:3: lv_machines_2_0= ruleStatemachine
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getMachinesStatemachineParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatemachine_in_ruleModule190);
            	    lv_machines_2_0=ruleStatemachine();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"machines",
            	            		lv_machines_2_0, 
            	            		"Statemachine");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleStatemachine"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:146:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:147:2: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:148:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine227);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine237); 

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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:155:1: ruleStatemachine returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' otherlv_6= 'events' ( (lv_events_7_0= ruleEvent ) )* otherlv_8= ';' ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )? ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        Token lv_initial_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_value_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_dbgName_12_0=null;
        EObject lv_events_7_0 = null;

        EObject lv_states_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:158:28: ( ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' otherlv_6= 'events' ( (lv_events_7_0= ruleEvent ) )* otherlv_8= ';' ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:159:1: ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' otherlv_6= 'events' ( (lv_events_7_0= ruleEvent ) )* otherlv_8= ';' ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:159:1: ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' otherlv_6= 'events' ( (lv_events_7_0= ruleEvent ) )* otherlv_8= ';' ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:159:2: ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'statemachine' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' otherlv_6= 'events' ( (lv_events_7_0= ruleEvent ) )* otherlv_8= ';' ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )?
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:159:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:160:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:160:1: (lv_initial_0_0= 'initial' )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:161:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,12,FOLLOW_12_in_ruleStatemachine280); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getStatemachineAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStatemachineRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleStatemachine306); 

                	newLeafNode(otherlv_1, grammarAccess.getStatemachineAccess().getStatemachineKeyword_1());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:178:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:179:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:179:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:180:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatemachine323); 

            			newLeafNode(lv_name_2_0, grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStatemachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:196:2: (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:196:4: otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleStatemachine341); 

                        	newLeafNode(otherlv_3, grammarAccess.getStatemachineAccess().getValueKeyword_3_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:200:1: ( (lv_value_4_0= RULE_INT ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:201:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:201:1: (lv_value_4_0= RULE_INT )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:202:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleStatemachine358); 

                    			newLeafNode(lv_value_4_0, grammarAccess.getStatemachineAccess().getValueINTTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStatemachineRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleStatemachine377); 

                	newLeafNode(otherlv_5, grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_4());
                
            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleStatemachine389); 

                	newLeafNode(otherlv_6, grammarAccess.getStatemachineAccess().getEventsKeyword_5());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:226:1: ( (lv_events_7_0= ruleEvent ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:227:1: (lv_events_7_0= ruleEvent )
            	    {
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:227:1: (lv_events_7_0= ruleEvent )
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:228:3: lv_events_7_0= ruleEvent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine410);
            	    lv_events_7_0=ruleEvent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"events",
            	            		lv_events_7_0, 
            	            		"Event");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleStatemachine423); 

                	newLeafNode(otherlv_8, grammarAccess.getStatemachineAccess().getSemicolonKeyword_7());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:248:1: ( (lv_states_9_0= ruleState ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==12||(LA6_0>=20 && LA6_0<=21)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:249:1: (lv_states_9_0= ruleState )
            	    {
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:249:1: (lv_states_9_0= ruleState )
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:250:3: lv_states_9_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine444);
            	    lv_states_9_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_9_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleStatemachine457); 

                	newLeafNode(otherlv_10, grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_9());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:270:1: (otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:270:3: otherlv_11= 'debug' ( (lv_dbgName_12_0= RULE_ID ) )
                    {
                    otherlv_11=(Token)match(input,19,FOLLOW_19_in_ruleStatemachine470); 

                        	newLeafNode(otherlv_11, grammarAccess.getStatemachineAccess().getDebugKeyword_10_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:274:1: ( (lv_dbgName_12_0= RULE_ID ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:275:1: (lv_dbgName_12_0= RULE_ID )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:275:1: (lv_dbgName_12_0= RULE_ID )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:276:3: lv_dbgName_12_0= RULE_ID
                    {
                    lv_dbgName_12_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStatemachine487); 

                    			newLeafNode(lv_dbgName_12_0, grammarAccess.getStatemachineAccess().getDbgNameIDTerminalRuleCall_10_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getStatemachineRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"dbgName",
                            		lv_dbgName_12_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:300:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:301:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:302:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent530);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent540); 

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:309:1: ruleEvent returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:312:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:313:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:313:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:314:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:314:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:315:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent581); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:339:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:340:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:341:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState621);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState631); 

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
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:348:1: ruleState returns [EObject current=null] : (this_SimpleState_0= ruleSimpleState | this_CompoundState_1= ruleCompoundState ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleState_0 = null;

        EObject this_CompoundState_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:351:28: ( (this_SimpleState_0= ruleSimpleState | this_CompoundState_1= ruleCompoundState ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:352:1: (this_SimpleState_0= ruleSimpleState | this_CompoundState_1= ruleCompoundState )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:352:1: (this_SimpleState_0= ruleSimpleState | this_CompoundState_1= ruleCompoundState )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==12||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:353:5: this_SimpleState_0= ruleSimpleState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleState_in_ruleState678);
                    this_SimpleState_0=ruleSimpleState();

                    state._fsp--;

                     
                            current = this_SimpleState_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:363:5: this_CompoundState_1= ruleCompoundState
                    {
                     
                            newCompositeNode(grammarAccess.getStateAccess().getCompoundStateParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCompoundState_in_ruleState705);
                    this_CompoundState_1=ruleCompoundState();

                    state._fsp--;

                     
                            current = this_CompoundState_1; 
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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleSimpleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:379:1: entryRuleSimpleState returns [EObject current=null] : iv_ruleSimpleState= ruleSimpleState EOF ;
    public final EObject entryRuleSimpleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleState = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:380:2: (iv_ruleSimpleState= ruleSimpleState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:381:2: iv_ruleSimpleState= ruleSimpleState EOF
            {
             newCompositeNode(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_ruleSimpleState_in_entryRuleSimpleState740);
            iv_ruleSimpleState=ruleSimpleState();

            state._fsp--;

             current =iv_ruleSimpleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleState750); 

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
    // $ANTLR end "entryRuleSimpleState"


    // $ANTLR start "ruleSimpleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:388:1: ruleSimpleState returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= '}' (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )? ) ;
    public final EObject ruleSimpleState() throws RecognitionException {
        EObject current = null;

        Token lv_initial_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_value_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_dbgName_9_0=null;
        EObject lv_transitions_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:391:28: ( ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= '}' (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:392:1: ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= '}' (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:392:1: ( ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= '}' (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:392:2: ( (lv_initial_0_0= 'initial' ) )? otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )? otherlv_5= '{' ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= '}' (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )?
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:392:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==12) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:393:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:393:1: (lv_initial_0_0= 'initial' )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:394:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,12,FOLLOW_12_in_ruleSimpleState793); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getSimpleStateAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleStateRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSimpleState819); 

                	newLeafNode(otherlv_1, grammarAccess.getSimpleStateAccess().getStateKeyword_1());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:411:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:412:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:412:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:413:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleState836); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSimpleStateAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:429:2: (otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:429:4: otherlv_3= 'value' ( (lv_value_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleSimpleState854); 

                        	newLeafNode(otherlv_3, grammarAccess.getSimpleStateAccess().getValueKeyword_3_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:433:1: ( (lv_value_4_0= RULE_INT ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:434:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:434:1: (lv_value_4_0= RULE_INT )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:435:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSimpleState871); 

                    			newLeafNode(lv_value_4_0, grammarAccess.getSimpleStateAccess().getValueINTTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleSimpleState890); 

                	newLeafNode(otherlv_5, grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:455:1: ( (lv_transitions_6_0= ruleTransition ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:456:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:456:1: (lv_transitions_6_0= ruleTransition )
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:457:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSimpleStateAccess().getTransitionsTransitionParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleSimpleState911);
            	    lv_transitions_6_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSimpleStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_6_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_7=(Token)match(input,18,FOLLOW_18_in_ruleSimpleState924); 

                	newLeafNode(otherlv_7, grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_6());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:477:1: (otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:477:3: otherlv_8= 'debug' ( (lv_dbgName_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleSimpleState937); 

                        	newLeafNode(otherlv_8, grammarAccess.getSimpleStateAccess().getDebugKeyword_7_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:481:1: ( (lv_dbgName_9_0= RULE_ID ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:482:1: (lv_dbgName_9_0= RULE_ID )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:482:1: (lv_dbgName_9_0= RULE_ID )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:483:3: lv_dbgName_9_0= RULE_ID
                    {
                    lv_dbgName_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleState954); 

                    			newLeafNode(lv_dbgName_9_0, grammarAccess.getSimpleStateAccess().getDbgNameIDTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"dbgName",
                            		lv_dbgName_9_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleSimpleState"


    // $ANTLR start "entryRuleCompoundState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:507:1: entryRuleCompoundState returns [EObject current=null] : iv_ruleCompoundState= ruleCompoundState EOF ;
    public final EObject entryRuleCompoundState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundState = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:508:2: (iv_ruleCompoundState= ruleCompoundState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:509:2: iv_ruleCompoundState= ruleCompoundState EOF
            {
             newCompositeNode(grammarAccess.getCompoundStateRule()); 
            pushFollow(FOLLOW_ruleCompoundState_in_entryRuleCompoundState997);
            iv_ruleCompoundState=ruleCompoundState();

            state._fsp--;

             current =iv_ruleCompoundState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundState1007); 

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
    // $ANTLR end "entryRuleCompoundState"


    // $ANTLR start "ruleCompoundState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:516:1: ruleCompoundState returns [EObject current=null] : (otherlv_0= 'compound' ( (lv_initial_1_0= 'initial' ) )? otherlv_2= 'state' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'machine' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (lv_transitions_7_0= ruleTransition ) )* otherlv_8= '}' (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )? ) ;
    public final EObject ruleCompoundState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_initial_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_dbgName_10_0=null;
        EObject lv_transitions_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:519:28: ( (otherlv_0= 'compound' ( (lv_initial_1_0= 'initial' ) )? otherlv_2= 'state' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'machine' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (lv_transitions_7_0= ruleTransition ) )* otherlv_8= '}' (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:520:1: (otherlv_0= 'compound' ( (lv_initial_1_0= 'initial' ) )? otherlv_2= 'state' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'machine' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (lv_transitions_7_0= ruleTransition ) )* otherlv_8= '}' (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:520:1: (otherlv_0= 'compound' ( (lv_initial_1_0= 'initial' ) )? otherlv_2= 'state' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'machine' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (lv_transitions_7_0= ruleTransition ) )* otherlv_8= '}' (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:520:3: otherlv_0= 'compound' ( (lv_initial_1_0= 'initial' ) )? otherlv_2= 'state' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'machine' ( (otherlv_5= RULE_ID ) ) otherlv_6= '{' ( (lv_transitions_7_0= ruleTransition ) )* otherlv_8= '}' (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleCompoundState1044); 

                	newLeafNode(otherlv_0, grammarAccess.getCompoundStateAccess().getCompoundKeyword_0());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:524:1: ( (lv_initial_1_0= 'initial' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==12) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:525:1: (lv_initial_1_0= 'initial' )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:525:1: (lv_initial_1_0= 'initial' )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:526:3: lv_initial_1_0= 'initial'
                    {
                    lv_initial_1_0=(Token)match(input,12,FOLLOW_12_in_ruleCompoundState1062); 

                            newLeafNode(lv_initial_1_0, grammarAccess.getCompoundStateAccess().getInitialInitialKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompoundStateRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleCompoundState1088); 

                	newLeafNode(otherlv_2, grammarAccess.getCompoundStateAccess().getStateKeyword_2());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:543:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:544:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:544:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:545:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompoundState1105); 

            			newLeafNode(lv_name_3_0, grammarAccess.getCompoundStateAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompoundStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleCompoundState1122); 

                	newLeafNode(otherlv_4, grammarAccess.getCompoundStateAccess().getMachineKeyword_4());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:565:1: ( (otherlv_5= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:566:1: (otherlv_5= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:566:1: (otherlv_5= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:567:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompoundStateRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompoundState1142); 

            		newLeafNode(otherlv_5, grammarAccess.getCompoundStateAccess().getMachineStatemachineCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleCompoundState1154); 

                	newLeafNode(otherlv_6, grammarAccess.getCompoundStateAccess().getLeftCurlyBracketKeyword_6());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:582:1: ( (lv_transitions_7_0= ruleTransition ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:583:1: (lv_transitions_7_0= ruleTransition )
            	    {
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:583:1: (lv_transitions_7_0= ruleTransition )
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:584:3: lv_transitions_7_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundStateAccess().getTransitionsTransitionParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleCompoundState1175);
            	    lv_transitions_7_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_7_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleCompoundState1188); 

                	newLeafNode(otherlv_8, grammarAccess.getCompoundStateAccess().getRightCurlyBracketKeyword_8());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:604:1: (otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==19) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:604:3: otherlv_9= 'debug' ( (lv_dbgName_10_0= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleCompoundState1201); 

                        	newLeafNode(otherlv_9, grammarAccess.getCompoundStateAccess().getDebugKeyword_9_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:608:1: ( (lv_dbgName_10_0= RULE_ID ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:609:1: (lv_dbgName_10_0= RULE_ID )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:609:1: (lv_dbgName_10_0= RULE_ID )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:610:3: lv_dbgName_10_0= RULE_ID
                    {
                    lv_dbgName_10_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompoundState1218); 

                    			newLeafNode(lv_dbgName_10_0, grammarAccess.getCompoundStateAccess().getDbgNameIDTerminalRuleCall_9_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompoundStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"dbgName",
                            		lv_dbgName_10_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleCompoundState"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:634:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:635:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:636:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition1261);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition1271); 

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
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:643:1: ruleTransition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_dbgName_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:646:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:647:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:647:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:647:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )?
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:647:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:648:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:648:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:649:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition1316); 

            		newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleTransition1328); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:664:1: ( (otherlv_2= RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:665:1: (otherlv_2= RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:665:1: (otherlv_2= RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:666:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition1348); 

            		newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            	

            }


            }

            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:677:2: (otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:677:4: otherlv_3= 'debug' ( (lv_dbgName_4_0= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleTransition1361); 

                        	newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getDebugKeyword_3_0());
                        
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:681:1: ( (lv_dbgName_4_0= RULE_ID ) )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:682:1: (lv_dbgName_4_0= RULE_ID )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:682:1: (lv_dbgName_4_0= RULE_ID )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/parser/antlr/internal/InternalStates.g:683:3: lv_dbgName_4_0= RULE_ID
                    {
                    lv_dbgName_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition1378); 

                    			newLeafNode(lv_dbgName_4_0, grammarAccess.getTransitionAccess().getDbgNameIDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"dbgName",
                            		lv_dbgName_4_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleTransition"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModule122 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModule141 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModule161 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleStatemachine_in_ruleModule190 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine280 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatemachine306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatemachine323 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleStatemachine341 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleStatemachine358 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleStatemachine377 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleStatemachine389 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine410 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleStatemachine423 = new BitSet(new long[]{0x0000000000341000L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine444 = new BitSet(new long[]{0x0000000000341000L});
    public static final BitSet FOLLOW_18_in_ruleStatemachine457 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleStatemachine470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStatemachine487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_ruleState678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundState_in_ruleState705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSimpleState793 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSimpleState819 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState836 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleSimpleState854 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSimpleState871 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSimpleState890 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleSimpleState911 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleSimpleState924 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleState937 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleState954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundState_in_entryRuleCompoundState997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundState1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleCompoundState1044 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_12_in_ruleCompoundState1062 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleCompoundState1088 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompoundState1105 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCompoundState1122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompoundState1142 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCompoundState1154 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleCompoundState1175 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleCompoundState1188 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleCompoundState1201 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompoundState1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1316 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTransition1328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1348 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleTransition1361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition1378 = new BitSet(new long[]{0x0000000000000002L});

}