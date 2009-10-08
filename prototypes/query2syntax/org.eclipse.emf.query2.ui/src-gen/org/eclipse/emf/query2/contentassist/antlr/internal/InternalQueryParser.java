package org.eclipse.emf.query2.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.emf.query2.services.QueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalQueryParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'notlike'", "'import'", "':'", "'select'", "'from'", "','", "'where'", "'.'", "'as'", "'in'", "'resources'", "'{'", "'}'", "'elements'", "'or'", "'and'", "'('", "')'", "'null'", "'withoutsubtypes'", "'not'", "'true'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_SINGED_LONG=7;
    public static final int RULE_SIGNED_DOUBLE=6;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

        public InternalQueryParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g"; }


     
     	private QueryGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(QueryGrammarAccess grammarAccess) {
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




    // $ANTLR start entryRuleModel
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:60:16: ( ruleModel EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:61:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:68:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:72:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:73:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:73:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:74:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:75:1: ( rule__Model__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:75:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:87:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:87:17: ( ruleImport EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:88:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport120);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport127); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:95:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:99:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:100:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:100:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:101:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:102:1: ( rule__Import__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:102:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleNamedQuery
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:114:1: entryRuleNamedQuery : ruleNamedQuery EOF ;
    public final void entryRuleNamedQuery() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:114:21: ( ruleNamedQuery EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:115:1: ruleNamedQuery EOF
            {
             before(grammarAccess.getNamedQueryRule()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery180);
            ruleNamedQuery();
            _fsp--;

             after(grammarAccess.getNamedQueryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedQuery187); 

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
    // $ANTLR end entryRuleNamedQuery


    // $ANTLR start ruleNamedQuery
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:122:1: ruleNamedQuery : ( ( rule__NamedQuery__Group__0 ) ) ;
    public final void ruleNamedQuery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:126:2: ( ( ( rule__NamedQuery__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:127:1: ( ( rule__NamedQuery__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:127:1: ( ( rule__NamedQuery__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:128:1: ( rule__NamedQuery__Group__0 )
            {
             before(grammarAccess.getNamedQueryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:129:1: ( rule__NamedQuery__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:129:2: rule__NamedQuery__Group__0
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__0_in_ruleNamedQuery214);
            rule__NamedQuery__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNamedQuery


    // $ANTLR start entryRuleMQLquery
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:141:1: entryRuleMQLquery : ruleMQLquery EOF ;
    public final void entryRuleMQLquery() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:141:19: ( ruleMQLquery EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:142:1: ruleMQLquery EOF
            {
             before(grammarAccess.getMQLqueryRule()); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery240);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getMQLqueryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery247); 

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
    // $ANTLR end entryRuleMQLquery


    // $ANTLR start ruleMQLquery
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:149:1: ruleMQLquery : ( ( rule__MQLquery__Group__0 ) ) ;
    public final void ruleMQLquery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:153:2: ( ( ( rule__MQLquery__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:154:1: ( ( rule__MQLquery__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:154:1: ( ( rule__MQLquery__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:155:1: ( rule__MQLquery__Group__0 )
            {
             before(grammarAccess.getMQLqueryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:156:1: ( rule__MQLquery__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:156:2: rule__MQLquery__Group__0
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__0_in_ruleMQLquery274);
            rule__MQLquery__Group__0();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleMQLquery


    // $ANTLR start entryRuleSelectEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:168:1: entryRuleSelectEntry : ruleSelectEntry EOF ;
    public final void entryRuleSelectEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:168:22: ( ruleSelectEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:169:1: ruleSelectEntry EOF
            {
             before(grammarAccess.getSelectEntryRule()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry300);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getSelectEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry307); 

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
    // $ANTLR end entryRuleSelectEntry


    // $ANTLR start ruleSelectEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:176:1: ruleSelectEntry : ( ( rule__SelectEntry__Group__0 ) ) ;
    public final void ruleSelectEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:180:2: ( ( ( rule__SelectEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:181:1: ( ( rule__SelectEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:181:1: ( ( rule__SelectEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:182:1: ( rule__SelectEntry__Group__0 )
            {
             before(grammarAccess.getSelectEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:183:1: ( rule__SelectEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:183:2: rule__SelectEntry__Group__0
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group__0_in_ruleSelectEntry334);
            rule__SelectEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSelectEntry


    // $ANTLR start entryRuleFromEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:195:1: entryRuleFromEntry : ruleFromEntry EOF ;
    public final void entryRuleFromEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:195:20: ( ruleFromEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:196:1: ruleFromEntry EOF
            {
             before(grammarAccess.getFromEntryRule()); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry360);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getFromEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry367); 

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
    // $ANTLR end entryRuleFromEntry


    // $ANTLR start ruleFromEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:203:1: ruleFromEntry : ( ( rule__FromEntry__Group__0 ) ) ;
    public final void ruleFromEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:207:2: ( ( ( rule__FromEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:208:1: ( ( rule__FromEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:208:1: ( ( rule__FromEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:209:1: ( rule__FromEntry__Group__0 )
            {
             before(grammarAccess.getFromEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:210:1: ( rule__FromEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:210:2: rule__FromEntry__Group__0
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__0_in_ruleFromEntry394);
            rule__FromEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleFromEntry


    // $ANTLR start entryRuleScopeClause
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:222:1: entryRuleScopeClause : ruleScopeClause EOF ;
    public final void entryRuleScopeClause() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:222:22: ( ruleScopeClause EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:223:1: ruleScopeClause EOF
            {
             before(grammarAccess.getScopeClauseRule()); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause420);
            ruleScopeClause();
            _fsp--;

             after(grammarAccess.getScopeClauseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause427); 

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
    // $ANTLR end entryRuleScopeClause


    // $ANTLR start ruleScopeClause
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:230:1: ruleScopeClause : ( ( rule__ScopeClause__Alternatives ) ) ;
    public final void ruleScopeClause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:234:2: ( ( ( rule__ScopeClause__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:235:1: ( ( rule__ScopeClause__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:235:1: ( ( rule__ScopeClause__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:236:1: ( rule__ScopeClause__Alternatives )
            {
             before(grammarAccess.getScopeClauseAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:237:1: ( rule__ScopeClause__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:237:2: rule__ScopeClause__Alternatives
            {
            pushFollow(FOLLOW_rule__ScopeClause__Alternatives_in_ruleScopeClause454);
            rule__ScopeClause__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getScopeClauseAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleScopeClause


    // $ANTLR start entryRuleResourceScope
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:249:1: entryRuleResourceScope : ruleResourceScope EOF ;
    public final void entryRuleResourceScope() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:249:24: ( ruleResourceScope EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:250:1: ruleResourceScope EOF
            {
             before(grammarAccess.getResourceScopeRule()); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope480);
            ruleResourceScope();
            _fsp--;

             after(grammarAccess.getResourceScopeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope487); 

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
    // $ANTLR end entryRuleResourceScope


    // $ANTLR start ruleResourceScope
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:257:1: ruleResourceScope : ( ( rule__ResourceScope__Group__0 ) ) ;
    public final void ruleResourceScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:261:2: ( ( ( rule__ResourceScope__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:262:1: ( ( rule__ResourceScope__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:262:1: ( ( rule__ResourceScope__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:263:1: ( rule__ResourceScope__Group__0 )
            {
             before(grammarAccess.getResourceScopeAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:264:1: ( rule__ResourceScope__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:264:2: rule__ResourceScope__Group__0
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__0_in_ruleResourceScope514);
            rule__ResourceScope__Group__0();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleResourceScope


    // $ANTLR start entryRuleElementScope
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:276:1: entryRuleElementScope : ruleElementScope EOF ;
    public final void entryRuleElementScope() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:276:23: ( ruleElementScope EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:277:1: ruleElementScope EOF
            {
             before(grammarAccess.getElementScopeRule()); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope540);
            ruleElementScope();
            _fsp--;

             after(grammarAccess.getElementScopeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope547); 

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
    // $ANTLR end entryRuleElementScope


    // $ANTLR start ruleElementScope
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:284:1: ruleElementScope : ( ( rule__ElementScope__Group__0 ) ) ;
    public final void ruleElementScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:288:2: ( ( ( rule__ElementScope__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:289:1: ( ( rule__ElementScope__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:289:1: ( ( rule__ElementScope__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:290:1: ( rule__ElementScope__Group__0 )
            {
             before(grammarAccess.getElementScopeAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:291:1: ( rule__ElementScope__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:291:2: rule__ElementScope__Group__0
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__0_in_ruleElementScope574);
            rule__ElementScope__Group__0();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleElementScope


    // $ANTLR start entryRuleWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:303:1: entryRuleWhereEntry : ruleWhereEntry EOF ;
    public final void entryRuleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:303:21: ( ruleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:304:1: ruleWhereEntry EOF
            {
             before(grammarAccess.getWhereEntryRule()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry600);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry607); 

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
    // $ANTLR end entryRuleWhereEntry


    // $ANTLR start ruleWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:311:1: ruleWhereEntry : ( ( rule__WhereEntry__Group__0 ) ) ;
    public final void ruleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:315:2: ( ( ( rule__WhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:316:1: ( ( rule__WhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:316:1: ( ( rule__WhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:317:1: ( rule__WhereEntry__Group__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:318:1: ( rule__WhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:318:2: rule__WhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group__0_in_ruleWhereEntry634);
            rule__WhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleWhereEntry


    // $ANTLR start entryRuleAndWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:330:1: entryRuleAndWhereEntry : ruleAndWhereEntry EOF ;
    public final void entryRuleAndWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:330:24: ( ruleAndWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:331:1: ruleAndWhereEntry EOF
            {
             before(grammarAccess.getAndWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry660);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry667); 

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
    // $ANTLR end entryRuleAndWhereEntry


    // $ANTLR start ruleAndWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:338:1: ruleAndWhereEntry : ( ( rule__AndWhereEntry__Group__0 ) ) ;
    public final void ruleAndWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:342:2: ( ( ( rule__AndWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:343:1: ( ( rule__AndWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:343:1: ( ( rule__AndWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:344:1: ( rule__AndWhereEntry__Group__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:345:1: ( rule__AndWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:345:2: rule__AndWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group__0_in_ruleAndWhereEntry694);
            rule__AndWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAndWhereEntry


    // $ANTLR start entryRuleConcreteWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:357:1: entryRuleConcreteWhereEntry : ruleConcreteWhereEntry EOF ;
    public final void entryRuleConcreteWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:357:29: ( ruleConcreteWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:358:1: ruleConcreteWhereEntry EOF
            {
             before(grammarAccess.getConcreteWhereEntryRule()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry720);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getConcreteWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry727); 

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
    // $ANTLR end entryRuleConcreteWhereEntry


    // $ANTLR start ruleConcreteWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:365:1: ruleConcreteWhereEntry : ( ( rule__ConcreteWhereEntry__Alternatives ) ) ;
    public final void ruleConcreteWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:369:2: ( ( ( rule__ConcreteWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:370:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:370:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:371:1: ( rule__ConcreteWhereEntry__Alternatives )
            {
             before(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:372:1: ( rule__ConcreteWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:372:2: rule__ConcreteWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__ConcreteWhereEntry__Alternatives_in_ruleConcreteWhereEntry754);
            rule__ConcreteWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcreteWhereEntry


    // $ANTLR start entryRuleParWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:384:1: entryRuleParWhereEntry : ruleParWhereEntry EOF ;
    public final void entryRuleParWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:384:24: ( ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:385:1: ruleParWhereEntry EOF
            {
             before(grammarAccess.getParWhereEntryRule()); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry780);
            ruleParWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry787); 

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
    // $ANTLR end entryRuleParWhereEntry


    // $ANTLR start ruleParWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:392:1: ruleParWhereEntry : ( ( rule__ParWhereEntry__Group__0 ) ) ;
    public final void ruleParWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:396:2: ( ( ( rule__ParWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:397:1: ( ( rule__ParWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:397:1: ( ( rule__ParWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:398:1: ( rule__ParWhereEntry__Group__0 )
            {
             before(grammarAccess.getParWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:399:1: ( rule__ParWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:399:2: rule__ParWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__0_in_ruleParWhereEntry814);
            rule__ParWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getParWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleParWhereEntry


    // $ANTLR start entryRuleAbstractAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:1: entryRuleAbstractAliasWhereEntry : ruleAbstractAliasWhereEntry EOF ;
    public final void entryRuleAbstractAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:34: ( ruleAbstractAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:412:1: ruleAbstractAliasWhereEntry EOF
            {
             before(grammarAccess.getAbstractAliasWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAbstractAliasWhereEntry_in_entryRuleAbstractAliasWhereEntry840);
            ruleAbstractAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getAbstractAliasWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAliasWhereEntry847); 

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
    // $ANTLR end entryRuleAbstractAliasWhereEntry


    // $ANTLR start ruleAbstractAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:419:1: ruleAbstractAliasWhereEntry : ( ( rule__AbstractAliasWhereEntry__Alternatives ) ) ;
    public final void ruleAbstractAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:423:2: ( ( ( rule__AbstractAliasWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__AbstractAliasWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__AbstractAliasWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:425:1: ( rule__AbstractAliasWhereEntry__Alternatives )
            {
             before(grammarAccess.getAbstractAliasWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:1: ( rule__AbstractAliasWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:2: rule__AbstractAliasWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractAliasWhereEntry__Alternatives_in_ruleAbstractAliasWhereEntry874);
            rule__AbstractAliasWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAbstractAliasWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAbstractAliasWhereEntry


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:1: entryRuleAttributeWhereEntry : ruleAttributeWhereEntry EOF ;
    public final void entryRuleAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:30: ( ruleAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:439:1: ruleAttributeWhereEntry EOF
            {
             before(grammarAccess.getAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry900);
            ruleAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry907); 

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
    // $ANTLR end entryRuleAttributeWhereEntry


    // $ANTLR start ruleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:446:1: ruleAttributeWhereEntry : ( ( rule__AttributeWhereEntry__Alternatives ) ) ;
    public final void ruleAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:450:2: ( ( ( rule__AttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:452:1: ( rule__AttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:1: ( rule__AttributeWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:2: rule__AttributeWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry934);
            rule__AttributeWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAttributeWhereEntry


    // $ANTLR start entryRuleNumericAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:1: entryRuleNumericAttributeWhereEntry : ruleNumericAttributeWhereEntry EOF ;
    public final void entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:37: ( ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:466:1: ruleNumericAttributeWhereEntry EOF
            {
             before(grammarAccess.getNumericAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry960);
            ruleNumericAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getNumericAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry967); 

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
    // $ANTLR end entryRuleNumericAttributeWhereEntry


    // $ANTLR start ruleNumericAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:473:1: ruleNumericAttributeWhereEntry : ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) ;
    public final void ruleNumericAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:477:2: ( ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:479:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:2: rule__NumericAttributeWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry994);
            rule__NumericAttributeWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNumericAttributeWhereEntry


    // $ANTLR start entryRuleDoubleWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:1: entryRuleDoubleWhereEntry : ruleDoubleWhereEntry EOF ;
    public final void entryRuleDoubleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:27: ( ruleDoubleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:493:1: ruleDoubleWhereEntry EOF
            {
             before(grammarAccess.getDoubleWhereEntryRule()); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry1020);
            ruleDoubleWhereEntry();
            _fsp--;

             after(grammarAccess.getDoubleWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry1027); 

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
    // $ANTLR end entryRuleDoubleWhereEntry


    // $ANTLR start ruleDoubleWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:500:1: ruleDoubleWhereEntry : ( ( rule__DoubleWhereEntry__Group__0 ) ) ;
    public final void ruleDoubleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:504:2: ( ( ( rule__DoubleWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:506:1: ( rule__DoubleWhereEntry__Group__0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:1: ( rule__DoubleWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:2: rule__DoubleWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry1054);
            rule__DoubleWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDoubleWhereEntry


    // $ANTLR start entryRuleLongWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:1: entryRuleLongWhereEntry : ruleLongWhereEntry EOF ;
    public final void entryRuleLongWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:25: ( ruleLongWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:520:1: ruleLongWhereEntry EOF
            {
             before(grammarAccess.getLongWhereEntryRule()); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1080);
            ruleLongWhereEntry();
            _fsp--;

             after(grammarAccess.getLongWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry1087); 

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
    // $ANTLR end entryRuleLongWhereEntry


    // $ANTLR start ruleLongWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:527:1: ruleLongWhereEntry : ( ( rule__LongWhereEntry__Group__0 ) ) ;
    public final void ruleLongWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:531:2: ( ( ( rule__LongWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__LongWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__LongWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:533:1: ( rule__LongWhereEntry__Group__0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:1: ( rule__LongWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:2: rule__LongWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1114);
            rule__LongWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLongWhereEntry


    // $ANTLR start entryRuleVariableWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:1: entryRuleVariableWhereEntry : ruleVariableWhereEntry EOF ;
    public final void entryRuleVariableWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:29: ( ruleVariableWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:547:1: ruleVariableWhereEntry EOF
            {
             before(grammarAccess.getVariableWhereEntryRule()); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1140);
            ruleVariableWhereEntry();
            _fsp--;

             after(grammarAccess.getVariableWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry1147); 

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
    // $ANTLR end entryRuleVariableWhereEntry


    // $ANTLR start ruleVariableWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:554:1: ruleVariableWhereEntry : ( ( rule__VariableWhereEntry__Group__0 ) ) ;
    public final void ruleVariableWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:558:2: ( ( ( rule__VariableWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:560:1: ( rule__VariableWhereEntry__Group__0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:1: ( rule__VariableWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:2: rule__VariableWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1174);
            rule__VariableWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleVariableWhereEntry


    // $ANTLR start entryRuleStringAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:1: entryRuleStringAttributeWhereEntry : ruleStringAttributeWhereEntry EOF ;
    public final void entryRuleStringAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:36: ( ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:574:1: ruleStringAttributeWhereEntry EOF
            {
             before(grammarAccess.getStringAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1200);
            ruleStringAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getStringAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1207); 

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
    // $ANTLR end entryRuleStringAttributeWhereEntry


    // $ANTLR start ruleStringAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:581:1: ruleStringAttributeWhereEntry : ( ( rule__StringAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleStringAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:585:2: ( ( ( rule__StringAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:587:1: ( rule__StringAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:1: ( rule__StringAttributeWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:2: rule__StringAttributeWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1234);
            rule__StringAttributeWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringAttributeWhereEntry


    // $ANTLR start entryRuleBooleanAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:1: entryRuleBooleanAttributeWhereEntry : ruleBooleanAttributeWhereEntry EOF ;
    public final void entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:37: ( ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:601:1: ruleBooleanAttributeWhereEntry EOF
            {
             before(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1260);
            ruleBooleanAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1267); 

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
    // $ANTLR end entryRuleBooleanAttributeWhereEntry


    // $ANTLR start ruleBooleanAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:608:1: ruleBooleanAttributeWhereEntry : ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleBooleanAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:612:2: ( ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:614:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:2: rule__BooleanAttributeWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1294);
            rule__BooleanAttributeWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanAttributeWhereEntry


    // $ANTLR start entryRuleReferenceWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:1: entryRuleReferenceWhereEntry : ruleReferenceWhereEntry EOF ;
    public final void entryRuleReferenceWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:30: ( ruleReferenceWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:628:1: ruleReferenceWhereEntry EOF
            {
             before(grammarAccess.getReferenceWhereEntryRule()); 
            pushFollow(FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry1320);
            ruleReferenceWhereEntry();
            _fsp--;

             after(grammarAccess.getReferenceWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceWhereEntry1327); 

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
    // $ANTLR end entryRuleReferenceWhereEntry


    // $ANTLR start ruleReferenceWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:635:1: ruleReferenceWhereEntry : ( ( rule__ReferenceWhereEntry__Alternatives ) ) ;
    public final void ruleReferenceWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:639:2: ( ( ( rule__ReferenceWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__ReferenceWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__ReferenceWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:641:1: ( rule__ReferenceWhereEntry__Alternatives )
            {
             before(grammarAccess.getReferenceWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:1: ( rule__ReferenceWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:2: rule__ReferenceWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__ReferenceWhereEntry__Alternatives_in_ruleReferenceWhereEntry1354);
            rule__ReferenceWhereEntry__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getReferenceWhereEntryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReferenceWhereEntry


    // $ANTLR start entryRuleNullWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:654:1: entryRuleNullWhereEntry : ruleNullWhereEntry EOF ;
    public final void entryRuleNullWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:654:25: ( ruleNullWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:655:1: ruleNullWhereEntry EOF
            {
             before(grammarAccess.getNullWhereEntryRule()); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1380);
            ruleNullWhereEntry();
            _fsp--;

             after(grammarAccess.getNullWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry1387); 

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
    // $ANTLR end entryRuleNullWhereEntry


    // $ANTLR start ruleNullWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:662:1: ruleNullWhereEntry : ( ( rule__NullWhereEntry__Group__0 ) ) ;
    public final void ruleNullWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:666:2: ( ( ( rule__NullWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:667:1: ( ( rule__NullWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:667:1: ( ( rule__NullWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:668:1: ( rule__NullWhereEntry__Group__0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:669:1: ( rule__NullWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:669:2: rule__NullWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1414);
            rule__NullWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNullWhereEntry


    // $ANTLR start entryRuleReferenceAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:681:1: entryRuleReferenceAliasWhereEntry : ruleReferenceAliasWhereEntry EOF ;
    public final void entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:681:35: ( ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:682:1: ruleReferenceAliasWhereEntry EOF
            {
             before(grammarAccess.getReferenceAliasWhereEntryRule()); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1440);
            ruleReferenceAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getReferenceAliasWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1447); 

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
    // $ANTLR end entryRuleReferenceAliasWhereEntry


    // $ANTLR start ruleReferenceAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:689:1: ruleReferenceAliasWhereEntry : ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) ;
    public final void ruleReferenceAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:693:2: ( ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:694:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:694:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:695:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:696:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:696:2: rule__ReferenceAliasWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1474);
            rule__ReferenceAliasWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReferenceAliasWhereEntry


    // $ANTLR start entryRuleSubselectWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:708:1: entryRuleSubselectWhereEntry : ruleSubselectWhereEntry EOF ;
    public final void entryRuleSubselectWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:708:30: ( ruleSubselectWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:709:1: ruleSubselectWhereEntry EOF
            {
             before(grammarAccess.getSubselectWhereEntryRule()); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1500);
            ruleSubselectWhereEntry();
            _fsp--;

             after(grammarAccess.getSubselectWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry1507); 

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
    // $ANTLR end entryRuleSubselectWhereEntry


    // $ANTLR start ruleSubselectWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:716:1: ruleSubselectWhereEntry : ( ( rule__SubselectWhereEntry__Group__0 ) ) ;
    public final void ruleSubselectWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:720:2: ( ( ( rule__SubselectWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:721:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:721:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:722:1: ( rule__SubselectWhereEntry__Group__0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:723:1: ( rule__SubselectWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:723:2: rule__SubselectWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1534);
            rule__SubselectWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSubselectWhereEntry


    // $ANTLR start entryRuleAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:735:1: entryRuleAliasWhereEntry : ruleAliasWhereEntry EOF ;
    public final void entryRuleAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:735:26: ( ruleAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:736:1: ruleAliasWhereEntry EOF
            {
             before(grammarAccess.getAliasWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1560);
            ruleAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getAliasWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry1567); 

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
    // $ANTLR end entryRuleAliasWhereEntry


    // $ANTLR start ruleAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:743:1: ruleAliasWhereEntry : ( ( rule__AliasWhereEntry__Group__0 ) ) ;
    public final void ruleAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:747:2: ( ( ( rule__AliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:748:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:748:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:749:1: ( rule__AliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:750:1: ( rule__AliasWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:750:2: rule__AliasWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1594);
            rule__AliasWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAliasWhereEntry


    // $ANTLR start ruleNumericOperator
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:763:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:767:1: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:768:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:768:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:769:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:770:1: ( rule__NumericOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:770:2: rule__NumericOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1631);
            rule__NumericOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNumericOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNumericOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:782:1: ruleStringOperator : ( ( rule__StringOperator__Alternatives ) ) ;
    public final void ruleStringOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:786:1: ( ( ( rule__StringOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:787:1: ( ( rule__StringOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:787:1: ( ( rule__StringOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:788:1: ( rule__StringOperator__Alternatives )
            {
             before(grammarAccess.getStringOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:789:1: ( rule__StringOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:789:2: rule__StringOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1667);
            rule__StringOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStringOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleBooleanOperator
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:801:1: ruleBooleanOperator : ( ( rule__BooleanOperator__Alternatives ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:805:1: ( ( ( rule__BooleanOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:806:1: ( ( rule__BooleanOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:806:1: ( ( rule__BooleanOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:807:1: ( rule__BooleanOperator__Alternatives )
            {
             before(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:808:1: ( rule__BooleanOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:808:2: rule__BooleanOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1703);
            rule__BooleanOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanOperator


    // $ANTLR start rule__ScopeClause__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:819:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__ScopeClause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:823:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==28) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==32) ) {
                        alt1=2;
                    }
                    else if ( (LA1_2==29) ) {
                        alt1=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("819:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("819:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==28) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==32) ) {
                    alt1=2;
                }
                else if ( (LA1_2==29) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("819:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("819:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:824:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:824:1: ( ruleResourceScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:825:1: ruleResourceScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1738);
                    ruleResourceScope();
                    _fsp--;

                     after(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:830:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:830:6: ( ruleElementScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:831:1: ruleElementScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1755);
                    ruleElementScope();
                    _fsp--;

                     after(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1()); 

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
    // $ANTLR end rule__ScopeClause__Alternatives


    // $ANTLR start rule__ConcreteWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:841:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAbstractAliasWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:845:1: ( ( ruleParWhereEntry ) | ( ruleAbstractAliasWhereEntry ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==35) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("841:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAbstractAliasWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:846:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:846:1: ( ruleParWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:847:1: ruleParWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1787);
                    ruleParWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:852:6: ( ruleAbstractAliasWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:852:6: ( ruleAbstractAliasWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:853:1: ruleAbstractAliasWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getAbstractAliasWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAbstractAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1804);
                    ruleAbstractAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getAbstractAliasWhereEntryParserRuleCall_1()); 

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
    // $ANTLR end rule__ConcreteWhereEntry__Alternatives


    // $ANTLR start rule__AbstractAliasWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );
    public final void rule__AbstractAliasWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:867:1: ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==26) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case 37:
                                {
                                alt3=4;
                                }
                                break;
                            case RULE_STRING:
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                            case 11:
                            case 40:
                                {
                                alt3=1;
                                }
                                break;
                            case RULE_ID:
                                {
                                int LA3_10 = input.LA(6);

                                if ( (LA3_10==EOF||LA3_10==RULE_ID||(LA3_10>=33 && LA3_10<=34)||LA3_10==36) ) {
                                    alt3=2;
                                }
                                else if ( (LA3_10==26) ) {
                                    alt3=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 10, input);

                                    throw nvae;
                                }
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 5, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            int LA3_6 = input.LA(5);

                            if ( ((LA3_6>=RULE_STRING && LA3_6<=RULE_SINGED_LONG)||LA3_6==11||LA3_6==40) ) {
                                alt3=1;
                            }
                            else if ( (LA3_6==37) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 18:
                        case 19:
                            {
                            alt3=1;
                            }
                            break;
                        case 28:
                        case 39:
                            {
                            alt3=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_1==16) ) {
                    alt3=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("863:1: rule__AbstractAliasWhereEntry__Alternatives : ( ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:868:1: ( ruleAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:868:1: ( ruleAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:869:1: ruleAttributeWhereEntry
                    {
                     before(grammarAccess.getAbstractAliasWhereEntryAccess().getAttributeWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1836);
                    ruleAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAbstractAliasWhereEntryAccess().getAttributeWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:874:6: ( ruleReferenceWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:874:6: ( ruleReferenceWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:875:1: ruleReferenceWhereEntry
                    {
                     before(grammarAccess.getAbstractAliasWhereEntryAccess().getReferenceWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReferenceWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1853);
                    ruleReferenceWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAbstractAliasWhereEntryAccess().getReferenceWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:880:6: ( ruleAliasWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:880:6: ( ruleAliasWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:881:1: ruleAliasWhereEntry
                    {
                     before(grammarAccess.getAbstractAliasWhereEntryAccess().getAliasWhereEntryParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1870);
                    ruleAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAbstractAliasWhereEntryAccess().getAliasWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:886:6: ( ruleNullWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:886:6: ( ruleNullWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:887:1: ruleNullWhereEntry
                    {
                     before(grammarAccess.getAbstractAliasWhereEntryAccess().getNullWhereEntryParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1887);
                    ruleNullWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAbstractAliasWhereEntryAccess().getNullWhereEntryParserRuleCall_3()); 

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
    // $ANTLR end rule__AbstractAliasWhereEntry__Alternatives


    // $ANTLR start rule__AttributeWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );
    public final void rule__AttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:901:1: ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==26) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA4_4 = input.LA(5);

                            if ( ((LA4_4>=RULE_SIGNED_DOUBLE && LA4_4<=RULE_SINGED_LONG)) ) {
                                alt4=1;
                            }
                            else if ( (LA4_4==RULE_ID) ) {
                                alt4=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA4_5 = input.LA(5);

                            if ( ((LA4_5>=RULE_SIGNED_DOUBLE && LA4_5<=RULE_SINGED_LONG)) ) {
                                alt4=1;
                            }
                            else if ( (LA4_5==RULE_ID) ) {
                                alt4=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA4_6 = input.LA(5);

                            if ( ((LA4_6>=RULE_SIGNED_DOUBLE && LA4_6<=RULE_SINGED_LONG)) ) {
                                alt4=1;
                            }
                            else if ( (LA4_6==RULE_ID) ) {
                                alt4=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA4_7 = input.LA(5);

                            if ( (LA4_7==RULE_ID) ) {
                                alt4=4;
                            }
                            else if ( ((LA4_7>=RULE_SIGNED_DOUBLE && LA4_7<=RULE_SINGED_LONG)) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt4=1;
                                }
                                break;
                            case 11:
                            case 40:
                                {
                                alt4=3;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt4=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt4=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 8, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt4=1;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt4=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt4=4;
                                }
                                break;
                            case 11:
                            case 40:
                                {
                                alt4=3;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 9, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 18:
                        case 19:
                            {
                            alt4=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("897:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:902:1: ( ruleNumericAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:902:1: ( ruleNumericAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:903:1: ruleNumericAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1919);
                    ruleNumericAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:908:6: ( ruleStringAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:908:6: ( ruleStringAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:909:1: ruleStringAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1936);
                    ruleStringAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:914:6: ( ruleBooleanAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:914:6: ( ruleBooleanAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:915:1: ruleBooleanAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1953);
                    ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:920:6: ( ruleVariableWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:920:6: ( ruleVariableWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:921:1: ruleVariableWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1970);
                    ruleVariableWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 

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
    // $ANTLR end rule__AttributeWhereEntry__Alternatives


    // $ANTLR start rule__NumericAttributeWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );
    public final void rule__NumericAttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:935:1: ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==26) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA5_4 = input.LA(5);

                            if ( (LA5_4==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else if ( (LA5_4==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA5_5 = input.LA(5);

                            if ( (LA5_5==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else if ( (LA5_5==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA5_6 = input.LA(5);

                            if ( (LA5_6==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else if ( (LA5_6==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA5_7 = input.LA(5);

                            if ( (LA5_7==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else if ( (LA5_7==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            int LA5_8 = input.LA(5);

                            if ( (LA5_8==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else if ( (LA5_8==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA5_9 = input.LA(5);

                            if ( (LA5_9==RULE_SINGED_LONG) ) {
                                alt5=2;
                            }
                            else if ( (LA5_9==RULE_SIGNED_DOUBLE) ) {
                                alt5=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("931:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:936:1: ( ruleDoubleWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:936:1: ( ruleDoubleWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:937:1: ruleDoubleWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives2002);
                    ruleDoubleWhereEntry();
                    _fsp--;

                     after(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:942:6: ( ruleLongWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:942:6: ( ruleLongWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:943:1: ruleLongWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives2019);
                    ruleLongWhereEntry();
                    _fsp--;

                     after(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 

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
    // $ANTLR end rule__NumericAttributeWhereEntry__Alternatives


    // $ANTLR start rule__BooleanAttributeWhereEntry__Alternatives_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:953:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );
    public final void rule__BooleanAttributeWhereEntry__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:957:1: ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==40) ) {
                alt6=1;
            }
            else if ( (LA6_0==11) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("953:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:958:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:958:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:959:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:960:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:960:2: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_42051);
                    rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:964:6: ( 'false' )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:964:6: ( 'false' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:965:1: 'false'
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_42070); 
                     after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1()); 

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
    // $ANTLR end rule__BooleanAttributeWhereEntry__Alternatives_4


    // $ANTLR start rule__ReferenceWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:977:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );
    public final void rule__ReferenceWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:981:1: ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==26) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==RULE_ID) ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==16) ) {
                            alt7=1;
                        }
                        else if ( (LA7_3==28||LA7_3==39) ) {
                            alt7=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("977:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 7, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("977:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("977:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("977:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:1: ( ruleReferenceAliasWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:1: ( ruleReferenceAliasWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:983:1: ruleReferenceAliasWhereEntry
                    {
                     before(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2104);
                    ruleReferenceAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:988:6: ( ruleSubselectWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:988:6: ( ruleSubselectWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:989:1: ruleSubselectWhereEntry
                    {
                     before(grammarAccess.getReferenceWhereEntryAccess().getSubselectWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2121);
                    ruleSubselectWhereEntry();
                    _fsp--;

                     after(grammarAccess.getReferenceWhereEntryAccess().getSubselectWhereEntryParserRuleCall_1()); 

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
    // $ANTLR end rule__ReferenceWhereEntry__Alternatives


    // $ANTLR start rule__NumericOperator__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:999:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1003:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt8=1;
                }
                break;
            case 13:
                {
                alt8=2;
                }
                break;
            case 14:
                {
                alt8=3;
                }
                break;
            case 15:
                {
                alt8=4;
                }
                break;
            case 16:
                {
                alt8=5;
                }
                break;
            case 17:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("999:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1004:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1004:1: ( ( '<' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1005:1: ( '<' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1006:1: ( '<' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1006:3: '<'
                    {
                    match(input,12,FOLLOW_12_in_rule__NumericOperator__Alternatives2154); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1011:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1011:6: ( ( '>' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1012:1: ( '>' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1013:1: ( '>' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1013:3: '>'
                    {
                    match(input,13,FOLLOW_13_in_rule__NumericOperator__Alternatives2175); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1018:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1018:6: ( ( '<=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1019:1: ( '<=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:1: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:3: '<='
                    {
                    match(input,14,FOLLOW_14_in_rule__NumericOperator__Alternatives2196); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1025:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1025:6: ( ( '>=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1026:1: ( '>=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1027:1: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1027:3: '>='
                    {
                    match(input,15,FOLLOW_15_in_rule__NumericOperator__Alternatives2217); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1032:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1032:6: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1033:1: ( '=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1034:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1034:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__NumericOperator__Alternatives2238); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1039:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1039:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1040:1: ( '!=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1041:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1041:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__NumericOperator__Alternatives2259); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 

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
    // $ANTLR end rule__NumericOperator__Alternatives


    // $ANTLR start rule__StringOperator__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1051:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );
    public final void rule__StringOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1055:1: ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt9=1;
                }
                break;
            case 17:
                {
                alt9=2;
                }
                break;
            case 18:
                {
                alt9=3;
                }
                break;
            case 19:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1051:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1056:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1056:1: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1057:1: ( '=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1058:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1058:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__StringOperator__Alternatives2295); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1063:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1063:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1064:1: ( '!=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1065:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1065:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__StringOperator__Alternatives2316); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1070:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1070:6: ( ( 'like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1071:1: ( 'like' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1072:1: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1072:3: 'like'
                    {
                    match(input,18,FOLLOW_18_in_rule__StringOperator__Alternatives2337); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1077:6: ( ( 'notlike' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1077:6: ( ( 'notlike' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1078:1: ( 'notlike' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:1: ( 'notlike' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:3: 'notlike'
                    {
                    match(input,19,FOLLOW_19_in_rule__StringOperator__Alternatives2358); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 

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
    // $ANTLR end rule__StringOperator__Alternatives


    // $ANTLR start rule__BooleanOperator__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1089:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__BooleanOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1093:1: ( ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            else if ( (LA10_0==17) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1089:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1094:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1094:1: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1095:1: ( '=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1096:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1096:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__BooleanOperator__Alternatives2394); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1101:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1101:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1102:1: ( '!=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1103:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1103:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__BooleanOperator__Alternatives2415); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

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
    // $ANTLR end rule__BooleanOperator__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1115:1: rule__Model__Group__0 : ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1119:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1120:1: ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1120:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1121:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1122:1: ( rule__Model__ImportsAssignment_0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1122:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02452);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02462);
            rule__Model__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1133:1: rule__Model__Group__1 : ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1137:1: ( ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1138:1: ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1138:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1139:1: ( rule__Model__DefaultQueryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1140:1: ( rule__Model__DefaultQueryAssignment_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1140:2: rule__Model__DefaultQueryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__12490);
                    rule__Model__DefaultQueryAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12500);
            rule__Model__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1151:1: rule__Model__Group__2 : ( ( rule__Model__NamedQueriesAssignment_2 )* ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1155:1: ( ( ( rule__Model__NamedQueriesAssignment_2 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1156:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1156:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1157:1: ( rule__Model__NamedQueriesAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1158:1: ( rule__Model__NamedQueriesAssignment_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1158:2: rule__Model__NamedQueriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22528);
            	    rule__Model__NamedQueriesAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1174:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1178:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1179:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1179:1: ( 'import' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1180:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Import__Group__02570); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02580);
            rule__Import__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1194:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1198:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1199:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1199:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1200:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1201:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1201:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12608);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__NamedQuery__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1215:1: rule__NamedQuery__Group__0 : ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 ;
    public final void rule__NamedQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1219:1: ( ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1220:1: ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1220:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1221:1: ( rule__NamedQuery__NameAssignment_0 )
            {
             before(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1222:1: ( rule__NamedQuery__NameAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1222:2: rule__NamedQuery__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02646);
            rule__NamedQuery__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02655);
            rule__NamedQuery__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__Group__0


    // $ANTLR start rule__NamedQuery__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1233:1: rule__NamedQuery__Group__1 : ( ':' ) rule__NamedQuery__Group__2 ;
    public final void rule__NamedQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1237:1: ( ( ':' ) rule__NamedQuery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1238:1: ( ':' ) rule__NamedQuery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1238:1: ( ':' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1239:1: ':'
            {
             before(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__NamedQuery__Group__12684); 
             after(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12694);
            rule__NamedQuery__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__Group__1


    // $ANTLR start rule__NamedQuery__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1253:1: rule__NamedQuery__Group__2 : ( ( rule__NamedQuery__QueryAssignment_2 ) ) ;
    public final void rule__NamedQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1257:1: ( ( ( rule__NamedQuery__QueryAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1259:1: ( rule__NamedQuery__QueryAssignment_2 )
            {
             before(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1260:1: ( rule__NamedQuery__QueryAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1260:2: rule__NamedQuery__QueryAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22722);
            rule__NamedQuery__QueryAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__Group__2


    // $ANTLR start rule__MQLquery__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1276:1: rule__MQLquery__Group__0 : ( 'select' ) rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1280:1: ( ( 'select' ) rule__MQLquery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1281:1: ( 'select' ) rule__MQLquery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1281:1: ( 'select' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1282:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MQLquery__Group__02763); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02773);
            rule__MQLquery__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__0


    // $ANTLR start rule__MQLquery__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1296:1: rule__MQLquery__Group__1 : ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1300:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1301:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1301:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1302:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1303:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1303:2: rule__MQLquery__SelectEntriesAssignment_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12801);
            rule__MQLquery__SelectEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12810);
            rule__MQLquery__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__1


    // $ANTLR start rule__MQLquery__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1314:1: rule__MQLquery__Group__2 : ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1318:1: ( ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1319:1: ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1319:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1320:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1321:1: ( rule__MQLquery__Group_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1321:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22838);
            	    rule__MQLquery__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22848);
            rule__MQLquery__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__2


    // $ANTLR start rule__MQLquery__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1332:1: rule__MQLquery__Group__3 : ( 'from' ) rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1336:1: ( ( 'from' ) rule__MQLquery__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1337:1: ( 'from' ) rule__MQLquery__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1337:1: ( 'from' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1338:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__MQLquery__Group__32877); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32887);
            rule__MQLquery__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__3


    // $ANTLR start rule__MQLquery__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1352:1: rule__MQLquery__Group__4 : ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1356:1: ( ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1357:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1357:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1358:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1359:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1359:2: rule__MQLquery__FromEntriesAssignment_4
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42915);
            rule__MQLquery__FromEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42924);
            rule__MQLquery__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__4


    // $ANTLR start rule__MQLquery__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1370:1: rule__MQLquery__Group__5 : ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1374:1: ( ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1375:1: ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1375:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1376:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1377:1: ( rule__MQLquery__Group_5__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==24) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1377:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52952);
            	    rule__MQLquery__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52962);
            rule__MQLquery__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__5


    // $ANTLR start rule__MQLquery__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1388:1: rule__MQLquery__Group__6 : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1392:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1393:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1393:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1394:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1395:1: ( rule__MQLquery__Group_6__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1395:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62990);
                    rule__MQLquery__Group_6__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMQLqueryAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__6


    // $ANTLR start rule__MQLquery__Group_2__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1419:1: rule__MQLquery__Group_2__0 : ( ',' ) rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1423:1: ( ( ',' ) rule__MQLquery__Group_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1424:1: ( ',' ) rule__MQLquery__Group_2__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1424:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1425:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group_2__03040); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__03050);
            rule__MQLquery__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_2__0


    // $ANTLR start rule__MQLquery__Group_2__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1439:1: rule__MQLquery__Group_2__1 : ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1443:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1444:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1444:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1445:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1446:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1446:2: rule__MQLquery__SelectEntriesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__13078);
            rule__MQLquery__SelectEntriesAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_2__1


    // $ANTLR start rule__MQLquery__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1460:1: rule__MQLquery__Group_5__0 : ( ',' ) rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1464:1: ( ( ',' ) rule__MQLquery__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1465:1: ( ',' ) rule__MQLquery__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1465:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1466:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group_5__03117); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03127);
            rule__MQLquery__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_5__0


    // $ANTLR start rule__MQLquery__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1480:1: rule__MQLquery__Group_5__1 : ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1484:1: ( ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1485:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1485:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1486:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1487:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1487:2: rule__MQLquery__FromEntriesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__13155);
            rule__MQLquery__FromEntriesAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_5__1


    // $ANTLR start rule__MQLquery__Group_6__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1501:1: rule__MQLquery__Group_6__0 : ( 'where' ) rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1505:1: ( ( 'where' ) rule__MQLquery__Group_6__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:1: ( 'where' ) rule__MQLquery__Group_6__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:1: ( 'where' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1507:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,25,FOLLOW_25_in_rule__MQLquery__Group_6__03194); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03204);
            rule__MQLquery__Group_6__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_6__0


    // $ANTLR start rule__MQLquery__Group_6__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1521:1: rule__MQLquery__Group_6__1 : ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1525:1: ( ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1526:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1526:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1527:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1528:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1528:2: rule__MQLquery__WhereEntryAssignment_6_1
            {
            pushFollow(FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__13232);
            rule__MQLquery__WhereEntryAssignment_6_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_6__1


    // $ANTLR start rule__SelectEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1542:1: rule__SelectEntry__Group__0 : ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1546:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1547:1: ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1547:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1548:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1549:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1549:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__03270);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03279);
            rule__SelectEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group__0


    // $ANTLR start rule__SelectEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1560:1: rule__SelectEntry__Group__1 : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1564:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1566:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1567:1: ( rule__SelectEntry__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1567:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__13307);
                    rule__SelectEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSelectEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group__1


    // $ANTLR start rule__SelectEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1581:1: rule__SelectEntry__Group_1__0 : ( '.' ) rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1585:1: ( ( '.' ) rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1586:1: ( '.' ) rule__SelectEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1586:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1587:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,26,FOLLOW_26_in_rule__SelectEntry__Group_1__03347); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03357);
            rule__SelectEntry__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group_1__0


    // $ANTLR start rule__SelectEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1601:1: rule__SelectEntry__Group_1__1 : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1605:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1606:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1606:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1607:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1608:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1608:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13385);
            rule__SelectEntry__AttributeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group_1__1


    // $ANTLR start rule__FromEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1622:1: rule__FromEntry__Group__0 : ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1626:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1627:1: ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1627:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1628:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1629:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1629:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03423);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03432);
            rule__FromEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__0


    // $ANTLR start rule__FromEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1640:1: rule__FromEntry__Group__1 : ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1644:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1645:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1645:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1646:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1647:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1647:2: rule__FromEntry__WithoutsubtypesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13460);
                    rule__FromEntry__WithoutsubtypesAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13470);
            rule__FromEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__1


    // $ANTLR start rule__FromEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1658:1: rule__FromEntry__Group__2 : ( 'as' ) rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1662:1: ( ( 'as' ) rule__FromEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1663:1: ( 'as' ) rule__FromEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1663:1: ( 'as' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1664:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__FromEntry__Group__23499); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23509);
            rule__FromEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__2


    // $ANTLR start rule__FromEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1678:1: rule__FromEntry__Group__3 : ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1682:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1683:1: ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1683:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1684:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1685:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1685:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33537);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33546);
            rule__FromEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__3


    // $ANTLR start rule__FromEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1696:1: rule__FromEntry__Group__4 : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1700:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1701:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1701:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1702:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1703:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28||LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1703:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43574);
                    rule__FromEntry__ScopeClauseAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__4


    // $ANTLR start rule__ResourceScope__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1723:1: rule__ResourceScope__Group__0 : ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1727:1: ( ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1728:1: ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1728:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1729:1: ( rule__ResourceScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1730:1: ( rule__ResourceScope__NotInAssignment_0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1730:2: rule__ResourceScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03619);
                    rule__ResourceScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03629);
            rule__ResourceScope__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__0


    // $ANTLR start rule__ResourceScope__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1741:1: rule__ResourceScope__Group__1 : ( 'in' ) rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1745:1: ( ( 'in' ) rule__ResourceScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1746:1: ( 'in' ) rule__ResourceScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1746:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1747:1: 'in'
            {
             before(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ResourceScope__Group__13658); 
             after(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13668);
            rule__ResourceScope__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__1


    // $ANTLR start rule__ResourceScope__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1761:1: rule__ResourceScope__Group__2 : ( 'resources' ) rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1765:1: ( ( 'resources' ) rule__ResourceScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1766:1: ( 'resources' ) rule__ResourceScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1766:1: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1767:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__ResourceScope__Group__23697); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23707);
            rule__ResourceScope__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__2


    // $ANTLR start rule__ResourceScope__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1781:1: rule__ResourceScope__Group__3 : ( '{' ) rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1785:1: ( ( '{' ) rule__ResourceScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1786:1: ( '{' ) rule__ResourceScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1786:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1787:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ResourceScope__Group__33736); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33746);
            rule__ResourceScope__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__3


    // $ANTLR start rule__ResourceScope__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1801:1: rule__ResourceScope__Group__4 : ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1805:1: ( ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1806:1: ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1806:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1807:1: ( rule__ResourceScope__UrisAssignment_4 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1808:1: ( rule__ResourceScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1808:2: rule__ResourceScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43774);
            rule__ResourceScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43783);
            rule__ResourceScope__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__4


    // $ANTLR start rule__ResourceScope__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1819:1: rule__ResourceScope__Group__5 : ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 ;
    public final void rule__ResourceScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1823:1: ( ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1824:1: ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1824:1: ( ( rule__ResourceScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1825:1: ( rule__ResourceScope__Group_5__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1826:1: ( rule__ResourceScope__Group_5__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==24) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1826:2: rule__ResourceScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53811);
            	    rule__ResourceScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getResourceScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53821);
            rule__ResourceScope__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__5


    // $ANTLR start rule__ResourceScope__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1837:1: rule__ResourceScope__Group__6 : ( '}' ) ;
    public final void rule__ResourceScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1841:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1842:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1842:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1843:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ResourceScope__Group__63850); 
             after(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__6


    // $ANTLR start rule__ResourceScope__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1870:1: rule__ResourceScope__Group_5__0 : ( ',' ) rule__ResourceScope__Group_5__1 ;
    public final void rule__ResourceScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1874:1: ( ( ',' ) rule__ResourceScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1875:1: ( ',' ) rule__ResourceScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1875:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1876:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__ResourceScope__Group_5__03900); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03910);
            rule__ResourceScope__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group_5__0


    // $ANTLR start rule__ResourceScope__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1890:1: rule__ResourceScope__Group_5__1 : ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ResourceScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1894:1: ( ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1895:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1895:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1896:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1897:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1897:2: rule__ResourceScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13938);
            rule__ResourceScope__UrisAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group_5__1


    // $ANTLR start rule__ElementScope__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1911:1: rule__ElementScope__Group__0 : ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1915:1: ( ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1916:1: ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1916:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1917:1: ( rule__ElementScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1918:1: ( rule__ElementScope__NotInAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1918:2: rule__ElementScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03976);
                    rule__ElementScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03986);
            rule__ElementScope__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__0


    // $ANTLR start rule__ElementScope__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1929:1: rule__ElementScope__Group__1 : ( 'in' ) rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1933:1: ( ( 'in' ) rule__ElementScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1934:1: ( 'in' ) rule__ElementScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1934:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1935:1: 'in'
            {
             before(grammarAccess.getElementScopeAccess().getInKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ElementScope__Group__14015); 
             after(grammarAccess.getElementScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14025);
            rule__ElementScope__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__1


    // $ANTLR start rule__ElementScope__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1949:1: rule__ElementScope__Group__2 : ( 'elements' ) rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1953:1: ( ( 'elements' ) rule__ElementScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1954:1: ( 'elements' ) rule__ElementScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1954:1: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1955:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ElementScope__Group__24054); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24064);
            rule__ElementScope__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__2


    // $ANTLR start rule__ElementScope__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1969:1: rule__ElementScope__Group__3 : ( '{' ) rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1973:1: ( ( '{' ) rule__ElementScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1974:1: ( '{' ) rule__ElementScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1974:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1975:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ElementScope__Group__34093); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34103);
            rule__ElementScope__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__3


    // $ANTLR start rule__ElementScope__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1989:1: rule__ElementScope__Group__4 : ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1993:1: ( ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1994:1: ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1994:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1995:1: ( rule__ElementScope__UrisAssignment_4 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1996:1: ( rule__ElementScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1996:2: rule__ElementScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__44131);
            rule__ElementScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__44140);
            rule__ElementScope__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__4


    // $ANTLR start rule__ElementScope__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2007:1: rule__ElementScope__Group__5 : ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 ;
    public final void rule__ElementScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2011:1: ( ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2012:1: ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2012:1: ( ( rule__ElementScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2013:1: ( rule__ElementScope__Group_5__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2014:1: ( rule__ElementScope__Group_5__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2014:2: rule__ElementScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__54168);
            	    rule__ElementScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getElementScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__54178);
            rule__ElementScope__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__5


    // $ANTLR start rule__ElementScope__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2025:1: rule__ElementScope__Group__6 : ( '}' ) ;
    public final void rule__ElementScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2029:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2030:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2030:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2031:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ElementScope__Group__64207); 
             after(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__6


    // $ANTLR start rule__ElementScope__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2058:1: rule__ElementScope__Group_5__0 : ( ',' ) rule__ElementScope__Group_5__1 ;
    public final void rule__ElementScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2062:1: ( ( ',' ) rule__ElementScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2063:1: ( ',' ) rule__ElementScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2063:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2064:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__ElementScope__Group_5__04257); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04267);
            rule__ElementScope__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group_5__0


    // $ANTLR start rule__ElementScope__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2078:1: rule__ElementScope__Group_5__1 : ( ( rule__ElementScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ElementScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2082:1: ( ( ( rule__ElementScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2083:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2083:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2084:1: ( rule__ElementScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2085:1: ( rule__ElementScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2085:2: rule__ElementScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14295);
            rule__ElementScope__UrisAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group_5__1


    // $ANTLR start rule__WhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2099:1: rule__WhereEntry__Group__0 : ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2103:1: ( ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2104:1: ( ruleAndWhereEntry ) rule__WhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2104:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2105:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04333);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04341);
            rule__WhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group__0


    // $ANTLR start rule__WhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2117:1: rule__WhereEntry__Group__1 : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2121:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2122:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2122:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2123:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2124:1: ( rule__WhereEntry__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2124:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14369);
                    rule__WhereEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group__1


    // $ANTLR start rule__WhereEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2138:1: rule__WhereEntry__Group_1__0 : ( () ) rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2142:1: ( ( () ) rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2143:1: ( () ) rule__WhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2143:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2144:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2145:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2147:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04418);
            rule__WhereEntry__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1__0


    // $ANTLR start rule__WhereEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2158:1: rule__WhereEntry__Group_1__1 : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2162:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2163:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2163:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2164:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2164:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2165:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2166:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2166:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14448);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2169:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2170:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2171:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==33) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2171:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14460);
            	    rule__WhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1__1


    // $ANTLR start rule__WhereEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2186:1: rule__WhereEntry__Group_1_1__0 : ( 'or' ) rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2190:1: ( ( 'or' ) rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2191:1: ( 'or' ) rule__WhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2191:1: ( 'or' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2192:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,33,FOLLOW_33_in_rule__WhereEntry__Group_1_1__04502); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04512);
            rule__WhereEntry__Group_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1_1__0


    // $ANTLR start rule__WhereEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2206:1: rule__WhereEntry__Group_1_1__1 : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2210:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2211:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2211:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2212:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2213:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2213:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14540);
            rule__WhereEntry__EntriesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1_1__1


    // $ANTLR start rule__AndWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2227:1: rule__AndWhereEntry__Group__0 : ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2231:1: ( ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2232:1: ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2232:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2233:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04578);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04586);
            rule__AndWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group__0


    // $ANTLR start rule__AndWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2245:1: rule__AndWhereEntry__Group__1 : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2249:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2250:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2250:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2251:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2252:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2252:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14614);
                    rule__AndWhereEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group__1


    // $ANTLR start rule__AndWhereEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2266:1: rule__AndWhereEntry__Group_1__0 : ( () ) rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2270:1: ( ( () ) rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2271:1: ( () ) rule__AndWhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2271:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2272:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2273:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2275:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04663);
            rule__AndWhereEntry__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1__0


    // $ANTLR start rule__AndWhereEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2286:1: rule__AndWhereEntry__Group_1__1 : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2290:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2291:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2291:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2292:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2292:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2293:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2294:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2294:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14693);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2297:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2298:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2299:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==34) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2299:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14705);
            	    rule__AndWhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2314:1: rule__AndWhereEntry__Group_1_1__0 : ( 'and' ) rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2318:1: ( ( 'and' ) rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2319:1: ( 'and' ) rule__AndWhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2319:1: ( 'and' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2320:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__AndWhereEntry__Group_1_1__04747); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04757);
            rule__AndWhereEntry__Group_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1_1__0


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2334:1: rule__AndWhereEntry__Group_1_1__1 : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2338:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2339:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2339:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2340:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2341:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2341:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14785);
            rule__AndWhereEntry__EntriesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1


    // $ANTLR start rule__ParWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2355:1: rule__ParWhereEntry__Group__0 : ( '(' ) rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2359:1: ( ( '(' ) rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2360:1: ( '(' ) rule__ParWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2360:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2361:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ParWhereEntry__Group__04824); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04834);
            rule__ParWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__0


    // $ANTLR start rule__ParWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2375:1: rule__ParWhereEntry__Group__1 : ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2379:1: ( ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2380:1: ( ruleWhereEntry ) rule__ParWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2380:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2381:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14862);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14870);
            rule__ParWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__1


    // $ANTLR start rule__ParWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2393:1: rule__ParWhereEntry__Group__2 : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2397:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2398:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2398:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2399:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,36,FOLLOW_36_in_rule__ParWhereEntry__Group__24899); 
             after(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__2


    // $ANTLR start rule__DoubleWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2418:1: rule__DoubleWhereEntry__Group__0 : ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 ;
    public final void rule__DoubleWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2422:1: ( ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2423:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2423:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2424:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2425:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2425:2: rule__DoubleWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04940);
            rule__DoubleWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04949);
            rule__DoubleWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__0


    // $ANTLR start rule__DoubleWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2436:1: rule__DoubleWhereEntry__Group__1 : ( '.' ) rule__DoubleWhereEntry__Group__2 ;
    public final void rule__DoubleWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2440:1: ( ( '.' ) rule__DoubleWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2441:1: ( '.' ) rule__DoubleWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2441:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2442:1: '.'
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__DoubleWhereEntry__Group__14978); 
             after(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14988);
            rule__DoubleWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__1


    // $ANTLR start rule__DoubleWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2456:1: rule__DoubleWhereEntry__Group__2 : ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 ;
    public final void rule__DoubleWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2460:1: ( ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2461:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2461:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2462:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2463:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2463:2: rule__DoubleWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__25016);
            rule__DoubleWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__25025);
            rule__DoubleWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__2


    // $ANTLR start rule__DoubleWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2474:1: rule__DoubleWhereEntry__Group__3 : ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 ;
    public final void rule__DoubleWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2478:1: ( ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2479:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2479:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2480:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2481:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2481:2: rule__DoubleWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__35053);
            rule__DoubleWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__35062);
            rule__DoubleWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__3


    // $ANTLR start rule__DoubleWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2492:1: rule__DoubleWhereEntry__Group__4 : ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__DoubleWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2496:1: ( ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2497:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2497:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2498:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2499:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2499:2: rule__DoubleWhereEntry__ValueAssignment_4
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__45090);
            rule__DoubleWhereEntry__ValueAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__Group__4


    // $ANTLR start rule__LongWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2519:1: rule__LongWhereEntry__Group__0 : ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 ;
    public final void rule__LongWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2523:1: ( ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2524:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2524:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2525:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2526:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2526:2: rule__LongWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__05134);
            rule__LongWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__05143);
            rule__LongWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__0


    // $ANTLR start rule__LongWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2537:1: rule__LongWhereEntry__Group__1 : ( '.' ) rule__LongWhereEntry__Group__2 ;
    public final void rule__LongWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2541:1: ( ( '.' ) rule__LongWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2542:1: ( '.' ) rule__LongWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2542:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2543:1: '.'
            {
             before(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__LongWhereEntry__Group__15172); 
             after(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__15182);
            rule__LongWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__1


    // $ANTLR start rule__LongWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2557:1: rule__LongWhereEntry__Group__2 : ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 ;
    public final void rule__LongWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2561:1: ( ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2562:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2562:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2563:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2564:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2564:2: rule__LongWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__25210);
            rule__LongWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__25219);
            rule__LongWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__2


    // $ANTLR start rule__LongWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2575:1: rule__LongWhereEntry__Group__3 : ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 ;
    public final void rule__LongWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2579:1: ( ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2580:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2580:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2581:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2582:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2582:2: rule__LongWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__35247);
            rule__LongWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__35256);
            rule__LongWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__3


    // $ANTLR start rule__LongWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2593:1: rule__LongWhereEntry__Group__4 : ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__LongWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2597:1: ( ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2598:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2598:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2599:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2600:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2600:2: rule__LongWhereEntry__ValueAssignment_4
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__45284);
            rule__LongWhereEntry__ValueAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__Group__4


    // $ANTLR start rule__VariableWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2620:1: rule__VariableWhereEntry__Group__0 : ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 ;
    public final void rule__VariableWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2624:1: ( ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2625:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2625:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2626:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2627:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2627:2: rule__VariableWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__05328);
            rule__VariableWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__05337);
            rule__VariableWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__0


    // $ANTLR start rule__VariableWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2638:1: rule__VariableWhereEntry__Group__1 : ( '.' ) rule__VariableWhereEntry__Group__2 ;
    public final void rule__VariableWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2642:1: ( ( '.' ) rule__VariableWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2643:1: ( '.' ) rule__VariableWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2643:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2644:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__VariableWhereEntry__Group__15366); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15376);
            rule__VariableWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__1


    // $ANTLR start rule__VariableWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2658:1: rule__VariableWhereEntry__Group__2 : ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 ;
    public final void rule__VariableWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2662:1: ( ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2663:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2663:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2664:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2665:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2665:2: rule__VariableWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25404);
            rule__VariableWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25413);
            rule__VariableWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__2


    // $ANTLR start rule__VariableWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2676:1: rule__VariableWhereEntry__Group__3 : ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 ;
    public final void rule__VariableWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2680:1: ( ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2681:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2681:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2682:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2683:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2683:2: rule__VariableWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35441);
            rule__VariableWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35450);
            rule__VariableWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__3


    // $ANTLR start rule__VariableWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2694:1: rule__VariableWhereEntry__Group__4 : ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 ;
    public final void rule__VariableWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2698:1: ( ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2699:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2699:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2700:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2701:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2701:2: rule__VariableWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45478);
            rule__VariableWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45487);
            rule__VariableWhereEntry__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__4


    // $ANTLR start rule__VariableWhereEntry__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2712:1: rule__VariableWhereEntry__Group__5 : ( '.' ) rule__VariableWhereEntry__Group__6 ;
    public final void rule__VariableWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2716:1: ( ( '.' ) rule__VariableWhereEntry__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2717:1: ( '.' ) rule__VariableWhereEntry__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2717:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2718:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 
            match(input,26,FOLLOW_26_in_rule__VariableWhereEntry__Group__55516); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55526);
            rule__VariableWhereEntry__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__5


    // $ANTLR start rule__VariableWhereEntry__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2732:1: rule__VariableWhereEntry__Group__6 : ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) ;
    public final void rule__VariableWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2736:1: ( ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2737:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2737:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2738:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2739:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2739:2: rule__VariableWhereEntry__RightAttributeAssignment_6
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65554);
            rule__VariableWhereEntry__RightAttributeAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__Group__6


    // $ANTLR start rule__StringAttributeWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2763:1: rule__StringAttributeWhereEntry__Group__0 : ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 ;
    public final void rule__StringAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2767:1: ( ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2768:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2768:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2769:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2770:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2770:2: rule__StringAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05602);
            rule__StringAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05611);
            rule__StringAttributeWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__0


    // $ANTLR start rule__StringAttributeWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2781:1: rule__StringAttributeWhereEntry__Group__1 : ( '.' ) rule__StringAttributeWhereEntry__Group__2 ;
    public final void rule__StringAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2785:1: ( ( '.' ) rule__StringAttributeWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2786:1: ( '.' ) rule__StringAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2786:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2787:1: '.'
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__StringAttributeWhereEntry__Group__15640); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15650);
            rule__StringAttributeWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__1


    // $ANTLR start rule__StringAttributeWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2801:1: rule__StringAttributeWhereEntry__Group__2 : ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 ;
    public final void rule__StringAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2805:1: ( ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2806:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2806:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2807:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2808:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2808:2: rule__StringAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25678);
            rule__StringAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25687);
            rule__StringAttributeWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__2


    // $ANTLR start rule__StringAttributeWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2819:1: rule__StringAttributeWhereEntry__Group__3 : ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 ;
    public final void rule__StringAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2823:1: ( ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2824:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2824:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2825:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2826:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2826:2: rule__StringAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35715);
            rule__StringAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35724);
            rule__StringAttributeWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__3


    // $ANTLR start rule__StringAttributeWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2837:1: rule__StringAttributeWhereEntry__Group__4 : ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2841:1: ( ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2842:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2842:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2843:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2844:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2844:2: rule__StringAttributeWhereEntry__PatternAssignment_4
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45752);
            rule__StringAttributeWhereEntry__PatternAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__Group__4


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2864:1: rule__BooleanAttributeWhereEntry__Group__0 : ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 ;
    public final void rule__BooleanAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2868:1: ( ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2869:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2869:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2870:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2871:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2871:2: rule__BooleanAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05796);
            rule__BooleanAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05805);
            rule__BooleanAttributeWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__0


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2882:1: rule__BooleanAttributeWhereEntry__Group__1 : ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 ;
    public final void rule__BooleanAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2886:1: ( ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2887:1: ( '.' ) rule__BooleanAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2887:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2888:1: '.'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__BooleanAttributeWhereEntry__Group__15834); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15844);
            rule__BooleanAttributeWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__1


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2902:1: rule__BooleanAttributeWhereEntry__Group__2 : ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 ;
    public final void rule__BooleanAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2906:1: ( ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2907:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2907:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2908:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2909:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2909:2: rule__BooleanAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25872);
            rule__BooleanAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25881);
            rule__BooleanAttributeWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__2


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2920:1: rule__BooleanAttributeWhereEntry__Group__3 : ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 ;
    public final void rule__BooleanAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2924:1: ( ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2925:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2925:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2926:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2927:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2927:2: rule__BooleanAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35909);
            rule__BooleanAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35918);
            rule__BooleanAttributeWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__3


    // $ANTLR start rule__BooleanAttributeWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2938:1: rule__BooleanAttributeWhereEntry__Group__4 : ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2942:1: ( ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2943:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2943:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2944:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2945:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2945:2: rule__BooleanAttributeWhereEntry__Alternatives_4
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45946);
            rule__BooleanAttributeWhereEntry__Alternatives_4();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__Group__4


    // $ANTLR start rule__NullWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2965:1: rule__NullWhereEntry__Group__0 : ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 ;
    public final void rule__NullWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2969:1: ( ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2970:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2970:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2971:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2972:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2972:2: rule__NullWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05990);
            rule__NullWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05999);
            rule__NullWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__0


    // $ANTLR start rule__NullWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2983:1: rule__NullWhereEntry__Group__1 : ( '.' ) rule__NullWhereEntry__Group__2 ;
    public final void rule__NullWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2987:1: ( ( '.' ) rule__NullWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2988:1: ( '.' ) rule__NullWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2988:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2989:1: '.'
            {
             before(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__NullWhereEntry__Group__16028); 
             after(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__16038);
            rule__NullWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__1


    // $ANTLR start rule__NullWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3003:1: rule__NullWhereEntry__Group__2 : ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 ;
    public final void rule__NullWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3007:1: ( ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3008:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3008:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3009:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3010:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3010:2: rule__NullWhereEntry__FeatureAssignment_2
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__26066);
            rule__NullWhereEntry__FeatureAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__26075);
            rule__NullWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__2


    // $ANTLR start rule__NullWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3021:1: rule__NullWhereEntry__Group__3 : ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 ;
    public final void rule__NullWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3025:1: ( ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3026:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3026:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3027:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3028:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3028:2: rule__NullWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__36103);
            rule__NullWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__36112);
            rule__NullWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__3


    // $ANTLR start rule__NullWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3039:1: rule__NullWhereEntry__Group__4 : ( 'null' ) ;
    public final void rule__NullWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3043:1: ( ( 'null' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3044:1: ( 'null' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3044:1: ( 'null' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3045:1: 'null'
            {
             before(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 
            match(input,37,FOLLOW_37_in_rule__NullWhereEntry__Group__46141); 
             after(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__Group__4


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3068:1: rule__ReferenceAliasWhereEntry__Group__0 : ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 ;
    public final void rule__ReferenceAliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3072:1: ( ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3073:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3073:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3074:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3075:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3075:2: rule__ReferenceAliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__06186);
            rule__ReferenceAliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__06195);
            rule__ReferenceAliasWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__0


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3086:1: rule__ReferenceAliasWhereEntry__Group__1 : ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 ;
    public final void rule__ReferenceAliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3090:1: ( ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3091:1: ( '.' ) rule__ReferenceAliasWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3091:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3092:1: '.'
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__ReferenceAliasWhereEntry__Group__16224); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__16234);
            rule__ReferenceAliasWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__1


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3106:1: rule__ReferenceAliasWhereEntry__Group__2 : ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 ;
    public final void rule__ReferenceAliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3110:1: ( ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3111:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3111:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3112:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3113:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3113:2: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__26262);
            rule__ReferenceAliasWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__26271);
            rule__ReferenceAliasWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__2


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3124:1: rule__ReferenceAliasWhereEntry__Group__3 : ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 ;
    public final void rule__ReferenceAliasWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3128:1: ( ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3129:1: ( '=' ) rule__ReferenceAliasWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3129:1: ( '=' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3130:1: '='
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__36300); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__36310);
            rule__ReferenceAliasWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__3


    // $ANTLR start rule__ReferenceAliasWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3144:1: rule__ReferenceAliasWhereEntry__Group__4 : ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3148:1: ( ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3149:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3149:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3150:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3151:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3151:2: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__46338);
            rule__ReferenceAliasWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__Group__4


    // $ANTLR start rule__SubselectWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3171:1: rule__SubselectWhereEntry__Group__0 : ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 ;
    public final void rule__SubselectWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3175:1: ( ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3176:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3176:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3177:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3178:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3178:2: rule__SubselectWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06382);
            rule__SubselectWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06391);
            rule__SubselectWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__0


    // $ANTLR start rule__SubselectWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3189:1: rule__SubselectWhereEntry__Group__1 : ( '.' ) rule__SubselectWhereEntry__Group__2 ;
    public final void rule__SubselectWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3193:1: ( ( '.' ) rule__SubselectWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3194:1: ( '.' ) rule__SubselectWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3194:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3195:1: '.'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__SubselectWhereEntry__Group__16420); 
             after(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16430);
            rule__SubselectWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__1


    // $ANTLR start rule__SubselectWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3209:1: rule__SubselectWhereEntry__Group__2 : ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 ;
    public final void rule__SubselectWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3213:1: ( ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3214:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3214:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3215:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3216:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3216:2: rule__SubselectWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26458);
            rule__SubselectWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26467);
            rule__SubselectWhereEntry__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__2


    // $ANTLR start rule__SubselectWhereEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3227:1: rule__SubselectWhereEntry__Group__3 : ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 ;
    public final void rule__SubselectWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3231:1: ( ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3232:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3232:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3233:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3234:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3234:2: rule__SubselectWhereEntry__NotInAssignment_3
                    {
                    pushFollow(FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36495);
                    rule__SubselectWhereEntry__NotInAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36505);
            rule__SubselectWhereEntry__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__3


    // $ANTLR start rule__SubselectWhereEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3245:1: rule__SubselectWhereEntry__Group__4 : ( 'in' ) rule__SubselectWhereEntry__Group__5 ;
    public final void rule__SubselectWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3249:1: ( ( 'in' ) rule__SubselectWhereEntry__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3250:1: ( 'in' ) rule__SubselectWhereEntry__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3250:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3251:1: 'in'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SubselectWhereEntry__Group__46534); 
             after(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46544);
            rule__SubselectWhereEntry__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__4


    // $ANTLR start rule__SubselectWhereEntry__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3265:1: rule__SubselectWhereEntry__Group__5 : ( '(' ) rule__SubselectWhereEntry__Group__6 ;
    public final void rule__SubselectWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3269:1: ( ( '(' ) rule__SubselectWhereEntry__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3270:1: ( '(' ) rule__SubselectWhereEntry__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3270:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3271:1: '('
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 
            match(input,35,FOLLOW_35_in_rule__SubselectWhereEntry__Group__56573); 
             after(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56583);
            rule__SubselectWhereEntry__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__5


    // $ANTLR start rule__SubselectWhereEntry__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3285:1: rule__SubselectWhereEntry__Group__6 : ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 ;
    public final void rule__SubselectWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3289:1: ( ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3290:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3290:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3291:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3292:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3292:2: rule__SubselectWhereEntry__SubQueryAssignment_6
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66611);
            rule__SubselectWhereEntry__SubQueryAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66620);
            rule__SubselectWhereEntry__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__6


    // $ANTLR start rule__SubselectWhereEntry__Group__7
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3303:1: rule__SubselectWhereEntry__Group__7 : ( ')' ) ;
    public final void rule__SubselectWhereEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3307:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3308:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3308:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3309:1: ')'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__SubselectWhereEntry__Group__76649); 
             after(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__Group__7


    // $ANTLR start rule__AliasWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3338:1: rule__AliasWhereEntry__Group__0 : ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 ;
    public final void rule__AliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3342:1: ( ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3343:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3343:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3344:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3345:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3345:2: rule__AliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06700);
            rule__AliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06709);
            rule__AliasWhereEntry__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__0


    // $ANTLR start rule__AliasWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3356:1: rule__AliasWhereEntry__Group__1 : ( '=' ) rule__AliasWhereEntry__Group__2 ;
    public final void rule__AliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3360:1: ( ( '=' ) rule__AliasWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3361:1: ( '=' ) rule__AliasWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3361:1: ( '=' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3362:1: '='
            {
             before(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__AliasWhereEntry__Group__16738); 
             after(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16748);
            rule__AliasWhereEntry__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__1


    // $ANTLR start rule__AliasWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3376:1: rule__AliasWhereEntry__Group__2 : ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) ;
    public final void rule__AliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3380:1: ( ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3381:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3381:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3382:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3383:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3383:2: rule__AliasWhereEntry__RightAliasAssignment_2
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26776);
            rule__AliasWhereEntry__RightAliasAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__Group__2


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3399:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3403:1: ( ( ruleImport ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3404:1: ( ruleImport )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3404:1: ( ruleImport )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3405:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06816);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_0


    // $ANTLR start rule__Model__DefaultQueryAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3414:1: rule__Model__DefaultQueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__DefaultQueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3418:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3419:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3419:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3420:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_16847);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__DefaultQueryAssignment_1


    // $ANTLR start rule__Model__NamedQueriesAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3429:1: rule__Model__NamedQueriesAssignment_2 : ( ruleNamedQuery ) ;
    public final void rule__Model__NamedQueriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3433:1: ( ( ruleNamedQuery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3434:1: ( ruleNamedQuery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3434:1: ( ruleNamedQuery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3435:1: ruleNamedQuery
            {
             before(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_26878);
            ruleNamedQuery();
            _fsp--;

             after(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__NamedQueriesAssignment_2


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3444:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3448:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3449:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3449:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3450:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16909); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__NamedQuery__NameAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3459:1: rule__NamedQuery__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__NamedQuery__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3463:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3464:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3464:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3465:1: RULE_ID
            {
             before(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_06940); 
             after(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__NameAssignment_0


    // $ANTLR start rule__NamedQuery__QueryAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3474:1: rule__NamedQuery__QueryAssignment_2 : ( ruleMQLquery ) ;
    public final void rule__NamedQuery__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3478:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3479:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3479:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3480:1: ruleMQLquery
            {
             before(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_26971);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__QueryAssignment_2


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3489:1: rule__MQLquery__SelectEntriesAssignment_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3493:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3494:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3494:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3495:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_17002);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_1


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_2_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3504:1: rule__MQLquery__SelectEntriesAssignment_2_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3508:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3509:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3509:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3510:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_17033);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_2_1


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3519:1: rule__MQLquery__FromEntriesAssignment_4 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3523:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3524:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3524:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3525:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_47064);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_4


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_5_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3534:1: rule__MQLquery__FromEntriesAssignment_5_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3538:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3539:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3539:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3540:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_17095);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_5_1


    // $ANTLR start rule__MQLquery__WhereEntryAssignment_6_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3549:1: rule__MQLquery__WhereEntryAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntryAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3553:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3554:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3554:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3555:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17126);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__WhereEntryAssignment_6_1


    // $ANTLR start rule__SelectEntry__SelectAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3564:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3568:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3569:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3569:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3570:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3571:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3572:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07161); 
             after(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__SelectAssignment_0


    // $ANTLR start rule__SelectEntry__AttributeAssignment_1_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3583:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3587:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3588:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3588:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3589:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3590:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3591:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17200); 
             after(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__AttributeAssignment_1_1


    // $ANTLR start rule__FromEntry__TypeAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3602:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3606:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3607:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3607:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3608:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3609:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3610:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07239); 
             after(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__TypeAssignment_0


    // $ANTLR start rule__FromEntry__WithoutsubtypesAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3621:1: rule__FromEntry__WithoutsubtypesAssignment_1 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3625:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3626:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3626:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3627:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3628:1: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3629:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            match(input,38,FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_17279); 
             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__WithoutsubtypesAssignment_1


    // $ANTLR start rule__FromEntry__AliasAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3644:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3648:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3649:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3649:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3650:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37318); 
             after(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__AliasAssignment_3


    // $ANTLR start rule__FromEntry__ScopeClauseAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3659:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3663:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3664:1: ( ruleScopeClause )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3664:1: ( ruleScopeClause )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3665:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47349);
            ruleScopeClause();
            _fsp--;

             after(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__ScopeClauseAssignment_4


    // $ANTLR start rule__ResourceScope__NotInAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3674:1: rule__ResourceScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ResourceScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3678:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3679:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3679:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3680:1: ( 'not' )
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3681:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3682:1: 'not'
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07385); 
             after(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 

            }

             after(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__NotInAssignment_0


    // $ANTLR start rule__ResourceScope__UrisAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3697:1: rule__ResourceScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3701:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3702:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3702:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3703:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47424); 
             after(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__UrisAssignment_4


    // $ANTLR start rule__ResourceScope__UrisAssignment_5_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3712:1: rule__ResourceScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3716:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3717:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3717:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3718:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17455); 
             after(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__UrisAssignment_5_1


    // $ANTLR start rule__ElementScope__NotInAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3727:1: rule__ElementScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ElementScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3731:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3732:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3732:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3733:1: ( 'not' )
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3734:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3735:1: 'not'
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ElementScope__NotInAssignment_07491); 
             after(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 

            }

             after(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__NotInAssignment_0


    // $ANTLR start rule__ElementScope__UrisAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3750:1: rule__ElementScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3754:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3755:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3755:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3756:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47530); 
             after(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__UrisAssignment_4


    // $ANTLR start rule__ElementScope__UrisAssignment_5_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3765:1: rule__ElementScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3769:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3770:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3770:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3771:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17561); 
             after(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__UrisAssignment_5_1


    // $ANTLR start rule__WhereEntry__EntriesAssignment_1_1_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3780:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3784:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3785:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3785:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3786:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17592);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__EntriesAssignment_1_1_1


    // $ANTLR start rule__AndWhereEntry__EntriesAssignment_1_1_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3795:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3799:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3800:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3800:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3801:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17623);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__EntriesAssignment_1_1_1


    // $ANTLR start rule__DoubleWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3810:1: rule__DoubleWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3814:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3815:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3815:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3816:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3817:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3818:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07658); 
             after(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__AliasAssignment_0


    // $ANTLR start rule__DoubleWhereEntry__AttributeAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3829:1: rule__DoubleWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3833:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3834:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3834:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3835:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3836:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3837:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27697); 
             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__DoubleWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3848:1: rule__DoubleWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__DoubleWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3852:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3853:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3853:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3854:1: ruleNumericOperator
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37732);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__DoubleWhereEntry__ValueAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3863:1: rule__DoubleWhereEntry__ValueAssignment_4 : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3867:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3868:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3868:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3869:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47763); 
             after(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleWhereEntry__ValueAssignment_4


    // $ANTLR start rule__LongWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3878:1: rule__LongWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3882:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3883:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3883:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3884:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3885:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3886:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07798); 
             after(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__AliasAssignment_0


    // $ANTLR start rule__LongWhereEntry__AttributeAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3897:1: rule__LongWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3901:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3902:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3902:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3903:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3904:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3905:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27837); 
             after(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__LongWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3916:1: rule__LongWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__LongWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3920:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3921:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3921:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3922:1: ruleNumericOperator
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37872);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__LongWhereEntry__ValueAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3931:1: rule__LongWhereEntry__ValueAssignment_4 : ( RULE_SINGED_LONG ) ;
    public final void rule__LongWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3935:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3936:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3936:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3937:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47903); 
             after(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongWhereEntry__ValueAssignment_4


    // $ANTLR start rule__VariableWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3946:1: rule__VariableWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3950:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3951:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3951:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3952:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3953:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3954:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07938); 
             after(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__AliasAssignment_0


    // $ANTLR start rule__VariableWhereEntry__AttributeAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3965:1: rule__VariableWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3969:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3970:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3970:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3971:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3972:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3973:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27977); 
             after(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__VariableWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3984:1: rule__VariableWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__VariableWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3988:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3989:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3989:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3990:1: ruleNumericOperator
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_38012);
            ruleNumericOperator();
            _fsp--;

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__VariableWhereEntry__RightAliasAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3999:1: rule__VariableWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4003:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4004:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4004:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4005:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4006:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4007:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_48047); 
             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__RightAliasAssignment_4


    // $ANTLR start rule__VariableWhereEntry__RightAttributeAssignment_6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4018:1: rule__VariableWhereEntry__RightAttributeAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAttributeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4022:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4023:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4023:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4024:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4025:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4026:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_68086); 
             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__VariableWhereEntry__RightAttributeAssignment_6


    // $ANTLR start rule__StringAttributeWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4037:1: rule__StringAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4041:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4042:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4042:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4043:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4044:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4045:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_08125); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__AliasAssignment_0


    // $ANTLR start rule__StringAttributeWhereEntry__AttributeAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4056:1: rule__StringAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4060:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4061:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4061:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4062:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4063:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4064:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_28164); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__StringAttributeWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4075:1: rule__StringAttributeWhereEntry__OperatorAssignment_3 : ( ruleStringOperator ) ;
    public final void rule__StringAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4079:1: ( ( ruleStringOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4080:1: ( ruleStringOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4080:1: ( ruleStringOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4081:1: ruleStringOperator
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_38199);
            ruleStringOperator();
            _fsp--;

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__StringAttributeWhereEntry__PatternAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4090:1: rule__StringAttributeWhereEntry__PatternAssignment_4 : ( RULE_STRING ) ;
    public final void rule__StringAttributeWhereEntry__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4094:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4095:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4095:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4096:1: RULE_STRING
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_48230); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringAttributeWhereEntry__PatternAssignment_4


    // $ANTLR start rule__BooleanAttributeWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4105:1: rule__BooleanAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4109:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4110:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4110:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4111:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4112:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4113:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_08265); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__AliasAssignment_0


    // $ANTLR start rule__BooleanAttributeWhereEntry__AttributeAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4124:1: rule__BooleanAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4128:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4129:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4129:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4130:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4131:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4132:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_28304); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__AttributeAssignment_2


    // $ANTLR start rule__BooleanAttributeWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4143:1: rule__BooleanAttributeWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__BooleanAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4147:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4148:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4148:1: ( ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4149:1: ruleBooleanOperator
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_38339);
            ruleBooleanOperator();
            _fsp--;

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4158:1: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4162:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4163:1: ( ( 'true' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4163:1: ( ( 'true' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4164:1: ( 'true' )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4165:1: ( 'true' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4166:1: 'true'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            match(input,40,FOLLOW_40_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_08375); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 

            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0


    // $ANTLR start rule__NullWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4181:1: rule__NullWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4185:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4186:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4186:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4187:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4188:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4189:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_08418); 
             after(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__AliasAssignment_0


    // $ANTLR start rule__NullWhereEntry__FeatureAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4200:1: rule__NullWhereEntry__FeatureAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4204:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4205:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4205:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4206:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4207:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4208:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_28457); 
             after(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__FeatureAssignment_2


    // $ANTLR start rule__NullWhereEntry__OperatorAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4219:1: rule__NullWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__NullWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4223:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4224:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4224:1: ( ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4225:1: ruleBooleanOperator
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38492);
            ruleBooleanOperator();
            _fsp--;

             after(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullWhereEntry__OperatorAssignment_3


    // $ANTLR start rule__ReferenceAliasWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4234:1: rule__ReferenceAliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4238:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4239:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4239:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4240:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4241:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4242:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08527); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__AliasAssignment_0


    // $ANTLR start rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4253:1: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4257:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4258:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4258:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4259:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4260:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4261:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28566); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__ReferenceAssignment_2


    // $ANTLR start rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4272:1: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4276:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4277:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4277:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4278:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4279:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4280:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48605); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReferenceAliasWhereEntry__RightAliasAssignment_4


    // $ANTLR start rule__SubselectWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4291:1: rule__SubselectWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4295:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4296:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4296:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4297:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4298:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4299:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08644); 
             after(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__AliasAssignment_0


    // $ANTLR start rule__SubselectWhereEntry__ReferenceAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4310:1: rule__SubselectWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4314:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4315:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4315:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4316:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4317:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4318:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28683); 
             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__ReferenceAssignment_2


    // $ANTLR start rule__SubselectWhereEntry__NotInAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4329:1: rule__SubselectWhereEntry__NotInAssignment_3 : ( ( 'not' ) ) ;
    public final void rule__SubselectWhereEntry__NotInAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4333:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4334:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4334:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4335:1: ( 'not' )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4336:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4337:1: 'not'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            match(input,39,FOLLOW_39_in_rule__SubselectWhereEntry__NotInAssignment_38723); 
             after(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__NotInAssignment_3


    // $ANTLR start rule__SubselectWhereEntry__SubQueryAssignment_6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4352:1: rule__SubselectWhereEntry__SubQueryAssignment_6 : ( ruleMQLquery ) ;
    public final void rule__SubselectWhereEntry__SubQueryAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4356:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4357:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4357:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4358:1: ruleMQLquery
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68762);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SubselectWhereEntry__SubQueryAssignment_6


    // $ANTLR start rule__AliasWhereEntry__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4367:1: rule__AliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4371:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4372:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4372:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4373:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4374:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4375:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08797); 
             after(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__AliasAssignment_0


    // $ANTLR start rule__AliasWhereEntry__RightAliasAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4386:1: rule__AliasWhereEntry__RightAliasAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__RightAliasAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4390:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4391:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4391:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4392:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4393:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4394:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28836); 
             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasWhereEntry__RightAliasAssignment_2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedQuery187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__0_in_ruleNamedQuery214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__0_in_ruleMQLquery274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__0_in_ruleSelectEntry334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__0_in_ruleFromEntry394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScopeClause__Alternatives_in_ruleScopeClause454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__0_in_ruleResourceScope514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__0_in_ruleElementScope574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__0_in_ruleWhereEntry634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0_in_ruleAndWhereEntry694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcreteWhereEntry__Alternatives_in_ruleConcreteWhereEntry754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0_in_ruleParWhereEntry814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAliasWhereEntry_in_entryRuleAbstractAliasWhereEntry840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAliasWhereEntry847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractAliasWhereEntry__Alternatives_in_ruleAbstractAliasWhereEntry874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceWhereEntry1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceWhereEntry__Alternatives_in_ruleReferenceWhereEntry1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_rule__AbstractAliasWhereEntry__Alternatives1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_42051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_42070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives2259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__StringOperator__Alternatives2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__StringOperator__Alternatives2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__StringOperator__Alternatives2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__StringOperator__Alternatives2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__BooleanOperator__Alternatives2394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__BooleanOperator__Alternatives2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02452 = new BitSet(new long[]{0x0000000000500022L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__12490 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22528 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_20_in_rule__Import__Group__02570 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02646 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NamedQuery__Group__12684 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MQLquery__Group__02763 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12801 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22838 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MQLquery__Group__32877 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42915 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52952 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_2__03040 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__03050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__13078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_5__03117 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__13155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MQLquery__Group_6__03194 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__13232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__03270 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__13307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SelectEntry__Group_1__03347 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03423 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13460 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__FromEntry__Group__23499 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33537 = new BitSet(new long[]{0x0000008010000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03619 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ResourceScope__Group__13658 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ResourceScope__Group__23697 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__33736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43774 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53811 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResourceScope__Group__63850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResourceScope__Group_5__03900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03976 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ElementScope__Group__14015 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ElementScope__Group__24054 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__34093 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__44131 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__44140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__54168 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__54178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__64207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ElementScope__Group_5__04257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04333 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14448 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14460 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rule__WhereEntry__Group_1_1__04502 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04578 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14693 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14705 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rule__AndWhereEntry__Group_1_1__04747 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ParWhereEntry__Group__04824 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14862 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParWhereEntry__Group__24899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04940 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DoubleWhereEntry__Group__14978 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__25016 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__25025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__35053 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__35062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__45090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__05134 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__05143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__LongWhereEntry__Group__15172 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__15182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__25210 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__25219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__35247 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__35256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__45284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__05328 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__05337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableWhereEntry__Group__15366 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25404 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35441 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45478 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableWhereEntry__Group__55516 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05602 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__StringAttributeWhereEntry__Group__15640 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25678 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35715 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05796 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__BooleanAttributeWhereEntry__Group__15834 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25872 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35909 = new BitSet(new long[]{0x0000010000000800L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05990 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__NullWhereEntry__Group__16028 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__16038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__26066 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__26075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__36103 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__36112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__NullWhereEntry__Group__46141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__06186 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__06195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ReferenceAliasWhereEntry__Group__16224 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__16234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__26262 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__26271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__36300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__36310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__46338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06382 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SubselectWhereEntry__Group__16420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26458 = new BitSet(new long[]{0x0000008010000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36495 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SubselectWhereEntry__Group__46534 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__SubselectWhereEntry__Group__56573 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66611 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__SubselectWhereEntry__Group__76649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06700 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AliasWhereEntry__Group__16738 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_16847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_26878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_06940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_26971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_17002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_17033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_47064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_17095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_17279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ElementScope__NotInAssignment_07491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_38012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_48047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_68086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_08125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_28164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_38199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_48230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_08265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_28304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_38339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_08375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_08418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_28457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SubselectWhereEntry__NotInAssignment_38723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28836 = new BitSet(new long[]{0x0000000000000002L});

}