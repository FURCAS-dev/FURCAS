package org.eclipse.ocl.tutorial.eclipsecon2011.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.tutorial.eclipsecon2011.services.StatesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalStatesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'statemachine'", "'{'", "'events'", "';'", "'}'", "'value'", "'debug'", "'state'", "'compound'", "'machine'", "'=>'", "'initial'"
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
    public String getGrammarFileName() { return "../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g"; }


     
     	private StatesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(StatesGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleModule"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:61:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:62:1: ( ruleModule EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:63:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule61);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule68); 

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:70:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:74:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:75:1: ( ( rule__Module__Group__0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:75:1: ( ( rule__Module__Group__0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:76:1: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:77:1: ( rule__Module__Group__0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:77:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule94);
            rule__Module__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleStatemachine"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:89:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:90:1: ( ruleStatemachine EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:91:1: ruleStatemachine EOF
            {
             before(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine121);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getStatemachineRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine128); 

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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:98:1: ruleStatemachine : ( ( rule__Statemachine__Group__0 ) ) ;
    public final void ruleStatemachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:102:2: ( ( ( rule__Statemachine__Group__0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:103:1: ( ( rule__Statemachine__Group__0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:103:1: ( ( rule__Statemachine__Group__0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:104:1: ( rule__Statemachine__Group__0 )
            {
             before(grammarAccess.getStatemachineAccess().getGroup()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:105:1: ( rule__Statemachine__Group__0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:105:2: rule__Statemachine__Group__0
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine154);
            rule__Statemachine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getGroup()); 

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
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:117:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:118:1: ( ruleEvent EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:119:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent181);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent188); 

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:126:1: ruleEvent : ( ( rule__Event__NameAssignment ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:130:2: ( ( ( rule__Event__NameAssignment ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:131:1: ( ( rule__Event__NameAssignment ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:131:1: ( ( rule__Event__NameAssignment ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:132:1: ( rule__Event__NameAssignment )
            {
             before(grammarAccess.getEventAccess().getNameAssignment()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:133:1: ( rule__Event__NameAssignment )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:133:2: rule__Event__NameAssignment
            {
            pushFollow(FOLLOW_rule__Event__NameAssignment_in_ruleEvent214);
            rule__Event__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:145:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:146:1: ( ruleState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:147:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState241);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState248); 

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:154:1: ruleState : ( ( rule__State__Alternatives ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:158:2: ( ( ( rule__State__Alternatives ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:159:1: ( ( rule__State__Alternatives ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:159:1: ( ( rule__State__Alternatives ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:160:1: ( rule__State__Alternatives )
            {
             before(grammarAccess.getStateAccess().getAlternatives()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:161:1: ( rule__State__Alternatives )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:161:2: rule__State__Alternatives
            {
            pushFollow(FOLLOW_rule__State__Alternatives_in_ruleState274);
            rule__State__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getAlternatives()); 

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleSimpleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:173:1: entryRuleSimpleState : ruleSimpleState EOF ;
    public final void entryRuleSimpleState() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:174:1: ( ruleSimpleState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:175:1: ruleSimpleState EOF
            {
             before(grammarAccess.getSimpleStateRule()); 
            pushFollow(FOLLOW_ruleSimpleState_in_entryRuleSimpleState301);
            ruleSimpleState();

            state._fsp--;

             after(grammarAccess.getSimpleStateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleState308); 

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
    // $ANTLR end "entryRuleSimpleState"


    // $ANTLR start "ruleSimpleState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:182:1: ruleSimpleState : ( ( rule__SimpleState__Group__0 ) ) ;
    public final void ruleSimpleState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:186:2: ( ( ( rule__SimpleState__Group__0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:187:1: ( ( rule__SimpleState__Group__0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:187:1: ( ( rule__SimpleState__Group__0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:188:1: ( rule__SimpleState__Group__0 )
            {
             before(grammarAccess.getSimpleStateAccess().getGroup()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:189:1: ( rule__SimpleState__Group__0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:189:2: rule__SimpleState__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__0_in_ruleSimpleState334);
            rule__SimpleState__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleStateAccess().getGroup()); 

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
    // $ANTLR end "ruleSimpleState"


    // $ANTLR start "entryRuleCompoundState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:201:1: entryRuleCompoundState : ruleCompoundState EOF ;
    public final void entryRuleCompoundState() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:202:1: ( ruleCompoundState EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:203:1: ruleCompoundState EOF
            {
             before(grammarAccess.getCompoundStateRule()); 
            pushFollow(FOLLOW_ruleCompoundState_in_entryRuleCompoundState361);
            ruleCompoundState();

            state._fsp--;

             after(grammarAccess.getCompoundStateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundState368); 

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
    // $ANTLR end "entryRuleCompoundState"


    // $ANTLR start "ruleCompoundState"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:210:1: ruleCompoundState : ( ( rule__CompoundState__Group__0 ) ) ;
    public final void ruleCompoundState() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:214:2: ( ( ( rule__CompoundState__Group__0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:215:1: ( ( rule__CompoundState__Group__0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:215:1: ( ( rule__CompoundState__Group__0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:216:1: ( rule__CompoundState__Group__0 )
            {
             before(grammarAccess.getCompoundStateAccess().getGroup()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:217:1: ( rule__CompoundState__Group__0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:217:2: rule__CompoundState__Group__0
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__0_in_ruleCompoundState394);
            rule__CompoundState__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompoundStateAccess().getGroup()); 

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
    // $ANTLR end "ruleCompoundState"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:229:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:230:1: ( ruleTransition EOF )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:231:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition421);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition428); 

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:238:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:242:2: ( ( ( rule__Transition__Group__0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:243:1: ( ( rule__Transition__Group__0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:243:1: ( ( rule__Transition__Group__0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:244:1: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:245:1: ( rule__Transition__Group__0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:245:2: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_rule__Transition__Group__0_in_ruleTransition454);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

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
    // $ANTLR end "ruleTransition"


    // $ANTLR start "rule__Module__NameAlternatives_1_0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:257:1: rule__Module__NameAlternatives_1_0 : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__Module__NameAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:261:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:262:1: ( RULE_STRING )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:262:1: ( RULE_STRING )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:263:1: RULE_STRING
                    {
                     before(grammarAccess.getModuleAccess().getNameSTRINGTerminalRuleCall_1_0_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Module__NameAlternatives_1_0490); 
                     after(grammarAccess.getModuleAccess().getNameSTRINGTerminalRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:268:6: ( RULE_ID )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:268:6: ( RULE_ID )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:269:1: RULE_ID
                    {
                     before(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Module__NameAlternatives_1_0507); 
                     after(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0_1()); 

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
    // $ANTLR end "rule__Module__NameAlternatives_1_0"


    // $ANTLR start "rule__State__Alternatives"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:279:1: rule__State__Alternatives : ( ( ruleSimpleState ) | ( ruleCompoundState ) );
    public final void rule__State__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:283:1: ( ( ruleSimpleState ) | ( ruleCompoundState ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19||LA2_0==23) ) {
                alt2=1;
            }
            else if ( (LA2_0==20) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:284:1: ( ruleSimpleState )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:284:1: ( ruleSimpleState )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:285:1: ruleSimpleState
                    {
                     before(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleState_in_rule__State__Alternatives539);
                    ruleSimpleState();

                    state._fsp--;

                     after(grammarAccess.getStateAccess().getSimpleStateParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:290:6: ( ruleCompoundState )
                    {
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:290:6: ( ruleCompoundState )
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:291:1: ruleCompoundState
                    {
                     before(grammarAccess.getStateAccess().getCompoundStateParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCompoundState_in_rule__State__Alternatives556);
                    ruleCompoundState();

                    state._fsp--;

                     after(grammarAccess.getStateAccess().getCompoundStateParserRuleCall_1()); 

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
    // $ANTLR end "rule__State__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:303:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:307:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:308:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__0586);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__0589);
            rule__Module__Group__1();

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
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:315:1: rule__Module__Group__0__Impl : ( 'module' ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:319:1: ( ( 'module' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:320:1: ( 'module' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:320:1: ( 'module' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:321:1: 'module'
            {
             before(grammarAccess.getModuleAccess().getModuleKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Module__Group__0__Impl617); 
             after(grammarAccess.getModuleAccess().getModuleKeyword_0()); 

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
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:334:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:338:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:339:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__1648);
            rule__Module__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__1651);
            rule__Module__Group__2();

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
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:346:1: rule__Module__Group__1__Impl : ( ( rule__Module__NameAssignment_1 ) ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:350:1: ( ( ( rule__Module__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:351:1: ( ( rule__Module__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:351:1: ( ( rule__Module__NameAssignment_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:352:1: ( rule__Module__NameAssignment_1 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:353:1: ( rule__Module__NameAssignment_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:353:2: rule__Module__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_1_in_rule__Module__Group__1__Impl678);
            rule__Module__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAssignment_1()); 

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
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:363:1: rule__Module__Group__2 : rule__Module__Group__2__Impl ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:367:1: ( rule__Module__Group__2__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:368:2: rule__Module__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__2708);
            rule__Module__Group__2__Impl();

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
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:374:1: rule__Module__Group__2__Impl : ( ( rule__Module__MachinesAssignment_2 )* ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:378:1: ( ( ( rule__Module__MachinesAssignment_2 )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:379:1: ( ( rule__Module__MachinesAssignment_2 )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:379:1: ( ( rule__Module__MachinesAssignment_2 )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:380:1: ( rule__Module__MachinesAssignment_2 )*
            {
             before(grammarAccess.getModuleAccess().getMachinesAssignment_2()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:381:1: ( rule__Module__MachinesAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12||LA3_0==23) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:381:2: rule__Module__MachinesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Module__MachinesAssignment_2_in_rule__Module__Group__2__Impl735);
            	    rule__Module__MachinesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getMachinesAssignment_2()); 

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
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Statemachine__Group__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:397:1: rule__Statemachine__Group__0 : rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 ;
    public final void rule__Statemachine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:401:1: ( rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:402:2: rule__Statemachine__Group__0__Impl rule__Statemachine__Group__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0772);
            rule__Statemachine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0775);
            rule__Statemachine__Group__1();

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
    // $ANTLR end "rule__Statemachine__Group__0"


    // $ANTLR start "rule__Statemachine__Group__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:409:1: rule__Statemachine__Group__0__Impl : ( ( rule__Statemachine__InitialAssignment_0 )? ) ;
    public final void rule__Statemachine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:413:1: ( ( ( rule__Statemachine__InitialAssignment_0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:414:1: ( ( rule__Statemachine__InitialAssignment_0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:414:1: ( ( rule__Statemachine__InitialAssignment_0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:415:1: ( rule__Statemachine__InitialAssignment_0 )?
            {
             before(grammarAccess.getStatemachineAccess().getInitialAssignment_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:416:1: ( rule__Statemachine__InitialAssignment_0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:416:2: rule__Statemachine__InitialAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__InitialAssignment_0_in_rule__Statemachine__Group__0__Impl802);
                    rule__Statemachine__InitialAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getInitialAssignment_0()); 

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
    // $ANTLR end "rule__Statemachine__Group__0__Impl"


    // $ANTLR start "rule__Statemachine__Group__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:426:1: rule__Statemachine__Group__1 : rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 ;
    public final void rule__Statemachine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:430:1: ( rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:431:2: rule__Statemachine__Group__1__Impl rule__Statemachine__Group__2
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1833);
            rule__Statemachine__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1836);
            rule__Statemachine__Group__2();

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
    // $ANTLR end "rule__Statemachine__Group__1"


    // $ANTLR start "rule__Statemachine__Group__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:438:1: rule__Statemachine__Group__1__Impl : ( 'statemachine' ) ;
    public final void rule__Statemachine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:442:1: ( ( 'statemachine' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:443:1: ( 'statemachine' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:443:1: ( 'statemachine' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:444:1: 'statemachine'
            {
             before(grammarAccess.getStatemachineAccess().getStatemachineKeyword_1()); 
            match(input,12,FOLLOW_12_in_rule__Statemachine__Group__1__Impl864); 
             after(grammarAccess.getStatemachineAccess().getStatemachineKeyword_1()); 

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
    // $ANTLR end "rule__Statemachine__Group__1__Impl"


    // $ANTLR start "rule__Statemachine__Group__2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:457:1: rule__Statemachine__Group__2 : rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 ;
    public final void rule__Statemachine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:461:1: ( rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:462:2: rule__Statemachine__Group__2__Impl rule__Statemachine__Group__3
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2895);
            rule__Statemachine__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2898);
            rule__Statemachine__Group__3();

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
    // $ANTLR end "rule__Statemachine__Group__2"


    // $ANTLR start "rule__Statemachine__Group__2__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:469:1: rule__Statemachine__Group__2__Impl : ( ( rule__Statemachine__NameAssignment_2 ) ) ;
    public final void rule__Statemachine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:473:1: ( ( ( rule__Statemachine__NameAssignment_2 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:474:1: ( ( rule__Statemachine__NameAssignment_2 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:474:1: ( ( rule__Statemachine__NameAssignment_2 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:475:1: ( rule__Statemachine__NameAssignment_2 )
            {
             before(grammarAccess.getStatemachineAccess().getNameAssignment_2()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:476:1: ( rule__Statemachine__NameAssignment_2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:476:2: rule__Statemachine__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Statemachine__NameAssignment_2_in_rule__Statemachine__Group__2__Impl925);
            rule__Statemachine__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Statemachine__Group__2__Impl"


    // $ANTLR start "rule__Statemachine__Group__3"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:486:1: rule__Statemachine__Group__3 : rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 ;
    public final void rule__Statemachine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:490:1: ( rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:491:2: rule__Statemachine__Group__3__Impl rule__Statemachine__Group__4
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3955);
            rule__Statemachine__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3958);
            rule__Statemachine__Group__4();

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
    // $ANTLR end "rule__Statemachine__Group__3"


    // $ANTLR start "rule__Statemachine__Group__3__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:498:1: rule__Statemachine__Group__3__Impl : ( ( rule__Statemachine__Group_3__0 )? ) ;
    public final void rule__Statemachine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:502:1: ( ( ( rule__Statemachine__Group_3__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:503:1: ( ( rule__Statemachine__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:503:1: ( ( rule__Statemachine__Group_3__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:504:1: ( rule__Statemachine__Group_3__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_3()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:505:1: ( rule__Statemachine__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:505:2: rule__Statemachine__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__Group_3__0_in_rule__Statemachine__Group__3__Impl985);
                    rule__Statemachine__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Statemachine__Group__3__Impl"


    // $ANTLR start "rule__Statemachine__Group__4"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:515:1: rule__Statemachine__Group__4 : rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 ;
    public final void rule__Statemachine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:519:1: ( rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:520:2: rule__Statemachine__Group__4__Impl rule__Statemachine__Group__5
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__41016);
            rule__Statemachine__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__41019);
            rule__Statemachine__Group__5();

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
    // $ANTLR end "rule__Statemachine__Group__4"


    // $ANTLR start "rule__Statemachine__Group__4__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:527:1: rule__Statemachine__Group__4__Impl : ( '{' ) ;
    public final void rule__Statemachine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:531:1: ( ( '{' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:532:1: ( '{' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:532:1: ( '{' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:533:1: '{'
            {
             before(grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__Statemachine__Group__4__Impl1047); 
             after(grammarAccess.getStatemachineAccess().getLeftCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Statemachine__Group__4__Impl"


    // $ANTLR start "rule__Statemachine__Group__5"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:546:1: rule__Statemachine__Group__5 : rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 ;
    public final void rule__Statemachine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:550:1: ( rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:551:2: rule__Statemachine__Group__5__Impl rule__Statemachine__Group__6
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__5__Impl_in_rule__Statemachine__Group__51078);
            rule__Statemachine__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__51081);
            rule__Statemachine__Group__6();

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
    // $ANTLR end "rule__Statemachine__Group__5"


    // $ANTLR start "rule__Statemachine__Group__5__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:558:1: rule__Statemachine__Group__5__Impl : ( 'events' ) ;
    public final void rule__Statemachine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:562:1: ( ( 'events' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:563:1: ( 'events' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:563:1: ( 'events' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:564:1: 'events'
            {
             before(grammarAccess.getStatemachineAccess().getEventsKeyword_5()); 
            match(input,14,FOLLOW_14_in_rule__Statemachine__Group__5__Impl1109); 
             after(grammarAccess.getStatemachineAccess().getEventsKeyword_5()); 

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
    // $ANTLR end "rule__Statemachine__Group__5__Impl"


    // $ANTLR start "rule__Statemachine__Group__6"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:577:1: rule__Statemachine__Group__6 : rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 ;
    public final void rule__Statemachine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:581:1: ( rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:582:2: rule__Statemachine__Group__6__Impl rule__Statemachine__Group__7
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__61140);
            rule__Statemachine__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__7_in_rule__Statemachine__Group__61143);
            rule__Statemachine__Group__7();

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
    // $ANTLR end "rule__Statemachine__Group__6"


    // $ANTLR start "rule__Statemachine__Group__6__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:589:1: rule__Statemachine__Group__6__Impl : ( ( rule__Statemachine__EventsAssignment_6 )* ) ;
    public final void rule__Statemachine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:593:1: ( ( ( rule__Statemachine__EventsAssignment_6 )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:594:1: ( ( rule__Statemachine__EventsAssignment_6 )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:594:1: ( ( rule__Statemachine__EventsAssignment_6 )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:595:1: ( rule__Statemachine__EventsAssignment_6 )*
            {
             before(grammarAccess.getStatemachineAccess().getEventsAssignment_6()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:596:1: ( rule__Statemachine__EventsAssignment_6 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:596:2: rule__Statemachine__EventsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__EventsAssignment_6_in_rule__Statemachine__Group__6__Impl1170);
            	    rule__Statemachine__EventsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getEventsAssignment_6()); 

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
    // $ANTLR end "rule__Statemachine__Group__6__Impl"


    // $ANTLR start "rule__Statemachine__Group__7"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:606:1: rule__Statemachine__Group__7 : rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8 ;
    public final void rule__Statemachine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:610:1: ( rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:611:2: rule__Statemachine__Group__7__Impl rule__Statemachine__Group__8
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__7__Impl_in_rule__Statemachine__Group__71201);
            rule__Statemachine__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__8_in_rule__Statemachine__Group__71204);
            rule__Statemachine__Group__8();

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
    // $ANTLR end "rule__Statemachine__Group__7"


    // $ANTLR start "rule__Statemachine__Group__7__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:618:1: rule__Statemachine__Group__7__Impl : ( ';' ) ;
    public final void rule__Statemachine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:622:1: ( ( ';' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:623:1: ( ';' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:623:1: ( ';' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:624:1: ';'
            {
             before(grammarAccess.getStatemachineAccess().getSemicolonKeyword_7()); 
            match(input,15,FOLLOW_15_in_rule__Statemachine__Group__7__Impl1232); 
             after(grammarAccess.getStatemachineAccess().getSemicolonKeyword_7()); 

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
    // $ANTLR end "rule__Statemachine__Group__7__Impl"


    // $ANTLR start "rule__Statemachine__Group__8"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:637:1: rule__Statemachine__Group__8 : rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9 ;
    public final void rule__Statemachine__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:641:1: ( rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:642:2: rule__Statemachine__Group__8__Impl rule__Statemachine__Group__9
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__8__Impl_in_rule__Statemachine__Group__81263);
            rule__Statemachine__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__9_in_rule__Statemachine__Group__81266);
            rule__Statemachine__Group__9();

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
    // $ANTLR end "rule__Statemachine__Group__8"


    // $ANTLR start "rule__Statemachine__Group__8__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:649:1: rule__Statemachine__Group__8__Impl : ( ( rule__Statemachine__StatesAssignment_8 )* ) ;
    public final void rule__Statemachine__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:653:1: ( ( ( rule__Statemachine__StatesAssignment_8 )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:654:1: ( ( rule__Statemachine__StatesAssignment_8 )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:654:1: ( ( rule__Statemachine__StatesAssignment_8 )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:655:1: ( rule__Statemachine__StatesAssignment_8 )*
            {
             before(grammarAccess.getStatemachineAccess().getStatesAssignment_8()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:656:1: ( rule__Statemachine__StatesAssignment_8 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)||LA7_0==23) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:656:2: rule__Statemachine__StatesAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__Statemachine__StatesAssignment_8_in_rule__Statemachine__Group__8__Impl1293);
            	    rule__Statemachine__StatesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getStatemachineAccess().getStatesAssignment_8()); 

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
    // $ANTLR end "rule__Statemachine__Group__8__Impl"


    // $ANTLR start "rule__Statemachine__Group__9"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:666:1: rule__Statemachine__Group__9 : rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10 ;
    public final void rule__Statemachine__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:670:1: ( rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:671:2: rule__Statemachine__Group__9__Impl rule__Statemachine__Group__10
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__9__Impl_in_rule__Statemachine__Group__91324);
            rule__Statemachine__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group__10_in_rule__Statemachine__Group__91327);
            rule__Statemachine__Group__10();

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
    // $ANTLR end "rule__Statemachine__Group__9"


    // $ANTLR start "rule__Statemachine__Group__9__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:678:1: rule__Statemachine__Group__9__Impl : ( '}' ) ;
    public final void rule__Statemachine__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:682:1: ( ( '}' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:683:1: ( '}' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:683:1: ( '}' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:684:1: '}'
            {
             before(grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_9()); 
            match(input,16,FOLLOW_16_in_rule__Statemachine__Group__9__Impl1355); 
             after(grammarAccess.getStatemachineAccess().getRightCurlyBracketKeyword_9()); 

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
    // $ANTLR end "rule__Statemachine__Group__9__Impl"


    // $ANTLR start "rule__Statemachine__Group__10"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:697:1: rule__Statemachine__Group__10 : rule__Statemachine__Group__10__Impl ;
    public final void rule__Statemachine__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:701:1: ( rule__Statemachine__Group__10__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:702:2: rule__Statemachine__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group__10__Impl_in_rule__Statemachine__Group__101386);
            rule__Statemachine__Group__10__Impl();

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
    // $ANTLR end "rule__Statemachine__Group__10"


    // $ANTLR start "rule__Statemachine__Group__10__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:708:1: rule__Statemachine__Group__10__Impl : ( ( rule__Statemachine__Group_10__0 )? ) ;
    public final void rule__Statemachine__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:712:1: ( ( ( rule__Statemachine__Group_10__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:713:1: ( ( rule__Statemachine__Group_10__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:713:1: ( ( rule__Statemachine__Group_10__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:714:1: ( rule__Statemachine__Group_10__0 )?
            {
             before(grammarAccess.getStatemachineAccess().getGroup_10()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:715:1: ( rule__Statemachine__Group_10__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:715:2: rule__Statemachine__Group_10__0
                    {
                    pushFollow(FOLLOW_rule__Statemachine__Group_10__0_in_rule__Statemachine__Group__10__Impl1413);
                    rule__Statemachine__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStatemachineAccess().getGroup_10()); 

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
    // $ANTLR end "rule__Statemachine__Group__10__Impl"


    // $ANTLR start "rule__Statemachine__Group_3__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:747:1: rule__Statemachine__Group_3__0 : rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1 ;
    public final void rule__Statemachine__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:751:1: ( rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:752:2: rule__Statemachine__Group_3__0__Impl rule__Statemachine__Group_3__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_3__0__Impl_in_rule__Statemachine__Group_3__01466);
            rule__Statemachine__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_3__1_in_rule__Statemachine__Group_3__01469);
            rule__Statemachine__Group_3__1();

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
    // $ANTLR end "rule__Statemachine__Group_3__0"


    // $ANTLR start "rule__Statemachine__Group_3__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:759:1: rule__Statemachine__Group_3__0__Impl : ( 'value' ) ;
    public final void rule__Statemachine__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:763:1: ( ( 'value' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:764:1: ( 'value' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:764:1: ( 'value' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:765:1: 'value'
            {
             before(grammarAccess.getStatemachineAccess().getValueKeyword_3_0()); 
            match(input,17,FOLLOW_17_in_rule__Statemachine__Group_3__0__Impl1497); 
             after(grammarAccess.getStatemachineAccess().getValueKeyword_3_0()); 

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
    // $ANTLR end "rule__Statemachine__Group_3__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_3__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:778:1: rule__Statemachine__Group_3__1 : rule__Statemachine__Group_3__1__Impl ;
    public final void rule__Statemachine__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:782:1: ( rule__Statemachine__Group_3__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:783:2: rule__Statemachine__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_3__1__Impl_in_rule__Statemachine__Group_3__11528);
            rule__Statemachine__Group_3__1__Impl();

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
    // $ANTLR end "rule__Statemachine__Group_3__1"


    // $ANTLR start "rule__Statemachine__Group_3__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:789:1: rule__Statemachine__Group_3__1__Impl : ( ( rule__Statemachine__ValueAssignment_3_1 ) ) ;
    public final void rule__Statemachine__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:793:1: ( ( ( rule__Statemachine__ValueAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:794:1: ( ( rule__Statemachine__ValueAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:794:1: ( ( rule__Statemachine__ValueAssignment_3_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:795:1: ( rule__Statemachine__ValueAssignment_3_1 )
            {
             before(grammarAccess.getStatemachineAccess().getValueAssignment_3_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:796:1: ( rule__Statemachine__ValueAssignment_3_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:796:2: rule__Statemachine__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Statemachine__ValueAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1555);
            rule__Statemachine__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getValueAssignment_3_1()); 

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
    // $ANTLR end "rule__Statemachine__Group_3__1__Impl"


    // $ANTLR start "rule__Statemachine__Group_10__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:810:1: rule__Statemachine__Group_10__0 : rule__Statemachine__Group_10__0__Impl rule__Statemachine__Group_10__1 ;
    public final void rule__Statemachine__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:814:1: ( rule__Statemachine__Group_10__0__Impl rule__Statemachine__Group_10__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:815:2: rule__Statemachine__Group_10__0__Impl rule__Statemachine__Group_10__1
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_10__0__Impl_in_rule__Statemachine__Group_10__01589);
            rule__Statemachine__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statemachine__Group_10__1_in_rule__Statemachine__Group_10__01592);
            rule__Statemachine__Group_10__1();

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
    // $ANTLR end "rule__Statemachine__Group_10__0"


    // $ANTLR start "rule__Statemachine__Group_10__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:822:1: rule__Statemachine__Group_10__0__Impl : ( 'debug' ) ;
    public final void rule__Statemachine__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:826:1: ( ( 'debug' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:827:1: ( 'debug' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:827:1: ( 'debug' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:828:1: 'debug'
            {
             before(grammarAccess.getStatemachineAccess().getDebugKeyword_10_0()); 
            match(input,18,FOLLOW_18_in_rule__Statemachine__Group_10__0__Impl1620); 
             after(grammarAccess.getStatemachineAccess().getDebugKeyword_10_0()); 

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
    // $ANTLR end "rule__Statemachine__Group_10__0__Impl"


    // $ANTLR start "rule__Statemachine__Group_10__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:841:1: rule__Statemachine__Group_10__1 : rule__Statemachine__Group_10__1__Impl ;
    public final void rule__Statemachine__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:845:1: ( rule__Statemachine__Group_10__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:846:2: rule__Statemachine__Group_10__1__Impl
            {
            pushFollow(FOLLOW_rule__Statemachine__Group_10__1__Impl_in_rule__Statemachine__Group_10__11651);
            rule__Statemachine__Group_10__1__Impl();

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
    // $ANTLR end "rule__Statemachine__Group_10__1"


    // $ANTLR start "rule__Statemachine__Group_10__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:852:1: rule__Statemachine__Group_10__1__Impl : ( ( rule__Statemachine__DbgNameAssignment_10_1 ) ) ;
    public final void rule__Statemachine__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:856:1: ( ( ( rule__Statemachine__DbgNameAssignment_10_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:857:1: ( ( rule__Statemachine__DbgNameAssignment_10_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:857:1: ( ( rule__Statemachine__DbgNameAssignment_10_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:858:1: ( rule__Statemachine__DbgNameAssignment_10_1 )
            {
             before(grammarAccess.getStatemachineAccess().getDbgNameAssignment_10_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:859:1: ( rule__Statemachine__DbgNameAssignment_10_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:859:2: rule__Statemachine__DbgNameAssignment_10_1
            {
            pushFollow(FOLLOW_rule__Statemachine__DbgNameAssignment_10_1_in_rule__Statemachine__Group_10__1__Impl1678);
            rule__Statemachine__DbgNameAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getStatemachineAccess().getDbgNameAssignment_10_1()); 

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
    // $ANTLR end "rule__Statemachine__Group_10__1__Impl"


    // $ANTLR start "rule__SimpleState__Group__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:873:1: rule__SimpleState__Group__0 : rule__SimpleState__Group__0__Impl rule__SimpleState__Group__1 ;
    public final void rule__SimpleState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:877:1: ( rule__SimpleState__Group__0__Impl rule__SimpleState__Group__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:878:2: rule__SimpleState__Group__0__Impl rule__SimpleState__Group__1
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__0__Impl_in_rule__SimpleState__Group__01712);
            rule__SimpleState__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__1_in_rule__SimpleState__Group__01715);
            rule__SimpleState__Group__1();

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
    // $ANTLR end "rule__SimpleState__Group__0"


    // $ANTLR start "rule__SimpleState__Group__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:885:1: rule__SimpleState__Group__0__Impl : ( ( rule__SimpleState__InitialAssignment_0 )? ) ;
    public final void rule__SimpleState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:889:1: ( ( ( rule__SimpleState__InitialAssignment_0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:890:1: ( ( rule__SimpleState__InitialAssignment_0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:890:1: ( ( rule__SimpleState__InitialAssignment_0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:891:1: ( rule__SimpleState__InitialAssignment_0 )?
            {
             before(grammarAccess.getSimpleStateAccess().getInitialAssignment_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:892:1: ( rule__SimpleState__InitialAssignment_0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:892:2: rule__SimpleState__InitialAssignment_0
                    {
                    pushFollow(FOLLOW_rule__SimpleState__InitialAssignment_0_in_rule__SimpleState__Group__0__Impl1742);
                    rule__SimpleState__InitialAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleStateAccess().getInitialAssignment_0()); 

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
    // $ANTLR end "rule__SimpleState__Group__0__Impl"


    // $ANTLR start "rule__SimpleState__Group__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:902:1: rule__SimpleState__Group__1 : rule__SimpleState__Group__1__Impl rule__SimpleState__Group__2 ;
    public final void rule__SimpleState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:906:1: ( rule__SimpleState__Group__1__Impl rule__SimpleState__Group__2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:907:2: rule__SimpleState__Group__1__Impl rule__SimpleState__Group__2
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__1__Impl_in_rule__SimpleState__Group__11773);
            rule__SimpleState__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__2_in_rule__SimpleState__Group__11776);
            rule__SimpleState__Group__2();

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
    // $ANTLR end "rule__SimpleState__Group__1"


    // $ANTLR start "rule__SimpleState__Group__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:914:1: rule__SimpleState__Group__1__Impl : ( 'state' ) ;
    public final void rule__SimpleState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:918:1: ( ( 'state' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:919:1: ( 'state' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:919:1: ( 'state' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:920:1: 'state'
            {
             before(grammarAccess.getSimpleStateAccess().getStateKeyword_1()); 
            match(input,19,FOLLOW_19_in_rule__SimpleState__Group__1__Impl1804); 
             after(grammarAccess.getSimpleStateAccess().getStateKeyword_1()); 

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
    // $ANTLR end "rule__SimpleState__Group__1__Impl"


    // $ANTLR start "rule__SimpleState__Group__2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:933:1: rule__SimpleState__Group__2 : rule__SimpleState__Group__2__Impl rule__SimpleState__Group__3 ;
    public final void rule__SimpleState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:937:1: ( rule__SimpleState__Group__2__Impl rule__SimpleState__Group__3 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:938:2: rule__SimpleState__Group__2__Impl rule__SimpleState__Group__3
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__2__Impl_in_rule__SimpleState__Group__21835);
            rule__SimpleState__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__3_in_rule__SimpleState__Group__21838);
            rule__SimpleState__Group__3();

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
    // $ANTLR end "rule__SimpleState__Group__2"


    // $ANTLR start "rule__SimpleState__Group__2__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:945:1: rule__SimpleState__Group__2__Impl : ( ( rule__SimpleState__NameAssignment_2 ) ) ;
    public final void rule__SimpleState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:949:1: ( ( ( rule__SimpleState__NameAssignment_2 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:950:1: ( ( rule__SimpleState__NameAssignment_2 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:950:1: ( ( rule__SimpleState__NameAssignment_2 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:951:1: ( rule__SimpleState__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleStateAccess().getNameAssignment_2()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:952:1: ( rule__SimpleState__NameAssignment_2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:952:2: rule__SimpleState__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__SimpleState__NameAssignment_2_in_rule__SimpleState__Group__2__Impl1865);
            rule__SimpleState__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleStateAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__SimpleState__Group__2__Impl"


    // $ANTLR start "rule__SimpleState__Group__3"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:962:1: rule__SimpleState__Group__3 : rule__SimpleState__Group__3__Impl rule__SimpleState__Group__4 ;
    public final void rule__SimpleState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:966:1: ( rule__SimpleState__Group__3__Impl rule__SimpleState__Group__4 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:967:2: rule__SimpleState__Group__3__Impl rule__SimpleState__Group__4
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__3__Impl_in_rule__SimpleState__Group__31895);
            rule__SimpleState__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__4_in_rule__SimpleState__Group__31898);
            rule__SimpleState__Group__4();

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
    // $ANTLR end "rule__SimpleState__Group__3"


    // $ANTLR start "rule__SimpleState__Group__3__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:974:1: rule__SimpleState__Group__3__Impl : ( ( rule__SimpleState__Group_3__0 )? ) ;
    public final void rule__SimpleState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:978:1: ( ( ( rule__SimpleState__Group_3__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:979:1: ( ( rule__SimpleState__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:979:1: ( ( rule__SimpleState__Group_3__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:980:1: ( rule__SimpleState__Group_3__0 )?
            {
             before(grammarAccess.getSimpleStateAccess().getGroup_3()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:981:1: ( rule__SimpleState__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:981:2: rule__SimpleState__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SimpleState__Group_3__0_in_rule__SimpleState__Group__3__Impl1925);
                    rule__SimpleState__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleStateAccess().getGroup_3()); 

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
    // $ANTLR end "rule__SimpleState__Group__3__Impl"


    // $ANTLR start "rule__SimpleState__Group__4"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:991:1: rule__SimpleState__Group__4 : rule__SimpleState__Group__4__Impl rule__SimpleState__Group__5 ;
    public final void rule__SimpleState__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:995:1: ( rule__SimpleState__Group__4__Impl rule__SimpleState__Group__5 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:996:2: rule__SimpleState__Group__4__Impl rule__SimpleState__Group__5
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__4__Impl_in_rule__SimpleState__Group__41956);
            rule__SimpleState__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__5_in_rule__SimpleState__Group__41959);
            rule__SimpleState__Group__5();

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
    // $ANTLR end "rule__SimpleState__Group__4"


    // $ANTLR start "rule__SimpleState__Group__4__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1003:1: rule__SimpleState__Group__4__Impl : ( '{' ) ;
    public final void rule__SimpleState__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1007:1: ( ( '{' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1008:1: ( '{' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1008:1: ( '{' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1009:1: '{'
            {
             before(grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,13,FOLLOW_13_in_rule__SimpleState__Group__4__Impl1987); 
             after(grammarAccess.getSimpleStateAccess().getLeftCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__SimpleState__Group__4__Impl"


    // $ANTLR start "rule__SimpleState__Group__5"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1022:1: rule__SimpleState__Group__5 : rule__SimpleState__Group__5__Impl rule__SimpleState__Group__6 ;
    public final void rule__SimpleState__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1026:1: ( rule__SimpleState__Group__5__Impl rule__SimpleState__Group__6 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1027:2: rule__SimpleState__Group__5__Impl rule__SimpleState__Group__6
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__5__Impl_in_rule__SimpleState__Group__52018);
            rule__SimpleState__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__6_in_rule__SimpleState__Group__52021);
            rule__SimpleState__Group__6();

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
    // $ANTLR end "rule__SimpleState__Group__5"


    // $ANTLR start "rule__SimpleState__Group__5__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1034:1: rule__SimpleState__Group__5__Impl : ( ( rule__SimpleState__TransitionsAssignment_5 )* ) ;
    public final void rule__SimpleState__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1038:1: ( ( ( rule__SimpleState__TransitionsAssignment_5 )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1039:1: ( ( rule__SimpleState__TransitionsAssignment_5 )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1039:1: ( ( rule__SimpleState__TransitionsAssignment_5 )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1040:1: ( rule__SimpleState__TransitionsAssignment_5 )*
            {
             before(grammarAccess.getSimpleStateAccess().getTransitionsAssignment_5()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1041:1: ( rule__SimpleState__TransitionsAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1041:2: rule__SimpleState__TransitionsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SimpleState__TransitionsAssignment_5_in_rule__SimpleState__Group__5__Impl2048);
            	    rule__SimpleState__TransitionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getSimpleStateAccess().getTransitionsAssignment_5()); 

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
    // $ANTLR end "rule__SimpleState__Group__5__Impl"


    // $ANTLR start "rule__SimpleState__Group__6"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1051:1: rule__SimpleState__Group__6 : rule__SimpleState__Group__6__Impl rule__SimpleState__Group__7 ;
    public final void rule__SimpleState__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1055:1: ( rule__SimpleState__Group__6__Impl rule__SimpleState__Group__7 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1056:2: rule__SimpleState__Group__6__Impl rule__SimpleState__Group__7
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__6__Impl_in_rule__SimpleState__Group__62079);
            rule__SimpleState__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group__7_in_rule__SimpleState__Group__62082);
            rule__SimpleState__Group__7();

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
    // $ANTLR end "rule__SimpleState__Group__6"


    // $ANTLR start "rule__SimpleState__Group__6__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1063:1: rule__SimpleState__Group__6__Impl : ( '}' ) ;
    public final void rule__SimpleState__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1067:1: ( ( '}' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1068:1: ( '}' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1068:1: ( '}' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1069:1: '}'
            {
             before(grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__SimpleState__Group__6__Impl2110); 
             after(grammarAccess.getSimpleStateAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__SimpleState__Group__6__Impl"


    // $ANTLR start "rule__SimpleState__Group__7"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1082:1: rule__SimpleState__Group__7 : rule__SimpleState__Group__7__Impl ;
    public final void rule__SimpleState__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1086:1: ( rule__SimpleState__Group__7__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1087:2: rule__SimpleState__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SimpleState__Group__7__Impl_in_rule__SimpleState__Group__72141);
            rule__SimpleState__Group__7__Impl();

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
    // $ANTLR end "rule__SimpleState__Group__7"


    // $ANTLR start "rule__SimpleState__Group__7__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1093:1: rule__SimpleState__Group__7__Impl : ( ( rule__SimpleState__Group_7__0 )? ) ;
    public final void rule__SimpleState__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1097:1: ( ( ( rule__SimpleState__Group_7__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1098:1: ( ( rule__SimpleState__Group_7__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1098:1: ( ( rule__SimpleState__Group_7__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1099:1: ( rule__SimpleState__Group_7__0 )?
            {
             before(grammarAccess.getSimpleStateAccess().getGroup_7()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1100:1: ( rule__SimpleState__Group_7__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1100:2: rule__SimpleState__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SimpleState__Group_7__0_in_rule__SimpleState__Group__7__Impl2168);
                    rule__SimpleState__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleStateAccess().getGroup_7()); 

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
    // $ANTLR end "rule__SimpleState__Group__7__Impl"


    // $ANTLR start "rule__SimpleState__Group_3__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1126:1: rule__SimpleState__Group_3__0 : rule__SimpleState__Group_3__0__Impl rule__SimpleState__Group_3__1 ;
    public final void rule__SimpleState__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1130:1: ( rule__SimpleState__Group_3__0__Impl rule__SimpleState__Group_3__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1131:2: rule__SimpleState__Group_3__0__Impl rule__SimpleState__Group_3__1
            {
            pushFollow(FOLLOW_rule__SimpleState__Group_3__0__Impl_in_rule__SimpleState__Group_3__02215);
            rule__SimpleState__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group_3__1_in_rule__SimpleState__Group_3__02218);
            rule__SimpleState__Group_3__1();

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
    // $ANTLR end "rule__SimpleState__Group_3__0"


    // $ANTLR start "rule__SimpleState__Group_3__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1138:1: rule__SimpleState__Group_3__0__Impl : ( 'value' ) ;
    public final void rule__SimpleState__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1142:1: ( ( 'value' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1143:1: ( 'value' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1143:1: ( 'value' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1144:1: 'value'
            {
             before(grammarAccess.getSimpleStateAccess().getValueKeyword_3_0()); 
            match(input,17,FOLLOW_17_in_rule__SimpleState__Group_3__0__Impl2246); 
             after(grammarAccess.getSimpleStateAccess().getValueKeyword_3_0()); 

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
    // $ANTLR end "rule__SimpleState__Group_3__0__Impl"


    // $ANTLR start "rule__SimpleState__Group_3__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1157:1: rule__SimpleState__Group_3__1 : rule__SimpleState__Group_3__1__Impl ;
    public final void rule__SimpleState__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1161:1: ( rule__SimpleState__Group_3__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1162:2: rule__SimpleState__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SimpleState__Group_3__1__Impl_in_rule__SimpleState__Group_3__12277);
            rule__SimpleState__Group_3__1__Impl();

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
    // $ANTLR end "rule__SimpleState__Group_3__1"


    // $ANTLR start "rule__SimpleState__Group_3__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1168:1: rule__SimpleState__Group_3__1__Impl : ( ( rule__SimpleState__ValueAssignment_3_1 ) ) ;
    public final void rule__SimpleState__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1172:1: ( ( ( rule__SimpleState__ValueAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1173:1: ( ( rule__SimpleState__ValueAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1173:1: ( ( rule__SimpleState__ValueAssignment_3_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1174:1: ( rule__SimpleState__ValueAssignment_3_1 )
            {
             before(grammarAccess.getSimpleStateAccess().getValueAssignment_3_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1175:1: ( rule__SimpleState__ValueAssignment_3_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1175:2: rule__SimpleState__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_rule__SimpleState__ValueAssignment_3_1_in_rule__SimpleState__Group_3__1__Impl2304);
            rule__SimpleState__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleStateAccess().getValueAssignment_3_1()); 

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
    // $ANTLR end "rule__SimpleState__Group_3__1__Impl"


    // $ANTLR start "rule__SimpleState__Group_7__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1189:1: rule__SimpleState__Group_7__0 : rule__SimpleState__Group_7__0__Impl rule__SimpleState__Group_7__1 ;
    public final void rule__SimpleState__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1193:1: ( rule__SimpleState__Group_7__0__Impl rule__SimpleState__Group_7__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1194:2: rule__SimpleState__Group_7__0__Impl rule__SimpleState__Group_7__1
            {
            pushFollow(FOLLOW_rule__SimpleState__Group_7__0__Impl_in_rule__SimpleState__Group_7__02338);
            rule__SimpleState__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SimpleState__Group_7__1_in_rule__SimpleState__Group_7__02341);
            rule__SimpleState__Group_7__1();

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
    // $ANTLR end "rule__SimpleState__Group_7__0"


    // $ANTLR start "rule__SimpleState__Group_7__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1201:1: rule__SimpleState__Group_7__0__Impl : ( 'debug' ) ;
    public final void rule__SimpleState__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1205:1: ( ( 'debug' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1206:1: ( 'debug' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1206:1: ( 'debug' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1207:1: 'debug'
            {
             before(grammarAccess.getSimpleStateAccess().getDebugKeyword_7_0()); 
            match(input,18,FOLLOW_18_in_rule__SimpleState__Group_7__0__Impl2369); 
             after(grammarAccess.getSimpleStateAccess().getDebugKeyword_7_0()); 

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
    // $ANTLR end "rule__SimpleState__Group_7__0__Impl"


    // $ANTLR start "rule__SimpleState__Group_7__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1220:1: rule__SimpleState__Group_7__1 : rule__SimpleState__Group_7__1__Impl ;
    public final void rule__SimpleState__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1224:1: ( rule__SimpleState__Group_7__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1225:2: rule__SimpleState__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SimpleState__Group_7__1__Impl_in_rule__SimpleState__Group_7__12400);
            rule__SimpleState__Group_7__1__Impl();

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
    // $ANTLR end "rule__SimpleState__Group_7__1"


    // $ANTLR start "rule__SimpleState__Group_7__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1231:1: rule__SimpleState__Group_7__1__Impl : ( ( rule__SimpleState__DbgNameAssignment_7_1 ) ) ;
    public final void rule__SimpleState__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1235:1: ( ( ( rule__SimpleState__DbgNameAssignment_7_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1236:1: ( ( rule__SimpleState__DbgNameAssignment_7_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1236:1: ( ( rule__SimpleState__DbgNameAssignment_7_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1237:1: ( rule__SimpleState__DbgNameAssignment_7_1 )
            {
             before(grammarAccess.getSimpleStateAccess().getDbgNameAssignment_7_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1238:1: ( rule__SimpleState__DbgNameAssignment_7_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1238:2: rule__SimpleState__DbgNameAssignment_7_1
            {
            pushFollow(FOLLOW_rule__SimpleState__DbgNameAssignment_7_1_in_rule__SimpleState__Group_7__1__Impl2427);
            rule__SimpleState__DbgNameAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleStateAccess().getDbgNameAssignment_7_1()); 

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
    // $ANTLR end "rule__SimpleState__Group_7__1__Impl"


    // $ANTLR start "rule__CompoundState__Group__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1252:1: rule__CompoundState__Group__0 : rule__CompoundState__Group__0__Impl rule__CompoundState__Group__1 ;
    public final void rule__CompoundState__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1256:1: ( rule__CompoundState__Group__0__Impl rule__CompoundState__Group__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1257:2: rule__CompoundState__Group__0__Impl rule__CompoundState__Group__1
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__0__Impl_in_rule__CompoundState__Group__02461);
            rule__CompoundState__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__1_in_rule__CompoundState__Group__02464);
            rule__CompoundState__Group__1();

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
    // $ANTLR end "rule__CompoundState__Group__0"


    // $ANTLR start "rule__CompoundState__Group__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1264:1: rule__CompoundState__Group__0__Impl : ( 'compound' ) ;
    public final void rule__CompoundState__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1268:1: ( ( 'compound' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1269:1: ( 'compound' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1269:1: ( 'compound' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1270:1: 'compound'
            {
             before(grammarAccess.getCompoundStateAccess().getCompoundKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__CompoundState__Group__0__Impl2492); 
             after(grammarAccess.getCompoundStateAccess().getCompoundKeyword_0()); 

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
    // $ANTLR end "rule__CompoundState__Group__0__Impl"


    // $ANTLR start "rule__CompoundState__Group__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1283:1: rule__CompoundState__Group__1 : rule__CompoundState__Group__1__Impl rule__CompoundState__Group__2 ;
    public final void rule__CompoundState__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1287:1: ( rule__CompoundState__Group__1__Impl rule__CompoundState__Group__2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1288:2: rule__CompoundState__Group__1__Impl rule__CompoundState__Group__2
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__1__Impl_in_rule__CompoundState__Group__12523);
            rule__CompoundState__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__2_in_rule__CompoundState__Group__12526);
            rule__CompoundState__Group__2();

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
    // $ANTLR end "rule__CompoundState__Group__1"


    // $ANTLR start "rule__CompoundState__Group__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1295:1: rule__CompoundState__Group__1__Impl : ( ( rule__CompoundState__InitialAssignment_1 )? ) ;
    public final void rule__CompoundState__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1299:1: ( ( ( rule__CompoundState__InitialAssignment_1 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1300:1: ( ( rule__CompoundState__InitialAssignment_1 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1300:1: ( ( rule__CompoundState__InitialAssignment_1 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1301:1: ( rule__CompoundState__InitialAssignment_1 )?
            {
             before(grammarAccess.getCompoundStateAccess().getInitialAssignment_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1302:1: ( rule__CompoundState__InitialAssignment_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1302:2: rule__CompoundState__InitialAssignment_1
                    {
                    pushFollow(FOLLOW_rule__CompoundState__InitialAssignment_1_in_rule__CompoundState__Group__1__Impl2553);
                    rule__CompoundState__InitialAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompoundStateAccess().getInitialAssignment_1()); 

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
    // $ANTLR end "rule__CompoundState__Group__1__Impl"


    // $ANTLR start "rule__CompoundState__Group__2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1312:1: rule__CompoundState__Group__2 : rule__CompoundState__Group__2__Impl rule__CompoundState__Group__3 ;
    public final void rule__CompoundState__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1316:1: ( rule__CompoundState__Group__2__Impl rule__CompoundState__Group__3 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1317:2: rule__CompoundState__Group__2__Impl rule__CompoundState__Group__3
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__2__Impl_in_rule__CompoundState__Group__22584);
            rule__CompoundState__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__3_in_rule__CompoundState__Group__22587);
            rule__CompoundState__Group__3();

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
    // $ANTLR end "rule__CompoundState__Group__2"


    // $ANTLR start "rule__CompoundState__Group__2__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1324:1: rule__CompoundState__Group__2__Impl : ( 'state' ) ;
    public final void rule__CompoundState__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1328:1: ( ( 'state' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1329:1: ( 'state' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1329:1: ( 'state' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1330:1: 'state'
            {
             before(grammarAccess.getCompoundStateAccess().getStateKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__CompoundState__Group__2__Impl2615); 
             after(grammarAccess.getCompoundStateAccess().getStateKeyword_2()); 

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
    // $ANTLR end "rule__CompoundState__Group__2__Impl"


    // $ANTLR start "rule__CompoundState__Group__3"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1343:1: rule__CompoundState__Group__3 : rule__CompoundState__Group__3__Impl rule__CompoundState__Group__4 ;
    public final void rule__CompoundState__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1347:1: ( rule__CompoundState__Group__3__Impl rule__CompoundState__Group__4 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1348:2: rule__CompoundState__Group__3__Impl rule__CompoundState__Group__4
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__3__Impl_in_rule__CompoundState__Group__32646);
            rule__CompoundState__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__4_in_rule__CompoundState__Group__32649);
            rule__CompoundState__Group__4();

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
    // $ANTLR end "rule__CompoundState__Group__3"


    // $ANTLR start "rule__CompoundState__Group__3__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1355:1: rule__CompoundState__Group__3__Impl : ( ( rule__CompoundState__NameAssignment_3 ) ) ;
    public final void rule__CompoundState__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1359:1: ( ( ( rule__CompoundState__NameAssignment_3 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1360:1: ( ( rule__CompoundState__NameAssignment_3 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1360:1: ( ( rule__CompoundState__NameAssignment_3 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1361:1: ( rule__CompoundState__NameAssignment_3 )
            {
             before(grammarAccess.getCompoundStateAccess().getNameAssignment_3()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1362:1: ( rule__CompoundState__NameAssignment_3 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1362:2: rule__CompoundState__NameAssignment_3
            {
            pushFollow(FOLLOW_rule__CompoundState__NameAssignment_3_in_rule__CompoundState__Group__3__Impl2676);
            rule__CompoundState__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompoundStateAccess().getNameAssignment_3()); 

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
    // $ANTLR end "rule__CompoundState__Group__3__Impl"


    // $ANTLR start "rule__CompoundState__Group__4"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1372:1: rule__CompoundState__Group__4 : rule__CompoundState__Group__4__Impl rule__CompoundState__Group__5 ;
    public final void rule__CompoundState__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1376:1: ( rule__CompoundState__Group__4__Impl rule__CompoundState__Group__5 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1377:2: rule__CompoundState__Group__4__Impl rule__CompoundState__Group__5
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__4__Impl_in_rule__CompoundState__Group__42706);
            rule__CompoundState__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__5_in_rule__CompoundState__Group__42709);
            rule__CompoundState__Group__5();

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
    // $ANTLR end "rule__CompoundState__Group__4"


    // $ANTLR start "rule__CompoundState__Group__4__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1384:1: rule__CompoundState__Group__4__Impl : ( 'machine' ) ;
    public final void rule__CompoundState__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1388:1: ( ( 'machine' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1389:1: ( 'machine' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1389:1: ( 'machine' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1390:1: 'machine'
            {
             before(grammarAccess.getCompoundStateAccess().getMachineKeyword_4()); 
            match(input,21,FOLLOW_21_in_rule__CompoundState__Group__4__Impl2737); 
             after(grammarAccess.getCompoundStateAccess().getMachineKeyword_4()); 

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
    // $ANTLR end "rule__CompoundState__Group__4__Impl"


    // $ANTLR start "rule__CompoundState__Group__5"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1403:1: rule__CompoundState__Group__5 : rule__CompoundState__Group__5__Impl rule__CompoundState__Group__6 ;
    public final void rule__CompoundState__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1407:1: ( rule__CompoundState__Group__5__Impl rule__CompoundState__Group__6 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1408:2: rule__CompoundState__Group__5__Impl rule__CompoundState__Group__6
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__5__Impl_in_rule__CompoundState__Group__52768);
            rule__CompoundState__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__6_in_rule__CompoundState__Group__52771);
            rule__CompoundState__Group__6();

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
    // $ANTLR end "rule__CompoundState__Group__5"


    // $ANTLR start "rule__CompoundState__Group__5__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1415:1: rule__CompoundState__Group__5__Impl : ( ( rule__CompoundState__MachineAssignment_5 ) ) ;
    public final void rule__CompoundState__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1419:1: ( ( ( rule__CompoundState__MachineAssignment_5 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1420:1: ( ( rule__CompoundState__MachineAssignment_5 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1420:1: ( ( rule__CompoundState__MachineAssignment_5 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1421:1: ( rule__CompoundState__MachineAssignment_5 )
            {
             before(grammarAccess.getCompoundStateAccess().getMachineAssignment_5()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1422:1: ( rule__CompoundState__MachineAssignment_5 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1422:2: rule__CompoundState__MachineAssignment_5
            {
            pushFollow(FOLLOW_rule__CompoundState__MachineAssignment_5_in_rule__CompoundState__Group__5__Impl2798);
            rule__CompoundState__MachineAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getCompoundStateAccess().getMachineAssignment_5()); 

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
    // $ANTLR end "rule__CompoundState__Group__5__Impl"


    // $ANTLR start "rule__CompoundState__Group__6"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1432:1: rule__CompoundState__Group__6 : rule__CompoundState__Group__6__Impl rule__CompoundState__Group__7 ;
    public final void rule__CompoundState__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1436:1: ( rule__CompoundState__Group__6__Impl rule__CompoundState__Group__7 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1437:2: rule__CompoundState__Group__6__Impl rule__CompoundState__Group__7
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__6__Impl_in_rule__CompoundState__Group__62828);
            rule__CompoundState__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__7_in_rule__CompoundState__Group__62831);
            rule__CompoundState__Group__7();

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
    // $ANTLR end "rule__CompoundState__Group__6"


    // $ANTLR start "rule__CompoundState__Group__6__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1444:1: rule__CompoundState__Group__6__Impl : ( '{' ) ;
    public final void rule__CompoundState__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1448:1: ( ( '{' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1449:1: ( '{' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1449:1: ( '{' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1450:1: '{'
            {
             before(grammarAccess.getCompoundStateAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,13,FOLLOW_13_in_rule__CompoundState__Group__6__Impl2859); 
             after(grammarAccess.getCompoundStateAccess().getLeftCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__CompoundState__Group__6__Impl"


    // $ANTLR start "rule__CompoundState__Group__7"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1463:1: rule__CompoundState__Group__7 : rule__CompoundState__Group__7__Impl rule__CompoundState__Group__8 ;
    public final void rule__CompoundState__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1467:1: ( rule__CompoundState__Group__7__Impl rule__CompoundState__Group__8 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1468:2: rule__CompoundState__Group__7__Impl rule__CompoundState__Group__8
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__7__Impl_in_rule__CompoundState__Group__72890);
            rule__CompoundState__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__8_in_rule__CompoundState__Group__72893);
            rule__CompoundState__Group__8();

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
    // $ANTLR end "rule__CompoundState__Group__7"


    // $ANTLR start "rule__CompoundState__Group__7__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1475:1: rule__CompoundState__Group__7__Impl : ( ( rule__CompoundState__TransitionsAssignment_7 )* ) ;
    public final void rule__CompoundState__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1479:1: ( ( ( rule__CompoundState__TransitionsAssignment_7 )* ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1480:1: ( ( rule__CompoundState__TransitionsAssignment_7 )* )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1480:1: ( ( rule__CompoundState__TransitionsAssignment_7 )* )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1481:1: ( rule__CompoundState__TransitionsAssignment_7 )*
            {
             before(grammarAccess.getCompoundStateAccess().getTransitionsAssignment_7()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1482:1: ( rule__CompoundState__TransitionsAssignment_7 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1482:2: rule__CompoundState__TransitionsAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__CompoundState__TransitionsAssignment_7_in_rule__CompoundState__Group__7__Impl2920);
            	    rule__CompoundState__TransitionsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getCompoundStateAccess().getTransitionsAssignment_7()); 

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
    // $ANTLR end "rule__CompoundState__Group__7__Impl"


    // $ANTLR start "rule__CompoundState__Group__8"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1492:1: rule__CompoundState__Group__8 : rule__CompoundState__Group__8__Impl rule__CompoundState__Group__9 ;
    public final void rule__CompoundState__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1496:1: ( rule__CompoundState__Group__8__Impl rule__CompoundState__Group__9 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1497:2: rule__CompoundState__Group__8__Impl rule__CompoundState__Group__9
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__8__Impl_in_rule__CompoundState__Group__82951);
            rule__CompoundState__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group__9_in_rule__CompoundState__Group__82954);
            rule__CompoundState__Group__9();

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
    // $ANTLR end "rule__CompoundState__Group__8"


    // $ANTLR start "rule__CompoundState__Group__8__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1504:1: rule__CompoundState__Group__8__Impl : ( '}' ) ;
    public final void rule__CompoundState__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1508:1: ( ( '}' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1509:1: ( '}' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1509:1: ( '}' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1510:1: '}'
            {
             before(grammarAccess.getCompoundStateAccess().getRightCurlyBracketKeyword_8()); 
            match(input,16,FOLLOW_16_in_rule__CompoundState__Group__8__Impl2982); 
             after(grammarAccess.getCompoundStateAccess().getRightCurlyBracketKeyword_8()); 

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
    // $ANTLR end "rule__CompoundState__Group__8__Impl"


    // $ANTLR start "rule__CompoundState__Group__9"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1523:1: rule__CompoundState__Group__9 : rule__CompoundState__Group__9__Impl ;
    public final void rule__CompoundState__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1527:1: ( rule__CompoundState__Group__9__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1528:2: rule__CompoundState__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__CompoundState__Group__9__Impl_in_rule__CompoundState__Group__93013);
            rule__CompoundState__Group__9__Impl();

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
    // $ANTLR end "rule__CompoundState__Group__9"


    // $ANTLR start "rule__CompoundState__Group__9__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1534:1: rule__CompoundState__Group__9__Impl : ( ( rule__CompoundState__Group_9__0 )? ) ;
    public final void rule__CompoundState__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1538:1: ( ( ( rule__CompoundState__Group_9__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1539:1: ( ( rule__CompoundState__Group_9__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1539:1: ( ( rule__CompoundState__Group_9__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1540:1: ( rule__CompoundState__Group_9__0 )?
            {
             before(grammarAccess.getCompoundStateAccess().getGroup_9()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1541:1: ( rule__CompoundState__Group_9__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1541:2: rule__CompoundState__Group_9__0
                    {
                    pushFollow(FOLLOW_rule__CompoundState__Group_9__0_in_rule__CompoundState__Group__9__Impl3040);
                    rule__CompoundState__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCompoundStateAccess().getGroup_9()); 

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
    // $ANTLR end "rule__CompoundState__Group__9__Impl"


    // $ANTLR start "rule__CompoundState__Group_9__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1571:1: rule__CompoundState__Group_9__0 : rule__CompoundState__Group_9__0__Impl rule__CompoundState__Group_9__1 ;
    public final void rule__CompoundState__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1575:1: ( rule__CompoundState__Group_9__0__Impl rule__CompoundState__Group_9__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1576:2: rule__CompoundState__Group_9__0__Impl rule__CompoundState__Group_9__1
            {
            pushFollow(FOLLOW_rule__CompoundState__Group_9__0__Impl_in_rule__CompoundState__Group_9__03091);
            rule__CompoundState__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CompoundState__Group_9__1_in_rule__CompoundState__Group_9__03094);
            rule__CompoundState__Group_9__1();

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
    // $ANTLR end "rule__CompoundState__Group_9__0"


    // $ANTLR start "rule__CompoundState__Group_9__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1583:1: rule__CompoundState__Group_9__0__Impl : ( 'debug' ) ;
    public final void rule__CompoundState__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1587:1: ( ( 'debug' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1588:1: ( 'debug' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1588:1: ( 'debug' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1589:1: 'debug'
            {
             before(grammarAccess.getCompoundStateAccess().getDebugKeyword_9_0()); 
            match(input,18,FOLLOW_18_in_rule__CompoundState__Group_9__0__Impl3122); 
             after(grammarAccess.getCompoundStateAccess().getDebugKeyword_9_0()); 

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
    // $ANTLR end "rule__CompoundState__Group_9__0__Impl"


    // $ANTLR start "rule__CompoundState__Group_9__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1602:1: rule__CompoundState__Group_9__1 : rule__CompoundState__Group_9__1__Impl ;
    public final void rule__CompoundState__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1606:1: ( rule__CompoundState__Group_9__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1607:2: rule__CompoundState__Group_9__1__Impl
            {
            pushFollow(FOLLOW_rule__CompoundState__Group_9__1__Impl_in_rule__CompoundState__Group_9__13153);
            rule__CompoundState__Group_9__1__Impl();

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
    // $ANTLR end "rule__CompoundState__Group_9__1"


    // $ANTLR start "rule__CompoundState__Group_9__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1613:1: rule__CompoundState__Group_9__1__Impl : ( ( rule__CompoundState__DbgNameAssignment_9_1 ) ) ;
    public final void rule__CompoundState__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1617:1: ( ( ( rule__CompoundState__DbgNameAssignment_9_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1618:1: ( ( rule__CompoundState__DbgNameAssignment_9_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1618:1: ( ( rule__CompoundState__DbgNameAssignment_9_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1619:1: ( rule__CompoundState__DbgNameAssignment_9_1 )
            {
             before(grammarAccess.getCompoundStateAccess().getDbgNameAssignment_9_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1620:1: ( rule__CompoundState__DbgNameAssignment_9_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1620:2: rule__CompoundState__DbgNameAssignment_9_1
            {
            pushFollow(FOLLOW_rule__CompoundState__DbgNameAssignment_9_1_in_rule__CompoundState__Group_9__1__Impl3180);
            rule__CompoundState__DbgNameAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getCompoundStateAccess().getDbgNameAssignment_9_1()); 

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
    // $ANTLR end "rule__CompoundState__Group_9__1__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1634:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1638:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1639:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__03214);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__03217);
            rule__Transition__Group__1();

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
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1646:1: rule__Transition__Group__0__Impl : ( ( rule__Transition__EventAssignment_0 ) ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1650:1: ( ( ( rule__Transition__EventAssignment_0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1651:1: ( ( rule__Transition__EventAssignment_0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1651:1: ( ( rule__Transition__EventAssignment_0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1652:1: ( rule__Transition__EventAssignment_0 )
            {
             before(grammarAccess.getTransitionAccess().getEventAssignment_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1653:1: ( rule__Transition__EventAssignment_0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1653:2: rule__Transition__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl3244);
            rule__Transition__EventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getEventAssignment_0()); 

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
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1663:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1667:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1668:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__13274);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__13277);
            rule__Transition__Group__2();

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
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1675:1: rule__Transition__Group__1__Impl : ( '=>' ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1679:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1680:1: ( '=>' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1680:1: ( '=>' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1681:1: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            match(input,22,FOLLOW_22_in_rule__Transition__Group__1__Impl3305); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1()); 

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
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1694:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl rule__Transition__Group__3 ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1698:1: ( rule__Transition__Group__2__Impl rule__Transition__Group__3 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1699:2: rule__Transition__Group__2__Impl rule__Transition__Group__3
            {
            pushFollow(FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__23336);
            rule__Transition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group__3_in_rule__Transition__Group__23339);
            rule__Transition__Group__3();

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
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1706:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__StateAssignment_2 ) ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1710:1: ( ( ( rule__Transition__StateAssignment_2 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1711:1: ( ( rule__Transition__StateAssignment_2 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1711:1: ( ( rule__Transition__StateAssignment_2 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1712:1: ( rule__Transition__StateAssignment_2 )
            {
             before(grammarAccess.getTransitionAccess().getStateAssignment_2()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1713:1: ( rule__Transition__StateAssignment_2 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1713:2: rule__Transition__StateAssignment_2
            {
            pushFollow(FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl3366);
            rule__Transition__StateAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getStateAssignment_2()); 

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
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group__3"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1723:1: rule__Transition__Group__3 : rule__Transition__Group__3__Impl ;
    public final void rule__Transition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1727:1: ( rule__Transition__Group__3__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1728:2: rule__Transition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group__3__Impl_in_rule__Transition__Group__33396);
            rule__Transition__Group__3__Impl();

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
    // $ANTLR end "rule__Transition__Group__3"


    // $ANTLR start "rule__Transition__Group__3__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1734:1: rule__Transition__Group__3__Impl : ( ( rule__Transition__Group_3__0 )? ) ;
    public final void rule__Transition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1738:1: ( ( ( rule__Transition__Group_3__0 )? ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1739:1: ( ( rule__Transition__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1739:1: ( ( rule__Transition__Group_3__0 )? )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1740:1: ( rule__Transition__Group_3__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_3()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1741:1: ( rule__Transition__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1741:2: rule__Transition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Transition__Group_3__0_in_rule__Transition__Group__3__Impl3423);
                    rule__Transition__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Transition__Group__3__Impl"


    // $ANTLR start "rule__Transition__Group_3__0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1759:1: rule__Transition__Group_3__0 : rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 ;
    public final void rule__Transition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1763:1: ( rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1764:2: rule__Transition__Group_3__0__Impl rule__Transition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Transition__Group_3__0__Impl_in_rule__Transition__Group_3__03462);
            rule__Transition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transition__Group_3__1_in_rule__Transition__Group_3__03465);
            rule__Transition__Group_3__1();

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
    // $ANTLR end "rule__Transition__Group_3__0"


    // $ANTLR start "rule__Transition__Group_3__0__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1771:1: rule__Transition__Group_3__0__Impl : ( 'debug' ) ;
    public final void rule__Transition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1775:1: ( ( 'debug' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1776:1: ( 'debug' )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1776:1: ( 'debug' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1777:1: 'debug'
            {
             before(grammarAccess.getTransitionAccess().getDebugKeyword_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Transition__Group_3__0__Impl3493); 
             after(grammarAccess.getTransitionAccess().getDebugKeyword_3_0()); 

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
    // $ANTLR end "rule__Transition__Group_3__0__Impl"


    // $ANTLR start "rule__Transition__Group_3__1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1790:1: rule__Transition__Group_3__1 : rule__Transition__Group_3__1__Impl ;
    public final void rule__Transition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1794:1: ( rule__Transition__Group_3__1__Impl )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1795:2: rule__Transition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Transition__Group_3__1__Impl_in_rule__Transition__Group_3__13524);
            rule__Transition__Group_3__1__Impl();

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
    // $ANTLR end "rule__Transition__Group_3__1"


    // $ANTLR start "rule__Transition__Group_3__1__Impl"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1801:1: rule__Transition__Group_3__1__Impl : ( ( rule__Transition__DbgNameAssignment_3_1 ) ) ;
    public final void rule__Transition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1805:1: ( ( ( rule__Transition__DbgNameAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1806:1: ( ( rule__Transition__DbgNameAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1806:1: ( ( rule__Transition__DbgNameAssignment_3_1 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1807:1: ( rule__Transition__DbgNameAssignment_3_1 )
            {
             before(grammarAccess.getTransitionAccess().getDbgNameAssignment_3_1()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1808:1: ( rule__Transition__DbgNameAssignment_3_1 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1808:2: rule__Transition__DbgNameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Transition__DbgNameAssignment_3_1_in_rule__Transition__Group_3__1__Impl3551);
            rule__Transition__DbgNameAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getDbgNameAssignment_3_1()); 

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
    // $ANTLR end "rule__Transition__Group_3__1__Impl"


    // $ANTLR start "rule__Module__NameAssignment_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1823:1: rule__Module__NameAssignment_1 : ( ( rule__Module__NameAlternatives_1_0 ) ) ;
    public final void rule__Module__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1827:1: ( ( ( rule__Module__NameAlternatives_1_0 ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1828:1: ( ( rule__Module__NameAlternatives_1_0 ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1828:1: ( ( rule__Module__NameAlternatives_1_0 ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1829:1: ( rule__Module__NameAlternatives_1_0 )
            {
             before(grammarAccess.getModuleAccess().getNameAlternatives_1_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1830:1: ( rule__Module__NameAlternatives_1_0 )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1830:2: rule__Module__NameAlternatives_1_0
            {
            pushFollow(FOLLOW_rule__Module__NameAlternatives_1_0_in_rule__Module__NameAssignment_13590);
            rule__Module__NameAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAlternatives_1_0()); 

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
    // $ANTLR end "rule__Module__NameAssignment_1"


    // $ANTLR start "rule__Module__MachinesAssignment_2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1839:1: rule__Module__MachinesAssignment_2 : ( ruleStatemachine ) ;
    public final void rule__Module__MachinesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1843:1: ( ( ruleStatemachine ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1844:1: ( ruleStatemachine )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1844:1: ( ruleStatemachine )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1845:1: ruleStatemachine
            {
             before(grammarAccess.getModuleAccess().getMachinesStatemachineParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatemachine_in_rule__Module__MachinesAssignment_23623);
            ruleStatemachine();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getMachinesStatemachineParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Module__MachinesAssignment_2"


    // $ANTLR start "rule__Statemachine__InitialAssignment_0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1854:1: rule__Statemachine__InitialAssignment_0 : ( ( 'initial' ) ) ;
    public final void rule__Statemachine__InitialAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1858:1: ( ( ( 'initial' ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1859:1: ( ( 'initial' ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1859:1: ( ( 'initial' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1860:1: ( 'initial' )
            {
             before(grammarAccess.getStatemachineAccess().getInitialInitialKeyword_0_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1861:1: ( 'initial' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1862:1: 'initial'
            {
             before(grammarAccess.getStatemachineAccess().getInitialInitialKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__Statemachine__InitialAssignment_03659); 
             after(grammarAccess.getStatemachineAccess().getInitialInitialKeyword_0_0()); 

            }

             after(grammarAccess.getStatemachineAccess().getInitialInitialKeyword_0_0()); 

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
    // $ANTLR end "rule__Statemachine__InitialAssignment_0"


    // $ANTLR start "rule__Statemachine__NameAssignment_2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1877:1: rule__Statemachine__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Statemachine__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1881:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1882:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1882:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1883:1: RULE_ID
            {
             before(grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Statemachine__NameAssignment_23698); 
             after(grammarAccess.getStatemachineAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Statemachine__NameAssignment_2"


    // $ANTLR start "rule__Statemachine__ValueAssignment_3_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1892:1: rule__Statemachine__ValueAssignment_3_1 : ( RULE_INT ) ;
    public final void rule__Statemachine__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1896:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1897:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1897:1: ( RULE_INT )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1898:1: RULE_INT
            {
             before(grammarAccess.getStatemachineAccess().getValueINTTerminalRuleCall_3_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Statemachine__ValueAssignment_3_13729); 
             after(grammarAccess.getStatemachineAccess().getValueINTTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Statemachine__ValueAssignment_3_1"


    // $ANTLR start "rule__Statemachine__EventsAssignment_6"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1907:1: rule__Statemachine__EventsAssignment_6 : ( ruleEvent ) ;
    public final void rule__Statemachine__EventsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1911:1: ( ( ruleEvent ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1912:1: ( ruleEvent )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1912:1: ( ruleEvent )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1913:1: ruleEvent
            {
             before(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_63760);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__Statemachine__EventsAssignment_6"


    // $ANTLR start "rule__Statemachine__StatesAssignment_8"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1922:1: rule__Statemachine__StatesAssignment_8 : ( ruleState ) ;
    public final void rule__Statemachine__StatesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1926:1: ( ( ruleState ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1927:1: ( ruleState )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1927:1: ( ruleState )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1928:1: ruleState
            {
             before(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_83791);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_8_0()); 

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
    // $ANTLR end "rule__Statemachine__StatesAssignment_8"


    // $ANTLR start "rule__Statemachine__DbgNameAssignment_10_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1937:1: rule__Statemachine__DbgNameAssignment_10_1 : ( RULE_ID ) ;
    public final void rule__Statemachine__DbgNameAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1941:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1942:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1942:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1943:1: RULE_ID
            {
             before(grammarAccess.getStatemachineAccess().getDbgNameIDTerminalRuleCall_10_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Statemachine__DbgNameAssignment_10_13822); 
             after(grammarAccess.getStatemachineAccess().getDbgNameIDTerminalRuleCall_10_1_0()); 

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
    // $ANTLR end "rule__Statemachine__DbgNameAssignment_10_1"


    // $ANTLR start "rule__Event__NameAssignment"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1952:1: rule__Event__NameAssignment : ( RULE_ID ) ;
    public final void rule__Event__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1956:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1957:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1957:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1958:1: RULE_ID
            {
             before(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Event__NameAssignment3853); 
             after(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__Event__NameAssignment"


    // $ANTLR start "rule__SimpleState__InitialAssignment_0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1967:1: rule__SimpleState__InitialAssignment_0 : ( ( 'initial' ) ) ;
    public final void rule__SimpleState__InitialAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1971:1: ( ( ( 'initial' ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1972:1: ( ( 'initial' ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1972:1: ( ( 'initial' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1973:1: ( 'initial' )
            {
             before(grammarAccess.getSimpleStateAccess().getInitialInitialKeyword_0_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1974:1: ( 'initial' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1975:1: 'initial'
            {
             before(grammarAccess.getSimpleStateAccess().getInitialInitialKeyword_0_0()); 
            match(input,23,FOLLOW_23_in_rule__SimpleState__InitialAssignment_03889); 
             after(grammarAccess.getSimpleStateAccess().getInitialInitialKeyword_0_0()); 

            }

             after(grammarAccess.getSimpleStateAccess().getInitialInitialKeyword_0_0()); 

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
    // $ANTLR end "rule__SimpleState__InitialAssignment_0"


    // $ANTLR start "rule__SimpleState__NameAssignment_2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1990:1: rule__SimpleState__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__SimpleState__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1994:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1995:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1995:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:1996:1: RULE_ID
            {
             before(grammarAccess.getSimpleStateAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleState__NameAssignment_23928); 
             after(grammarAccess.getSimpleStateAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__SimpleState__NameAssignment_2"


    // $ANTLR start "rule__SimpleState__ValueAssignment_3_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2005:1: rule__SimpleState__ValueAssignment_3_1 : ( RULE_INT ) ;
    public final void rule__SimpleState__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2009:1: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2010:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2010:1: ( RULE_INT )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2011:1: RULE_INT
            {
             before(grammarAccess.getSimpleStateAccess().getValueINTTerminalRuleCall_3_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SimpleState__ValueAssignment_3_13959); 
             after(grammarAccess.getSimpleStateAccess().getValueINTTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__SimpleState__ValueAssignment_3_1"


    // $ANTLR start "rule__SimpleState__TransitionsAssignment_5"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2020:1: rule__SimpleState__TransitionsAssignment_5 : ( ruleTransition ) ;
    public final void rule__SimpleState__TransitionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2024:1: ( ( ruleTransition ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2025:1: ( ruleTransition )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2025:1: ( ruleTransition )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2026:1: ruleTransition
            {
             before(grammarAccess.getSimpleStateAccess().getTransitionsTransitionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__SimpleState__TransitionsAssignment_53990);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getSimpleStateAccess().getTransitionsTransitionParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__SimpleState__TransitionsAssignment_5"


    // $ANTLR start "rule__SimpleState__DbgNameAssignment_7_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2035:1: rule__SimpleState__DbgNameAssignment_7_1 : ( RULE_ID ) ;
    public final void rule__SimpleState__DbgNameAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2039:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2040:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2040:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2041:1: RULE_ID
            {
             before(grammarAccess.getSimpleStateAccess().getDbgNameIDTerminalRuleCall_7_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleState__DbgNameAssignment_7_14021); 
             after(grammarAccess.getSimpleStateAccess().getDbgNameIDTerminalRuleCall_7_1_0()); 

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
    // $ANTLR end "rule__SimpleState__DbgNameAssignment_7_1"


    // $ANTLR start "rule__CompoundState__InitialAssignment_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2050:1: rule__CompoundState__InitialAssignment_1 : ( ( 'initial' ) ) ;
    public final void rule__CompoundState__InitialAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2054:1: ( ( ( 'initial' ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2055:1: ( ( 'initial' ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2055:1: ( ( 'initial' ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2056:1: ( 'initial' )
            {
             before(grammarAccess.getCompoundStateAccess().getInitialInitialKeyword_1_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2057:1: ( 'initial' )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2058:1: 'initial'
            {
             before(grammarAccess.getCompoundStateAccess().getInitialInitialKeyword_1_0()); 
            match(input,23,FOLLOW_23_in_rule__CompoundState__InitialAssignment_14057); 
             after(grammarAccess.getCompoundStateAccess().getInitialInitialKeyword_1_0()); 

            }

             after(grammarAccess.getCompoundStateAccess().getInitialInitialKeyword_1_0()); 

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
    // $ANTLR end "rule__CompoundState__InitialAssignment_1"


    // $ANTLR start "rule__CompoundState__NameAssignment_3"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2073:1: rule__CompoundState__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__CompoundState__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2077:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2078:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2078:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2079:1: RULE_ID
            {
             before(grammarAccess.getCompoundStateAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CompoundState__NameAssignment_34096); 
             after(grammarAccess.getCompoundStateAccess().getNameIDTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__CompoundState__NameAssignment_3"


    // $ANTLR start "rule__CompoundState__MachineAssignment_5"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2088:1: rule__CompoundState__MachineAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__CompoundState__MachineAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2092:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2093:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2093:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2094:1: ( RULE_ID )
            {
             before(grammarAccess.getCompoundStateAccess().getMachineStatemachineCrossReference_5_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2095:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2096:1: RULE_ID
            {
             before(grammarAccess.getCompoundStateAccess().getMachineStatemachineIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CompoundState__MachineAssignment_54131); 
             after(grammarAccess.getCompoundStateAccess().getMachineStatemachineIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getCompoundStateAccess().getMachineStatemachineCrossReference_5_0()); 

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
    // $ANTLR end "rule__CompoundState__MachineAssignment_5"


    // $ANTLR start "rule__CompoundState__TransitionsAssignment_7"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2107:1: rule__CompoundState__TransitionsAssignment_7 : ( ruleTransition ) ;
    public final void rule__CompoundState__TransitionsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2111:1: ( ( ruleTransition ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2112:1: ( ruleTransition )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2112:1: ( ruleTransition )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2113:1: ruleTransition
            {
             before(grammarAccess.getCompoundStateAccess().getTransitionsTransitionParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleTransition_in_rule__CompoundState__TransitionsAssignment_74166);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getCompoundStateAccess().getTransitionsTransitionParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__CompoundState__TransitionsAssignment_7"


    // $ANTLR start "rule__CompoundState__DbgNameAssignment_9_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2122:1: rule__CompoundState__DbgNameAssignment_9_1 : ( RULE_ID ) ;
    public final void rule__CompoundState__DbgNameAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2126:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2127:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2127:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2128:1: RULE_ID
            {
             before(grammarAccess.getCompoundStateAccess().getDbgNameIDTerminalRuleCall_9_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CompoundState__DbgNameAssignment_9_14197); 
             after(grammarAccess.getCompoundStateAccess().getDbgNameIDTerminalRuleCall_9_1_0()); 

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
    // $ANTLR end "rule__CompoundState__DbgNameAssignment_9_1"


    // $ANTLR start "rule__Transition__EventAssignment_0"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2137:1: rule__Transition__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2141:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2142:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2142:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2143:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2144:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2145:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_04232); 
             after(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0()); 

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
    // $ANTLR end "rule__Transition__EventAssignment_0"


    // $ANTLR start "rule__Transition__StateAssignment_2"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2156:1: rule__Transition__StateAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transition__StateAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2160:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2161:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2161:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2162:1: ( RULE_ID )
            {
             before(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2163:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2164:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_24271); 
             after(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0()); 

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
    // $ANTLR end "rule__Transition__StateAssignment_2"


    // $ANTLR start "rule__Transition__DbgNameAssignment_3_1"
    // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2175:1: rule__Transition__DbgNameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Transition__DbgNameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2179:1: ( ( RULE_ID ) )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2180:1: ( RULE_ID )
            {
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2180:1: ( RULE_ID )
            // ../org.eclipse.ocl.tutorial.eclipsecon2011.states.ui/src-gen/org/eclipse/ocl/tutorial/eclipsecon2011/ui/contentassist/antlr/internal/InternalStates.g:2181:1: RULE_ID
            {
             before(grammarAccess.getTransitionAccess().getDbgNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transition__DbgNameAssignment_3_14306); 
             after(grammarAccess.getTransitionAccess().getDbgNameIDTerminalRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Transition__DbgNameAssignment_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0_in_ruleStatemachine154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__NameAssignment_in_ruleEvent214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__State__Alternatives_in_ruleState274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_entryRuleSimpleState301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleState308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__0_in_ruleSimpleState334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundState_in_entryRuleCompoundState361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundState368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__0_in_ruleCompoundState394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0_in_ruleTransition454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Module__NameAlternatives_1_0490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Module__NameAlternatives_1_0507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleState_in_rule__State__Alternatives539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundState_in_rule__State__Alternatives556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__0586 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__0589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Module__Group__0__Impl617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__1648 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_1_in_rule__Module__Group__1__Impl678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__MachinesAssignment_2_in_rule__Module__Group__2__Impl735 = new BitSet(new long[]{0x0000000000801002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__0__Impl_in_rule__Statemachine__Group__0772 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1_in_rule__Statemachine__Group__0775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__InitialAssignment_0_in_rule__Statemachine__Group__0__Impl802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__1__Impl_in_rule__Statemachine__Group__1833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2_in_rule__Statemachine__Group__1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Statemachine__Group__1__Impl864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__2__Impl_in_rule__Statemachine__Group__2895 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3_in_rule__Statemachine__Group__2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__NameAssignment_2_in_rule__Statemachine__Group__2__Impl925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__3__Impl_in_rule__Statemachine__Group__3955 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4_in_rule__Statemachine__Group__3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__0_in_rule__Statemachine__Group__3__Impl985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__4__Impl_in_rule__Statemachine__Group__41016 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5_in_rule__Statemachine__Group__41019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Statemachine__Group__4__Impl1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__5__Impl_in_rule__Statemachine__Group__51078 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6_in_rule__Statemachine__Group__51081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Statemachine__Group__5__Impl1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__6__Impl_in_rule__Statemachine__Group__61140 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__7_in_rule__Statemachine__Group__61143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__EventsAssignment_6_in_rule__Statemachine__Group__6__Impl1170 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__7__Impl_in_rule__Statemachine__Group__71201 = new BitSet(new long[]{0x0000000000990000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__8_in_rule__Statemachine__Group__71204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Statemachine__Group__7__Impl1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__8__Impl_in_rule__Statemachine__Group__81263 = new BitSet(new long[]{0x0000000000990000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__9_in_rule__Statemachine__Group__81266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__StatesAssignment_8_in_rule__Statemachine__Group__8__Impl1293 = new BitSet(new long[]{0x0000000000980002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__9__Impl_in_rule__Statemachine__Group__91324 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__10_in_rule__Statemachine__Group__91327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Statemachine__Group__9__Impl1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group__10__Impl_in_rule__Statemachine__Group__101386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_10__0_in_rule__Statemachine__Group__10__Impl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__0__Impl_in_rule__Statemachine__Group_3__01466 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__1_in_rule__Statemachine__Group_3__01469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Statemachine__Group_3__0__Impl1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_3__1__Impl_in_rule__Statemachine__Group_3__11528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__ValueAssignment_3_1_in_rule__Statemachine__Group_3__1__Impl1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_10__0__Impl_in_rule__Statemachine__Group_10__01589 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_10__1_in_rule__Statemachine__Group_10__01592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Statemachine__Group_10__0__Impl1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__Group_10__1__Impl_in_rule__Statemachine__Group_10__11651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statemachine__DbgNameAssignment_10_1_in_rule__Statemachine__Group_10__1__Impl1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__0__Impl_in_rule__SimpleState__Group__01712 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__1_in_rule__SimpleState__Group__01715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__InitialAssignment_0_in_rule__SimpleState__Group__0__Impl1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__1__Impl_in_rule__SimpleState__Group__11773 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__2_in_rule__SimpleState__Group__11776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SimpleState__Group__1__Impl1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__2__Impl_in_rule__SimpleState__Group__21835 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__3_in_rule__SimpleState__Group__21838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__NameAssignment_2_in_rule__SimpleState__Group__2__Impl1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__3__Impl_in_rule__SimpleState__Group__31895 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__4_in_rule__SimpleState__Group__31898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_3__0_in_rule__SimpleState__Group__3__Impl1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__4__Impl_in_rule__SimpleState__Group__41956 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__5_in_rule__SimpleState__Group__41959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleState__Group__4__Impl1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__5__Impl_in_rule__SimpleState__Group__52018 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__6_in_rule__SimpleState__Group__52021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__TransitionsAssignment_5_in_rule__SimpleState__Group__5__Impl2048 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__6__Impl_in_rule__SimpleState__Group__62079 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__7_in_rule__SimpleState__Group__62082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__SimpleState__Group__6__Impl2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group__7__Impl_in_rule__SimpleState__Group__72141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_7__0_in_rule__SimpleState__Group__7__Impl2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_3__0__Impl_in_rule__SimpleState__Group_3__02215 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_3__1_in_rule__SimpleState__Group_3__02218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SimpleState__Group_3__0__Impl2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_3__1__Impl_in_rule__SimpleState__Group_3__12277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__ValueAssignment_3_1_in_rule__SimpleState__Group_3__1__Impl2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_7__0__Impl_in_rule__SimpleState__Group_7__02338 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_7__1_in_rule__SimpleState__Group_7__02341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SimpleState__Group_7__0__Impl2369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__Group_7__1__Impl_in_rule__SimpleState__Group_7__12400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleState__DbgNameAssignment_7_1_in_rule__SimpleState__Group_7__1__Impl2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__0__Impl_in_rule__CompoundState__Group__02461 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__1_in_rule__CompoundState__Group__02464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CompoundState__Group__0__Impl2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__1__Impl_in_rule__CompoundState__Group__12523 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__2_in_rule__CompoundState__Group__12526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__InitialAssignment_1_in_rule__CompoundState__Group__1__Impl2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__2__Impl_in_rule__CompoundState__Group__22584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__3_in_rule__CompoundState__Group__22587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CompoundState__Group__2__Impl2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__3__Impl_in_rule__CompoundState__Group__32646 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__4_in_rule__CompoundState__Group__32649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__NameAssignment_3_in_rule__CompoundState__Group__3__Impl2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__4__Impl_in_rule__CompoundState__Group__42706 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__5_in_rule__CompoundState__Group__42709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__CompoundState__Group__4__Impl2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__5__Impl_in_rule__CompoundState__Group__52768 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__6_in_rule__CompoundState__Group__52771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__MachineAssignment_5_in_rule__CompoundState__Group__5__Impl2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__6__Impl_in_rule__CompoundState__Group__62828 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__7_in_rule__CompoundState__Group__62831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__CompoundState__Group__6__Impl2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__7__Impl_in_rule__CompoundState__Group__72890 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__8_in_rule__CompoundState__Group__72893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__TransitionsAssignment_7_in_rule__CompoundState__Group__7__Impl2920 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__8__Impl_in_rule__CompoundState__Group__82951 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__9_in_rule__CompoundState__Group__82954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__CompoundState__Group__8__Impl2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group__9__Impl_in_rule__CompoundState__Group__93013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group_9__0_in_rule__CompoundState__Group__9__Impl3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group_9__0__Impl_in_rule__CompoundState__Group_9__03091 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CompoundState__Group_9__1_in_rule__CompoundState__Group_9__03094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CompoundState__Group_9__0__Impl3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__Group_9__1__Impl_in_rule__CompoundState__Group_9__13153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CompoundState__DbgNameAssignment_9_1_in_rule__CompoundState__Group_9__1__Impl3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__0__Impl_in_rule__Transition__Group__03214 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Transition__Group__1_in_rule__Transition__Group__03217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__EventAssignment_0_in_rule__Transition__Group__0__Impl3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__1__Impl_in_rule__Transition__Group__13274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Transition__Group__2_in_rule__Transition__Group__13277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Transition__Group__1__Impl3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__2__Impl_in_rule__Transition__Group__23336 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Transition__Group__3_in_rule__Transition__Group__23339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__StateAssignment_2_in_rule__Transition__Group__2__Impl3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group__3__Impl_in_rule__Transition__Group__33396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__0_in_rule__Transition__Group__3__Impl3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__0__Impl_in_rule__Transition__Group_3__03462 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__1_in_rule__Transition__Group_3__03465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transition__Group_3__0__Impl3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__Group_3__1__Impl_in_rule__Transition__Group_3__13524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transition__DbgNameAssignment_3_1_in_rule__Transition__Group_3__1__Impl3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAlternatives_1_0_in_rule__Module__NameAssignment_13590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatemachine_in_rule__Module__MachinesAssignment_23623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Statemachine__InitialAssignment_03659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Statemachine__NameAssignment_23698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Statemachine__ValueAssignment_3_13729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Statemachine__EventsAssignment_63760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_rule__Statemachine__StatesAssignment_83791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Statemachine__DbgNameAssignment_10_13822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Event__NameAssignment3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SimpleState__InitialAssignment_03889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleState__NameAssignment_23928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SimpleState__ValueAssignment_3_13959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__SimpleState__TransitionsAssignment_53990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleState__DbgNameAssignment_7_14021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CompoundState__InitialAssignment_14057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CompoundState__NameAssignment_34096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CompoundState__MachineAssignment_54131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_rule__CompoundState__TransitionsAssignment_74166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CompoundState__DbgNameAssignment_9_14197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__EventAssignment_04232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__StateAssignment_24271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transition__DbgNameAssignment_3_14306 = new BitSet(new long[]{0x0000000000000002L});

}