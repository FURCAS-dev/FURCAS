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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_DOUBLE_QUOTED_STRING", "RULE_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'*'", "'conformsTo'", "'extends'", "'import'", "'iteration'", "'library'", "'operation'", "'package'", "'property'", "'super'", "'type'", "'+'", "'?'", "'{'", "'}'", "':'", "'<'", "'>'", "','", "'('", "')'", "'=>'", "';'", "'['", "']'", "'..'", "'::'", "'&&'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int RULE_SL_COMMENT=9;

        public InternalOCLstdlibParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[404+1];
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


    // $ANTLR start entryRuleRestrictedKeywords
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:174:1: entryRuleRestrictedKeywords : ruleRestrictedKeywords EOF ;
    public final void entryRuleRestrictedKeywords() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:175:1: ( ruleRestrictedKeywords EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:176:1: ruleRestrictedKeywords EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRestrictedKeywordsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRestrictedKeywords_in_entryRuleRestrictedKeywords306);
            ruleRestrictedKeywords();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getRestrictedKeywordsRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRestrictedKeywords313); if (failed) return ;

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
    // $ANTLR end entryRuleRestrictedKeywords


    // $ANTLR start ruleRestrictedKeywords
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:183:1: ruleRestrictedKeywords : ( ( rule__RestrictedKeywords__Alternatives ) ) ;
    public final void ruleRestrictedKeywords() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:187:2: ( ( ( rule__RestrictedKeywords__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:1: ( ( rule__RestrictedKeywords__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:188:1: ( ( rule__RestrictedKeywords__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:189:1: ( rule__RestrictedKeywords__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getRestrictedKeywordsAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:190:1: ( rule__RestrictedKeywords__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:190:2: rule__RestrictedKeywords__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__RestrictedKeywords__Alternatives_in_ruleRestrictedKeywords339);
            rule__RestrictedKeywords__Alternatives();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getRestrictedKeywordsAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleRestrictedKeywords


    // $ANTLR start entryRuleName
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:202:1: entryRuleName : ruleName EOF ;
    public final void entryRuleName() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:203:1: ( ruleName EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:204:1: ruleName EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_entryRuleName366);
            ruleName();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getNameRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleName373); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:211:1: ruleName : ( ( rule__Name__Alternatives ) ) ;
    public final void ruleName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:215:2: ( ( ( rule__Name__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:1: ( ( rule__Name__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:216:1: ( ( rule__Name__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:217:1: ( rule__Name__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getNameAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:218:1: ( rule__Name__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:218:2: rule__Name__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Name__Alternatives_in_ruleName399);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:230:1: entryRuleLibImportCS : ruleLibImportCS EOF ;
    public final void entryRuleLibImportCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:231:1: ( ruleLibImportCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:232:1: ruleLibImportCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS426);
            ruleLibImportCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibImportCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibImportCS433); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:239:1: ruleLibImportCS : ( ( rule__LibImportCS__Group__0 ) ) ;
    public final void ruleLibImportCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:243:2: ( ( ( rule__LibImportCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:1: ( ( rule__LibImportCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:244:1: ( ( rule__LibImportCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:245:1: ( rule__LibImportCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:246:1: ( rule__LibImportCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:246:2: rule__LibImportCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS459);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:258:1: entryRuleLibClassCS : ruleLibClassCS EOF ;
    public final void entryRuleLibClassCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:259:1: ( ruleLibClassCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:260:1: ruleLibClassCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS486);
            ruleLibClassCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassCS493); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:267:1: ruleLibClassCS : ( ( rule__LibClassCS__Group__0 ) ) ;
    public final void ruleLibClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:271:2: ( ( ( rule__LibClassCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:1: ( ( rule__LibClassCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:272:1: ( ( rule__LibClassCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:273:1: ( rule__LibClassCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:274:1: ( rule__LibClassCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:274:2: rule__LibClassCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS519);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:286:1: entryRuleLibClassifierCS : ruleLibClassifierCS EOF ;
    public final void entryRuleLibClassifierCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:287:1: ( ruleLibClassifierCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:288:1: ruleLibClassifierCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS546);
            ruleLibClassifierCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassifierCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibClassifierCS553); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:295:1: ruleLibClassifierCS : ( ruleLibClassCS ) ;
    public final void ruleLibClassifierCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:299:2: ( ( ruleLibClassCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:1: ( ruleLibClassCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:300:1: ( ruleLibClassCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:301:1: ruleLibClassCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassifierCSAccess().getLibClassCSParserRuleCall()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS579);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:314:1: entryRuleLibIterationCS : ruleLibIterationCS EOF ;
    public final void entryRuleLibIterationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:315:1: ( ruleLibIterationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:316:1: ruleLibIterationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS605);
            ruleLibIterationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibIterationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibIterationCS612); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:323:1: ruleLibIterationCS : ( ( rule__LibIterationCS__Group__0 ) ) ;
    public final void ruleLibIterationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:327:2: ( ( ( rule__LibIterationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:1: ( ( rule__LibIterationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:328:1: ( ( rule__LibIterationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:329:1: ( rule__LibIterationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:330:1: ( rule__LibIterationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:330:2: rule__LibIterationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS638);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:342:1: entryRuleLibOperationCS : ruleLibOperationCS EOF ;
    public final void entryRuleLibOperationCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:343:1: ( ruleLibOperationCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:344:1: ruleLibOperationCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS665);
            ruleLibOperationCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibOperationCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibOperationCS672); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:351:1: ruleLibOperationCS : ( ( rule__LibOperationCS__Group__0 ) ) ;
    public final void ruleLibOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:355:2: ( ( ( rule__LibOperationCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:1: ( ( rule__LibOperationCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:356:1: ( ( rule__LibOperationCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:357:1: ( rule__LibOperationCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:358:1: ( rule__LibOperationCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:358:2: rule__LibOperationCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS698);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:370:1: entryRuleLibPackageCS : ruleLibPackageCS EOF ;
    public final void entryRuleLibPackageCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:371:1: ( ruleLibPackageCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:372:1: ruleLibPackageCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS725);
            ruleLibPackageCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPackageCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPackageCS732); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:379:1: ruleLibPackageCS : ( ( rule__LibPackageCS__Group__0 ) ) ;
    public final void ruleLibPackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:383:2: ( ( ( rule__LibPackageCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:1: ( ( rule__LibPackageCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:384:1: ( ( rule__LibPackageCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:385:1: ( rule__LibPackageCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:386:1: ( rule__LibPackageCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:386:2: rule__LibPackageCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS758);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:398:1: entryRuleLibParameterCS : ruleLibParameterCS EOF ;
    public final void entryRuleLibParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:399:1: ( ruleLibParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:400:1: ruleLibParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS785);
            ruleLibParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibParameterCS792); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:407:1: ruleLibParameterCS : ( ( rule__LibParameterCS__Group__0 ) ) ;
    public final void ruleLibParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:411:2: ( ( ( rule__LibParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:1: ( ( rule__LibParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:412:1: ( ( rule__LibParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:413:1: ( rule__LibParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:414:1: ( rule__LibParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:414:2: rule__LibParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS818);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:426:1: entryRuleLibPropertyCS : ruleLibPropertyCS EOF ;
    public final void entryRuleLibPropertyCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:427:1: ( ruleLibPropertyCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:428:1: ruleLibPropertyCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS845);
            ruleLibPropertyCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibPropertyCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibPropertyCS852); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:435:1: ruleLibPropertyCS : ( ( rule__LibPropertyCS__Group__0 ) ) ;
    public final void ruleLibPropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:439:2: ( ( ( rule__LibPropertyCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:1: ( ( rule__LibPropertyCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:440:1: ( ( rule__LibPropertyCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:441:1: ( rule__LibPropertyCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:442:1: ( rule__LibPropertyCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:442:2: rule__LibPropertyCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS878);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:454:1: entryRuleLibQualifiedTypeRefCS : ruleLibQualifiedTypeRefCS EOF ;
    public final void entryRuleLibQualifiedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:455:1: ( ruleLibQualifiedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:456:1: ruleLibQualifiedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS905);
            ruleLibQualifiedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibQualifiedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS912); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:463:1: ruleLibQualifiedTypeRefCS : ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibQualifiedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:467:2: ( ( ( rule__LibQualifiedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:468:1: ( ( rule__LibQualifiedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:469:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:470:1: ( rule__LibQualifiedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:470:2: rule__LibQualifiedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS938);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:482:1: entryRuleLibTypeParameterCS : ruleLibTypeParameterCS EOF ;
    public final void entryRuleLibTypeParameterCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:483:1: ( ruleLibTypeParameterCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:484:1: ruleLibTypeParameterCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS965);
            ruleLibTypeParameterCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeParameterCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeParameterCS972); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:491:1: ruleLibTypeParameterCS : ( ( rule__LibTypeParameterCS__Group__0 ) ) ;
    public final void ruleLibTypeParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:495:2: ( ( ( rule__LibTypeParameterCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:496:1: ( ( rule__LibTypeParameterCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:497:1: ( rule__LibTypeParameterCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:498:1: ( rule__LibTypeParameterCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:498:2: rule__LibTypeParameterCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS998);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:510:1: entryRuleLibTypeRefCS : ruleLibTypeRefCS EOF ;
    public final void entryRuleLibTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:511:1: ( ruleLibTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:512:1: ruleLibTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS1025);
            ruleLibTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypeRefCS1032); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:519:1: ruleLibTypeRefCS : ( ( rule__LibTypeRefCS__Alternatives ) ) ;
    public final void ruleLibTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:523:2: ( ( ( rule__LibTypeRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:524:1: ( ( rule__LibTypeRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:525:1: ( rule__LibTypeRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:526:1: ( rule__LibTypeRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:526:2: rule__LibTypeRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS1058);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:538:1: entryRuleLibTypedRefCS : ruleLibTypedRefCS EOF ;
    public final void entryRuleLibTypedRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:539:1: ( ruleLibTypedRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:540:1: ruleLibTypedRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS1085);
            ruleLibTypedRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedRefCS1092); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:547:1: ruleLibTypedRefCS : ( ( rule__LibTypedRefCS__Alternatives ) ) ;
    public final void ruleLibTypedRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:551:2: ( ( ( rule__LibTypedRefCS__Alternatives ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:552:1: ( ( rule__LibTypedRefCS__Alternatives ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:553:1: ( rule__LibTypedRefCS__Alternatives )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedRefCSAccess().getAlternatives()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:554:1: ( rule__LibTypedRefCS__Alternatives )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:554:2: rule__LibTypedRefCS__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1118);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:566:1: entryRuleLibTypedTypeRefCS : ruleLibTypedTypeRefCS EOF ;
    public final void entryRuleLibTypedTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:567:1: ( ruleLibTypedTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:568:1: ruleLibTypedTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1145);
            ruleLibTypedTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibTypedTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1152); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:575:1: ruleLibTypedTypeRefCS : ( ( rule__LibTypedTypeRefCS__Group__0 ) ) ;
    public final void ruleLibTypedTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:579:2: ( ( ( rule__LibTypedTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:580:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:580:1: ( ( rule__LibTypedTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:581:1: ( rule__LibTypedTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:582:1: ( rule__LibTypedTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:582:2: rule__LibTypedTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1178);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:594:1: entryRuleLibWildcardTypeRefCS : ruleLibWildcardTypeRefCS EOF ;
    public final void entryRuleLibWildcardTypeRefCS() throws RecognitionException {
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:595:1: ( ruleLibWildcardTypeRefCS EOF )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:596:1: ruleLibWildcardTypeRefCS EOF
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1205);
            ruleLibWildcardTypeRefCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibWildcardTypeRefCSRule()); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1212); if (failed) return ;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:603:1: ruleLibWildcardTypeRefCS : ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) ;
    public final void ruleLibWildcardTypeRefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:607:2: ( ( ( rule__LibWildcardTypeRefCS__Group__0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:608:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:608:1: ( ( rule__LibWildcardTypeRefCS__Group__0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:609:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:610:1: ( rule__LibWildcardTypeRefCS__Group__0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:610:2: rule__LibWildcardTypeRefCS__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1238);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:622:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );
    public final void rule__UPPER__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:626:1: ( ( RULE_INT ) | ( '*' ) )
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
                    new NoViableAltException("622:1: rule__UPPER__Alternatives : ( ( RULE_INT ) | ( '*' ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:627:1: ( RULE_INT )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:627:1: ( RULE_INT )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:628:1: RULE_INT
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1274); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:633:6: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:633:6: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:634:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__UPPER__Alternatives1292); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:646:1: rule__Identifier__Alternatives : ( ( RULE_ID ) | ( ruleRestrictedKeywords ) );
    public final void rule__Identifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:650:1: ( ( RULE_ID ) | ( ruleRestrictedKeywords ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=12 && LA2_0<=21)) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("646:1: rule__Identifier__Alternatives : ( ( RULE_ID ) | ( ruleRestrictedKeywords ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:651:1: ( RULE_ID )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:651:1: ( RULE_ID )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:652:1: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Identifier__Alternatives1326); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:657:6: ( ruleRestrictedKeywords )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:657:6: ( ruleRestrictedKeywords )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:658:1: ruleRestrictedKeywords
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRestrictedKeywords_in_rule__Identifier__Alternatives1343);
                    ruleRestrictedKeywords();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getIdentifierAccess().getRestrictedKeywordsParserRuleCall_1()); 
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


    // $ANTLR start rule__RestrictedKeywords__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:668:1: rule__RestrictedKeywords__Alternatives : ( ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );
    public final void rule__RestrictedKeywords__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:672:1: ( ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) )
            int alt3=10;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 13:
                {
                alt3=2;
                }
                break;
            case 14:
                {
                alt3=3;
                }
                break;
            case 15:
                {
                alt3=4;
                }
                break;
            case 16:
                {
                alt3=5;
                }
                break;
            case 17:
                {
                alt3=6;
                }
                break;
            case 18:
                {
                alt3=7;
                }
                break;
            case 19:
                {
                alt3=8;
                }
                break;
            case 20:
                {
                alt3=9;
                }
                break;
            case 21:
                {
                alt3=10;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("668:1: rule__RestrictedKeywords__Alternatives : ( ( 'conformsTo' ) | ( 'extends' ) | ( 'import' ) | ( 'iteration' ) | ( 'library' ) | ( 'operation' ) | ( 'package' ) | ( 'property' ) | ( 'super' ) | ( 'type' ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:673:1: ( 'conformsTo' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:673:1: ( 'conformsTo' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:674:1: 'conformsTo'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_0()); 
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__RestrictedKeywords__Alternatives1376); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getConformsToKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:681:6: ( 'extends' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:681:6: ( 'extends' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:682:1: 'extends'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_1()); 
                    }
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__RestrictedKeywords__Alternatives1396); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getExtendsKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:689:6: ( 'import' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:689:6: ( 'import' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:690:1: 'import'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_2()); 
                    }
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__RestrictedKeywords__Alternatives1416); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getImportKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:697:6: ( 'iteration' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:697:6: ( 'iteration' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:698:1: 'iteration'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_3()); 
                    }
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__RestrictedKeywords__Alternatives1436); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getIterationKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:705:6: ( 'library' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:705:6: ( 'library' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:706:1: 'library'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_4()); 
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__RestrictedKeywords__Alternatives1456); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getLibraryKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:713:6: ( 'operation' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:713:6: ( 'operation' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:714:1: 'operation'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_5()); 
                    }
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__RestrictedKeywords__Alternatives1476); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getOperationKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:721:6: ( 'package' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:721:6: ( 'package' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:722:1: 'package'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_6()); 
                    }
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__RestrictedKeywords__Alternatives1496); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getPackageKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:729:6: ( 'property' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:729:6: ( 'property' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:730:1: 'property'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_7()); 
                    }
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__RestrictedKeywords__Alternatives1516); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getPropertyKeyword_7()); 
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:737:6: ( 'super' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:737:6: ( 'super' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:738:1: 'super'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getSuperKeyword_8()); 
                    }
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__RestrictedKeywords__Alternatives1536); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getSuperKeyword_8()); 
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:745:6: ( 'type' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:745:6: ( 'type' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:746:1: 'type'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_9()); 
                    }
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__RestrictedKeywords__Alternatives1556); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getRestrictedKeywordsAccess().getTypeKeyword_9()); 
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
    // $ANTLR end rule__RestrictedKeywords__Alternatives


    // $ANTLR start rule__Name__Alternatives
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:758:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );
    public final void rule__Name__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:762:1: ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID||(LA4_0>=12 && LA4_0<=21)) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_DOUBLE_QUOTED_STRING) ) {
                alt4=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("758:1: rule__Name__Alternatives : ( ( ruleIdentifier ) | ( RULE_DOUBLE_QUOTED_STRING ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:763:1: ( ruleIdentifier )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:763:1: ( ruleIdentifier )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:764:1: ruleIdentifier
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNameAccess().getIdentifierParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Name__Alternatives1590);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:769:6: ( RULE_DOUBLE_QUOTED_STRING )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:769:6: ( RULE_DOUBLE_QUOTED_STRING )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:770:1: RULE_DOUBLE_QUOTED_STRING
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getNameAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); 
                    }
                    match(input,RULE_DOUBLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_rule__Name__Alternatives1607); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:780:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );
    public final void rule__LibClassCS__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:784:1: ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 19:
                {
                alt5=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("780:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__IterationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__OperationsAssignment_5_1 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:785:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:785:1: ( ( rule__LibClassCS__IterationsAssignment_5_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:786:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getIterationsAssignment_5_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:787:1: ( rule__LibClassCS__IterationsAssignment_5_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:787:2: rule__LibClassCS__IterationsAssignment_5_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51639);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:6: ( ( rule__LibClassCS__OperationsAssignment_5_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:792:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:1: ( rule__LibClassCS__OperationsAssignment_5_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:2: rule__LibClassCS__OperationsAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51657);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:797:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:797:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:798:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_2()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:799:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_2 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:799:2: rule__LibClassCS__StructuralFeaturesAssignment_5_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51675);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:808:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__LibPackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:812:1: ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("808:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:814:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:815:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:815:2: rule__LibPackageCS__SubpackagesAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31708);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:819:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:819:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:820:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:821:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:821:2: rule__LibPackageCS__ClassifiersAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31726);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:830:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );
    public final void rule__LibParameterCS__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:834:1: ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==11||(LA7_0>=22 && LA7_0<=23)) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("830:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:835:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:835:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:836:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:837:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:837:2: rule__LibParameterCS__Group_3_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11759);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:841:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:841:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:842:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:843:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:843:2: rule__LibParameterCS__MultiplicityAssignment_3_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11777);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:852:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:856:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt8=1;
                }
                break;
            case 22:
                {
                alt8=2;
                }
                break;
            case 23:
                {
                alt8=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("852:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:857:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:857:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:858:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01811); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:865:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:865:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:866:1: '+'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01831); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:873:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:873:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:1: '?'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01851); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:886:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__LibTypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("886:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:891:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:892:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:893:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:893:2: rule__LibTypeParameterCS__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11885);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:897:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:898:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:899:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:899:2: rule__LibTypeParameterCS__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11903);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:908:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );
    public final void rule__LibTypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:912:1: ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=12 && LA10_0<=21)) ) {
                alt10=1;
            }
            else if ( (LA10_0==23) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("908:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:1: ( ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:1: ( ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:914:1: ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1936);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:919:6: ( ruleLibWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:919:6: ( ruleLibWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:920:1: ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1953);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );
    public final void rule__LibTypedRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:934:1: ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) )
            int alt11=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA11_1 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA11_2 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA11_3 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA11_4 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 4, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA11_5 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 5, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA11_6 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 6, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA11_7 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 7, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA11_8 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 8, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA11_9 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 9, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA11_10 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 10, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA11_11 = input.LA(2);

                if ( (synpred21()) ) {
                    alt11=1;
                }
                else if ( (true) ) {
                    alt11=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("930:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ruleLibQualifiedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ruleLibQualifiedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1985);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:941:6: ( ruleLibTypedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:941:6: ( ruleLibTypedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:942:1: ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2002);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:952:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__LibWildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:956:1: ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            else if ( (LA12_0==20) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("952:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:957:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:957:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:958:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:959:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:959:2: rule__LibWildcardTypeRefCS__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_22034);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:963:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:963:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:964:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:965:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:965:2: rule__LibWildcardTypeRefCS__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_22052);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:976:1: rule__Library__Group__0 : rule__Library__Group__0__Impl rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:980:1: ( rule__Library__Group__0__Impl rule__Library__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:981:2: rule__Library__Group__0__Impl rule__Library__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__02083);
            rule__Library__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02086);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:988:1: rule__Library__Group__0__Impl : ( 'library' ) ;
    public final void rule__Library__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:992:1: ( ( 'library' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:993:1: ( 'library' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:993:1: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:994:1: 'library'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Library__Group__0__Impl2114); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1007:1: rule__Library__Group__1 : rule__Library__Group__1__Impl rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1011:1: ( rule__Library__Group__1__Impl rule__Library__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1012:2: rule__Library__Group__1__Impl rule__Library__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12145);
            rule__Library__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12148);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1019:1: rule__Library__Group__1__Impl : ( ( rule__Library__NameAssignment_1 ) ) ;
    public final void rule__Library__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1023:1: ( ( ( rule__Library__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1024:1: ( ( rule__Library__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1024:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1025:1: ( rule__Library__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1026:1: ( rule__Library__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1026:2: rule__Library__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2175);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1036:1: rule__Library__Group__2 : rule__Library__Group__2__Impl rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1040:1: ( rule__Library__Group__2__Impl rule__Library__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1041:2: rule__Library__Group__2__Impl rule__Library__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22205);
            rule__Library__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22208);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1048:1: rule__Library__Group__2__Impl : ( ( rule__Library__ImportsAssignment_2 )* ) ;
    public final void rule__Library__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1052:1: ( ( ( rule__Library__ImportsAssignment_2 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1053:1: ( ( rule__Library__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1053:1: ( ( rule__Library__ImportsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1054:1: ( rule__Library__ImportsAssignment_2 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1055:1: ( rule__Library__ImportsAssignment_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1055:2: rule__Library__ImportsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2235);
            	    rule__Library__ImportsAssignment_2();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1065:1: rule__Library__Group__3 : rule__Library__Group__3__Impl rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1069:1: ( rule__Library__Group__3__Impl rule__Library__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1070:2: rule__Library__Group__3__Impl rule__Library__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32266);
            rule__Library__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32269);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1077:1: rule__Library__Group__3__Impl : ( '{' ) ;
    public final void rule__Library__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1081:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1082:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1082:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1083:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Library__Group__3__Impl2297); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1096:1: rule__Library__Group__4 : rule__Library__Group__4__Impl rule__Library__Group__5 ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1100:1: ( rule__Library__Group__4__Impl rule__Library__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1101:2: rule__Library__Group__4__Impl rule__Library__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42328);
            rule__Library__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42331);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1108:1: rule__Library__Group__4__Impl : ( ( rule__Library__PackagesAssignment_4 )* ) ;
    public final void rule__Library__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1112:1: ( ( ( rule__Library__PackagesAssignment_4 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1113:1: ( ( rule__Library__PackagesAssignment_4 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1113:1: ( ( rule__Library__PackagesAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1114:1: ( rule__Library__PackagesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1115:1: ( rule__Library__PackagesAssignment_4 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==18) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1115:2: rule__Library__PackagesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2358);
            	    rule__Library__PackagesAssignment_4();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1125:1: rule__Library__Group__5 : rule__Library__Group__5__Impl ;
    public final void rule__Library__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1129:1: ( rule__Library__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1130:2: rule__Library__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52389);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1136:1: rule__Library__Group__5__Impl : ( '}' ) ;
    public final void rule__Library__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1140:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1141:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1141:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1142:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Library__Group__5__Impl2417); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1167:1: rule__LibImportCS__Group__0 : rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 ;
    public final void rule__LibImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1171:1: ( rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1172:2: rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02460);
            rule__LibImportCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02463);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1179:1: rule__LibImportCS__Group__0__Impl : ( 'import' ) ;
    public final void rule__LibImportCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: ( ( 'import' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1184:1: ( 'import' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1184:1: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1185:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2491); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1198:1: rule__LibImportCS__Group__1 : rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 ;
    public final void rule__LibImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1202:1: ( rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1203:2: rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12522);
            rule__LibImportCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12525);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1210:1: rule__LibImportCS__Group__1__Impl : ( ( rule__LibImportCS__Group_1__0 )? ) ;
    public final void rule__LibImportCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1214:1: ( ( ( rule__LibImportCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1215:1: ( ( rule__LibImportCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1215:1: ( ( rule__LibImportCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1216:1: ( rule__LibImportCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1217:1: ( rule__LibImportCS__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID||(LA15_0>=12 && LA15_0<=21)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1217:2: rule__LibImportCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2552);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1227:1: rule__LibImportCS__Group__2 : rule__LibImportCS__Group__2__Impl ;
    public final void rule__LibImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1231:1: ( rule__LibImportCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1232:2: rule__LibImportCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22583);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1238:1: rule__LibImportCS__Group__2__Impl : ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) ;
    public final void rule__LibImportCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1242:1: ( ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1243:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1243:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1244:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1245:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1245:2: rule__LibImportCS__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2610);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1261:1: rule__LibImportCS__Group_1__0 : rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 ;
    public final void rule__LibImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1265:1: ( rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1266:2: rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02646);
            rule__LibImportCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02649);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1273:1: rule__LibImportCS__Group_1__0__Impl : ( ( rule__LibImportCS__NameAssignment_1_0 ) ) ;
    public final void rule__LibImportCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1277:1: ( ( ( rule__LibImportCS__NameAssignment_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1278:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1278:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1279:1: ( rule__LibImportCS__NameAssignment_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1280:1: ( rule__LibImportCS__NameAssignment_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1280:2: rule__LibImportCS__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2676);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1290:1: rule__LibImportCS__Group_1__1 : rule__LibImportCS__Group_1__1__Impl ;
    public final void rule__LibImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1294:1: ( rule__LibImportCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1295:2: rule__LibImportCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12706);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1301:1: rule__LibImportCS__Group_1__1__Impl : ( ':' ) ;
    public final void rule__LibImportCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1305:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1306:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1306:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1307:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2734); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1324:1: rule__LibClassCS__Group__0 : rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 ;
    public final void rule__LibClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1328:1: ( rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1329:2: rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02769);
            rule__LibClassCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02772);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1336:1: rule__LibClassCS__Group__0__Impl : ( 'type' ) ;
    public final void rule__LibClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1340:1: ( ( 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1341:1: ( 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1341:1: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1342:1: 'type'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2800); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1355:1: rule__LibClassCS__Group__1 : rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 ;
    public final void rule__LibClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1359:1: ( rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1360:2: rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12831);
            rule__LibClassCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12834);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1367:1: rule__LibClassCS__Group__1__Impl : ( ( rule__LibClassCS__NameAssignment_1 ) ) ;
    public final void rule__LibClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1371:1: ( ( ( rule__LibClassCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1372:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1372:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1373:1: ( rule__LibClassCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1374:1: ( rule__LibClassCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1374:2: rule__LibClassCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2861);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1384:1: rule__LibClassCS__Group__2 : rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 ;
    public final void rule__LibClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1388:1: ( rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1389:2: rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22891);
            rule__LibClassCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22894);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1396:1: rule__LibClassCS__Group__2__Impl : ( ( rule__LibClassCS__Group_2__0 )? ) ;
    public final void rule__LibClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1400:1: ( ( ( rule__LibClassCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1401:1: ( ( rule__LibClassCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1401:1: ( ( rule__LibClassCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1402:1: ( rule__LibClassCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1403:1: ( rule__LibClassCS__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1403:2: rule__LibClassCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2921);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1413:1: rule__LibClassCS__Group__3 : rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 ;
    public final void rule__LibClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1417:1: ( rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1418:2: rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32952);
            rule__LibClassCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32955);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1425:1: rule__LibClassCS__Group__3__Impl : ( ( rule__LibClassCS__Group_3__0 )? ) ;
    public final void rule__LibClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1429:1: ( ( ( rule__LibClassCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1430:1: ( ( rule__LibClassCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1430:1: ( ( rule__LibClassCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1431:1: ( rule__LibClassCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:1: ( rule__LibClassCS__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==12) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1432:2: rule__LibClassCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl2982);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1442:1: rule__LibClassCS__Group__4 : rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 ;
    public final void rule__LibClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1446:1: ( rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1447:2: rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__43013);
            rule__LibClassCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__43016);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1454:1: rule__LibClassCS__Group__4__Impl : ( '{' ) ;
    public final void rule__LibClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1458:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1459:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1459:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1460:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibClassCS__Group__4__Impl3044); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1473:1: rule__LibClassCS__Group__5 : rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 ;
    public final void rule__LibClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1477:1: ( rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1478:2: rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__53075);
            rule__LibClassCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__53078);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1485:1: rule__LibClassCS__Group__5__Impl : ( ( rule__LibClassCS__Alternatives_5 )* ) ;
    public final void rule__LibClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1489:1: ( ( ( rule__LibClassCS__Alternatives_5 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1490:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1490:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1491:1: ( rule__LibClassCS__Alternatives_5 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1492:1: ( rule__LibClassCS__Alternatives_5 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==15||LA18_0==17||LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1492:2: rule__LibClassCS__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3105);
            	    rule__LibClassCS__Alternatives_5();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1502:1: rule__LibClassCS__Group__6 : rule__LibClassCS__Group__6__Impl ;
    public final void rule__LibClassCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1506:1: ( rule__LibClassCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1507:2: rule__LibClassCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63136);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1513:1: rule__LibClassCS__Group__6__Impl : ( '}' ) ;
    public final void rule__LibClassCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1517:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1519:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3164); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1546:1: rule__LibClassCS__Group_2__0 : rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 ;
    public final void rule__LibClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1550:1: ( rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1551:2: rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03209);
            rule__LibClassCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03212);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1558:1: rule__LibClassCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1562:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1563:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1563:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1564:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3240); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1577:1: rule__LibClassCS__Group_2__1 : rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 ;
    public final void rule__LibClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1581:1: ( rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1582:2: rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13271);
            rule__LibClassCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13274);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1589:1: rule__LibClassCS__Group_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1593:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1594:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1594:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1595:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1596:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1596:2: rule__LibClassCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3301);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1606:1: rule__LibClassCS__Group_2__2 : rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 ;
    public final void rule__LibClassCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1610:1: ( rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1611:2: rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23331);
            rule__LibClassCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23334);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1618:1: rule__LibClassCS__Group_2__2__Impl : ( ( rule__LibClassCS__Group_2_2__0 )* ) ;
    public final void rule__LibClassCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1622:1: ( ( ( rule__LibClassCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1623:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1623:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1624:1: ( rule__LibClassCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1625:1: ( rule__LibClassCS__Group_2_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1625:2: rule__LibClassCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3361);
            	    rule__LibClassCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1635:1: rule__LibClassCS__Group_2__3 : rule__LibClassCS__Group_2__3__Impl ;
    public final void rule__LibClassCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1639:1: ( rule__LibClassCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1640:2: rule__LibClassCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33392);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1646:1: rule__LibClassCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibClassCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1650:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1651:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1651:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1652:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3420); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1673:1: rule__LibClassCS__Group_2_2__0 : rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 ;
    public final void rule__LibClassCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1677:1: ( rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1678:2: rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03459);
            rule__LibClassCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03462);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1685:1: rule__LibClassCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1689:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1690:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1690:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1691:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3490); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1704:1: rule__LibClassCS__Group_2_2__1 : rule__LibClassCS__Group_2_2__1__Impl ;
    public final void rule__LibClassCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1708:1: ( rule__LibClassCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1709:2: rule__LibClassCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13521);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1715:1: rule__LibClassCS__Group_2_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1719:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1720:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1720:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1721:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1722:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1722:2: rule__LibClassCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3548);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1736:1: rule__LibClassCS__Group_3__0 : rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 ;
    public final void rule__LibClassCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1740:1: ( rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1741:2: rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03582);
            rule__LibClassCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03585);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1748:1: rule__LibClassCS__Group_3__0__Impl : ( 'conformsTo' ) ;
    public final void rule__LibClassCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1752:1: ( ( 'conformsTo' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1753:1: ( 'conformsTo' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1753:1: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1754:1: 'conformsTo'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3613); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1767:1: rule__LibClassCS__Group_3__1 : rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 ;
    public final void rule__LibClassCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1771:1: ( rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1772:2: rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13644);
            rule__LibClassCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13647);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1779:1: rule__LibClassCS__Group_3__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) ;
    public final void rule__LibClassCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1783:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1784:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1784:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1785:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1786:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1786:2: rule__LibClassCS__ConformsToAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3674);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1796:1: rule__LibClassCS__Group_3__2 : rule__LibClassCS__Group_3__2__Impl ;
    public final void rule__LibClassCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1800:1: ( rule__LibClassCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1801:2: rule__LibClassCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23704);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1807:1: rule__LibClassCS__Group_3__2__Impl : ( ( rule__LibClassCS__Group_3_2__0 )* ) ;
    public final void rule__LibClassCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1811:1: ( ( ( rule__LibClassCS__Group_3_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1812:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1812:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1813:1: ( rule__LibClassCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1814:1: ( rule__LibClassCS__Group_3_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1814:2: rule__LibClassCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3731);
            	    rule__LibClassCS__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1830:1: rule__LibClassCS__Group_3_2__0 : rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 ;
    public final void rule__LibClassCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1834:1: ( rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1835:2: rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03768);
            rule__LibClassCS__Group_3_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03771);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1842:1: rule__LibClassCS__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1846:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1847:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1847:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1848:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3799); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1861:1: rule__LibClassCS__Group_3_2__1 : rule__LibClassCS__Group_3_2__1__Impl ;
    public final void rule__LibClassCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1865:1: ( rule__LibClassCS__Group_3_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1866:2: rule__LibClassCS__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13830);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1872:1: rule__LibClassCS__Group_3_2__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) ;
    public final void rule__LibClassCS__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1876:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1877:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1877:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1878:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1879:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1879:2: rule__LibClassCS__ConformsToAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3857);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1893:1: rule__LibIterationCS__Group__0 : rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 ;
    public final void rule__LibIterationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1897:1: ( rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1898:2: rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03891);
            rule__LibIterationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03894);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1905:1: rule__LibIterationCS__Group__0__Impl : ( 'iteration' ) ;
    public final void rule__LibIterationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1909:1: ( ( 'iteration' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1910:1: ( 'iteration' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1910:1: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1911:1: 'iteration'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3922); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1924:1: rule__LibIterationCS__Group__1 : rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 ;
    public final void rule__LibIterationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1928:1: ( rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1929:2: rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13953);
            rule__LibIterationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13956);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1936:1: rule__LibIterationCS__Group__1__Impl : ( ( rule__LibIterationCS__NameAssignment_1 ) ) ;
    public final void rule__LibIterationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1940:1: ( ( ( rule__LibIterationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1941:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1941:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1942:1: ( rule__LibIterationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1943:1: ( rule__LibIterationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1943:2: rule__LibIterationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl3983);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1953:1: rule__LibIterationCS__Group__2 : rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 ;
    public final void rule__LibIterationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1957:1: ( rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1958:2: rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__24013);
            rule__LibIterationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__24016);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1965:1: rule__LibIterationCS__Group__2__Impl : ( ( rule__LibIterationCS__Group_2__0 )? ) ;
    public final void rule__LibIterationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1969:1: ( ( ( rule__LibIterationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1970:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1970:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1971:1: ( rule__LibIterationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1972:1: ( rule__LibIterationCS__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==27) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1972:2: rule__LibIterationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl4043);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1982:1: rule__LibIterationCS__Group__3 : rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 ;
    public final void rule__LibIterationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1986:1: ( rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1987:2: rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__34074);
            rule__LibIterationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__34077);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1994:1: rule__LibIterationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibIterationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1998:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1999:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1999:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2000:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4105); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2013:1: rule__LibIterationCS__Group__4 : rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 ;
    public final void rule__LibIterationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2017:1: ( rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2018:2: rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44136);
            rule__LibIterationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44139);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2025:1: rule__LibIterationCS__Group__4__Impl : ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) ;
    public final void rule__LibIterationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2029:1: ( ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2030:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2030:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2031:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2032:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2032:2: rule__LibIterationCS__ParametersAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4166);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2042:1: rule__LibIterationCS__Group__5 : rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 ;
    public final void rule__LibIterationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2046:1: ( rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2047:2: rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54196);
            rule__LibIterationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54199);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2054:1: rule__LibIterationCS__Group__5__Impl : ( ( rule__LibIterationCS__Group_5__0 )* ) ;
    public final void rule__LibIterationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2058:1: ( ( ( rule__LibIterationCS__Group_5__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2059:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2059:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2060:1: ( rule__LibIterationCS__Group_5__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2061:1: ( rule__LibIterationCS__Group_5__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2061:2: rule__LibIterationCS__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4226);
            	    rule__LibIterationCS__Group_5__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2071:1: rule__LibIterationCS__Group__6 : rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 ;
    public final void rule__LibIterationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2075:1: ( rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2076:2: rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64257);
            rule__LibIterationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64260);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2083:1: rule__LibIterationCS__Group__6__Impl : ( ')' ) ;
    public final void rule__LibIterationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2087:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2088:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2088:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2089:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4288); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2102:1: rule__LibIterationCS__Group__7 : rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 ;
    public final void rule__LibIterationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2106:1: ( rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2107:2: rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74319);
            rule__LibIterationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74322);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2114:1: rule__LibIterationCS__Group__7__Impl : ( ':' ) ;
    public final void rule__LibIterationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2118:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2119:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2119:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2120:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4350); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2133:1: rule__LibIterationCS__Group__8 : rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 ;
    public final void rule__LibIterationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2137:1: ( rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2138:2: rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84381);
            rule__LibIterationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84384);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2145:1: rule__LibIterationCS__Group__8__Impl : ( ( rule__LibIterationCS__TypeAssignment_8 ) ) ;
    public final void rule__LibIterationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2149:1: ( ( ( rule__LibIterationCS__TypeAssignment_8 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2150:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2150:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2151:1: ( rule__LibIterationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2152:1: ( rule__LibIterationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2152:2: rule__LibIterationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4411);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2162:1: rule__LibIterationCS__Group__9 : rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 ;
    public final void rule__LibIterationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2166:1: ( rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2167:2: rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94441);
            rule__LibIterationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94444);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2174:1: rule__LibIterationCS__Group__9__Impl : ( '=>' ) ;
    public final void rule__LibIterationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2178:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2179:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2179:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2180:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4472); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2193:1: rule__LibIterationCS__Group__10 : rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 ;
    public final void rule__LibIterationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2197:1: ( rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2198:2: rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104503);
            rule__LibIterationCS__Group__10__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104506);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2205:1: rule__LibIterationCS__Group__10__Impl : ( ( rule__LibIterationCS__ClassAssignment_10 ) ) ;
    public final void rule__LibIterationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2209:1: ( ( ( rule__LibIterationCS__ClassAssignment_10 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2210:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2210:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2211:1: ( rule__LibIterationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2212:1: ( rule__LibIterationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2212:2: rule__LibIterationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4533);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2222:1: rule__LibIterationCS__Group__11 : rule__LibIterationCS__Group__11__Impl ;
    public final void rule__LibIterationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2226:1: ( rule__LibIterationCS__Group__11__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2227:2: rule__LibIterationCS__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114563);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2233:1: rule__LibIterationCS__Group__11__Impl : ( ';' ) ;
    public final void rule__LibIterationCS__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2237:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2238:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2238:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2239:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4591); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2276:1: rule__LibIterationCS__Group_2__0 : rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 ;
    public final void rule__LibIterationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2280:1: ( rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2281:2: rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04646);
            rule__LibIterationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04649);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2288:1: rule__LibIterationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibIterationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2292:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2293:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2293:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2294:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4677); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2307:1: rule__LibIterationCS__Group_2__1 : rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 ;
    public final void rule__LibIterationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2311:1: ( rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2312:2: rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14708);
            rule__LibIterationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14711);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2319:1: rule__LibIterationCS__Group_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2323:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2324:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2324:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2325:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2326:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2326:2: rule__LibIterationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4738);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2336:1: rule__LibIterationCS__Group_2__2 : rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 ;
    public final void rule__LibIterationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2340:1: ( rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2341:2: rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24768);
            rule__LibIterationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24771);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2348:1: rule__LibIterationCS__Group_2__2__Impl : ( ( rule__LibIterationCS__Group_2_2__0 )* ) ;
    public final void rule__LibIterationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2352:1: ( ( ( rule__LibIterationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2353:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2353:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2354:1: ( rule__LibIterationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2355:1: ( rule__LibIterationCS__Group_2_2__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2355:2: rule__LibIterationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4798);
            	    rule__LibIterationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2365:1: rule__LibIterationCS__Group_2__3 : rule__LibIterationCS__Group_2__3__Impl ;
    public final void rule__LibIterationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2369:1: ( rule__LibIterationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2370:2: rule__LibIterationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34829);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2376:1: rule__LibIterationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibIterationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2380:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2381:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2381:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2382:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4857); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2403:1: rule__LibIterationCS__Group_2_2__0 : rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 ;
    public final void rule__LibIterationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2407:1: ( rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2408:2: rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04896);
            rule__LibIterationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04899);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2415:1: rule__LibIterationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2419:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2420:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2420:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2421:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4927); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2434:1: rule__LibIterationCS__Group_2_2__1 : rule__LibIterationCS__Group_2_2__1__Impl ;
    public final void rule__LibIterationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2438:1: ( rule__LibIterationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2439:2: rule__LibIterationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14958);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2445:1: rule__LibIterationCS__Group_2_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2449:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2450:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2450:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2451:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2452:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2452:2: rule__LibIterationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl4985);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2466:1: rule__LibIterationCS__Group_5__0 : rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 ;
    public final void rule__LibIterationCS__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2470:1: ( rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2471:2: rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__05019);
            rule__LibIterationCS__Group_5__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__05022);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2478:1: rule__LibIterationCS__Group_5__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2482:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2483:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2483:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2484:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl5050); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2497:1: rule__LibIterationCS__Group_5__1 : rule__LibIterationCS__Group_5__1__Impl ;
    public final void rule__LibIterationCS__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2501:1: ( rule__LibIterationCS__Group_5__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2502:2: rule__LibIterationCS__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__15081);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2508:1: rule__LibIterationCS__Group_5__1__Impl : ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) ;
    public final void rule__LibIterationCS__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2512:1: ( ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2513:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2513:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2514:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_5_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2515:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2515:2: rule__LibIterationCS__ParametersAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5108);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2529:1: rule__LibOperationCS__Group__0 : rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 ;
    public final void rule__LibOperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2533:1: ( rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2534:2: rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05142);
            rule__LibOperationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05145);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2541:1: rule__LibOperationCS__Group__0__Impl : ( 'operation' ) ;
    public final void rule__LibOperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2545:1: ( ( 'operation' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2546:1: ( 'operation' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2546:1: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2547:1: 'operation'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5173); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2560:1: rule__LibOperationCS__Group__1 : rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 ;
    public final void rule__LibOperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2564:1: ( rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2565:2: rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15204);
            rule__LibOperationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15207);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2572:1: rule__LibOperationCS__Group__1__Impl : ( ( rule__LibOperationCS__NameAssignment_1 ) ) ;
    public final void rule__LibOperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2576:1: ( ( ( rule__LibOperationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2577:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2577:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2578:1: ( rule__LibOperationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2579:1: ( rule__LibOperationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2579:2: rule__LibOperationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5234);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2589:1: rule__LibOperationCS__Group__2 : rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 ;
    public final void rule__LibOperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2593:1: ( rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2594:2: rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25264);
            rule__LibOperationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25267);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2601:1: rule__LibOperationCS__Group__2__Impl : ( ( rule__LibOperationCS__Group_2__0 )? ) ;
    public final void rule__LibOperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2605:1: ( ( ( rule__LibOperationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2606:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2606:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2607:1: ( rule__LibOperationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2608:1: ( rule__LibOperationCS__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==27) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2608:2: rule__LibOperationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5294);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2618:1: rule__LibOperationCS__Group__3 : rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 ;
    public final void rule__LibOperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2622:1: ( rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2623:2: rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35325);
            rule__LibOperationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35328);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2630:1: rule__LibOperationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibOperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2634:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2635:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2635:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2636:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5356); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2649:1: rule__LibOperationCS__Group__4 : rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 ;
    public final void rule__LibOperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2653:1: ( rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2654:2: rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45387);
            rule__LibOperationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45390);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2661:1: rule__LibOperationCS__Group__4__Impl : ( ( rule__LibOperationCS__Group_4__0 )? ) ;
    public final void rule__LibOperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2665:1: ( ( ( rule__LibOperationCS__Group_4__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2666:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2666:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2667:1: ( rule__LibOperationCS__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2668:1: ( rule__LibOperationCS__Group_4__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=12 && LA25_0<=21)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2668:2: rule__LibOperationCS__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5417);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2678:1: rule__LibOperationCS__Group__5 : rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 ;
    public final void rule__LibOperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2682:1: ( rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2683:2: rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55448);
            rule__LibOperationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55451);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2690:1: rule__LibOperationCS__Group__5__Impl : ( ')' ) ;
    public final void rule__LibOperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2694:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2695:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2695:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2696:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5479); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2709:1: rule__LibOperationCS__Group__6 : rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 ;
    public final void rule__LibOperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2713:1: ( rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2714:2: rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65510);
            rule__LibOperationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65513);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2721:1: rule__LibOperationCS__Group__6__Impl : ( ':' ) ;
    public final void rule__LibOperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2725:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2726:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2726:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2727:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5541); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2740:1: rule__LibOperationCS__Group__7 : rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 ;
    public final void rule__LibOperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2744:1: ( rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2745:2: rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75572);
            rule__LibOperationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75575);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2752:1: rule__LibOperationCS__Group__7__Impl : ( ( rule__LibOperationCS__TypeAssignment_7 ) ) ;
    public final void rule__LibOperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2756:1: ( ( ( rule__LibOperationCS__TypeAssignment_7 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2757:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2757:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2758:1: ( rule__LibOperationCS__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2759:1: ( rule__LibOperationCS__TypeAssignment_7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2759:2: rule__LibOperationCS__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5602);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2769:1: rule__LibOperationCS__Group__8 : rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 ;
    public final void rule__LibOperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:2: rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85632);
            rule__LibOperationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85635);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2781:1: rule__LibOperationCS__Group__8__Impl : ( '=>' ) ;
    public final void rule__LibOperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2785:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2786:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2786:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2787:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5663); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2800:1: rule__LibOperationCS__Group__9 : rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 ;
    public final void rule__LibOperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2804:1: ( rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2805:2: rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95694);
            rule__LibOperationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95697);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2812:1: rule__LibOperationCS__Group__9__Impl : ( ( rule__LibOperationCS__ClassAssignment_9 ) ) ;
    public final void rule__LibOperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2816:1: ( ( ( rule__LibOperationCS__ClassAssignment_9 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2817:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2817:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2818:1: ( rule__LibOperationCS__ClassAssignment_9 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2819:1: ( rule__LibOperationCS__ClassAssignment_9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2819:2: rule__LibOperationCS__ClassAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5724);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2829:1: rule__LibOperationCS__Group__10 : rule__LibOperationCS__Group__10__Impl ;
    public final void rule__LibOperationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2833:1: ( rule__LibOperationCS__Group__10__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2834:2: rule__LibOperationCS__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105754);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2840:1: rule__LibOperationCS__Group__10__Impl : ( ';' ) ;
    public final void rule__LibOperationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2844:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2845:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2845:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2846:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5782); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2881:1: rule__LibOperationCS__Group_2__0 : rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 ;
    public final void rule__LibOperationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2885:1: ( rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2886:2: rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05835);
            rule__LibOperationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05838);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2893:1: rule__LibOperationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibOperationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2897:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2898:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2898:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2899:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5866); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2912:1: rule__LibOperationCS__Group_2__1 : rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 ;
    public final void rule__LibOperationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2916:1: ( rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2917:2: rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15897);
            rule__LibOperationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15900);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2924:1: rule__LibOperationCS__Group_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2928:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2929:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2929:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2930:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2931:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2931:2: rule__LibOperationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5927);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2941:1: rule__LibOperationCS__Group_2__2 : rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 ;
    public final void rule__LibOperationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2945:1: ( rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2946:2: rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25957);
            rule__LibOperationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25960);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2953:1: rule__LibOperationCS__Group_2__2__Impl : ( ( rule__LibOperationCS__Group_2_2__0 )* ) ;
    public final void rule__LibOperationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2957:1: ( ( ( rule__LibOperationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2958:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2958:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2959:1: ( rule__LibOperationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2960:1: ( rule__LibOperationCS__Group_2_2__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==29) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2960:2: rule__LibOperationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl5987);
            	    rule__LibOperationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2970:1: rule__LibOperationCS__Group_2__3 : rule__LibOperationCS__Group_2__3__Impl ;
    public final void rule__LibOperationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2974:1: ( rule__LibOperationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2975:2: rule__LibOperationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__36018);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2981:1: rule__LibOperationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibOperationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2985:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2986:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2986:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2987:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl6046); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3008:1: rule__LibOperationCS__Group_2_2__0 : rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 ;
    public final void rule__LibOperationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3012:1: ( rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3013:2: rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__06085);
            rule__LibOperationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__06088);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3020:1: rule__LibOperationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3024:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3025:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3025:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3026:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6116); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3039:1: rule__LibOperationCS__Group_2_2__1 : rule__LibOperationCS__Group_2_2__1__Impl ;
    public final void rule__LibOperationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3043:1: ( rule__LibOperationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3044:2: rule__LibOperationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16147);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3050:1: rule__LibOperationCS__Group_2_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3054:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3055:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3055:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3056:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3057:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3057:2: rule__LibOperationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6174);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3071:1: rule__LibOperationCS__Group_4__0 : rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 ;
    public final void rule__LibOperationCS__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3075:1: ( rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3076:2: rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06208);
            rule__LibOperationCS__Group_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06211);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3083:1: rule__LibOperationCS__Group_4__0__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) ;
    public final void rule__LibOperationCS__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3087:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3088:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3088:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3089:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3090:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3090:2: rule__LibOperationCS__ParametersAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6238);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3100:1: rule__LibOperationCS__Group_4__1 : rule__LibOperationCS__Group_4__1__Impl ;
    public final void rule__LibOperationCS__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( rule__LibOperationCS__Group_4__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:2: rule__LibOperationCS__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16268);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3111:1: rule__LibOperationCS__Group_4__1__Impl : ( ( rule__LibOperationCS__Group_4_1__0 )* ) ;
    public final void rule__LibOperationCS__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3115:1: ( ( ( rule__LibOperationCS__Group_4_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3116:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3116:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3117:1: ( rule__LibOperationCS__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3118:1: ( rule__LibOperationCS__Group_4_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==29) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3118:2: rule__LibOperationCS__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6295);
            	    rule__LibOperationCS__Group_4_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3132:1: rule__LibOperationCS__Group_4_1__0 : rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 ;
    public final void rule__LibOperationCS__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3136:1: ( rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3137:2: rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06330);
            rule__LibOperationCS__Group_4_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06333);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3144:1: rule__LibOperationCS__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3148:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3149:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3149:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3150:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6361); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3163:1: rule__LibOperationCS__Group_4_1__1 : rule__LibOperationCS__Group_4_1__1__Impl ;
    public final void rule__LibOperationCS__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3167:1: ( rule__LibOperationCS__Group_4_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3168:2: rule__LibOperationCS__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16392);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3174:1: rule__LibOperationCS__Group_4_1__1__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__LibOperationCS__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3178:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3179:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3179:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3180:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3181:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3181:2: rule__LibOperationCS__ParametersAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6419);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3195:1: rule__LibPackageCS__Group__0 : rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 ;
    public final void rule__LibPackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3199:1: ( rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3200:2: rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06453);
            rule__LibPackageCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06456);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3207:1: rule__LibPackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__LibPackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3211:1: ( ( 'package' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3212:1: ( 'package' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3212:1: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3213:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6484); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3226:1: rule__LibPackageCS__Group__1 : rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 ;
    public final void rule__LibPackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3230:1: ( rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3231:2: rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16515);
            rule__LibPackageCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16518);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3238:1: rule__LibPackageCS__Group__1__Impl : ( ( rule__LibPackageCS__NameAssignment_1 ) ) ;
    public final void rule__LibPackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3242:1: ( ( ( rule__LibPackageCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3243:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3243:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3244:1: ( rule__LibPackageCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3245:1: ( rule__LibPackageCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3245:2: rule__LibPackageCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6545);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3255:1: rule__LibPackageCS__Group__2 : rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 ;
    public final void rule__LibPackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3259:1: ( rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3260:2: rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26575);
            rule__LibPackageCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26578);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3267:1: rule__LibPackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__LibPackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3271:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3272:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3272:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3273:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6606); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3286:1: rule__LibPackageCS__Group__3 : rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 ;
    public final void rule__LibPackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3290:1: ( rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3291:2: rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36637);
            rule__LibPackageCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36640);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3298:1: rule__LibPackageCS__Group__3__Impl : ( ( rule__LibPackageCS__Alternatives_3 )* ) ;
    public final void rule__LibPackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3302:1: ( ( ( rule__LibPackageCS__Alternatives_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3303:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3303:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3304:1: ( rule__LibPackageCS__Alternatives_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3305:1: ( rule__LibPackageCS__Alternatives_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==18||LA28_0==21) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3305:2: rule__LibPackageCS__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6667);
            	    rule__LibPackageCS__Alternatives_3();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3315:1: rule__LibPackageCS__Group__4 : rule__LibPackageCS__Group__4__Impl ;
    public final void rule__LibPackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3319:1: ( rule__LibPackageCS__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3320:2: rule__LibPackageCS__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46698);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3326:1: rule__LibPackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__LibPackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3330:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3331:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3331:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3332:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6726); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3355:1: rule__LibParameterCS__Group__0 : rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 ;
    public final void rule__LibParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3359:1: ( rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3360:2: rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06767);
            rule__LibParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06770);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3367:1: rule__LibParameterCS__Group__0__Impl : ( ( rule__LibParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3371:1: ( ( ( rule__LibParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3372:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3372:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3373:1: ( rule__LibParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3374:1: ( rule__LibParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3374:2: rule__LibParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6797);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3384:1: rule__LibParameterCS__Group__1 : rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 ;
    public final void rule__LibParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: ( rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3389:2: rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16827);
            rule__LibParameterCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16830);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3396:1: rule__LibParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__LibParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3400:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3401:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3401:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3402:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6858); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3415:1: rule__LibParameterCS__Group__2 : rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 ;
    public final void rule__LibParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3419:1: ( rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3420:2: rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26889);
            rule__LibParameterCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26892);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3427:1: rule__LibParameterCS__Group__2__Impl : ( ( rule__LibParameterCS__TypeAssignment_2 ) ) ;
    public final void rule__LibParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3431:1: ( ( ( rule__LibParameterCS__TypeAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3432:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3432:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3433:1: ( rule__LibParameterCS__TypeAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3434:1: ( rule__LibParameterCS__TypeAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3434:2: rule__LibParameterCS__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6919);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3444:1: rule__LibParameterCS__Group__3 : rule__LibParameterCS__Group__3__Impl ;
    public final void rule__LibParameterCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3448:1: ( rule__LibParameterCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3449:2: rule__LibParameterCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36949);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3455:1: rule__LibParameterCS__Group__3__Impl : ( ( rule__LibParameterCS__Group_3__0 )? ) ;
    public final void rule__LibParameterCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3459:1: ( ( ( rule__LibParameterCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3460:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3460:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3461:1: ( rule__LibParameterCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3462:1: ( rule__LibParameterCS__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==34) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3462:2: rule__LibParameterCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl6976);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3480:1: rule__LibParameterCS__Group_3__0 : rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 ;
    public final void rule__LibParameterCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3484:1: ( rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3485:2: rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__07015);
            rule__LibParameterCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__07018);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3492:1: rule__LibParameterCS__Group_3__0__Impl : ( '[' ) ;
    public final void rule__LibParameterCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3497:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3497:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3498:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl7046); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3511:1: rule__LibParameterCS__Group_3__1 : rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 ;
    public final void rule__LibParameterCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3515:1: ( rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3516:2: rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__17077);
            rule__LibParameterCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__17080);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3523:1: rule__LibParameterCS__Group_3__1__Impl : ( ( rule__LibParameterCS__Alternatives_3_1 ) ) ;
    public final void rule__LibParameterCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3527:1: ( ( ( rule__LibParameterCS__Alternatives_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3528:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3528:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3529:1: ( rule__LibParameterCS__Alternatives_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3530:1: ( rule__LibParameterCS__Alternatives_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3530:2: rule__LibParameterCS__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7107);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3540:1: rule__LibParameterCS__Group_3__2 : rule__LibParameterCS__Group_3__2__Impl ;
    public final void rule__LibParameterCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: ( rule__LibParameterCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3545:2: rule__LibParameterCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27137);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3551:1: rule__LibParameterCS__Group_3__2__Impl : ( ']' ) ;
    public final void rule__LibParameterCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3555:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3556:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3556:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3557:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7165); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3576:1: rule__LibParameterCS__Group_3_1_0__0 : rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 ;
    public final void rule__LibParameterCS__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3580:1: ( rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3581:2: rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07202);
            rule__LibParameterCS__Group_3_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07205);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3588:1: rule__LibParameterCS__Group_3_1_0__0__Impl : ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3592:1: ( ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3593:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3593:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3594:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3595:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3595:2: rule__LibParameterCS__LowerAssignment_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7232);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3605:1: rule__LibParameterCS__Group_3_1_0__1 : rule__LibParameterCS__Group_3_1_0__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3609:1: ( rule__LibParameterCS__Group_3_1_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3610:2: rule__LibParameterCS__Group_3_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17262);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3616:1: rule__LibParameterCS__Group_3_1_0__1__Impl : ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) ;
    public final void rule__LibParameterCS__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3620:1: ( ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3621:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3621:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3622:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3623:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3623:2: rule__LibParameterCS__Group_3_1_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7289);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3637:1: rule__LibParameterCS__Group_3_1_0_1__0 : rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3641:1: ( rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3642:2: rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07324);
            rule__LibParameterCS__Group_3_1_0_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07327);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3649:1: rule__LibParameterCS__Group_3_1_0_1__0__Impl : ( '..' ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3653:1: ( ( '..' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3654:1: ( '..' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3654:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3655:1: '..'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7355); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3668:1: rule__LibParameterCS__Group_3_1_0_1__1 : rule__LibParameterCS__Group_3_1_0_1__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3672:1: ( rule__LibParameterCS__Group_3_1_0_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3673:2: rule__LibParameterCS__Group_3_1_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17386);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3679:1: rule__LibParameterCS__Group_3_1_0_1__1__Impl : ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3683:1: ( ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3684:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3684:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3685:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3686:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3686:2: rule__LibParameterCS__UpperAssignment_3_1_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7413);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3700:1: rule__LibPropertyCS__Group__0 : rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 ;
    public final void rule__LibPropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3704:1: ( rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3705:2: rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07447);
            rule__LibPropertyCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07450);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3712:1: rule__LibPropertyCS__Group__0__Impl : ( 'property' ) ;
    public final void rule__LibPropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3716:1: ( ( 'property' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3717:1: ( 'property' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3717:1: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3718:1: 'property'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7478); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3731:1: rule__LibPropertyCS__Group__1 : rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 ;
    public final void rule__LibPropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3735:1: ( rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3736:2: rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17509);
            rule__LibPropertyCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17512);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3743:1: rule__LibPropertyCS__Group__1__Impl : ( ( rule__LibPropertyCS__NameAssignment_1 ) ) ;
    public final void rule__LibPropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3747:1: ( ( ( rule__LibPropertyCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3748:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3748:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3749:1: ( rule__LibPropertyCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3750:1: ( rule__LibPropertyCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3750:2: rule__LibPropertyCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7539);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3760:1: rule__LibPropertyCS__Group__2 : rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 ;
    public final void rule__LibPropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3764:1: ( rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3765:2: rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27569);
            rule__LibPropertyCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27572);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3772:1: rule__LibPropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__LibPropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3776:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3777:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3777:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3778:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7600); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3791:1: rule__LibPropertyCS__Group__3 : rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 ;
    public final void rule__LibPropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3795:1: ( rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3796:2: rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37631);
            rule__LibPropertyCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37634);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3803:1: rule__LibPropertyCS__Group__3__Impl : ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) ;
    public final void rule__LibPropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3807:1: ( ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3808:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3808:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3809:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3810:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3810:2: rule__LibPropertyCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7661);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3820:1: rule__LibPropertyCS__Group__4 : rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 ;
    public final void rule__LibPropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3824:1: ( rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3825:2: rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47691);
            rule__LibPropertyCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47694);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3832:1: rule__LibPropertyCS__Group__4__Impl : ( '=>' ) ;
    public final void rule__LibPropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3836:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3837:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3837:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3838:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7722); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3851:1: rule__LibPropertyCS__Group__5 : rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 ;
    public final void rule__LibPropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3855:1: ( rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3856:2: rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57753);
            rule__LibPropertyCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57756);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3863:1: rule__LibPropertyCS__Group__5__Impl : ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) ;
    public final void rule__LibPropertyCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3867:1: ( ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3868:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3868:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3869:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3870:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3870:2: rule__LibPropertyCS__ClassAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7783);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3880:1: rule__LibPropertyCS__Group__6 : rule__LibPropertyCS__Group__6__Impl ;
    public final void rule__LibPropertyCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3884:1: ( rule__LibPropertyCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3885:2: rule__LibPropertyCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67813);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3891:1: rule__LibPropertyCS__Group__6__Impl : ( ';' ) ;
    public final void rule__LibPropertyCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3895:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3896:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3896:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3897:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7841); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3924:1: rule__LibQualifiedTypeRefCS__Group__0 : rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3928:1: ( rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3929:2: rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07886);
            rule__LibQualifiedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07889);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3936:1: rule__LibQualifiedTypeRefCS__Group__0__Impl : ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3940:1: ( ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3941:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3941:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3942:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3943:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3943:2: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7916);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3953:1: rule__LibQualifiedTypeRefCS__Group__1 : rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3957:1: ( rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3958:2: rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17946);
            rule__LibQualifiedTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17949);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3965:1: rule__LibQualifiedTypeRefCS__Group__1__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3969:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3970:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3970:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3971:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3972:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==27) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3972:2: rule__LibQualifiedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl7976);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3982:1: rule__LibQualifiedTypeRefCS__Group__2 : rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3986:1: ( rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3987:2: rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__28007);
            rule__LibQualifiedTypeRefCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__28010);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3994:1: rule__LibQualifiedTypeRefCS__Group__2__Impl : ( '::' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3998:1: ( ( '::' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3999:1: ( '::' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3999:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4000:1: '::'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }
            match(input,37,FollowSets000.FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl8038); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4013:1: rule__LibQualifiedTypeRefCS__Group__3 : rule__LibQualifiedTypeRefCS__Group__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4017:1: ( rule__LibQualifiedTypeRefCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4018:2: rule__LibQualifiedTypeRefCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__38069);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4024:1: rule__LibQualifiedTypeRefCS__Group__3__Impl : ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4028:1: ( ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4029:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4029:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4030:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4031:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4031:2: rule__LibQualifiedTypeRefCS__ElementAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8096);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4049:1: rule__LibQualifiedTypeRefCS__Group_1__0 : rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4053:1: ( rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4054:2: rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08134);
            rule__LibQualifiedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08137);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4061:1: rule__LibQualifiedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4065:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4066:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4066:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4067:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8165); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4080:1: rule__LibQualifiedTypeRefCS__Group_1__1 : rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4084:1: ( rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4085:2: rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18196);
            rule__LibQualifiedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18199);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4092:1: rule__LibQualifiedTypeRefCS__Group_1__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4096:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4097:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4097:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4098:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4099:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4099:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8226);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4109:1: rule__LibQualifiedTypeRefCS__Group_1__2 : rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4113:1: ( rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4114:2: rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28256);
            rule__LibQualifiedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28259);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4121:1: rule__LibQualifiedTypeRefCS__Group_1__2__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4125:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4126:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4126:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4127:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4128:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==29) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4128:2: rule__LibQualifiedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8286);
            	    rule__LibQualifiedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4138:1: rule__LibQualifiedTypeRefCS__Group_1__3 : rule__LibQualifiedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4142:1: ( rule__LibQualifiedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4143:2: rule__LibQualifiedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38317);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4149:1: rule__LibQualifiedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4153:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4154:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4154:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4155:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8345); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4176:1: rule__LibQualifiedTypeRefCS__Group_1_2__0 : rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4180:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4181:2: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08384);
            rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08387);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4188:1: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4192:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4193:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4193:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4194:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8415); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4207:1: rule__LibQualifiedTypeRefCS__Group_1_2__1 : rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4211:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4212:2: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18446);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4218:1: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4222:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4223:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4223:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4224:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4225:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4225:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8473);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4239:1: rule__LibTypeParameterCS__Group__0 : rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 ;
    public final void rule__LibTypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4243:1: ( rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4244:2: rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08507);
            rule__LibTypeParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08510);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4251:1: rule__LibTypeParameterCS__Group__0__Impl : ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibTypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4255:1: ( ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4256:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4256:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4257:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4258:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4258:2: rule__LibTypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8537);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4268:1: rule__LibTypeParameterCS__Group__1 : rule__LibTypeParameterCS__Group__1__Impl ;
    public final void rule__LibTypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4272:1: ( rule__LibTypeParameterCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4273:2: rule__LibTypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18567);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4279:1: rule__LibTypeParameterCS__Group__1__Impl : ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__LibTypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4283:1: ( ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4284:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4284:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4285:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4286:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==13||LA33_0==20) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4286:2: rule__LibTypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8594);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4300:1: rule__LibTypeParameterCS__Group_1_0__0 : rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4304:1: ( rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4305:2: rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08629);
            rule__LibTypeParameterCS__Group_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08632);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4312:1: rule__LibTypeParameterCS__Group_1_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4316:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4317:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4317:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4318:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8660); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4331:1: rule__LibTypeParameterCS__Group_1_0__1 : rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 ;
    public final void rule__LibTypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4335:1: ( rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4336:2: rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18691);
            rule__LibTypeParameterCS__Group_1_0__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18694);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4343:1: rule__LibTypeParameterCS__Group_1_0__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4347:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4348:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4348:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4349:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4350:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4350:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8721);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4360:1: rule__LibTypeParameterCS__Group_1_0__2 : rule__LibTypeParameterCS__Group_1_0__2__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4364:1: ( rule__LibTypeParameterCS__Group_1_0__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4365:2: rule__LibTypeParameterCS__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28751);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4371:1: rule__LibTypeParameterCS__Group_1_0__2__Impl : ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4375:1: ( ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4376:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4376:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4377:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4378:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==38) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4378:2: rule__LibTypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8778);
            	    rule__LibTypeParameterCS__Group_1_0_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4394:1: rule__LibTypeParameterCS__Group_1_0_2__0 : rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4398:1: ( rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4399:2: rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08815);
            rule__LibTypeParameterCS__Group_1_0_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08818);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4406:1: rule__LibTypeParameterCS__Group_1_0_2__0__Impl : ( '&&' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4410:1: ( ( '&&' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4411:1: ( '&&' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4411:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4412:1: '&&'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,38,FollowSets000.FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8846); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4425:1: rule__LibTypeParameterCS__Group_1_0_2__1 : rule__LibTypeParameterCS__Group_1_0_2__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4429:1: ( rule__LibTypeParameterCS__Group_1_0_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4430:2: rule__LibTypeParameterCS__Group_1_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18877);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4436:1: rule__LibTypeParameterCS__Group_1_0_2__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4440:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4441:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4441:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4442:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4443:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4443:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8904);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4457:1: rule__LibTypeParameterCS__Group_1_1__0 : rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 ;
    public final void rule__LibTypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4461:1: ( rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4462:2: rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08938);
            rule__LibTypeParameterCS__Group_1_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08941);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4469:1: rule__LibTypeParameterCS__Group_1_1__0__Impl : ( 'super' ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4473:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4474:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4474:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4475:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl8969); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4488:1: rule__LibTypeParameterCS__Group_1_1__1 : rule__LibTypeParameterCS__Group_1_1__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4492:1: ( rule__LibTypeParameterCS__Group_1_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4493:2: rule__LibTypeParameterCS__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__19000);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4499:1: rule__LibTypeParameterCS__Group_1_1__1__Impl : ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4503:1: ( ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4504:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4504:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4505:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4506:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4506:2: rule__LibTypeParameterCS__SuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl9027);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4520:1: rule__LibTypedTypeRefCS__Group__0 : rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 ;
    public final void rule__LibTypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4524:1: ( rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4525:2: rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__09061);
            rule__LibTypedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__09064);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4532:1: rule__LibTypedTypeRefCS__Group__0__Impl : ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4536:1: ( ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4537:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4537:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4538:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4539:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4539:2: rule__LibTypedTypeRefCS__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl9091);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4549:1: rule__LibTypedTypeRefCS__Group__1 : rule__LibTypedTypeRefCS__Group__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4553:1: ( rule__LibTypedTypeRefCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4554:2: rule__LibTypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19121);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4560:1: rule__LibTypedTypeRefCS__Group__1__Impl : ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibTypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4564:1: ( ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4565:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4565:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4566:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4567:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4567:2: rule__LibTypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9148);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4581:1: rule__LibTypedTypeRefCS__Group_1__0 : rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4585:1: ( rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4586:2: rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09183);
            rule__LibTypedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09186);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4593:1: rule__LibTypedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4597:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4598:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4598:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4599:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9214); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4612:1: rule__LibTypedTypeRefCS__Group_1__1 : rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 ;
    public final void rule__LibTypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4616:1: ( rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4617:2: rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19245);
            rule__LibTypedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19248);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4624:1: rule__LibTypedTypeRefCS__Group_1__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4628:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4629:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4629:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4630:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4631:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4631:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9275);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4641:1: rule__LibTypedTypeRefCS__Group_1__2 : rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 ;
    public final void rule__LibTypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4645:1: ( rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4646:2: rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29305);
            rule__LibTypedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29308);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4653:1: rule__LibTypedTypeRefCS__Group_1__2__Impl : ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4657:1: ( ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4658:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4658:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4659:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4660:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==29) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4660:2: rule__LibTypedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9335);
            	    rule__LibTypedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4670:1: rule__LibTypedTypeRefCS__Group_1__3 : rule__LibTypedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4674:1: ( rule__LibTypedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4675:2: rule__LibTypedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39366);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4681:1: rule__LibTypedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4685:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4686:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4686:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4687:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9394); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4708:1: rule__LibTypedTypeRefCS__Group_1_2__0 : rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4712:1: ( rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4713:2: rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09433);
            rule__LibTypedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09436);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4720:1: rule__LibTypedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4724:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4725:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4725:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4726:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9464); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4739:1: rule__LibTypedTypeRefCS__Group_1_2__1 : rule__LibTypedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4743:1: ( rule__LibTypedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4744:2: rule__LibTypedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19495);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4750:1: rule__LibTypedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4754:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4755:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4755:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4756:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4757:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4757:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9522);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4771:1: rule__LibWildcardTypeRefCS__Group__0 : rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 ;
    public final void rule__LibWildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4775:1: ( rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4776:2: rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09556);
            rule__LibWildcardTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09559);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4783:1: rule__LibWildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__LibWildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4787:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4788:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4788:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4789:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4790:1: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4792:1: 
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4802:1: rule__LibWildcardTypeRefCS__Group__1 : rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 ;
    public final void rule__LibWildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4806:1: ( rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4807:2: rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19617);
            rule__LibWildcardTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19620);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4814:1: rule__LibWildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__LibWildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4818:1: ( ( '?' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4819:1: ( '?' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4819:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4820:1: '?'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9648); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4833:1: rule__LibWildcardTypeRefCS__Group__2 : rule__LibWildcardTypeRefCS__Group__2__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4837:1: ( rule__LibWildcardTypeRefCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4838:2: rule__LibWildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29679);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4844:1: rule__LibWildcardTypeRefCS__Group__2__Impl : ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__LibWildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4848:1: ( ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4849:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4849:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4850:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4851:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==13||LA37_0==20) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4851:2: rule__LibWildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9706);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4867:1: rule__LibWildcardTypeRefCS__Group_2_0__0 : rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4871:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4872:2: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09743);
            rule__LibWildcardTypeRefCS__Group_2_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09746);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4879:1: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4883:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4884:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4884:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4885:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9774); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4898:1: rule__LibWildcardTypeRefCS__Group_2_0__1 : rule__LibWildcardTypeRefCS__Group_2_0__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4902:1: ( rule__LibWildcardTypeRefCS__Group_2_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4903:2: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19805);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4909:1: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl : ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4913:1: ( ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4914:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4914:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4915:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4916:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4916:2: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9832);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4930:1: rule__LibWildcardTypeRefCS__Group_2_1__0 : rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4934:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4935:2: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09866);
            rule__LibWildcardTypeRefCS__Group_2_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09869);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4942:1: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl : ( 'super' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4946:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4947:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4947:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4948:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9897); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4961:1: rule__LibWildcardTypeRefCS__Group_2_1__1 : rule__LibWildcardTypeRefCS__Group_2_1__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4965:1: ( rule__LibWildcardTypeRefCS__Group_2_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4966:2: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19928);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4972:1: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl : ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4976:1: ( ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4977:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4977:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4978:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4979:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4979:2: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9955);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4994:1: rule__Library__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4998:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4999:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4999:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5000:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_19994);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5009:1: rule__Library__ImportsAssignment_2 : ( ruleLibImportCS ) ;
    public final void rule__Library__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5013:1: ( ( ruleLibImportCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5014:1: ( ruleLibImportCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5014:1: ( ruleLibImportCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5015:1: ruleLibImportCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_210025);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5024:1: rule__Library__PackagesAssignment_4 : ( ruleLibPackageCS ) ;
    public final void rule__Library__PackagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5028:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5029:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5029:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5030:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_410056);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5039:1: rule__LibImportCS__NameAssignment_1_0 : ( ruleIdentifier ) ;
    public final void rule__LibImportCS__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5043:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5044:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5044:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5045:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_010087);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5054:1: rule__LibImportCS__NamespaceAssignment_2 : ( ( RULE_SINGLE_QUOTED_STRING ) ) ;
    public final void rule__LibImportCS__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5058:1: ( ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5059:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5059:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5060:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5061:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5062:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210122); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5073:1: rule__LibClassCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5077:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5078:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5078:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5079:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110157);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5088:1: rule__LibClassCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5092:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5093:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5093:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5094:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110188);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5103:1: rule__LibClassCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5107:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5108:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5108:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5109:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110219);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5118:1: rule__LibClassCS__ConformsToAssignment_3_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5122:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5123:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5123:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5124:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110250);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5133:1: rule__LibClassCS__ConformsToAssignment_3_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5137:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5138:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5138:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5139:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110281);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5148:1: rule__LibClassCS__IterationsAssignment_5_0 : ( ruleLibIterationCS ) ;
    public final void rule__LibClassCS__IterationsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5152:1: ( ( ruleLibIterationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5153:1: ( ruleLibIterationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5153:1: ( ruleLibIterationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5154:1: ruleLibIterationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getIterationsLibIterationCSParserRuleCall_5_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_010312);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5163:1: rule__LibClassCS__OperationsAssignment_5_1 : ( ruleLibOperationCS ) ;
    public final void rule__LibClassCS__OperationsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5167:1: ( ( ruleLibOperationCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5168:1: ( ruleLibOperationCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5168:1: ( ruleLibOperationCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5169:1: ruleLibOperationCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_110343);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5178:1: rule__LibClassCS__StructuralFeaturesAssignment_5_2 : ( ruleLibPropertyCS ) ;
    public final void rule__LibClassCS__StructuralFeaturesAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5182:1: ( ( ruleLibPropertyCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5183:1: ( ruleLibPropertyCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5183:1: ( ruleLibPropertyCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5184:1: ruleLibPropertyCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_210374);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5193:1: rule__LibIterationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibIterationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5197:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5198:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5198:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5199:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110405);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5208:1: rule__LibIterationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5212:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5213:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5213:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5214:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110436);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5223:1: rule__LibIterationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5227:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5228:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5228:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5229:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110467);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5238:1: rule__LibIterationCS__ParametersAssignment_4 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5242:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5243:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5243:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5244:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410498);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5253:1: rule__LibIterationCS__ParametersAssignment_5_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5257:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5258:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5258:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5259:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110529);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5268:1: rule__LibIterationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibIterationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5272:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5273:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5273:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5274:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810560);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5283:1: rule__LibIterationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibIterationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5287:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5288:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5288:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5289:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010591); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5298:1: rule__LibOperationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibOperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5302:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5303:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5303:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5304:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110622);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5313:1: rule__LibOperationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5317:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5318:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5318:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5319:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110653);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5328:1: rule__LibOperationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5332:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5333:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5333:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5334:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110684);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5343:1: rule__LibOperationCS__ParametersAssignment_4_0 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5347:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5348:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5348:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5349:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010715);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5358:1: rule__LibOperationCS__ParametersAssignment_4_1_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5362:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5363:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5363:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5364:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110746);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5373:1: rule__LibOperationCS__TypeAssignment_7 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibOperationCS__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5377:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5378:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5378:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5379:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710777);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5388:1: rule__LibOperationCS__ClassAssignment_9 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibOperationCS__ClassAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5392:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5393:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5393:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5394:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910808); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5403:1: rule__LibPackageCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibPackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5407:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5408:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5408:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5409:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110839);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5418:1: rule__LibPackageCS__SubpackagesAssignment_3_0 : ( ruleLibPackageCS ) ;
    public final void rule__LibPackageCS__SubpackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5422:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5423:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5423:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5424:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010870);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5433:1: rule__LibPackageCS__ClassifiersAssignment_3_1 : ( ruleLibClassifierCS ) ;
    public final void rule__LibPackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5437:1: ( ( ruleLibClassifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5438:1: ( ruleLibClassifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5438:1: ( ruleLibClassifierCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5439:1: ruleLibClassifierCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110901);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5448:1: rule__LibParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5452:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5453:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5453:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5454:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010932);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5463:1: rule__LibParameterCS__TypeAssignment_2 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibParameterCS__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5467:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5468:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5468:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5469:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210963);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5478:1: rule__LibParameterCS__LowerAssignment_3_1_0_0 : ( ruleLOWER ) ;
    public final void rule__LibParameterCS__LowerAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5482:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5483:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5483:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5484:1: ruleLOWER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010994);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5493:1: rule__LibParameterCS__UpperAssignment_3_1_0_1_1 : ( ruleUPPER ) ;
    public final void rule__LibParameterCS__UpperAssignment_3_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5497:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5498:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5498:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5499:1: ruleUPPER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_111025);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5508:1: rule__LibParameterCS__MultiplicityAssignment_3_1_1 : ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) ;
    public final void rule__LibParameterCS__MultiplicityAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5512:1: ( ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5513:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5513:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5514:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:2: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_111056);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5524:1: rule__LibPropertyCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibPropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5528:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5529:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5529:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5530:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_111089);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5539:1: rule__LibPropertyCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibPropertyCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5543:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5544:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5544:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5545:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311120);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5554:1: rule__LibPropertyCS__ClassAssignment_5 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibPropertyCS__ClassAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5558:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5559:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5559:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5560:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511151); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5569:1: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibQualifiedTypeRefCS__NamespaceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5573:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5574:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5574:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5575:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5576:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5577:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011186);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5588:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5592:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5593:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5593:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5594:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111221);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5603:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5607:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5608:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5608:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5609:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111252);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5618:1: rule__LibQualifiedTypeRefCS__ElementAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__ElementAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5622:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5623:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5623:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5624:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311283);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5633:1: rule__LibTypeParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibTypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5637:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5638:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5638:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5639:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011314);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5648:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5652:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5653:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5653:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5654:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111345);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5663:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5667:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5668:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5668:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5669:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111376);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5678:1: rule__LibTypeParameterCS__SuperAssignment_1_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__SuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5682:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5683:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5683:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5684:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111407);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5693:1: rule__LibTypedTypeRefCS__TypeAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibTypedTypeRefCS__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5697:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5698:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5698:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5699:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5700:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5701:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011442);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5712:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5716:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5717:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5717:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5718:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111477);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5727:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5731:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5732:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5732:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5733:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111508);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5742:1: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5746:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5747:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5747:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5748:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111539);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5757:1: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5761:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5762:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5762:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5763:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111570);
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ( ruleLibQualifiedTypeRefCS ) )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ruleLibQualifiedTypeRefCS )
        {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:1: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211985);
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
        public static final BitSet FOLLOW_ruleRestrictedKeywords_in_entryRuleRestrictedKeywords306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRestrictedKeywords313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RestrictedKeywords__Alternatives_in_ruleRestrictedKeywords339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_entryRuleName366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleName373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Name__Alternatives_in_ruleName399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_entryRuleLibImportCS426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibImportCS433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0_in_ruleLibImportCS459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_entryRuleLibClassCS486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassCS493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0_in_ruleLibClassCS519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_entryRuleLibClassifierCS546 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibClassifierCS553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassCS_in_ruleLibClassifierCS579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_entryRuleLibIterationCS605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibIterationCS612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0_in_ruleLibIterationCS638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_entryRuleLibOperationCS665 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibOperationCS672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0_in_ruleLibOperationCS698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_entryRuleLibPackageCS725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPackageCS732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0_in_ruleLibPackageCS758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_entryRuleLibParameterCS785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibParameterCS792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0_in_ruleLibParameterCS818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_entryRuleLibPropertyCS845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibPropertyCS852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0_in_ruleLibPropertyCS878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_entryRuleLibQualifiedTypeRefCS905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibQualifiedTypeRefCS912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0_in_ruleLibQualifiedTypeRefCS938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_entryRuleLibTypeParameterCS965 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeParameterCS972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0_in_ruleLibTypeParameterCS998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_entryRuleLibTypeRefCS1025 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypeRefCS1032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeRefCS__Alternatives_in_ruleLibTypeRefCS1058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_entryRuleLibTypedRefCS1085 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedRefCS1092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedRefCS__Alternatives_in_ruleLibTypedRefCS1118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_entryRuleLibTypedTypeRefCS1145 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibTypedTypeRefCS1152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0_in_ruleLibTypedTypeRefCS1178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_entryRuleLibWildcardTypeRefCS1205 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibWildcardTypeRefCS1212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0_in_ruleLibWildcardTypeRefCS1238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__UPPER__Alternatives1274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__UPPER__Alternatives1292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Identifier__Alternatives1326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRestrictedKeywords_in_rule__Identifier__Alternatives1343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__RestrictedKeywords__Alternatives1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__RestrictedKeywords__Alternatives1396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__RestrictedKeywords__Alternatives1416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__RestrictedKeywords__Alternatives1436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__RestrictedKeywords__Alternatives1456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__RestrictedKeywords__Alternatives1476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__RestrictedKeywords__Alternatives1496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__RestrictedKeywords__Alternatives1516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__RestrictedKeywords__Alternatives1536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__RestrictedKeywords__Alternatives1556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Name__Alternatives1590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_rule__Name__Alternatives1607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__IterationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__OperationsAssignment_5_1_in_rule__LibClassCS__Alternatives_51657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_2_in_rule__LibClassCS__Alternatives_51675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives1985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_22034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_22052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__02083 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Library__Group__0__Impl2114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12145 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22205 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2235 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32266 = new BitSet(new long[]{0x0000000002040000L});
        public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Library__Group__3__Impl2297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42328 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2358 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Library__Group__5__Impl2417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02460 = new BitSet(new long[]{0x00000000003FF0A0L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12522 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02646 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02769 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12831 = new BitSet(new long[]{0x0000000009001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22891 = new BitSet(new long[]{0x0000000001001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32952 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl2982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__43013 = new BitSet(new long[]{0x00000000020A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__43016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibClassCS__Group__4__Impl3044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__53075 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__53078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3105 = new BitSet(new long[]{0x00000000000A8002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03209 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13271 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23331 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3361 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03459 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03582 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13644 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3731 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03768 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03891 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13953 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl3983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__24013 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__24016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl4043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__34074 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__34077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44136 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54196 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4226 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64257 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74319 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84381 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94441 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104503 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04646 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14708 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24768 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4798 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04896 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl4985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__05019 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__05022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl5050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__15081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05142 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15204 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25264 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35325 = new BitSet(new long[]{0x00000000803FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45387 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55448 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65510 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75572 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85632 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95694 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05835 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15897 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25957 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl5987 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__36018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl6046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__06085 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__06088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06208 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6295 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06330 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06453 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16515 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26575 = new BitSet(new long[]{0x0000000002240000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36637 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6667 = new BitSet(new long[]{0x0000000000240002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06767 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16827 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26889 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl6976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__07015 = new BitSet(new long[]{0x0000000000C00810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__07018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl7046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__17077 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__17080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07202 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07324 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07447 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17509 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27569 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37631 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47691 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57753 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07886 = new BitSet(new long[]{0x0000002008000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17946 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl7976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__28007 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__28010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl8038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__38069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08134 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18196 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28256 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8286 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08384 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08507 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08629 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18691 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8778 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08815 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08938 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl8969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__19000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl9027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__09061 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__09064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl9091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09183 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19245 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29305 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9335 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09433 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09556 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19617 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09743 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09866 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_19994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_210025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_410056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_010087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__IterationsAssignment_5_010312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAssignment_5_110343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_210374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110746 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_111025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_111056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_111089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred211985 = new BitSet(new long[]{0x0000000000000002L});
    }


}