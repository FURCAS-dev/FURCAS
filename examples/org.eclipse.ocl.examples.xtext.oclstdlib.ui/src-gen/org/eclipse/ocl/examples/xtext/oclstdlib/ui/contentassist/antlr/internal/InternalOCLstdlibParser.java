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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID_TERMINAL", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'library'", "'operation'", "'package'", "'property'", "'super'", "'type'", "'+'", "'?'", "'{'", "'}'", "':'", "'<'", "'>'", "','", "'('", "')'", "'=>'", "';'", "'['", "']'", "'..'", "'::'", "'&&'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID_TERMINAL=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int RULE_SL_COMMENT=9;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[274+1];
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


    // $ANTLR start entryRuleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:173:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:174:1: ( ruleName EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:175:1: ruleName EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_entryRuleName306);
            ruleName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleName313); if (failed) return ;

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
    // $ANTLR end entryRuleName


    // $ANTLR start ruleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:182:1: ruleName : ( ( rule__Name__Alternatives ) ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:186:2: ( ( ( rule__Name__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:187:1: ( ( rule__Name__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:187:1: ( ( rule__Name__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:1: ( rule__Name__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNameAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:1: ( rule__Name__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:2: rule__Name__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Name__Alternatives_in_ruleName339);
            rule__Name__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getNameAccess().getAlternatives()); 
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
    // $ANTLR end ruleName


    // $ANTLR start entryRuleLibImportCS
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:201:1: entryRuleLibImportCS : ruleLibImportCS EOF ;
    public final void entryRuleLibImportCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:202:1: ( ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:203:1: ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS366);
            ruleLibImportCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS373); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:210:1: ruleLibImportCS : ( ( rule__LibImportCS__Group__0 ) ) ;
    public final void ruleLibImportCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:214:2: ( ( ( rule__LibImportCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:215:1: ( ( rule__LibImportCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:215:1: ( ( rule__LibImportCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:1: ( rule__LibImportCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:1: ( rule__LibImportCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:2: rule__LibImportCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS399);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:229:1: entryRuleLibClassCS : ruleLibClassCS EOF ;
    public final void entryRuleLibClassCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:230:1: ( ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:231:1: ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS426);
            ruleLibClassCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS433); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:238:1: ruleLibClassCS : ( ( rule__LibClassCS__Group__0 ) ) ;
    public final void ruleLibClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:242:2: ( ( ( rule__LibClassCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:243:1: ( ( rule__LibClassCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:243:1: ( ( rule__LibClassCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:1: ( rule__LibClassCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:1: ( rule__LibClassCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:2: rule__LibClassCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS459);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:257:1: entryRuleLibClassifierCS : ruleLibClassifierCS EOF ;
    public final void entryRuleLibClassifierCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:258:1: ( ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:259:1: ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS486);
            ruleLibClassifierCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassifierCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS493); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:266:1: ruleLibClassifierCS : ( ruleLibClassCS ) ;
    public final void ruleLibClassifierCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:270:2: ( ( ruleLibClassCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:271:1: ( ruleLibClassCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:271:1: ( ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:1: ruleLibClassCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS519);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:285:1: entryRuleLibIterationCS : ruleLibIterationCS EOF ;
    public final void entryRuleLibIterationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:286:1: ( ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:287:1: ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS545);
            ruleLibIterationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS552); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:294:1: ruleLibIterationCS : ( ( rule__LibIterationCS__Group__0 ) ) ;
    public final void ruleLibIterationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:298:2: ( ( ( rule__LibIterationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:299:1: ( ( rule__LibIterationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:299:1: ( ( rule__LibIterationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:1: ( rule__LibIterationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:1: ( rule__LibIterationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:2: rule__LibIterationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS578);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:313:1: entryRuleLibOperationCS : ruleLibOperationCS EOF ;
    public final void entryRuleLibOperationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:314:1: ( ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:315:1: ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS605);
            ruleLibOperationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS612); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:322:1: ruleLibOperationCS : ( ( rule__LibOperationCS__Group__0 ) ) ;
    public final void ruleLibOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:326:2: ( ( ( rule__LibOperationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:327:1: ( ( rule__LibOperationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:327:1: ( ( rule__LibOperationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:1: ( rule__LibOperationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:1: ( rule__LibOperationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:2: rule__LibOperationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS638);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:341:1: entryRuleLibPackageCS : ruleLibPackageCS EOF ;
    public final void entryRuleLibPackageCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:342:1: ( ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:343:1: ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS665);
            ruleLibPackageCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS672); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:350:1: ruleLibPackageCS : ( ( rule__LibPackageCS__Group__0 ) ) ;
    public final void ruleLibPackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:354:2: ( ( ( rule__LibPackageCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:355:1: ( ( rule__LibPackageCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:355:1: ( ( rule__LibPackageCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:1: ( rule__LibPackageCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:1: ( rule__LibPackageCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:2: rule__LibPackageCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS698);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:369:1: entryRuleLibParameterCS : ruleLibParameterCS EOF ;
    public final void entryRuleLibParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:370:1: ( ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:371:1: ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS725);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS732); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:378:1: ruleLibParameterCS : ( ( rule__LibParameterCS__Group__0 ) ) ;
    public final void ruleLibParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:382:2: ( ( ( rule__LibParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:383:1: ( ( rule__LibParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:383:1: ( ( rule__LibParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:1: ( rule__LibParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:1: ( rule__LibParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:2: rule__LibParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS758);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:397:1: entryRuleLibPropertyCS : ruleLibPropertyCS EOF ;
    public final void entryRuleLibPropertyCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:398:1: ( ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:399:1: ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS785);
            ruleLibPropertyCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS792); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:406:1: ruleLibPropertyCS : ( ( rule__LibPropertyCS__Group__0 ) ) ;
    public final void ruleLibPropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:410:2: ( ( ( rule__LibPropertyCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:411:1: ( ( rule__LibPropertyCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:411:1: ( ( rule__LibPropertyCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:1: ( rule__LibPropertyCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:1: ( rule__LibPropertyCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:2: rule__LibPropertyCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS818);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:425:1: entryRuleLibQualifiedTypeRefCS : ruleLibQualifiedTypeRefCS EOF ;
    public final void entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:426:1: ( ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:427:1: ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS845);
            ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS852); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:434:1: ruleLibQualifiedTypeRefCS : ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibQualifiedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:438:2: ( ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:439:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:439:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:2: rule__LibQualifiedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS878);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:453:1: entryRuleLibTypeParameterCS : ruleLibTypeParameterCS EOF ;
    public final void entryRuleLibTypeParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:454:1: ( ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:455:1: ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS905);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS912); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:462:1: ruleLibTypeParameterCS : ( ( rule__LibTypeParameterCS__Group__0 ) ) ;
    public final void ruleLibTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:466:2: ( ( ( rule__LibTypeParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:467:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:467:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:1: ( rule__LibTypeParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:1: ( rule__LibTypeParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:2: rule__LibTypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS938);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:481:1: entryRuleLibTypeRefCS : ruleLibTypeRefCS EOF ;
    public final void entryRuleLibTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:482:1: ( ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:483:1: ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS965);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS972); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:490:1: ruleLibTypeRefCS : ( ( rule__LibTypeRefCS__Alternatives ) ) ;
    public final void ruleLibTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:494:2: ( ( ( rule__LibTypeRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:495:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:495:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:1: ( rule__LibTypeRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:1: ( rule__LibTypeRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:2: rule__LibTypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS998);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:509:1: entryRuleLibTypedRefCS : ruleLibTypedRefCS EOF ;
    public final void entryRuleLibTypedRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:510:1: ( ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:511:1: ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS1025);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS1032); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:518:1: ruleLibTypedRefCS : ( ( rule__LibTypedRefCS__Alternatives ) ) ;
    public final void ruleLibTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:522:2: ( ( ( rule__LibTypedRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:523:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:523:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:1: ( rule__LibTypedRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:1: ( rule__LibTypedRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:2: rule__LibTypedRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1058);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:537:1: entryRuleLibTypedTypeRefCS : ruleLibTypedTypeRefCS EOF ;
    public final void entryRuleLibTypedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:538:1: ( ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:539:1: ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1085);
            ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1092); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:546:1: ruleLibTypedTypeRefCS : ( ( rule__LibTypedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:550:2: ( ( ( rule__LibTypedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:551:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:551:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:1: ( rule__LibTypedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:1: ( rule__LibTypedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:2: rule__LibTypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1118);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:565:1: entryRuleLibWildcardTypeRefCS : ruleLibWildcardTypeRefCS EOF ;
    public final void entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:566:1: ( ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:567:1: ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1145);
            ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1152); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:574:1: ruleLibWildcardTypeRefCS : ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleLibWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:578:2: ( ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:579:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:579:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:580:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:581:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:581:2: rule__LibWildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1178);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:593:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:597:1: ( ( RULE_INT ) | ( '*' ) )
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
                    new NoViableAltException("593:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:598:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:598:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:599:1: RULE_INT
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1214); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:604:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:604:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:605:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__UPPER__Alternatives1232); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:617:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );
    public final void rule__Identifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:621:1: ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) )
            int alt2=11;
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
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("617:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:622:1: ( RULE_ID_TERMINAL )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:622:1: ( RULE_ID_TERMINAL )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:623:1: RULE_ID_TERMINAL
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getID_TERMINALTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID_TERMINAL,FollowSets000.FOLLOW_RULE_ID_TERMINAL_in_rule__Identifier__Alternatives1266); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getID_TERMINALTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:628:6: ( 'conformsTo' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:628:6: ( 'conformsTo' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:629:1: 'conformsTo'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getConformsToKeyword_1()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Identifier__Alternatives1284); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getConformsToKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:636:6: ( 'extends' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:636:6: ( 'extends' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:637:1: 'extends'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getExtendsKeyword_2()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Identifier__Alternatives1304); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getExtendsKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:644:6: ( 'import' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:644:6: ( 'import' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:645:1: 'import'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getImportKeyword_3()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__Identifier__Alternatives1324); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getImportKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:652:6: ( 'iteration' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:652:6: ( 'iteration' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:653:1: 'iteration'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getIterationKeyword_4()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Identifier__Alternatives1344); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getIterationKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:660:6: ( 'library' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:660:6: ( 'library' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:661:1: 'library'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getLibraryKeyword_5()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Identifier__Alternatives1364); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getLibraryKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:668:6: ( 'operation' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:668:6: ( 'operation' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:669:1: 'operation'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getOperationKeyword_6()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__Identifier__Alternatives1384); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getOperationKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:676:6: ( 'package' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:676:6: ( 'package' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:677:1: 'package'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getPackageKeyword_7()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__Identifier__Alternatives1404); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getPackageKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:684:6: ( 'property' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:684:6: ( 'property' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:685:1: 'property'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getPropertyKeyword_8()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__Identifier__Alternatives1424); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getPropertyKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:692:6: ( 'super' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:692:6: ( 'super' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:693:1: 'super'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getSuperKeyword_9()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__Identifier__Alternatives1444); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getSuperKeyword_9()); 
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:700:6: ( 'type' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:700:6: ( 'type' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:701:1: 'type'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getTypeKeyword_10()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__Identifier__Alternatives1464); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getTypeKeyword_10()); 
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


    // $ANTLR start rule__Name__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:713:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );
    public final void rule__Name__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:717:1: ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID_TERMINAL||(LA3_0>=12 && LA3_0<=21)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_DOUBLE_QUOTED_STRING) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("713:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:718:1: ( ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:718:1: ( ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:719:1: ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Name__Alternatives1498);
                    ruleIdentifier();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:724:6: ( RULE_DOUBLE_QUOTED_STRING )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:724:6: ( RULE_DOUBLE_QUOTED_STRING )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:725:1: RULE_DOUBLE_QUOTED_STRING
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); 
                    }
                    match(input,RULE_DOUBLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_rule__Name__Alternatives1515); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); 
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
    // $ANTLR end rule__Name__Alternatives


    // $ANTLR start rule__LibClassCS__Alternatives_5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:735:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );
    public final void rule__LibClassCS__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:739:1: ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 19:
                {
                alt4=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("735:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:740:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:740:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:741:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getIterationsAssignment_5_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:742:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:742:2: rule__LibClassCS__IterationsAssignment_5_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51547);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:746:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:746:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:747:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:748:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:748:2: rule__LibClassCS__OperationsAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51565);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:752:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:752:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:753:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_2()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:754:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:754:2: rule__LibClassCS__StructuralFeaturesAssignment_5_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51583);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:763:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__LibPackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:767:1: ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==21) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("763:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:768:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:768:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:769:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:770:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:770:2: rule__LibPackageCS__SubpackagesAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31616);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:774:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:774:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:775:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:776:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:776:2: rule__LibPackageCS__ClassifiersAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31634);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:785:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );
    public final void rule__LibParameterCS__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:789:1: ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INT) ) {
                alt6=1;
            }
            else if ( (LA6_0==11||(LA6_0>=22 && LA6_0<=23)) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("785:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:790:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:790:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:792:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:792:2: rule__LibParameterCS__Group_3_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11667);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:796:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:796:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:797:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:798:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:798:2: rule__LibParameterCS__MultiplicityAssignment_3_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11685);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:807:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:811:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt7=1;
                }
                break;
            case 22:
                {
                alt7=2;
                }
                break;
            case 23:
                {
                alt7=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("807:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01719); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:820:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:820:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:821:1: '+'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01739); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:828:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:828:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:1: '?'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01759); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:841:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__LibTypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:845:1: ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("841:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:846:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:846:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:847:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:848:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:848:2: rule__LibTypeParameterCS__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11793);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:852:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:852:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:853:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:854:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:854:2: rule__LibTypeParameterCS__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11811);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:863:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );
    public final void rule__LibTypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:867:1: ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID_TERMINAL||(LA9_0>=12 && LA9_0<=21)) ) {
                alt9=1;
            }
            else if ( (LA9_0==23) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("863:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:868:1: ( ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:868:1: ( ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:869:1: ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1844);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:6: ( ruleLibWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:6: ( ruleLibWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:875:1: ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1861);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );
    public final void rule__LibTypedRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:889:1: ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case RULE_ID_TERMINAL:
                {
                int LA10_1 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA10_2 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA10_3 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA10_4 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 4, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA10_5 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 5, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA10_6 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 6, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA10_7 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 7, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA10_8 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 8, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA10_9 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 9, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA10_10 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 10, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA10_11 = input.LA(2);

                if ( (synpred21()) ) {
                    alt10=1;
                }
                else if ( (true) ) {
                    alt10=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("885:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ruleLibQualifiedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ruleLibQualifiedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1893);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:896:6: ( ruleLibTypedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:896:6: ( ruleLibTypedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:1: ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1910);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:907:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__LibWildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:911:1: ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==13) ) {
                alt11=1;
            }
            else if ( (LA11_0==20) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("907:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:912:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:912:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:914:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:914:2: rule__LibWildcardTypeRefCS__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_21942);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:918:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:918:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:919:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:920:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:920:2: rule__LibWildcardTypeRefCS__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_21960);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:931:1: rule__Library__Group__0 : ( 'library' ) rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ( 'library' ) rule__Library__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ( 'library' ) rule__Library__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:937:1: 'library'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Library__Group__01996); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02006);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: rule__Library__Group__1 : ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:955:1: ( ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:956:1: ( ( rule__Library__NameAssignment_1 ) ) rule__Library__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:956:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:957:1: ( rule__Library__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:958:1: ( rule__Library__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:958:2: rule__Library__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__12034);
            rule__Library__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12043);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:969:1: rule__Library__Group__2 : ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:973:1: ( ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:974:1: ( ( rule__Library__ImportsAssignment_2 )* ) rule__Library__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:974:1: ( ( rule__Library__ImportsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:975:1: ( rule__Library__ImportsAssignment_2 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:976:1: ( rule__Library__ImportsAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:976:2: rule__Library__ImportsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__22071);
            	    rule__Library__ImportsAssignment_2();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22081);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:987:1: rule__Library__Group__3 : ( '{' ) rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:991:1: ( ( '{' ) rule__Library__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:992:1: ( '{' ) rule__Library__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:992:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:993:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Library__Group__32110); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32120);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1007:1: rule__Library__Group__4 : ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5 ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1011:1: ( ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1012:1: ( ( rule__Library__PackagesAssignment_4 )* ) rule__Library__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1012:1: ( ( rule__Library__PackagesAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1013:1: ( rule__Library__PackagesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1014:1: ( rule__Library__PackagesAssignment_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1014:2: rule__Library__PackagesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__42148);
            	    rule__Library__PackagesAssignment_4();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42158);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1025:1: rule__Library__Group__5 : ( '}' ) ;
    public final void rule__Library__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1029:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1030:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1030:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1031:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Library__Group__52187); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1056:1: rule__LibImportCS__Group__0 : ( 'import' ) rule__LibImportCS__Group__1 ;
    public final void rule__LibImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1060:1: ( ( 'import' ) rule__LibImportCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1061:1: ( 'import' ) rule__LibImportCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1061:1: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1062:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__LibImportCS__Group__02235); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02245);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1076:1: rule__LibImportCS__Group__1 : ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2 ;
    public final void rule__LibImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1080:1: ( ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1081:1: ( ( rule__LibImportCS__Group_1__0 )? ) rule__LibImportCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1081:1: ( ( rule__LibImportCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1082:1: ( rule__LibImportCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1083:1: ( rule__LibImportCS__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID_TERMINAL||(LA14_0>=12 && LA14_0<=21)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1083:2: rule__LibImportCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__12273);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12283);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1094:1: rule__LibImportCS__Group__2 : ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) ;
    public final void rule__LibImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1098:1: ( ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1099:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1099:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1100:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1101:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1101:2: rule__LibImportCS__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__22311);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1117:1: rule__LibImportCS__Group_1__0 : ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1 ;
    public final void rule__LibImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1121:1: ( ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1122:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) ) rule__LibImportCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1122:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1123:1: ( rule__LibImportCS__NameAssignment_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1124:1: ( rule__LibImportCS__NameAssignment_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1124:2: rule__LibImportCS__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__02351);
            rule__LibImportCS__NameAssignment_1_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02360);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1135:1: rule__LibImportCS__Group_1__1 : ( ':' ) ;
    public final void rule__LibImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1139:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1141:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibImportCS__Group_1__12389); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1158:1: rule__LibClassCS__Group__0 : ( 'type' ) rule__LibClassCS__Group__1 ;
    public final void rule__LibClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1162:1: ( ( 'type' ) rule__LibClassCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1163:1: ( 'type' ) rule__LibClassCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1163:1: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1164:1: 'type'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibClassCS__Group__02429); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02439);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1178:1: rule__LibClassCS__Group__1 : ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2 ;
    public final void rule__LibClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1182:1: ( ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: ( ( rule__LibClassCS__NameAssignment_1 ) ) rule__LibClassCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1184:1: ( rule__LibClassCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1185:1: ( rule__LibClassCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1185:2: rule__LibClassCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__12467);
            rule__LibClassCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12476);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1196:1: rule__LibClassCS__Group__2 : ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3 ;
    public final void rule__LibClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1200:1: ( ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1201:1: ( ( rule__LibClassCS__Group_2__0 )? ) rule__LibClassCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1201:1: ( ( rule__LibClassCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1202:1: ( rule__LibClassCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1203:1: ( rule__LibClassCS__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1203:2: rule__LibClassCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__22504);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22514);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1214:1: rule__LibClassCS__Group__3 : ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4 ;
    public final void rule__LibClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1218:1: ( ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1219:1: ( ( rule__LibClassCS__Group_3__0 )? ) rule__LibClassCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1219:1: ( ( rule__LibClassCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1220:1: ( rule__LibClassCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1221:1: ( rule__LibClassCS__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==12) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1221:2: rule__LibClassCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__32542);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32552);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1232:1: rule__LibClassCS__Group__4 : ( '{' ) rule__LibClassCS__Group__5 ;
    public final void rule__LibClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1236:1: ( ( '{' ) rule__LibClassCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1237:1: ( '{' ) rule__LibClassCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1237:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1238:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibClassCS__Group__42581); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42591);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1252:1: rule__LibClassCS__Group__5 : ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6 ;
    public final void rule__LibClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1256:1: ( ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1257:1: ( ( rule__LibClassCS__Alternatives_5 )* ) rule__LibClassCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1257:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1258:1: ( rule__LibClassCS__Alternatives_5 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1259:1: ( rule__LibClassCS__Alternatives_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15||LA17_0==17||LA17_0==19) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1259:2: rule__LibClassCS__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__52619);
            	    rule__LibClassCS__Alternatives_5();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52629);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1270:1: rule__LibClassCS__Group__6 : ( '}' ) ;
    public final void rule__LibClassCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1274:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1275:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1275:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1276:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibClassCS__Group__62658); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1303:1: rule__LibClassCS__Group_2__0 : ( '<' ) rule__LibClassCS__Group_2__1 ;
    public final void rule__LibClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1307:1: ( ( '<' ) rule__LibClassCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1308:1: ( '<' ) rule__LibClassCS__Group_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1308:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1309:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibClassCS__Group_2__02708); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__02718);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1323:1: rule__LibClassCS__Group_2__1 : ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2 ;
    public final void rule__LibClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1327:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1328:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) rule__LibClassCS__Group_2__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1328:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1329:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1330:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1330:2: rule__LibClassCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__12746);
            rule__LibClassCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__12755);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1341:1: rule__LibClassCS__Group_2__2 : ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3 ;
    public final void rule__LibClassCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1345:1: ( ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1346:1: ( ( rule__LibClassCS__Group_2_2__0 )* ) rule__LibClassCS__Group_2__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1346:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1347:1: ( rule__LibClassCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1348:1: ( rule__LibClassCS__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1348:2: rule__LibClassCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__22783);
            	    rule__LibClassCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__22793);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1359:1: rule__LibClassCS__Group_2__3 : ( '>' ) ;
    public final void rule__LibClassCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1363:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1364:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1364:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1365:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibClassCS__Group_2__32822); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1386:1: rule__LibClassCS__Group_2_2__0 : ( ',' ) rule__LibClassCS__Group_2_2__1 ;
    public final void rule__LibClassCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1390:1: ( ( ',' ) rule__LibClassCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1391:1: ( ',' ) rule__LibClassCS__Group_2_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1391:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1392:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_2_2__02866); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__02876);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1406:1: rule__LibClassCS__Group_2_2__1 : ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1410:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1411:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1411:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1412:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1413:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1413:2: rule__LibClassCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__12904);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1427:1: rule__LibClassCS__Group_3__0 : ( 'conformsTo' ) rule__LibClassCS__Group_3__1 ;
    public final void rule__LibClassCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1431:1: ( ( 'conformsTo' ) rule__LibClassCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:1: ( 'conformsTo' ) rule__LibClassCS__Group_3__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:1: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1433:1: 'conformsTo'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__LibClassCS__Group_3__02943); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__02953);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1447:1: rule__LibClassCS__Group_3__1 : ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2 ;
    public final void rule__LibClassCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1451:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1452:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) rule__LibClassCS__Group_3__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1452:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1453:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1454:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1454:2: rule__LibClassCS__ConformsToAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__12981);
            rule__LibClassCS__ConformsToAssignment_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__12990);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1465:1: rule__LibClassCS__Group_3__2 : ( ( rule__LibClassCS__Group_3_2__0 )* ) ;
    public final void rule__LibClassCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1469:1: ( ( ( rule__LibClassCS__Group_3_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1470:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1470:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1471:1: ( rule__LibClassCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1472:1: ( rule__LibClassCS__Group_3_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1472:2: rule__LibClassCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__23018);
            	    rule__LibClassCS__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1488:1: rule__LibClassCS__Group_3_2__0 : ( ',' ) rule__LibClassCS__Group_3_2__1 ;
    public final void rule__LibClassCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1492:1: ( ( ',' ) rule__LibClassCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1493:1: ( ',' ) rule__LibClassCS__Group_3_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1493:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1494:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_3_2__03060); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03070);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1508:1: rule__LibClassCS__Group_3_2__1 : ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) ;
    public final void rule__LibClassCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1512:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1513:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1513:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1514:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1515:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1515:2: rule__LibClassCS__ConformsToAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__13098);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1529:1: rule__LibIterationCS__Group__0 : ( 'iteration' ) rule__LibIterationCS__Group__1 ;
    public final void rule__LibIterationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1533:1: ( ( 'iteration' ) rule__LibIterationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( 'iteration' ) rule__LibIterationCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1535:1: 'iteration'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__LibIterationCS__Group__03137); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03147);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1549:1: rule__LibIterationCS__Group__1 : ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2 ;
    public final void rule__LibIterationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1553:1: ( ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1554:1: ( ( rule__LibIterationCS__NameAssignment_1 ) ) rule__LibIterationCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1554:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1555:1: ( rule__LibIterationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1556:1: ( rule__LibIterationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1556:2: rule__LibIterationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__13175);
            rule__LibIterationCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13184);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1567:1: rule__LibIterationCS__Group__2 : ( ( rule__LibIterationCS__Group_2__0 )? ) rule__LibIterationCS__Group__3 ;
    public final void rule__LibIterationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1571:1: ( ( ( rule__LibIterationCS__Group_2__0 )? ) rule__LibIterationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1572:1: ( ( rule__LibIterationCS__Group_2__0 )? ) rule__LibIterationCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1572:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1573:1: ( rule__LibIterationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:1: ( rule__LibIterationCS__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:2: rule__LibIterationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__23212);
                    rule__LibIterationCS__Group_2__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGroup_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23222);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1585:1: rule__LibIterationCS__Group__3 : ( '(' ) rule__LibIterationCS__Group__4 ;
    public final void rule__LibIterationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1589:1: ( ( '(' ) rule__LibIterationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1590:1: ( '(' ) rule__LibIterationCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1590:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1591:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibIterationCS__Group__33251); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33261);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1605:1: rule__LibIterationCS__Group__4 : ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) rule__LibIterationCS__Group__5 ;
    public final void rule__LibIterationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1609:1: ( ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) rule__LibIterationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1610:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) rule__LibIterationCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1610:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1611:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1612:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1612:2: rule__LibIterationCS__ParametersAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__43289);
            rule__LibIterationCS__ParametersAssignment_4();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__43298);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1623:1: rule__LibIterationCS__Group__5 : ( ( rule__LibIterationCS__Group_5__0 )* ) rule__LibIterationCS__Group__6 ;
    public final void rule__LibIterationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1627:1: ( ( ( rule__LibIterationCS__Group_5__0 )* ) rule__LibIterationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1628:1: ( ( rule__LibIterationCS__Group_5__0 )* ) rule__LibIterationCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1628:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1629:1: ( rule__LibIterationCS__Group_5__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1630:1: ( rule__LibIterationCS__Group_5__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1630:2: rule__LibIterationCS__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__53326);
            	    rule__LibIterationCS__Group_5__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGroup_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__53336);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1641:1: rule__LibIterationCS__Group__6 : ( ')' ) rule__LibIterationCS__Group__7 ;
    public final void rule__LibIterationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1645:1: ( ( ')' ) rule__LibIterationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1646:1: ( ')' ) rule__LibIterationCS__Group__7
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1646:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1647:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibIterationCS__Group__63365); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__63375);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1661:1: rule__LibIterationCS__Group__7 : ( ':' ) rule__LibIterationCS__Group__8 ;
    public final void rule__LibIterationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1665:1: ( ( ':' ) rule__LibIterationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1666:1: ( ':' ) rule__LibIterationCS__Group__8
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1666:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1667:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibIterationCS__Group__73404); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__73414);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1681:1: rule__LibIterationCS__Group__8 : ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9 ;
    public final void rule__LibIterationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1685:1: ( ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1686:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) ) rule__LibIterationCS__Group__9
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1686:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1687:1: ( rule__LibIterationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1688:1: ( rule__LibIterationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1688:2: rule__LibIterationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__83442);
            rule__LibIterationCS__TypeAssignment_8();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__83451);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1699:1: rule__LibIterationCS__Group__9 : ( '=>' ) rule__LibIterationCS__Group__10 ;
    public final void rule__LibIterationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1703:1: ( ( '=>' ) rule__LibIterationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: ( '=>' ) rule__LibIterationCS__Group__10
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1705:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibIterationCS__Group__93480); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__93490);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1719:1: rule__LibIterationCS__Group__10 : ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11 ;
    public final void rule__LibIterationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1723:1: ( ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1724:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) ) rule__LibIterationCS__Group__11
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1724:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1725:1: ( rule__LibIterationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1726:1: ( rule__LibIterationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1726:2: rule__LibIterationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__103518);
            rule__LibIterationCS__ClassAssignment_10();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__103527);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1737:1: rule__LibIterationCS__Group__11 : ( ';' ) ;
    public final void rule__LibIterationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1741:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1742:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1742:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1743:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibIterationCS__Group__113556); if (failed) return ;
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


    // $ANTLR start rule__LibIterationCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1780:1: rule__LibIterationCS__Group_2__0 : ( '<' ) rule__LibIterationCS__Group_2__1 ;
    public final void rule__LibIterationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1784:1: ( ( '<' ) rule__LibIterationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1785:1: ( '<' ) rule__LibIterationCS__Group_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1785:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1786:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibIterationCS__Group_2__03616); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__03626);
            rule__LibIterationCS__Group_2__1();
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
    // $ANTLR end rule__LibIterationCS__Group_2__0


    // $ANTLR start rule__LibIterationCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1800:1: rule__LibIterationCS__Group_2__1 : ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) rule__LibIterationCS__Group_2__2 ;
    public final void rule__LibIterationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1804:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) rule__LibIterationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1805:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) rule__LibIterationCS__Group_2__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1805:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1806:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1807:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1807:2: rule__LibIterationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__13654);
            rule__LibIterationCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__13663);
            rule__LibIterationCS__Group_2__2();
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
    // $ANTLR end rule__LibIterationCS__Group_2__1


    // $ANTLR start rule__LibIterationCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1818:1: rule__LibIterationCS__Group_2__2 : ( ( rule__LibIterationCS__Group_2_2__0 )* ) rule__LibIterationCS__Group_2__3 ;
    public final void rule__LibIterationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1822:1: ( ( ( rule__LibIterationCS__Group_2_2__0 )* ) rule__LibIterationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1823:1: ( ( rule__LibIterationCS__Group_2_2__0 )* ) rule__LibIterationCS__Group_2__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1823:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1824:1: ( rule__LibIterationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1825:1: ( rule__LibIterationCS__Group_2_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1825:2: rule__LibIterationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__23691);
            	    rule__LibIterationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGroup_2_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__23701);
            rule__LibIterationCS__Group_2__3();
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
    // $ANTLR end rule__LibIterationCS__Group_2__2


    // $ANTLR start rule__LibIterationCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1836:1: rule__LibIterationCS__Group_2__3 : ( '>' ) ;
    public final void rule__LibIterationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1840:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1841:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1841:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1842:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibIterationCS__Group_2__33730); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3()); 
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
    // $ANTLR end rule__LibIterationCS__Group_2__3


    // $ANTLR start rule__LibIterationCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1863:1: rule__LibIterationCS__Group_2_2__0 : ( ',' ) rule__LibIterationCS__Group_2_2__1 ;
    public final void rule__LibIterationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1867:1: ( ( ',' ) rule__LibIterationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1868:1: ( ',' ) rule__LibIterationCS__Group_2_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1868:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1869:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_2_2__03774); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__03784);
            rule__LibIterationCS__Group_2_2__1();
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
    // $ANTLR end rule__LibIterationCS__Group_2_2__0


    // $ANTLR start rule__LibIterationCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1883:1: rule__LibIterationCS__Group_2_2__1 : ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1887:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1888:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1888:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1889:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1890:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1890:2: rule__LibIterationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__13812);
            rule__LibIterationCS__TypeParametersAssignment_2_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_2_1()); 
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
    // $ANTLR end rule__LibIterationCS__Group_2_2__1


    // $ANTLR start rule__LibIterationCS__Group_5__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1904:1: rule__LibIterationCS__Group_5__0 : ( ',' ) rule__LibIterationCS__Group_5__1 ;
    public final void rule__LibIterationCS__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1908:1: ( ( ',' ) rule__LibIterationCS__Group_5__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1909:1: ( ',' ) rule__LibIterationCS__Group_5__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1909:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1910:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_5__03851); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__03861);
            rule__LibIterationCS__Group_5__1();
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
    // $ANTLR end rule__LibIterationCS__Group_5__0


    // $ANTLR start rule__LibIterationCS__Group_5__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1924:1: rule__LibIterationCS__Group_5__1 : ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) ;
    public final void rule__LibIterationCS__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1928:1: ( ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1929:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1929:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1930:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_5_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1931:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1931:2: rule__LibIterationCS__ParametersAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__13889);
            rule__LibIterationCS__ParametersAssignment_5_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getParametersAssignment_5_1()); 
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
    // $ANTLR end rule__LibIterationCS__Group_5__1


    // $ANTLR start rule__LibOperationCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1945:1: rule__LibOperationCS__Group__0 : ( 'operation' ) rule__LibOperationCS__Group__1 ;
    public final void rule__LibOperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1949:1: ( ( 'operation' ) rule__LibOperationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1950:1: ( 'operation' ) rule__LibOperationCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1950:1: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1951:1: 'operation'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__LibOperationCS__Group__03928); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__03938);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1965:1: rule__LibOperationCS__Group__1 : ( ( rule__LibOperationCS__NameAssignment_1 ) ) rule__LibOperationCS__Group__2 ;
    public final void rule__LibOperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1969:1: ( ( ( rule__LibOperationCS__NameAssignment_1 ) ) rule__LibOperationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1970:1: ( ( rule__LibOperationCS__NameAssignment_1 ) ) rule__LibOperationCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1970:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1971:1: ( rule__LibOperationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1972:1: ( rule__LibOperationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1972:2: rule__LibOperationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__13966);
            rule__LibOperationCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__13975);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1983:1: rule__LibOperationCS__Group__2 : ( ( rule__LibOperationCS__Group_2__0 )? ) rule__LibOperationCS__Group__3 ;
    public final void rule__LibOperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1987:1: ( ( ( rule__LibOperationCS__Group_2__0 )? ) rule__LibOperationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:1: ( ( rule__LibOperationCS__Group_2__0 )? ) rule__LibOperationCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1989:1: ( rule__LibOperationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1990:1: ( rule__LibOperationCS__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1990:2: rule__LibOperationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__24003);
                    rule__LibOperationCS__Group_2__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__24013);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2001:1: rule__LibOperationCS__Group__3 : ( '(' ) rule__LibOperationCS__Group__4 ;
    public final void rule__LibOperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2005:1: ( ( '(' ) rule__LibOperationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2006:1: ( '(' ) rule__LibOperationCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2006:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2007:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group__34042); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__34052);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2021:1: rule__LibOperationCS__Group__4 : ( ( rule__LibOperationCS__Group_4__0 )? ) rule__LibOperationCS__Group__5 ;
    public final void rule__LibOperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2025:1: ( ( ( rule__LibOperationCS__Group_4__0 )? ) rule__LibOperationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2026:1: ( ( rule__LibOperationCS__Group_4__0 )? ) rule__LibOperationCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2026:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2027:1: ( rule__LibOperationCS__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2028:1: ( rule__LibOperationCS__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID_TERMINAL||(LA24_0>=12 && LA24_0<=21)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2028:2: rule__LibOperationCS__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__44080);
                    rule__LibOperationCS__Group_4__0();
                    _fsp--;
                    if (failed) return ;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__44090);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2039:1: rule__LibOperationCS__Group__5 : ( ')' ) rule__LibOperationCS__Group__6 ;
    public final void rule__LibOperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2043:1: ( ( ')' ) rule__LibOperationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2044:1: ( ')' ) rule__LibOperationCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2044:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2045:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibOperationCS__Group__54119); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__54129);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2059:1: rule__LibOperationCS__Group__6 : ( ':' ) rule__LibOperationCS__Group__7 ;
    public final void rule__LibOperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2063:1: ( ( ':' ) rule__LibOperationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2064:1: ( ':' ) rule__LibOperationCS__Group__7
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2064:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2065:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibOperationCS__Group__64158); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__64168);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2079:1: rule__LibOperationCS__Group__7 : ( ( rule__LibOperationCS__TypeAssignment_7 ) ) rule__LibOperationCS__Group__8 ;
    public final void rule__LibOperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2083:1: ( ( ( rule__LibOperationCS__TypeAssignment_7 ) ) rule__LibOperationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2084:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) ) rule__LibOperationCS__Group__8
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2084:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2085:1: ( rule__LibOperationCS__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2086:1: ( rule__LibOperationCS__TypeAssignment_7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2086:2: rule__LibOperationCS__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__74196);
            rule__LibOperationCS__TypeAssignment_7();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__74205);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2097:1: rule__LibOperationCS__Group__8 : ( '=>' ) rule__LibOperationCS__Group__9 ;
    public final void rule__LibOperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2101:1: ( ( '=>' ) rule__LibOperationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2102:1: ( '=>' ) rule__LibOperationCS__Group__9
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2102:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2103:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibOperationCS__Group__84234); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__84244);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2117:1: rule__LibOperationCS__Group__9 : ( ( rule__LibOperationCS__ClassAssignment_9 ) ) rule__LibOperationCS__Group__10 ;
    public final void rule__LibOperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2121:1: ( ( ( rule__LibOperationCS__ClassAssignment_9 ) ) rule__LibOperationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) ) rule__LibOperationCS__Group__10
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2123:1: ( rule__LibOperationCS__ClassAssignment_9 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2124:1: ( rule__LibOperationCS__ClassAssignment_9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2124:2: rule__LibOperationCS__ClassAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__94272);
            rule__LibOperationCS__ClassAssignment_9();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__94281);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2135:1: rule__LibOperationCS__Group__10 : ( ';' ) ;
    public final void rule__LibOperationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2139:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2140:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2140:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2141:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibOperationCS__Group__104310); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10()); 
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
    // $ANTLR end rule__LibOperationCS__Group__10


    // $ANTLR start rule__LibOperationCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2176:1: rule__LibOperationCS__Group_2__0 : ( '<' ) rule__LibOperationCS__Group_2__1 ;
    public final void rule__LibOperationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2180:1: ( ( '<' ) rule__LibOperationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2181:1: ( '<' ) rule__LibOperationCS__Group_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2181:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2182:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibOperationCS__Group_2__04368); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__04378);
            rule__LibOperationCS__Group_2__1();
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
    // $ANTLR end rule__LibOperationCS__Group_2__0


    // $ANTLR start rule__LibOperationCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2196:1: rule__LibOperationCS__Group_2__1 : ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) rule__LibOperationCS__Group_2__2 ;
    public final void rule__LibOperationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2200:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) rule__LibOperationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2201:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) rule__LibOperationCS__Group_2__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2201:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2202:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2203:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2203:2: rule__LibOperationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__14406);
            rule__LibOperationCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__14415);
            rule__LibOperationCS__Group_2__2();
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
    // $ANTLR end rule__LibOperationCS__Group_2__1


    // $ANTLR start rule__LibOperationCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2214:1: rule__LibOperationCS__Group_2__2 : ( ( rule__LibOperationCS__Group_2_2__0 )* ) rule__LibOperationCS__Group_2__3 ;
    public final void rule__LibOperationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2218:1: ( ( ( rule__LibOperationCS__Group_2_2__0 )* ) rule__LibOperationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2219:1: ( ( rule__LibOperationCS__Group_2_2__0 )* ) rule__LibOperationCS__Group_2__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2219:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2220:1: ( rule__LibOperationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2221:1: ( rule__LibOperationCS__Group_2_2__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2221:2: rule__LibOperationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__24443);
            	    rule__LibOperationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_2_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__24453);
            rule__LibOperationCS__Group_2__3();
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
    // $ANTLR end rule__LibOperationCS__Group_2__2


    // $ANTLR start rule__LibOperationCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2232:1: rule__LibOperationCS__Group_2__3 : ( '>' ) ;
    public final void rule__LibOperationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2236:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2237:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2237:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2238:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibOperationCS__Group_2__34482); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3()); 
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
    // $ANTLR end rule__LibOperationCS__Group_2__3


    // $ANTLR start rule__LibOperationCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2259:1: rule__LibOperationCS__Group_2_2__0 : ( ',' ) rule__LibOperationCS__Group_2_2__1 ;
    public final void rule__LibOperationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2263:1: ( ( ',' ) rule__LibOperationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2264:1: ( ',' ) rule__LibOperationCS__Group_2_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2264:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2265:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_2_2__04526); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__04536);
            rule__LibOperationCS__Group_2_2__1();
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
    // $ANTLR end rule__LibOperationCS__Group_2_2__0


    // $ANTLR start rule__LibOperationCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2279:1: rule__LibOperationCS__Group_2_2__1 : ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2283:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2284:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2284:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2285:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2286:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2286:2: rule__LibOperationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__14564);
            rule__LibOperationCS__TypeParametersAssignment_2_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_2_1()); 
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
    // $ANTLR end rule__LibOperationCS__Group_2_2__1


    // $ANTLR start rule__LibOperationCS__Group_4__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2300:1: rule__LibOperationCS__Group_4__0 : ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) rule__LibOperationCS__Group_4__1 ;
    public final void rule__LibOperationCS__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2304:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) rule__LibOperationCS__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2305:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) rule__LibOperationCS__Group_4__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2305:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2306:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2307:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2307:2: rule__LibOperationCS__ParametersAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__04602);
            rule__LibOperationCS__ParametersAssignment_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__04611);
            rule__LibOperationCS__Group_4__1();
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
    // $ANTLR end rule__LibOperationCS__Group_4__0


    // $ANTLR start rule__LibOperationCS__Group_4__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2318:1: rule__LibOperationCS__Group_4__1 : ( ( rule__LibOperationCS__Group_4_1__0 )* ) ;
    public final void rule__LibOperationCS__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2322:1: ( ( ( rule__LibOperationCS__Group_4_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2323:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2323:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2324:1: ( rule__LibOperationCS__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2325:1: ( rule__LibOperationCS__Group_4_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==29) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2325:2: rule__LibOperationCS__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__14639);
            	    rule__LibOperationCS__Group_4_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getGroup_4_1()); 
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
    // $ANTLR end rule__LibOperationCS__Group_4__1


    // $ANTLR start rule__LibOperationCS__Group_4_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2339:1: rule__LibOperationCS__Group_4_1__0 : ( ',' ) rule__LibOperationCS__Group_4_1__1 ;
    public final void rule__LibOperationCS__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2343:1: ( ( ',' ) rule__LibOperationCS__Group_4_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2344:1: ( ',' ) rule__LibOperationCS__Group_4_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2344:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2345:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_4_1__04679); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__04689);
            rule__LibOperationCS__Group_4_1__1();
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
    // $ANTLR end rule__LibOperationCS__Group_4_1__0


    // $ANTLR start rule__LibOperationCS__Group_4_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2359:1: rule__LibOperationCS__Group_4_1__1 : ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__LibOperationCS__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2363:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2364:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2364:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2365:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2366:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2366:2: rule__LibOperationCS__ParametersAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__14717);
            rule__LibOperationCS__ParametersAssignment_4_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_1_1()); 
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
    // $ANTLR end rule__LibOperationCS__Group_4_1__1


    // $ANTLR start rule__LibPackageCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2380:1: rule__LibPackageCS__Group__0 : ( 'package' ) rule__LibPackageCS__Group__1 ;
    public final void rule__LibPackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2384:1: ( ( 'package' ) rule__LibPackageCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2385:1: ( 'package' ) rule__LibPackageCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2385:1: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2386:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LibPackageCS__Group__04756); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__04766);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2400:1: rule__LibPackageCS__Group__1 : ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2 ;
    public final void rule__LibPackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2404:1: ( ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2405:1: ( ( rule__LibPackageCS__NameAssignment_1 ) ) rule__LibPackageCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2405:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2406:1: ( rule__LibPackageCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2407:1: ( rule__LibPackageCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2407:2: rule__LibPackageCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__14794);
            rule__LibPackageCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__14803);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2418:1: rule__LibPackageCS__Group__2 : ( '{' ) rule__LibPackageCS__Group__3 ;
    public final void rule__LibPackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2422:1: ( ( '{' ) rule__LibPackageCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2423:1: ( '{' ) rule__LibPackageCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2423:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2424:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibPackageCS__Group__24832); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__24842);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2438:1: rule__LibPackageCS__Group__3 : ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4 ;
    public final void rule__LibPackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2442:1: ( ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2443:1: ( ( rule__LibPackageCS__Alternatives_3 )* ) rule__LibPackageCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2443:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2444:1: ( rule__LibPackageCS__Alternatives_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2445:1: ( rule__LibPackageCS__Alternatives_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==18||LA27_0==21) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2445:2: rule__LibPackageCS__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__34870);
            	    rule__LibPackageCS__Alternatives_3();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__34880);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2456:1: rule__LibPackageCS__Group__4 : ( '}' ) ;
    public final void rule__LibPackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2460:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2461:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2461:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2462:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibPackageCS__Group__44909); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2485:1: rule__LibParameterCS__Group__0 : ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1 ;
    public final void rule__LibParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2489:1: ( ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2490:1: ( ( rule__LibParameterCS__NameAssignment_0 ) ) rule__LibParameterCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2490:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2491:1: ( rule__LibParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2492:1: ( rule__LibParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2492:2: rule__LibParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__04954);
            rule__LibParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__04963);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2503:1: rule__LibParameterCS__Group__1 : ( ':' ) rule__LibParameterCS__Group__2 ;
    public final void rule__LibParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2507:1: ( ( ':' ) rule__LibParameterCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2508:1: ( ':' ) rule__LibParameterCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2508:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2509:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibParameterCS__Group__14992); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__15002);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2523:1: rule__LibParameterCS__Group__2 : ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3 ;
    public final void rule__LibParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2527:1: ( ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2528:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) ) rule__LibParameterCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2528:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2529:1: ( rule__LibParameterCS__TypeAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2530:1: ( rule__LibParameterCS__TypeAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2530:2: rule__LibParameterCS__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__25030);
            rule__LibParameterCS__TypeAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__25039);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2541:1: rule__LibParameterCS__Group__3 : ( ( rule__LibParameterCS__Group_3__0 )? ) ;
    public final void rule__LibParameterCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2545:1: ( ( ( rule__LibParameterCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2546:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2546:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2547:1: ( rule__LibParameterCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2548:1: ( rule__LibParameterCS__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2548:2: rule__LibParameterCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__35067);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2566:1: rule__LibParameterCS__Group_3__0 : ( '[' ) rule__LibParameterCS__Group_3__1 ;
    public final void rule__LibParameterCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2570:1: ( ( '[' ) rule__LibParameterCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2571:1: ( '[' ) rule__LibParameterCS__Group_3__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2571:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2572:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibParameterCS__Group_3__05111); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__05121);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2586:1: rule__LibParameterCS__Group_3__1 : ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2 ;
    public final void rule__LibParameterCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2590:1: ( ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2591:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) ) rule__LibParameterCS__Group_3__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2591:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2592:1: ( rule__LibParameterCS__Alternatives_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2593:1: ( rule__LibParameterCS__Alternatives_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2593:2: rule__LibParameterCS__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__15149);
            rule__LibParameterCS__Alternatives_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__15158);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2604:1: rule__LibParameterCS__Group_3__2 : ( ']' ) ;
    public final void rule__LibParameterCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2608:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2609:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2609:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2610:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__LibParameterCS__Group_3__25187); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2629:1: rule__LibParameterCS__Group_3_1_0__0 : ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1 ;
    public final void rule__LibParameterCS__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2633:1: ( ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2634:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) rule__LibParameterCS__Group_3_1_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2634:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2635:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2636:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2636:2: rule__LibParameterCS__LowerAssignment_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__05228);
            rule__LibParameterCS__LowerAssignment_3_1_0_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__05237);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2647:1: rule__LibParameterCS__Group_3_1_0__1 : ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) ;
    public final void rule__LibParameterCS__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2651:1: ( ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2652:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2652:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2653:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2654:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2654:2: rule__LibParameterCS__Group_3_1_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__15265);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2668:1: rule__LibParameterCS__Group_3_1_0_1__0 : ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1 ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2672:1: ( ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2673:1: ( '..' ) rule__LibParameterCS__Group_3_1_0_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2673:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2674:1: '..'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__05305); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__05315);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2688:1: rule__LibParameterCS__Group_3_1_0_1__1 : ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2692:1: ( ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2693:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2693:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2694:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2695:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2695:2: rule__LibParameterCS__UpperAssignment_3_1_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__15343);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2709:1: rule__LibPropertyCS__Group__0 : ( 'property' ) rule__LibPropertyCS__Group__1 ;
    public final void rule__LibPropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2713:1: ( ( 'property' ) rule__LibPropertyCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2714:1: ( 'property' ) rule__LibPropertyCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2714:1: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2715:1: 'property'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LibPropertyCS__Group__05382); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__05392);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2729:1: rule__LibPropertyCS__Group__1 : ( ( rule__LibPropertyCS__NameAssignment_1 ) ) rule__LibPropertyCS__Group__2 ;
    public final void rule__LibPropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2733:1: ( ( ( rule__LibPropertyCS__NameAssignment_1 ) ) rule__LibPropertyCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2734:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) ) rule__LibPropertyCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2734:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2735:1: ( rule__LibPropertyCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2736:1: ( rule__LibPropertyCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2736:2: rule__LibPropertyCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__15420);
            rule__LibPropertyCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__15429);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2747:1: rule__LibPropertyCS__Group__2 : ( ':' ) rule__LibPropertyCS__Group__3 ;
    public final void rule__LibPropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2751:1: ( ( ':' ) rule__LibPropertyCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2752:1: ( ':' ) rule__LibPropertyCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2752:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2753:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibPropertyCS__Group__25458); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__25468);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2767:1: rule__LibPropertyCS__Group__3 : ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) rule__LibPropertyCS__Group__4 ;
    public final void rule__LibPropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2771:1: ( ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) rule__LibPropertyCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2772:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) rule__LibPropertyCS__Group__4
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2772:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:2: rule__LibPropertyCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__35496);
            rule__LibPropertyCS__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__35505);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2785:1: rule__LibPropertyCS__Group__4 : ( '=>' ) rule__LibPropertyCS__Group__5 ;
    public final void rule__LibPropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2789:1: ( ( '=>' ) rule__LibPropertyCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2790:1: ( '=>' ) rule__LibPropertyCS__Group__5
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2790:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2791:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibPropertyCS__Group__45534); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__45544);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2805:1: rule__LibPropertyCS__Group__5 : ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) rule__LibPropertyCS__Group__6 ;
    public final void rule__LibPropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2809:1: ( ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) rule__LibPropertyCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2810:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) rule__LibPropertyCS__Group__6
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2810:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2811:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2812:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2812:2: rule__LibPropertyCS__ClassAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__55572);
            rule__LibPropertyCS__ClassAssignment_5();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__55581);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2823:1: rule__LibPropertyCS__Group__6 : ( ';' ) ;
    public final void rule__LibPropertyCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2827:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2828:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2828:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2829:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibPropertyCS__Group__65610); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__6


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2856:1: rule__LibQualifiedTypeRefCS__Group__0 : ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2860:1: ( ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2861:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) rule__LibQualifiedTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2861:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2862:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2863:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2863:2: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__05659);
            rule__LibQualifiedTypeRefCS__NamespaceAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__05668);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2874:1: rule__LibQualifiedTypeRefCS__Group__1 : ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2878:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2879:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) rule__LibQualifiedTypeRefCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2879:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2880:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2881:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2881:2: rule__LibQualifiedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__15696);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__15706);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2892:1: rule__LibQualifiedTypeRefCS__Group__2 : ( '::' ) rule__LibQualifiedTypeRefCS__Group__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2896:1: ( ( '::' ) rule__LibQualifiedTypeRefCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2897:1: ( '::' ) rule__LibQualifiedTypeRefCS__Group__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2897:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2898:1: '::'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }
            match(input,37,FollowSets000.FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__25735); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__25745);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2912:1: rule__LibQualifiedTypeRefCS__Group__3 : ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2916:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2917:1: ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2917:1: ( ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2918:1: ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2919:1: ( rule__LibQualifiedTypeRefCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2919:2: rule__LibQualifiedTypeRefCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__35773);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2937:1: rule__LibQualifiedTypeRefCS__Group_1__0 : ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2941:1: ( ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2942:1: ( '<' ) rule__LibQualifiedTypeRefCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2942:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2943:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__05816); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__05826);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2957:1: rule__LibQualifiedTypeRefCS__Group_1__1 : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2961:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2962:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibQualifiedTypeRefCS__Group_1__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2962:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2963:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2964:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2964:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__15854);
            rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__15863);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2975:1: rule__LibQualifiedTypeRefCS__Group_1__2 : ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2979:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2980:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) rule__LibQualifiedTypeRefCS__Group_1__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2980:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2981:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2982:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==29) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2982:2: rule__LibQualifiedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__25891);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__25901);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2993:1: rule__LibQualifiedTypeRefCS__Group_1__3 : ( '>' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2997:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2998:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2998:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2999:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__35930); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3020:1: rule__LibQualifiedTypeRefCS__Group_1_2__0 : ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3024:1: ( ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3025:1: ( ',' ) rule__LibQualifiedTypeRefCS__Group_1_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3025:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3026:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__05974); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__05984);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3040:1: rule__LibQualifiedTypeRefCS__Group_1_2__1 : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3045:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3045:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3046:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3047:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3047:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__16012);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3061:1: rule__LibTypeParameterCS__Group__0 : ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1 ;
    public final void rule__LibTypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3065:1: ( ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3066:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) rule__LibTypeParameterCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3066:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3067:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3068:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3068:2: rule__LibTypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__06050);
            rule__LibTypeParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__06059);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3079:1: rule__LibTypeParameterCS__Group__1 : ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__LibTypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3083:1: ( ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3084:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3084:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3085:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3086:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==13||LA32_0==20) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3086:2: rule__LibTypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__16087);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3100:1: rule__LibTypeParameterCS__Group_1_0__0 : ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( 'extends' ) rule__LibTypeParameterCS__Group_1_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3106:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__06127); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__06137);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3120:1: rule__LibTypeParameterCS__Group_1_0__1 : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2 ;
    public final void rule__LibTypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3124:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3125:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) rule__LibTypeParameterCS__Group_1_0__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3125:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3126:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3127:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3127:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__16165);
            rule__LibTypeParameterCS__ExtendsAssignment_1_0_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__16174);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3138:1: rule__LibTypeParameterCS__Group_1_0__2 : ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3142:1: ( ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3143:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3143:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3144:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3145:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==38) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3145:2: rule__LibTypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__26202);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3161:1: rule__LibTypeParameterCS__Group_1_0_2__0 : ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3165:1: ( ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3166:1: ( '&&' ) rule__LibTypeParameterCS__Group_1_0_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3166:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3167:1: '&&'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,38,FollowSets000.FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__06244); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__06254);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3181:1: rule__LibTypeParameterCS__Group_1_0_2__1 : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3185:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3186:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3186:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3187:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3188:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3188:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__16282);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3202:1: rule__LibTypeParameterCS__Group_1_1__0 : ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1 ;
    public final void rule__LibTypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3206:1: ( ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3207:1: ( 'super' ) rule__LibTypeParameterCS__Group_1_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3207:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3208:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__06321); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__06331);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3222:1: rule__LibTypeParameterCS__Group_1_1__1 : ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3226:1: ( ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3227:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3227:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3228:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3229:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3229:2: rule__LibTypeParameterCS__SuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__16359);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3243:1: rule__LibTypedTypeRefCS__Group__0 : ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1 ;
    public final void rule__LibTypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3247:1: ( ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3248:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) rule__LibTypedTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3248:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3249:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3250:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3250:2: rule__LibTypedTypeRefCS__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__06397);
            rule__LibTypedTypeRefCS__TypeAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__06406);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3261:1: rule__LibTypedTypeRefCS__Group__1 : ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibTypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3265:1: ( ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3266:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3266:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3267:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3268:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3268:2: rule__LibTypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__16434);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3282:1: rule__LibTypedTypeRefCS__Group_1__0 : ( '<' ) rule__LibTypedTypeRefCS__Group_1__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3286:1: ( ( '<' ) rule__LibTypedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3287:1: ( '<' ) rule__LibTypedTypeRefCS__Group_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3287:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3288:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__06474); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__06484);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3302:1: rule__LibTypedTypeRefCS__Group_1__1 : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2 ;
    public final void rule__LibTypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3306:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3307:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) rule__LibTypedTypeRefCS__Group_1__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3307:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3308:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3309:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3309:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__16512);
            rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__16521);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3320:1: rule__LibTypedTypeRefCS__Group_1__2 : ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3 ;
    public final void rule__LibTypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3324:1: ( ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3325:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) rule__LibTypedTypeRefCS__Group_1__3
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3325:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3326:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3327:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==29) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3327:2: rule__LibTypedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__26549);
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

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__26559);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3338:1: rule__LibTypedTypeRefCS__Group_1__3 : ( '>' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3342:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3343:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3343:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3344:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__36588); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3365:1: rule__LibTypedTypeRefCS__Group_1_2__0 : ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3369:1: ( ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3370:1: ( ',' ) rule__LibTypedTypeRefCS__Group_1_2__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3370:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3371:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__06632); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__06642);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3385:1: rule__LibTypedTypeRefCS__Group_1_2__1 : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3389:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3391:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3392:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3392:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__16670);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3406:1: rule__LibWildcardTypeRefCS__Group__0 : ( () ) rule__LibWildcardTypeRefCS__Group__1 ;
    public final void rule__LibWildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3410:1: ( ( () ) rule__LibWildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3411:1: ( () ) rule__LibWildcardTypeRefCS__Group__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3411:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3412:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3413:1: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3415:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__06718);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3426:1: rule__LibWildcardTypeRefCS__Group__1 : ( '?' ) rule__LibWildcardTypeRefCS__Group__2 ;
    public final void rule__LibWildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3430:1: ( ( '?' ) rule__LibWildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3431:1: ( '?' ) rule__LibWildcardTypeRefCS__Group__2
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3431:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3432:1: '?'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__16747); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__16757);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3446:1: rule__LibWildcardTypeRefCS__Group__2 : ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__LibWildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3450:1: ( ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3451:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3451:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3452:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3453:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==13||LA36_0==20) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3453:2: rule__LibWildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__26785);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3469:1: rule__LibWildcardTypeRefCS__Group_2_0__0 : ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3473:1: ( ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3474:1: ( 'extends' ) rule__LibWildcardTypeRefCS__Group_2_0__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3474:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3475:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__06827); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__06837);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3489:1: rule__LibWildcardTypeRefCS__Group_2_0__1 : ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3493:1: ( ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3494:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3494:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3495:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:2: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__16865);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3510:1: rule__LibWildcardTypeRefCS__Group_2_1__0 : ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3514:1: ( ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3515:1: ( 'super' ) rule__LibWildcardTypeRefCS__Group_2_1__1
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3515:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3516:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__06904); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }

            }

            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__06914);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3530:1: rule__LibWildcardTypeRefCS__Group_2_1__1 : ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3534:1: ( ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3535:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3535:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3536:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3537:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3537:2: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__16942);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3552:1: rule__Library__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3556:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3557:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3557:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3558:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_16981);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3567:1: rule__Library__ImportsAssignment_2 : ( ruleLibImportCS ) ;
    public final void rule__Library__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3571:1: ( ( ruleLibImportCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3572:1: ( ruleLibImportCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3572:1: ( ruleLibImportCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3573:1: ruleLibImportCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_27012);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3582:1: rule__Library__PackagesAssignment_4 : ( ruleLibPackageCS ) ;
    public final void rule__Library__PackagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3586:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3587:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3587:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3588:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_47043);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3597:1: rule__LibImportCS__NameAssignment_1_0 : ( ruleIdentifier ) ;
    public final void rule__LibImportCS__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3601:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3602:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3602:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3603:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_07074);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3612:1: rule__LibImportCS__NamespaceAssignment_2 : ( ( RULE_SINGLE_QUOTED_STRING ) ) ;
    public final void rule__LibImportCS__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3616:1: ( ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3617:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3617:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3618:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3619:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3620:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_27109); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3631:1: rule__LibClassCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3635:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3636:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3636:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3637:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_17144);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3646:1: rule__LibClassCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3650:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3651:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3651:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3652:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_17175);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3661:1: rule__LibClassCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3665:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3666:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3666:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3667:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_17206);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3676:1: rule__LibClassCS__ConformsToAssignment_3_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3680:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3681:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3681:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3682:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_17237);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3691:1: rule__LibClassCS__ConformsToAssignment_3_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3695:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3696:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3696:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3697:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_17268);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3706:1: rule__LibClassCS__IterationsAssignment_5_0 : ( ruleLibIterationCS ) ;
    public final void rule__LibClassCS__IterationsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3710:1: ( ( ruleLibIterationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3711:1: ( ruleLibIterationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3711:1: ( ruleLibIterationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3712:1: ruleLibIterationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_07299);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3721:1: rule__LibClassCS__OperationsAssignment_5_1 : ( ruleLibOperationCS ) ;
    public final void rule__LibClassCS__OperationsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3725:1: ( ( ruleLibOperationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3726:1: ( ruleLibOperationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3726:1: ( ruleLibOperationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3727:1: ruleLibOperationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_17330);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3736:1: rule__LibClassCS__StructuralFeaturesAssignment_5_2 : ( ruleLibPropertyCS ) ;
    public final void rule__LibClassCS__StructuralFeaturesAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3740:1: ( ( ruleLibPropertyCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3741:1: ( ruleLibPropertyCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3741:1: ( ruleLibPropertyCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3742:1: ruleLibPropertyCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_27361);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3751:1: rule__LibIterationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibIterationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3755:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3756:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3756:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3757:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_17392);
            ruleName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); 
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


    // $ANTLR start rule__LibIterationCS__TypeParametersAssignment_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3766:1: rule__LibIterationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3770:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3771:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3771:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3772:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_17423);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
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
    // $ANTLR end rule__LibIterationCS__TypeParametersAssignment_2_1


    // $ANTLR start rule__LibIterationCS__TypeParametersAssignment_2_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3781:1: rule__LibIterationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3785:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3786:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3786:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3787:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_17454);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
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
    // $ANTLR end rule__LibIterationCS__TypeParametersAssignment_2_2_1


    // $ANTLR start rule__LibIterationCS__ParametersAssignment_4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3796:1: rule__LibIterationCS__ParametersAssignment_4 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3800:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3801:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3801:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3802:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_47485);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0()); 
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
    // $ANTLR end rule__LibIterationCS__ParametersAssignment_4


    // $ANTLR start rule__LibIterationCS__ParametersAssignment_5_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3811:1: rule__LibIterationCS__ParametersAssignment_5_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3815:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3816:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3816:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3817:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_17516);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0()); 
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
    // $ANTLR end rule__LibIterationCS__ParametersAssignment_5_1


    // $ANTLR start rule__LibIterationCS__TypeAssignment_8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3826:1: rule__LibIterationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibIterationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3830:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3831:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3831:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3832:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_87547);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3841:1: rule__LibIterationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibIterationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3845:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3846:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3846:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3847:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_107578); if (failed) return ;
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


    // $ANTLR start rule__LibOperationCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3856:1: rule__LibOperationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibOperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3860:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3861:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3861:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3862:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_17609);
            ruleName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0()); 
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
    // $ANTLR end rule__LibOperationCS__NameAssignment_1


    // $ANTLR start rule__LibOperationCS__TypeParametersAssignment_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3871:1: rule__LibOperationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3875:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3876:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3876:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3877:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_17640);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
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
    // $ANTLR end rule__LibOperationCS__TypeParametersAssignment_2_1


    // $ANTLR start rule__LibOperationCS__TypeParametersAssignment_2_2_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3886:1: rule__LibOperationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3890:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3891:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3891:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3892:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_17671);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
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
    // $ANTLR end rule__LibOperationCS__TypeParametersAssignment_2_2_1


    // $ANTLR start rule__LibOperationCS__ParametersAssignment_4_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3901:1: rule__LibOperationCS__ParametersAssignment_4_0 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3905:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3906:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3906:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3907:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_07702);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0()); 
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
    // $ANTLR end rule__LibOperationCS__ParametersAssignment_4_0


    // $ANTLR start rule__LibOperationCS__ParametersAssignment_4_1_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3916:1: rule__LibOperationCS__ParametersAssignment_4_1_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3920:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3921:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3921:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3922:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_17733);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0()); 
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
    // $ANTLR end rule__LibOperationCS__ParametersAssignment_4_1_1


    // $ANTLR start rule__LibOperationCS__TypeAssignment_7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3931:1: rule__LibOperationCS__TypeAssignment_7 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibOperationCS__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3935:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3936:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3936:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3937:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_77764);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0()); 
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
    // $ANTLR end rule__LibOperationCS__TypeAssignment_7


    // $ANTLR start rule__LibOperationCS__ClassAssignment_9
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3946:1: rule__LibOperationCS__ClassAssignment_9 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibOperationCS__ClassAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3950:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3951:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3951:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3952:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_97795); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0()); 
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
    // $ANTLR end rule__LibOperationCS__ClassAssignment_9


    // $ANTLR start rule__LibPackageCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3961:1: rule__LibPackageCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibPackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3965:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3966:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3966:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3967:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_17826);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3976:1: rule__LibPackageCS__SubpackagesAssignment_3_0 : ( ruleLibPackageCS ) ;
    public final void rule__LibPackageCS__SubpackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3980:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3981:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3981:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3982:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_07857);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3991:1: rule__LibPackageCS__ClassifiersAssignment_3_1 : ( ruleLibClassifierCS ) ;
    public final void rule__LibPackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3995:1: ( ( ruleLibClassifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3996:1: ( ruleLibClassifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3996:1: ( ruleLibClassifierCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3997:1: ruleLibClassifierCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_17888);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4006:1: rule__LibParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4010:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4011:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4011:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4012:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_07919);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4021:1: rule__LibParameterCS__TypeAssignment_2 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibParameterCS__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4025:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4026:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4026:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4027:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_27950);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4036:1: rule__LibParameterCS__LowerAssignment_3_1_0_0 : ( ruleLOWER ) ;
    public final void rule__LibParameterCS__LowerAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4040:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4041:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4041:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4042:1: ruleLOWER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_07981);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4051:1: rule__LibParameterCS__UpperAssignment_3_1_0_1_1 : ( ruleUPPER ) ;
    public final void rule__LibParameterCS__UpperAssignment_3_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4055:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4056:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4056:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4057:1: ruleUPPER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_18012);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4066:1: rule__LibParameterCS__MultiplicityAssignment_3_1_1 : ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) ;
    public final void rule__LibParameterCS__MultiplicityAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4070:1: ( ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4071:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4071:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4072:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4073:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4073:2: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_18043);
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


    // $ANTLR start rule__LibPropertyCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: rule__LibPropertyCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibPropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4086:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4087:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4087:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4088:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_18076);
            ruleName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0()); 
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
    // $ANTLR end rule__LibPropertyCS__NameAssignment_1


    // $ANTLR start rule__LibPropertyCS__TypeAssignment_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4097:1: rule__LibPropertyCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibPropertyCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4101:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4102:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4102:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4103:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_38107);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
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
    // $ANTLR end rule__LibPropertyCS__TypeAssignment_3


    // $ANTLR start rule__LibPropertyCS__ClassAssignment_5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4112:1: rule__LibPropertyCS__ClassAssignment_5 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibPropertyCS__ClassAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4116:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4117:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4117:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4118:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_58138); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0()); 
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
    // $ANTLR end rule__LibPropertyCS__ClassAssignment_5


    // $ANTLR start rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4127:1: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibQualifiedTypeRefCS__NamespaceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4131:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4132:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4132:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4133:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4134:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4135:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_08173);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4146:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4150:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4151:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4151:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4152:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_18208);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4161:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4165:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4166:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4166:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4167:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_18239);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4176:1: rule__LibQualifiedTypeRefCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4180:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4181:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4181:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4182:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__TypeAssignment_38270);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4191:1: rule__LibTypeParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibTypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4195:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4196:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4196:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4197:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_08301);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4206:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4210:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4211:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4211:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4212:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_18332);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4221:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4225:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4226:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4226:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4227:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_18363);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4236:1: rule__LibTypeParameterCS__SuperAssignment_1_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__SuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4240:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4241:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4241:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4242:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_18394);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4251:1: rule__LibTypedTypeRefCS__TypeAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibTypedTypeRefCS__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4255:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4256:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4256:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4257:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4258:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4259:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_08429);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4270:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4274:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4275:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4275:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4276:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_18464);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4285:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4289:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4290:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4290:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4291:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_18495);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4300:1: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4304:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4305:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4305:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4306:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_18526);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4315:1: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4319:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4320:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4320:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4321:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_18557);
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ( ruleLibQualifiedTypeRefCS ) )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ruleLibQualifiedTypeRefCS )
        {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211893);
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
        public static final BitSet FOLLOW_ruleName_in_entryRuleName306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleName313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Name__Alternatives_in_ruleName339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS665 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS965 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS1025 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS1032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1145 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__UPPER__Alternatives1232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_TERMINAL_in_rule__Identifier__Alternatives1266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Identifier__Alternatives1284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Identifier__Alternatives1304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Identifier__Alternatives1324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Identifier__Alternatives1344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Identifier__Alternatives1364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Identifier__Alternatives1384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Identifier__Alternatives1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Identifier__Alternatives1424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Identifier__Alternatives1444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Identifier__Alternatives1464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Name__Alternatives1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_rule__Name__Alternatives1515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_21942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_21960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Library__Group__01996 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__12034 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__22071 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Library__Group__32110 = new BitSet(new long[]{0x0000000002040000L});
        public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__42148 = new BitSet(new long[]{0x0000000002040000L});
        public static final BitSet FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Library__Group__52187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__LibImportCS__Group__02235 = new BitSet(new long[]{0x00000000003FF0A0L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__12273 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__22311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__02351 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibImportCS__Group_1__12389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibClassCS__Group__02429 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__12467 = new BitSet(new long[]{0x0000000009001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__22504 = new BitSet(new long[]{0x0000000001001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__32542 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibClassCS__Group__42581 = new BitSet(new long[]{0x00000000020A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__52619 = new BitSet(new long[]{0x00000000020A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibClassCS__Group__62658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibClassCS__Group_2__02708 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__02718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__12746 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__12755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__22783 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__22793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibClassCS__Group_2__32822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_2_2__02866 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__02876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__12904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LibClassCS__Group_3__02943 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__02953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__12981 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__12990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__23018 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_3_2__03060 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__13098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__LibIterationCS__Group__03137 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__13175 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__23212 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibIterationCS__Group__33251 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__43289 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__43298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__53326 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__53336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibIterationCS__Group__63365 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__63375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibIterationCS__Group__73404 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__73414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__83442 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__83451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibIterationCS__Group__93480 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__93490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__103518 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__103527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibIterationCS__Group__113556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibIterationCS__Group_2__03616 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__03626 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__13654 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__13663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__23691 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__23701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibIterationCS__Group_2__33730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_2_2__03774 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__03784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__13812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_5__03851 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__03861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__13889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__LibOperationCS__Group__03928 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__03938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__13966 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__13975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__24003 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__24013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group__34042 = new BitSet(new long[]{0x00000000803FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__34052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__44080 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__44090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibOperationCS__Group__54119 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__54129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibOperationCS__Group__64158 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__64168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__74196 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__74205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibOperationCS__Group__84234 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__84244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__94272 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__94281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibOperationCS__Group__104310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibOperationCS__Group_2__04368 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__04378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__14406 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__14415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__24443 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__24453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibOperationCS__Group_2__34482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_2_2__04526 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__04536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__14564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__04602 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__04611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__14639 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_4_1__04679 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__04689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__14717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LibPackageCS__Group__04756 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__04766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__14794 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__14803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibPackageCS__Group__24832 = new BitSet(new long[]{0x0000000002240000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__24842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__34870 = new BitSet(new long[]{0x0000000002240000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__34880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibPackageCS__Group__44909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__04954 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__04963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibParameterCS__Group__14992 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__15002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__25030 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__25039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__35067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibParameterCS__Group_3__05111 = new BitSet(new long[]{0x0000000000C00810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__05121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__15149 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__15158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__LibParameterCS__Group_3__25187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__05228 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__05237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__15265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__05305 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__05315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__15343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LibPropertyCS__Group__05382 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__05392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__15420 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__15429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibPropertyCS__Group__25458 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__25468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__35496 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__35505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibPropertyCS__Group__45534 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__45544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__55572 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__55581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibPropertyCS__Group__65610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__05659 = new BitSet(new long[]{0x0000002008000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__05668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__15696 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__15706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__25735 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__25745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__35773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__05816 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__05826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__15854 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__15863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__25891 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__25901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__35930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__05974 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__05984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__16012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__06050 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__06059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__16087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__06127 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__06137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__16165 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__16174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__26202 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__06244 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__06254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__16282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__06321 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__06331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__16359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__06397 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__06406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__16434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__06474 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__06484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__16512 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__16521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__26549 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__26559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__36588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__06632 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__06642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__16670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__06718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__16747 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__16757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__26785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__06827 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__06837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__16865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__06904 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__06914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__16942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_16981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_27012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_47043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_07074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_27109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_17144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_17175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_17206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_17237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_17268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_07299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_17330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_27361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_17392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_17423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_17454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_47485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_17516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_87547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_107578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_17609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_17640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_17671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_07702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_17733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_77764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_97795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_17826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_07857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_17888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_07919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_27950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_07981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_18012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_18043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_18076 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_38107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_58138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_08173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_18208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_18239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__TypeAssignment_38270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_08301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_18332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_18363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_18394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_08429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_18464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_18495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_18526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_18557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211893 = new BitSet(new long[]{0x0000000000000002L});
    }


}