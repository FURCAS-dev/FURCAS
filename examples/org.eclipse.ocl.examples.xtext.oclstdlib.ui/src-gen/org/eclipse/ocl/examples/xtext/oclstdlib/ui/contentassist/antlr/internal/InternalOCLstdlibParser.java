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
    public static final int RULE_ID=5;
    public static final int RULE_SINGLE_QUOTED_STRING=7;
    public static final int RULE_DOUBLE_QUOTED_STRING=6;
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:780:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__OperationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 ) ) );
    public final void rule__LibClassCS__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:784:1: ( ( ( rule__LibClassCS__OperationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15||LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("780:1: rule__LibClassCS__Alternatives_5 : ( ( ( rule__LibClassCS__OperationsAssignment_5_0 ) ) | ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 ) ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:785:1: ( ( rule__LibClassCS__OperationsAssignment_5_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:785:1: ( ( rule__LibClassCS__OperationsAssignment_5_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:786:1: ( rule__LibClassCS__OperationsAssignment_5_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:787:1: ( rule__LibClassCS__OperationsAssignment_5_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:787:2: rule__LibClassCS__OperationsAssignment_5_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__OperationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51639);
                    rule__LibClassCS__OperationsAssignment_5_0();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getOperationsAssignment_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:791:6: ( ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:792:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:1: ( rule__LibClassCS__StructuralFeaturesAssignment_5_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:793:2: rule__LibClassCS__StructuralFeaturesAssignment_5_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_1_in_rule__LibClassCS__Alternatives_51657);
                    rule__LibClassCS__StructuralFeaturesAssignment_5_1();
                    _fsp--;
                    if (failed) return ;

                    }

                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getStructuralFeaturesAssignment_5_1()); 
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


    // $ANTLR start rule__LibClassCS__OperationsAlternatives_5_0_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:802:1: rule__LibClassCS__OperationsAlternatives_5_0_0 : ( ( ruleLibIterationCS ) | ( ruleLibOperationCS ) );
    public final void rule__LibClassCS__OperationsAlternatives_5_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:806:1: ( ( ruleLibIterationCS ) | ( ruleLibOperationCS ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("802:1: rule__LibClassCS__OperationsAlternatives_5_0_0 : ( ( ruleLibIterationCS ) | ( ruleLibOperationCS ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:807:1: ( ruleLibIterationCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:807:1: ( ruleLibIterationCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:808:1: ruleLibIterationCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsLibIterationCSParserRuleCall_5_0_0_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__OperationsAlternatives_5_0_01690);
                    ruleLibIterationCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getOperationsLibIterationCSParserRuleCall_5_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:6: ( ruleLibOperationCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:813:6: ( ruleLibOperationCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:814:1: ruleLibOperationCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_0_0_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAlternatives_5_0_01707);
                    ruleLibOperationCS();
                    _fsp--;
                    if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibClassCSAccess().getOperationsLibOperationCSParserRuleCall_5_0_0_1()); 
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
    // $ANTLR end rule__LibClassCS__OperationsAlternatives_5_0_0


    // $ANTLR start rule__LibPackageCS__Alternatives_3
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:824:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__LibPackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:828:1: ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("824:1: rule__LibPackageCS__Alternatives_3 : ( ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) ) | ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:829:1: ( ( rule__LibPackageCS__SubpackagesAssignment_3_0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:830:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getSubpackagesAssignment_3_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:831:1: ( rule__LibPackageCS__SubpackagesAssignment_3_0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:831:2: rule__LibPackageCS__SubpackagesAssignment_3_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31739);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:835:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:835:6: ( ( rule__LibPackageCS__ClassifiersAssignment_3_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:836:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:837:1: ( rule__LibPackageCS__ClassifiersAssignment_3_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:837:2: rule__LibPackageCS__ClassifiersAssignment_3_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31757);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:846:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );
    public final void rule__LibParameterCS__Alternatives_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:850:1: ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            else if ( (LA8_0==11||(LA8_0>=22 && LA8_0<=23)) ) {
                alt8=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("846:1: rule__LibParameterCS__Alternatives_3_1 : ( ( ( rule__LibParameterCS__Group_3_1_0__0 ) ) | ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) ) );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:851:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:851:1: ( ( rule__LibParameterCS__Group_3_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:852:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:853:1: ( rule__LibParameterCS__Group_3_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:853:2: rule__LibParameterCS__Group_3_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11790);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:857:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:857:6: ( ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:858:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAssignment_3_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:859:1: ( rule__LibParameterCS__MultiplicityAssignment_3_1_1 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:859:2: rule__LibParameterCS__MultiplicityAssignment_3_1_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11808);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:868:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );
    public final void rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:872:1: ( ( '*' ) | ( '+' ) | ( '?' ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case 23:
                {
                alt9=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("868:1: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 : ( ( '*' ) | ( '+' ) | ( '?' ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:873:1: ( '*' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:873:1: ( '*' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:874:1: '*'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01842); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityAsteriskKeyword_3_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:881:6: ( '+' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:881:6: ( '+' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:882:1: '+'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01862); if (failed) return ;
                    if ( backtracking==0 ) {
                       after(grammarAccess.getLibParameterCSAccess().getMultiplicityPlusSignKeyword_3_1_1_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:889:6: ( '?' )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:889:6: ( '?' )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:890:1: '?'
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibParameterCSAccess().getMultiplicityQuestionMarkKeyword_3_1_1_0_2()); 
                    }
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01882); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:902:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );
    public final void rule__LibTypeParameterCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:906:1: ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==13) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("902:1: rule__LibTypeParameterCS__Alternatives_1 : ( ( ( rule__LibTypeParameterCS__Group_1_0__0 ) ) | ( ( rule__LibTypeParameterCS__Group_1_1__0 ) ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:907:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:907:1: ( ( rule__LibTypeParameterCS__Group_1_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:908:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:909:1: ( rule__LibTypeParameterCS__Group_1_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:909:2: rule__LibTypeParameterCS__Group_1_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11916);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:913:6: ( ( rule__LibTypeParameterCS__Group_1_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:914:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:915:1: ( rule__LibTypeParameterCS__Group_1_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:915:2: rule__LibTypeParameterCS__Group_1_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11934);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:924:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );
    public final void rule__LibTypeRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:928:1: ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||(LA11_0>=12 && LA11_0<=21)) ) {
                alt11=1;
            }
            else if ( (LA11_0==23) ) {
                alt11=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("924:1: rule__LibTypeRefCS__Alternatives : ( ( ruleLibTypedRefCS ) | ( ruleLibWildcardTypeRefCS ) );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:929:1: ( ruleLibTypedRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:929:1: ( ruleLibTypedRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:930:1: ruleLibTypedRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibTypedRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1967);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:6: ( ruleLibWildcardTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:935:6: ( ruleLibWildcardTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:936:1: ruleLibWildcardTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypeRefCSAccess().getLibWildcardTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1984);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );
    public final void rule__LibTypedRefCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:950:1: ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) )
            int alt12=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case 12:
                {
                int LA12_2 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case 13:
                {
                int LA12_3 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 3, input);

                    throw nvae;
                }
                }
                break;
            case 14:
                {
                int LA12_4 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 4, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                int LA12_5 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 5, input);

                    throw nvae;
                }
                }
                break;
            case 16:
                {
                int LA12_6 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 6, input);

                    throw nvae;
                }
                }
                break;
            case 17:
                {
                int LA12_7 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 7, input);

                    throw nvae;
                }
                }
                break;
            case 18:
                {
                int LA12_8 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 8, input);

                    throw nvae;
                }
                }
                break;
            case 19:
                {
                int LA12_9 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 9, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA12_10 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 10, input);

                    throw nvae;
                }
                }
                break;
            case 21:
                {
                int LA12_11 = input.LA(2);

                if ( (synpred21()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (backtracking>0) {failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 11, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("946:1: rule__LibTypedRefCS__Alternatives : ( ( ruleLibQualifiedTypeRefCS ) | ( ruleLibTypedTypeRefCS ) );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ruleLibQualifiedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ruleLibQualifiedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:952:1: ruleLibQualifiedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2016);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:957:6: ( ruleLibTypedTypeRefCS )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:957:6: ( ruleLibTypedTypeRefCS )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:958:1: ruleLibTypedTypeRefCS
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibTypedRefCSAccess().getLibTypedTypeRefCSParserRuleCall_1()); 
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2033);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:968:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );
    public final void rule__LibWildcardTypeRefCS__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:972:1: ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
                alt13=2;
            }
            else {
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("968:1: rule__LibWildcardTypeRefCS__Alternatives_2 : ( ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) ) | ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) ) );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:973:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:973:1: ( ( rule__LibWildcardTypeRefCS__Group_2_0__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:974:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_0()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:975:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:975:2: rule__LibWildcardTypeRefCS__Group_2_0__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_22065);
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
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:979:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    {
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:979:6: ( ( rule__LibWildcardTypeRefCS__Group_2_1__0 ) )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:980:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    {
                    if ( backtracking==0 ) {
                       before(grammarAccess.getLibWildcardTypeRefCSAccess().getGroup_2_1()); 
                    }
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:981:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0 )
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:981:2: rule__LibWildcardTypeRefCS__Group_2_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_22083);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:992:1: rule__Library__Group__0 : rule__Library__Group__0__Impl rule__Library__Group__1 ;
    public final void rule__Library__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:996:1: ( rule__Library__Group__0__Impl rule__Library__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:997:2: rule__Library__Group__0__Impl rule__Library__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__02114);
            rule__Library__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02117);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1004:1: rule__Library__Group__0__Impl : ( 'library' ) ;
    public final void rule__Library__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1008:1: ( ( 'library' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1009:1: ( 'library' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1009:1: ( 'library' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1010:1: 'library'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLibraryKeyword_0()); 
            }
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Library__Group__0__Impl2145); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1023:1: rule__Library__Group__1 : rule__Library__Group__1__Impl rule__Library__Group__2 ;
    public final void rule__Library__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1027:1: ( rule__Library__Group__1__Impl rule__Library__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1028:2: rule__Library__Group__1__Impl rule__Library__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12176);
            rule__Library__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12179);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1035:1: rule__Library__Group__1__Impl : ( ( rule__Library__NameAssignment_1 ) ) ;
    public final void rule__Library__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1039:1: ( ( ( rule__Library__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1040:1: ( ( rule__Library__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1040:1: ( ( rule__Library__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1041:1: ( rule__Library__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1042:1: ( rule__Library__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1042:2: rule__Library__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2206);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1052:1: rule__Library__Group__2 : rule__Library__Group__2__Impl rule__Library__Group__3 ;
    public final void rule__Library__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1056:1: ( rule__Library__Group__2__Impl rule__Library__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1057:2: rule__Library__Group__2__Impl rule__Library__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22236);
            rule__Library__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22239);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1064:1: rule__Library__Group__2__Impl : ( ( rule__Library__ImportsAssignment_2 )* ) ;
    public final void rule__Library__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1068:1: ( ( ( rule__Library__ImportsAssignment_2 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1069:1: ( ( rule__Library__ImportsAssignment_2 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1069:1: ( ( rule__Library__ImportsAssignment_2 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1070:1: ( rule__Library__ImportsAssignment_2 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1071:1: ( rule__Library__ImportsAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==14) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1071:2: rule__Library__ImportsAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2266);
            	    rule__Library__ImportsAssignment_2();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1081:1: rule__Library__Group__3 : rule__Library__Group__3__Impl rule__Library__Group__4 ;
    public final void rule__Library__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1085:1: ( rule__Library__Group__3__Impl rule__Library__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1086:2: rule__Library__Group__3__Impl rule__Library__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32297);
            rule__Library__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32300);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1093:1: rule__Library__Group__3__Impl : ( '{' ) ;
    public final void rule__Library__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1097:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1098:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1098:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1099:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Library__Group__3__Impl2328); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1112:1: rule__Library__Group__4 : rule__Library__Group__4__Impl rule__Library__Group__5 ;
    public final void rule__Library__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1116:1: ( rule__Library__Group__4__Impl rule__Library__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1117:2: rule__Library__Group__4__Impl rule__Library__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42359);
            rule__Library__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42362);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1124:1: rule__Library__Group__4__Impl : ( ( rule__Library__PackagesAssignment_4 )* ) ;
    public final void rule__Library__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1128:1: ( ( ( rule__Library__PackagesAssignment_4 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1129:1: ( ( rule__Library__PackagesAssignment_4 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1129:1: ( ( rule__Library__PackagesAssignment_4 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1130:1: ( rule__Library__PackagesAssignment_4 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1131:1: ( rule__Library__PackagesAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==18) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1131:2: rule__Library__PackagesAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2389);
            	    rule__Library__PackagesAssignment_4();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1141:1: rule__Library__Group__5 : rule__Library__Group__5__Impl ;
    public final void rule__Library__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1145:1: ( rule__Library__Group__5__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1146:2: rule__Library__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52420);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1152:1: rule__Library__Group__5__Impl : ( '}' ) ;
    public final void rule__Library__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1156:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1157:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1157:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1158:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Library__Group__5__Impl2448); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1183:1: rule__LibImportCS__Group__0 : rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 ;
    public final void rule__LibImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1187:1: ( rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1188:2: rule__LibImportCS__Group__0__Impl rule__LibImportCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02491);
            rule__LibImportCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02494);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1195:1: rule__LibImportCS__Group__0__Impl : ( 'import' ) ;
    public final void rule__LibImportCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1199:1: ( ( 'import' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1200:1: ( 'import' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1200:1: ( 'import' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1201:1: 'import'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getImportKeyword_0()); 
            }
            match(input,14,FollowSets000.FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2522); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1214:1: rule__LibImportCS__Group__1 : rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 ;
    public final void rule__LibImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1218:1: ( rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1219:2: rule__LibImportCS__Group__1__Impl rule__LibImportCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12553);
            rule__LibImportCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12556);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1226:1: rule__LibImportCS__Group__1__Impl : ( ( rule__LibImportCS__Group_1__0 )? ) ;
    public final void rule__LibImportCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1230:1: ( ( ( rule__LibImportCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1231:1: ( ( rule__LibImportCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1231:1: ( ( rule__LibImportCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1232:1: ( rule__LibImportCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1233:1: ( rule__LibImportCS__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||(LA16_0>=12 && LA16_0<=21)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1233:2: rule__LibImportCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2583);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1243:1: rule__LibImportCS__Group__2 : rule__LibImportCS__Group__2__Impl ;
    public final void rule__LibImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1247:1: ( rule__LibImportCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1248:2: rule__LibImportCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22614);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1254:1: rule__LibImportCS__Group__2__Impl : ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) ;
    public final void rule__LibImportCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1258:1: ( ( ( rule__LibImportCS__NamespaceAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1259:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1259:1: ( ( rule__LibImportCS__NamespaceAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1260:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1261:1: ( rule__LibImportCS__NamespaceAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1261:2: rule__LibImportCS__NamespaceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2641);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1277:1: rule__LibImportCS__Group_1__0 : rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 ;
    public final void rule__LibImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1281:1: ( rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1282:2: rule__LibImportCS__Group_1__0__Impl rule__LibImportCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02677);
            rule__LibImportCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02680);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1289:1: rule__LibImportCS__Group_1__0__Impl : ( ( rule__LibImportCS__NameAssignment_1_0 ) ) ;
    public final void rule__LibImportCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1293:1: ( ( ( rule__LibImportCS__NameAssignment_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1294:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1294:1: ( ( rule__LibImportCS__NameAssignment_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1295:1: ( rule__LibImportCS__NameAssignment_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameAssignment_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1296:1: ( rule__LibImportCS__NameAssignment_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1296:2: rule__LibImportCS__NameAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2707);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1306:1: rule__LibImportCS__Group_1__1 : rule__LibImportCS__Group_1__1__Impl ;
    public final void rule__LibImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1310:1: ( rule__LibImportCS__Group_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1311:2: rule__LibImportCS__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12737);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1317:1: rule__LibImportCS__Group_1__1__Impl : ( ':' ) ;
    public final void rule__LibImportCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1321:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1322:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1322:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1323:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2765); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1340:1: rule__LibClassCS__Group__0 : rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 ;
    public final void rule__LibClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1344:1: ( rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1345:2: rule__LibClassCS__Group__0__Impl rule__LibClassCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02800);
            rule__LibClassCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02803);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1352:1: rule__LibClassCS__Group__0__Impl : ( 'type' ) ;
    public final void rule__LibClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1356:1: ( ( 'type' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1357:1: ( 'type' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1357:1: ( 'type' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1358:1: 'type'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeKeyword_0()); 
            }
            match(input,21,FollowSets000.FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2831); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1371:1: rule__LibClassCS__Group__1 : rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 ;
    public final void rule__LibClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1375:1: ( rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1376:2: rule__LibClassCS__Group__1__Impl rule__LibClassCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12862);
            rule__LibClassCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12865);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1383:1: rule__LibClassCS__Group__1__Impl : ( ( rule__LibClassCS__NameAssignment_1 ) ) ;
    public final void rule__LibClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1387:1: ( ( ( rule__LibClassCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1388:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1388:1: ( ( rule__LibClassCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1389:1: ( rule__LibClassCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1390:1: ( rule__LibClassCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1390:2: rule__LibClassCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2892);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1400:1: rule__LibClassCS__Group__2 : rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 ;
    public final void rule__LibClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1404:1: ( rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1405:2: rule__LibClassCS__Group__2__Impl rule__LibClassCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22922);
            rule__LibClassCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22925);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1412:1: rule__LibClassCS__Group__2__Impl : ( ( rule__LibClassCS__Group_2__0 )? ) ;
    public final void rule__LibClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1416:1: ( ( ( rule__LibClassCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1417:1: ( ( rule__LibClassCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1417:1: ( ( rule__LibClassCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1418:1: ( rule__LibClassCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1419:1: ( rule__LibClassCS__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1419:2: rule__LibClassCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2952);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1429:1: rule__LibClassCS__Group__3 : rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 ;
    public final void rule__LibClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1433:1: ( rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1434:2: rule__LibClassCS__Group__3__Impl rule__LibClassCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32983);
            rule__LibClassCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32986);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1441:1: rule__LibClassCS__Group__3__Impl : ( ( rule__LibClassCS__Group_3__0 )? ) ;
    public final void rule__LibClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1445:1: ( ( ( rule__LibClassCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1446:1: ( ( rule__LibClassCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1446:1: ( ( rule__LibClassCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1447:1: ( rule__LibClassCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1448:1: ( rule__LibClassCS__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==12) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1448:2: rule__LibClassCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl3013);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1458:1: rule__LibClassCS__Group__4 : rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 ;
    public final void rule__LibClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1462:1: ( rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1463:2: rule__LibClassCS__Group__4__Impl rule__LibClassCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__43044);
            rule__LibClassCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__43047);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1470:1: rule__LibClassCS__Group__4__Impl : ( '{' ) ;
    public final void rule__LibClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1474:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1475:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1475:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1476:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibClassCS__Group__4__Impl3075); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1489:1: rule__LibClassCS__Group__5 : rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 ;
    public final void rule__LibClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1493:1: ( rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1494:2: rule__LibClassCS__Group__5__Impl rule__LibClassCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__53106);
            rule__LibClassCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__53109);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1501:1: rule__LibClassCS__Group__5__Impl : ( ( rule__LibClassCS__Alternatives_5 )* ) ;
    public final void rule__LibClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1505:1: ( ( ( rule__LibClassCS__Alternatives_5 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1506:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1506:1: ( ( rule__LibClassCS__Alternatives_5 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1507:1: ( rule__LibClassCS__Alternatives_5 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getAlternatives_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1508:1: ( rule__LibClassCS__Alternatives_5 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==15||LA19_0==17||LA19_0==19) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1508:2: rule__LibClassCS__Alternatives_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3136);
            	    rule__LibClassCS__Alternatives_5();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1518:1: rule__LibClassCS__Group__6 : rule__LibClassCS__Group__6__Impl ;
    public final void rule__LibClassCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1522:1: ( rule__LibClassCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1523:2: rule__LibClassCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63167);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1529:1: rule__LibClassCS__Group__6__Impl : ( '}' ) ;
    public final void rule__LibClassCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1533:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1534:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1535:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3195); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1562:1: rule__LibClassCS__Group_2__0 : rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 ;
    public final void rule__LibClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1566:1: ( rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1567:2: rule__LibClassCS__Group_2__0__Impl rule__LibClassCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03240);
            rule__LibClassCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03243);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1574:1: rule__LibClassCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1578:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1579:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1579:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1580:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3271); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1593:1: rule__LibClassCS__Group_2__1 : rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 ;
    public final void rule__LibClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1597:1: ( rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1598:2: rule__LibClassCS__Group_2__1__Impl rule__LibClassCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13302);
            rule__LibClassCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13305);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1605:1: rule__LibClassCS__Group_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1609:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1610:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1610:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1611:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1612:1: ( rule__LibClassCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1612:2: rule__LibClassCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3332);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1622:1: rule__LibClassCS__Group_2__2 : rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 ;
    public final void rule__LibClassCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1626:1: ( rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1627:2: rule__LibClassCS__Group_2__2__Impl rule__LibClassCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23362);
            rule__LibClassCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23365);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1634:1: rule__LibClassCS__Group_2__2__Impl : ( ( rule__LibClassCS__Group_2_2__0 )* ) ;
    public final void rule__LibClassCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1638:1: ( ( ( rule__LibClassCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1639:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1639:1: ( ( rule__LibClassCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1640:1: ( rule__LibClassCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1641:1: ( rule__LibClassCS__Group_2_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1641:2: rule__LibClassCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3392);
            	    rule__LibClassCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1651:1: rule__LibClassCS__Group_2__3 : rule__LibClassCS__Group_2__3__Impl ;
    public final void rule__LibClassCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1655:1: ( rule__LibClassCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1656:2: rule__LibClassCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33423);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1662:1: rule__LibClassCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibClassCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1666:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1667:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1667:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1668:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3451); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1689:1: rule__LibClassCS__Group_2_2__0 : rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 ;
    public final void rule__LibClassCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1693:1: ( rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1694:2: rule__LibClassCS__Group_2_2__0__Impl rule__LibClassCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03490);
            rule__LibClassCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03493);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1701:1: rule__LibClassCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1705:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1706:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1706:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1707:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3521); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1720:1: rule__LibClassCS__Group_2_2__1 : rule__LibClassCS__Group_2_2__1__Impl ;
    public final void rule__LibClassCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1724:1: ( rule__LibClassCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1725:2: rule__LibClassCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13552);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1731:1: rule__LibClassCS__Group_2_2__1__Impl : ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibClassCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1735:1: ( ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1736:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1736:1: ( ( rule__LibClassCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1737:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1738:1: ( rule__LibClassCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1738:2: rule__LibClassCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3579);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1752:1: rule__LibClassCS__Group_3__0 : rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 ;
    public final void rule__LibClassCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1756:1: ( rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1757:2: rule__LibClassCS__Group_3__0__Impl rule__LibClassCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03613);
            rule__LibClassCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03616);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1764:1: rule__LibClassCS__Group_3__0__Impl : ( 'conformsTo' ) ;
    public final void rule__LibClassCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1768:1: ( ( 'conformsTo' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1769:1: ( 'conformsTo' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1769:1: ( 'conformsTo' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1770:1: 'conformsTo'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToKeyword_3_0()); 
            }
            match(input,12,FollowSets000.FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3644); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1783:1: rule__LibClassCS__Group_3__1 : rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 ;
    public final void rule__LibClassCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1787:1: ( rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1788:2: rule__LibClassCS__Group_3__1__Impl rule__LibClassCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13675);
            rule__LibClassCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13678);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1795:1: rule__LibClassCS__Group_3__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) ;
    public final void rule__LibClassCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1799:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1800:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1800:1: ( ( rule__LibClassCS__ConformsToAssignment_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1801:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1802:1: ( rule__LibClassCS__ConformsToAssignment_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1802:2: rule__LibClassCS__ConformsToAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3705);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1812:1: rule__LibClassCS__Group_3__2 : rule__LibClassCS__Group_3__2__Impl ;
    public final void rule__LibClassCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1816:1: ( rule__LibClassCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1817:2: rule__LibClassCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23735);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1823:1: rule__LibClassCS__Group_3__2__Impl : ( ( rule__LibClassCS__Group_3_2__0 )* ) ;
    public final void rule__LibClassCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1827:1: ( ( ( rule__LibClassCS__Group_3_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1828:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1828:1: ( ( rule__LibClassCS__Group_3_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1829:1: ( rule__LibClassCS__Group_3_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getGroup_3_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1830:1: ( rule__LibClassCS__Group_3_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==29) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1830:2: rule__LibClassCS__Group_3_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3762);
            	    rule__LibClassCS__Group_3_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1846:1: rule__LibClassCS__Group_3_2__0 : rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 ;
    public final void rule__LibClassCS__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1850:1: ( rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1851:2: rule__LibClassCS__Group_3_2__0__Impl rule__LibClassCS__Group_3_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03799);
            rule__LibClassCS__Group_3_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03802);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1858:1: rule__LibClassCS__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__LibClassCS__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1862:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1863:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1863:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1864:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getCommaKeyword_3_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3830); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1877:1: rule__LibClassCS__Group_3_2__1 : rule__LibClassCS__Group_3_2__1__Impl ;
    public final void rule__LibClassCS__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1881:1: ( rule__LibClassCS__Group_3_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1882:2: rule__LibClassCS__Group_3_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13861);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1888:1: rule__LibClassCS__Group_3_2__1__Impl : ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) ;
    public final void rule__LibClassCS__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1892:1: ( ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1893:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1893:1: ( ( rule__LibClassCS__ConformsToAssignment_3_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1894:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToAssignment_3_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1895:1: ( rule__LibClassCS__ConformsToAssignment_3_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1895:2: rule__LibClassCS__ConformsToAssignment_3_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3888);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1909:1: rule__LibIterationCS__Group__0 : rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 ;
    public final void rule__LibIterationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1913:1: ( rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1914:2: rule__LibIterationCS__Group__0__Impl rule__LibIterationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03922);
            rule__LibIterationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03925);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1921:1: rule__LibIterationCS__Group__0__Impl : ( 'iteration' ) ;
    public final void rule__LibIterationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1925:1: ( ( 'iteration' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1926:1: ( 'iteration' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1926:1: ( 'iteration' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1927:1: 'iteration'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getIterationKeyword_0()); 
            }
            match(input,15,FollowSets000.FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3953); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1940:1: rule__LibIterationCS__Group__1 : rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 ;
    public final void rule__LibIterationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1944:1: ( rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1945:2: rule__LibIterationCS__Group__1__Impl rule__LibIterationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13984);
            rule__LibIterationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13987);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1952:1: rule__LibIterationCS__Group__1__Impl : ( ( rule__LibIterationCS__NameAssignment_1 ) ) ;
    public final void rule__LibIterationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1956:1: ( ( ( rule__LibIterationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1957:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1957:1: ( ( rule__LibIterationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1958:1: ( rule__LibIterationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1959:1: ( rule__LibIterationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1959:2: rule__LibIterationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl4014);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1969:1: rule__LibIterationCS__Group__2 : rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 ;
    public final void rule__LibIterationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1973:1: ( rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1974:2: rule__LibIterationCS__Group__2__Impl rule__LibIterationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__24044);
            rule__LibIterationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__24047);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1981:1: rule__LibIterationCS__Group__2__Impl : ( ( rule__LibIterationCS__Group_2__0 )? ) ;
    public final void rule__LibIterationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1985:1: ( ( ( rule__LibIterationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1986:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1986:1: ( ( rule__LibIterationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1987:1: ( rule__LibIterationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:1: ( rule__LibIterationCS__Group_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==27) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1988:2: rule__LibIterationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl4074);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:1998:1: rule__LibIterationCS__Group__3 : rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 ;
    public final void rule__LibIterationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2002:1: ( rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2003:2: rule__LibIterationCS__Group__3__Impl rule__LibIterationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__34105);
            rule__LibIterationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__34108);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2010:1: rule__LibIterationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibIterationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2014:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2015:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2015:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2016:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4136); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2029:1: rule__LibIterationCS__Group__4 : rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 ;
    public final void rule__LibIterationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2033:1: ( rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2034:2: rule__LibIterationCS__Group__4__Impl rule__LibIterationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44167);
            rule__LibIterationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44170);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2041:1: rule__LibIterationCS__Group__4__Impl : ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) ;
    public final void rule__LibIterationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2045:1: ( ( ( rule__LibIterationCS__ParametersAssignment_4 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2046:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2046:1: ( ( rule__LibIterationCS__ParametersAssignment_4 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2047:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2048:1: ( rule__LibIterationCS__ParametersAssignment_4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2048:2: rule__LibIterationCS__ParametersAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4197);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2058:1: rule__LibIterationCS__Group__5 : rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 ;
    public final void rule__LibIterationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2062:1: ( rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2063:2: rule__LibIterationCS__Group__5__Impl rule__LibIterationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54227);
            rule__LibIterationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54230);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2070:1: rule__LibIterationCS__Group__5__Impl : ( ( rule__LibIterationCS__Group_5__0 )* ) ;
    public final void rule__LibIterationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2074:1: ( ( ( rule__LibIterationCS__Group_5__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2075:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2075:1: ( ( rule__LibIterationCS__Group_5__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2076:1: ( rule__LibIterationCS__Group_5__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2077:1: ( rule__LibIterationCS__Group_5__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2077:2: rule__LibIterationCS__Group_5__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4257);
            	    rule__LibIterationCS__Group_5__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2087:1: rule__LibIterationCS__Group__6 : rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 ;
    public final void rule__LibIterationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2091:1: ( rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2092:2: rule__LibIterationCS__Group__6__Impl rule__LibIterationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64288);
            rule__LibIterationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64291);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2099:1: rule__LibIterationCS__Group__6__Impl : ( ')' ) ;
    public final void rule__LibIterationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2103:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2104:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2104:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2105:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4319); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2118:1: rule__LibIterationCS__Group__7 : rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 ;
    public final void rule__LibIterationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2122:1: ( rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2123:2: rule__LibIterationCS__Group__7__Impl rule__LibIterationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74350);
            rule__LibIterationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74353);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2130:1: rule__LibIterationCS__Group__7__Impl : ( ':' ) ;
    public final void rule__LibIterationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2134:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2135:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2135:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2136:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getColonKeyword_7()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4381); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2149:1: rule__LibIterationCS__Group__8 : rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 ;
    public final void rule__LibIterationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2153:1: ( rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2154:2: rule__LibIterationCS__Group__8__Impl rule__LibIterationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84412);
            rule__LibIterationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84415);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2161:1: rule__LibIterationCS__Group__8__Impl : ( ( rule__LibIterationCS__TypeAssignment_8 ) ) ;
    public final void rule__LibIterationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2165:1: ( ( ( rule__LibIterationCS__TypeAssignment_8 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2166:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2166:1: ( ( rule__LibIterationCS__TypeAssignment_8 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2167:1: ( rule__LibIterationCS__TypeAssignment_8 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeAssignment_8()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2168:1: ( rule__LibIterationCS__TypeAssignment_8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2168:2: rule__LibIterationCS__TypeAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4442);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2178:1: rule__LibIterationCS__Group__9 : rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 ;
    public final void rule__LibIterationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2182:1: ( rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2183:2: rule__LibIterationCS__Group__9__Impl rule__LibIterationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94472);
            rule__LibIterationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94475);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2190:1: rule__LibIterationCS__Group__9__Impl : ( '=>' ) ;
    public final void rule__LibIterationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2194:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2195:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2195:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2196:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getEqualsSignGreaterThanSignKeyword_9()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4503); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2209:1: rule__LibIterationCS__Group__10 : rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 ;
    public final void rule__LibIterationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2213:1: ( rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2214:2: rule__LibIterationCS__Group__10__Impl rule__LibIterationCS__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104534);
            rule__LibIterationCS__Group__10__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104537);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2221:1: rule__LibIterationCS__Group__10__Impl : ( ( rule__LibIterationCS__ClassAssignment_10 ) ) ;
    public final void rule__LibIterationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2225:1: ( ( ( rule__LibIterationCS__ClassAssignment_10 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2226:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2226:1: ( ( rule__LibIterationCS__ClassAssignment_10 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2227:1: ( rule__LibIterationCS__ClassAssignment_10 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassAssignment_10()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2228:1: ( rule__LibIterationCS__ClassAssignment_10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2228:2: rule__LibIterationCS__ClassAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4564);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2238:1: rule__LibIterationCS__Group__11 : rule__LibIterationCS__Group__11__Impl ;
    public final void rule__LibIterationCS__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2242:1: ( rule__LibIterationCS__Group__11__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2243:2: rule__LibIterationCS__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114594);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2249:1: rule__LibIterationCS__Group__11__Impl : ( ';' ) ;
    public final void rule__LibIterationCS__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2253:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2254:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2254:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2255:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getSemicolonKeyword_11()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4622); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2292:1: rule__LibIterationCS__Group_2__0 : rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 ;
    public final void rule__LibIterationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2296:1: ( rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2297:2: rule__LibIterationCS__Group_2__0__Impl rule__LibIterationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04677);
            rule__LibIterationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04680);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2304:1: rule__LibIterationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibIterationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2308:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2309:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2309:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2310:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4708); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2323:1: rule__LibIterationCS__Group_2__1 : rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 ;
    public final void rule__LibIterationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2327:1: ( rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2328:2: rule__LibIterationCS__Group_2__1__Impl rule__LibIterationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14739);
            rule__LibIterationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14742);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2335:1: rule__LibIterationCS__Group_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2339:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2340:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2340:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2341:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2342:1: ( rule__LibIterationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2342:2: rule__LibIterationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4769);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2352:1: rule__LibIterationCS__Group_2__2 : rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 ;
    public final void rule__LibIterationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2356:1: ( rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2357:2: rule__LibIterationCS__Group_2__2__Impl rule__LibIterationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24799);
            rule__LibIterationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24802);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2364:1: rule__LibIterationCS__Group_2__2__Impl : ( ( rule__LibIterationCS__Group_2_2__0 )* ) ;
    public final void rule__LibIterationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2368:1: ( ( ( rule__LibIterationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2369:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2369:1: ( ( rule__LibIterationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2370:1: ( rule__LibIterationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2371:1: ( rule__LibIterationCS__Group_2_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==29) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2371:2: rule__LibIterationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4829);
            	    rule__LibIterationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2381:1: rule__LibIterationCS__Group_2__3 : rule__LibIterationCS__Group_2__3__Impl ;
    public final void rule__LibIterationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2385:1: ( rule__LibIterationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2386:2: rule__LibIterationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34860);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2392:1: rule__LibIterationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibIterationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2396:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2397:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2397:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2398:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4888); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2419:1: rule__LibIterationCS__Group_2_2__0 : rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 ;
    public final void rule__LibIterationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2423:1: ( rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2424:2: rule__LibIterationCS__Group_2_2__0__Impl rule__LibIterationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04927);
            rule__LibIterationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04930);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2431:1: rule__LibIterationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2435:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2436:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2436:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2437:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4958); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2450:1: rule__LibIterationCS__Group_2_2__1 : rule__LibIterationCS__Group_2_2__1__Impl ;
    public final void rule__LibIterationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2454:1: ( rule__LibIterationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2455:2: rule__LibIterationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14989);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2461:1: rule__LibIterationCS__Group_2_2__1__Impl : ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibIterationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2465:1: ( ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2466:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2466:1: ( ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2467:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2468:1: ( rule__LibIterationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2468:2: rule__LibIterationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl5016);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2482:1: rule__LibIterationCS__Group_5__0 : rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 ;
    public final void rule__LibIterationCS__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2486:1: ( rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2487:2: rule__LibIterationCS__Group_5__0__Impl rule__LibIterationCS__Group_5__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__05050);
            rule__LibIterationCS__Group_5__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__05053);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2494:1: rule__LibIterationCS__Group_5__0__Impl : ( ',' ) ;
    public final void rule__LibIterationCS__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2498:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2499:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2499:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2500:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getCommaKeyword_5_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl5081); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2513:1: rule__LibIterationCS__Group_5__1 : rule__LibIterationCS__Group_5__1__Impl ;
    public final void rule__LibIterationCS__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2517:1: ( rule__LibIterationCS__Group_5__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2518:2: rule__LibIterationCS__Group_5__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__15112);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2524:1: rule__LibIterationCS__Group_5__1__Impl : ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) ;
    public final void rule__LibIterationCS__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2528:1: ( ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2529:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2529:1: ( ( rule__LibIterationCS__ParametersAssignment_5_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2530:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersAssignment_5_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2531:1: ( rule__LibIterationCS__ParametersAssignment_5_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2531:2: rule__LibIterationCS__ParametersAssignment_5_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5139);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2545:1: rule__LibOperationCS__Group__0 : rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 ;
    public final void rule__LibOperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2549:1: ( rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2550:2: rule__LibOperationCS__Group__0__Impl rule__LibOperationCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05173);
            rule__LibOperationCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05176);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2557:1: rule__LibOperationCS__Group__0__Impl : ( 'operation' ) ;
    public final void rule__LibOperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2561:1: ( ( 'operation' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2562:1: ( 'operation' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2562:1: ( 'operation' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2563:1: 'operation'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getOperationKeyword_0()); 
            }
            match(input,17,FollowSets000.FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5204); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2576:1: rule__LibOperationCS__Group__1 : rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 ;
    public final void rule__LibOperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2580:1: ( rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2581:2: rule__LibOperationCS__Group__1__Impl rule__LibOperationCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15235);
            rule__LibOperationCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15238);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2588:1: rule__LibOperationCS__Group__1__Impl : ( ( rule__LibOperationCS__NameAssignment_1 ) ) ;
    public final void rule__LibOperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2592:1: ( ( ( rule__LibOperationCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2593:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2593:1: ( ( rule__LibOperationCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2594:1: ( rule__LibOperationCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2595:1: ( rule__LibOperationCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2595:2: rule__LibOperationCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5265);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2605:1: rule__LibOperationCS__Group__2 : rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 ;
    public final void rule__LibOperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2609:1: ( rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2610:2: rule__LibOperationCS__Group__2__Impl rule__LibOperationCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25295);
            rule__LibOperationCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25298);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2617:1: rule__LibOperationCS__Group__2__Impl : ( ( rule__LibOperationCS__Group_2__0 )? ) ;
    public final void rule__LibOperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2621:1: ( ( ( rule__LibOperationCS__Group_2__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2622:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2622:1: ( ( rule__LibOperationCS__Group_2__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2623:1: ( rule__LibOperationCS__Group_2__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2624:1: ( rule__LibOperationCS__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==27) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2624:2: rule__LibOperationCS__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5325);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2634:1: rule__LibOperationCS__Group__3 : rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 ;
    public final void rule__LibOperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2638:1: ( rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2639:2: rule__LibOperationCS__Group__3__Impl rule__LibOperationCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35356);
            rule__LibOperationCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35359);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2646:1: rule__LibOperationCS__Group__3__Impl : ( '(' ) ;
    public final void rule__LibOperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2650:1: ( ( '(' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2651:1: ( '(' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2651:1: ( '(' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2652:1: '('
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLeftParenthesisKeyword_3()); 
            }
            match(input,30,FollowSets000.FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5387); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2665:1: rule__LibOperationCS__Group__4 : rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 ;
    public final void rule__LibOperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2669:1: ( rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2670:2: rule__LibOperationCS__Group__4__Impl rule__LibOperationCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45418);
            rule__LibOperationCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45421);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2677:1: rule__LibOperationCS__Group__4__Impl : ( ( rule__LibOperationCS__Group_4__0 )? ) ;
    public final void rule__LibOperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2681:1: ( ( ( rule__LibOperationCS__Group_4__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2682:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2682:1: ( ( rule__LibOperationCS__Group_4__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2683:1: ( rule__LibOperationCS__Group_4__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2684:1: ( rule__LibOperationCS__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||(LA26_0>=12 && LA26_0<=21)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2684:2: rule__LibOperationCS__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5448);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2694:1: rule__LibOperationCS__Group__5 : rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 ;
    public final void rule__LibOperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2698:1: ( rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2699:2: rule__LibOperationCS__Group__5__Impl rule__LibOperationCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55479);
            rule__LibOperationCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55482);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2706:1: rule__LibOperationCS__Group__5__Impl : ( ')' ) ;
    public final void rule__LibOperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2710:1: ( ( ')' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2711:1: ( ')' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2711:1: ( ')' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2712:1: ')'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FollowSets000.FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5510); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2725:1: rule__LibOperationCS__Group__6 : rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 ;
    public final void rule__LibOperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2729:1: ( rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2730:2: rule__LibOperationCS__Group__6__Impl rule__LibOperationCS__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65541);
            rule__LibOperationCS__Group__6__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65544);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2737:1: rule__LibOperationCS__Group__6__Impl : ( ':' ) ;
    public final void rule__LibOperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2741:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2742:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2742:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2743:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getColonKeyword_6()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5572); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2756:1: rule__LibOperationCS__Group__7 : rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 ;
    public final void rule__LibOperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2760:1: ( rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2761:2: rule__LibOperationCS__Group__7__Impl rule__LibOperationCS__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75603);
            rule__LibOperationCS__Group__7__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75606);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2768:1: rule__LibOperationCS__Group__7__Impl : ( ( rule__LibOperationCS__TypeAssignment_7 ) ) ;
    public final void rule__LibOperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2772:1: ( ( ( rule__LibOperationCS__TypeAssignment_7 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2773:1: ( ( rule__LibOperationCS__TypeAssignment_7 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2774:1: ( rule__LibOperationCS__TypeAssignment_7 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeAssignment_7()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:1: ( rule__LibOperationCS__TypeAssignment_7 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2775:2: rule__LibOperationCS__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5633);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2785:1: rule__LibOperationCS__Group__8 : rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 ;
    public final void rule__LibOperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2789:1: ( rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2790:2: rule__LibOperationCS__Group__8__Impl rule__LibOperationCS__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85663);
            rule__LibOperationCS__Group__8__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85666);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2797:1: rule__LibOperationCS__Group__8__Impl : ( '=>' ) ;
    public final void rule__LibOperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2801:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2802:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2802:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2803:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getEqualsSignGreaterThanSignKeyword_8()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5694); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2816:1: rule__LibOperationCS__Group__9 : rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 ;
    public final void rule__LibOperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2820:1: ( rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2821:2: rule__LibOperationCS__Group__9__Impl rule__LibOperationCS__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95725);
            rule__LibOperationCS__Group__9__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95728);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2828:1: rule__LibOperationCS__Group__9__Impl : ( ( rule__LibOperationCS__ClassAssignment_9 ) ) ;
    public final void rule__LibOperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2832:1: ( ( ( rule__LibOperationCS__ClassAssignment_9 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2833:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2833:1: ( ( rule__LibOperationCS__ClassAssignment_9 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2834:1: ( rule__LibOperationCS__ClassAssignment_9 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassAssignment_9()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2835:1: ( rule__LibOperationCS__ClassAssignment_9 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2835:2: rule__LibOperationCS__ClassAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5755);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2845:1: rule__LibOperationCS__Group__10 : rule__LibOperationCS__Group__10__Impl ;
    public final void rule__LibOperationCS__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2849:1: ( rule__LibOperationCS__Group__10__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2850:2: rule__LibOperationCS__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105785);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2856:1: rule__LibOperationCS__Group__10__Impl : ( ';' ) ;
    public final void rule__LibOperationCS__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2860:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2861:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2861:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2862:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getSemicolonKeyword_10()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5813); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2897:1: rule__LibOperationCS__Group_2__0 : rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 ;
    public final void rule__LibOperationCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2901:1: ( rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2902:2: rule__LibOperationCS__Group_2__0__Impl rule__LibOperationCS__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05866);
            rule__LibOperationCS__Group_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05869);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2909:1: rule__LibOperationCS__Group_2__0__Impl : ( '<' ) ;
    public final void rule__LibOperationCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2913:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2914:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2914:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2915:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getLessThanSignKeyword_2_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5897); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2928:1: rule__LibOperationCS__Group_2__1 : rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 ;
    public final void rule__LibOperationCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2932:1: ( rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2933:2: rule__LibOperationCS__Group_2__1__Impl rule__LibOperationCS__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15928);
            rule__LibOperationCS__Group_2__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15931);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2940:1: rule__LibOperationCS__Group_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2944:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2945:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2945:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2946:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2947:1: ( rule__LibOperationCS__TypeParametersAssignment_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2947:2: rule__LibOperationCS__TypeParametersAssignment_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5958);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2957:1: rule__LibOperationCS__Group_2__2 : rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 ;
    public final void rule__LibOperationCS__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2961:1: ( rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2962:2: rule__LibOperationCS__Group_2__2__Impl rule__LibOperationCS__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25988);
            rule__LibOperationCS__Group_2__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25991);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2969:1: rule__LibOperationCS__Group_2__2__Impl : ( ( rule__LibOperationCS__Group_2_2__0 )* ) ;
    public final void rule__LibOperationCS__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2973:1: ( ( ( rule__LibOperationCS__Group_2_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2974:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2974:1: ( ( rule__LibOperationCS__Group_2_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2975:1: ( rule__LibOperationCS__Group_2_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_2_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2976:1: ( rule__LibOperationCS__Group_2_2__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==29) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2976:2: rule__LibOperationCS__Group_2_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl6018);
            	    rule__LibOperationCS__Group_2_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2986:1: rule__LibOperationCS__Group_2__3 : rule__LibOperationCS__Group_2__3__Impl ;
    public final void rule__LibOperationCS__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2990:1: ( rule__LibOperationCS__Group_2__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2991:2: rule__LibOperationCS__Group_2__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__36049);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:2997:1: rule__LibOperationCS__Group_2__3__Impl : ( '>' ) ;
    public final void rule__LibOperationCS__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3001:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3002:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3002:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3003:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGreaterThanSignKeyword_2_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl6077); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3024:1: rule__LibOperationCS__Group_2_2__0 : rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 ;
    public final void rule__LibOperationCS__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3028:1: ( rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3029:2: rule__LibOperationCS__Group_2_2__0__Impl rule__LibOperationCS__Group_2_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__06116);
            rule__LibOperationCS__Group_2_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__06119);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3036:1: rule__LibOperationCS__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3040:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3041:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3041:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3042:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_2_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6147); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3055:1: rule__LibOperationCS__Group_2_2__1 : rule__LibOperationCS__Group_2_2__1__Impl ;
    public final void rule__LibOperationCS__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3059:1: ( rule__LibOperationCS__Group_2_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3060:2: rule__LibOperationCS__Group_2_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16178);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3066:1: rule__LibOperationCS__Group_2_2__1__Impl : ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) ;
    public final void rule__LibOperationCS__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3070:1: ( ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3071:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3071:1: ( ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3072:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersAssignment_2_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3073:1: ( rule__LibOperationCS__TypeParametersAssignment_2_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3073:2: rule__LibOperationCS__TypeParametersAssignment_2_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6205);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3087:1: rule__LibOperationCS__Group_4__0 : rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 ;
    public final void rule__LibOperationCS__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3091:1: ( rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3092:2: rule__LibOperationCS__Group_4__0__Impl rule__LibOperationCS__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06239);
            rule__LibOperationCS__Group_4__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06242);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3099:1: rule__LibOperationCS__Group_4__0__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) ;
    public final void rule__LibOperationCS__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3103:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3104:1: ( ( rule__LibOperationCS__ParametersAssignment_4_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3105:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3106:1: ( rule__LibOperationCS__ParametersAssignment_4_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3106:2: rule__LibOperationCS__ParametersAssignment_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6269);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3116:1: rule__LibOperationCS__Group_4__1 : rule__LibOperationCS__Group_4__1__Impl ;
    public final void rule__LibOperationCS__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3120:1: ( rule__LibOperationCS__Group_4__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3121:2: rule__LibOperationCS__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16299);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3127:1: rule__LibOperationCS__Group_4__1__Impl : ( ( rule__LibOperationCS__Group_4_1__0 )* ) ;
    public final void rule__LibOperationCS__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3131:1: ( ( ( rule__LibOperationCS__Group_4_1__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3132:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3132:1: ( ( rule__LibOperationCS__Group_4_1__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3133:1: ( rule__LibOperationCS__Group_4_1__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getGroup_4_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3134:1: ( rule__LibOperationCS__Group_4_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==29) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3134:2: rule__LibOperationCS__Group_4_1__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6326);
            	    rule__LibOperationCS__Group_4_1__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3148:1: rule__LibOperationCS__Group_4_1__0 : rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 ;
    public final void rule__LibOperationCS__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3152:1: ( rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3153:2: rule__LibOperationCS__Group_4_1__0__Impl rule__LibOperationCS__Group_4_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06361);
            rule__LibOperationCS__Group_4_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06364);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3160:1: rule__LibOperationCS__Group_4_1__0__Impl : ( ',' ) ;
    public final void rule__LibOperationCS__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3164:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3165:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3165:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3166:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getCommaKeyword_4_1_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6392); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3179:1: rule__LibOperationCS__Group_4_1__1 : rule__LibOperationCS__Group_4_1__1__Impl ;
    public final void rule__LibOperationCS__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3183:1: ( rule__LibOperationCS__Group_4_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3184:2: rule__LibOperationCS__Group_4_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16423);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3190:1: rule__LibOperationCS__Group_4_1__1__Impl : ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__LibOperationCS__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3194:1: ( ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3195:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3195:1: ( ( rule__LibOperationCS__ParametersAssignment_4_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3196:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersAssignment_4_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3197:1: ( rule__LibOperationCS__ParametersAssignment_4_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3197:2: rule__LibOperationCS__ParametersAssignment_4_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6450);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3211:1: rule__LibPackageCS__Group__0 : rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 ;
    public final void rule__LibPackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3215:1: ( rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3216:2: rule__LibPackageCS__Group__0__Impl rule__LibPackageCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06484);
            rule__LibPackageCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06487);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3223:1: rule__LibPackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__LibPackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3227:1: ( ( 'package' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3228:1: ( 'package' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3228:1: ( 'package' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3229:1: 'package'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,18,FollowSets000.FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6515); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3242:1: rule__LibPackageCS__Group__1 : rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 ;
    public final void rule__LibPackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3246:1: ( rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3247:2: rule__LibPackageCS__Group__1__Impl rule__LibPackageCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16546);
            rule__LibPackageCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16549);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3254:1: rule__LibPackageCS__Group__1__Impl : ( ( rule__LibPackageCS__NameAssignment_1 ) ) ;
    public final void rule__LibPackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3258:1: ( ( ( rule__LibPackageCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3259:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3259:1: ( ( rule__LibPackageCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3260:1: ( rule__LibPackageCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3261:1: ( rule__LibPackageCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3261:2: rule__LibPackageCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6576);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3271:1: rule__LibPackageCS__Group__2 : rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 ;
    public final void rule__LibPackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3275:1: ( rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3276:2: rule__LibPackageCS__Group__2__Impl rule__LibPackageCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26606);
            rule__LibPackageCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26609);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3283:1: rule__LibPackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__LibPackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3287:1: ( ( '{' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3288:1: ( '{' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3288:1: ( '{' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3289:1: '{'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,24,FollowSets000.FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6637); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3302:1: rule__LibPackageCS__Group__3 : rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 ;
    public final void rule__LibPackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3306:1: ( rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3307:2: rule__LibPackageCS__Group__3__Impl rule__LibPackageCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36668);
            rule__LibPackageCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36671);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3314:1: rule__LibPackageCS__Group__3__Impl : ( ( rule__LibPackageCS__Alternatives_3 )* ) ;
    public final void rule__LibPackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3318:1: ( ( ( rule__LibPackageCS__Alternatives_3 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3319:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3319:1: ( ( rule__LibPackageCS__Alternatives_3 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3320:1: ( rule__LibPackageCS__Alternatives_3 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getAlternatives_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3321:1: ( rule__LibPackageCS__Alternatives_3 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==18||LA29_0==21) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3321:2: rule__LibPackageCS__Alternatives_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6698);
            	    rule__LibPackageCS__Alternatives_3();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3331:1: rule__LibPackageCS__Group__4 : rule__LibPackageCS__Group__4__Impl ;
    public final void rule__LibPackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3335:1: ( rule__LibPackageCS__Group__4__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3336:2: rule__LibPackageCS__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46729);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3342:1: rule__LibPackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__LibPackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3346:1: ( ( '}' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3347:1: ( '}' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3347:1: ( '}' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3348:1: '}'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,25,FollowSets000.FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6757); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3371:1: rule__LibParameterCS__Group__0 : rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 ;
    public final void rule__LibParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3375:1: ( rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3376:2: rule__LibParameterCS__Group__0__Impl rule__LibParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06798);
            rule__LibParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06801);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3383:1: rule__LibParameterCS__Group__0__Impl : ( ( rule__LibParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3387:1: ( ( ( rule__LibParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3388:1: ( ( rule__LibParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3389:1: ( rule__LibParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:1: ( rule__LibParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3390:2: rule__LibParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6828);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3400:1: rule__LibParameterCS__Group__1 : rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 ;
    public final void rule__LibParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3404:1: ( rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3405:2: rule__LibParameterCS__Group__1__Impl rule__LibParameterCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16858);
            rule__LibParameterCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16861);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3412:1: rule__LibParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__LibParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3416:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3417:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3417:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3418:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6889); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3431:1: rule__LibParameterCS__Group__2 : rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 ;
    public final void rule__LibParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3435:1: ( rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3436:2: rule__LibParameterCS__Group__2__Impl rule__LibParameterCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26920);
            rule__LibParameterCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26923);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3443:1: rule__LibParameterCS__Group__2__Impl : ( ( rule__LibParameterCS__TypeAssignment_2 ) ) ;
    public final void rule__LibParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3447:1: ( ( ( rule__LibParameterCS__TypeAssignment_2 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3448:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3448:1: ( ( rule__LibParameterCS__TypeAssignment_2 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3449:1: ( rule__LibParameterCS__TypeAssignment_2 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeAssignment_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3450:1: ( rule__LibParameterCS__TypeAssignment_2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3450:2: rule__LibParameterCS__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6950);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3460:1: rule__LibParameterCS__Group__3 : rule__LibParameterCS__Group__3__Impl ;
    public final void rule__LibParameterCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3464:1: ( rule__LibParameterCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3465:2: rule__LibParameterCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36980);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3471:1: rule__LibParameterCS__Group__3__Impl : ( ( rule__LibParameterCS__Group_3__0 )? ) ;
    public final void rule__LibParameterCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3475:1: ( ( ( rule__LibParameterCS__Group_3__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3476:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3476:1: ( ( rule__LibParameterCS__Group_3__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3477:1: ( rule__LibParameterCS__Group_3__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3478:1: ( rule__LibParameterCS__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==34) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3478:2: rule__LibParameterCS__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl7007);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3496:1: rule__LibParameterCS__Group_3__0 : rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 ;
    public final void rule__LibParameterCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3500:1: ( rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3501:2: rule__LibParameterCS__Group_3__0__Impl rule__LibParameterCS__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__07046);
            rule__LibParameterCS__Group_3__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__07049);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3508:1: rule__LibParameterCS__Group_3__0__Impl : ( '[' ) ;
    public final void rule__LibParameterCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3512:1: ( ( '[' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3513:1: ( '[' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3513:1: ( '[' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3514:1: '['
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLeftSquareBracketKeyword_3_0()); 
            }
            match(input,34,FollowSets000.FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl7077); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3527:1: rule__LibParameterCS__Group_3__1 : rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 ;
    public final void rule__LibParameterCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3531:1: ( rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3532:2: rule__LibParameterCS__Group_3__1__Impl rule__LibParameterCS__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__17108);
            rule__LibParameterCS__Group_3__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__17111);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3539:1: rule__LibParameterCS__Group_3__1__Impl : ( ( rule__LibParameterCS__Alternatives_3_1 ) ) ;
    public final void rule__LibParameterCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3543:1: ( ( ( rule__LibParameterCS__Alternatives_3_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3544:1: ( ( rule__LibParameterCS__Alternatives_3_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3545:1: ( rule__LibParameterCS__Alternatives_3_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getAlternatives_3_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3546:1: ( rule__LibParameterCS__Alternatives_3_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3546:2: rule__LibParameterCS__Alternatives_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7138);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3556:1: rule__LibParameterCS__Group_3__2 : rule__LibParameterCS__Group_3__2__Impl ;
    public final void rule__LibParameterCS__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3560:1: ( rule__LibParameterCS__Group_3__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3561:2: rule__LibParameterCS__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27168);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3567:1: rule__LibParameterCS__Group_3__2__Impl : ( ']' ) ;
    public final void rule__LibParameterCS__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3571:1: ( ( ']' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3572:1: ( ']' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3572:1: ( ']' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3573:1: ']'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getRightSquareBracketKeyword_3_2()); 
            }
            match(input,35,FollowSets000.FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7196); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3592:1: rule__LibParameterCS__Group_3_1_0__0 : rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 ;
    public final void rule__LibParameterCS__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3596:1: ( rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3597:2: rule__LibParameterCS__Group_3_1_0__0__Impl rule__LibParameterCS__Group_3_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07233);
            rule__LibParameterCS__Group_3_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07236);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3604:1: rule__LibParameterCS__Group_3_1_0__0__Impl : ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3608:1: ( ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3609:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3609:1: ( ( rule__LibParameterCS__LowerAssignment_3_1_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3610:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerAssignment_3_1_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3611:1: ( rule__LibParameterCS__LowerAssignment_3_1_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3611:2: rule__LibParameterCS__LowerAssignment_3_1_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7263);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3621:1: rule__LibParameterCS__Group_3_1_0__1 : rule__LibParameterCS__Group_3_1_0__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3625:1: ( rule__LibParameterCS__Group_3_1_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3626:2: rule__LibParameterCS__Group_3_1_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17293);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3632:1: rule__LibParameterCS__Group_3_1_0__1__Impl : ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) ;
    public final void rule__LibParameterCS__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3636:1: ( ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3637:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3637:1: ( ( rule__LibParameterCS__Group_3_1_0_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3638:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getGroup_3_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3639:1: ( rule__LibParameterCS__Group_3_1_0_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3639:2: rule__LibParameterCS__Group_3_1_0_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7320);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3653:1: rule__LibParameterCS__Group_3_1_0_1__0 : rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3657:1: ( rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3658:2: rule__LibParameterCS__Group_3_1_0_1__0__Impl rule__LibParameterCS__Group_3_1_0_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07355);
            rule__LibParameterCS__Group_3_1_0_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07358);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3665:1: rule__LibParameterCS__Group_3_1_0_1__0__Impl : ( '..' ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3669:1: ( ( '..' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3670:1: ( '..' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3670:1: ( '..' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3671:1: '..'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getFullStopFullStopKeyword_3_1_0_1_0()); 
            }
            match(input,36,FollowSets000.FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7386); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3684:1: rule__LibParameterCS__Group_3_1_0_1__1 : rule__LibParameterCS__Group_3_1_0_1__1__Impl ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3688:1: ( rule__LibParameterCS__Group_3_1_0_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3689:2: rule__LibParameterCS__Group_3_1_0_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17417);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3695:1: rule__LibParameterCS__Group_3_1_0_1__1__Impl : ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) ;
    public final void rule__LibParameterCS__Group_3_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3699:1: ( ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3700:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3700:1: ( ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3701:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperAssignment_3_1_0_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3702:1: ( rule__LibParameterCS__UpperAssignment_3_1_0_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3702:2: rule__LibParameterCS__UpperAssignment_3_1_0_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7444);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3716:1: rule__LibPropertyCS__Group__0 : rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 ;
    public final void rule__LibPropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3720:1: ( rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3721:2: rule__LibPropertyCS__Group__0__Impl rule__LibPropertyCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07478);
            rule__LibPropertyCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07481);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3728:1: rule__LibPropertyCS__Group__0__Impl : ( 'property' ) ;
    public final void rule__LibPropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3732:1: ( ( 'property' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3733:1: ( 'property' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3733:1: ( 'property' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3734:1: 'property'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getPropertyKeyword_0()); 
            }
            match(input,19,FollowSets000.FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7509); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3747:1: rule__LibPropertyCS__Group__1 : rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 ;
    public final void rule__LibPropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3751:1: ( rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3752:2: rule__LibPropertyCS__Group__1__Impl rule__LibPropertyCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17540);
            rule__LibPropertyCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17543);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3759:1: rule__LibPropertyCS__Group__1__Impl : ( ( rule__LibPropertyCS__NameAssignment_1 ) ) ;
    public final void rule__LibPropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3763:1: ( ( ( rule__LibPropertyCS__NameAssignment_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3764:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3764:1: ( ( rule__LibPropertyCS__NameAssignment_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3765:1: ( rule__LibPropertyCS__NameAssignment_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameAssignment_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3766:1: ( rule__LibPropertyCS__NameAssignment_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3766:2: rule__LibPropertyCS__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7570);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3776:1: rule__LibPropertyCS__Group__2 : rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 ;
    public final void rule__LibPropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3780:1: ( rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3781:2: rule__LibPropertyCS__Group__2__Impl rule__LibPropertyCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27600);
            rule__LibPropertyCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27603);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3788:1: rule__LibPropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__LibPropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3792:1: ( ( ':' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3793:1: ( ':' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3793:1: ( ':' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3794:1: ':'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FollowSets000.FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7631); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3807:1: rule__LibPropertyCS__Group__3 : rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 ;
    public final void rule__LibPropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3811:1: ( rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3812:2: rule__LibPropertyCS__Group__3__Impl rule__LibPropertyCS__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37662);
            rule__LibPropertyCS__Group__3__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37665);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3819:1: rule__LibPropertyCS__Group__3__Impl : ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) ;
    public final void rule__LibPropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3823:1: ( ( ( rule__LibPropertyCS__TypeAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3824:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3824:1: ( ( rule__LibPropertyCS__TypeAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3825:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3826:1: ( rule__LibPropertyCS__TypeAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3826:2: rule__LibPropertyCS__TypeAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7692);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3836:1: rule__LibPropertyCS__Group__4 : rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 ;
    public final void rule__LibPropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3840:1: ( rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3841:2: rule__LibPropertyCS__Group__4__Impl rule__LibPropertyCS__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47722);
            rule__LibPropertyCS__Group__4__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47725);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3848:1: rule__LibPropertyCS__Group__4__Impl : ( '=>' ) ;
    public final void rule__LibPropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3852:1: ( ( '=>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3853:1: ( '=>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3853:1: ( '=>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3854:1: '=>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getEqualsSignGreaterThanSignKeyword_4()); 
            }
            match(input,32,FollowSets000.FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7753); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3867:1: rule__LibPropertyCS__Group__5 : rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 ;
    public final void rule__LibPropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3871:1: ( rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3872:2: rule__LibPropertyCS__Group__5__Impl rule__LibPropertyCS__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57784);
            rule__LibPropertyCS__Group__5__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57787);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3879:1: rule__LibPropertyCS__Group__5__Impl : ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) ;
    public final void rule__LibPropertyCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3883:1: ( ( ( rule__LibPropertyCS__ClassAssignment_5 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3884:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3884:1: ( ( rule__LibPropertyCS__ClassAssignment_5 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3885:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassAssignment_5()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3886:1: ( rule__LibPropertyCS__ClassAssignment_5 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3886:2: rule__LibPropertyCS__ClassAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7814);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3896:1: rule__LibPropertyCS__Group__6 : rule__LibPropertyCS__Group__6__Impl ;
    public final void rule__LibPropertyCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3900:1: ( rule__LibPropertyCS__Group__6__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3901:2: rule__LibPropertyCS__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67844);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3907:1: rule__LibPropertyCS__Group__6__Impl : ( ';' ) ;
    public final void rule__LibPropertyCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3911:1: ( ( ';' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3912:1: ( ';' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3912:1: ( ';' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3913:1: ';'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getSemicolonKeyword_6()); 
            }
            match(input,33,FollowSets000.FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7872); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3940:1: rule__LibQualifiedTypeRefCS__Group__0 : rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3944:1: ( rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3945:2: rule__LibQualifiedTypeRefCS__Group__0__Impl rule__LibQualifiedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07917);
            rule__LibQualifiedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07920);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3952:1: rule__LibQualifiedTypeRefCS__Group__0__Impl : ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3956:1: ( ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3957:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3957:1: ( ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3958:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3959:1: ( rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3959:2: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7947);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3969:1: rule__LibQualifiedTypeRefCS__Group__1 : rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3973:1: ( rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3974:2: rule__LibQualifiedTypeRefCS__Group__1__Impl rule__LibQualifiedTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17977);
            rule__LibQualifiedTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17980);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3981:1: rule__LibQualifiedTypeRefCS__Group__1__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3985:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3986:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3986:1: ( ( rule__LibQualifiedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3987:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3988:1: ( rule__LibQualifiedTypeRefCS__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3988:2: rule__LibQualifiedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl8007);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:3998:1: rule__LibQualifiedTypeRefCS__Group__2 : rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4002:1: ( rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4003:2: rule__LibQualifiedTypeRefCS__Group__2__Impl rule__LibQualifiedTypeRefCS__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__28038);
            rule__LibQualifiedTypeRefCS__Group__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__28041);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4010:1: rule__LibQualifiedTypeRefCS__Group__2__Impl : ( '::' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4014:1: ( ( '::' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4015:1: ( '::' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4015:1: ( '::' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4016:1: '::'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getColonColonKeyword_2()); 
            }
            match(input,37,FollowSets000.FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl8069); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4029:1: rule__LibQualifiedTypeRefCS__Group__3 : rule__LibQualifiedTypeRefCS__Group__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4033:1: ( rule__LibQualifiedTypeRefCS__Group__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4034:2: rule__LibQualifiedTypeRefCS__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__38100);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4040:1: rule__LibQualifiedTypeRefCS__Group__3__Impl : ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4044:1: ( ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4045:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4045:1: ( ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4046:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementAssignment_3()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4047:1: ( rule__LibQualifiedTypeRefCS__ElementAssignment_3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4047:2: rule__LibQualifiedTypeRefCS__ElementAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8127);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4065:1: rule__LibQualifiedTypeRefCS__Group_1__0 : rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4069:1: ( rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4070:2: rule__LibQualifiedTypeRefCS__Group_1__0__Impl rule__LibQualifiedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08165);
            rule__LibQualifiedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08168);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4077:1: rule__LibQualifiedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4081:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4082:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4083:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8196); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4096:1: rule__LibQualifiedTypeRefCS__Group_1__1 : rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4100:1: ( rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4101:2: rule__LibQualifiedTypeRefCS__Group_1__1__Impl rule__LibQualifiedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18227);
            rule__LibQualifiedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18230);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4108:1: rule__LibQualifiedTypeRefCS__Group_1__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4112:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4113:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4113:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4114:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4115:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4115:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8257);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4125:1: rule__LibQualifiedTypeRefCS__Group_1__2 : rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4129:1: ( rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4130:2: rule__LibQualifiedTypeRefCS__Group_1__2__Impl rule__LibQualifiedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28287);
            rule__LibQualifiedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28290);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4137:1: rule__LibQualifiedTypeRefCS__Group_1__2__Impl : ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4141:1: ( ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4142:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4142:1: ( ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4143:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4144:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==29) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4144:2: rule__LibQualifiedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8317);
            	    rule__LibQualifiedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4154:1: rule__LibQualifiedTypeRefCS__Group_1__3 : rule__LibQualifiedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4158:1: ( rule__LibQualifiedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4159:2: rule__LibQualifiedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38348);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4165:1: rule__LibQualifiedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4169:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4170:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4170:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4171:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8376); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4192:1: rule__LibQualifiedTypeRefCS__Group_1_2__0 : rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4196:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4197:2: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl rule__LibQualifiedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08415);
            rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08418);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4204:1: rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4208:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4209:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4209:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4210:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8446); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4223:1: rule__LibQualifiedTypeRefCS__Group_1_2__1 : rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4227:1: ( rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4228:2: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18477);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4234:1: rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4238:1: ( ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4239:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4239:1: ( ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4240:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4241:1: ( rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4241:2: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8504);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4255:1: rule__LibTypeParameterCS__Group__0 : rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 ;
    public final void rule__LibTypeParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4259:1: ( rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4260:2: rule__LibTypeParameterCS__Group__0__Impl rule__LibTypeParameterCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08538);
            rule__LibTypeParameterCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08541);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4267:1: rule__LibTypeParameterCS__Group__0__Impl : ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) ;
    public final void rule__LibTypeParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4271:1: ( ( ( rule__LibTypeParameterCS__NameAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4272:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4272:1: ( ( rule__LibTypeParameterCS__NameAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4273:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4274:1: ( rule__LibTypeParameterCS__NameAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4274:2: rule__LibTypeParameterCS__NameAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8568);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4284:1: rule__LibTypeParameterCS__Group__1 : rule__LibTypeParameterCS__Group__1__Impl ;
    public final void rule__LibTypeParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4288:1: ( rule__LibTypeParameterCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4289:2: rule__LibTypeParameterCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18598);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4295:1: rule__LibTypeParameterCS__Group__1__Impl : ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) ;
    public final void rule__LibTypeParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4299:1: ( ( ( rule__LibTypeParameterCS__Alternatives_1 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4300:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4300:1: ( ( rule__LibTypeParameterCS__Alternatives_1 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4301:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAlternatives_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4302:1: ( rule__LibTypeParameterCS__Alternatives_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==13||LA34_0==20) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4302:2: rule__LibTypeParameterCS__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8625);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4316:1: rule__LibTypeParameterCS__Group_1_0__0 : rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4320:1: ( rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4321:2: rule__LibTypeParameterCS__Group_1_0__0__Impl rule__LibTypeParameterCS__Group_1_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08660);
            rule__LibTypeParameterCS__Group_1_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08663);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4328:1: rule__LibTypeParameterCS__Group_1_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4332:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4333:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4333:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4334:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsKeyword_1_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8691); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4347:1: rule__LibTypeParameterCS__Group_1_0__1 : rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 ;
    public final void rule__LibTypeParameterCS__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4351:1: ( rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4352:2: rule__LibTypeParameterCS__Group_1_0__1__Impl rule__LibTypeParameterCS__Group_1_0__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18722);
            rule__LibTypeParameterCS__Group_1_0__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18725);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4359:1: rule__LibTypeParameterCS__Group_1_0__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4363:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4364:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4364:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4365:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4366:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4366:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8752);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4376:1: rule__LibTypeParameterCS__Group_1_0__2 : rule__LibTypeParameterCS__Group_1_0__2__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4380:1: ( rule__LibTypeParameterCS__Group_1_0__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4381:2: rule__LibTypeParameterCS__Group_1_0__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28782);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4387:1: rule__LibTypeParameterCS__Group_1_0__2__Impl : ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) ;
    public final void rule__LibTypeParameterCS__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4391:1: ( ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4392:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4392:1: ( ( rule__LibTypeParameterCS__Group_1_0_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4393:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getGroup_1_0_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4394:1: ( rule__LibTypeParameterCS__Group_1_0_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==38) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4394:2: rule__LibTypeParameterCS__Group_1_0_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8809);
            	    rule__LibTypeParameterCS__Group_1_0_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4410:1: rule__LibTypeParameterCS__Group_1_0_2__0 : rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4414:1: ( rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4415:2: rule__LibTypeParameterCS__Group_1_0_2__0__Impl rule__LibTypeParameterCS__Group_1_0_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08846);
            rule__LibTypeParameterCS__Group_1_0_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08849);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4422:1: rule__LibTypeParameterCS__Group_1_0_2__0__Impl : ( '&&' ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4426:1: ( ( '&&' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4427:1: ( '&&' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4427:1: ( '&&' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4428:1: '&&'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_0_2_0()); 
            }
            match(input,38,FollowSets000.FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8877); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4441:1: rule__LibTypeParameterCS__Group_1_0_2__1 : rule__LibTypeParameterCS__Group_1_0_2__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4445:1: ( rule__LibTypeParameterCS__Group_1_0_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4446:2: rule__LibTypeParameterCS__Group_1_0_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18908);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4452:1: rule__LibTypeParameterCS__Group_1_0_2__1__Impl : ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4456:1: ( ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4457:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4457:1: ( ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4458:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsAssignment_1_0_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4459:1: ( rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4459:2: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8935);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4473:1: rule__LibTypeParameterCS__Group_1_1__0 : rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 ;
    public final void rule__LibTypeParameterCS__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4477:1: ( rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4478:2: rule__LibTypeParameterCS__Group_1_1__0__Impl rule__LibTypeParameterCS__Group_1_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08969);
            rule__LibTypeParameterCS__Group_1_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08972);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4485:1: rule__LibTypeParameterCS__Group_1_1__0__Impl : ( 'super' ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4489:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4490:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4490:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4491:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperKeyword_1_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl9000); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4504:1: rule__LibTypeParameterCS__Group_1_1__1 : rule__LibTypeParameterCS__Group_1_1__1__Impl ;
    public final void rule__LibTypeParameterCS__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4508:1: ( rule__LibTypeParameterCS__Group_1_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4509:2: rule__LibTypeParameterCS__Group_1_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__19031);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4515:1: rule__LibTypeParameterCS__Group_1_1__1__Impl : ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) ;
    public final void rule__LibTypeParameterCS__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4519:1: ( ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4520:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4520:1: ( ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4521:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperAssignment_1_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4522:1: ( rule__LibTypeParameterCS__SuperAssignment_1_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4522:2: rule__LibTypeParameterCS__SuperAssignment_1_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl9058);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4536:1: rule__LibTypedTypeRefCS__Group__0 : rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 ;
    public final void rule__LibTypedTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4540:1: ( rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4541:2: rule__LibTypedTypeRefCS__Group__0__Impl rule__LibTypedTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__09092);
            rule__LibTypedTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__09095);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4548:1: rule__LibTypedTypeRefCS__Group__0__Impl : ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4552:1: ( ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4553:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4553:1: ( ( rule__LibTypedTypeRefCS__TypeAssignment_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4554:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeAssignment_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4555:1: ( rule__LibTypedTypeRefCS__TypeAssignment_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4555:2: rule__LibTypedTypeRefCS__TypeAssignment_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl9122);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4565:1: rule__LibTypedTypeRefCS__Group__1 : rule__LibTypedTypeRefCS__Group__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4569:1: ( rule__LibTypedTypeRefCS__Group__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4570:2: rule__LibTypedTypeRefCS__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19152);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4576:1: rule__LibTypedTypeRefCS__Group__1__Impl : ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) ;
    public final void rule__LibTypedTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4580:1: ( ( ( rule__LibTypedTypeRefCS__Group_1__0 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4581:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4581:1: ( ( rule__LibTypedTypeRefCS__Group_1__0 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4582:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4583:1: ( rule__LibTypedTypeRefCS__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==27) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4583:2: rule__LibTypedTypeRefCS__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9179);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4597:1: rule__LibTypedTypeRefCS__Group_1__0 : rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4601:1: ( rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4602:2: rule__LibTypedTypeRefCS__Group_1__0__Impl rule__LibTypedTypeRefCS__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09214);
            rule__LibTypedTypeRefCS__Group_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09217);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4609:1: rule__LibTypedTypeRefCS__Group_1__0__Impl : ( '<' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4613:1: ( ( '<' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4614:1: ( '<' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4614:1: ( '<' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4615:1: '<'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getLessThanSignKeyword_1_0()); 
            }
            match(input,27,FollowSets000.FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9245); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4628:1: rule__LibTypedTypeRefCS__Group_1__1 : rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 ;
    public final void rule__LibTypedTypeRefCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4632:1: ( rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4633:2: rule__LibTypedTypeRefCS__Group_1__1__Impl rule__LibTypedTypeRefCS__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19276);
            rule__LibTypedTypeRefCS__Group_1__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19279);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4640:1: rule__LibTypedTypeRefCS__Group_1__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4644:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4645:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4645:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4646:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4647:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4647:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9306);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4657:1: rule__LibTypedTypeRefCS__Group_1__2 : rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 ;
    public final void rule__LibTypedTypeRefCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4661:1: ( rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4662:2: rule__LibTypedTypeRefCS__Group_1__2__Impl rule__LibTypedTypeRefCS__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29336);
            rule__LibTypedTypeRefCS__Group_1__2__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29339);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4669:1: rule__LibTypedTypeRefCS__Group_1__2__Impl : ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4673:1: ( ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4674:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4674:1: ( ( rule__LibTypedTypeRefCS__Group_1_2__0 )* )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4675:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGroup_1_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4676:1: ( rule__LibTypedTypeRefCS__Group_1_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==29) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4676:2: rule__LibTypedTypeRefCS__Group_1_2__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9366);
            	    rule__LibTypedTypeRefCS__Group_1_2__0();
            	    _fsp--;
            	    if (failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4686:1: rule__LibTypedTypeRefCS__Group_1__3 : rule__LibTypedTypeRefCS__Group_1__3__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4690:1: ( rule__LibTypedTypeRefCS__Group_1__3__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4691:2: rule__LibTypedTypeRefCS__Group_1__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39397);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4697:1: rule__LibTypedTypeRefCS__Group_1__3__Impl : ( '>' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4701:1: ( ( '>' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4702:1: ( '>' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4702:1: ( '>' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4703:1: '>'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,28,FollowSets000.FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9425); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4724:1: rule__LibTypedTypeRefCS__Group_1_2__0 : rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4728:1: ( rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4729:2: rule__LibTypedTypeRefCS__Group_1_2__0__Impl rule__LibTypedTypeRefCS__Group_1_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09464);
            rule__LibTypedTypeRefCS__Group_1_2__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09467);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4736:1: rule__LibTypedTypeRefCS__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4740:1: ( ( ',' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4741:1: ( ',' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4741:1: ( ',' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4742:1: ','
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,29,FollowSets000.FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9495); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4755:1: rule__LibTypedTypeRefCS__Group_1_2__1 : rule__LibTypedTypeRefCS__Group_1_2__1__Impl ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4759:1: ( rule__LibTypedTypeRefCS__Group_1_2__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4760:2: rule__LibTypedTypeRefCS__Group_1_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19526);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4766:1: rule__LibTypedTypeRefCS__Group_1_2__1__Impl : ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__LibTypedTypeRefCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4770:1: ( ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4771:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4771:1: ( ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4772:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsAssignment_1_2_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4773:1: ( rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4773:2: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9553);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4787:1: rule__LibWildcardTypeRefCS__Group__0 : rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 ;
    public final void rule__LibWildcardTypeRefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4791:1: ( rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4792:2: rule__LibWildcardTypeRefCS__Group__0__Impl rule__LibWildcardTypeRefCS__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09587);
            rule__LibWildcardTypeRefCS__Group__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09590);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4799:1: rule__LibWildcardTypeRefCS__Group__0__Impl : ( () ) ;
    public final void rule__LibWildcardTypeRefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4803:1: ( ( () ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4804:1: ( () )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4804:1: ( () )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4805:1: ()
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4806:1: ()
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4808:1: 
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4818:1: rule__LibWildcardTypeRefCS__Group__1 : rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 ;
    public final void rule__LibWildcardTypeRefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4822:1: ( rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4823:2: rule__LibWildcardTypeRefCS__Group__1__Impl rule__LibWildcardTypeRefCS__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19648);
            rule__LibWildcardTypeRefCS__Group__1__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19651);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4830:1: rule__LibWildcardTypeRefCS__Group__1__Impl : ( '?' ) ;
    public final void rule__LibWildcardTypeRefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4834:1: ( ( '?' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4835:1: ( '?' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4835:1: ( '?' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4836:1: '?'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,23,FollowSets000.FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9679); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4849:1: rule__LibWildcardTypeRefCS__Group__2 : rule__LibWildcardTypeRefCS__Group__2__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4853:1: ( rule__LibWildcardTypeRefCS__Group__2__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4854:2: rule__LibWildcardTypeRefCS__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29710);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4860:1: rule__LibWildcardTypeRefCS__Group__2__Impl : ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) ;
    public final void rule__LibWildcardTypeRefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4864:1: ( ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4865:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4865:1: ( ( rule__LibWildcardTypeRefCS__Alternatives_2 )? )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4866:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getAlternatives_2()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4867:1: ( rule__LibWildcardTypeRefCS__Alternatives_2 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==13||LA38_0==20) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4867:2: rule__LibWildcardTypeRefCS__Alternatives_2
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9737);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4883:1: rule__LibWildcardTypeRefCS__Group_2_0__0 : rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4887:1: ( rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4888:2: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl rule__LibWildcardTypeRefCS__Group_2_0__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09774);
            rule__LibWildcardTypeRefCS__Group_2_0__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09777);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4895:1: rule__LibWildcardTypeRefCS__Group_2_0__0__Impl : ( 'extends' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4899:1: ( ( 'extends' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4900:1: ( 'extends' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4900:1: ( 'extends' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4901:1: 'extends'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsKeyword_2_0_0()); 
            }
            match(input,13,FollowSets000.FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9805); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4914:1: rule__LibWildcardTypeRefCS__Group_2_0__1 : rule__LibWildcardTypeRefCS__Group_2_0__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4918:1: ( rule__LibWildcardTypeRefCS__Group_2_0__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4919:2: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19836);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4925:1: rule__LibWildcardTypeRefCS__Group_2_0__1__Impl : ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4929:1: ( ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4930:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4930:1: ( ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4931:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsAssignment_2_0_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4932:1: ( rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4932:2: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9863);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4946:1: rule__LibWildcardTypeRefCS__Group_2_1__0 : rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4950:1: ( rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4951:2: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl rule__LibWildcardTypeRefCS__Group_2_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09897);
            rule__LibWildcardTypeRefCS__Group_2_1__0__Impl();
            _fsp--;
            if (failed) return ;
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09900);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4958:1: rule__LibWildcardTypeRefCS__Group_2_1__0__Impl : ( 'super' ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4962:1: ( ( 'super' ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4963:1: ( 'super' )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4963:1: ( 'super' )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4964:1: 'super'
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperKeyword_2_1_0()); 
            }
            match(input,20,FollowSets000.FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9928); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4977:1: rule__LibWildcardTypeRefCS__Group_2_1__1 : rule__LibWildcardTypeRefCS__Group_2_1__1__Impl ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4981:1: ( rule__LibWildcardTypeRefCS__Group_2_1__1__Impl )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4982:2: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19959);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4988:1: rule__LibWildcardTypeRefCS__Group_2_1__1__Impl : ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) ;
    public final void rule__LibWildcardTypeRefCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4992:1: ( ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4993:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4993:1: ( ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4994:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperAssignment_2_1_1()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4995:1: ( rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:4995:2: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9986);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5010:1: rule__Library__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__Library__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5014:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5015:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5015:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5016:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_110025);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5025:1: rule__Library__ImportsAssignment_2 : ( ruleLibImportCS ) ;
    public final void rule__Library__ImportsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5029:1: ( ( ruleLibImportCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5030:1: ( ruleLibImportCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5030:1: ( ruleLibImportCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5031:1: ruleLibImportCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getImportsLibImportCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_210056);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5040:1: rule__Library__PackagesAssignment_4 : ( ruleLibPackageCS ) ;
    public final void rule__Library__PackagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5044:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5045:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5045:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5046:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibraryAccess().getPackagesLibPackageCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_410087);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5055:1: rule__LibImportCS__NameAssignment_1_0 : ( ruleIdentifier ) ;
    public final void rule__LibImportCS__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5059:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5060:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5060:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5061:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNameIdentifierParserRuleCall_1_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_010118);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5070:1: rule__LibImportCS__NamespaceAssignment_2 : ( ( RULE_SINGLE_QUOTED_STRING ) ) ;
    public final void rule__LibImportCS__NamespaceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5074:1: ( ( ( RULE_SINGLE_QUOTED_STRING ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5075:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5075:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5076:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSCrossReference_2_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5077:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5078:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibImportCSAccess().getNamespaceNamespaceCSSINGLE_QUOTED_STRINGTerminalRuleCall_2_0_1()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210153); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5089:1: rule__LibClassCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5093:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5094:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5094:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5095:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110188);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5104:1: rule__LibClassCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5108:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5109:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5109:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5110:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110219);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5119:1: rule__LibClassCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibClassCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5123:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5124:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5124:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5125:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110250);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5134:1: rule__LibClassCS__ConformsToAssignment_3_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5138:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5139:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5139:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5140:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110281);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5149:1: rule__LibClassCS__ConformsToAssignment_3_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibClassCS__ConformsToAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5153:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5154:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5154:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5155:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getConformsToLibTypedRefCSParserRuleCall_3_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110312);
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


    // $ANTLR start rule__LibClassCS__OperationsAssignment_5_0
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5164:1: rule__LibClassCS__OperationsAssignment_5_0 : ( ( rule__LibClassCS__OperationsAlternatives_5_0_0 ) ) ;
    public final void rule__LibClassCS__OperationsAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5168:1: ( ( ( rule__LibClassCS__OperationsAlternatives_5_0_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5169:1: ( ( rule__LibClassCS__OperationsAlternatives_5_0_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5169:1: ( ( rule__LibClassCS__OperationsAlternatives_5_0_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5170:1: ( rule__LibClassCS__OperationsAlternatives_5_0_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getOperationsAlternatives_5_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5171:1: ( rule__LibClassCS__OperationsAlternatives_5_0_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5171:2: rule__LibClassCS__OperationsAlternatives_5_0_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibClassCS__OperationsAlternatives_5_0_0_in_rule__LibClassCS__OperationsAssignment_5_010343);
            rule__LibClassCS__OperationsAlternatives_5_0_0();
            _fsp--;
            if (failed) return ;

            }

            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getOperationsAlternatives_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__OperationsAssignment_5_0


    // $ANTLR start rule__LibClassCS__StructuralFeaturesAssignment_5_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5180:1: rule__LibClassCS__StructuralFeaturesAssignment_5_1 : ( ruleLibPropertyCS ) ;
    public final void rule__LibClassCS__StructuralFeaturesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5184:1: ( ( ruleLibPropertyCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5185:1: ( ruleLibPropertyCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5185:1: ( ruleLibPropertyCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5186:1: ruleLibPropertyCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_110376);
            ruleLibPropertyCS();
            _fsp--;
            if (failed) return ;
            if ( backtracking==0 ) {
               after(grammarAccess.getLibClassCSAccess().getStructuralFeaturesLibPropertyCSParserRuleCall_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LibClassCS__StructuralFeaturesAssignment_5_1


    // $ANTLR start rule__LibIterationCS__NameAssignment_1
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5195:1: rule__LibIterationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibIterationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5199:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5200:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5200:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5201:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110407);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5210:1: rule__LibIterationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5214:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5215:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5215:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5216:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110438);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5225:1: rule__LibIterationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibIterationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5229:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5230:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5230:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5231:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110469);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5240:1: rule__LibIterationCS__ParametersAssignment_4 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5244:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5245:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5245:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5246:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_4_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410500);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5255:1: rule__LibIterationCS__ParametersAssignment_5_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibIterationCS__ParametersAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5259:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5260:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5260:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5261:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getParametersLibParameterCSParserRuleCall_5_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110531);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5270:1: rule__LibIterationCS__TypeAssignment_8 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibIterationCS__TypeAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5274:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5275:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5275:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5276:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getTypeLibTypedRefCSParserRuleCall_8_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810562);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5285:1: rule__LibIterationCS__ClassAssignment_10 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibIterationCS__ClassAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5289:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5290:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5290:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5291:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibIterationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_10_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010593); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5300:1: rule__LibOperationCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibOperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5304:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5305:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5305:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5306:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110624);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5315:1: rule__LibOperationCS__TypeParametersAssignment_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5319:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5320:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5320:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5321:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110655);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5330:1: rule__LibOperationCS__TypeParametersAssignment_2_2_1 : ( ruleLibTypeParameterCS ) ;
    public final void rule__LibOperationCS__TypeParametersAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5334:1: ( ( ruleLibTypeParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5335:1: ( ruleLibTypeParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5335:1: ( ruleLibTypeParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5336:1: ruleLibTypeParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeParametersLibTypeParameterCSParserRuleCall_2_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110686);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5345:1: rule__LibOperationCS__ParametersAssignment_4_0 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5349:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5350:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5350:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5351:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010717);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5360:1: rule__LibOperationCS__ParametersAssignment_4_1_1 : ( ruleLibParameterCS ) ;
    public final void rule__LibOperationCS__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5364:1: ( ( ruleLibParameterCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5365:1: ( ruleLibParameterCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5365:1: ( ruleLibParameterCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5366:1: ruleLibParameterCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getParametersLibParameterCSParserRuleCall_4_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110748);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5375:1: rule__LibOperationCS__TypeAssignment_7 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibOperationCS__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5379:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5380:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5380:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5381:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getTypeLibTypedRefCSParserRuleCall_7_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710779);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5390:1: rule__LibOperationCS__ClassAssignment_9 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibOperationCS__ClassAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5394:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5395:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5395:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5396:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibOperationCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_9_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910810); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5405:1: rule__LibPackageCS__NameAssignment_1 : ( ruleIdentifier ) ;
    public final void rule__LibPackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5409:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5410:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5410:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5411:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getNameIdentifierParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110841);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5420:1: rule__LibPackageCS__SubpackagesAssignment_3_0 : ( ruleLibPackageCS ) ;
    public final void rule__LibPackageCS__SubpackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5424:1: ( ( ruleLibPackageCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5425:1: ( ruleLibPackageCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5425:1: ( ruleLibPackageCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5426:1: ruleLibPackageCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getSubpackagesLibPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010872);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5435:1: rule__LibPackageCS__ClassifiersAssignment_3_1 : ( ruleLibClassifierCS ) ;
    public final void rule__LibPackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5439:1: ( ( ruleLibClassifierCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5440:1: ( ruleLibClassifierCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5440:1: ( ruleLibClassifierCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5441:1: ruleLibClassifierCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPackageCSAccess().getClassifiersLibClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110903);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5450:1: rule__LibParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5454:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5455:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5455:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5456:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010934);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5465:1: rule__LibParameterCS__TypeAssignment_2 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibParameterCS__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5469:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5470:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5470:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5471:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getTypeLibTypedRefCSParserRuleCall_2_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210965);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5480:1: rule__LibParameterCS__LowerAssignment_3_1_0_0 : ( ruleLOWER ) ;
    public final void rule__LibParameterCS__LowerAssignment_3_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5484:1: ( ( ruleLOWER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5485:1: ( ruleLOWER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5485:1: ( ruleLOWER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5486:1: ruleLOWER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getLowerLOWERParserRuleCall_3_1_0_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010996);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5495:1: rule__LibParameterCS__UpperAssignment_3_1_0_1_1 : ( ruleUPPER ) ;
    public final void rule__LibParameterCS__UpperAssignment_3_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5499:1: ( ( ruleUPPER ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5500:1: ( ruleUPPER )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5500:1: ( ruleUPPER )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5501:1: ruleUPPER
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getUpperUPPERParserRuleCall_3_1_0_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_111027);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5510:1: rule__LibParameterCS__MultiplicityAssignment_3_1_1 : ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) ;
    public final void rule__LibParameterCS__MultiplicityAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5514:1: ( ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5515:1: ( ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5516:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibParameterCSAccess().getMultiplicityAlternatives_3_1_1_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5517:1: ( rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0 )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5517:2: rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_111058);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5526:1: rule__LibPropertyCS__NameAssignment_1 : ( ruleName ) ;
    public final void rule__LibPropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5530:1: ( ( ruleName ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5531:1: ( ruleName )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5531:1: ( ruleName )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5532:1: ruleName
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getNameNameParserRuleCall_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_111091);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5541:1: rule__LibPropertyCS__TypeAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibPropertyCS__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5545:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5546:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5546:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5547:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getTypeLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311122);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5556:1: rule__LibPropertyCS__ClassAssignment_5 : ( RULE_SINGLE_QUOTED_STRING ) ;
    public final void rule__LibPropertyCS__ClassAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5560:1: ( ( RULE_SINGLE_QUOTED_STRING ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5561:1: ( RULE_SINGLE_QUOTED_STRING )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5561:1: ( RULE_SINGLE_QUOTED_STRING )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5562:1: RULE_SINGLE_QUOTED_STRING
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibPropertyCSAccess().getClassSINGLE_QUOTED_STRINGTerminalRuleCall_5_0()); 
            }
            match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511153); if (failed) return ;
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5571:1: rule__LibQualifiedTypeRefCS__NamespaceAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibQualifiedTypeRefCS__NamespaceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5575:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5576:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5576:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5577:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5578:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5579:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getNamespaceNamespaceCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011188);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5590:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5594:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5595:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5595:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5596:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111223);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5605:1: rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5609:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5610:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5610:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5611:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111254);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5620:1: rule__LibQualifiedTypeRefCS__ElementAssignment_3 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibQualifiedTypeRefCS__ElementAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5624:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5625:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5625:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5626:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibQualifiedTypeRefCSAccess().getElementLibTypedRefCSParserRuleCall_3_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311285);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5635:1: rule__LibTypeParameterCS__NameAssignment_0 : ( ruleIdentifier ) ;
    public final void rule__LibTypeParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5639:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5640:1: ( ruleIdentifier )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5640:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5641:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getNameIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011316);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5650:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5654:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5655:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5655:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5656:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111347);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5665:1: rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5669:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5670:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5670:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5671:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getExtendsLibTypedRefCSParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111378);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5680:1: rule__LibTypeParameterCS__SuperAssignment_1_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibTypeParameterCS__SuperAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5684:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5685:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5685:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5686:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypeParameterCSAccess().getSuperLibTypedRefCSParserRuleCall_1_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111409);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5695:1: rule__LibTypedTypeRefCS__TypeAssignment_0 : ( ( ruleIdentifier ) ) ;
    public final void rule__LibTypedTypeRefCS__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5699:1: ( ( ( ruleIdentifier ) ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5700:1: ( ( ruleIdentifier ) )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5700:1: ( ( ruleIdentifier ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5701:1: ( ruleIdentifier )
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSCrossReference_0_0()); 
            }
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5702:1: ( ruleIdentifier )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5703:1: ruleIdentifier
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeTypeCSIdentifierParserRuleCall_0_0_1()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011444);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5714:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5718:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5719:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5719:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5720:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111479);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5729:1: rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1 : ( ruleLibTypeRefCS ) ;
    public final void rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5733:1: ( ( ruleLibTypeRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5734:1: ( ruleLibTypeRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5734:1: ( ruleLibTypeRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5735:1: ruleLibTypeRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibTypedTypeRefCSAccess().getTypeArgumentsLibTypeRefCSParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111510);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5744:1: rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5748:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5749:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5749:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5750:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getExtendsLibTypedRefCSParserRuleCall_2_0_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111541);
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
    // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5759:1: rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1 : ( ruleLibTypedRefCS ) ;
    public final void rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5763:1: ( ( ruleLibTypedRefCS ) )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5764:1: ( ruleLibTypedRefCS )
            {
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5764:1: ( ruleLibTypedRefCS )
            // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:5765:1: ruleLibTypedRefCS
            {
            if ( backtracking==0 ) {
               before(grammarAccess.getLibWildcardTypeRefCSAccess().getSuperLibTypedRefCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111572);
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
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ( ruleLibQualifiedTypeRefCS ) )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ruleLibQualifiedTypeRefCS )
        {
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:951:1: ( ruleLibQualifiedTypeRefCS )
        // ../org.eclipse.ocl.examples.xtext.oclstdlib.ui/src-gen/org/eclipse/ocl/examples/xtext/oclstdlib/ui/contentassist/antlr/internal/InternalOCLstdlib.g:952:1: ruleLibQualifiedTypeRefCS
        {
        if ( backtracking==0 ) {
           before(grammarAccess.getLibTypedRefCSAccess().getLibQualifiedTypeRefCSParserRuleCall_0()); 
        }
        pushFollow(FollowSets000.FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred212016);
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
        public static final BitSet FOLLOW_rule__LibClassCS__OperationsAssignment_5_0_in_rule__LibClassCS__Alternatives_51639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__StructuralFeaturesAssignment_5_1_in_rule__LibClassCS__Alternatives_51657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibIterationCS_in_rule__LibClassCS__OperationsAlternatives_5_0_01690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibOperationCS_in_rule__LibClassCS__OperationsAlternatives_5_0_01707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__SubpackagesAssignment_3_0_in_rule__LibPackageCS__Alternatives_31739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__ClassifiersAssignment_3_1_in_rule__LibPackageCS__Alternatives_31757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0_in_rule__LibParameterCS__Alternatives_3_11790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAssignment_3_1_1_in_rule__LibParameterCS__Alternatives_3_11808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_01882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0_in_rule__LibTypeParameterCS__Alternatives_11916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0_in_rule__LibTypeParameterCS__Alternatives_11934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeRefCS__Alternatives1967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibWildcardTypeRefCS_in_rule__LibTypeRefCS__Alternatives1984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedTypeRefCS_in_rule__LibTypedRefCS__Alternatives2033 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0_in_rule__LibWildcardTypeRefCS__Alternatives_22065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0_in_rule__LibWildcardTypeRefCS__Alternatives_22083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__0__Impl_in_rule__Library__Group__02114 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__Library__Group__1_in_rule__Library__Group__02117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Library__Group__0__Impl2145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__1__Impl_in_rule__Library__Group__12176 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_rule__Library__Group__2_in_rule__Library__Group__12179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__NameAssignment_1_in_rule__Library__Group__1__Impl2206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__2__Impl_in_rule__Library__Group__22236 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Library__Group__3_in_rule__Library__Group__22239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__ImportsAssignment_2_in_rule__Library__Group__2__Impl2266 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_rule__Library__Group__3__Impl_in_rule__Library__Group__32297 = new BitSet(new long[]{0x0000000002040000L});
        public static final BitSet FOLLOW_rule__Library__Group__4_in_rule__Library__Group__32300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Library__Group__3__Impl2328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__Group__4__Impl_in_rule__Library__Group__42359 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Library__Group__5_in_rule__Library__Group__42362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Library__PackagesAssignment_4_in_rule__Library__Group__4__Impl2389 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Library__Group__5__Impl_in_rule__Library__Group__52420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Library__Group__5__Impl2448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__0__Impl_in_rule__LibImportCS__Group__02491 = new BitSet(new long[]{0x00000000003FF0A0L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1_in_rule__LibImportCS__Group__02494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__LibImportCS__Group__0__Impl2522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__1__Impl_in_rule__LibImportCS__Group__12553 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2_in_rule__LibImportCS__Group__12556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0_in_rule__LibImportCS__Group__1__Impl2583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group__2__Impl_in_rule__LibImportCS__Group__22614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NamespaceAssignment_2_in_rule__LibImportCS__Group__2__Impl2641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__0__Impl_in_rule__LibImportCS__Group_1__02677 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1_in_rule__LibImportCS__Group_1__02680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__NameAssignment_1_0_in_rule__LibImportCS__Group_1__0__Impl2707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibImportCS__Group_1__1__Impl_in_rule__LibImportCS__Group_1__12737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibImportCS__Group_1__1__Impl2765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__0__Impl_in_rule__LibClassCS__Group__02800 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1_in_rule__LibClassCS__Group__02803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__LibClassCS__Group__0__Impl2831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__1__Impl_in_rule__LibClassCS__Group__12862 = new BitSet(new long[]{0x0000000009001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2_in_rule__LibClassCS__Group__12865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__NameAssignment_1_in_rule__LibClassCS__Group__1__Impl2892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__2__Impl_in_rule__LibClassCS__Group__22922 = new BitSet(new long[]{0x0000000001001000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3_in_rule__LibClassCS__Group__22925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0_in_rule__LibClassCS__Group__2__Impl2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__3__Impl_in_rule__LibClassCS__Group__32983 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4_in_rule__LibClassCS__Group__32986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0_in_rule__LibClassCS__Group__3__Impl3013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__4__Impl_in_rule__LibClassCS__Group__43044 = new BitSet(new long[]{0x00000000020A8000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5_in_rule__LibClassCS__Group__43047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibClassCS__Group__4__Impl3075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__5__Impl_in_rule__LibClassCS__Group__53106 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6_in_rule__LibClassCS__Group__53109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Alternatives_5_in_rule__LibClassCS__Group__5__Impl3136 = new BitSet(new long[]{0x00000000000A8002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group__6__Impl_in_rule__LibClassCS__Group__63167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibClassCS__Group__6__Impl3195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__0__Impl_in_rule__LibClassCS__Group_2__03240 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1_in_rule__LibClassCS__Group_2__03243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibClassCS__Group_2__0__Impl3271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__1__Impl_in_rule__LibClassCS__Group_2__13302 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2_in_rule__LibClassCS__Group_2__13305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_1_in_rule__LibClassCS__Group_2__1__Impl3332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__2__Impl_in_rule__LibClassCS__Group_2__23362 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3_in_rule__LibClassCS__Group_2__23365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0_in_rule__LibClassCS__Group_2__2__Impl3392 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2__3__Impl_in_rule__LibClassCS__Group_2__33423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibClassCS__Group_2__3__Impl3451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__0__Impl_in_rule__LibClassCS__Group_2_2__03490 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1_in_rule__LibClassCS__Group_2_2__03493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_2_2__0__Impl3521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_2_2__1__Impl_in_rule__LibClassCS__Group_2_2__13552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__TypeParametersAssignment_2_2_1_in_rule__LibClassCS__Group_2_2__1__Impl3579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__0__Impl_in_rule__LibClassCS__Group_3__03613 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1_in_rule__LibClassCS__Group_3__03616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__LibClassCS__Group_3__0__Impl3644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__1__Impl_in_rule__LibClassCS__Group_3__13675 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2_in_rule__LibClassCS__Group_3__13678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_1_in_rule__LibClassCS__Group_3__1__Impl3705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3__2__Impl_in_rule__LibClassCS__Group_3__23735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0_in_rule__LibClassCS__Group_3__2__Impl3762 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__0__Impl_in_rule__LibClassCS__Group_3_2__03799 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1_in_rule__LibClassCS__Group_3_2__03802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibClassCS__Group_3_2__0__Impl3830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__Group_3_2__1__Impl_in_rule__LibClassCS__Group_3_2__13861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__ConformsToAssignment_3_2_1_in_rule__LibClassCS__Group_3_2__1__Impl3888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__0__Impl_in_rule__LibIterationCS__Group__03922 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1_in_rule__LibIterationCS__Group__03925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__LibIterationCS__Group__0__Impl3953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__1__Impl_in_rule__LibIterationCS__Group__13984 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2_in_rule__LibIterationCS__Group__13987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__NameAssignment_1_in_rule__LibIterationCS__Group__1__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__2__Impl_in_rule__LibIterationCS__Group__24044 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3_in_rule__LibIterationCS__Group__24047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0_in_rule__LibIterationCS__Group__2__Impl4074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__3__Impl_in_rule__LibIterationCS__Group__34105 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4_in_rule__LibIterationCS__Group__34108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibIterationCS__Group__3__Impl4136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__4__Impl_in_rule__LibIterationCS__Group__44167 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5_in_rule__LibIterationCS__Group__44170 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_4_in_rule__LibIterationCS__Group__4__Impl4197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__5__Impl_in_rule__LibIterationCS__Group__54227 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6_in_rule__LibIterationCS__Group__54230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0_in_rule__LibIterationCS__Group__5__Impl4257 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__6__Impl_in_rule__LibIterationCS__Group__64288 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7_in_rule__LibIterationCS__Group__64291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibIterationCS__Group__6__Impl4319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__7__Impl_in_rule__LibIterationCS__Group__74350 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8_in_rule__LibIterationCS__Group__74353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibIterationCS__Group__7__Impl4381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__8__Impl_in_rule__LibIterationCS__Group__84412 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9_in_rule__LibIterationCS__Group__84415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeAssignment_8_in_rule__LibIterationCS__Group__8__Impl4442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__9__Impl_in_rule__LibIterationCS__Group__94472 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10_in_rule__LibIterationCS__Group__94475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibIterationCS__Group__9__Impl4503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__10__Impl_in_rule__LibIterationCS__Group__104534 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11_in_rule__LibIterationCS__Group__104537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ClassAssignment_10_in_rule__LibIterationCS__Group__10__Impl4564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group__11__Impl_in_rule__LibIterationCS__Group__114594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibIterationCS__Group__11__Impl4622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__0__Impl_in_rule__LibIterationCS__Group_2__04677 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1_in_rule__LibIterationCS__Group_2__04680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibIterationCS__Group_2__0__Impl4708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__1__Impl_in_rule__LibIterationCS__Group_2__14739 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2_in_rule__LibIterationCS__Group_2__14742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_1_in_rule__LibIterationCS__Group_2__1__Impl4769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__2__Impl_in_rule__LibIterationCS__Group_2__24799 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3_in_rule__LibIterationCS__Group_2__24802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0_in_rule__LibIterationCS__Group_2__2__Impl4829 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2__3__Impl_in_rule__LibIterationCS__Group_2__34860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibIterationCS__Group_2__3__Impl4888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__0__Impl_in_rule__LibIterationCS__Group_2_2__04927 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1_in_rule__LibIterationCS__Group_2_2__04930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_2_2__0__Impl4958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_2_2__1__Impl_in_rule__LibIterationCS__Group_2_2__14989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__TypeParametersAssignment_2_2_1_in_rule__LibIterationCS__Group_2_2__1__Impl5016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__0__Impl_in_rule__LibIterationCS__Group_5__05050 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1_in_rule__LibIterationCS__Group_5__05053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibIterationCS__Group_5__0__Impl5081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__Group_5__1__Impl_in_rule__LibIterationCS__Group_5__15112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibIterationCS__ParametersAssignment_5_1_in_rule__LibIterationCS__Group_5__1__Impl5139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__0__Impl_in_rule__LibOperationCS__Group__05173 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1_in_rule__LibOperationCS__Group__05176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__LibOperationCS__Group__0__Impl5204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__1__Impl_in_rule__LibOperationCS__Group__15235 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2_in_rule__LibOperationCS__Group__15238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__NameAssignment_1_in_rule__LibOperationCS__Group__1__Impl5265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__2__Impl_in_rule__LibOperationCS__Group__25295 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3_in_rule__LibOperationCS__Group__25298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0_in_rule__LibOperationCS__Group__2__Impl5325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__3__Impl_in_rule__LibOperationCS__Group__35356 = new BitSet(new long[]{0x00000000803FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4_in_rule__LibOperationCS__Group__35359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__LibOperationCS__Group__3__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__4__Impl_in_rule__LibOperationCS__Group__45418 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5_in_rule__LibOperationCS__Group__45421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0_in_rule__LibOperationCS__Group__4__Impl5448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__5__Impl_in_rule__LibOperationCS__Group__55479 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6_in_rule__LibOperationCS__Group__55482 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__LibOperationCS__Group__5__Impl5510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__6__Impl_in_rule__LibOperationCS__Group__65541 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7_in_rule__LibOperationCS__Group__65544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibOperationCS__Group__6__Impl5572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__7__Impl_in_rule__LibOperationCS__Group__75603 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8_in_rule__LibOperationCS__Group__75606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeAssignment_7_in_rule__LibOperationCS__Group__7__Impl5633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__8__Impl_in_rule__LibOperationCS__Group__85663 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9_in_rule__LibOperationCS__Group__85666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibOperationCS__Group__8__Impl5694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__9__Impl_in_rule__LibOperationCS__Group__95725 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10_in_rule__LibOperationCS__Group__95728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ClassAssignment_9_in_rule__LibOperationCS__Group__9__Impl5755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group__10__Impl_in_rule__LibOperationCS__Group__105785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibOperationCS__Group__10__Impl5813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__0__Impl_in_rule__LibOperationCS__Group_2__05866 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1_in_rule__LibOperationCS__Group_2__05869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibOperationCS__Group_2__0__Impl5897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__1__Impl_in_rule__LibOperationCS__Group_2__15928 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2_in_rule__LibOperationCS__Group_2__15931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_1_in_rule__LibOperationCS__Group_2__1__Impl5958 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__2__Impl_in_rule__LibOperationCS__Group_2__25988 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3_in_rule__LibOperationCS__Group_2__25991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0_in_rule__LibOperationCS__Group_2__2__Impl6018 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2__3__Impl_in_rule__LibOperationCS__Group_2__36049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibOperationCS__Group_2__3__Impl6077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__0__Impl_in_rule__LibOperationCS__Group_2_2__06116 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1_in_rule__LibOperationCS__Group_2_2__06119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_2_2__0__Impl6147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_2_2__1__Impl_in_rule__LibOperationCS__Group_2_2__16178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__TypeParametersAssignment_2_2_1_in_rule__LibOperationCS__Group_2_2__1__Impl6205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__0__Impl_in_rule__LibOperationCS__Group_4__06239 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1_in_rule__LibOperationCS__Group_4__06242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_0_in_rule__LibOperationCS__Group_4__0__Impl6269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4__1__Impl_in_rule__LibOperationCS__Group_4__16299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0_in_rule__LibOperationCS__Group_4__1__Impl6326 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__0__Impl_in_rule__LibOperationCS__Group_4_1__06361 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1_in_rule__LibOperationCS__Group_4_1__06364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibOperationCS__Group_4_1__0__Impl6392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__Group_4_1__1__Impl_in_rule__LibOperationCS__Group_4_1__16423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibOperationCS__ParametersAssignment_4_1_1_in_rule__LibOperationCS__Group_4_1__1__Impl6450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__0__Impl_in_rule__LibPackageCS__Group__06484 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1_in_rule__LibPackageCS__Group__06487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__LibPackageCS__Group__0__Impl6515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__1__Impl_in_rule__LibPackageCS__Group__16546 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2_in_rule__LibPackageCS__Group__16549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__NameAssignment_1_in_rule__LibPackageCS__Group__1__Impl6576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__2__Impl_in_rule__LibPackageCS__Group__26606 = new BitSet(new long[]{0x0000000002240000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3_in_rule__LibPackageCS__Group__26609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__LibPackageCS__Group__2__Impl6637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__3__Impl_in_rule__LibPackageCS__Group__36668 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4_in_rule__LibPackageCS__Group__36671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Alternatives_3_in_rule__LibPackageCS__Group__3__Impl6698 = new BitSet(new long[]{0x0000000000240002L});
        public static final BitSet FOLLOW_rule__LibPackageCS__Group__4__Impl_in_rule__LibPackageCS__Group__46729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__LibPackageCS__Group__4__Impl6757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__0__Impl_in_rule__LibParameterCS__Group__06798 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1_in_rule__LibParameterCS__Group__06801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__NameAssignment_0_in_rule__LibParameterCS__Group__0__Impl6828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__1__Impl_in_rule__LibParameterCS__Group__16858 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2_in_rule__LibParameterCS__Group__16861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibParameterCS__Group__1__Impl6889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__2__Impl_in_rule__LibParameterCS__Group__26920 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3_in_rule__LibParameterCS__Group__26923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__TypeAssignment_2_in_rule__LibParameterCS__Group__2__Impl6950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group__3__Impl_in_rule__LibParameterCS__Group__36980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0_in_rule__LibParameterCS__Group__3__Impl7007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__0__Impl_in_rule__LibParameterCS__Group_3__07046 = new BitSet(new long[]{0x0000000000C00810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1_in_rule__LibParameterCS__Group_3__07049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__LibParameterCS__Group_3__0__Impl7077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__1__Impl_in_rule__LibParameterCS__Group_3__17108 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2_in_rule__LibParameterCS__Group_3__17111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Alternatives_3_1_in_rule__LibParameterCS__Group_3__1__Impl7138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3__2__Impl_in_rule__LibParameterCS__Group_3__27168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__LibParameterCS__Group_3__2__Impl7196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__0__Impl_in_rule__LibParameterCS__Group_3_1_0__07233 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1_in_rule__LibParameterCS__Group_3_1_0__07236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__LowerAssignment_3_1_0_0_in_rule__LibParameterCS__Group_3_1_0__0__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0__1__Impl_in_rule__LibParameterCS__Group_3_1_0__17293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0_in_rule__LibParameterCS__Group_3_1_0__1__Impl7320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__0__Impl_in_rule__LibParameterCS__Group_3_1_0_1__07355 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1_in_rule__LibParameterCS__Group_3_1_0_1__07358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__LibParameterCS__Group_3_1_0_1__0__Impl7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__Group_3_1_0_1__1__Impl_in_rule__LibParameterCS__Group_3_1_0_1__17417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__UpperAssignment_3_1_0_1_1_in_rule__LibParameterCS__Group_3_1_0_1__1__Impl7444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__0__Impl_in_rule__LibPropertyCS__Group__07478 = new BitSet(new long[]{0x00000000003FF060L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1_in_rule__LibPropertyCS__Group__07481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__LibPropertyCS__Group__0__Impl7509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__1__Impl_in_rule__LibPropertyCS__Group__17540 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2_in_rule__LibPropertyCS__Group__17543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__NameAssignment_1_in_rule__LibPropertyCS__Group__1__Impl7570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__2__Impl_in_rule__LibPropertyCS__Group__27600 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3_in_rule__LibPropertyCS__Group__27603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__LibPropertyCS__Group__2__Impl7631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__3__Impl_in_rule__LibPropertyCS__Group__37662 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4_in_rule__LibPropertyCS__Group__37665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__TypeAssignment_3_in_rule__LibPropertyCS__Group__3__Impl7692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__4__Impl_in_rule__LibPropertyCS__Group__47722 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5_in_rule__LibPropertyCS__Group__47725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__LibPropertyCS__Group__4__Impl7753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__5__Impl_in_rule__LibPropertyCS__Group__57784 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6_in_rule__LibPropertyCS__Group__57787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__ClassAssignment_5_in_rule__LibPropertyCS__Group__5__Impl7814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibPropertyCS__Group__6__Impl_in_rule__LibPropertyCS__Group__67844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__LibPropertyCS__Group__6__Impl7872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__0__Impl_in_rule__LibQualifiedTypeRefCS__Group__07917 = new BitSet(new long[]{0x0000002008000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1_in_rule__LibQualifiedTypeRefCS__Group__07920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__NamespaceAssignment_0_in_rule__LibQualifiedTypeRefCS__Group__0__Impl7947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__1__Impl_in_rule__LibQualifiedTypeRefCS__Group__17977 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2_in_rule__LibQualifiedTypeRefCS__Group__17980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0_in_rule__LibQualifiedTypeRefCS__Group__1__Impl8007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__2__Impl_in_rule__LibQualifiedTypeRefCS__Group__28038 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3_in_rule__LibQualifiedTypeRefCS__Group__28041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__LibQualifiedTypeRefCS__Group__2__Impl8069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group__3__Impl_in_rule__LibQualifiedTypeRefCS__Group__38100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__ElementAssignment_3_in_rule__LibQualifiedTypeRefCS__Group__3__Impl8127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__08165 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1_in_rule__LibQualifiedTypeRefCS__Group_1__08168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibQualifiedTypeRefCS__Group_1__0__Impl8196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__18227 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2_in_rule__LibQualifiedTypeRefCS__Group_1__18230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibQualifiedTypeRefCS__Group_1__1__Impl8257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__2__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__28287 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3_in_rule__LibQualifiedTypeRefCS__Group_1__28290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0_in_rule__LibQualifiedTypeRefCS__Group_1__2__Impl8317 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1__3__Impl_in_rule__LibQualifiedTypeRefCS__Group_1__38348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibQualifiedTypeRefCS__Group_1__3__Impl8376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__08415 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1_in_rule__LibQualifiedTypeRefCS__Group_1_2__08418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibQualifiedTypeRefCS__Group_1_2__0__Impl8446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl_in_rule__LibQualifiedTypeRefCS__Group_1_2__18477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibQualifiedTypeRefCS__Group_1_2__1__Impl8504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__0__Impl_in_rule__LibTypeParameterCS__Group__08538 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1_in_rule__LibTypeParameterCS__Group__08541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__NameAssignment_0_in_rule__LibTypeParameterCS__Group__0__Impl8568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group__1__Impl_in_rule__LibTypeParameterCS__Group__18598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Alternatives_1_in_rule__LibTypeParameterCS__Group__1__Impl8625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__0__Impl_in_rule__LibTypeParameterCS__Group_1_0__08660 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1_in_rule__LibTypeParameterCS__Group_1_0__08663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibTypeParameterCS__Group_1_0__0__Impl8691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__1__Impl_in_rule__LibTypeParameterCS__Group_1_0__18722 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2_in_rule__LibTypeParameterCS__Group_1_0__18725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_1_in_rule__LibTypeParameterCS__Group_1_0__1__Impl8752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0__2__Impl_in_rule__LibTypeParameterCS__Group_1_0__28782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0_in_rule__LibTypeParameterCS__Group_1_0__2__Impl8809 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__0__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__08846 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1_in_rule__LibTypeParameterCS__Group_1_0_2__08849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__LibTypeParameterCS__Group_1_0_2__0__Impl8877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_0_2__1__Impl_in_rule__LibTypeParameterCS__Group_1_0_2__18908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_1_in_rule__LibTypeParameterCS__Group_1_0_2__1__Impl8935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__0__Impl_in_rule__LibTypeParameterCS__Group_1_1__08969 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1_in_rule__LibTypeParameterCS__Group_1_1__08972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibTypeParameterCS__Group_1_1__0__Impl9000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__Group_1_1__1__Impl_in_rule__LibTypeParameterCS__Group_1_1__19031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypeParameterCS__SuperAssignment_1_1_1_in_rule__LibTypeParameterCS__Group_1_1__1__Impl9058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__0__Impl_in_rule__LibTypedTypeRefCS__Group__09092 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1_in_rule__LibTypedTypeRefCS__Group__09095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeAssignment_0_in_rule__LibTypedTypeRefCS__Group__0__Impl9122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group__1__Impl_in_rule__LibTypedTypeRefCS__Group__19152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0_in_rule__LibTypedTypeRefCS__Group__1__Impl9179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__0__Impl_in_rule__LibTypedTypeRefCS__Group_1__09214 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1_in_rule__LibTypedTypeRefCS__Group_1__09217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__LibTypedTypeRefCS__Group_1__0__Impl9245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__1__Impl_in_rule__LibTypedTypeRefCS__Group_1__19276 = new BitSet(new long[]{0x0000000030000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2_in_rule__LibTypedTypeRefCS__Group_1__19279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_1_in_rule__LibTypedTypeRefCS__Group_1__1__Impl9306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__2__Impl_in_rule__LibTypedTypeRefCS__Group_1__29336 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3_in_rule__LibTypedTypeRefCS__Group_1__29339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0_in_rule__LibTypedTypeRefCS__Group_1__2__Impl9366 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1__3__Impl_in_rule__LibTypedTypeRefCS__Group_1__39397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__LibTypedTypeRefCS__Group_1__3__Impl9425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__0__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__09464 = new BitSet(new long[]{0x0000000000BFF020L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1_in_rule__LibTypedTypeRefCS__Group_1_2__09467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__LibTypedTypeRefCS__Group_1_2__0__Impl9495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__Group_1_2__1__Impl_in_rule__LibTypedTypeRefCS__Group_1_2__19526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_1_in_rule__LibTypedTypeRefCS__Group_1_2__1__Impl9553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__0__Impl_in_rule__LibWildcardTypeRefCS__Group__09587 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1_in_rule__LibWildcardTypeRefCS__Group__09590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__1__Impl_in_rule__LibWildcardTypeRefCS__Group__19648 = new BitSet(new long[]{0x0000000000102002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2_in_rule__LibWildcardTypeRefCS__Group__19651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__LibWildcardTypeRefCS__Group__1__Impl9679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group__2__Impl_in_rule__LibWildcardTypeRefCS__Group__29710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Alternatives_2_in_rule__LibWildcardTypeRefCS__Group__2__Impl9737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__09774 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1_in_rule__LibWildcardTypeRefCS__Group_2_0__09777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__LibWildcardTypeRefCS__Group_2_0__0__Impl9805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_0__19836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_1_in_rule__LibWildcardTypeRefCS__Group_2_0__1__Impl9863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__09897 = new BitSet(new long[]{0x00000000003FF020L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1_in_rule__LibWildcardTypeRefCS__Group_2_1__09900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__LibWildcardTypeRefCS__Group_2_1__0__Impl9928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl_in_rule__LibWildcardTypeRefCS__Group_2_1__19959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_1_in_rule__LibWildcardTypeRefCS__Group_2_1__1__Impl9986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__Library__NameAssignment_110025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibImportCS_in_rule__Library__ImportsAssignment_210056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__Library__PackagesAssignment_410087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibImportCS__NameAssignment_1_010118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibImportCS__NamespaceAssignment_210153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibClassCS__NameAssignment_110188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_110219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibClassCS__TypeParametersAssignment_2_2_110250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_110281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibClassCS__ConformsToAssignment_3_2_110312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibClassCS__OperationsAlternatives_5_0_0_in_rule__LibClassCS__OperationsAssignment_5_010343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPropertyCS_in_rule__LibClassCS__StructuralFeaturesAssignment_5_110376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibIterationCS__NameAssignment_110407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_110438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibIterationCS__TypeParametersAssignment_2_2_110469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_410500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibIterationCS__ParametersAssignment_5_110531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibIterationCS__TypeAssignment_810562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibIterationCS__ClassAssignment_1010593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibOperationCS__NameAssignment_110624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_110655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeParameterCS_in_rule__LibOperationCS__TypeParametersAssignment_2_2_110686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_010717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibParameterCS_in_rule__LibOperationCS__ParametersAssignment_4_1_110748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibOperationCS__TypeAssignment_710779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibOperationCS__ClassAssignment_910810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibPackageCS__NameAssignment_110841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibPackageCS_in_rule__LibPackageCS__SubpackagesAssignment_3_010872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibClassifierCS_in_rule__LibPackageCS__ClassifiersAssignment_3_110903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibParameterCS__NameAssignment_010934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibParameterCS__TypeAssignment_210965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_rule__LibParameterCS__LowerAssignment_3_1_0_010996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_rule__LibParameterCS__UpperAssignment_3_1_0_1_111027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__LibParameterCS__MultiplicityAlternatives_3_1_1_0_in_rule__LibParameterCS__MultiplicityAssignment_3_1_111058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleName_in_rule__LibPropertyCS__NameAssignment_111091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibPropertyCS__TypeAssignment_311122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_rule__LibPropertyCS__ClassAssignment_511153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibQualifiedTypeRefCS__NamespaceAssignment_011188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_111223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibQualifiedTypeRefCS__TypeArgumentsAssignment_1_2_111254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibQualifiedTypeRefCS__ElementAssignment_311285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypeParameterCS__NameAssignment_011316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_111347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__ExtendsAssignment_1_0_2_111378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibTypeParameterCS__SuperAssignment_1_1_111409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_rule__LibTypedTypeRefCS__TypeAssignment_011444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_111479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypeRefCS_in_rule__LibTypedTypeRefCS__TypeArgumentsAssignment_1_2_111510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__ExtendsAssignment_2_0_111541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibTypedRefCS_in_rule__LibWildcardTypeRefCS__SuperAssignment_2_1_111572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibQualifiedTypeRefCS_in_synpred212016 = new BitSet(new long[]{0x0000000000000002L});
    }


}