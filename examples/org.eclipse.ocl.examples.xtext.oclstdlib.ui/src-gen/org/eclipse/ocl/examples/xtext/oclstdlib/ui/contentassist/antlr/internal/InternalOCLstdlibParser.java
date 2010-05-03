package org.eclipse.ocl.examples.xtext.oclstdlib.ui.contentassist.antlr.internal; 

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
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class InternalOCLstdlibParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID_TERMINAL", "RULE_SINGLE_QUOTED_STRING", "RULE_DOUBLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'library'", "'operation'", "'package'", "'property'", "'static'", "'super'", "'type'", "'+'", "'?'", "'{'", "'}'", "':'", "'<'", "'>'", "','", "'('", "')'", "'=>'", "';'", "'['", "']'", "'..'", "'::'", "'&&'", "'...'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID_TERMINAL=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_SINGLE_QUOTED_STRING=6;
    public static final int RULE_DOUBLE_QUOTED_STRING=7;
    public static final int RULE_SL_COMMENT=9;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[269+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g"; }


     
     	private OCLstdlibGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(OCLstdlibGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleLibrary
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:61:1: entryRuleLibrary : ruleLibrary EOF ;
    public final void entryRuleLibrary() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:62:1: ( ruleLibrary EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:63:1: ruleLibrary EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_entryRuleLibrary67);
            ruleLibrary();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibrary74); if (failed) return ;

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
    // $ANTLR end entryRuleLibrary


    // $ANTLR start ruleLibrary
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:70:1: ruleLibrary : ( ( rule__Library__Group__0 ) ) ;
    public final void ruleLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:74:2: ( ( ( rule__Library__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:75:1: ( ( rule__Library__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:75:1: ( ( rule__Library__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:76:1: ( rule__Library__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:77:1: ( rule__Library__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:77:2: rule__Library__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__0_in_ruleLibrary100);
            rule__Library__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibrary


    // $ANTLR start entryRuleLOWER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:89:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:90:1: ( ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:91:1: ruleLOWER EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER127);
            ruleLOWER();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLOWERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER134); if (failed) return ;

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
    // $ANTLR end entryRuleLOWER


    // $ANTLR start ruleLOWER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:98:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:102:2: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:103:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:103:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:104:1: RULE_INT
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER160); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
            }

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
    // $ANTLR end ruleLOWER


    // $ANTLR start entryRuleUPPER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:117:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:118:1: ( ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:119:1: ruleUPPER EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER186);
            ruleUPPER();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getUPPERRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER193); if (failed) return ;

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
    // $ANTLR end entryRuleUPPER


    // $ANTLR start ruleUPPER
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:126:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:130:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:131:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:131:1: ( ( rule__UPPER__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:132:1: ( rule__UPPER__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:133:1: ( rule__UPPER__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:133:2: rule__UPPER__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER219);
            rule__UPPER__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getUPPERAccess().getAlternatives()); 
            }

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
    // $ANTLR end ruleUPPER


    // $ANTLR start entryRuleIdentifier
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:145:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:146:1: ( ruleIdentifier EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:147:1: ruleIdentifier EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier246);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier253); if (failed) return ;

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
    // $ANTLR end entryRuleIdentifier


    // $ANTLR start ruleIdentifier
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:154:1: ruleIdentifier : ( ( rule__Identifier__Alternatives ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:158:2: ( ( ( rule__Identifier__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:159:1: ( ( rule__Identifier__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:159:1: ( ( rule__Identifier__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:160:1: ( rule__Identifier__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:161:1: ( rule__Identifier__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:161:2: rule__Identifier__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Identifier__Alternatives_in_ruleIdentifier279);
            rule__Identifier__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getIdentifierAccess().getAlternatives()); 
            }

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
    // $ANTLR end ruleIdentifier


    // $ANTLR start entryRuleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:175:1: entryRuleLibImportCS : ruleLibImportCS EOF ;
    public final void entryRuleLibImportCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:176:1: ( ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:177:1: ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS308);
            ruleLibImportCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS315); if (failed) return ;

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
    // $ANTLR end entryRuleLibImportCS


    // $ANTLR start ruleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:184:1: ruleLibImportCS : ( ( rule__LibImportCS__Group__0 ) ) ;
    public final void ruleLibImportCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:2: ( ( ( rule__LibImportCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:1: ( ( rule__LibImportCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:1: ( ( rule__LibImportCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:190:1: ( rule__LibImportCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:191:1: ( rule__LibImportCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:191:2: rule__LibImportCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS341);
            rule__LibImportCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibImportCS


    // $ANTLR start entryRuleLibClassCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:203:1: entryRuleLibClassCS : ruleLibClassCS EOF ;
    public final void entryRuleLibClassCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:204:1: ( ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:205:1: ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS368);
            ruleLibClassCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS375); if (failed) return ;

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
    // $ANTLR end entryRuleLibClassCS


    // $ANTLR start ruleLibClassCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:212:1: ruleLibClassCS : ( ( rule__LibClassCS__Group__0 ) ) ;
    public final void ruleLibClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:2: ( ( ( rule__LibClassCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:1: ( ( rule__LibClassCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:1: ( ( rule__LibClassCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:218:1: ( rule__LibClassCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:219:1: ( rule__LibClassCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:219:2: rule__LibClassCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS401);
            rule__LibClassCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibClassCS


    // $ANTLR start entryRuleLibClassifierCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:231:1: entryRuleLibClassifierCS : ruleLibClassifierCS EOF ;
    public final void entryRuleLibClassifierCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:232:1: ( ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:233:1: ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS428);
            ruleLibClassifierCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassifierCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS435); if (failed) return ;

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
    // $ANTLR end entryRuleLibClassifierCS


    // $ANTLR start ruleLibClassifierCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:240:1: ruleLibClassifierCS : ( ruleLibClassCS ) ;
    public final void ruleLibClassifierCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:2: ( ( ruleLibClassCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:1: ( ruleLibClassCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:1: ( ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:246:1: ruleLibClassCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS461);
            ruleLibClassCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall()); 
            }

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
    // $ANTLR end ruleLibClassifierCS


    // $ANTLR start entryRuleLibIterationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:259:1: entryRuleLibIterationCS : ruleLibIterationCS EOF ;
    public final void entryRuleLibIterationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:260:1: ( ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:261:1: ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS487);
            ruleLibIterationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS494); if (failed) return ;

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
    // $ANTLR end entryRuleLibIterationCS


    // $ANTLR start ruleLibIterationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:268:1: ruleLibIterationCS : ( ( rule__LibIterationCS__Group__0 ) ) ;
    public final void ruleLibIterationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:2: ( ( ( rule__LibIterationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:273:1: ( ( rule__LibIterationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:273:1: ( ( rule__LibIterationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:274:1: ( rule__LibIterationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:275:1: ( rule__LibIterationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:275:2: rule__LibIterationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS520);
            rule__LibIterationCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibIterationCS


    // $ANTLR start entryRuleLibOperationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:287:1: entryRuleLibOperationCS : ruleLibOperationCS EOF ;
    public final void entryRuleLibOperationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:288:1: ( ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:289:1: ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS547);
            ruleLibOperationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS554); if (failed) return ;

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
    // $ANTLR end entryRuleLibOperationCS


    // $ANTLR start ruleLibOperationCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:296:1: ruleLibOperationCS : ( ( rule__LibOperationCS__Group__0 ) ) ;
    public final void ruleLibOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:2: ( ( ( rule__LibOperationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:1: ( ( rule__LibOperationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:1: ( ( rule__LibOperationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:302:1: ( rule__LibOperationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:303:1: ( rule__LibOperationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:303:2: rule__LibOperationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS580);
            rule__LibOperationCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibOperationCS


    // $ANTLR start entryRuleLibPackageCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:315:1: entryRuleLibPackageCS : ruleLibPackageCS EOF ;
    public final void entryRuleLibPackageCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:316:1: ( ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:317:1: ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS607);
            ruleLibPackageCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS614); if (failed) return ;

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
    // $ANTLR end entryRuleLibPackageCS


    // $ANTLR start ruleLibPackageCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:324:1: ruleLibPackageCS : ( ( rule__LibPackageCS__Group__0 ) ) ;
    public final void ruleLibPackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:2: ( ( ( rule__LibPackageCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:1: ( ( rule__LibPackageCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:1: ( ( rule__LibPackageCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:330:1: ( rule__LibPackageCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:331:1: ( rule__LibPackageCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:331:2: rule__LibPackageCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS640);
            rule__LibPackageCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibPackageCS


    // $ANTLR start entryRuleLibParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:343:1: entryRuleLibParameterCS : ruleLibParameterCS EOF ;
    public final void entryRuleLibParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:344:1: ( ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:345:1: ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS667);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS674); if (failed) return ;

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
    // $ANTLR end entryRuleLibParameterCS


    // $ANTLR start ruleLibParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:352:1: ruleLibParameterCS : ( ( rule__LibParameterCS__Group__0 ) ) ;
    public final void ruleLibParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:2: ( ( ( rule__LibParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:1: ( ( rule__LibParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:1: ( ( rule__LibParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:358:1: ( rule__LibParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:359:1: ( rule__LibParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:359:2: rule__LibParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS700);
            rule__LibParameterCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibParameterCS


    // $ANTLR start entryRuleLibPropertyCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:371:1: entryRuleLibPropertyCS : ruleLibPropertyCS EOF ;
    public final void entryRuleLibPropertyCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:372:1: ( ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:373:1: ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS727);
            ruleLibPropertyCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS734); if (failed) return ;

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
    // $ANTLR end entryRuleLibPropertyCS


    // $ANTLR start ruleLibPropertyCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:380:1: ruleLibPropertyCS : ( ( rule__LibPropertyCS__Group__0 ) ) ;
    public final void ruleLibPropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:2: ( ( ( rule__LibPropertyCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:1: ( ( rule__LibPropertyCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:1: ( ( rule__LibPropertyCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:386:1: ( rule__LibPropertyCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:387:1: ( rule__LibPropertyCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:387:2: rule__LibPropertyCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS760);
            rule__LibPropertyCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibPropertyCS


    // $ANTLR start entryRuleLibQualifiedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:399:1: entryRuleLibQualifiedTypeRefCS : ruleLibQualifiedTypeRefCS EOF ;
    public final void entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:400:1: ( ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:401:1: ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS787);
            ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS794); if (failed) return ;

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
    // $ANTLR end entryRuleLibQualifiedTypeRefCS


    // $ANTLR start ruleLibQualifiedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:408:1: ruleLibQualifiedTypeRefCS : ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibQualifiedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:2: ( ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:414:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:415:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:415:2: rule__LibQualifiedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS820);
            rule__LibQualifiedTypeRefCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibQualifiedTypeRefCS


    // $ANTLR start entryRuleLibTypeParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:427:1: entryRuleLibTypeParameterCS : ruleLibTypeParameterCS EOF ;
    public final void entryRuleLibTypeParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:428:1: ( ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:429:1: ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS847);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS854); if (failed) return ;

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
    // $ANTLR end entryRuleLibTypeParameterCS


    // $ANTLR start ruleLibTypeParameterCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:436:1: ruleLibTypeParameterCS : ( ( rule__LibTypeParameterCS__Group__0 ) ) ;
    public final void ruleLibTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:2: ( ( ( rule__LibTypeParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:442:1: ( rule__LibTypeParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:443:1: ( rule__LibTypeParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:443:2: rule__LibTypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS880);
            rule__LibTypeParameterCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibTypeParameterCS


    // $ANTLR start entryRuleLibTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:455:1: entryRuleLibTypeRefCS : ruleLibTypeRefCS EOF ;
    public final void entryRuleLibTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:456:1: ( ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:457:1: ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS907);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS914); if (failed) return ;

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
    // $ANTLR end entryRuleLibTypeRefCS


    // $ANTLR start ruleLibTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:464:1: ruleLibTypeRefCS : ( ( rule__LibTypeRefCS__Alternatives ) ) ;
    public final void ruleLibTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:2: ( ( ( rule__LibTypeRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:470:1: ( rule__LibTypeRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:471:1: ( rule__LibTypeRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:471:2: rule__LibTypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS940);
            rule__LibTypeRefCS__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeRefCSAccess().getAlternatives()); 
            }

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
    // $ANTLR end ruleLibTypeRefCS


    // $ANTLR start entryRuleLibTypedRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:483:1: entryRuleLibTypedRefCS : ruleLibTypedRefCS EOF ;
    public final void entryRuleLibTypedRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:484:1: ( ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:485:1: ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS967);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS974); if (failed) return ;

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
    // $ANTLR end entryRuleLibTypedRefCS


    // $ANTLR start ruleLibTypedRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:492:1: ruleLibTypedRefCS : ( ( rule__LibTypedRefCS__Alternatives ) ) ;
    public final void ruleLibTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:2: ( ( ( rule__LibTypedRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:498:1: ( rule__LibTypedRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:499:1: ( rule__LibTypedRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:499:2: rule__LibTypedRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1000);
            rule__LibTypedRefCS__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedRefCSAccess().getAlternatives()); 
            }

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
    // $ANTLR end ruleLibTypedRefCS


    // $ANTLR start entryRuleLibTypedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:511:1: entryRuleLibTypedTypeRefCS : ruleLibTypedTypeRefCS EOF ;
    public final void entryRuleLibTypedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:512:1: ( ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:513:1: ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1027);
            ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1034); if (failed) return ;

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
    // $ANTLR end entryRuleLibTypedTypeRefCS


    // $ANTLR start ruleLibTypedTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:520:1: ruleLibTypedTypeRefCS : ( ( rule__LibTypedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:2: ( ( ( rule__LibTypedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:526:1: ( rule__LibTypedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:527:1: ( rule__LibTypedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:527:2: rule__LibTypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1060);
            rule__LibTypedTypeRefCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibTypedTypeRefCS


    // $ANTLR start entryRuleLibWildcardTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:539:1: entryRuleLibWildcardTypeRefCS : ruleLibWildcardTypeRefCS EOF ;
    public final void entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:540:1: ( ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:541:1: ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1087);
            ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1094); if (failed) return ;

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
    // $ANTLR end entryRuleLibWildcardTypeRefCS


    // $ANTLR start ruleLibWildcardTypeRefCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:548:1: ruleLibWildcardTypeRefCS : ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleLibWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:2: ( ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:554:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:555:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:555:2: rule__LibWildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1120);
            rule__LibWildcardTypeRefCS__Group__0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup()); 
            }

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
    // $ANTLR end ruleLibWildcardTypeRefCS


    // $ANTLR start rule__UPPER__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:567:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:571:1: ( ( RULE_INT ) | ( '*' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_INT) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("567:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:572:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:572:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:573:1: RULE_INT
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1156); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:578:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:578:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:579:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__UPPER__Alternatives1174); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }

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
    // $ANTLR end rule__UPPER__Alternatives


    // $ANTLR start rule__Identifier__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:591:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'static' ) | ( 'super' ) | ( 'type' ) );
    public final void rule__Identifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:595:1: ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'static' ) | ( 'super' ) | ( 'type' ) )
            int alt2=12;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 17:
                {
                alt2=7;
                }
                break;
            case 18:
                {
                alt2=8;
                }
                break;
            case 19:
                {
                alt2=9;
                }
                break;
            case 20:
                {
                alt2=10;
                }
                break;
            case 21:
                {
                alt2=11;
                }
                break;
            case 22:
                {
                alt2=12;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("591:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'static' ) | ( 'super' ) | ( 'type' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:596:1: ( RULE_ID_TERMINAL )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:596:1: ( RULE_ID_TERMINAL )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:597:1: RULE_ID_TERMINAL
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getID_TERMINALTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID_TERMINAL,FollowSets000.FOLLOW_RULE_ID_TERMINAL_in_rule__Identifier__Alternatives1208); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getID_TERMINALTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:602:6: ( 'conformsTo' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:602:6: ( 'conformsTo' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:603:1: 'conformsTo'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getConformsToKeyword_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Identifier__Alternatives1226); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getConformsToKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:610:6: ( 'extends' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:610:6: ( 'extends' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:611:1: 'extends'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getExtendsKeyword_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Identifier__Alternatives1246); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getExtendsKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:618:6: ( 'import' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:618:6: ( 'import' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:619:1: 'import'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getImportKeyword_3()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Identifier__Alternatives1266); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getImportKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:626:6: ( 'iteration' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:626:6: ( 'iteration' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:627:1: 'iteration'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getIterationKeyword_4()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Identifier__Alternatives1286); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getIterationKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:634:6: ( 'library' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:634:6: ( 'library' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:635:1: 'library'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getLibraryKeyword_5()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Identifier__Alternatives1306); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getLibraryKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:642:6: ( 'operation' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:642:6: ( 'operation' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:643:1: 'operation'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getOperationKeyword_6()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__Identifier__Alternatives1326); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getOperationKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:650:6: ( 'package' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:650:6: ( 'package' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:651:1: 'package'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getPackageKeyword_7()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__Identifier__Alternatives1346); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getPackageKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:658:6: ( 'property' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:658:6: ( 'property' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:659:1: 'property'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getPropertyKeyword_8()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__Identifier__Alternatives1366); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getPropertyKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:666:6: ( 'static' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:666:6: ( 'static' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:667:1: 'static'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getStaticKeyword_9()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__Identifier__Alternatives1386); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getStaticKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:674:6: ( 'super' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:674:6: ( 'super' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:675:1: 'super'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getSuperKeyword_10()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__Identifier__Alternatives1406); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getSuperKeyword_10()); 
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:682:6: ( 'type' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:682:6: ( 'type' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:683:1: 'type'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getTypeKeyword_11()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__Identifier__Alternatives1426); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getTypeKeyword_11()); 
                    }

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
    // $ANTLR end rule__Identifier__Alternatives


    // $ANTLR start rule__LibClassCS__Alternatives_5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:695:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );
    public final void rule__LibClassCS__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:699:1: ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt3=1;
                }
                break;
            case 20:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==19) ) {
                    alt3=3;
                }
                else if ( (LA3_2==17) ) {
                    alt3=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("695:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("695:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:700:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:700:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:701:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getIterationsAssignment_5_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:702:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:702:2: rule__LibClassCS__IterationsAssignment_5_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51460);
                    rule__LibClassCS__IterationsAssignment_5_0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getIterationsAssignment_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:706:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:706:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:707:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:708:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:708:2: rule__LibClassCS__OperationsAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51478);
                    rule__LibClassCS__OperationsAssignment_5_1();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:712:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:712:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:713:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_2()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:714:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:714:2: rule__LibClassCS__StructuralFeaturesAssignment_5_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51496);
                    rule__LibClassCS__StructuralFeaturesAssignment_5_2();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_2()); 
                    }

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
    // $ANTLR end rule__LibClassCS__Alternatives_5


    // $ANTLR start rule__LibPackageCS__Alternatives_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:723:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__LibPackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:727:1: ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==22) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("723:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:728:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:728:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:729:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:730:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:730:2: rule__LibPackageCS__SubpackagesAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31529);
                    rule__LibPackageCS__SubpackagesAssignment_3_0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:734:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:734:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:735:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:736:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:736:2: rule__LibPackageCS__ClassifiersAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31547);
                    rule__LibPackageCS__ClassifiersAssignment_3_1();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }

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
    // $ANTLR end rule__LibPackageCS__Alternatives_3


    // $ANTLR start rule__LibParameterCS__Alternatives_3_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:745:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );
    public final void rule__LibParameterCS__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:749:1: ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==11||(LA5_0>=23 && LA5_0<=24)) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("745:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:750:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:750:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:751:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:752:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:752:2: rule__LibParameterCS__Group_3_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11580);
                    rule__LibParameterCS__Group_3_1_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:756:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:756:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:757:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:758:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:758:2: rule__LibParameterCS__MultiplicityAssignment_3_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11598);
                    rule__LibParameterCS__MultiplicityAssignment_3_1_1();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }

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
    // $ANTLR end rule__LibParameterCS__Alternatives_3_1


    // $ANTLR start rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:767:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:771:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 23:
                {
                alt6=2;
                }
                break;
            case 24:
                {
                alt6=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("767:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:772:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:772:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:773:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01632); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:780:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:780:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:781:1: '+'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01652); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:788:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:788:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:789:1: '?'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2()); 
                    }
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01672); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2()); 
                    }

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
    // $ANTLR end rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0


    // $ANTLR start rule__LibTypeParameterCS__Alternatives_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:801:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__LibTypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:805:1: ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("801:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:806:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:806:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:807:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:808:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:808:2: rule__LibTypeParameterCS__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11706);
                    rule__LibTypeParameterCS__Group_1_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:814:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:814:2: rule__LibTypeParameterCS__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11724);
                    rule__LibTypeParameterCS__Group_1_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }

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
    // $ANTLR end rule__LibTypeParameterCS__Alternatives_1


    // $ANTLR start rule__LibTypeRefCS__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:823:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );
    public final void rule__LibTypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:827:1: ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID_TERMINAL||(LA8_0>=12 && LA8_0<=22)) ) {
                alt8=1;
            }
            else if ( (LA8_0==24) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("823:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:828:1: ( ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:828:1: ( ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:1: ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1757);
                    ruleLibTypedRefCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:834:6: ( ruleLibWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:834:6: ( ruleLibWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:835:1: ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1774);
                    ruleLibWildcardTypeRefCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1()); 
                    }

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
    // $ANTLR end rule__LibTypeRefCS__Alternatives


    // $ANTLR start rule__LibTypedRefCS__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );
    public final void rule__LibTypedRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:849:1: ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) )
            int alt9=2;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                int LA9_1 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA9_2 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA9_3 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA9_4 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 4, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA9_5 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 5, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA9_6 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 6, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA9_7 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 7, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA9_8 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 8, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA9_9 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 9, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA9_10 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 10, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA9_11 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 11, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA9_12 = input.LA(2);

                if ( (synpred21()) ) {
                    alt9=1;
                }
                else if ( (true) ) {
                    alt9=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 12, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("845:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ruleLibQualifiedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ruleLibQualifiedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:851:1: ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1806);
                    ruleLibQualifiedTypeRefCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:856:6: ( ruleLibTypedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:856:6: ( ruleLibTypedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:857:1: ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1823);
                    ruleLibTypedTypeRefCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1()); 
                    }

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
    // $ANTLR end rule__LibTypedRefCS__Alternatives


    // $ANTLR start rule__LibWildcardTypeRefCS__Alternatives_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:867:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__LibWildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:871:1: ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            else if ( (LA10_0==21) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("867:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:872:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:872:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:873:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:2: rule__LibWildcardTypeRefCS__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_21855);
                    rule__LibWildcardTypeRefCS__Group_2_0__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:878:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:878:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:879:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:880:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:880:2: rule__LibWildcardTypeRefCS__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_21873);
                    rule__LibWildcardTypeRefCS__Group_2_1__0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Alternatives_2


    // $ANTLR start rule__Library__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: rule__Library__Group__0 : ( 'library' ) rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:895:1: ( ( 'library' ) rule__Library__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:896:1: ( 'library' ) rule__Library__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:896:1: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:1: 'library'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Library__Group__01909); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1_in_rule__Library__Group__01919);
            rule__Library__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__Library__Group__0


    // $ANTLR start rule__Library__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:911:1: rule__Library__Group__1 : ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:915:1: ( ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:916:1: ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:916:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:917:1: ( rule__Library__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:918:1: ( rule__Library__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:918:2: rule__Library__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__11947);
            rule__Library__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2_in_rule__Library__Group__11956);
            rule__Library__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__Library__Group__1


    // $ANTLR start rule__Library__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:929:1: rule__Library__Group__2 : ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:933:1: ( ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:934:1: ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:934:1: ( ( rule__Library__ImportsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( rule__Library__ImportsAssignment_2 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ( rule__Library__ImportsAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:2: rule__Library__ImportsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__21984);
            	    rule__Library__ImportsAssignment_2();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3_in_rule__Library__Group__21994);
            rule__Library__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__Library__Group__2


    // $ANTLR start rule__Library__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:947:1: rule__Library__Group__3 : ( '{' ) rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ( '{' ) rule__Library__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:952:1: ( '{' ) rule__Library__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:952:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:953:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Library__Group__32023); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32033);
            rule__Library__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__Library__Group__3


    // $ANTLR start rule__Library__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:967:1: rule__Library__Group__4 : ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5 ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:971:1: ( ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:972:1: ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:972:1: ( ( rule__Library__PackagesAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:973:1: ( rule__Library__PackagesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:974:1: ( rule__Library__PackagesAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==18) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:974:2: rule__Library__PackagesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__42061);
            	    rule__Library__PackagesAssignment_4();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42071);
            rule__Library__Group__5();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__Library__Group__4


    // $ANTLR start rule__Library__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:985:1: rule__Library__Group__5 : ( '}' ) ;
    public final void rule__Library__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:989:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:990:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:990:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:991:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Library__Group__52100); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }

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
    // $ANTLR end rule__Library__Group__5


    // $ANTLR start rule__LibImportCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1018:1: rule__LibImportCS__Group__0 : ( 'import' ) rule__LibImportCS__Group__1 ;
    public final void rule__LibImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1022:1: ( ( 'import' ) rule__LibImportCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1023:1: ( 'import' ) rule__LibImportCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1023:1: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1024:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__LibImportCS__Group__02150); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02160);
            rule__LibImportCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibImportCS__Group__0


    // $ANTLR start rule__LibImportCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1038:1: rule__LibImportCS__Group__1 : ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2 ;
    public final void rule__LibImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1042:1: ( ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1043:1: ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1043:1: ( ( rule__LibImportCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1044:1: ( rule__LibImportCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1045:1: ( rule__LibImportCS__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID_TERMINAL||(LA13_0>=12 && LA13_0<=22)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1045:2: rule__LibImportCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__12188);
                    rule__LibImportCS__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12198);
            rule__LibImportCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibImportCS__Group__1


    // $ANTLR start rule__LibImportCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1056:1: rule__LibImportCS__Group__2 : ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) ;
    public final void rule__LibImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1060:1: ( ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1061:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1061:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1062:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1063:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1063:2: rule__LibImportCS__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__22226);
            rule__LibImportCS__NamespaceAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }

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
    // $ANTLR end rule__LibImportCS__Group__2


    // $ANTLR start rule__LibImportCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1079:1: rule__LibImportCS__Group_1__0 : ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1 ;
    public final void rule__LibImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1083:1: ( ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1084:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1084:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1085:1: ( rule__LibImportCS__NameAssignment_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1086:1: ( rule__LibImportCS__NameAssignment_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1086:2: rule__LibImportCS__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__02266);
            rule__LibImportCS__NameAssignment_1_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02275);
            rule__LibImportCS__Group_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibImportCS__Group_1__0


    // $ANTLR start rule__LibImportCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1097:1: rule__LibImportCS__Group_1__1 : ( ':' ) ;
    public final void rule__LibImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1101:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1102:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1102:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1103:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibImportCS__Group_1__12304); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }

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
    // $ANTLR end rule__LibImportCS__Group_1__1


    // $ANTLR start rule__LibClassCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1120:1: rule__LibClassCS__Group__0 : ( 'type' ) rule__LibClassCS__Group__1 ;
    public final void rule__LibClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1124:1: ( ( 'type' ) rule__LibClassCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1125:1: ( 'type' ) rule__LibClassCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1125:1: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1126:1: 'type'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }
            match(input,22,FollowSets000.FOLLOW_22_in_rule__LibClassCS__Group__02344); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02354);
            rule__LibClassCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__0


    // $ANTLR start rule__LibClassCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: rule__LibClassCS__Group__1 : ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2 ;
    public final void rule__LibClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1144:1: ( ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1145:1: ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1145:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1146:1: ( rule__LibClassCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1147:1: ( rule__LibClassCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1147:2: rule__LibClassCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__12382);
            rule__LibClassCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12391);
            rule__LibClassCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__1


    // $ANTLR start rule__LibClassCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1158:1: rule__LibClassCS__Group__2 : ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3 ;
    public final void rule__LibClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1162:1: ( ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1163:1: ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1163:1: ( ( rule__LibClassCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1164:1: ( rule__LibClassCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1165:1: ( rule__LibClassCS__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1165:2: rule__LibClassCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__22419);
                    rule__LibClassCS__Group_2__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22429);
            rule__LibClassCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__2


    // $ANTLR start rule__LibClassCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1176:1: rule__LibClassCS__Group__3 : ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4 ;
    public final void rule__LibClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1180:1: ( ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1181:1: ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1181:1: ( ( rule__LibClassCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1182:1: ( rule__LibClassCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: ( rule__LibClassCS__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==12) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:2: rule__LibClassCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__32457);
                    rule__LibClassCS__Group_3__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32467);
            rule__LibClassCS__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__3


    // $ANTLR start rule__LibClassCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1194:1: rule__LibClassCS__Group__4 : ( '{' ) rule__LibClassCS__Group__5 ;
    public final void rule__LibClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1198:1: ( ( '{' ) rule__LibClassCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1199:1: ( '{' ) rule__LibClassCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1199:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1200:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibClassCS__Group__42496); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42506);
            rule__LibClassCS__Group__5();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__4


    // $ANTLR start rule__LibClassCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1214:1: rule__LibClassCS__Group__5 : ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6 ;
    public final void rule__LibClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1218:1: ( ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1219:1: ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1219:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1220:1: ( rule__LibClassCS__Alternatives_5 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1221:1: ( rule__LibClassCS__Alternatives_5 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15||LA16_0==17||(LA16_0>=19 && LA16_0<=20)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1221:2: rule__LibClassCS__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__52534);
            	    rule__LibClassCS__Alternatives_5();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52544);
            rule__LibClassCS__Group__6();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group__5


    // $ANTLR start rule__LibClassCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1232:1: rule__LibClassCS__Group__6 : ( '}' ) ;
    public final void rule__LibClassCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1236:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1237:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1237:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1238:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibClassCS__Group__62573); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }

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
    // $ANTLR end rule__LibClassCS__Group__6


    // $ANTLR start rule__LibClassCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1265:1: rule__LibClassCS__Group_2__0 : ( '<' ) rule__LibClassCS__Group_2__1 ;
    public final void rule__LibClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1269:1: ( ( '<' ) rule__LibClassCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1270:1: ( '<' ) rule__LibClassCS__Group_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1270:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1271:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibClassCS__Group_2__02623); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__02633);
            rule__LibClassCS__Group_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_2__0


    // $ANTLR start rule__LibClassCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1285:1: rule__LibClassCS__Group_2__1 : ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2 ;
    public final void rule__LibClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1289:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1290:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1290:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1291:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1292:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1292:2: rule__LibClassCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__12661);
            rule__LibClassCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__12670);
            rule__LibClassCS__Group_2__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_2__1


    // $ANTLR start rule__LibClassCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1303:1: rule__LibClassCS__Group_2__2 : ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3 ;
    public final void rule__LibClassCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1307:1: ( ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1308:1: ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1308:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1309:1: ( rule__LibClassCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1310:1: ( rule__LibClassCS__Group_2_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==30) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1310:2: rule__LibClassCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__22698);
            	    rule__LibClassCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__22708);
            rule__LibClassCS__Group_2__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_2__2


    // $ANTLR start rule__LibClassCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1321:1: rule__LibClassCS__Group_2__3 : ( '>' ) ;
    public final void rule__LibClassCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1325:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1326:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1326:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1327:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_2__32737); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }

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
    // $ANTLR end rule__LibClassCS__Group_2__3


    // $ANTLR start rule__LibClassCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1348:1: rule__LibClassCS__Group_2_2__0 : ( ',' ) rule__LibClassCS__Group_2_2__1 ;
    public final void rule__LibClassCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1352:1: ( ( ',' ) rule__LibClassCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1353:1: ( ',' ) rule__LibClassCS__Group_2_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1353:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1354:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibClassCS__Group_2_2__02781); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__02791);
            rule__LibClassCS__Group_2_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_2_2__0


    // $ANTLR start rule__LibClassCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1368:1: rule__LibClassCS__Group_2_2__1 : ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1372:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1373:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1373:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1374:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1375:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1375:2: rule__LibClassCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__12819);
            rule__LibClassCS__TypeParametersAssignment_2_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }

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
    // $ANTLR end rule__LibClassCS__Group_2_2__1


    // $ANTLR start rule__LibClassCS__Group_3__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1389:1: rule__LibClassCS__Group_3__0 : ( 'conformsTo' ) rule__LibClassCS__Group_3__1 ;
    public final void rule__LibClassCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1393:1: ( ( 'conformsTo' ) rule__LibClassCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1394:1: ( 'conformsTo' ) rule__LibClassCS__Group_3__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1394:1: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1395:1: 'conformsTo'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__LibClassCS__Group_3__02858); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__02868);
            rule__LibClassCS__Group_3__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_3__0


    // $ANTLR start rule__LibClassCS__Group_3__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1409:1: rule__LibClassCS__Group_3__1 : ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2 ;
    public final void rule__LibClassCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1413:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1414:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1414:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1415:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1416:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1416:2: rule__LibClassCS__ConformsToAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__12896);
            rule__LibClassCS__ConformsToAssignment_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__12905);
            rule__LibClassCS__Group_3__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_3__1


    // $ANTLR start rule__LibClassCS__Group_3__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1427:1: rule__LibClassCS__Group_3__2 : ( ( rule__LibClassCS__Group_3_2__0 )* ) ;
    public final void rule__LibClassCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1431:1: ( ( ( rule__LibClassCS__Group_3_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1433:1: ( rule__LibClassCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1434:1: ( rule__LibClassCS__Group_3_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==30) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1434:2: rule__LibClassCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__22933);
            	    rule__LibClassCS__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }

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
    // $ANTLR end rule__LibClassCS__Group_3__2


    // $ANTLR start rule__LibClassCS__Group_3_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1450:1: rule__LibClassCS__Group_3_2__0 : ( ',' ) rule__LibClassCS__Group_3_2__1 ;
    public final void rule__LibClassCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1454:1: ( ( ',' ) rule__LibClassCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1455:1: ( ',' ) rule__LibClassCS__Group_3_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1455:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1456:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibClassCS__Group_3_2__02975); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__02985);
            rule__LibClassCS__Group_3_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibClassCS__Group_3_2__0


    // $ANTLR start rule__LibClassCS__Group_3_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1470:1: rule__LibClassCS__Group_3_2__1 : ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) ;
    public final void rule__LibClassCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1474:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1475:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1475:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1476:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1477:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1477:2: rule__LibClassCS__ConformsToAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__13013);
            rule__LibClassCS__ConformsToAssignment_3_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }

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
    // $ANTLR end rule__LibClassCS__Group_3_2__1


    // $ANTLR start rule__LibIterationCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1491:1: rule__LibIterationCS__Group__0 : ( 'iteration' ) rule__LibIterationCS__Group__1 ;
    public final void rule__LibIterationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1495:1: ( ( 'iteration' ) rule__LibIterationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1496:1: ( 'iteration' ) rule__LibIterationCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1496:1: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1497:1: 'iteration'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__LibIterationCS__Group__03052); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03062);
            rule__LibIterationCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__0


    // $ANTLR start rule__LibIterationCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1511:1: rule__LibIterationCS__Group__1 : ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2 ;
    public final void rule__LibIterationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1515:1: ( ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1516:1: ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1516:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1517:1: ( rule__LibIterationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:1: ( rule__LibIterationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:2: rule__LibIterationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__13090);
            rule__LibIterationCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13099);
            rule__LibIterationCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__1


    // $ANTLR start rule__LibIterationCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1529:1: rule__LibIterationCS__Group__2 : ( '(' ) rule__LibIterationCS__Group__3 ;
    public final void rule__LibIterationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1533:1: ( ( '(' ) rule__LibIterationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( '(' ) rule__LibIterationCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1535:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibIterationCS__Group__23128); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23138);
            rule__LibIterationCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__2


    // $ANTLR start rule__LibIterationCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1549:1: rule__LibIterationCS__Group__3 : ( ( rule__LibIterationCS__IteratorsAssignment_3 ) ) rule__LibIterationCS__Group__4 ;
    public final void rule__LibIterationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1553:1: ( ( ( rule__LibIterationCS__IteratorsAssignment_3 ) ) rule__LibIterationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1554:1: ( ( rule__LibIterationCS__IteratorsAssignment_3 ) ) rule__LibIterationCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1554:1: ( ( rule__LibIterationCS__IteratorsAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1555:1: ( rule__LibIterationCS__IteratorsAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1556:1: ( rule__LibIterationCS__IteratorsAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1556:2: rule__LibIterationCS__IteratorsAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__IteratorsAssignment_3_in_rule__LibIterationCS__Group__33166);
            rule__LibIterationCS__IteratorsAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33175);
            rule__LibIterationCS__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__3


    // $ANTLR start rule__LibIterationCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1567:1: rule__LibIterationCS__Group__4 : ( ( rule__LibIterationCS__Group_4__0 )* ) rule__LibIterationCS__Group__5 ;
    public final void rule__LibIterationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1571:1: ( ( ( rule__LibIterationCS__Group_4__0 )* ) rule__LibIterationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1572:1: ( ( rule__LibIterationCS__Group_4__0 )* ) rule__LibIterationCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1572:1: ( ( rule__LibIterationCS__Group_4__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1573:1: ( rule__LibIterationCS__Group_4__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:1: ( rule__LibIterationCS__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:2: rule__LibIterationCS__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_4__0_in_rule__LibIterationCS__Group__43203);
            	    rule__LibIterationCS__Group_4__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGroup_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__43213);
            rule__LibIterationCS__Group__5();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__4


    // $ANTLR start rule__LibIterationCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1585:1: rule__LibIterationCS__Group__5 : ( ( rule__LibIterationCS__IteratorsAssignment_5 )? ) rule__LibIterationCS__Group__6 ;
    public final void rule__LibIterationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1589:1: ( ( ( rule__LibIterationCS__IteratorsAssignment_5 )? ) rule__LibIterationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1590:1: ( ( rule__LibIterationCS__IteratorsAssignment_5 )? ) rule__LibIterationCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1590:1: ( ( rule__LibIterationCS__IteratorsAssignment_5 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1591:1: ( rule__LibIterationCS__IteratorsAssignment_5 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1592:1: ( rule__LibIterationCS__IteratorsAssignment_5 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==40) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1592:2: rule__LibIterationCS__IteratorsAssignment_5
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__IteratorsAssignment_5_in_rule__LibIterationCS__Group__53241);
                    rule__LibIterationCS__IteratorsAssignment_5();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__53251);
            rule__LibIterationCS__Group__6();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__5


    // $ANTLR start rule__LibIterationCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1603:1: rule__LibIterationCS__Group__6 : ( ')' ) rule__LibIterationCS__Group__7 ;
    public final void rule__LibIterationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1607:1: ( ( ')' ) rule__LibIterationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1608:1: ( ')' ) rule__LibIterationCS__Group__7
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1608:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1609:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibIterationCS__Group__63280); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__63290);
            rule__LibIterationCS__Group__7();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__6


    // $ANTLR start rule__LibIterationCS__Group__7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1623:1: rule__LibIterationCS__Group__7 : ( ':' ) rule__LibIterationCS__Group__8 ;
    public final void rule__LibIterationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1627:1: ( ( ':' ) rule__LibIterationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1628:1: ( ':' ) rule__LibIterationCS__Group__8
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1628:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1629:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibIterationCS__Group__73319); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__73329);
            rule__LibIterationCS__Group__8();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__7


    // $ANTLR start rule__LibIterationCS__Group__8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1643:1: rule__LibIterationCS__Group__8 : ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9 ;
    public final void rule__LibIterationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1647:1: ( ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1648:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1648:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1649:1: ( rule__LibIterationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1650:1: ( rule__LibIterationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1650:2: rule__LibIterationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__83357);
            rule__LibIterationCS__TypeAssignment_8();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__83366);
            rule__LibIterationCS__Group__9();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__8


    // $ANTLR start rule__LibIterationCS__Group__9
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1661:1: rule__LibIterationCS__Group__9 : ( '=>' ) rule__LibIterationCS__Group__10 ;
    public final void rule__LibIterationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1665:1: ( ( '=>' ) rule__LibIterationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1666:1: ( '=>' ) rule__LibIterationCS__Group__10
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1666:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1667:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibIterationCS__Group__93395); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__93405);
            rule__LibIterationCS__Group__10();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__9


    // $ANTLR start rule__LibIterationCS__Group__10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1681:1: rule__LibIterationCS__Group__10 : ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11 ;
    public final void rule__LibIterationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1685:1: ( ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1686:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1686:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1687:1: ( rule__LibIterationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1688:1: ( rule__LibIterationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1688:2: rule__LibIterationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__103433);
            rule__LibIterationCS__ClassAssignment_10();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__103442);
            rule__LibIterationCS__Group__11();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group__10


    // $ANTLR start rule__LibIterationCS__Group__11
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1699:1: rule__LibIterationCS__Group__11 : ( ';' ) ;
    public final void rule__LibIterationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1703:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1705:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibIterationCS__Group__113471); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }

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
    // $ANTLR end rule__LibIterationCS__Group__11


    // $ANTLR start rule__LibIterationCS__Group_4__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1742:1: rule__LibIterationCS__Group_4__0 : ( ',' ) rule__LibIterationCS__Group_4__1 ;
    public final void rule__LibIterationCS__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1746:1: ( ( ',' ) rule__LibIterationCS__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1747:1: ( ',' ) rule__LibIterationCS__Group_4__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1747:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1748:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_4_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibIterationCS__Group_4__03531); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_4__1_in_rule__LibIterationCS__Group_4__03541);
            rule__LibIterationCS__Group_4__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibIterationCS__Group_4__0


    // $ANTLR start rule__LibIterationCS__Group_4__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1762:1: rule__LibIterationCS__Group_4__1 : ( ( rule__LibIterationCS__IteratorsAssignment_4_1 ) ) ;
    public final void rule__LibIterationCS__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1766:1: ( ( ( rule__LibIterationCS__IteratorsAssignment_4_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1767:1: ( ( rule__LibIterationCS__IteratorsAssignment_4_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1767:1: ( ( rule__LibIterationCS__IteratorsAssignment_4_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1768:1: ( rule__LibIterationCS__IteratorsAssignment_4_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1769:1: ( rule__LibIterationCS__IteratorsAssignment_4_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1769:2: rule__LibIterationCS__IteratorsAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__IteratorsAssignment_4_1_in_rule__LibIterationCS__Group_4__13569);
            rule__LibIterationCS__IteratorsAssignment_4_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsAssignment_4_1()); 
            }

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
    // $ANTLR end rule__LibIterationCS__Group_4__1


    // $ANTLR start rule__LibOperationCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1783:1: rule__LibOperationCS__Group__0 : ( ( rule__LibOperationCS__IsStaticAssignment_0 )? ) rule__LibOperationCS__Group__1 ;
    public final void rule__LibOperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1787:1: ( ( ( rule__LibOperationCS__IsStaticAssignment_0 )? ) rule__LibOperationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1788:1: ( ( rule__LibOperationCS__IsStaticAssignment_0 )? ) rule__LibOperationCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1788:1: ( ( rule__LibOperationCS__IsStaticAssignment_0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1789:1: ( rule__LibOperationCS__IsStaticAssignment_0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getIsStaticAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1790:1: ( rule__LibOperationCS__IsStaticAssignment_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1790:2: rule__LibOperationCS__IsStaticAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__IsStaticAssignment_0_in_rule__LibOperationCS__Group__03607);
                    rule__LibOperationCS__IsStaticAssignment_0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getIsStaticAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__03617);
            rule__LibOperationCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__0


    // $ANTLR start rule__LibOperationCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1801:1: rule__LibOperationCS__Group__1 : ( 'operation' ) rule__LibOperationCS__Group__2 ;
    public final void rule__LibOperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1805:1: ( ( 'operation' ) rule__LibOperationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1806:1: ( 'operation' ) rule__LibOperationCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1806:1: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1807:1: 'operation'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_1()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__LibOperationCS__Group__13646); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getOperationKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__13656);
            rule__LibOperationCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__1


    // $ANTLR start rule__LibOperationCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1821:1: rule__LibOperationCS__Group__2 : ( ( rule__LibOperationCS__NameAssignment_2 ) ) rule__LibOperationCS__Group__3 ;
    public final void rule__LibOperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1825:1: ( ( ( rule__LibOperationCS__NameAssignment_2 ) ) rule__LibOperationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1826:1: ( ( rule__LibOperationCS__NameAssignment_2 ) ) rule__LibOperationCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1826:1: ( ( rule__LibOperationCS__NameAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1827:1: ( rule__LibOperationCS__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1828:1: ( rule__LibOperationCS__NameAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1828:2: rule__LibOperationCS__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__NameAssignment_2_in_rule__LibOperationCS__Group__23684);
            rule__LibOperationCS__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getNameAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__23693);
            rule__LibOperationCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__2


    // $ANTLR start rule__LibOperationCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1839:1: rule__LibOperationCS__Group__3 : ( ( rule__LibOperationCS__Group_3__0 )? ) rule__LibOperationCS__Group__4 ;
    public final void rule__LibOperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1843:1: ( ( ( rule__LibOperationCS__Group_3__0 )? ) rule__LibOperationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1844:1: ( ( rule__LibOperationCS__Group_3__0 )? ) rule__LibOperationCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1844:1: ( ( rule__LibOperationCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1845:1: ( rule__LibOperationCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1846:1: ( rule__LibOperationCS__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1846:2: rule__LibOperationCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3__0_in_rule__LibOperationCS__Group__33721);
                    rule__LibOperationCS__Group_3__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__33731);
            rule__LibOperationCS__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__3


    // $ANTLR start rule__LibOperationCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1857:1: rule__LibOperationCS__Group__4 : ( '(' ) rule__LibOperationCS__Group__5 ;
    public final void rule__LibOperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1861:1: ( ( '(' ) rule__LibOperationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1862:1: ( '(' ) rule__LibOperationCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1862:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1863:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibOperationCS__Group__43760); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__43770);
            rule__LibOperationCS__Group__5();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__4


    // $ANTLR start rule__LibOperationCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1877:1: rule__LibOperationCS__Group__5 : ( ( rule__LibOperationCS__Group_5__0 )? ) rule__LibOperationCS__Group__6 ;
    public final void rule__LibOperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1881:1: ( ( ( rule__LibOperationCS__Group_5__0 )? ) rule__LibOperationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1882:1: ( ( rule__LibOperationCS__Group_5__0 )? ) rule__LibOperationCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1882:1: ( ( rule__LibOperationCS__Group_5__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1883:1: ( rule__LibOperationCS__Group_5__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1884:1: ( rule__LibOperationCS__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID_TERMINAL||(LA23_0>=12 && LA23_0<=22)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1884:2: rule__LibOperationCS__Group_5__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_5__0_in_rule__LibOperationCS__Group__53798);
                    rule__LibOperationCS__Group_5__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__53808);
            rule__LibOperationCS__Group__6();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__5


    // $ANTLR start rule__LibOperationCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1895:1: rule__LibOperationCS__Group__6 : ( ')' ) rule__LibOperationCS__Group__7 ;
    public final void rule__LibOperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1899:1: ( ( ')' ) rule__LibOperationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1900:1: ( ')' ) rule__LibOperationCS__Group__7
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1900:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1901:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibOperationCS__Group__63837); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__63847);
            rule__LibOperationCS__Group__7();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__6


    // $ANTLR start rule__LibOperationCS__Group__7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1915:1: rule__LibOperationCS__Group__7 : ( ':' ) rule__LibOperationCS__Group__8 ;
    public final void rule__LibOperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1919:1: ( ( ':' ) rule__LibOperationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1920:1: ( ':' ) rule__LibOperationCS__Group__8
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1920:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1921:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getColonKeyword_7()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibOperationCS__Group__73876); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getColonKeyword_7()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__73886);
            rule__LibOperationCS__Group__8();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__7


    // $ANTLR start rule__LibOperationCS__Group__8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1935:1: rule__LibOperationCS__Group__8 : ( ( rule__LibOperationCS__TypeAssignment_8 ) ) rule__LibOperationCS__Group__9 ;
    public final void rule__LibOperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1939:1: ( ( ( rule__LibOperationCS__TypeAssignment_8 ) ) rule__LibOperationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1940:1: ( ( rule__LibOperationCS__TypeAssignment_8 ) ) rule__LibOperationCS__Group__9
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1940:1: ( ( rule__LibOperationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1941:1: ( rule__LibOperationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1942:1: ( rule__LibOperationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1942:2: rule__LibOperationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeAssignment_8_in_rule__LibOperationCS__Group__83914);
            rule__LibOperationCS__TypeAssignment_8();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeAssignment_8()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__83923);
            rule__LibOperationCS__Group__9();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__8


    // $ANTLR start rule__LibOperationCS__Group__9
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1953:1: rule__LibOperationCS__Group__9 : ( '=>' ) rule__LibOperationCS__Group__10 ;
    public final void rule__LibOperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1957:1: ( ( '=>' ) rule__LibOperationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1958:1: ( '=>' ) rule__LibOperationCS__Group__10
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1958:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1959:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibOperationCS__Group__93952); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__93962);
            rule__LibOperationCS__Group__10();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__9


    // $ANTLR start rule__LibOperationCS__Group__10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1973:1: rule__LibOperationCS__Group__10 : ( ( rule__LibOperationCS__ClassAssignment_10 ) ) rule__LibOperationCS__Group__11 ;
    public final void rule__LibOperationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1977:1: ( ( ( rule__LibOperationCS__ClassAssignment_10 ) ) rule__LibOperationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1978:1: ( ( rule__LibOperationCS__ClassAssignment_10 ) ) rule__LibOperationCS__Group__11
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1978:1: ( ( rule__LibOperationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1979:1: ( rule__LibOperationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1980:1: ( rule__LibOperationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1980:2: rule__LibOperationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ClassAssignment_10_in_rule__LibOperationCS__Group__103990);
            rule__LibOperationCS__ClassAssignment_10();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getClassAssignment_10()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__11_in_rule__LibOperationCS__Group__103999);
            rule__LibOperationCS__Group__11();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group__10


    // $ANTLR start rule__LibOperationCS__Group__11
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1991:1: rule__LibOperationCS__Group__11 : ( ';' ) ;
    public final void rule__LibOperationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1995:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1996:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1996:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1997:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibOperationCS__Group__114028); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_11()); 
            }

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
    // $ANTLR end rule__LibOperationCS__Group__11


    // $ANTLR start rule__LibOperationCS__Group_3__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2034:1: rule__LibOperationCS__Group_3__0 : ( '<' ) rule__LibOperationCS__Group_3__1 ;
    public final void rule__LibOperationCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2038:1: ( ( '<' ) rule__LibOperationCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2039:1: ( '<' ) rule__LibOperationCS__Group_3__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2039:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2040:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_3_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibOperationCS__Group_3__04088); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3__1_in_rule__LibOperationCS__Group_3__04098);
            rule__LibOperationCS__Group_3__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_3__0


    // $ANTLR start rule__LibOperationCS__Group_3__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2054:1: rule__LibOperationCS__Group_3__1 : ( ( rule__LibOperationCS__TypeParametersAssignment_3_1 ) ) rule__LibOperationCS__Group_3__2 ;
    public final void rule__LibOperationCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2058:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_3_1 ) ) rule__LibOperationCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2059:1: ( ( rule__LibOperationCS__TypeParametersAssignment_3_1 ) ) rule__LibOperationCS__Group_3__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2059:1: ( ( rule__LibOperationCS__TypeParametersAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2060:1: ( rule__LibOperationCS__TypeParametersAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2061:1: ( rule__LibOperationCS__TypeParametersAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2061:2: rule__LibOperationCS__TypeParametersAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_3_1_in_rule__LibOperationCS__Group_3__14126);
            rule__LibOperationCS__TypeParametersAssignment_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3__2_in_rule__LibOperationCS__Group_3__14135);
            rule__LibOperationCS__Group_3__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_3__1


    // $ANTLR start rule__LibOperationCS__Group_3__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2072:1: rule__LibOperationCS__Group_3__2 : ( ( rule__LibOperationCS__Group_3_2__0 )* ) rule__LibOperationCS__Group_3__3 ;
    public final void rule__LibOperationCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2076:1: ( ( ( rule__LibOperationCS__Group_3_2__0 )* ) rule__LibOperationCS__Group_3__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2077:1: ( ( rule__LibOperationCS__Group_3_2__0 )* ) rule__LibOperationCS__Group_3__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2077:1: ( ( rule__LibOperationCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2078:1: ( rule__LibOperationCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2079:1: ( rule__LibOperationCS__Group_3_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==30) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2079:2: rule__LibOperationCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3_2__0_in_rule__LibOperationCS__Group_3__24163);
            	    rule__LibOperationCS__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_3_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3__3_in_rule__LibOperationCS__Group_3__24173);
            rule__LibOperationCS__Group_3__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_3__2


    // $ANTLR start rule__LibOperationCS__Group_3__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2090:1: rule__LibOperationCS__Group_3__3 : ( '>' ) ;
    public final void rule__LibOperationCS__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2094:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2095:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2095:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2096:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_3_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_3__34202); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_3_3()); 
            }

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
    // $ANTLR end rule__LibOperationCS__Group_3__3


    // $ANTLR start rule__LibOperationCS__Group_3_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2117:1: rule__LibOperationCS__Group_3_2__0 : ( ',' ) rule__LibOperationCS__Group_3_2__1 ;
    public final void rule__LibOperationCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2121:1: ( ( ',' ) rule__LibOperationCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( ',' ) rule__LibOperationCS__Group_3_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2123:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group_3_2__04246); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_3_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_3_2__1_in_rule__LibOperationCS__Group_3_2__04256);
            rule__LibOperationCS__Group_3_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_3_2__0


    // $ANTLR start rule__LibOperationCS__Group_3_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2137:1: rule__LibOperationCS__Group_3_2__1 : ( ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2141:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2142:1: ( ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2142:1: ( ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2143:1: ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2144:1: ( rule__LibOperationCS__TypeParametersAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2144:2: rule__LibOperationCS__TypeParametersAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_3_2_1_in_rule__LibOperationCS__Group_3_2__14284);
            rule__LibOperationCS__TypeParametersAssignment_3_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_3_2_1()); 
            }

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
    // $ANTLR end rule__LibOperationCS__Group_3_2__1


    // $ANTLR start rule__LibOperationCS__Group_5__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2158:1: rule__LibOperationCS__Group_5__0 : ( ( rule__LibOperationCS__ParametersAssignment_5_0 ) ) rule__LibOperationCS__Group_5__1 ;
    public final void rule__LibOperationCS__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2162:1: ( ( ( rule__LibOperationCS__ParametersAssignment_5_0 ) ) rule__LibOperationCS__Group_5__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2163:1: ( ( rule__LibOperationCS__ParametersAssignment_5_0 ) ) rule__LibOperationCS__Group_5__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2163:1: ( ( rule__LibOperationCS__ParametersAssignment_5_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2164:1: ( rule__LibOperationCS__ParametersAssignment_5_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_5_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2165:1: ( rule__LibOperationCS__ParametersAssignment_5_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2165:2: rule__LibOperationCS__ParametersAssignment_5_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_5_0_in_rule__LibOperationCS__Group_5__04322);
            rule__LibOperationCS__ParametersAssignment_5_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersAssignment_5_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_5__1_in_rule__LibOperationCS__Group_5__04331);
            rule__LibOperationCS__Group_5__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_5__0


    // $ANTLR start rule__LibOperationCS__Group_5__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2176:1: rule__LibOperationCS__Group_5__1 : ( ( rule__LibOperationCS__Group_5_1__0 )* ) ;
    public final void rule__LibOperationCS__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2180:1: ( ( ( rule__LibOperationCS__Group_5_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2181:1: ( ( rule__LibOperationCS__Group_5_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2181:1: ( ( rule__LibOperationCS__Group_5_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2182:1: ( rule__LibOperationCS__Group_5_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_5_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2183:1: ( rule__LibOperationCS__Group_5_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==30) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2183:2: rule__LibOperationCS__Group_5_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_5_1__0_in_rule__LibOperationCS__Group_5__14359);
            	    rule__LibOperationCS__Group_5_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_5_1()); 
            }

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
    // $ANTLR end rule__LibOperationCS__Group_5__1


    // $ANTLR start rule__LibOperationCS__Group_5_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2197:1: rule__LibOperationCS__Group_5_1__0 : ( ',' ) rule__LibOperationCS__Group_5_1__1 ;
    public final void rule__LibOperationCS__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2201:1: ( ( ',' ) rule__LibOperationCS__Group_5_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2202:1: ( ',' ) rule__LibOperationCS__Group_5_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2202:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2203:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group_5_1__04399); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_5_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_5_1__1_in_rule__LibOperationCS__Group_5_1__04409);
            rule__LibOperationCS__Group_5_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibOperationCS__Group_5_1__0


    // $ANTLR start rule__LibOperationCS__Group_5_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2217:1: rule__LibOperationCS__Group_5_1__1 : ( ( rule__LibOperationCS__ParametersAssignment_5_1_1 ) ) ;
    public final void rule__LibOperationCS__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2221:1: ( ( ( rule__LibOperationCS__ParametersAssignment_5_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2222:1: ( ( rule__LibOperationCS__ParametersAssignment_5_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2222:1: ( ( rule__LibOperationCS__ParametersAssignment_5_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2223:1: ( rule__LibOperationCS__ParametersAssignment_5_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_5_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2224:1: ( rule__LibOperationCS__ParametersAssignment_5_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2224:2: rule__LibOperationCS__ParametersAssignment_5_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_5_1_1_in_rule__LibOperationCS__Group_5_1__14437);
            rule__LibOperationCS__ParametersAssignment_5_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersAssignment_5_1_1()); 
            }

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
    // $ANTLR end rule__LibOperationCS__Group_5_1__1


    // $ANTLR start rule__LibPackageCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2238:1: rule__LibPackageCS__Group__0 : ( 'package' ) rule__LibPackageCS__Group__1 ;
    public final void rule__LibPackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2242:1: ( ( 'package' ) rule__LibPackageCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2243:1: ( 'package' ) rule__LibPackageCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2243:1: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2244:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LibPackageCS__Group__04476); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__04486);
            rule__LibPackageCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPackageCS__Group__0


    // $ANTLR start rule__LibPackageCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2258:1: rule__LibPackageCS__Group__1 : ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2 ;
    public final void rule__LibPackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2262:1: ( ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2263:1: ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2263:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2264:1: ( rule__LibPackageCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2265:1: ( rule__LibPackageCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2265:2: rule__LibPackageCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__14514);
            rule__LibPackageCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__14523);
            rule__LibPackageCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPackageCS__Group__1


    // $ANTLR start rule__LibPackageCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2276:1: rule__LibPackageCS__Group__2 : ( '{' ) rule__LibPackageCS__Group__3 ;
    public final void rule__LibPackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2280:1: ( ( '{' ) rule__LibPackageCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2281:1: ( '{' ) rule__LibPackageCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2281:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2282:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibPackageCS__Group__24552); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__24562);
            rule__LibPackageCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPackageCS__Group__2


    // $ANTLR start rule__LibPackageCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2296:1: rule__LibPackageCS__Group__3 : ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4 ;
    public final void rule__LibPackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2300:1: ( ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2301:1: ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2301:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2302:1: ( rule__LibPackageCS__Alternatives_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2303:1: ( rule__LibPackageCS__Alternatives_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==18||LA26_0==22) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2303:2: rule__LibPackageCS__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__34590);
            	    rule__LibPackageCS__Alternatives_3();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__34600);
            rule__LibPackageCS__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPackageCS__Group__3


    // $ANTLR start rule__LibPackageCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2314:1: rule__LibPackageCS__Group__4 : ( '}' ) ;
    public final void rule__LibPackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2318:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2319:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2319:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2320:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibPackageCS__Group__44629); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }

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
    // $ANTLR end rule__LibPackageCS__Group__4


    // $ANTLR start rule__LibParameterCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2343:1: rule__LibParameterCS__Group__0 : ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1 ;
    public final void rule__LibParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2347:1: ( ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2348:1: ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2348:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2349:1: ( rule__LibParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2350:1: ( rule__LibParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2350:2: rule__LibParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__04674);
            rule__LibParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__04683);
            rule__LibParameterCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group__0


    // $ANTLR start rule__LibParameterCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2361:1: rule__LibParameterCS__Group__1 : ( ':' ) rule__LibParameterCS__Group__2 ;
    public final void rule__LibParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2365:1: ( ( ':' ) rule__LibParameterCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2366:1: ( ':' ) rule__LibParameterCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2366:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2367:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibParameterCS__Group__14712); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__14722);
            rule__LibParameterCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group__1


    // $ANTLR start rule__LibParameterCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2381:1: rule__LibParameterCS__Group__2 : ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3 ;
    public final void rule__LibParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2385:1: ( ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2386:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2386:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2387:1: ( rule__LibParameterCS__TypeAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2388:1: ( rule__LibParameterCS__TypeAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2388:2: rule__LibParameterCS__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__24750);
            rule__LibParameterCS__TypeAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__24759);
            rule__LibParameterCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group__2


    // $ANTLR start rule__LibParameterCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2399:1: rule__LibParameterCS__Group__3 : ( ( rule__LibParameterCS__Group_3__0 )? ) ;
    public final void rule__LibParameterCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2403:1: ( ( ( rule__LibParameterCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2404:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2404:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2405:1: ( rule__LibParameterCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2406:1: ( rule__LibParameterCS__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2406:2: rule__LibParameterCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__34787);
                    rule__LibParameterCS__Group_3__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }

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
    // $ANTLR end rule__LibParameterCS__Group__3


    // $ANTLR start rule__LibParameterCS__Group_3__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2424:1: rule__LibParameterCS__Group_3__0 : ( '[' ) rule__LibParameterCS__Group_3__1 ;
    public final void rule__LibParameterCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2428:1: ( ( '[' ) rule__LibParameterCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2429:1: ( '[' ) rule__LibParameterCS__Group_3__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2429:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2430:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__LibParameterCS__Group_3__04831); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__04841);
            rule__LibParameterCS__Group_3__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group_3__0


    // $ANTLR start rule__LibParameterCS__Group_3__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2444:1: rule__LibParameterCS__Group_3__1 : ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2 ;
    public final void rule__LibParameterCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2448:1: ( ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2449:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2449:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2450:1: ( rule__LibParameterCS__Alternatives_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2451:1: ( rule__LibParameterCS__Alternatives_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2451:2: rule__LibParameterCS__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__14869);
            rule__LibParameterCS__Alternatives_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__14878);
            rule__LibParameterCS__Group_3__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group_3__1


    // $ANTLR start rule__LibParameterCS__Group_3__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2462:1: rule__LibParameterCS__Group_3__2 : ( ']' ) ;
    public final void rule__LibParameterCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2466:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2467:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2467:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2468:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,36,FollowSets000.FOLLOW_36_in_rule__LibParameterCS__Group_3__24907); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }

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
    // $ANTLR end rule__LibParameterCS__Group_3__2


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2487:1: rule__LibParameterCS__Group_3_1_0__0 : ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1 ;
    public final void rule__LibParameterCS__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2491:1: ( ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2492:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2492:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2493:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2494:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2494:2: rule__LibParameterCS__LowerAssignment_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__04948);
            rule__LibParameterCS__LowerAssignment_3_1_0_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__04957);
            rule__LibParameterCS__Group_3_1_0__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0__0


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2505:1: rule__LibParameterCS__Group_3_1_0__1 : ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) ;
    public final void rule__LibParameterCS__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2509:1: ( ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2510:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2510:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2511:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2512:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==37) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2512:2: rule__LibParameterCS__Group_3_1_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__14985);
                    rule__LibParameterCS__Group_3_1_0_1__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }

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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0__1


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2526:1: rule__LibParameterCS__Group_3_1_0_1__0 : ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1 ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2530:1: ( ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2531:1: ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2531:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2532:1: '..'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }
            match(input,37,FollowSets000.FOLLOW_37_in_rule__LibParameterCS__Group_3_1_0_1__05025); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__05035);
            rule__LibParameterCS__Group_3_1_0_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0_1__0


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2546:1: rule__LibParameterCS__Group_3_1_0_1__1 : ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2550:1: ( ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2551:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2551:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2552:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2553:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2553:2: rule__LibParameterCS__UpperAssignment_3_1_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__15063);
            rule__LibParameterCS__UpperAssignment_3_1_0_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }

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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0_1__1


    // $ANTLR start rule__LibPropertyCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2567:1: rule__LibPropertyCS__Group__0 : ( ( rule__LibPropertyCS__IsStaticAssignment_0 )? ) rule__LibPropertyCS__Group__1 ;
    public final void rule__LibPropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2571:1: ( ( ( rule__LibPropertyCS__IsStaticAssignment_0 )? ) rule__LibPropertyCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2572:1: ( ( rule__LibPropertyCS__IsStaticAssignment_0 )? ) rule__LibPropertyCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2572:1: ( ( rule__LibPropertyCS__IsStaticAssignment_0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2573:1: ( rule__LibPropertyCS__IsStaticAssignment_0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getIsStaticAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2574:1: ( rule__LibPropertyCS__IsStaticAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==20) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2574:2: rule__LibPropertyCS__IsStaticAssignment_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__IsStaticAssignment_0_in_rule__LibPropertyCS__Group__05101);
                    rule__LibPropertyCS__IsStaticAssignment_0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getIsStaticAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__05111);
            rule__LibPropertyCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__0


    // $ANTLR start rule__LibPropertyCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2585:1: rule__LibPropertyCS__Group__1 : ( 'property' ) rule__LibPropertyCS__Group__2 ;
    public final void rule__LibPropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2589:1: ( ( 'property' ) rule__LibPropertyCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2590:1: ( 'property' ) rule__LibPropertyCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2590:1: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2591:1: 'property'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LibPropertyCS__Group__15140); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__15150);
            rule__LibPropertyCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__1


    // $ANTLR start rule__LibPropertyCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2605:1: rule__LibPropertyCS__Group__2 : ( ( rule__LibPropertyCS__NameAssignment_2 ) ) rule__LibPropertyCS__Group__3 ;
    public final void rule__LibPropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2609:1: ( ( ( rule__LibPropertyCS__NameAssignment_2 ) ) rule__LibPropertyCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2610:1: ( ( rule__LibPropertyCS__NameAssignment_2 ) ) rule__LibPropertyCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2610:1: ( ( rule__LibPropertyCS__NameAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2611:1: ( rule__LibPropertyCS__NameAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2612:1: ( rule__LibPropertyCS__NameAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2612:2: rule__LibPropertyCS__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__NameAssignment_2_in_rule__LibPropertyCS__Group__25178);
            rule__LibPropertyCS__NameAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getNameAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__25187);
            rule__LibPropertyCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__2


    // $ANTLR start rule__LibPropertyCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2623:1: rule__LibPropertyCS__Group__3 : ( ':' ) rule__LibPropertyCS__Group__4 ;
    public final void rule__LibPropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2627:1: ( ( ':' ) rule__LibPropertyCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2628:1: ( ':' ) rule__LibPropertyCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2628:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2629:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_3()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibPropertyCS__Group__35216); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getColonKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__35226);
            rule__LibPropertyCS__Group__4();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__3


    // $ANTLR start rule__LibPropertyCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2643:1: rule__LibPropertyCS__Group__4 : ( ( rule__LibPropertyCS__TypeAssignment_4 ) ) rule__LibPropertyCS__Group__5 ;
    public final void rule__LibPropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2647:1: ( ( ( rule__LibPropertyCS__TypeAssignment_4 ) ) rule__LibPropertyCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2648:1: ( ( rule__LibPropertyCS__TypeAssignment_4 ) ) rule__LibPropertyCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2648:1: ( ( rule__LibPropertyCS__TypeAssignment_4 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2649:1: ( rule__LibPropertyCS__TypeAssignment_4 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2650:1: ( rule__LibPropertyCS__TypeAssignment_4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2650:2: rule__LibPropertyCS__TypeAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__TypeAssignment_4_in_rule__LibPropertyCS__Group__45254);
            rule__LibPropertyCS__TypeAssignment_4();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__45263);
            rule__LibPropertyCS__Group__5();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__4


    // $ANTLR start rule__LibPropertyCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2661:1: rule__LibPropertyCS__Group__5 : ( '=>' ) rule__LibPropertyCS__Group__6 ;
    public final void rule__LibPropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2665:1: ( ( '=>' ) rule__LibPropertyCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2666:1: ( '=>' ) rule__LibPropertyCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2666:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2667:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_5()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibPropertyCS__Group__55292); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__55302);
            rule__LibPropertyCS__Group__6();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__5


    // $ANTLR start rule__LibPropertyCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2681:1: rule__LibPropertyCS__Group__6 : ( ( rule__LibPropertyCS__ClassAssignment_6 ) ) rule__LibPropertyCS__Group__7 ;
    public final void rule__LibPropertyCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2685:1: ( ( ( rule__LibPropertyCS__ClassAssignment_6 ) ) rule__LibPropertyCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2686:1: ( ( rule__LibPropertyCS__ClassAssignment_6 ) ) rule__LibPropertyCS__Group__7
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2686:1: ( ( rule__LibPropertyCS__ClassAssignment_6 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2687:1: ( rule__LibPropertyCS__ClassAssignment_6 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassAssignment_6()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2688:1: ( rule__LibPropertyCS__ClassAssignment_6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2688:2: rule__LibPropertyCS__ClassAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__ClassAssignment_6_in_rule__LibPropertyCS__Group__65330);
            rule__LibPropertyCS__ClassAssignment_6();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getClassAssignment_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__7_in_rule__LibPropertyCS__Group__65339);
            rule__LibPropertyCS__Group__7();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibPropertyCS__Group__6


    // $ANTLR start rule__LibPropertyCS__Group__7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2699:1: rule__LibPropertyCS__Group__7 : ( ';' ) ;
    public final void rule__LibPropertyCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2703:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2704:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2704:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2705:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibPropertyCS__Group__75368); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_7()); 
            }

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
    // $ANTLR end rule__LibPropertyCS__Group__7


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2734:1: rule__LibQualifiedTypeRefCS__Group__0 : ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2738:1: ( ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2739:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2739:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2740:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2741:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2741:2: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__05419);
            rule__LibQualifiedTypeRefCS__NamespaceAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__05428);
            rule__LibQualifiedTypeRefCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__0


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2752:1: rule__LibQualifiedTypeRefCS__Group__1 : ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2756:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2757:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2757:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2758:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2759:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==28) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2759:2: rule__LibQualifiedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__15456);
                    rule__LibQualifiedTypeRefCS__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__15466);
            rule__LibQualifiedTypeRefCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__1


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2770:1: rule__LibQualifiedTypeRefCS__Group__2 : ( '::' ) rule__LibQualifiedTypeRefCS__Group__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:1: ( ( '::' ) rule__LibQualifiedTypeRefCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:1: ( '::' ) rule__LibQualifiedTypeRefCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2776:1: '::'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }
            match(input,38,FollowSets000.FOLLOW_38_in_rule__LibQualifiedTypeRefCS__Group__25495); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__25505);
            rule__LibQualifiedTypeRefCS__Group__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__2


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2790:1: rule__LibQualifiedTypeRefCS__Group__3 : ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2794:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2795:1: ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2795:1: ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2796:1: ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2797:1: ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2797:2: rule__LibQualifiedTypeRefCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__35533);
            rule__LibQualifiedTypeRefCS__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeAssignment_3()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__3


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2815:1: rule__LibQualifiedTypeRefCS__Group_1__0 : ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2819:1: ( ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2820:1: ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2820:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2821:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__05576); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__05586);
            rule__LibQualifiedTypeRefCS__Group_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__0


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2835:1: rule__LibQualifiedTypeRefCS__Group_1__1 : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2839:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2840:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2840:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2841:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2842:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2842:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__15614);
            rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__15623);
            rule__LibQualifiedTypeRefCS__Group_1__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__1


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2853:1: rule__LibQualifiedTypeRefCS__Group_1__2 : ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2857:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2858:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2858:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2859:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2860:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==30) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2860:2: rule__LibQualifiedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__25651);
            	    rule__LibQualifiedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__25661);
            rule__LibQualifiedTypeRefCS__Group_1__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__2


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2871:1: rule__LibQualifiedTypeRefCS__Group_1__3 : ( '>' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2875:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2876:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2876:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2877:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1__35690); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__3


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2898:1: rule__LibQualifiedTypeRefCS__Group_1_2__0 : ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2902:1: ( ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2903:1: ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2903:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2904:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibQualifiedTypeRefCS__Group_1_2__05734); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__05744);
            rule__LibQualifiedTypeRefCS__Group_1_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1_2__0


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2918:1: rule__LibQualifiedTypeRefCS__Group_1_2__1 : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2922:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2923:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2923:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2924:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2925:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2925:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__15772);
            rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1_2__1


    // $ANTLR start rule__LibTypeParameterCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2939:1: rule__LibTypeParameterCS__Group__0 : ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1 ;
    public final void rule__LibTypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2943:1: ( ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2944:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2944:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2945:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2946:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2946:2: rule__LibTypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__05810);
            rule__LibTypeParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__05819);
            rule__LibTypeParameterCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypeParameterCS__Group__0


    // $ANTLR start rule__LibTypeParameterCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2957:1: rule__LibTypeParameterCS__Group__1 : ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__LibTypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2961:1: ( ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2962:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2962:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2963:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2964:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==13||LA32_0==21) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2964:2: rule__LibTypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__15847);
                    rule__LibTypeParameterCS__Alternatives_1();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__Group__1


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2978:1: rule__LibTypeParameterCS__Group_1_0__0 : ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2982:1: ( ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2983:1: ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2983:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2984:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__05887); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__05897);
            rule__LibTypeParameterCS__Group_1_0__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__0


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2998:1: rule__LibTypeParameterCS__Group_1_0__1 : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2 ;
    public final void rule__LibTypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3002:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3003:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3003:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3004:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3005:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3005:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__15925);
            rule__LibTypeParameterCS__ExtendsAssignment_1_0_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__15934);
            rule__LibTypeParameterCS__Group_1_0__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__1


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3016:1: rule__LibTypeParameterCS__Group_1_0__2 : ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3020:1: ( ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3021:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3021:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3022:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3023:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==39) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3023:2: rule__LibTypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__25962);
            	    rule__LibTypeParameterCS__Group_1_0_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__2


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3039:1: rule__LibTypeParameterCS__Group_1_0_2__0 : ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3043:1: ( ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:1: ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3045:1: '&&'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,39,FollowSets000.FOLLOW_39_in_rule__LibTypeParameterCS__Group_1_0_2__06004); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__06014);
            rule__LibTypeParameterCS__Group_1_0_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0_2__0


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3059:1: rule__LibTypeParameterCS__Group_1_0_2__1 : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3063:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3064:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3064:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3065:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3066:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3066:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__16042);
            rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0_2__1


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3080:1: rule__LibTypeParameterCS__Group_1_1__0 : ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1 ;
    public final void rule__LibTypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3084:1: ( ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3085:1: ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3085:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3086:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibTypeParameterCS__Group_1_1__06081); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__06091);
            rule__LibTypeParameterCS__Group_1_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_1__0


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3100:1: rule__LibTypeParameterCS__Group_1_1__1 : ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3106:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3107:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3107:2: rule__LibTypeParameterCS__SuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__16119);
            rule__LibTypeParameterCS__SuperAssignment_1_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_1__1


    // $ANTLR start rule__LibTypedTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3121:1: rule__LibTypedTypeRefCS__Group__0 : ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1 ;
    public final void rule__LibTypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3125:1: ( ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3126:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3126:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3127:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3128:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3128:2: rule__LibTypedTypeRefCS__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__06157);
            rule__LibTypedTypeRefCS__TypeAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__06166);
            rule__LibTypedTypeRefCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group__0


    // $ANTLR start rule__LibTypedTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3139:1: rule__LibTypedTypeRefCS__Group__1 : ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibTypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3143:1: ( ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3144:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3144:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3145:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3146:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3146:2: rule__LibTypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__16194);
                    rule__LibTypedTypeRefCS__Group_1__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group__1


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3160:1: rule__LibTypedTypeRefCS__Group_1__0 : ( '<' ) rule__LibTypedTypeRefCS__Group_1__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3164:1: ( ( '<' ) rule__LibTypedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3165:1: ( '<' ) rule__LibTypedTypeRefCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3165:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3166:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__06234); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__06244);
            rule__LibTypedTypeRefCS__Group_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__0


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3180:1: rule__LibTypedTypeRefCS__Group_1__1 : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2 ;
    public final void rule__LibTypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3184:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3185:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3185:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3186:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3187:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3187:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__16272);
            rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__16281);
            rule__LibTypedTypeRefCS__Group_1__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__1


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3198:1: rule__LibTypedTypeRefCS__Group_1__2 : ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3 ;
    public final void rule__LibTypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3202:1: ( ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3203:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3203:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3204:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3205:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==30) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3205:2: rule__LibTypedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__26309);
            	    rule__LibTypedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__26319);
            rule__LibTypedTypeRefCS__Group_1__3();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__2


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3216:1: rule__LibTypedTypeRefCS__Group_1__3 : ( '>' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3220:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3221:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3221:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3222:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1__36348); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__3


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3243:1: rule__LibTypedTypeRefCS__Group_1_2__0 : ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3247:1: ( ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3248:1: ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3248:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3249:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibTypedTypeRefCS__Group_1_2__06392); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__06402);
            rule__LibTypedTypeRefCS__Group_1_2__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1_2__0


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3263:1: rule__LibTypedTypeRefCS__Group_1_2__1 : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3267:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3268:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3268:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3269:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3270:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3270:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__16430);
            rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1_2__1


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3284:1: rule__LibWildcardTypeRefCS__Group__0 : ( () ) rule__LibWildcardTypeRefCS__Group__1 ;
    public final void rule__LibWildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3288:1: ( ( () ) rule__LibWildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3289:1: ( () ) rule__LibWildcardTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3289:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3290:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3291:1: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3293:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__06478);
            rule__LibWildcardTypeRefCS__Group__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__0


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3304:1: rule__LibWildcardTypeRefCS__Group__1 : ( '?' ) rule__LibWildcardTypeRefCS__Group__2 ;
    public final void rule__LibWildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3308:1: ( ( '?' ) rule__LibWildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3309:1: ( '?' ) rule__LibWildcardTypeRefCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3309:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3310:1: '?'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibWildcardTypeRefCS__Group__16507); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__16517);
            rule__LibWildcardTypeRefCS__Group__2();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__1


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3324:1: rule__LibWildcardTypeRefCS__Group__2 : ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__LibWildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3328:1: ( ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3329:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3329:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3330:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3331:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==13||LA36_0==21) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3331:2: rule__LibWildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__26545);
                    rule__LibWildcardTypeRefCS__Alternatives_2();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__2


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3347:1: rule__LibWildcardTypeRefCS__Group_2_0__0 : ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3351:1: ( ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3352:1: ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3352:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3353:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__06587); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__06597);
            rule__LibWildcardTypeRefCS__Group_2_0__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_0__0


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3367:1: rule__LibWildcardTypeRefCS__Group_2_0__1 : ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3371:1: ( ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3372:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3372:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3373:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3374:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3374:2: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__16625);
            rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_0__1


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: rule__LibWildcardTypeRefCS__Group_2_1__0 : ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3392:1: ( ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3393:1: ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3393:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3394:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibWildcardTypeRefCS__Group_2_1__06664); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__06674);
            rule__LibWildcardTypeRefCS__Group_2_1__1();
            _fsp--;
            if (failed) return ;

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_1__0


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3408:1: rule__LibWildcardTypeRefCS__Group_2_1__1 : ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3412:1: ( ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3413:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3413:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3414:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3415:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3415:2: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__16702);
            rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_1__1


    // $ANTLR start rule__Library__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3430:1: rule__Library__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3434:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3435:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3435:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3436:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_16741);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }

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
    // $ANTLR end rule__Library__NameAssignment_1


    // $ANTLR start rule__Library__ImportsAssignment_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3445:1: rule__Library__ImportsAssignment_2 : ( ruleLibImportCS ) ;
    public final void rule__Library__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3449:1: ( ( ruleLibImportCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3450:1: ( ruleLibImportCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3450:1: ( ruleLibImportCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3451:1: ruleLibImportCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_26772);
            ruleLibImportCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }

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
    // $ANTLR end rule__Library__ImportsAssignment_2


    // $ANTLR start rule__Library__PackagesAssignment_4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3460:1: rule__Library__PackagesAssignment_4 : ( ruleLibPackageCS ) ;
    public final void rule__Library__PackagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3464:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3465:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3465:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3466:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_46803);
            ruleLibPackageCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }

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
    // $ANTLR end rule__Library__PackagesAssignment_4


    // $ANTLR start rule__LibImportCS__NameAssignment_1_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3475:1: rule__LibImportCS__NameAssignment_1_0 : ( ruleIdentifier ) ;
    public final void rule__LibImportCS__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3479:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3480:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3480:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3481:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_06834);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }

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
    // $ANTLR end rule__LibImportCS__NameAssignment_1_0


    // $ANTLR start rule__LibImportCS__NamespaceAssignment_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3490:1: rule__LibImportCS__NamespaceAssignment_2 : ( ( RULE_SINGLE_QUOTED_STRING ) ) ;
    public final void rule__LibImportCS__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3494:1: ( ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3495:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3495:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3497:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3498:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_26869); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }

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
    // $ANTLR end rule__LibImportCS__NamespaceAssignment_2


    // $ANTLR start rule__LibClassCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3509:1: rule__LibClassCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3513:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3514:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3514:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3515:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_16904);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__NameAssignment_1


    // $ANTLR start rule__LibClassCS__TypeParametersAssignment_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3524:1: rule__LibClassCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3528:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3529:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3529:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3530:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_16935);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__TypeParametersAssignment_2_1


    // $ANTLR start rule__LibClassCS__TypeParametersAssignment_2_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3539:1: rule__LibClassCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3543:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3545:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_16966);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__TypeParametersAssignment_2_2_1


    // $ANTLR start rule__LibClassCS__ConformsToAssignment_3_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3554:1: rule__LibClassCS__ConformsToAssignment_3_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3558:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3559:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3559:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3560:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_16997);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__ConformsToAssignment_3_1


    // $ANTLR start rule__LibClassCS__ConformsToAssignment_3_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3569:1: rule__LibClassCS__ConformsToAssignment_3_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3573:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3574:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3574:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3575:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_17028);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__ConformsToAssignment_3_2_1


    // $ANTLR start rule__LibClassCS__IterationsAssignment_5_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3584:1: rule__LibClassCS__IterationsAssignment_5_0 : ( ruleLibIterationCS ) ;
    public final void rule__LibClassCS__IterationsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3588:1: ( ( ruleLibIterationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3589:1: ( ruleLibIterationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3589:1: ( ruleLibIterationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3590:1: ruleLibIterationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_07059);
            ruleLibIterationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__IterationsAssignment_5_0


    // $ANTLR start rule__LibClassCS__OperationsAssignment_5_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3599:1: rule__LibClassCS__OperationsAssignment_5_1 : ( ruleLibOperationCS ) ;
    public final void rule__LibClassCS__OperationsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3603:1: ( ( ruleLibOperationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3604:1: ( ruleLibOperationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3604:1: ( ruleLibOperationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3605:1: ruleLibOperationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_17090);
            ruleLibOperationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__OperationsAssignment_5_1


    // $ANTLR start rule__LibClassCS__StructuralFeaturesAssignment_5_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3614:1: rule__LibClassCS__StructuralFeaturesAssignment_5_2 : ( ruleLibPropertyCS ) ;
    public final void rule__LibClassCS__StructuralFeaturesAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3618:1: ( ( ruleLibPropertyCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3619:1: ( ruleLibPropertyCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3619:1: ( ruleLibPropertyCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3620:1: ruleLibPropertyCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_27121);
            ruleLibPropertyCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0()); 
            }

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
    // $ANTLR end rule__LibClassCS__StructuralFeaturesAssignment_5_2


    // $ANTLR start rule__LibIterationCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3629:1: rule__LibIterationCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibIterationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3633:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3634:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3634:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3635:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibIterationCS__NameAssignment_17152);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__NameAssignment_1


    // $ANTLR start rule__LibIterationCS__IteratorsAssignment_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3644:1: rule__LibIterationCS__IteratorsAssignment_3 : ( ruleIdentifier ) ;
    public final void rule__LibIterationCS__IteratorsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3648:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3649:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3649:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3650:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibIterationCS__IteratorsAssignment_37183);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_3_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__IteratorsAssignment_3


    // $ANTLR start rule__LibIterationCS__IteratorsAssignment_4_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3659:1: rule__LibIterationCS__IteratorsAssignment_4_1 : ( ruleIdentifier ) ;
    public final void rule__LibIterationCS__IteratorsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3663:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3664:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3664:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3665:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_4_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibIterationCS__IteratorsAssignment_4_17214);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsIdentifierParserRuleCall_4_1_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__IteratorsAssignment_4_1


    // $ANTLR start rule__LibIterationCS__IteratorsAssignment_5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3674:1: rule__LibIterationCS__IteratorsAssignment_5 : ( ( '...' ) ) ;
    public final void rule__LibIterationCS__IteratorsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3678:1: ( ( ( '...' ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3679:1: ( ( '...' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3679:1: ( ( '...' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3680:1: ( '...' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsFullStopFullStopFullStopKeyword_5_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3681:1: ( '...' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3682:1: '...'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIteratorsFullStopFullStopFullStopKeyword_5_0()); 
            }
            match(input,40,FollowSets000.FOLLOW_40_in_rule__LibIterationCS__IteratorsAssignment_57250); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsFullStopFullStopFullStopKeyword_5_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIteratorsFullStopFullStopFullStopKeyword_5_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__IteratorsAssignment_5


    // $ANTLR start rule__LibIterationCS__TypeAssignment_8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3697:1: rule__LibIterationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibIterationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3701:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3702:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3702:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3703:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_87289);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__TypeAssignment_8


    // $ANTLR start rule__LibIterationCS__ClassAssignment_10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3712:1: rule__LibIterationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibIterationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3716:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3717:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3717:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3718:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_107320); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }

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
    // $ANTLR end rule__LibIterationCS__ClassAssignment_10


    // $ANTLR start rule__LibOperationCS__IsStaticAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3727:1: rule__LibOperationCS__IsStaticAssignment_0 : ( ( 'static' ) ) ;
    public final void rule__LibOperationCS__IsStaticAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3731:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3732:1: ( ( 'static' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3732:1: ( ( 'static' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3733:1: ( 'static' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3734:1: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3735:1: 'static'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibOperationCS__IsStaticAssignment_07356); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getIsStaticStaticKeyword_0_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__IsStaticAssignment_0


    // $ANTLR start rule__LibOperationCS__NameAssignment_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3750:1: rule__LibOperationCS__NameAssignment_2 : ( ruleIdentifier ) ;
    public final void rule__LibOperationCS__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3754:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3755:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3755:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3756:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameIdentifierParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibOperationCS__NameAssignment_27395);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getNameIdentifierParserRuleCall_2_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__NameAssignment_2


    // $ANTLR start rule__LibOperationCS__TypeParametersAssignment_3_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3765:1: rule__LibOperationCS__TypeParametersAssignment_3_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3769:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3770:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3770:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3771:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_3_17426);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_1_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__TypeParametersAssignment_3_1


    // $ANTLR start rule__LibOperationCS__TypeParametersAssignment_3_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3780:1: rule__LibOperationCS__TypeParametersAssignment_3_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3784:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3785:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3785:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3786:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_3_2_17457);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_3_2_1_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__TypeParametersAssignment_3_2_1


    // $ANTLR start rule__LibOperationCS__ParametersAssignment_5_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3795:1: rule__LibOperationCS__ParametersAssignment_5_0 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3799:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3800:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3800:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3801:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_5_07488);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_0_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__ParametersAssignment_5_0


    // $ANTLR start rule__LibOperationCS__ParametersAssignment_5_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3810:1: rule__LibOperationCS__ParametersAssignment_5_1_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3814:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3815:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3815:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3816:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_5_1_17519);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_1_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__ParametersAssignment_5_1_1


    // $ANTLR start rule__LibOperationCS__TypeAssignment_8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3825:1: rule__LibOperationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibOperationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3829:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3830:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3830:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3831:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_87550);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__TypeAssignment_8


    // $ANTLR start rule__LibOperationCS__ClassAssignment_10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3840:1: rule__LibOperationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibOperationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3844:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3845:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3845:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3846:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_107581); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }

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
    // $ANTLR end rule__LibOperationCS__ClassAssignment_10


    // $ANTLR start rule__LibPackageCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3855:1: rule__LibPackageCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibPackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3859:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3860:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3860:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3861:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_17612);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }

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
    // $ANTLR end rule__LibPackageCS__NameAssignment_1


    // $ANTLR start rule__LibPackageCS__SubpackagesAssignment_3_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3870:1: rule__LibPackageCS__SubpackagesAssignment_3_0 : ( ruleLibPackageCS ) ;
    public final void rule__LibPackageCS__SubpackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3874:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3875:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3875:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3876:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_07643);
            ruleLibPackageCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }

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
    // $ANTLR end rule__LibPackageCS__SubpackagesAssignment_3_0


    // $ANTLR start rule__LibPackageCS__ClassifiersAssignment_3_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3885:1: rule__LibPackageCS__ClassifiersAssignment_3_1 : ( ruleLibClassifierCS ) ;
    public final void rule__LibPackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3889:1: ( ( ruleLibClassifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3890:1: ( ruleLibClassifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3890:1: ( ruleLibClassifierCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3891:1: ruleLibClassifierCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_17674);
            ruleLibClassifierCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }

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
    // $ANTLR end rule__LibPackageCS__ClassifiersAssignment_3_1


    // $ANTLR start rule__LibParameterCS__NameAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3900:1: rule__LibParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3904:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3905:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3905:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3906:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_07705);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }

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
    // $ANTLR end rule__LibParameterCS__NameAssignment_0


    // $ANTLR start rule__LibParameterCS__TypeAssignment_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3915:1: rule__LibParameterCS__TypeAssignment_2 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibParameterCS__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3919:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3920:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3920:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3921:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_27736);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }

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
    // $ANTLR end rule__LibParameterCS__TypeAssignment_2


    // $ANTLR start rule__LibParameterCS__LowerAssignment_3_1_0_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3930:1: rule__LibParameterCS__LowerAssignment_3_1_0_0 : ( ruleLOWER ) ;
    public final void rule__LibParameterCS__LowerAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3934:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3935:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3935:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3936:1: ruleLOWER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_07767);
            ruleLOWER();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }

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
    // $ANTLR end rule__LibParameterCS__LowerAssignment_3_1_0_0


    // $ANTLR start rule__LibParameterCS__UpperAssignment_3_1_0_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3945:1: rule__LibParameterCS__UpperAssignment_3_1_0_1_1 : ( ruleUPPER ) ;
    public final void rule__LibParameterCS__UpperAssignment_3_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3949:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3950:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3950:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3951:1: ruleUPPER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_17798);
            ruleUPPER();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }

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
    // $ANTLR end rule__LibParameterCS__UpperAssignment_3_1_0_1_1


    // $ANTLR start rule__LibParameterCS__MultiplicityAssignment_3_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3960:1: rule__LibParameterCS__MultiplicityAssignment_3_1_1 : ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) ;
    public final void rule__LibParameterCS__MultiplicityAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3964:1: ( ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3965:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3965:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3966:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3967:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3967:2: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_17829);
            rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }

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
    // $ANTLR end rule__LibParameterCS__MultiplicityAssignment_3_1_1


    // $ANTLR start rule__LibPropertyCS__IsStaticAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3976:1: rule__LibPropertyCS__IsStaticAssignment_0 : ( ( 'static' ) ) ;
    public final void rule__LibPropertyCS__IsStaticAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3980:1: ( ( ( 'static' ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3981:1: ( ( 'static' ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3981:1: ( ( 'static' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3982:1: ( 'static' )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3983:1: ( 'static' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3984:1: 'static'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibPropertyCS__IsStaticAssignment_07867); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getIsStaticStaticKeyword_0_0()); 
            }

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
    // $ANTLR end rule__LibPropertyCS__IsStaticAssignment_0


    // $ANTLR start rule__LibPropertyCS__NameAssignment_2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3999:1: rule__LibPropertyCS__NameAssignment_2 : ( ruleIdentifier ) ;
    public final void rule__LibPropertyCS__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4003:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4004:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4004:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4005:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameIdentifierParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPropertyCS__NameAssignment_27906);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getNameIdentifierParserRuleCall_2_0()); 
            }

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
    // $ANTLR end rule__LibPropertyCS__NameAssignment_2


    // $ANTLR start rule__LibPropertyCS__TypeAssignment_4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4014:1: rule__LibPropertyCS__TypeAssignment_4 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibPropertyCS__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4018:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4019:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4019:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4020:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_47937);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_4_0()); 
            }

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
    // $ANTLR end rule__LibPropertyCS__TypeAssignment_4


    // $ANTLR start rule__LibPropertyCS__ClassAssignment_6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4029:1: rule__LibPropertyCS__ClassAssignment_6 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibPropertyCS__ClassAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4033:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4034:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4034:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4035:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_6_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_67968); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_6_0()); 
            }

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
    // $ANTLR end rule__LibPropertyCS__ClassAssignment_6


    // $ANTLR start rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4044:1: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibQualifiedTypeRefCS__NamespaceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4048:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4049:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4049:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4050:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4051:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4052:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_08003);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__NamespaceAssignment_0


    // $ANTLR start rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4063:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4067:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4068:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4068:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4069:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_18038);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1


    // $ANTLR start rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4078:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4083:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4083:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4084:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_18069);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1


    // $ANTLR start rule__LibQualifiedTypeRefCS__TypeAssignment_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4093:1: rule__LibQualifiedTypeRefCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4097:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4098:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4098:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4099:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__TypeAssignment_38100);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }

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
    // $ANTLR end rule__LibQualifiedTypeRefCS__TypeAssignment_3


    // $ANTLR start rule__LibTypeParameterCS__NameAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4108:1: rule__LibTypeParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibTypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4112:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4113:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4113:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4114:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_08131);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__NameAssignment_0


    // $ANTLR start rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4123:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4127:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4128:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4128:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4129:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_18162);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__ExtendsAssignment_1_0_1


    // $ANTLR start rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4138:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4142:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4143:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4143:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4144:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_18193);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1


    // $ANTLR start rule__LibTypeParameterCS__SuperAssignment_1_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4153:1: rule__LibTypeParameterCS__SuperAssignment_1_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__SuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4157:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4158:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4158:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4159:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_18224);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }

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
    // $ANTLR end rule__LibTypeParameterCS__SuperAssignment_1_1_1


    // $ANTLR start rule__LibTypedTypeRefCS__TypeAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4168:1: rule__LibTypedTypeRefCS__TypeAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibTypedTypeRefCS__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4172:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4173:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4173:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4174:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4175:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4176:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_08259);
            ruleIdentifier();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__TypeAssignment_0


    // $ANTLR start rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4187:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4191:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4192:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4192:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4193:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_18294);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1


    // $ANTLR start rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4202:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4206:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4207:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4207:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4208:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_18325);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }

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
    // $ANTLR end rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1


    // $ANTLR start rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4217:1: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4221:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4222:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4222:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4223:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_18356);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1


    // $ANTLR start rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4232:1: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4236:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4237:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4237:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4238:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_18387);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }

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
    // $ANTLR end rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1

    // $ANTLR start synpred21
    public final void synpred21_fragment() throws RecognitionException {   
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ( ruleLibQualifiedTypeRefCS ) )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ruleLibQualifiedTypeRefCS )
        {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:851:1: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211806);
        ruleLibQualifiedTypeRefCS();
        _fsp--;
        if (failed) return ;

        }


        }
    }
    // $ANTLR end synpred21

    public final boolean synpred21() {
        backtracking++;
        int start = input.mark();
        try {
            synpred21_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibrary74 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__0_in_ruleLibrary100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER127 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UPPER__Alternatives_in_ruleUPPER219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier246 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Identifier__Alternatives_in_ruleIdentifier279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS308 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS607 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS727 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS787 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS847 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__UPPER__Alternatives1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_TERMINAL_in_rule__Identifier__Alternatives1208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Identifier__Alternatives1226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Identifier__Alternatives1246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Identifier__Alternatives1266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Identifier__Alternatives1286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Identifier__Alternatives1306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Identifier__Alternatives1326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Identifier__Alternatives1346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Identifier__Alternatives1366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Identifier__Alternatives1386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Identifier__Alternatives1406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Identifier__Alternatives1426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_21855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_21873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Library__Group__01909 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__01919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__11947 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__11956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__21984 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__21994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Library__Group__32023 = new BitSet(new long[]{0x0000000004040000L});
        public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__42061 = new BitSet(new long[]{0x0000000004040000L});
        public static final BitSet FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Library__Group__52100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__LibImportCS__Group__02150 = new BitSet(new long[]{0x00000000007FF060L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__12188 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__22226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__02266 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibImportCS__Group_1__12304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LibClassCS__Group__02344 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__12382 = new BitSet(new long[]{0x0000000012001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__22419 = new BitSet(new long[]{0x0000000002001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__32457 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibClassCS__Group__42496 = new BitSet(new long[]{0x00000000041A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__52534 = new BitSet(new long[]{0x00000000041A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibClassCS__Group__62573 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibClassCS__Group_2__02623 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__02633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__12661 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__12670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__22698 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__22708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_2__32737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibClassCS__Group_2_2__02781 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__02791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__12819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LibClassCS__Group_3__02858 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__02868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__12896 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__12905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__22933 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__LibClassCS__Group_3_2__02975 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__02985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__13013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__LibIterationCS__Group__03052 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__13090 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibIterationCS__Group__23128 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__IteratorsAssignment_3_in_rule__LibIterationCS__Group__33166 = new BitSet(new long[]{0x0000010140000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_4__0_in_rule__LibIterationCS__Group__43203 = new BitSet(new long[]{0x0000010140000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__43213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__IteratorsAssignment_5_in_rule__LibIterationCS__Group__53241 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__53251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibIterationCS__Group__63280 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__63290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibIterationCS__Group__73319 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__73329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__83357 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__83366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibIterationCS__Group__93395 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__93405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__103433 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__103442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibIterationCS__Group__113471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibIterationCS__Group_4__03531 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_4__1_in_rule__LibIterationCS__Group_4__03541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__IteratorsAssignment_4_1_in_rule__LibIterationCS__Group_4__13569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__IsStaticAssignment_0_in_rule__LibOperationCS__Group__03607 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__03617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__LibOperationCS__Group__13646 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__13656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__NameAssignment_2_in_rule__LibOperationCS__Group__23684 = new BitSet(new long[]{0x0000000090000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__23693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3__0_in_rule__LibOperationCS__Group__33721 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__33731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibOperationCS__Group__43760 = new BitSet(new long[]{0x00000001007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__43770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_5__0_in_rule__LibOperationCS__Group__53798 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__53808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibOperationCS__Group__63837 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__63847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibOperationCS__Group__73876 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__73886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeAssignment_8_in_rule__LibOperationCS__Group__83914 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__83923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibOperationCS__Group__93952 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__93962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ClassAssignment_10_in_rule__LibOperationCS__Group__103990 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__11_in_rule__LibOperationCS__Group__103999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibOperationCS__Group__114028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibOperationCS__Group_3__04088 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3__1_in_rule__LibOperationCS__Group_3__04098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_3_1_in_rule__LibOperationCS__Group_3__14126 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3__2_in_rule__LibOperationCS__Group_3__14135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3_2__0_in_rule__LibOperationCS__Group_3__24163 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3__3_in_rule__LibOperationCS__Group_3__24173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_3__34202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group_3_2__04246 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_3_2__1_in_rule__LibOperationCS__Group_3_2__04256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_3_2_1_in_rule__LibOperationCS__Group_3_2__14284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_5_0_in_rule__LibOperationCS__Group_5__04322 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_5__1_in_rule__LibOperationCS__Group_5__04331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_5_1__0_in_rule__LibOperationCS__Group_5__14359 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group_5_1__04399 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_5_1__1_in_rule__LibOperationCS__Group_5_1__04409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_5_1_1_in_rule__LibOperationCS__Group_5_1__14437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LibPackageCS__Group__04476 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__04486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__14514 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__14523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibPackageCS__Group__24552 = new BitSet(new long[]{0x0000000004440000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__24562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__34590 = new BitSet(new long[]{0x0000000004440000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__34600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibPackageCS__Group__44629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__04674 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__04683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibParameterCS__Group__14712 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__14722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__24750 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__24759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__34787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__LibParameterCS__Group_3__04831 = new BitSet(new long[]{0x0000000001800810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__04841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__14869 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__14878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__LibParameterCS__Group_3__24907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__04948 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__04957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__14985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__LibParameterCS__Group_3_1_0_1__05025 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__05035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__15063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__IsStaticAssignment_0_in_rule__LibPropertyCS__Group__05101 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__05111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LibPropertyCS__Group__15140 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__15150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__NameAssignment_2_in_rule__LibPropertyCS__Group__25178 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__25187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibPropertyCS__Group__35216 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__35226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__TypeAssignment_4_in_rule__LibPropertyCS__Group__45254 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__45263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibPropertyCS__Group__55292 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__55302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__ClassAssignment_6_in_rule__LibPropertyCS__Group__65330 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__7_in_rule__LibPropertyCS__Group__65339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibPropertyCS__Group__75368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__05419 = new BitSet(new long[]{0x0000004010000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__05428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__15456 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__15466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__LibQualifiedTypeRefCS__Group__25495 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__25505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__35533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__05576 = new BitSet(new long[]{0x00000000017FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__05586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__15614 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__15623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__25651 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__25661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1__35690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibQualifiedTypeRefCS__Group_1_2__05734 = new BitSet(new long[]{0x00000000017FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__05744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__15772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__05810 = new BitSet(new long[]{0x0000000000202002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__05819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__15847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__05887 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__05897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__15925 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__15934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__25962 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_39_in_rule__LibTypeParameterCS__Group_1_0_2__06004 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__06014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__16042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibTypeParameterCS__Group_1_1__06081 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__06091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__16119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__06157 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__06166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__16194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__06234 = new BitSet(new long[]{0x00000000017FF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__06244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__16272 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__16281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__26309 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__26319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1__36348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibTypedTypeRefCS__Group_1_2__06392 = new BitSet(new long[]{0x00000000017FF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__06402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__16430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__06478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibWildcardTypeRefCS__Group__16507 = new BitSet(new long[]{0x0000000000202002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__16517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__26545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__06587 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__06597 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__16625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibWildcardTypeRefCS__Group_2_1__06664 = new BitSet(new long[]{0x00000000007FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__06674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__16702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_16741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_26772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_46803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_06834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_26869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_16904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_16935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_16966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_16997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_17028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_07059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_17090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_27121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibIterationCS__NameAssignment_17152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibIterationCS__IteratorsAssignment_37183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibIterationCS__IteratorsAssignment_4_17214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__LibIterationCS__IteratorsAssignment_57250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_87289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_107320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibOperationCS__IsStaticAssignment_07356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibOperationCS__NameAssignment_27395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_3_17426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_3_2_17457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_5_07488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_5_1_17519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_87550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_107581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_17612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_07643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_17674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_07705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_27736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_07767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_17798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_17829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibPropertyCS__IsStaticAssignment_07867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPropertyCS__NameAssignment_27906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_47937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_67968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_08003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_18038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_18069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__TypeAssignment_38100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_08131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_18162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_18193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_18224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_08259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_18294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_18325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_18356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_18387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211806 = new BitSet(new long[]{0x0000000000000002L});
    }


}