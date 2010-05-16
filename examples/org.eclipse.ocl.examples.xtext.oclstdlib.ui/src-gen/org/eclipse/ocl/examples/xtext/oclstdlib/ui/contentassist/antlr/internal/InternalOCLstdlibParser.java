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
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.ocl.examples.xtext.oclstdlib.services.OCLstdlibGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
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
            ruleMemo = new HashMap[401+1];
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:62:1: entryRuleLibrary : ruleLibrary EOF ;
    public final void entryRuleLibrary() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:63:1: ( ruleLibrary EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:64:1: ruleLibrary EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:71:1: ruleLibrary : ( ( rule__Library__Group__0 ) ) ;
    public final void ruleLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:75:2: ( ( ( rule__Library__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:76:1: ( ( rule__Library__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:76:1: ( ( rule__Library__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:77:1: ( rule__Library__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:78:1: ( rule__Library__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:78:2: rule__Library__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:90:1: entryRuleLOWER : ruleLOWER EOF ;
    public final void entryRuleLOWER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:91:1: ( ruleLOWER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:92:1: ruleLOWER EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:99:1: ruleLOWER : ( RULE_INT ) ;
    public final void ruleLOWER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:103:2: ( ( RULE_INT ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:104:1: ( RULE_INT )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:104:1: ( RULE_INT )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:105:1: RULE_INT
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:118:1: entryRuleUPPER : ruleUPPER EOF ;
    public final void entryRuleUPPER() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:119:1: ( ruleUPPER EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:120:1: ruleUPPER EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:127:1: ruleUPPER : ( ( rule__UPPER__Alternatives ) ) ;
    public final void ruleUPPER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:131:2: ( ( ( rule__UPPER__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:132:1: ( ( rule__UPPER__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:132:1: ( ( rule__UPPER__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:133:1: ( rule__UPPER__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getUPPERAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:134:1: ( rule__UPPER__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:134:2: rule__UPPER__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:146:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:147:1: ( ruleIdentifier EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:148:1: ruleIdentifier EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:155:1: ruleIdentifier : ( ( rule__Identifier__Alternatives ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:159:2: ( ( ( rule__Identifier__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:160:1: ( ( rule__Identifier__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:160:1: ( ( rule__Identifier__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:161:1: ( rule__Identifier__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:162:1: ( rule__Identifier__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:162:2: rule__Identifier__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:174:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:175:1: ( ruleName EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:176:1: ruleName EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:183:1: ruleName : ( ( rule__Name__Alternatives ) ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:187:2: ( ( ( rule__Name__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:1: ( ( rule__Name__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:1: ( ( rule__Name__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:1: ( rule__Name__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNameAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:190:1: ( rule__Name__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:190:2: rule__Name__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:202:1: entryRuleLibImportCS : ruleLibImportCS EOF ;
    public final void entryRuleLibImportCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:203:1: ( ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:204:1: ruleLibImportCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:211:1: ruleLibImportCS : ( ( rule__LibImportCS__Group__0 ) ) ;
    public final void ruleLibImportCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:215:2: ( ( ( rule__LibImportCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:1: ( ( rule__LibImportCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:1: ( ( rule__LibImportCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:1: ( rule__LibImportCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:218:1: ( rule__LibImportCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:218:2: rule__LibImportCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:230:1: entryRuleLibClassCS : ruleLibClassCS EOF ;
    public final void entryRuleLibClassCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:231:1: ( ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:232:1: ruleLibClassCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:239:1: ruleLibClassCS : ( ( rule__LibClassCS__Group__0 ) ) ;
    public final void ruleLibClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:243:2: ( ( ( rule__LibClassCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:1: ( ( rule__LibClassCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:1: ( ( rule__LibClassCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:1: ( rule__LibClassCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:246:1: ( rule__LibClassCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:246:2: rule__LibClassCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:258:1: entryRuleLibClassifierCS : ruleLibClassifierCS EOF ;
    public final void entryRuleLibClassifierCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:259:1: ( ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:260:1: ruleLibClassifierCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:267:1: ruleLibClassifierCS : ( ruleLibClassCS ) ;
    public final void ruleLibClassifierCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:271:2: ( ( ruleLibClassCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:1: ( ruleLibClassCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:1: ( ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:273:1: ruleLibClassCS
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:286:1: entryRuleLibIterationCS : ruleLibIterationCS EOF ;
    public final void entryRuleLibIterationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:287:1: ( ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:288:1: ruleLibIterationCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:295:1: ruleLibIterationCS : ( ( rule__LibIterationCS__Group__0 ) ) ;
    public final void ruleLibIterationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:299:2: ( ( ( rule__LibIterationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:1: ( ( rule__LibIterationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:1: ( ( rule__LibIterationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:1: ( rule__LibIterationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:302:1: ( rule__LibIterationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:302:2: rule__LibIterationCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:314:1: entryRuleLibOperationCS : ruleLibOperationCS EOF ;
    public final void entryRuleLibOperationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:315:1: ( ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:316:1: ruleLibOperationCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:323:1: ruleLibOperationCS : ( ( rule__LibOperationCS__Group__0 ) ) ;
    public final void ruleLibOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:327:2: ( ( ( rule__LibOperationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:1: ( ( rule__LibOperationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:1: ( ( rule__LibOperationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:1: ( rule__LibOperationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:330:1: ( rule__LibOperationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:330:2: rule__LibOperationCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:342:1: entryRuleLibPackageCS : ruleLibPackageCS EOF ;
    public final void entryRuleLibPackageCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:343:1: ( ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:344:1: ruleLibPackageCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:351:1: ruleLibPackageCS : ( ( rule__LibPackageCS__Group__0 ) ) ;
    public final void ruleLibPackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:355:2: ( ( ( rule__LibPackageCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:1: ( ( rule__LibPackageCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:1: ( ( rule__LibPackageCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:1: ( rule__LibPackageCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:358:1: ( rule__LibPackageCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:358:2: rule__LibPackageCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:370:1: entryRuleLibParameterCS : ruleLibParameterCS EOF ;
    public final void entryRuleLibParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:371:1: ( ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:372:1: ruleLibParameterCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:379:1: ruleLibParameterCS : ( ( rule__LibParameterCS__Group__0 ) ) ;
    public final void ruleLibParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:383:2: ( ( ( rule__LibParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:1: ( ( rule__LibParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:1: ( ( rule__LibParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:1: ( rule__LibParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:386:1: ( rule__LibParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:386:2: rule__LibParameterCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:398:1: entryRuleLibPropertyCS : ruleLibPropertyCS EOF ;
    public final void entryRuleLibPropertyCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:399:1: ( ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:400:1: ruleLibPropertyCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:407:1: ruleLibPropertyCS : ( ( rule__LibPropertyCS__Group__0 ) ) ;
    public final void ruleLibPropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:411:2: ( ( ( rule__LibPropertyCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:1: ( ( rule__LibPropertyCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:1: ( ( rule__LibPropertyCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:1: ( rule__LibPropertyCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:414:1: ( rule__LibPropertyCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:414:2: rule__LibPropertyCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:426:1: entryRuleLibQualifiedTypeRefCS : ruleLibQualifiedTypeRefCS EOF ;
    public final void entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:427:1: ( ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:428:1: ruleLibQualifiedTypeRefCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:435:1: ruleLibQualifiedTypeRefCS : ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibQualifiedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:439:2: ( ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:442:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:442:2: rule__LibQualifiedTypeRefCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:454:1: entryRuleLibTypeParameterCS : ruleLibTypeParameterCS EOF ;
    public final void entryRuleLibTypeParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:455:1: ( ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:456:1: ruleLibTypeParameterCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:463:1: ruleLibTypeParameterCS : ( ( rule__LibTypeParameterCS__Group__0 ) ) ;
    public final void ruleLibTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:467:2: ( ( ( rule__LibTypeParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:1: ( rule__LibTypeParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:470:1: ( rule__LibTypeParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:470:2: rule__LibTypeParameterCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:482:1: entryRuleLibTypeRefCS : ruleLibTypeRefCS EOF ;
    public final void entryRuleLibTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:483:1: ( ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:484:1: ruleLibTypeRefCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:491:1: ruleLibTypeRefCS : ( ( rule__LibTypeRefCS__Alternatives ) ) ;
    public final void ruleLibTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:495:2: ( ( ( rule__LibTypeRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:1: ( rule__LibTypeRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:498:1: ( rule__LibTypeRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:498:2: rule__LibTypeRefCS__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:510:1: entryRuleLibTypedRefCS : ruleLibTypedRefCS EOF ;
    public final void entryRuleLibTypedRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:511:1: ( ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:512:1: ruleLibTypedRefCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:519:1: ruleLibTypedRefCS : ( ( rule__LibTypedRefCS__Alternatives ) ) ;
    public final void ruleLibTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:523:2: ( ( ( rule__LibTypedRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:1: ( rule__LibTypedRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:526:1: ( rule__LibTypedRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:526:2: rule__LibTypedRefCS__Alternatives
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:538:1: entryRuleLibTypedTypeRefCS : ruleLibTypedTypeRefCS EOF ;
    public final void entryRuleLibTypedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:539:1: ( ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:540:1: ruleLibTypedTypeRefCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:547:1: ruleLibTypedTypeRefCS : ( ( rule__LibTypedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:551:2: ( ( ( rule__LibTypedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:1: ( rule__LibTypedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:554:1: ( rule__LibTypedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:554:2: rule__LibTypedTypeRefCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:566:1: entryRuleLibWildcardTypeRefCS : ruleLibWildcardTypeRefCS EOF ;
    public final void entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:567:1: ( ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:568:1: ruleLibWildcardTypeRefCS EOF
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:575:1: ruleLibWildcardTypeRefCS : ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleLibWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:579:2: ( ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:580:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:580:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:581:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:582:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:582:2: rule__LibWildcardTypeRefCS__Group__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:594:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:598:1: ( ( RULE_INT ) | ( '*' ) )
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
                    new NoViableAltException("594:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:599:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:599:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:600:1: RULE_INT
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:605:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:605:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:606:1: '*'
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:618:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );
    public final void rule__Identifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:622:1: ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) )
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
                    new NoViableAltException("618:1: rule__Identifier__Alternatives : ( ( RULE_ID_TERMINAL ) | ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:623:1: ( RULE_ID_TERMINAL )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:623:1: ( RULE_ID_TERMINAL )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:624:1: RULE_ID_TERMINAL
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:629:6: ( 'conformsTo' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:629:6: ( 'conformsTo' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:630:1: 'conformsTo'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:637:6: ( 'extends' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:637:6: ( 'extends' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:638:1: 'extends'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:645:6: ( 'import' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:645:6: ( 'import' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:646:1: 'import'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:653:6: ( 'iteration' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:653:6: ( 'iteration' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:654:1: 'iteration'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:661:6: ( 'library' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:661:6: ( 'library' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:662:1: 'library'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:669:6: ( 'operation' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:669:6: ( 'operation' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:670:1: 'operation'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:677:6: ( 'package' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:677:6: ( 'package' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:678:1: 'package'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:685:6: ( 'property' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:685:6: ( 'property' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:686:1: 'property'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:693:6: ( 'super' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:693:6: ( 'super' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:694:1: 'super'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:701:6: ( 'type' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:701:6: ( 'type' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:702:1: 'type'
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:714:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );
    public final void rule__Name__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:718:1: ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) )
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
                    new NoViableAltException("714:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:719:1: ( ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:719:1: ( ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:720:1: ruleIdentifier
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:725:6: ( RULE_DOUBLE_QUOTED_STRING )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:725:6: ( RULE_DOUBLE_QUOTED_STRING )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:726:1: RULE_DOUBLE_QUOTED_STRING
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:736:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );
    public final void rule__LibClassCS__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:740:1: ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) )
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
                    new NoViableAltException("736:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:741:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:741:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:742:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getIterationsAssignment_5_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:743:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:743:2: rule__LibClassCS__IterationsAssignment_5_0
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:747:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:747:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:748:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:749:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:749:2: rule__LibClassCS__OperationsAssignment_5_1
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:753:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:753:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:754:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_2()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:755:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:755:2: rule__LibClassCS__StructuralFeaturesAssignment_5_2
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:764:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__LibPackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:768:1: ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) )
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
                    new NoViableAltException("764:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:769:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:769:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:770:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:771:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:771:2: rule__LibPackageCS__SubpackagesAssignment_3_0
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:775:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:775:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:776:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:777:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:777:2: rule__LibPackageCS__ClassifiersAssignment_3_1
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:786:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );
    public final void rule__LibParameterCS__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:790:1: ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) )
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
                    new NoViableAltException("786:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:792:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:2: rule__LibParameterCS__Group_3_1_0__0
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:797:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:797:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:798:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:799:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:799:2: rule__LibParameterCS__MultiplicityAssignment_3_1_1
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:808:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
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
                    new NoViableAltException("808:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:814:1: '*'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:821:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:821:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:822:1: '+'
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:830:1: '?'
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:842:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__LibTypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:846:1: ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) )
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
                    new NoViableAltException("842:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:847:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:847:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:848:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:849:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:849:2: rule__LibTypeParameterCS__Group_1_0__0
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:853:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:853:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:854:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:855:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:855:2: rule__LibTypeParameterCS__Group_1_1__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:864:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );
    public final void rule__LibTypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:868:1: ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) )
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
                    new NoViableAltException("864:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:869:1: ( ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:869:1: ( ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:870:1: ruleLibTypedRefCS
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:875:6: ( ruleLibWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:875:6: ( ruleLibWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:876:1: ruleLibWildcardTypeRefCS
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );
    public final void rule__LibTypedRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) )
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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 1, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 2, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 3, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 4, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 5, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 6, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 7, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 8, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 9, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 10, input);

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
                        new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("886:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ruleLibQualifiedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ruleLibQualifiedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:892:1: ruleLibQualifiedTypeRefCS
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:6: ( ruleLibTypedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:6: ( ruleLibTypedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:898:1: ruleLibTypedTypeRefCS
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:908:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__LibWildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:912:1: ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) )
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
                    new NoViableAltException("908:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:914:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:915:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:915:2: rule__LibWildcardTypeRefCS__Group_2_0__0
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:919:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:919:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:920:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:921:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:921:2: rule__LibWildcardTypeRefCS__Group_2_1__0
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:932:1: rule__Library__Group__0 : rule__Library__Group__0__Impl rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ( rule__Library__Group__0__Impl rule__Library__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:937:2: rule__Library__Group__0__Impl rule__Library__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__01991);
            rule__Library__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1_in_rule__Library__Group__01994);
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


    // $ANTLR start rule__Library__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:944:1: rule__Library__Group__0__Impl : ( 'library' ) ;
    public final void rule__Library__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:948:1: ( ( 'library' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:949:1: ( 'library' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:949:1: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:950:1: 'library'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Library__Group__0__Impl2022); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
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
    // $ANTLR end rule__Library__Group__0__Impl


    // $ANTLR start rule__Library__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:963:1: rule__Library__Group__1 : rule__Library__Group__1__Impl rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:967:1: ( rule__Library__Group__1__Impl rule__Library__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:968:2: rule__Library__Group__1__Impl rule__Library__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12053);
            rule__Library__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12056);
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


    // $ANTLR start rule__Library__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:975:1: rule__Library__Group__1__Impl : ( ( rule__Library__NameAssignment_1 ) ) ;
    public final void rule__Library__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:979:1: ( ( ( rule__Library__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:980:1: ( ( rule__Library__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:980:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:981:1: ( rule__Library__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:982:1: ( rule__Library__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:982:2: rule__Library__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2083);
            rule__Library__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__Library__Group__1__Impl


    // $ANTLR start rule__Library__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:992:1: rule__Library__Group__2 : rule__Library__Group__2__Impl rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:996:1: ( rule__Library__Group__2__Impl rule__Library__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:997:2: rule__Library__Group__2__Impl rule__Library__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22113);
            rule__Library__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22116);
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


    // $ANTLR start rule__Library__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1004:1: rule__Library__Group__2__Impl : ( ( rule__Library__ImportsAssignment_2 )* ) ;
    public final void rule__Library__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1008:1: ( ( ( rule__Library__ImportsAssignment_2 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1009:1: ( ( rule__Library__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1009:1: ( ( rule__Library__ImportsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1010:1: ( rule__Library__ImportsAssignment_2 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1011:1: ( rule__Library__ImportsAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1011:2: rule__Library__ImportsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2143);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Library__Group__2__Impl


    // $ANTLR start rule__Library__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1021:1: rule__Library__Group__3 : rule__Library__Group__3__Impl rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1025:1: ( rule__Library__Group__3__Impl rule__Library__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1026:2: rule__Library__Group__3__Impl rule__Library__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32174);
            rule__Library__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32177);
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


    // $ANTLR start rule__Library__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1033:1: rule__Library__Group__3__Impl : ( '{' ) ;
    public final void rule__Library__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1037:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1038:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1038:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1039:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Library__Group__3__Impl2205); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end rule__Library__Group__3__Impl


    // $ANTLR start rule__Library__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1052:1: rule__Library__Group__4 : rule__Library__Group__4__Impl rule__Library__Group__5 ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1056:1: ( rule__Library__Group__4__Impl rule__Library__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1057:2: rule__Library__Group__4__Impl rule__Library__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42236);
            rule__Library__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42239);
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


    // $ANTLR start rule__Library__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1064:1: rule__Library__Group__4__Impl : ( ( rule__Library__PackagesAssignment_4 )* ) ;
    public final void rule__Library__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1068:1: ( ( ( rule__Library__PackagesAssignment_4 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1069:1: ( ( rule__Library__PackagesAssignment_4 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1069:1: ( ( rule__Library__PackagesAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1070:1: ( rule__Library__PackagesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1071:1: ( rule__Library__PackagesAssignment_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==18) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1071:2: rule__Library__PackagesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2266);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Library__Group__4__Impl


    // $ANTLR start rule__Library__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1081:1: rule__Library__Group__5 : rule__Library__Group__5__Impl ;
    public final void rule__Library__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1085:1: ( rule__Library__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1086:2: rule__Library__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52297);
            rule__Library__Group__5__Impl();
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
    // $ANTLR end rule__Library__Group__5


    // $ANTLR start rule__Library__Group__5__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1092:1: rule__Library__Group__5__Impl : ( '}' ) ;
    public final void rule__Library__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1096:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1097:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1097:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1098:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Library__Group__5__Impl2325); if (failed) return ;
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
    // $ANTLR end rule__Library__Group__5__Impl


    // $ANTLR start rule__LibImportCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1123:1: rule__LibImportCS__Group__0 : rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 ;
    public final void rule__LibImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1127:1: ( rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1128:2: rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02368);
            rule__LibImportCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02371);
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


    // $ANTLR start rule__LibImportCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1135:1: rule__LibImportCS__Group__0__Impl : ( 'import' ) ;
    public final void rule__LibImportCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1139:1: ( ( 'import' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: ( 'import' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1141:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2399); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
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
    // $ANTLR end rule__LibImportCS__Group__0__Impl


    // $ANTLR start rule__LibImportCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1154:1: rule__LibImportCS__Group__1 : rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 ;
    public final void rule__LibImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1158:1: ( rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1159:2: rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12430);
            rule__LibImportCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12433);
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


    // $ANTLR start rule__LibImportCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1166:1: rule__LibImportCS__Group__1__Impl : ( ( rule__LibImportCS__Group_1__0 )? ) ;
    public final void rule__LibImportCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1170:1: ( ( ( rule__LibImportCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1171:1: ( ( rule__LibImportCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1171:1: ( ( rule__LibImportCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1172:1: ( rule__LibImportCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1173:1: ( rule__LibImportCS__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID_TERMINAL||(LA14_0>=12 && LA14_0<=21)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1173:2: rule__LibImportCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2460);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibImportCS__Group__1__Impl


    // $ANTLR start rule__LibImportCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: rule__LibImportCS__Group__2 : rule__LibImportCS__Group__2__Impl ;
    public final void rule__LibImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1187:1: ( rule__LibImportCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1188:2: rule__LibImportCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22491);
            rule__LibImportCS__Group__2__Impl();
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
    // $ANTLR end rule__LibImportCS__Group__2


    // $ANTLR start rule__LibImportCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1194:1: rule__LibImportCS__Group__2__Impl : ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) ;
    public final void rule__LibImportCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1198:1: ( ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1199:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1199:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1200:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1201:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1201:2: rule__LibImportCS__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2518);
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
    // $ANTLR end rule__LibImportCS__Group__2__Impl


    // $ANTLR start rule__LibImportCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1217:1: rule__LibImportCS__Group_1__0 : rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 ;
    public final void rule__LibImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1221:1: ( rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1222:2: rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02554);
            rule__LibImportCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02557);
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


    // $ANTLR start rule__LibImportCS__Group_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1229:1: rule__LibImportCS__Group_1__0__Impl : ( ( rule__LibImportCS__NameAssignment_1_0 ) ) ;
    public final void rule__LibImportCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1233:1: ( ( ( rule__LibImportCS__NameAssignment_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1234:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1234:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1235:1: ( rule__LibImportCS__NameAssignment_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1236:1: ( rule__LibImportCS__NameAssignment_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1236:2: rule__LibImportCS__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2584);
            rule__LibImportCS__NameAssignment_1_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
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
    // $ANTLR end rule__LibImportCS__Group_1__0__Impl


    // $ANTLR start rule__LibImportCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1246:1: rule__LibImportCS__Group_1__1 : rule__LibImportCS__Group_1__1__Impl ;
    public final void rule__LibImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1250:1: ( rule__LibImportCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1251:2: rule__LibImportCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12614);
            rule__LibImportCS__Group_1__1__Impl();
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
    // $ANTLR end rule__LibImportCS__Group_1__1


    // $ANTLR start rule__LibImportCS__Group_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1257:1: rule__LibImportCS__Group_1__1__Impl : ( ':' ) ;
    public final void rule__LibImportCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1261:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1262:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1262:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1263:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2642); if (failed) return ;
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
    // $ANTLR end rule__LibImportCS__Group_1__1__Impl


    // $ANTLR start rule__LibClassCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1280:1: rule__LibClassCS__Group__0 : rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 ;
    public final void rule__LibClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1284:1: ( rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1285:2: rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02677);
            rule__LibClassCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02680);
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


    // $ANTLR start rule__LibClassCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1292:1: rule__LibClassCS__Group__0__Impl : ( 'type' ) ;
    public final void rule__LibClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1296:1: ( ( 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1297:1: ( 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1297:1: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1298:1: 'type'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2708); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
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
    // $ANTLR end rule__LibClassCS__Group__0__Impl


    // $ANTLR start rule__LibClassCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1311:1: rule__LibClassCS__Group__1 : rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 ;
    public final void rule__LibClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1315:1: ( rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1316:2: rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12739);
            rule__LibClassCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12742);
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


    // $ANTLR start rule__LibClassCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1323:1: rule__LibClassCS__Group__1__Impl : ( ( rule__LibClassCS__NameAssignment_1 ) ) ;
    public final void rule__LibClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1327:1: ( ( ( rule__LibClassCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1328:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1328:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1329:1: ( rule__LibClassCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1330:1: ( rule__LibClassCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1330:2: rule__LibClassCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2769);
            rule__LibClassCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__LibClassCS__Group__1__Impl


    // $ANTLR start rule__LibClassCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1340:1: rule__LibClassCS__Group__2 : rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 ;
    public final void rule__LibClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1344:1: ( rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1345:2: rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22799);
            rule__LibClassCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22802);
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


    // $ANTLR start rule__LibClassCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1352:1: rule__LibClassCS__Group__2__Impl : ( ( rule__LibClassCS__Group_2__0 )? ) ;
    public final void rule__LibClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1356:1: ( ( ( rule__LibClassCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1357:1: ( ( rule__LibClassCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1357:1: ( ( rule__LibClassCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1358:1: ( rule__LibClassCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1359:1: ( rule__LibClassCS__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1359:2: rule__LibClassCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2829);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__Group__2__Impl


    // $ANTLR start rule__LibClassCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1369:1: rule__LibClassCS__Group__3 : rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 ;
    public final void rule__LibClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1373:1: ( rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1374:2: rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32860);
            rule__LibClassCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32863);
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


    // $ANTLR start rule__LibClassCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1381:1: rule__LibClassCS__Group__3__Impl : ( ( rule__LibClassCS__Group_3__0 )? ) ;
    public final void rule__LibClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1385:1: ( ( ( rule__LibClassCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1386:1: ( ( rule__LibClassCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1386:1: ( ( rule__LibClassCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1387:1: ( rule__LibClassCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1388:1: ( rule__LibClassCS__Group_3__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==12) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1388:2: rule__LibClassCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl2890);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__Group__3__Impl


    // $ANTLR start rule__LibClassCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1398:1: rule__LibClassCS__Group__4 : rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 ;
    public final void rule__LibClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1402:1: ( rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1403:2: rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__42921);
            rule__LibClassCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42924);
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


    // $ANTLR start rule__LibClassCS__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1410:1: rule__LibClassCS__Group__4__Impl : ( '{' ) ;
    public final void rule__LibClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1414:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1415:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1415:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1416:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibClassCS__Group__4__Impl2952); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
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
    // $ANTLR end rule__LibClassCS__Group__4__Impl


    // $ANTLR start rule__LibClassCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1429:1: rule__LibClassCS__Group__5 : rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 ;
    public final void rule__LibClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1433:1: ( rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1434:2: rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__52983);
            rule__LibClassCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52986);
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


    // $ANTLR start rule__LibClassCS__Group__5__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1441:1: rule__LibClassCS__Group__5__Impl : ( ( rule__LibClassCS__Alternatives_5 )* ) ;
    public final void rule__LibClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1445:1: ( ( ( rule__LibClassCS__Alternatives_5 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1446:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1446:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1447:1: ( rule__LibClassCS__Alternatives_5 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1448:1: ( rule__LibClassCS__Alternatives_5 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15||LA17_0==17||LA17_0==19) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1448:2: rule__LibClassCS__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3013);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__Group__5__Impl


    // $ANTLR start rule__LibClassCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1458:1: rule__LibClassCS__Group__6 : rule__LibClassCS__Group__6__Impl ;
    public final void rule__LibClassCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1462:1: ( rule__LibClassCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1463:2: rule__LibClassCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63044);
            rule__LibClassCS__Group__6__Impl();
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
    // $ANTLR end rule__LibClassCS__Group__6


    // $ANTLR start rule__LibClassCS__Group__6__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1469:1: rule__LibClassCS__Group__6__Impl : ( '}' ) ;
    public final void rule__LibClassCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1473:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1474:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1474:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1475:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3072); if (failed) return ;
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
    // $ANTLR end rule__LibClassCS__Group__6__Impl


    // $ANTLR start rule__LibClassCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1502:1: rule__LibClassCS__Group_2__0 : rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 ;
    public final void rule__LibClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1506:1: ( rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1507:2: rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03117);
            rule__LibClassCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03120);
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


    // $ANTLR start rule__LibClassCS__Group_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1514:1: rule__LibClassCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1519:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1519:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1520:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3148); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
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
    // $ANTLR end rule__LibClassCS__Group_2__0__Impl


    // $ANTLR start rule__LibClassCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1533:1: rule__LibClassCS__Group_2__1 : rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 ;
    public final void rule__LibClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1537:1: ( rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1538:2: rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13179);
            rule__LibClassCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13182);
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


    // $ANTLR start rule__LibClassCS__Group_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1545:1: rule__LibClassCS__Group_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1549:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1550:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1550:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1551:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1552:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1552:2: rule__LibClassCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3209);
            rule__LibClassCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
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
    // $ANTLR end rule__LibClassCS__Group_2__1__Impl


    // $ANTLR start rule__LibClassCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1562:1: rule__LibClassCS__Group_2__2 : rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 ;
    public final void rule__LibClassCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1566:1: ( rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1567:2: rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23239);
            rule__LibClassCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23242);
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


    // $ANTLR start rule__LibClassCS__Group_2__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:1: rule__LibClassCS__Group_2__2__Impl : ( ( rule__LibClassCS__Group_2_2__0 )* ) ;
    public final void rule__LibClassCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1578:1: ( ( ( rule__LibClassCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1579:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1579:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1580:1: ( rule__LibClassCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1581:1: ( rule__LibClassCS__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1581:2: rule__LibClassCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3269);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__Group_2__2__Impl


    // $ANTLR start rule__LibClassCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1591:1: rule__LibClassCS__Group_2__3 : rule__LibClassCS__Group_2__3__Impl ;
    public final void rule__LibClassCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1595:1: ( rule__LibClassCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1596:2: rule__LibClassCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33300);
            rule__LibClassCS__Group_2__3__Impl();
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
    // $ANTLR end rule__LibClassCS__Group_2__3


    // $ANTLR start rule__LibClassCS__Group_2__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1602:1: rule__LibClassCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibClassCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1606:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1607:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1607:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1608:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3328); if (failed) return ;
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
    // $ANTLR end rule__LibClassCS__Group_2__3__Impl


    // $ANTLR start rule__LibClassCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1629:1: rule__LibClassCS__Group_2_2__0 : rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 ;
    public final void rule__LibClassCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1633:1: ( rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1634:2: rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03367);
            rule__LibClassCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03370);
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


    // $ANTLR start rule__LibClassCS__Group_2_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1641:1: rule__LibClassCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1645:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1646:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1646:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1647:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3398); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
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
    // $ANTLR end rule__LibClassCS__Group_2_2__0__Impl


    // $ANTLR start rule__LibClassCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1660:1: rule__LibClassCS__Group_2_2__1 : rule__LibClassCS__Group_2_2__1__Impl ;
    public final void rule__LibClassCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1664:1: ( rule__LibClassCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1665:2: rule__LibClassCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13429);
            rule__LibClassCS__Group_2_2__1__Impl();
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
    // $ANTLR end rule__LibClassCS__Group_2_2__1


    // $ANTLR start rule__LibClassCS__Group_2_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1671:1: rule__LibClassCS__Group_2_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1675:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1676:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1676:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1677:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1678:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1678:2: rule__LibClassCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3456);
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
    // $ANTLR end rule__LibClassCS__Group_2_2__1__Impl


    // $ANTLR start rule__LibClassCS__Group_3__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1692:1: rule__LibClassCS__Group_3__0 : rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 ;
    public final void rule__LibClassCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1696:1: ( rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1697:2: rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03490);
            rule__LibClassCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03493);
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


    // $ANTLR start rule__LibClassCS__Group_3__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: rule__LibClassCS__Group_3__0__Impl : ( 'conformsTo' ) ;
    public final void rule__LibClassCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1708:1: ( ( 'conformsTo' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1709:1: ( 'conformsTo' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1709:1: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1710:1: 'conformsTo'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3521); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
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
    // $ANTLR end rule__LibClassCS__Group_3__0__Impl


    // $ANTLR start rule__LibClassCS__Group_3__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1723:1: rule__LibClassCS__Group_3__1 : rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 ;
    public final void rule__LibClassCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1727:1: ( rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1728:2: rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13552);
            rule__LibClassCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13555);
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


    // $ANTLR start rule__LibClassCS__Group_3__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1735:1: rule__LibClassCS__Group_3__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) ;
    public final void rule__LibClassCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1739:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1740:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1740:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1741:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1742:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1742:2: rule__LibClassCS__ConformsToAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3582);
            rule__LibClassCS__ConformsToAssignment_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
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
    // $ANTLR end rule__LibClassCS__Group_3__1__Impl


    // $ANTLR start rule__LibClassCS__Group_3__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1752:1: rule__LibClassCS__Group_3__2 : rule__LibClassCS__Group_3__2__Impl ;
    public final void rule__LibClassCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1756:1: ( rule__LibClassCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1757:2: rule__LibClassCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23612);
            rule__LibClassCS__Group_3__2__Impl();
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
    // $ANTLR end rule__LibClassCS__Group_3__2


    // $ANTLR start rule__LibClassCS__Group_3__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1763:1: rule__LibClassCS__Group_3__2__Impl : ( ( rule__LibClassCS__Group_3_2__0 )* ) ;
    public final void rule__LibClassCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1767:1: ( ( ( rule__LibClassCS__Group_3_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1768:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1768:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1769:1: ( rule__LibClassCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1770:1: ( rule__LibClassCS__Group_3_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1770:2: rule__LibClassCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3639);
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
    // $ANTLR end rule__LibClassCS__Group_3__2__Impl


    // $ANTLR start rule__LibClassCS__Group_3_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1786:1: rule__LibClassCS__Group_3_2__0 : rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 ;
    public final void rule__LibClassCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1790:1: ( rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1791:2: rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03676);
            rule__LibClassCS__Group_3_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03679);
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


    // $ANTLR start rule__LibClassCS__Group_3_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1798:1: rule__LibClassCS__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1802:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1803:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1803:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1804:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3707); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
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
    // $ANTLR end rule__LibClassCS__Group_3_2__0__Impl


    // $ANTLR start rule__LibClassCS__Group_3_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1817:1: rule__LibClassCS__Group_3_2__1 : rule__LibClassCS__Group_3_2__1__Impl ;
    public final void rule__LibClassCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1821:1: ( rule__LibClassCS__Group_3_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1822:2: rule__LibClassCS__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13738);
            rule__LibClassCS__Group_3_2__1__Impl();
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
    // $ANTLR end rule__LibClassCS__Group_3_2__1


    // $ANTLR start rule__LibClassCS__Group_3_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1828:1: rule__LibClassCS__Group_3_2__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) ;
    public final void rule__LibClassCS__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1832:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1833:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1833:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1834:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1835:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1835:2: rule__LibClassCS__ConformsToAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3765);
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
    // $ANTLR end rule__LibClassCS__Group_3_2__1__Impl


    // $ANTLR start rule__LibIterationCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1849:1: rule__LibIterationCS__Group__0 : rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 ;
    public final void rule__LibIterationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1853:1: ( rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1854:2: rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03799);
            rule__LibIterationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03802);
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


    // $ANTLR start rule__LibIterationCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1861:1: rule__LibIterationCS__Group__0__Impl : ( 'iteration' ) ;
    public final void rule__LibIterationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1865:1: ( ( 'iteration' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1866:1: ( 'iteration' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1866:1: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1867:1: 'iteration'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3830); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
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
    // $ANTLR end rule__LibIterationCS__Group__0__Impl


    // $ANTLR start rule__LibIterationCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1880:1: rule__LibIterationCS__Group__1 : rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 ;
    public final void rule__LibIterationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1884:1: ( rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1885:2: rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13861);
            rule__LibIterationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13864);
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


    // $ANTLR start rule__LibIterationCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1892:1: rule__LibIterationCS__Group__1__Impl : ( ( rule__LibIterationCS__NameAssignment_1 ) ) ;
    public final void rule__LibIterationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1896:1: ( ( ( rule__LibIterationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1897:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1897:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1898:1: ( rule__LibIterationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1899:1: ( rule__LibIterationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1899:2: rule__LibIterationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl3891);
            rule__LibIterationCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__LibIterationCS__Group__1__Impl


    // $ANTLR start rule__LibIterationCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1909:1: rule__LibIterationCS__Group__2 : rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 ;
    public final void rule__LibIterationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1913:1: ( rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1914:2: rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__23921);
            rule__LibIterationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23924);
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


    // $ANTLR start rule__LibIterationCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1921:1: rule__LibIterationCS__Group__2__Impl : ( ( rule__LibIterationCS__Group_2__0 )? ) ;
    public final void rule__LibIterationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1925:1: ( ( ( rule__LibIterationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1926:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1926:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1927:1: ( rule__LibIterationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1928:1: ( rule__LibIterationCS__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1928:2: rule__LibIterationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl3951);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibIterationCS__Group__2__Impl


    // $ANTLR start rule__LibIterationCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1938:1: rule__LibIterationCS__Group__3 : rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 ;
    public final void rule__LibIterationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1942:1: ( rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1943:2: rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__33982);
            rule__LibIterationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33985);
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


    // $ANTLR start rule__LibIterationCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1950:1: rule__LibIterationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibIterationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1954:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1955:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1955:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1956:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4013); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
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
    // $ANTLR end rule__LibIterationCS__Group__3__Impl


    // $ANTLR start rule__LibIterationCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1969:1: rule__LibIterationCS__Group__4 : rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 ;
    public final void rule__LibIterationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1973:1: ( rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1974:2: rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44044);
            rule__LibIterationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44047);
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


    // $ANTLR start rule__LibIterationCS__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1981:1: rule__LibIterationCS__Group__4__Impl : ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) ;
    public final void rule__LibIterationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1985:1: ( ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1986:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1986:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1987:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:2: rule__LibIterationCS__ParametersAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4074);
            rule__LibIterationCS__ParametersAssignment_4();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
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
    // $ANTLR end rule__LibIterationCS__Group__4__Impl


    // $ANTLR start rule__LibIterationCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1998:1: rule__LibIterationCS__Group__5 : rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 ;
    public final void rule__LibIterationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2002:1: ( rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2003:2: rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54104);
            rule__LibIterationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54107);
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


    // $ANTLR start rule__LibIterationCS__Group__5__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2010:1: rule__LibIterationCS__Group__5__Impl : ( ( rule__LibIterationCS__Group_5__0 )* ) ;
    public final void rule__LibIterationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2014:1: ( ( ( rule__LibIterationCS__Group_5__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2015:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2015:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2016:1: ( rule__LibIterationCS__Group_5__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2017:1: ( rule__LibIterationCS__Group_5__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2017:2: rule__LibIterationCS__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4134);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibIterationCS__Group__5__Impl


    // $ANTLR start rule__LibIterationCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2027:1: rule__LibIterationCS__Group__6 : rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 ;
    public final void rule__LibIterationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2031:1: ( rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2032:2: rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64165);
            rule__LibIterationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64168);
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


    // $ANTLR start rule__LibIterationCS__Group__6__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2039:1: rule__LibIterationCS__Group__6__Impl : ( ')' ) ;
    public final void rule__LibIterationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2043:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2044:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2044:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2045:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4196); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
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
    // $ANTLR end rule__LibIterationCS__Group__6__Impl


    // $ANTLR start rule__LibIterationCS__Group__7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2058:1: rule__LibIterationCS__Group__7 : rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 ;
    public final void rule__LibIterationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2062:1: ( rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2063:2: rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74227);
            rule__LibIterationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74230);
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


    // $ANTLR start rule__LibIterationCS__Group__7__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2070:1: rule__LibIterationCS__Group__7__Impl : ( ':' ) ;
    public final void rule__LibIterationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2074:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2075:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2075:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2076:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4258); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
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
    // $ANTLR end rule__LibIterationCS__Group__7__Impl


    // $ANTLR start rule__LibIterationCS__Group__8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2089:1: rule__LibIterationCS__Group__8 : rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 ;
    public final void rule__LibIterationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2093:1: ( rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2094:2: rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84289);
            rule__LibIterationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84292);
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


    // $ANTLR start rule__LibIterationCS__Group__8__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2101:1: rule__LibIterationCS__Group__8__Impl : ( ( rule__LibIterationCS__TypeAssignment_8 ) ) ;
    public final void rule__LibIterationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2105:1: ( ( ( rule__LibIterationCS__TypeAssignment_8 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2106:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2106:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2107:1: ( rule__LibIterationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2108:1: ( rule__LibIterationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2108:2: rule__LibIterationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4319);
            rule__LibIterationCS__TypeAssignment_8();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
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
    // $ANTLR end rule__LibIterationCS__Group__8__Impl


    // $ANTLR start rule__LibIterationCS__Group__9
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2118:1: rule__LibIterationCS__Group__9 : rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 ;
    public final void rule__LibIterationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2123:2: rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94349);
            rule__LibIterationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94352);
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


    // $ANTLR start rule__LibIterationCS__Group__9__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2130:1: rule__LibIterationCS__Group__9__Impl : ( '=>' ) ;
    public final void rule__LibIterationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2134:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2135:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2135:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2136:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4380); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
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
    // $ANTLR end rule__LibIterationCS__Group__9__Impl


    // $ANTLR start rule__LibIterationCS__Group__10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2149:1: rule__LibIterationCS__Group__10 : rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 ;
    public final void rule__LibIterationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2153:1: ( rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2154:2: rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104411);
            rule__LibIterationCS__Group__10__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104414);
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


    // $ANTLR start rule__LibIterationCS__Group__10__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2161:1: rule__LibIterationCS__Group__10__Impl : ( ( rule__LibIterationCS__ClassAssignment_10 ) ) ;
    public final void rule__LibIterationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2165:1: ( ( ( rule__LibIterationCS__ClassAssignment_10 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2166:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2166:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2167:1: ( rule__LibIterationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2168:1: ( rule__LibIterationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2168:2: rule__LibIterationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4441);
            rule__LibIterationCS__ClassAssignment_10();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
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
    // $ANTLR end rule__LibIterationCS__Group__10__Impl


    // $ANTLR start rule__LibIterationCS__Group__11
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2178:1: rule__LibIterationCS__Group__11 : rule__LibIterationCS__Group__11__Impl ;
    public final void rule__LibIterationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2182:1: ( rule__LibIterationCS__Group__11__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2183:2: rule__LibIterationCS__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114471);
            rule__LibIterationCS__Group__11__Impl();
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
    // $ANTLR end rule__LibIterationCS__Group__11


    // $ANTLR start rule__LibIterationCS__Group__11__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2189:1: rule__LibIterationCS__Group__11__Impl : ( ';' ) ;
    public final void rule__LibIterationCS__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2193:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2194:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2194:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2195:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4499); if (failed) return ;
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
    // $ANTLR end rule__LibIterationCS__Group__11__Impl


    // $ANTLR start rule__LibIterationCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2232:1: rule__LibIterationCS__Group_2__0 : rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 ;
    public final void rule__LibIterationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2236:1: ( rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2237:2: rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04554);
            rule__LibIterationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04557);
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


    // $ANTLR start rule__LibIterationCS__Group_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2244:1: rule__LibIterationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibIterationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2248:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2249:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2249:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2250:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4585); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
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
    // $ANTLR end rule__LibIterationCS__Group_2__0__Impl


    // $ANTLR start rule__LibIterationCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2263:1: rule__LibIterationCS__Group_2__1 : rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 ;
    public final void rule__LibIterationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2267:1: ( rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2268:2: rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14616);
            rule__LibIterationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14619);
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


    // $ANTLR start rule__LibIterationCS__Group_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2275:1: rule__LibIterationCS__Group_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2279:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2280:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2280:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2281:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2282:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2282:2: rule__LibIterationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4646);
            rule__LibIterationCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
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
    // $ANTLR end rule__LibIterationCS__Group_2__1__Impl


    // $ANTLR start rule__LibIterationCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2292:1: rule__LibIterationCS__Group_2__2 : rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 ;
    public final void rule__LibIterationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2296:1: ( rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2297:2: rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24676);
            rule__LibIterationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24679);
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


    // $ANTLR start rule__LibIterationCS__Group_2__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2304:1: rule__LibIterationCS__Group_2__2__Impl : ( ( rule__LibIterationCS__Group_2_2__0 )* ) ;
    public final void rule__LibIterationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2308:1: ( ( ( rule__LibIterationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2309:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2309:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2310:1: ( rule__LibIterationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2311:1: ( rule__LibIterationCS__Group_2_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2311:2: rule__LibIterationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4706);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibIterationCS__Group_2__2__Impl


    // $ANTLR start rule__LibIterationCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2321:1: rule__LibIterationCS__Group_2__3 : rule__LibIterationCS__Group_2__3__Impl ;
    public final void rule__LibIterationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2325:1: ( rule__LibIterationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2326:2: rule__LibIterationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34737);
            rule__LibIterationCS__Group_2__3__Impl();
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
    // $ANTLR end rule__LibIterationCS__Group_2__3


    // $ANTLR start rule__LibIterationCS__Group_2__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2332:1: rule__LibIterationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibIterationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2336:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2337:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2337:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2338:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4765); if (failed) return ;
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
    // $ANTLR end rule__LibIterationCS__Group_2__3__Impl


    // $ANTLR start rule__LibIterationCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2359:1: rule__LibIterationCS__Group_2_2__0 : rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 ;
    public final void rule__LibIterationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2363:1: ( rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2364:2: rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04804);
            rule__LibIterationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04807);
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


    // $ANTLR start rule__LibIterationCS__Group_2_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2371:1: rule__LibIterationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2375:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2376:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2376:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2377:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4835); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
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
    // $ANTLR end rule__LibIterationCS__Group_2_2__0__Impl


    // $ANTLR start rule__LibIterationCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2390:1: rule__LibIterationCS__Group_2_2__1 : rule__LibIterationCS__Group_2_2__1__Impl ;
    public final void rule__LibIterationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2394:1: ( rule__LibIterationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2395:2: rule__LibIterationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14866);
            rule__LibIterationCS__Group_2_2__1__Impl();
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
    // $ANTLR end rule__LibIterationCS__Group_2_2__1


    // $ANTLR start rule__LibIterationCS__Group_2_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2401:1: rule__LibIterationCS__Group_2_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2405:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2406:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2406:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2407:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2408:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2408:2: rule__LibIterationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl4893);
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
    // $ANTLR end rule__LibIterationCS__Group_2_2__1__Impl


    // $ANTLR start rule__LibIterationCS__Group_5__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2422:1: rule__LibIterationCS__Group_5__0 : rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 ;
    public final void rule__LibIterationCS__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2426:1: ( rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2427:2: rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__04927);
            rule__LibIterationCS__Group_5__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__04930);
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


    // $ANTLR start rule__LibIterationCS__Group_5__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2434:1: rule__LibIterationCS__Group_5__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2438:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2439:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2439:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2440:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl4958); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
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
    // $ANTLR end rule__LibIterationCS__Group_5__0__Impl


    // $ANTLR start rule__LibIterationCS__Group_5__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2453:1: rule__LibIterationCS__Group_5__1 : rule__LibIterationCS__Group_5__1__Impl ;
    public final void rule__LibIterationCS__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2457:1: ( rule__LibIterationCS__Group_5__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2458:2: rule__LibIterationCS__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__14989);
            rule__LibIterationCS__Group_5__1__Impl();
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
    // $ANTLR end rule__LibIterationCS__Group_5__1


    // $ANTLR start rule__LibIterationCS__Group_5__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2464:1: rule__LibIterationCS__Group_5__1__Impl : ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) ;
    public final void rule__LibIterationCS__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2468:1: ( ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2469:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2469:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2470:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_5_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2471:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2471:2: rule__LibIterationCS__ParametersAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5016);
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
    // $ANTLR end rule__LibIterationCS__Group_5__1__Impl


    // $ANTLR start rule__LibOperationCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2485:1: rule__LibOperationCS__Group__0 : rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 ;
    public final void rule__LibOperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2489:1: ( rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2490:2: rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05050);
            rule__LibOperationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05053);
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


    // $ANTLR start rule__LibOperationCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2497:1: rule__LibOperationCS__Group__0__Impl : ( 'operation' ) ;
    public final void rule__LibOperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2501:1: ( ( 'operation' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2502:1: ( 'operation' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2502:1: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2503:1: 'operation'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5081); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
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
    // $ANTLR end rule__LibOperationCS__Group__0__Impl


    // $ANTLR start rule__LibOperationCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2516:1: rule__LibOperationCS__Group__1 : rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 ;
    public final void rule__LibOperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2520:1: ( rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2521:2: rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15112);
            rule__LibOperationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15115);
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


    // $ANTLR start rule__LibOperationCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2528:1: rule__LibOperationCS__Group__1__Impl : ( ( rule__LibOperationCS__NameAssignment_1 ) ) ;
    public final void rule__LibOperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2532:1: ( ( ( rule__LibOperationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2533:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2533:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2534:1: ( rule__LibOperationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2535:1: ( rule__LibOperationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2535:2: rule__LibOperationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5142);
            rule__LibOperationCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__LibOperationCS__Group__1__Impl


    // $ANTLR start rule__LibOperationCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2545:1: rule__LibOperationCS__Group__2 : rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 ;
    public final void rule__LibOperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2549:1: ( rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2550:2: rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25172);
            rule__LibOperationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25175);
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


    // $ANTLR start rule__LibOperationCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2557:1: rule__LibOperationCS__Group__2__Impl : ( ( rule__LibOperationCS__Group_2__0 )? ) ;
    public final void rule__LibOperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2561:1: ( ( ( rule__LibOperationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2562:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2562:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2563:1: ( rule__LibOperationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2564:1: ( rule__LibOperationCS__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==27) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2564:2: rule__LibOperationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5202);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibOperationCS__Group__2__Impl


    // $ANTLR start rule__LibOperationCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2574:1: rule__LibOperationCS__Group__3 : rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 ;
    public final void rule__LibOperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2578:1: ( rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2579:2: rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35233);
            rule__LibOperationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35236);
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


    // $ANTLR start rule__LibOperationCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2586:1: rule__LibOperationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibOperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2590:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2591:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2591:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2592:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5264); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
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
    // $ANTLR end rule__LibOperationCS__Group__3__Impl


    // $ANTLR start rule__LibOperationCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2605:1: rule__LibOperationCS__Group__4 : rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 ;
    public final void rule__LibOperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2609:1: ( rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2610:2: rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45295);
            rule__LibOperationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45298);
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


    // $ANTLR start rule__LibOperationCS__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2617:1: rule__LibOperationCS__Group__4__Impl : ( ( rule__LibOperationCS__Group_4__0 )? ) ;
    public final void rule__LibOperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2621:1: ( ( ( rule__LibOperationCS__Group_4__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2622:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2622:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2623:1: ( rule__LibOperationCS__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2624:1: ( rule__LibOperationCS__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID_TERMINAL||(LA24_0>=12 && LA24_0<=21)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2624:2: rule__LibOperationCS__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5325);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibOperationCS__Group__4__Impl


    // $ANTLR start rule__LibOperationCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2634:1: rule__LibOperationCS__Group__5 : rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 ;
    public final void rule__LibOperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2638:1: ( rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2639:2: rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55356);
            rule__LibOperationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55359);
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


    // $ANTLR start rule__LibOperationCS__Group__5__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2646:1: rule__LibOperationCS__Group__5__Impl : ( ')' ) ;
    public final void rule__LibOperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2650:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2651:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2651:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2652:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5387); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
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
    // $ANTLR end rule__LibOperationCS__Group__5__Impl


    // $ANTLR start rule__LibOperationCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2665:1: rule__LibOperationCS__Group__6 : rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 ;
    public final void rule__LibOperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2669:1: ( rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2670:2: rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65418);
            rule__LibOperationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65421);
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


    // $ANTLR start rule__LibOperationCS__Group__6__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2677:1: rule__LibOperationCS__Group__6__Impl : ( ':' ) ;
    public final void rule__LibOperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2681:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2682:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2682:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2683:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5449); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
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
    // $ANTLR end rule__LibOperationCS__Group__6__Impl


    // $ANTLR start rule__LibOperationCS__Group__7
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2696:1: rule__LibOperationCS__Group__7 : rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 ;
    public final void rule__LibOperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2700:1: ( rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2701:2: rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75480);
            rule__LibOperationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75483);
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


    // $ANTLR start rule__LibOperationCS__Group__7__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2708:1: rule__LibOperationCS__Group__7__Impl : ( ( rule__LibOperationCS__TypeAssignment_7 ) ) ;
    public final void rule__LibOperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2712:1: ( ( ( rule__LibOperationCS__TypeAssignment_7 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2713:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2713:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2714:1: ( rule__LibOperationCS__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2715:1: ( rule__LibOperationCS__TypeAssignment_7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2715:2: rule__LibOperationCS__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5510);
            rule__LibOperationCS__TypeAssignment_7();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
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
    // $ANTLR end rule__LibOperationCS__Group__7__Impl


    // $ANTLR start rule__LibOperationCS__Group__8
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2725:1: rule__LibOperationCS__Group__8 : rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 ;
    public final void rule__LibOperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2729:1: ( rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2730:2: rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85540);
            rule__LibOperationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85543);
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


    // $ANTLR start rule__LibOperationCS__Group__8__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2737:1: rule__LibOperationCS__Group__8__Impl : ( '=>' ) ;
    public final void rule__LibOperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2741:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2742:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2742:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2743:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5571); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
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
    // $ANTLR end rule__LibOperationCS__Group__8__Impl


    // $ANTLR start rule__LibOperationCS__Group__9
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2756:1: rule__LibOperationCS__Group__9 : rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 ;
    public final void rule__LibOperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2760:1: ( rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2761:2: rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95602);
            rule__LibOperationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95605);
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


    // $ANTLR start rule__LibOperationCS__Group__9__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2768:1: rule__LibOperationCS__Group__9__Impl : ( ( rule__LibOperationCS__ClassAssignment_9 ) ) ;
    public final void rule__LibOperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2772:1: ( ( ( rule__LibOperationCS__ClassAssignment_9 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:1: ( rule__LibOperationCS__ClassAssignment_9 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:1: ( rule__LibOperationCS__ClassAssignment_9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:2: rule__LibOperationCS__ClassAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5632);
            rule__LibOperationCS__ClassAssignment_9();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
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
    // $ANTLR end rule__LibOperationCS__Group__9__Impl


    // $ANTLR start rule__LibOperationCS__Group__10
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2785:1: rule__LibOperationCS__Group__10 : rule__LibOperationCS__Group__10__Impl ;
    public final void rule__LibOperationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2789:1: ( rule__LibOperationCS__Group__10__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2790:2: rule__LibOperationCS__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105662);
            rule__LibOperationCS__Group__10__Impl();
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


    // $ANTLR start rule__LibOperationCS__Group__10__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2796:1: rule__LibOperationCS__Group__10__Impl : ( ';' ) ;
    public final void rule__LibOperationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2800:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2801:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2801:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2802:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5690); if (failed) return ;
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
    // $ANTLR end rule__LibOperationCS__Group__10__Impl


    // $ANTLR start rule__LibOperationCS__Group_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2837:1: rule__LibOperationCS__Group_2__0 : rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 ;
    public final void rule__LibOperationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2841:1: ( rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2842:2: rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05743);
            rule__LibOperationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05746);
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


    // $ANTLR start rule__LibOperationCS__Group_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2849:1: rule__LibOperationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibOperationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2853:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2854:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2854:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2855:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5774); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
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
    // $ANTLR end rule__LibOperationCS__Group_2__0__Impl


    // $ANTLR start rule__LibOperationCS__Group_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2868:1: rule__LibOperationCS__Group_2__1 : rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 ;
    public final void rule__LibOperationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2872:1: ( rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2873:2: rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15805);
            rule__LibOperationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15808);
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


    // $ANTLR start rule__LibOperationCS__Group_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2880:1: rule__LibOperationCS__Group_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2884:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2885:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2885:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2886:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2887:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2887:2: rule__LibOperationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5835);
            rule__LibOperationCS__TypeParametersAssignment_2_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
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
    // $ANTLR end rule__LibOperationCS__Group_2__1__Impl


    // $ANTLR start rule__LibOperationCS__Group_2__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2897:1: rule__LibOperationCS__Group_2__2 : rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 ;
    public final void rule__LibOperationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2901:1: ( rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2902:2: rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25865);
            rule__LibOperationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25868);
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


    // $ANTLR start rule__LibOperationCS__Group_2__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2909:1: rule__LibOperationCS__Group_2__2__Impl : ( ( rule__LibOperationCS__Group_2_2__0 )* ) ;
    public final void rule__LibOperationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2913:1: ( ( ( rule__LibOperationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2914:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2914:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2915:1: ( rule__LibOperationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2916:1: ( rule__LibOperationCS__Group_2_2__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2916:2: rule__LibOperationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl5895);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibOperationCS__Group_2__2__Impl


    // $ANTLR start rule__LibOperationCS__Group_2__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2926:1: rule__LibOperationCS__Group_2__3 : rule__LibOperationCS__Group_2__3__Impl ;
    public final void rule__LibOperationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2930:1: ( rule__LibOperationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2931:2: rule__LibOperationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__35926);
            rule__LibOperationCS__Group_2__3__Impl();
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
    // $ANTLR end rule__LibOperationCS__Group_2__3


    // $ANTLR start rule__LibOperationCS__Group_2__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2937:1: rule__LibOperationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibOperationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2941:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2942:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2942:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2943:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl5954); if (failed) return ;
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
    // $ANTLR end rule__LibOperationCS__Group_2__3__Impl


    // $ANTLR start rule__LibOperationCS__Group_2_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2964:1: rule__LibOperationCS__Group_2_2__0 : rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 ;
    public final void rule__LibOperationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2968:1: ( rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2969:2: rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__05993);
            rule__LibOperationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__05996);
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


    // $ANTLR start rule__LibOperationCS__Group_2_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2976:1: rule__LibOperationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2980:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2981:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2981:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2982:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6024); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
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
    // $ANTLR end rule__LibOperationCS__Group_2_2__0__Impl


    // $ANTLR start rule__LibOperationCS__Group_2_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2995:1: rule__LibOperationCS__Group_2_2__1 : rule__LibOperationCS__Group_2_2__1__Impl ;
    public final void rule__LibOperationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2999:1: ( rule__LibOperationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3000:2: rule__LibOperationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16055);
            rule__LibOperationCS__Group_2_2__1__Impl();
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
    // $ANTLR end rule__LibOperationCS__Group_2_2__1


    // $ANTLR start rule__LibOperationCS__Group_2_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3006:1: rule__LibOperationCS__Group_2_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3010:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3011:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3011:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3012:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3013:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3013:2: rule__LibOperationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6082);
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
    // $ANTLR end rule__LibOperationCS__Group_2_2__1__Impl


    // $ANTLR start rule__LibOperationCS__Group_4__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3027:1: rule__LibOperationCS__Group_4__0 : rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 ;
    public final void rule__LibOperationCS__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3031:1: ( rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3032:2: rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06116);
            rule__LibOperationCS__Group_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06119);
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


    // $ANTLR start rule__LibOperationCS__Group_4__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3039:1: rule__LibOperationCS__Group_4__0__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) ;
    public final void rule__LibOperationCS__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3043:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3045:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3046:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3046:2: rule__LibOperationCS__ParametersAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6146);
            rule__LibOperationCS__ParametersAssignment_4_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
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
    // $ANTLR end rule__LibOperationCS__Group_4__0__Impl


    // $ANTLR start rule__LibOperationCS__Group_4__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3056:1: rule__LibOperationCS__Group_4__1 : rule__LibOperationCS__Group_4__1__Impl ;
    public final void rule__LibOperationCS__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3060:1: ( rule__LibOperationCS__Group_4__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3061:2: rule__LibOperationCS__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16176);
            rule__LibOperationCS__Group_4__1__Impl();
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
    // $ANTLR end rule__LibOperationCS__Group_4__1


    // $ANTLR start rule__LibOperationCS__Group_4__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3067:1: rule__LibOperationCS__Group_4__1__Impl : ( ( rule__LibOperationCS__Group_4_1__0 )* ) ;
    public final void rule__LibOperationCS__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3071:1: ( ( ( rule__LibOperationCS__Group_4_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3072:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3072:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3073:1: ( rule__LibOperationCS__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3074:1: ( rule__LibOperationCS__Group_4_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==29) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3074:2: rule__LibOperationCS__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6203);
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
    // $ANTLR end rule__LibOperationCS__Group_4__1__Impl


    // $ANTLR start rule__LibOperationCS__Group_4_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3088:1: rule__LibOperationCS__Group_4_1__0 : rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 ;
    public final void rule__LibOperationCS__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3092:1: ( rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3093:2: rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06238);
            rule__LibOperationCS__Group_4_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06241);
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


    // $ANTLR start rule__LibOperationCS__Group_4_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3100:1: rule__LibOperationCS__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3106:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6269); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
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
    // $ANTLR end rule__LibOperationCS__Group_4_1__0__Impl


    // $ANTLR start rule__LibOperationCS__Group_4_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3119:1: rule__LibOperationCS__Group_4_1__1 : rule__LibOperationCS__Group_4_1__1__Impl ;
    public final void rule__LibOperationCS__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3123:1: ( rule__LibOperationCS__Group_4_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3124:2: rule__LibOperationCS__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16300);
            rule__LibOperationCS__Group_4_1__1__Impl();
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
    // $ANTLR end rule__LibOperationCS__Group_4_1__1


    // $ANTLR start rule__LibOperationCS__Group_4_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3130:1: rule__LibOperationCS__Group_4_1__1__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__LibOperationCS__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3134:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3135:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3135:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3136:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3137:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3137:2: rule__LibOperationCS__ParametersAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6327);
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
    // $ANTLR end rule__LibOperationCS__Group_4_1__1__Impl


    // $ANTLR start rule__LibPackageCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3151:1: rule__LibPackageCS__Group__0 : rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 ;
    public final void rule__LibPackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3155:1: ( rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3156:2: rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06361);
            rule__LibPackageCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06364);
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


    // $ANTLR start rule__LibPackageCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3163:1: rule__LibPackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__LibPackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3167:1: ( ( 'package' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3168:1: ( 'package' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3168:1: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3169:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6392); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
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
    // $ANTLR end rule__LibPackageCS__Group__0__Impl


    // $ANTLR start rule__LibPackageCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3182:1: rule__LibPackageCS__Group__1 : rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 ;
    public final void rule__LibPackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3186:1: ( rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3187:2: rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16423);
            rule__LibPackageCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16426);
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


    // $ANTLR start rule__LibPackageCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3194:1: rule__LibPackageCS__Group__1__Impl : ( ( rule__LibPackageCS__NameAssignment_1 ) ) ;
    public final void rule__LibPackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3198:1: ( ( ( rule__LibPackageCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3199:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3199:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3200:1: ( rule__LibPackageCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3201:1: ( rule__LibPackageCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3201:2: rule__LibPackageCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6453);
            rule__LibPackageCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__LibPackageCS__Group__1__Impl


    // $ANTLR start rule__LibPackageCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3211:1: rule__LibPackageCS__Group__2 : rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 ;
    public final void rule__LibPackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3215:1: ( rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3216:2: rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26483);
            rule__LibPackageCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26486);
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


    // $ANTLR start rule__LibPackageCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3223:1: rule__LibPackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__LibPackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3227:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3228:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3228:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3229:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6514); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
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
    // $ANTLR end rule__LibPackageCS__Group__2__Impl


    // $ANTLR start rule__LibPackageCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3242:1: rule__LibPackageCS__Group__3 : rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 ;
    public final void rule__LibPackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3246:1: ( rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3247:2: rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36545);
            rule__LibPackageCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36548);
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


    // $ANTLR start rule__LibPackageCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3254:1: rule__LibPackageCS__Group__3__Impl : ( ( rule__LibPackageCS__Alternatives_3 )* ) ;
    public final void rule__LibPackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3258:1: ( ( ( rule__LibPackageCS__Alternatives_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3259:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3259:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3260:1: ( rule__LibPackageCS__Alternatives_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3261:1: ( rule__LibPackageCS__Alternatives_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==18||LA27_0==21) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3261:2: rule__LibPackageCS__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6575);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibPackageCS__Group__3__Impl


    // $ANTLR start rule__LibPackageCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3271:1: rule__LibPackageCS__Group__4 : rule__LibPackageCS__Group__4__Impl ;
    public final void rule__LibPackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3275:1: ( rule__LibPackageCS__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3276:2: rule__LibPackageCS__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46606);
            rule__LibPackageCS__Group__4__Impl();
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
    // $ANTLR end rule__LibPackageCS__Group__4


    // $ANTLR start rule__LibPackageCS__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3282:1: rule__LibPackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__LibPackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3286:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3287:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3287:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3288:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6634); if (failed) return ;
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
    // $ANTLR end rule__LibPackageCS__Group__4__Impl


    // $ANTLR start rule__LibParameterCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3311:1: rule__LibParameterCS__Group__0 : rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 ;
    public final void rule__LibParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3315:1: ( rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3316:2: rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06675);
            rule__LibParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06678);
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


    // $ANTLR start rule__LibParameterCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3323:1: rule__LibParameterCS__Group__0__Impl : ( ( rule__LibParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3327:1: ( ( ( rule__LibParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3328:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3328:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3329:1: ( rule__LibParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3330:1: ( rule__LibParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3330:2: rule__LibParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6705);
            rule__LibParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
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
    // $ANTLR end rule__LibParameterCS__Group__0__Impl


    // $ANTLR start rule__LibParameterCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3340:1: rule__LibParameterCS__Group__1 : rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 ;
    public final void rule__LibParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3344:1: ( rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3345:2: rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16735);
            rule__LibParameterCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16738);
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


    // $ANTLR start rule__LibParameterCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3352:1: rule__LibParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__LibParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3356:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3357:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3357:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3358:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6766); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
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
    // $ANTLR end rule__LibParameterCS__Group__1__Impl


    // $ANTLR start rule__LibParameterCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3371:1: rule__LibParameterCS__Group__2 : rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 ;
    public final void rule__LibParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3375:1: ( rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3376:2: rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26797);
            rule__LibParameterCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26800);
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


    // $ANTLR start rule__LibParameterCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3383:1: rule__LibParameterCS__Group__2__Impl : ( ( rule__LibParameterCS__TypeAssignment_2 ) ) ;
    public final void rule__LibParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3387:1: ( ( ( rule__LibParameterCS__TypeAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3389:1: ( rule__LibParameterCS__TypeAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:1: ( rule__LibParameterCS__TypeAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:2: rule__LibParameterCS__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6827);
            rule__LibParameterCS__TypeAssignment_2();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
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
    // $ANTLR end rule__LibParameterCS__Group__2__Impl


    // $ANTLR start rule__LibParameterCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3400:1: rule__LibParameterCS__Group__3 : rule__LibParameterCS__Group__3__Impl ;
    public final void rule__LibParameterCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3404:1: ( rule__LibParameterCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3405:2: rule__LibParameterCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36857);
            rule__LibParameterCS__Group__3__Impl();
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
    // $ANTLR end rule__LibParameterCS__Group__3


    // $ANTLR start rule__LibParameterCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3411:1: rule__LibParameterCS__Group__3__Impl : ( ( rule__LibParameterCS__Group_3__0 )? ) ;
    public final void rule__LibParameterCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3415:1: ( ( ( rule__LibParameterCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3416:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3416:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3417:1: ( rule__LibParameterCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3418:1: ( rule__LibParameterCS__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3418:2: rule__LibParameterCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl6884);
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
    // $ANTLR end rule__LibParameterCS__Group__3__Impl


    // $ANTLR start rule__LibParameterCS__Group_3__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3436:1: rule__LibParameterCS__Group_3__0 : rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 ;
    public final void rule__LibParameterCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3440:1: ( rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3441:2: rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__06923);
            rule__LibParameterCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__06926);
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


    // $ANTLR start rule__LibParameterCS__Group_3__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3448:1: rule__LibParameterCS__Group_3__0__Impl : ( '[' ) ;
    public final void rule__LibParameterCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3452:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3453:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3453:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3454:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl6954); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
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
    // $ANTLR end rule__LibParameterCS__Group_3__0__Impl


    // $ANTLR start rule__LibParameterCS__Group_3__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3467:1: rule__LibParameterCS__Group_3__1 : rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 ;
    public final void rule__LibParameterCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3471:1: ( rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3472:2: rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__16985);
            rule__LibParameterCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__16988);
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


    // $ANTLR start rule__LibParameterCS__Group_3__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3479:1: rule__LibParameterCS__Group_3__1__Impl : ( ( rule__LibParameterCS__Alternatives_3_1 ) ) ;
    public final void rule__LibParameterCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3483:1: ( ( ( rule__LibParameterCS__Alternatives_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3484:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3484:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3485:1: ( rule__LibParameterCS__Alternatives_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3486:1: ( rule__LibParameterCS__Alternatives_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3486:2: rule__LibParameterCS__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7015);
            rule__LibParameterCS__Alternatives_3_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
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
    // $ANTLR end rule__LibParameterCS__Group_3__1__Impl


    // $ANTLR start rule__LibParameterCS__Group_3__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:1: rule__LibParameterCS__Group_3__2 : rule__LibParameterCS__Group_3__2__Impl ;
    public final void rule__LibParameterCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3500:1: ( rule__LibParameterCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3501:2: rule__LibParameterCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27045);
            rule__LibParameterCS__Group_3__2__Impl();
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
    // $ANTLR end rule__LibParameterCS__Group_3__2


    // $ANTLR start rule__LibParameterCS__Group_3__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3507:1: rule__LibParameterCS__Group_3__2__Impl : ( ']' ) ;
    public final void rule__LibParameterCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3511:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3512:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3512:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3513:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7073); if (failed) return ;
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
    // $ANTLR end rule__LibParameterCS__Group_3__2__Impl


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3532:1: rule__LibParameterCS__Group_3_1_0__0 : rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 ;
    public final void rule__LibParameterCS__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3536:1: ( rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3537:2: rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07110);
            rule__LibParameterCS__Group_3_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07113);
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


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: rule__LibParameterCS__Group_3_1_0__0__Impl : ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3548:1: ( ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3549:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3549:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3550:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3551:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3551:2: rule__LibParameterCS__LowerAssignment_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7140);
            rule__LibParameterCS__LowerAssignment_3_1_0_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0__0__Impl


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3561:1: rule__LibParameterCS__Group_3_1_0__1 : rule__LibParameterCS__Group_3_1_0__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3565:1: ( rule__LibParameterCS__Group_3_1_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3566:2: rule__LibParameterCS__Group_3_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17170);
            rule__LibParameterCS__Group_3_1_0__1__Impl();
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0__1


    // $ANTLR start rule__LibParameterCS__Group_3_1_0__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3572:1: rule__LibParameterCS__Group_3_1_0__1__Impl : ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) ;
    public final void rule__LibParameterCS__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3576:1: ( ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3577:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3577:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3578:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3579:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3579:2: rule__LibParameterCS__Group_3_1_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7197);
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0__1__Impl


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3593:1: rule__LibParameterCS__Group_3_1_0_1__0 : rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3597:1: ( rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3598:2: rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07232);
            rule__LibParameterCS__Group_3_1_0_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07235);
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


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3605:1: rule__LibParameterCS__Group_3_1_0_1__0__Impl : ( '..' ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3609:1: ( ( '..' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3610:1: ( '..' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3610:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3611:1: '..'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7263); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0_1__0__Impl


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3624:1: rule__LibParameterCS__Group_3_1_0_1__1 : rule__LibParameterCS__Group_3_1_0_1__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3628:1: ( rule__LibParameterCS__Group_3_1_0_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3629:2: rule__LibParameterCS__Group_3_1_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17294);
            rule__LibParameterCS__Group_3_1_0_1__1__Impl();
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0_1__1


    // $ANTLR start rule__LibParameterCS__Group_3_1_0_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3635:1: rule__LibParameterCS__Group_3_1_0_1__1__Impl : ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3639:1: ( ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3640:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3640:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3641:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3642:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3642:2: rule__LibParameterCS__UpperAssignment_3_1_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7321);
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
    // $ANTLR end rule__LibParameterCS__Group_3_1_0_1__1__Impl


    // $ANTLR start rule__LibPropertyCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3656:1: rule__LibPropertyCS__Group__0 : rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 ;
    public final void rule__LibPropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3660:1: ( rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3661:2: rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07355);
            rule__LibPropertyCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07358);
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


    // $ANTLR start rule__LibPropertyCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3668:1: rule__LibPropertyCS__Group__0__Impl : ( 'property' ) ;
    public final void rule__LibPropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3672:1: ( ( 'property' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3673:1: ( 'property' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3673:1: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3674:1: 'property'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7386); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__0__Impl


    // $ANTLR start rule__LibPropertyCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3687:1: rule__LibPropertyCS__Group__1 : rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 ;
    public final void rule__LibPropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3691:1: ( rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3692:2: rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17417);
            rule__LibPropertyCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17420);
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


    // $ANTLR start rule__LibPropertyCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3699:1: rule__LibPropertyCS__Group__1__Impl : ( ( rule__LibPropertyCS__NameAssignment_1 ) ) ;
    public final void rule__LibPropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3703:1: ( ( ( rule__LibPropertyCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3704:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3704:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3705:1: ( rule__LibPropertyCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3706:1: ( rule__LibPropertyCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3706:2: rule__LibPropertyCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7447);
            rule__LibPropertyCS__NameAssignment_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__1__Impl


    // $ANTLR start rule__LibPropertyCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3716:1: rule__LibPropertyCS__Group__2 : rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 ;
    public final void rule__LibPropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3720:1: ( rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3721:2: rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27477);
            rule__LibPropertyCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27480);
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


    // $ANTLR start rule__LibPropertyCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3728:1: rule__LibPropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__LibPropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3732:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3733:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3733:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3734:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7508); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__2__Impl


    // $ANTLR start rule__LibPropertyCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3747:1: rule__LibPropertyCS__Group__3 : rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 ;
    public final void rule__LibPropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3751:1: ( rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3752:2: rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37539);
            rule__LibPropertyCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37542);
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


    // $ANTLR start rule__LibPropertyCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3759:1: rule__LibPropertyCS__Group__3__Impl : ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) ;
    public final void rule__LibPropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3763:1: ( ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3764:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3764:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3765:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3766:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3766:2: rule__LibPropertyCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7569);
            rule__LibPropertyCS__TypeAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__3__Impl


    // $ANTLR start rule__LibPropertyCS__Group__4
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3776:1: rule__LibPropertyCS__Group__4 : rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 ;
    public final void rule__LibPropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3780:1: ( rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3781:2: rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47599);
            rule__LibPropertyCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47602);
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


    // $ANTLR start rule__LibPropertyCS__Group__4__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3788:1: rule__LibPropertyCS__Group__4__Impl : ( '=>' ) ;
    public final void rule__LibPropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3792:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3793:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3793:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3794:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7630); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__4__Impl


    // $ANTLR start rule__LibPropertyCS__Group__5
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3807:1: rule__LibPropertyCS__Group__5 : rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 ;
    public final void rule__LibPropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3811:1: ( rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3812:2: rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57661);
            rule__LibPropertyCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57664);
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


    // $ANTLR start rule__LibPropertyCS__Group__5__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3819:1: rule__LibPropertyCS__Group__5__Impl : ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) ;
    public final void rule__LibPropertyCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3823:1: ( ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3824:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3824:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3825:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3826:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3826:2: rule__LibPropertyCS__ClassAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7691);
            rule__LibPropertyCS__ClassAssignment_5();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
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
    // $ANTLR end rule__LibPropertyCS__Group__5__Impl


    // $ANTLR start rule__LibPropertyCS__Group__6
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3836:1: rule__LibPropertyCS__Group__6 : rule__LibPropertyCS__Group__6__Impl ;
    public final void rule__LibPropertyCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3840:1: ( rule__LibPropertyCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3841:2: rule__LibPropertyCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67721);
            rule__LibPropertyCS__Group__6__Impl();
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


    // $ANTLR start rule__LibPropertyCS__Group__6__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3847:1: rule__LibPropertyCS__Group__6__Impl : ( ';' ) ;
    public final void rule__LibPropertyCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3851:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3852:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3852:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3853:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7749); if (failed) return ;
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
    // $ANTLR end rule__LibPropertyCS__Group__6__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3880:1: rule__LibQualifiedTypeRefCS__Group__0 : rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3884:1: ( rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3885:2: rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07794);
            rule__LibQualifiedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07797);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3892:1: rule__LibQualifiedTypeRefCS__Group__0__Impl : ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3896:1: ( ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3897:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3897:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3898:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3899:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3899:2: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7824);
            rule__LibQualifiedTypeRefCS__NamespaceAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__0__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3909:1: rule__LibQualifiedTypeRefCS__Group__1 : rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3913:1: ( rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3914:2: rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17854);
            rule__LibQualifiedTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17857);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3921:1: rule__LibQualifiedTypeRefCS__Group__1__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3925:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3926:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3926:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3927:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3928:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3928:2: rule__LibQualifiedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl7884);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__1__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3938:1: rule__LibQualifiedTypeRefCS__Group__2 : rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3942:1: ( rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3943:2: rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__27915);
            rule__LibQualifiedTypeRefCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__27918);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3950:1: rule__LibQualifiedTypeRefCS__Group__2__Impl : ( '::' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3954:1: ( ( '::' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3955:1: ( '::' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3955:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3956:1: '::'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }
            match(input,37,FollowSets000.FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl7946); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__2__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3969:1: rule__LibQualifiedTypeRefCS__Group__3 : rule__LibQualifiedTypeRefCS__Group__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3973:1: ( rule__LibQualifiedTypeRefCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3974:2: rule__LibQualifiedTypeRefCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__37977);
            rule__LibQualifiedTypeRefCS__Group__3__Impl();
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__3


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3980:1: rule__LibQualifiedTypeRefCS__Group__3__Impl : ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3984:1: ( ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3985:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3985:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3986:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3987:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3987:2: rule__LibQualifiedTypeRefCS__ElementAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8004);
            rule__LibQualifiedTypeRefCS__ElementAssignment_3();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementAssignment_3()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group__3__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4005:1: rule__LibQualifiedTypeRefCS__Group_1__0 : rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4009:1: ( rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4010:2: rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08042);
            rule__LibQualifiedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08045);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4017:1: rule__LibQualifiedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4021:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4022:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4022:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4023:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8073); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__0__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4036:1: rule__LibQualifiedTypeRefCS__Group_1__1 : rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4040:1: ( rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4041:2: rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18104);
            rule__LibQualifiedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18107);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4048:1: rule__LibQualifiedTypeRefCS__Group_1__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4052:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4053:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4053:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4054:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4055:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4055:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8134);
            rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__1__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4065:1: rule__LibQualifiedTypeRefCS__Group_1__2 : rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4069:1: ( rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4070:2: rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28164);
            rule__LibQualifiedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28167);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4077:1: rule__LibQualifiedTypeRefCS__Group_1__2__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4081:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4083:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4084:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==29) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4084:2: rule__LibQualifiedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8194);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__2__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4094:1: rule__LibQualifiedTypeRefCS__Group_1__3 : rule__LibQualifiedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4098:1: ( rule__LibQualifiedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4099:2: rule__LibQualifiedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38225);
            rule__LibQualifiedTypeRefCS__Group_1__3__Impl();
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__3


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4105:1: rule__LibQualifiedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4109:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4110:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4110:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4111:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8253); if (failed) return ;
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1__3__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4132:1: rule__LibQualifiedTypeRefCS__Group_1_2__0 : rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4136:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4137:2: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08292);
            rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08295);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4144:1: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4148:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4149:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4149:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4150:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8323); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4163:1: rule__LibQualifiedTypeRefCS__Group_1_2__1 : rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4167:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4168:2: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18354);
            rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl();
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1_2__1


    // $ANTLR start rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4174:1: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4178:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4179:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4179:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4180:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4181:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4181:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8381);
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4195:1: rule__LibTypeParameterCS__Group__0 : rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 ;
    public final void rule__LibTypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4199:1: ( rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4200:2: rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08415);
            rule__LibTypeParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08418);
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


    // $ANTLR start rule__LibTypeParameterCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4207:1: rule__LibTypeParameterCS__Group__0__Impl : ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibTypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4211:1: ( ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4212:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4212:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4213:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4214:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4214:2: rule__LibTypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8445);
            rule__LibTypeParameterCS__NameAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
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
    // $ANTLR end rule__LibTypeParameterCS__Group__0__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4224:1: rule__LibTypeParameterCS__Group__1 : rule__LibTypeParameterCS__Group__1__Impl ;
    public final void rule__LibTypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4228:1: ( rule__LibTypeParameterCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4229:2: rule__LibTypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18475);
            rule__LibTypeParameterCS__Group__1__Impl();
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
    // $ANTLR end rule__LibTypeParameterCS__Group__1


    // $ANTLR start rule__LibTypeParameterCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4235:1: rule__LibTypeParameterCS__Group__1__Impl : ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__LibTypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4239:1: ( ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4240:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4240:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4241:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4242:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==13||LA32_0==20) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4242:2: rule__LibTypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8502);
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
    // $ANTLR end rule__LibTypeParameterCS__Group__1__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4256:1: rule__LibTypeParameterCS__Group_1_0__0 : rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4260:1: ( rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4261:2: rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08537);
            rule__LibTypeParameterCS__Group_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08540);
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


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4268:1: rule__LibTypeParameterCS__Group_1_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4272:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4273:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4273:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4274:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8568); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__0__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4287:1: rule__LibTypeParameterCS__Group_1_0__1 : rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 ;
    public final void rule__LibTypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4291:1: ( rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4292:2: rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18599);
            rule__LibTypeParameterCS__Group_1_0__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18602);
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


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4299:1: rule__LibTypeParameterCS__Group_1_0__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4303:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4304:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4304:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4305:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4306:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4306:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8629);
            rule__LibTypeParameterCS__ExtendsAssignment_1_0_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__1__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4316:1: rule__LibTypeParameterCS__Group_1_0__2 : rule__LibTypeParameterCS__Group_1_0__2__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4320:1: ( rule__LibTypeParameterCS__Group_1_0__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4321:2: rule__LibTypeParameterCS__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28659);
            rule__LibTypeParameterCS__Group_1_0__2__Impl();
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__2


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4327:1: rule__LibTypeParameterCS__Group_1_0__2__Impl : ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4331:1: ( ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4332:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4332:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4333:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4334:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==38) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4334:2: rule__LibTypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8686);
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0__2__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4350:1: rule__LibTypeParameterCS__Group_1_0_2__0 : rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4354:1: ( rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4355:2: rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08723);
            rule__LibTypeParameterCS__Group_1_0_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08726);
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


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4362:1: rule__LibTypeParameterCS__Group_1_0_2__0__Impl : ( '&&' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4366:1: ( ( '&&' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4367:1: ( '&&' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4367:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4368:1: '&&'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,38,FollowSets000.FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8754); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0_2__0__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4381:1: rule__LibTypeParameterCS__Group_1_0_2__1 : rule__LibTypeParameterCS__Group_1_0_2__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4385:1: ( rule__LibTypeParameterCS__Group_1_0_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4386:2: rule__LibTypeParameterCS__Group_1_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18785);
            rule__LibTypeParameterCS__Group_1_0_2__1__Impl();
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0_2__1


    // $ANTLR start rule__LibTypeParameterCS__Group_1_0_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4392:1: rule__LibTypeParameterCS__Group_1_0_2__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4396:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4397:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4397:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4398:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4399:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4399:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8812);
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_0_2__1__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4413:1: rule__LibTypeParameterCS__Group_1_1__0 : rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 ;
    public final void rule__LibTypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4417:1: ( rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4418:2: rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08846);
            rule__LibTypeParameterCS__Group_1_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08849);
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


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4425:1: rule__LibTypeParameterCS__Group_1_1__0__Impl : ( 'super' ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4429:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4430:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4430:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4431:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl8877); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_1__0__Impl


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4444:1: rule__LibTypeParameterCS__Group_1_1__1 : rule__LibTypeParameterCS__Group_1_1__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4448:1: ( rule__LibTypeParameterCS__Group_1_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4449:2: rule__LibTypeParameterCS__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__18908);
            rule__LibTypeParameterCS__Group_1_1__1__Impl();
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_1__1


    // $ANTLR start rule__LibTypeParameterCS__Group_1_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4455:1: rule__LibTypeParameterCS__Group_1_1__1__Impl : ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4459:1: ( ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4460:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4460:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4461:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4462:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4462:2: rule__LibTypeParameterCS__SuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl8935);
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
    // $ANTLR end rule__LibTypeParameterCS__Group_1_1__1__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4476:1: rule__LibTypedTypeRefCS__Group__0 : rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 ;
    public final void rule__LibTypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4480:1: ( rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4481:2: rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__08969);
            rule__LibTypedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__08972);
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


    // $ANTLR start rule__LibTypedTypeRefCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4488:1: rule__LibTypedTypeRefCS__Group__0__Impl : ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4492:1: ( ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4493:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4493:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4494:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4495:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4495:2: rule__LibTypedTypeRefCS__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl8999);
            rule__LibTypedTypeRefCS__TypeAssignment_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group__0__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4505:1: rule__LibTypedTypeRefCS__Group__1 : rule__LibTypedTypeRefCS__Group__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4509:1: ( rule__LibTypedTypeRefCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4510:2: rule__LibTypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19029);
            rule__LibTypedTypeRefCS__Group__1__Impl();
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group__1


    // $ANTLR start rule__LibTypedTypeRefCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4516:1: rule__LibTypedTypeRefCS__Group__1__Impl : ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibTypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4520:1: ( ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4521:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4521:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4522:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4523:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4523:2: rule__LibTypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9056);
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group__1__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4537:1: rule__LibTypedTypeRefCS__Group_1__0 : rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4541:1: ( rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4542:2: rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09091);
            rule__LibTypedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09094);
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


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4549:1: rule__LibTypedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4553:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4554:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4554:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4555:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9122); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__0__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4568:1: rule__LibTypedTypeRefCS__Group_1__1 : rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 ;
    public final void rule__LibTypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4572:1: ( rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4573:2: rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19153);
            rule__LibTypedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19156);
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


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4580:1: rule__LibTypedTypeRefCS__Group_1__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4584:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4585:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4585:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4586:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4587:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4587:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9183);
            rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__1__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4597:1: rule__LibTypedTypeRefCS__Group_1__2 : rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 ;
    public final void rule__LibTypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4601:1: ( rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4602:2: rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29213);
            rule__LibTypedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29216);
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


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4609:1: rule__LibTypedTypeRefCS__Group_1__2__Impl : ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4613:1: ( ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4614:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4614:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4615:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4616:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==29) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4616:2: rule__LibTypedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9243);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__2__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4626:1: rule__LibTypedTypeRefCS__Group_1__3 : rule__LibTypedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4630:1: ( rule__LibTypedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4631:2: rule__LibTypedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39274);
            rule__LibTypedTypeRefCS__Group_1__3__Impl();
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__3


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1__3__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4637:1: rule__LibTypedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4641:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4642:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4642:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4643:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9302); if (failed) return ;
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1__3__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4664:1: rule__LibTypedTypeRefCS__Group_1_2__0 : rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4668:1: ( rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4669:2: rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09341);
            rule__LibTypedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09344);
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


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4676:1: rule__LibTypedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4680:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4681:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4681:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4682:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9372); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1_2__0__Impl


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4695:1: rule__LibTypedTypeRefCS__Group_1_2__1 : rule__LibTypedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4699:1: ( rule__LibTypedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4700:2: rule__LibTypedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19403);
            rule__LibTypedTypeRefCS__Group_1_2__1__Impl();
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1_2__1


    // $ANTLR start rule__LibTypedTypeRefCS__Group_1_2__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4706:1: rule__LibTypedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4710:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4711:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4711:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4712:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4713:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4713:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9430);
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
    // $ANTLR end rule__LibTypedTypeRefCS__Group_1_2__1__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4727:1: rule__LibWildcardTypeRefCS__Group__0 : rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 ;
    public final void rule__LibWildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4731:1: ( rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4732:2: rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09464);
            rule__LibWildcardTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09467);
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


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4739:1: rule__LibWildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__LibWildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4743:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4744:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4744:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4745:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4746:1: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4748:1: 
            {
            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__0__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4758:1: rule__LibWildcardTypeRefCS__Group__1 : rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 ;
    public final void rule__LibWildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4762:1: ( rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4763:2: rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19525);
            rule__LibWildcardTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19528);
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


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4770:1: rule__LibWildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__LibWildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4774:1: ( ( '?' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4775:1: ( '?' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4775:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4776:1: '?'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9556); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__1__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__2
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4789:1: rule__LibWildcardTypeRefCS__Group__2 : rule__LibWildcardTypeRefCS__Group__2__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4793:1: ( rule__LibWildcardTypeRefCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4794:2: rule__LibWildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29587);
            rule__LibWildcardTypeRefCS__Group__2__Impl();
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__2


    // $ANTLR start rule__LibWildcardTypeRefCS__Group__2__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4800:1: rule__LibWildcardTypeRefCS__Group__2__Impl : ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__LibWildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4804:1: ( ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4805:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4805:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4806:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4807:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==13||LA36_0==20) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4807:2: rule__LibWildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9614);
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group__2__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4823:1: rule__LibWildcardTypeRefCS__Group_2_0__0 : rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4827:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4828:2: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09651);
            rule__LibWildcardTypeRefCS__Group_2_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09654);
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


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4835:1: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4839:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4840:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4840:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4841:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9682); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_0__0__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4854:1: rule__LibWildcardTypeRefCS__Group_2_0__1 : rule__LibWildcardTypeRefCS__Group_2_0__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4858:1: ( rule__LibWildcardTypeRefCS__Group_2_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4859:2: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19713);
            rule__LibWildcardTypeRefCS__Group_2_0__1__Impl();
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_0__1


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_0__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4865:1: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl : ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4869:1: ( ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4870:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4870:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4871:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4872:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4872:2: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9740);
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_0__1__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4886:1: rule__LibWildcardTypeRefCS__Group_2_1__0 : rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4890:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4891:2: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09774);
            rule__LibWildcardTypeRefCS__Group_2_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09777);
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


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__0__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4898:1: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl : ( 'super' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4902:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4903:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4903:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4904:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9805); if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_1__0__Impl


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4917:1: rule__LibWildcardTypeRefCS__Group_2_1__1 : rule__LibWildcardTypeRefCS__Group_2_1__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4921:1: ( rule__LibWildcardTypeRefCS__Group_2_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4922:2: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19836);
            rule__LibWildcardTypeRefCS__Group_2_1__1__Impl();
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_1__1


    // $ANTLR start rule__LibWildcardTypeRefCS__Group_2_1__1__Impl
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4928:1: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl : ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4932:1: ( ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4933:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4933:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4934:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4935:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4935:2: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9863);
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
    // $ANTLR end rule__LibWildcardTypeRefCS__Group_2_1__1__Impl


    // $ANTLR start rule__Library__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4950:1: rule__Library__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4954:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4955:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4955:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4956:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_19902);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4965:1: rule__Library__ImportsAssignment_2 : ( ruleLibImportCS ) ;
    public final void rule__Library__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4969:1: ( ( ruleLibImportCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4970:1: ( ruleLibImportCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4970:1: ( ruleLibImportCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4971:1: ruleLibImportCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_29933);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4980:1: rule__Library__PackagesAssignment_4 : ( ruleLibPackageCS ) ;
    public final void rule__Library__PackagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4984:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4985:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4985:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4986:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_49964);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4995:1: rule__LibImportCS__NameAssignment_1_0 : ( ruleIdentifier ) ;
    public final void rule__LibImportCS__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4999:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5000:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5000:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5001:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_09995);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5010:1: rule__LibImportCS__NamespaceAssignment_2 : ( ( RULE_SINGLE_QUOTED_STRING ) ) ;
    public final void rule__LibImportCS__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5014:1: ( ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5015:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5015:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5016:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5017:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5018:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210030); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5029:1: rule__LibClassCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5033:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5034:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5034:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5035:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110065);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5044:1: rule__LibClassCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5048:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5049:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5049:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5050:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110096);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5059:1: rule__LibClassCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5063:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5064:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5064:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5065:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110127);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5074:1: rule__LibClassCS__ConformsToAssignment_3_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5078:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5079:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5079:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5080:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110158);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5089:1: rule__LibClassCS__ConformsToAssignment_3_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5093:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5094:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5094:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5095:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110189);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5104:1: rule__LibClassCS__IterationsAssignment_5_0 : ( ruleLibIterationCS ) ;
    public final void rule__LibClassCS__IterationsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5108:1: ( ( ruleLibIterationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5109:1: ( ruleLibIterationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5109:1: ( ruleLibIterationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5110:1: ruleLibIterationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_010220);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5119:1: rule__LibClassCS__OperationsAssignment_5_1 : ( ruleLibOperationCS ) ;
    public final void rule__LibClassCS__OperationsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5123:1: ( ( ruleLibOperationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5124:1: ( ruleLibOperationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5124:1: ( ruleLibOperationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5125:1: ruleLibOperationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_110251);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5134:1: rule__LibClassCS__StructuralFeaturesAssignment_5_2 : ( ruleLibPropertyCS ) ;
    public final void rule__LibClassCS__StructuralFeaturesAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5138:1: ( ( ruleLibPropertyCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5139:1: ( ruleLibPropertyCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5139:1: ( ruleLibPropertyCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5140:1: ruleLibPropertyCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_210282);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5149:1: rule__LibIterationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibIterationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5153:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5154:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5154:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5155:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110313);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5164:1: rule__LibIterationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5168:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5169:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5169:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5170:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110344);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5179:1: rule__LibIterationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5183:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5184:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5184:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5185:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110375);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5194:1: rule__LibIterationCS__ParametersAssignment_4 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5198:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5199:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5199:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5200:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410406);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5209:1: rule__LibIterationCS__ParametersAssignment_5_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5213:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5214:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5214:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5215:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110437);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5224:1: rule__LibIterationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibIterationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5228:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5229:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5229:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5230:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810468);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5239:1: rule__LibIterationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibIterationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5243:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5244:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5244:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5245:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010499); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5254:1: rule__LibOperationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibOperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5258:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5259:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5259:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5260:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110530);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5269:1: rule__LibOperationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5273:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5274:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5274:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5275:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110561);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5284:1: rule__LibOperationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5288:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5289:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5289:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5290:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110592);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5299:1: rule__LibOperationCS__ParametersAssignment_4_0 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5303:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5304:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5304:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5305:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010623);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5314:1: rule__LibOperationCS__ParametersAssignment_4_1_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5318:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5319:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5319:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5320:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110654);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5329:1: rule__LibOperationCS__TypeAssignment_7 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibOperationCS__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5333:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5334:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5334:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5335:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710685);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5344:1: rule__LibOperationCS__ClassAssignment_9 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibOperationCS__ClassAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5348:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5349:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5349:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5350:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910716); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5359:1: rule__LibPackageCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibPackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5363:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5364:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5364:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5365:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110747);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5374:1: rule__LibPackageCS__SubpackagesAssignment_3_0 : ( ruleLibPackageCS ) ;
    public final void rule__LibPackageCS__SubpackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5378:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5379:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5379:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5380:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010778);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5389:1: rule__LibPackageCS__ClassifiersAssignment_3_1 : ( ruleLibClassifierCS ) ;
    public final void rule__LibPackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5393:1: ( ( ruleLibClassifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5394:1: ( ruleLibClassifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5394:1: ( ruleLibClassifierCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5395:1: ruleLibClassifierCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110809);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5404:1: rule__LibParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5408:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5409:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5409:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5410:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010840);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5419:1: rule__LibParameterCS__TypeAssignment_2 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibParameterCS__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5423:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5424:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5424:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5425:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210871);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5434:1: rule__LibParameterCS__LowerAssignment_3_1_0_0 : ( ruleLOWER ) ;
    public final void rule__LibParameterCS__LowerAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5438:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5439:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5439:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5440:1: ruleLOWER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010902);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5449:1: rule__LibParameterCS__UpperAssignment_3_1_0_1_1 : ( ruleUPPER ) ;
    public final void rule__LibParameterCS__UpperAssignment_3_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5453:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5454:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5454:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5455:1: ruleUPPER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_110933);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5464:1: rule__LibParameterCS__MultiplicityAssignment_3_1_1 : ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) ;
    public final void rule__LibParameterCS__MultiplicityAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5468:1: ( ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5469:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5469:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5470:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5471:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5471:2: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_110964);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5480:1: rule__LibPropertyCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibPropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5484:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5485:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5485:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5486:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_110997);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5495:1: rule__LibPropertyCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibPropertyCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5499:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5500:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5500:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5501:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311028);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5510:1: rule__LibPropertyCS__ClassAssignment_5 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibPropertyCS__ClassAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5514:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5516:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511059); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5525:1: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibQualifiedTypeRefCS__NamespaceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5529:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5530:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5530:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5531:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5532:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5533:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011094);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5544:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5548:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5549:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5549:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5550:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111129);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5559:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5563:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5564:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5564:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5565:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111160);
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


    // $ANTLR start rule__LibQualifiedTypeRefCS__ElementAssignment_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5574:1: rule__LibQualifiedTypeRefCS__ElementAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__ElementAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5578:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5579:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5579:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5580:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311191);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementLibTypedRefCSParserRuleCall_3_0()); 
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
    // $ANTLR end rule__LibQualifiedTypeRefCS__ElementAssignment_3


    // $ANTLR start rule__LibTypeParameterCS__NameAssignment_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5589:1: rule__LibTypeParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibTypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5593:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5594:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5594:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5595:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011222);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5604:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5608:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5609:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5609:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5610:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111253);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5619:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5623:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5624:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5624:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5625:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111284);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5634:1: rule__LibTypeParameterCS__SuperAssignment_1_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__SuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5638:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5639:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5639:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5640:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111315);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5649:1: rule__LibTypedTypeRefCS__TypeAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibTypedTypeRefCS__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5653:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5654:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5654:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5655:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5656:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5657:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011350);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5668:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5672:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5673:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5673:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5674:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111385);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5683:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5687:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5688:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5688:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5689:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111416);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5698:1: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5702:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5703:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5703:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5704:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111447);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5713:1: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5717:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5718:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5718:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5719:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111478);
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ( ruleLibQualifiedTypeRefCS ) )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ruleLibQualifiedTypeRefCS )
        {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:892:1: ruleLibQualifiedTypeRefCS
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
        public static final BitSet FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__01991 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__01994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Library__Group__0__Impl2022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12053 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22113 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2143 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32174 = new BitSet(new long[]{0x0000000002040000L});
        public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Library__Group__3__Impl2205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42236 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2266 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Library__Group__5__Impl2325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02368 = new BitSet(new long[]{0x00000000003FF0A0L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12430 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02554 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02677 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12739 = new BitSet(new long[]{0x0000000009001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22799 = new BitSet(new long[]{0x0000000001001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32860 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl2890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__42921 = new BitSet(new long[]{0x00000000020A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__42924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibClassCS__Group__4__Impl2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__52983 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__52986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3013 = new BitSet(new long[]{0x00000000000A8002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03117 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13179 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23239 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3269 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03367 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03490 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13552 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3639 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03676 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03799 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13861 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl3891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__23921 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__23924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl3951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__33982 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__33985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44044 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54104 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4134 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64165 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74227 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84289 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94349 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104411 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04554 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14616 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24676 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4706 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04804 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl4893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__04927 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__04930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl4958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__14989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05050 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15112 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25172 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35233 = new BitSet(new long[]{0x00000000803FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45295 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55356 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65418 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75480 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85540 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95602 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05743 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15805 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25865 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl5895 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__35926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl5954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__05993 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__05996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06116 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6203 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06238 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06361 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16423 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26483 = new BitSet(new long[]{0x0000000002240000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36545 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6575 = new BitSet(new long[]{0x0000000000240002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06675 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16735 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26797 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl6884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__06923 = new BitSet(new long[]{0x0000000000C00810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__06926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl6954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__16985 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__16988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07110 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07232 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07355 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17417 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27477 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37539 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47599 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57661 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07794 = new BitSet(new long[]{0x0000002008000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17854 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl7884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__27915 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__27918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl7946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__37977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08042 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18104 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28164 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8194 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08292 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08415 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08537 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18599 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8686 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08723 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08846 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl8877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__18908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl8935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__08969 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__08972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl8999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09091 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19153 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29213 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9243 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9302 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09341 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09464 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19525 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09651 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09774 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_19902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_29933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_49964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_09995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_010220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_110251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_210282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_110933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_110964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_110997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211893 = new BitSet(new long[]{0x0000000000000002L});
    }


}