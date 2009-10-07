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


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:1: entryRuleAttributeWhereEntry : ruleAttributeWhereEntry EOF ;
    public final void entryRuleAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:30: ( ruleAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:412:1: ruleAttributeWhereEntry EOF
            {
             before(grammarAccess.getAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry840);
            ruleAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry847); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:419:1: ruleAttributeWhereEntry : ( ( rule__AttributeWhereEntry__Alternatives ) ) ;
    public final void ruleAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:423:2: ( ( ( rule__AttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__AttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:425:1: ( rule__AttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:1: ( rule__AttributeWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:2: rule__AttributeWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry874);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:1: entryRuleNumericAttributeWhereEntry : ruleNumericAttributeWhereEntry EOF ;
    public final void entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:37: ( ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:439:1: ruleNumericAttributeWhereEntry EOF
            {
             before(grammarAccess.getNumericAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry900);
            ruleNumericAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getNumericAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry907); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:446:1: ruleNumericAttributeWhereEntry : ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) ;
    public final void ruleNumericAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:450:2: ( ( ( rule__NumericAttributeWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__NumericAttributeWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:452:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            {
             before(grammarAccess.getNumericAttributeWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:1: ( rule__NumericAttributeWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:2: rule__NumericAttributeWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry934);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:1: entryRuleDoubleWhereEntry : ruleDoubleWhereEntry EOF ;
    public final void entryRuleDoubleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:27: ( ruleDoubleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:466:1: ruleDoubleWhereEntry EOF
            {
             before(grammarAccess.getDoubleWhereEntryRule()); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry960);
            ruleDoubleWhereEntry();
            _fsp--;

             after(grammarAccess.getDoubleWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry967); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:473:1: ruleDoubleWhereEntry : ( ( rule__DoubleWhereEntry__Group__0 ) ) ;
    public final void ruleDoubleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:477:2: ( ( ( rule__DoubleWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__DoubleWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:479:1: ( rule__DoubleWhereEntry__Group__0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:1: ( rule__DoubleWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:2: rule__DoubleWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry994);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:1: entryRuleLongWhereEntry : ruleLongWhereEntry EOF ;
    public final void entryRuleLongWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:25: ( ruleLongWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:493:1: ruleLongWhereEntry EOF
            {
             before(grammarAccess.getLongWhereEntryRule()); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1020);
            ruleLongWhereEntry();
            _fsp--;

             after(grammarAccess.getLongWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry1027); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:500:1: ruleLongWhereEntry : ( ( rule__LongWhereEntry__Group__0 ) ) ;
    public final void ruleLongWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:504:2: ( ( ( rule__LongWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__LongWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__LongWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:506:1: ( rule__LongWhereEntry__Group__0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:1: ( rule__LongWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:2: rule__LongWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1054);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:1: entryRuleVariableWhereEntry : ruleVariableWhereEntry EOF ;
    public final void entryRuleVariableWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:29: ( ruleVariableWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:520:1: ruleVariableWhereEntry EOF
            {
             before(grammarAccess.getVariableWhereEntryRule()); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1080);
            ruleVariableWhereEntry();
            _fsp--;

             after(grammarAccess.getVariableWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry1087); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:527:1: ruleVariableWhereEntry : ( ( rule__VariableWhereEntry__Group__0 ) ) ;
    public final void ruleVariableWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:531:2: ( ( ( rule__VariableWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__VariableWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:533:1: ( rule__VariableWhereEntry__Group__0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:1: ( rule__VariableWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:2: rule__VariableWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1114);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:1: entryRuleStringAttributeWhereEntry : ruleStringAttributeWhereEntry EOF ;
    public final void entryRuleStringAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:36: ( ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:547:1: ruleStringAttributeWhereEntry EOF
            {
             before(grammarAccess.getStringAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1140);
            ruleStringAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getStringAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1147); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:554:1: ruleStringAttributeWhereEntry : ( ( rule__StringAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleStringAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:558:2: ( ( ( rule__StringAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__StringAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:560:1: ( rule__StringAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:1: ( rule__StringAttributeWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:2: rule__StringAttributeWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1174);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:1: entryRuleBooleanAttributeWhereEntry : ruleBooleanAttributeWhereEntry EOF ;
    public final void entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:37: ( ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:574:1: ruleBooleanAttributeWhereEntry EOF
            {
             before(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1200);
            ruleBooleanAttributeWhereEntry();
            _fsp--;

             after(grammarAccess.getBooleanAttributeWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1207); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:581:1: ruleBooleanAttributeWhereEntry : ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) ;
    public final void ruleBooleanAttributeWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:585:2: ( ( ( rule__BooleanAttributeWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__BooleanAttributeWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:587:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:1: ( rule__BooleanAttributeWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:2: rule__BooleanAttributeWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1234);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:1: entryRuleReferenceWhereEntry : ruleReferenceWhereEntry EOF ;
    public final void entryRuleReferenceWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:30: ( ruleReferenceWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:601:1: ruleReferenceWhereEntry EOF
            {
             before(grammarAccess.getReferenceWhereEntryRule()); 
            pushFollow(FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry1260);
            ruleReferenceWhereEntry();
            _fsp--;

             after(grammarAccess.getReferenceWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceWhereEntry1267); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:608:1: ruleReferenceWhereEntry : ( ( rule__ReferenceWhereEntry__Alternatives ) ) ;
    public final void ruleReferenceWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:612:2: ( ( ( rule__ReferenceWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__ReferenceWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__ReferenceWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:614:1: ( rule__ReferenceWhereEntry__Alternatives )
            {
             before(grammarAccess.getReferenceWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:1: ( rule__ReferenceWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:2: rule__ReferenceWhereEntry__Alternatives
            {
            pushFollow(FOLLOW_rule__ReferenceWhereEntry__Alternatives_in_ruleReferenceWhereEntry1294);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:1: entryRuleNullWhereEntry : ruleNullWhereEntry EOF ;
    public final void entryRuleNullWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:25: ( ruleNullWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:628:1: ruleNullWhereEntry EOF
            {
             before(grammarAccess.getNullWhereEntryRule()); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1320);
            ruleNullWhereEntry();
            _fsp--;

             after(grammarAccess.getNullWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry1327); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:635:1: ruleNullWhereEntry : ( ( rule__NullWhereEntry__Group__0 ) ) ;
    public final void ruleNullWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:639:2: ( ( ( rule__NullWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__NullWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__NullWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:641:1: ( rule__NullWhereEntry__Group__0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:1: ( rule__NullWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:2: rule__NullWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1354);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:654:1: entryRuleReferenceAliasWhereEntry : ruleReferenceAliasWhereEntry EOF ;
    public final void entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:654:35: ( ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:655:1: ruleReferenceAliasWhereEntry EOF
            {
             before(grammarAccess.getReferenceAliasWhereEntryRule()); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1380);
            ruleReferenceAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getReferenceAliasWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1387); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:662:1: ruleReferenceAliasWhereEntry : ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) ;
    public final void ruleReferenceAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:666:2: ( ( ( rule__ReferenceAliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:667:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:667:1: ( ( rule__ReferenceAliasWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:668:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:669:1: ( rule__ReferenceAliasWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:669:2: rule__ReferenceAliasWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1414);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:681:1: entryRuleSubselectWhereEntry : ruleSubselectWhereEntry EOF ;
    public final void entryRuleSubselectWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:681:30: ( ruleSubselectWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:682:1: ruleSubselectWhereEntry EOF
            {
             before(grammarAccess.getSubselectWhereEntryRule()); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1440);
            ruleSubselectWhereEntry();
            _fsp--;

             after(grammarAccess.getSubselectWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry1447); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:689:1: ruleSubselectWhereEntry : ( ( rule__SubselectWhereEntry__Group__0 ) ) ;
    public final void ruleSubselectWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:693:2: ( ( ( rule__SubselectWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:694:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:694:1: ( ( rule__SubselectWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:695:1: ( rule__SubselectWhereEntry__Group__0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:696:1: ( rule__SubselectWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:696:2: rule__SubselectWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1474);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:708:1: entryRuleAliasWhereEntry : ruleAliasWhereEntry EOF ;
    public final void entryRuleAliasWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:708:26: ( ruleAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:709:1: ruleAliasWhereEntry EOF
            {
             before(grammarAccess.getAliasWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1500);
            ruleAliasWhereEntry();
            _fsp--;

             after(grammarAccess.getAliasWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry1507); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:716:1: ruleAliasWhereEntry : ( ( rule__AliasWhereEntry__Group__0 ) ) ;
    public final void ruleAliasWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:720:2: ( ( ( rule__AliasWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:721:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:721:1: ( ( rule__AliasWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:722:1: ( rule__AliasWhereEntry__Group__0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:723:1: ( rule__AliasWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:723:2: rule__AliasWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1534);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:736:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:740:1: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:741:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:741:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:742:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:743:1: ( rule__NumericOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:743:2: rule__NumericOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1571);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:755:1: ruleStringOperator : ( ( rule__StringOperator__Alternatives ) ) ;
    public final void ruleStringOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:759:1: ( ( ( rule__StringOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:760:1: ( ( rule__StringOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:760:1: ( ( rule__StringOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:761:1: ( rule__StringOperator__Alternatives )
            {
             before(grammarAccess.getStringOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:762:1: ( rule__StringOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:762:2: rule__StringOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1607);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:774:1: ruleBooleanOperator : ( ( rule__BooleanOperator__Alternatives ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:778:1: ( ( ( rule__BooleanOperator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:779:1: ( ( rule__BooleanOperator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:779:1: ( ( rule__BooleanOperator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:780:1: ( rule__BooleanOperator__Alternatives )
            {
             before(grammarAccess.getBooleanOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:781:1: ( rule__BooleanOperator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:781:2: rule__BooleanOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1643);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:792:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__ScopeClause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:796:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==28) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==29) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==32) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("792:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("792:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==28) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==29) ) {
                    alt1=1;
                }
                else if ( (LA1_2==32) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("792:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("792:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:797:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:797:1: ( ruleResourceScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:798:1: ruleResourceScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1678);
                    ruleResourceScope();
                    _fsp--;

                     after(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:803:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:803:6: ( ruleElementScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:804:1: ruleElementScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1695);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:818:1: ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) )
            int alt2=5;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==35) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==26) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_STRING:
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                            case 11:
                            case 40:
                                {
                                alt2=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                int LA2_10 = input.LA(6);

                                if ( (LA2_10==EOF||LA2_10==RULE_ID||(LA2_10>=33 && LA2_10<=34)||LA2_10==36) ) {
                                    alt2=3;
                                }
                                else if ( (LA2_10==26) ) {
                                    alt2=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 10, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case 37:
                                {
                                alt2=5;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 17:
                            {
                            int LA2_7 = input.LA(5);

                            if ( (LA2_7==37) ) {
                                alt2=5;
                            }
                            else if ( ((LA2_7>=RULE_STRING && LA2_7<=RULE_SINGED_LONG)||LA2_7==11||LA2_7==40) ) {
                                alt2=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 7, input);

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
                            alt2=2;
                            }
                            break;
                        case 28:
                        case 39:
                            {
                            alt2=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_2==16) ) {
                    alt2=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("814:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleAttributeWhereEntry ) | ( ruleReferenceWhereEntry ) | ( ruleAliasWhereEntry ) | ( ruleNullWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:819:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:819:1: ( ruleParWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:820:1: ruleParWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1727);
                    ruleParWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:825:6: ( ruleAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:825:6: ( ruleAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:826:1: ruleAttributeWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1744);
                    ruleAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:831:6: ( ruleReferenceWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:831:6: ( ruleReferenceWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:832:1: ruleReferenceWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getReferenceWhereEntryParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleReferenceWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1761);
                    ruleReferenceWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getReferenceWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:837:6: ( ruleAliasWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:837:6: ( ruleAliasWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:838:1: ruleAliasWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1778);
                    ruleAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:843:6: ( ruleNullWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:843:6: ( ruleNullWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:844:1: ruleNullWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1795);
                    ruleNullWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_4()); 

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


    // $ANTLR start rule__AttributeWhereEntry__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );
    public final void rule__AttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:858:1: ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) )
            int alt3=4;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==26) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 12:
                            {
                            int LA3_4 = input.LA(5);

                            if ( ((LA3_4>=RULE_SIGNED_DOUBLE && LA3_4<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_4==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA3_5 = input.LA(5);

                            if ( ((LA3_5>=RULE_SIGNED_DOUBLE && LA3_5<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else if ( (LA3_5==RULE_ID) ) {
                                alt3=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA3_6 = input.LA(5);

                            if ( (LA3_6==RULE_ID) ) {
                                alt3=4;
                            }
                            else if ( ((LA3_6>=RULE_SIGNED_DOUBLE && LA3_6<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA3_7 = input.LA(5);

                            if ( (LA3_7==RULE_ID) ) {
                                alt3=4;
                            }
                            else if ( ((LA3_7>=RULE_SIGNED_DOUBLE && LA3_7<=RULE_SINGED_LONG)) ) {
                                alt3=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            switch ( input.LA(5) ) {
                            case 11:
                            case 40:
                                {
                                alt3=3;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt3=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt3=4;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt3=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 8, input);

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
                                alt3=1;
                                }
                                break;
                            case 11:
                            case 40:
                                {
                                alt3=3;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt3=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt3=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 9, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 18:
                        case 19:
                            {
                            alt3=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("854:1: rule__AttributeWhereEntry__Alternatives : ( ( ruleNumericAttributeWhereEntry ) | ( ruleStringAttributeWhereEntry ) | ( ruleBooleanAttributeWhereEntry ) | ( ruleVariableWhereEntry ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:859:1: ( ruleNumericAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:859:1: ( ruleNumericAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:860:1: ruleNumericAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1827);
                    ruleNumericAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:865:6: ( ruleStringAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:865:6: ( ruleStringAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:866:1: ruleStringAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1844);
                    ruleStringAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:871:6: ( ruleBooleanAttributeWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:871:6: ( ruleBooleanAttributeWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:872:1: ruleBooleanAttributeWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1861);
                    ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     after(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:877:6: ( ruleVariableWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:877:6: ( ruleVariableWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:878:1: ruleVariableWhereEntry
                    {
                     before(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1878);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );
    public final void rule__NumericAttributeWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:892:1: ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) )
            int alt4=2;
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

                            if ( (LA4_4==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_4==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 13:
                            {
                            int LA4_5 = input.LA(5);

                            if ( (LA4_5==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_5==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 14:
                            {
                            int LA4_6 = input.LA(5);

                            if ( (LA4_6==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_6==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 15:
                            {
                            int LA4_7 = input.LA(5);

                            if ( (LA4_7==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_7==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 16:
                            {
                            int LA4_8 = input.LA(5);

                            if ( (LA4_8==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else if ( (LA4_8==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 17:
                            {
                            int LA4_9 = input.LA(5);

                            if ( (LA4_9==RULE_SIGNED_DOUBLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_9==RULE_SINGED_LONG) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("888:1: rule__NumericAttributeWhereEntry__Alternatives : ( ( ruleDoubleWhereEntry ) | ( ruleLongWhereEntry ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:893:1: ( ruleDoubleWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:893:1: ( ruleDoubleWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:894:1: ruleDoubleWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1910);
                    ruleDoubleWhereEntry();
                    _fsp--;

                     after(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:899:6: ( ruleLongWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:899:6: ( ruleLongWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:900:1: ruleLongWhereEntry
                    {
                     before(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1927);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:910:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );
    public final void rule__BooleanAttributeWhereEntry__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:914:1: ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==40) ) {
                alt5=1;
            }
            else if ( (LA5_0==11) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("910:1: rule__BooleanAttributeWhereEntry__Alternatives_4 : ( ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) ) | ( 'false' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:915:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:915:1: ( ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:916:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:917:1: ( rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:917:2: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0
                    {
                    pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_41959);
                    rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0();
                    _fsp--;


                    }

                     after(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueAssignment_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:921:6: ( 'false' )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:921:6: ( 'false' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:922:1: 'false'
                    {
                     before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_41978); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:934:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );
    public final void rule__ReferenceWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:938:1: ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==26) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==RULE_ID) ) {
                        int LA6_3 = input.LA(4);

                        if ( (LA6_3==28||LA6_3==39) ) {
                            alt6=2;
                        }
                        else if ( (LA6_3==16) ) {
                            alt6=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("934:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 6, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("934:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("934:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("934:1: rule__ReferenceWhereEntry__Alternatives : ( ( ruleReferenceAliasWhereEntry ) | ( ruleSubselectWhereEntry ) );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:939:1: ( ruleReferenceAliasWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:939:1: ( ruleReferenceAliasWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:940:1: ruleReferenceAliasWhereEntry
                    {
                     before(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2012);
                    ruleReferenceAliasWhereEntry();
                    _fsp--;

                     after(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:945:6: ( ruleSubselectWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:945:6: ( ruleSubselectWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:946:1: ruleSubselectWhereEntry
                    {
                     before(grammarAccess.getReferenceWhereEntryAccess().getSubselectWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2029);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:956:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:960:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt7=1;
                }
                break;
            case 13:
                {
                alt7=2;
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            case 15:
                {
                alt7=4;
                }
                break;
            case 16:
                {
                alt7=5;
                }
                break;
            case 17:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("956:1: rule__NumericOperator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:961:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:961:1: ( ( '<' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:962:1: ( '<' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:963:1: ( '<' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:963:3: '<'
                    {
                    match(input,12,FOLLOW_12_in_rule__NumericOperator__Alternatives2062); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:968:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:968:6: ( ( '>' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:969:1: ( '>' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:970:1: ( '>' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:970:3: '>'
                    {
                    match(input,13,FOLLOW_13_in_rule__NumericOperator__Alternatives2083); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:975:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:975:6: ( ( '<=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:976:1: ( '<=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:977:1: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:977:3: '<='
                    {
                    match(input,14,FOLLOW_14_in_rule__NumericOperator__Alternatives2104); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:6: ( ( '>=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:983:1: ( '>=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:984:1: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:984:3: '>='
                    {
                    match(input,15,FOLLOW_15_in_rule__NumericOperator__Alternatives2125); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:989:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:989:6: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:990:1: ( '=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:991:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:991:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__NumericOperator__Alternatives2146); 

                    }

                     after(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:996:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:996:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:997:1: ( '!=' )
                    {
                     before(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:998:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:998:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__NumericOperator__Alternatives2167); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1008:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );
    public final void rule__StringOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1012:1: ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt8=1;
                }
                break;
            case 17:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 19:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1008:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'notlike' ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1013:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1013:1: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1014:1: ( '=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1015:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1015:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__StringOperator__Alternatives2203); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1021:1: ( '!=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1022:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1022:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__StringOperator__Alternatives2224); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1027:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1027:6: ( ( 'like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1028:1: ( 'like' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1029:1: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1029:3: 'like'
                    {
                    match(input,18,FOLLOW_18_in_rule__StringOperator__Alternatives2245); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1034:6: ( ( 'notlike' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1034:6: ( ( 'notlike' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1035:1: ( 'notlike' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1036:1: ( 'notlike' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1036:3: 'notlike'
                    {
                    match(input,19,FOLLOW_19_in_rule__StringOperator__Alternatives2266); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1046:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );
    public final void rule__BooleanOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1050:1: ( ( ( '=' ) ) | ( ( '!=' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            else if ( (LA9_0==17) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1046:1: rule__BooleanOperator__Alternatives : ( ( ( '=' ) ) | ( ( '!=' ) ) );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1051:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1051:1: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1052:1: ( '=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1053:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1053:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__BooleanOperator__Alternatives2302); 

                    }

                     after(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1058:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1058:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1059:1: ( '!=' )
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1060:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1060:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__BooleanOperator__Alternatives2323); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1072:1: rule__Model__Group__0 : ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1076:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1077:1: ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1077:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1078:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:1: ( rule__Model__ImportsAssignment_0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02360);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02370);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1090:1: rule__Model__Group__1 : ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1094:1: ( ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1095:1: ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1095:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1096:1: ( rule__Model__DefaultQueryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1097:1: ( rule__Model__DefaultQueryAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1097:2: rule__Model__DefaultQueryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__12398);
                    rule__Model__DefaultQueryAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12408);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1108:1: rule__Model__Group__2 : ( ( rule__Model__NamedQueriesAssignment_2 )* ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1112:1: ( ( ( rule__Model__NamedQueriesAssignment_2 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1113:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1113:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1114:1: ( rule__Model__NamedQueriesAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1115:1: ( rule__Model__NamedQueriesAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1115:2: rule__Model__NamedQueriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22436);
            	    rule__Model__NamedQueriesAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1131:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1135:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1136:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1136:1: ( 'import' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1137:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Import__Group__02478); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02488);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1151:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1155:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1156:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1156:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1157:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1158:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1158:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12516);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1172:1: rule__NamedQuery__Group__0 : ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 ;
    public final void rule__NamedQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1176:1: ( ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1177:1: ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1177:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1178:1: ( rule__NamedQuery__NameAssignment_0 )
            {
             before(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1179:1: ( rule__NamedQuery__NameAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1179:2: rule__NamedQuery__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02554);
            rule__NamedQuery__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02563);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1190:1: rule__NamedQuery__Group__1 : ( ':' ) rule__NamedQuery__Group__2 ;
    public final void rule__NamedQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1194:1: ( ( ':' ) rule__NamedQuery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1195:1: ( ':' ) rule__NamedQuery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1195:1: ( ':' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1196:1: ':'
            {
             before(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__NamedQuery__Group__12592); 
             after(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12602);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1210:1: rule__NamedQuery__Group__2 : ( ( rule__NamedQuery__QueryAssignment_2 ) ) ;
    public final void rule__NamedQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1214:1: ( ( ( rule__NamedQuery__QueryAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1215:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1215:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1216:1: ( rule__NamedQuery__QueryAssignment_2 )
            {
             before(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1217:1: ( rule__NamedQuery__QueryAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1217:2: rule__NamedQuery__QueryAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22630);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1233:1: rule__MQLquery__Group__0 : ( 'select' ) rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1237:1: ( ( 'select' ) rule__MQLquery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1238:1: ( 'select' ) rule__MQLquery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1238:1: ( 'select' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1239:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__MQLquery__Group__02671); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02681);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1253:1: rule__MQLquery__Group__1 : ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1257:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) ) rule__MQLquery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__MQLquery__SelectEntriesAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1259:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1260:1: ( rule__MQLquery__SelectEntriesAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1260:2: rule__MQLquery__SelectEntriesAssignment_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12709);
            rule__MQLquery__SelectEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12718);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1271:1: rule__MQLquery__Group__2 : ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1275:1: ( ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1276:1: ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1276:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1277:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1278:1: ( rule__MQLquery__Group_2__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==24) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1278:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22746);
            	    rule__MQLquery__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22756);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1289:1: rule__MQLquery__Group__3 : ( 'from' ) rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1293:1: ( ( 'from' ) rule__MQLquery__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1294:1: ( 'from' ) rule__MQLquery__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1294:1: ( 'from' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1295:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 
            match(input,23,FOLLOW_23_in_rule__MQLquery__Group__32785); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32795);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1309:1: rule__MQLquery__Group__4 : ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1313:1: ( ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1314:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) ) rule__MQLquery__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1314:1: ( ( rule__MQLquery__FromEntriesAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1315:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1316:1: ( rule__MQLquery__FromEntriesAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1316:2: rule__MQLquery__FromEntriesAssignment_4
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42823);
            rule__MQLquery__FromEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42832);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1327:1: rule__MQLquery__Group__5 : ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1331:1: ( ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1332:1: ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1332:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1333:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1334:1: ( rule__MQLquery__Group_5__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1334:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52860);
            	    rule__MQLquery__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52870);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1345:1: rule__MQLquery__Group__6 : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1349:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1350:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1350:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1351:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1352:1: ( rule__MQLquery__Group_6__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1352:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62898);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1376:1: rule__MQLquery__Group_2__0 : ( ',' ) rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1380:1: ( ( ',' ) rule__MQLquery__Group_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1381:1: ( ',' ) rule__MQLquery__Group_2__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1381:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1382:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group_2__02948); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02958);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1396:1: rule__MQLquery__Group_2__1 : ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1400:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1401:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1401:1: ( ( rule__MQLquery__SelectEntriesAssignment_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1402:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1403:1: ( rule__MQLquery__SelectEntriesAssignment_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1403:2: rule__MQLquery__SelectEntriesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12986);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1417:1: rule__MQLquery__Group_5__0 : ( ',' ) rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1421:1: ( ( ',' ) rule__MQLquery__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1422:1: ( ',' ) rule__MQLquery__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1422:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1423:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group_5__03025); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03035);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1437:1: rule__MQLquery__Group_5__1 : ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1441:1: ( ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1442:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1442:1: ( ( rule__MQLquery__FromEntriesAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1443:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1444:1: ( rule__MQLquery__FromEntriesAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1444:2: rule__MQLquery__FromEntriesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__13063);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1458:1: rule__MQLquery__Group_6__0 : ( 'where' ) rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1462:1: ( ( 'where' ) rule__MQLquery__Group_6__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1463:1: ( 'where' ) rule__MQLquery__Group_6__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1463:1: ( 'where' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1464:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,25,FOLLOW_25_in_rule__MQLquery__Group_6__03102); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03112);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1478:1: rule__MQLquery__Group_6__1 : ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1482:1: ( ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1483:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1483:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1484:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1485:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1485:2: rule__MQLquery__WhereEntryAssignment_6_1
            {
            pushFollow(FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__13140);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1499:1: rule__SelectEntry__Group__0 : ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1503:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1504:1: ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1504:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1505:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__03178);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03187);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1517:1: rule__SelectEntry__Group__1 : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1521:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1522:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1522:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1523:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1524:1: ( rule__SelectEntry__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1524:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__13215);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1538:1: rule__SelectEntry__Group_1__0 : ( '.' ) rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1542:1: ( ( '.' ) rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1543:1: ( '.' ) rule__SelectEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1543:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1544:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,26,FOLLOW_26_in_rule__SelectEntry__Group_1__03255); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03265);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1558:1: rule__SelectEntry__Group_1__1 : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1562:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1563:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1563:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1564:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13293);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1579:1: rule__FromEntry__Group__0 : ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1583:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1584:1: ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1584:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1585:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1586:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1586:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03331);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03340);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1597:1: rule__FromEntry__Group__1 : ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1601:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1602:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? ) rule__FromEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1602:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1603:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1604:1: ( rule__FromEntry__WithoutsubtypesAssignment_1 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1604:2: rule__FromEntry__WithoutsubtypesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13368);
                    rule__FromEntry__WithoutsubtypesAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13378);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1615:1: rule__FromEntry__Group__2 : ( 'as' ) rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1619:1: ( ( 'as' ) rule__FromEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1620:1: ( 'as' ) rule__FromEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1620:1: ( 'as' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1621:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,27,FOLLOW_27_in_rule__FromEntry__Group__23407); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23417);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1635:1: rule__FromEntry__Group__3 : ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1639:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1640:1: ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1640:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1641:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1642:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1642:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33445);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33454);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1653:1: rule__FromEntry__Group__4 : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1657:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1658:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1658:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1659:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1660:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28||LA18_0==39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1660:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43482);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1680:1: rule__ResourceScope__Group__0 : ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1684:1: ( ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1685:1: ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1685:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1686:1: ( rule__ResourceScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1687:1: ( rule__ResourceScope__NotInAssignment_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1687:2: rule__ResourceScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03527);
                    rule__ResourceScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03537);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1698:1: rule__ResourceScope__Group__1 : ( 'in' ) rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1702:1: ( ( 'in' ) rule__ResourceScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1703:1: ( 'in' ) rule__ResourceScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1703:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1704:1: 'in'
            {
             before(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ResourceScope__Group__13566); 
             after(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13576);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1718:1: rule__ResourceScope__Group__2 : ( 'resources' ) rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1722:1: ( ( 'resources' ) rule__ResourceScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1723:1: ( 'resources' ) rule__ResourceScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1723:1: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1724:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__ResourceScope__Group__23605); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23615);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1738:1: rule__ResourceScope__Group__3 : ( '{' ) rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1742:1: ( ( '{' ) rule__ResourceScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1743:1: ( '{' ) rule__ResourceScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1743:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1744:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ResourceScope__Group__33644); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33654);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1758:1: rule__ResourceScope__Group__4 : ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1762:1: ( ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1763:1: ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1763:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1764:1: ( rule__ResourceScope__UrisAssignment_4 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1765:1: ( rule__ResourceScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1765:2: rule__ResourceScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43682);
            rule__ResourceScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43691);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1776:1: rule__ResourceScope__Group__5 : ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 ;
    public final void rule__ResourceScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1780:1: ( ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1781:1: ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1781:1: ( ( rule__ResourceScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1782:1: ( rule__ResourceScope__Group_5__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1783:1: ( rule__ResourceScope__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==24) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1783:2: rule__ResourceScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53719);
            	    rule__ResourceScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getResourceScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53729);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1794:1: rule__ResourceScope__Group__6 : ( '}' ) ;
    public final void rule__ResourceScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1798:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1799:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1799:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1800:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ResourceScope__Group__63758); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1827:1: rule__ResourceScope__Group_5__0 : ( ',' ) rule__ResourceScope__Group_5__1 ;
    public final void rule__ResourceScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1831:1: ( ( ',' ) rule__ResourceScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1832:1: ( ',' ) rule__ResourceScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1832:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1833:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__ResourceScope__Group_5__03808); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03818);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1847:1: rule__ResourceScope__Group_5__1 : ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ResourceScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1851:1: ( ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1852:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1852:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1853:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1854:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1854:2: rule__ResourceScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13846);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1868:1: rule__ElementScope__Group__0 : ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1872:1: ( ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1873:1: ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1873:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1874:1: ( rule__ElementScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1875:1: ( rule__ElementScope__NotInAssignment_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==39) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1875:2: rule__ElementScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03884);
                    rule__ElementScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03894);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1886:1: rule__ElementScope__Group__1 : ( 'in' ) rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1890:1: ( ( 'in' ) rule__ElementScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1891:1: ( 'in' ) rule__ElementScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1891:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1892:1: 'in'
            {
             before(grammarAccess.getElementScopeAccess().getInKeyword_1()); 
            match(input,28,FOLLOW_28_in_rule__ElementScope__Group__13923); 
             after(grammarAccess.getElementScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13933);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1906:1: rule__ElementScope__Group__2 : ( 'elements' ) rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1910:1: ( ( 'elements' ) rule__ElementScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1911:1: ( 'elements' ) rule__ElementScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1911:1: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1912:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ElementScope__Group__23962); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23972);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1926:1: rule__ElementScope__Group__3 : ( '{' ) rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1930:1: ( ( '{' ) rule__ElementScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1931:1: ( '{' ) rule__ElementScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1931:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1932:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ElementScope__Group__34001); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34011);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1946:1: rule__ElementScope__Group__4 : ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1950:1: ( ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1951:1: ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1951:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1952:1: ( rule__ElementScope__UrisAssignment_4 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1953:1: ( rule__ElementScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1953:2: rule__ElementScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__44039);
            rule__ElementScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__44048);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1964:1: rule__ElementScope__Group__5 : ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 ;
    public final void rule__ElementScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1968:1: ( ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1969:1: ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1969:1: ( ( rule__ElementScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1970:1: ( rule__ElementScope__Group_5__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1971:1: ( rule__ElementScope__Group_5__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==24) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1971:2: rule__ElementScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__54076);
            	    rule__ElementScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getElementScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__54086);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1982:1: rule__ElementScope__Group__6 : ( '}' ) ;
    public final void rule__ElementScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1986:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1987:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1987:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1988:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ElementScope__Group__64115); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2015:1: rule__ElementScope__Group_5__0 : ( ',' ) rule__ElementScope__Group_5__1 ;
    public final void rule__ElementScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2019:1: ( ( ',' ) rule__ElementScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2020:1: ( ',' ) rule__ElementScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2020:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2021:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 
            match(input,24,FOLLOW_24_in_rule__ElementScope__Group_5__04165); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04175);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2035:1: rule__ElementScope__Group_5__1 : ( ( rule__ElementScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ElementScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2039:1: ( ( ( rule__ElementScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2040:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2040:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2041:1: ( rule__ElementScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2042:1: ( rule__ElementScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2042:2: rule__ElementScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14203);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2056:1: rule__WhereEntry__Group__0 : ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2060:1: ( ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2061:1: ( ruleAndWhereEntry ) rule__WhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2061:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2062:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04241);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04249);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2074:1: rule__WhereEntry__Group__1 : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2078:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2079:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2079:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2080:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2081:1: ( rule__WhereEntry__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2081:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14277);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2095:1: rule__WhereEntry__Group_1__0 : ( () ) rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2099:1: ( ( () ) rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2100:1: ( () ) rule__WhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2100:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2101:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2102:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2104:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04326);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2115:1: rule__WhereEntry__Group_1__1 : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2119:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2120:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2120:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2121:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2121:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2122:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2123:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2123:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14356);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2126:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2127:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2128:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==33) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2128:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14368);
            	    rule__WhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2143:1: rule__WhereEntry__Group_1_1__0 : ( 'or' ) rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2147:1: ( ( 'or' ) rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2148:1: ( 'or' ) rule__WhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2148:1: ( 'or' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2149:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,33,FOLLOW_33_in_rule__WhereEntry__Group_1_1__04410); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04420);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2163:1: rule__WhereEntry__Group_1_1__1 : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2167:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2168:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2168:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2169:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2170:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2170:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14448);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2184:1: rule__AndWhereEntry__Group__0 : ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2188:1: ( ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2189:1: ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2189:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2190:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04486);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04494);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2202:1: rule__AndWhereEntry__Group__1 : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2206:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2207:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2207:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2208:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2209:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2209:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14522);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2223:1: rule__AndWhereEntry__Group_1__0 : ( () ) rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2227:1: ( ( () ) rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2228:1: ( () ) rule__AndWhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2228:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2229:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2230:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2232:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04571);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2243:1: rule__AndWhereEntry__Group_1__1 : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2247:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2248:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2248:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2249:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2249:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2250:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2251:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2251:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14601);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2254:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2255:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2256:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==34) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2256:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14613);
            	    rule__AndWhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2271:1: rule__AndWhereEntry__Group_1_1__0 : ( 'and' ) rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2275:1: ( ( 'and' ) rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2276:1: ( 'and' ) rule__AndWhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2276:1: ( 'and' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2277:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__AndWhereEntry__Group_1_1__04655); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04665);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2291:1: rule__AndWhereEntry__Group_1_1__1 : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2295:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2296:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2296:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2297:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2298:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2298:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14693);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2312:1: rule__ParWhereEntry__Group__0 : ( '(' ) rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2316:1: ( ( '(' ) rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2317:1: ( '(' ) rule__ParWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2317:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2318:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ParWhereEntry__Group__04732); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04742);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2332:1: rule__ParWhereEntry__Group__1 : ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2336:1: ( ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2337:1: ( ruleWhereEntry ) rule__ParWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2337:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2338:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14770);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14778);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2350:1: rule__ParWhereEntry__Group__2 : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2354:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2355:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2355:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2356:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,36,FOLLOW_36_in_rule__ParWhereEntry__Group__24807); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2375:1: rule__DoubleWhereEntry__Group__0 : ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 ;
    public final void rule__DoubleWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2379:1: ( ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2380:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) ) rule__DoubleWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2380:1: ( ( rule__DoubleWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2381:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2382:1: ( rule__DoubleWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2382:2: rule__DoubleWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04848);
            rule__DoubleWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04857);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2393:1: rule__DoubleWhereEntry__Group__1 : ( '.' ) rule__DoubleWhereEntry__Group__2 ;
    public final void rule__DoubleWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2397:1: ( ( '.' ) rule__DoubleWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2398:1: ( '.' ) rule__DoubleWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2398:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2399:1: '.'
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__DoubleWhereEntry__Group__14886); 
             after(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14896);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2413:1: rule__DoubleWhereEntry__Group__2 : ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 ;
    public final void rule__DoubleWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2417:1: ( ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2418:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) ) rule__DoubleWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2418:1: ( ( rule__DoubleWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2419:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2420:1: ( rule__DoubleWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2420:2: rule__DoubleWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__24924);
            rule__DoubleWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__24933);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2431:1: rule__DoubleWhereEntry__Group__3 : ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 ;
    public final void rule__DoubleWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2435:1: ( ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2436:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) ) rule__DoubleWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2436:1: ( ( rule__DoubleWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2437:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2438:1: ( rule__DoubleWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2438:2: rule__DoubleWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__34961);
            rule__DoubleWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getDoubleWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__34970);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2449:1: rule__DoubleWhereEntry__Group__4 : ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__DoubleWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2453:1: ( ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2454:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2454:1: ( ( rule__DoubleWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2455:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2456:1: ( rule__DoubleWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2456:2: rule__DoubleWhereEntry__ValueAssignment_4
            {
            pushFollow(FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__44998);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2476:1: rule__LongWhereEntry__Group__0 : ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 ;
    public final void rule__LongWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2480:1: ( ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2481:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) ) rule__LongWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2481:1: ( ( rule__LongWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2482:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2483:1: ( rule__LongWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2483:2: rule__LongWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__05042);
            rule__LongWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__05051);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2494:1: rule__LongWhereEntry__Group__1 : ( '.' ) rule__LongWhereEntry__Group__2 ;
    public final void rule__LongWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2498:1: ( ( '.' ) rule__LongWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2499:1: ( '.' ) rule__LongWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2499:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2500:1: '.'
            {
             before(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__LongWhereEntry__Group__15080); 
             after(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__15090);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2514:1: rule__LongWhereEntry__Group__2 : ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 ;
    public final void rule__LongWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2518:1: ( ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2519:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) ) rule__LongWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2519:1: ( ( rule__LongWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2520:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2521:1: ( rule__LongWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2521:2: rule__LongWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__25118);
            rule__LongWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__25127);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2532:1: rule__LongWhereEntry__Group__3 : ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 ;
    public final void rule__LongWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2536:1: ( ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2537:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) ) rule__LongWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2537:1: ( ( rule__LongWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2538:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2539:1: ( rule__LongWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2539:2: rule__LongWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__35155);
            rule__LongWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getLongWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__35164);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2550:1: rule__LongWhereEntry__Group__4 : ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) ;
    public final void rule__LongWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2554:1: ( ( ( rule__LongWhereEntry__ValueAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2555:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2555:1: ( ( rule__LongWhereEntry__ValueAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2556:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2557:1: ( rule__LongWhereEntry__ValueAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2557:2: rule__LongWhereEntry__ValueAssignment_4
            {
            pushFollow(FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__45192);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2577:1: rule__VariableWhereEntry__Group__0 : ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 ;
    public final void rule__VariableWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2581:1: ( ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2582:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) ) rule__VariableWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2582:1: ( ( rule__VariableWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2583:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2584:1: ( rule__VariableWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2584:2: rule__VariableWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__05236);
            rule__VariableWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__05245);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2595:1: rule__VariableWhereEntry__Group__1 : ( '.' ) rule__VariableWhereEntry__Group__2 ;
    public final void rule__VariableWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2599:1: ( ( '.' ) rule__VariableWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2600:1: ( '.' ) rule__VariableWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2600:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2601:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__VariableWhereEntry__Group__15274); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15284);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2615:1: rule__VariableWhereEntry__Group__2 : ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 ;
    public final void rule__VariableWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2619:1: ( ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2620:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) ) rule__VariableWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2620:1: ( ( rule__VariableWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2621:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2622:1: ( rule__VariableWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2622:2: rule__VariableWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25312);
            rule__VariableWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25321);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2633:1: rule__VariableWhereEntry__Group__3 : ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 ;
    public final void rule__VariableWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2637:1: ( ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2638:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) ) rule__VariableWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2638:1: ( ( rule__VariableWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2639:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2640:1: ( rule__VariableWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2640:2: rule__VariableWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35349);
            rule__VariableWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35358);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2651:1: rule__VariableWhereEntry__Group__4 : ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 ;
    public final void rule__VariableWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2655:1: ( ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2656:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) ) rule__VariableWhereEntry__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2656:1: ( ( rule__VariableWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2657:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2658:1: ( rule__VariableWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2658:2: rule__VariableWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45386);
            rule__VariableWhereEntry__RightAliasAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getVariableWhereEntryAccess().getRightAliasAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45395);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2669:1: rule__VariableWhereEntry__Group__5 : ( '.' ) rule__VariableWhereEntry__Group__6 ;
    public final void rule__VariableWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2673:1: ( ( '.' ) rule__VariableWhereEntry__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2674:1: ( '.' ) rule__VariableWhereEntry__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2674:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2675:1: '.'
            {
             before(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 
            match(input,26,FOLLOW_26_in_rule__VariableWhereEntry__Group__55424); 
             after(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5()); 

            }

            pushFollow(FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55434);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2689:1: rule__VariableWhereEntry__Group__6 : ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) ;
    public final void rule__VariableWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2693:1: ( ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2694:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2694:1: ( ( rule__VariableWhereEntry__RightAttributeAssignment_6 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2695:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeAssignment_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2696:1: ( rule__VariableWhereEntry__RightAttributeAssignment_6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2696:2: rule__VariableWhereEntry__RightAttributeAssignment_6
            {
            pushFollow(FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65462);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2720:1: rule__StringAttributeWhereEntry__Group__0 : ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 ;
    public final void rule__StringAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2724:1: ( ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2725:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) ) rule__StringAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2725:1: ( ( rule__StringAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2726:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2727:1: ( rule__StringAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2727:2: rule__StringAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05510);
            rule__StringAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05519);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2738:1: rule__StringAttributeWhereEntry__Group__1 : ( '.' ) rule__StringAttributeWhereEntry__Group__2 ;
    public final void rule__StringAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2742:1: ( ( '.' ) rule__StringAttributeWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2743:1: ( '.' ) rule__StringAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2743:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2744:1: '.'
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__StringAttributeWhereEntry__Group__15548); 
             after(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15558);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2758:1: rule__StringAttributeWhereEntry__Group__2 : ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 ;
    public final void rule__StringAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2762:1: ( ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2763:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) ) rule__StringAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2763:1: ( ( rule__StringAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2764:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2765:1: ( rule__StringAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2765:2: rule__StringAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25586);
            rule__StringAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25595);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2776:1: rule__StringAttributeWhereEntry__Group__3 : ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 ;
    public final void rule__StringAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2780:1: ( ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2781:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) ) rule__StringAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2781:1: ( ( rule__StringAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2782:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2783:1: ( rule__StringAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2783:2: rule__StringAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35623);
            rule__StringAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35632);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2794:1: rule__StringAttributeWhereEntry__Group__4 : ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) ;
    public final void rule__StringAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2798:1: ( ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2799:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2799:1: ( ( rule__StringAttributeWhereEntry__PatternAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2800:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2801:1: ( rule__StringAttributeWhereEntry__PatternAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2801:2: rule__StringAttributeWhereEntry__PatternAssignment_4
            {
            pushFollow(FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45660);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2821:1: rule__BooleanAttributeWhereEntry__Group__0 : ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 ;
    public final void rule__BooleanAttributeWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2825:1: ( ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2826:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) ) rule__BooleanAttributeWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2826:1: ( ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2827:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2828:1: ( rule__BooleanAttributeWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2828:2: rule__BooleanAttributeWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05704);
            rule__BooleanAttributeWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05713);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2839:1: rule__BooleanAttributeWhereEntry__Group__1 : ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 ;
    public final void rule__BooleanAttributeWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2843:1: ( ( '.' ) rule__BooleanAttributeWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2844:1: ( '.' ) rule__BooleanAttributeWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2844:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2845:1: '.'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__BooleanAttributeWhereEntry__Group__15742); 
             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15752);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2859:1: rule__BooleanAttributeWhereEntry__Group__2 : ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 ;
    public final void rule__BooleanAttributeWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2863:1: ( ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2864:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) ) rule__BooleanAttributeWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2864:1: ( ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2865:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2866:1: ( rule__BooleanAttributeWhereEntry__AttributeAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2866:2: rule__BooleanAttributeWhereEntry__AttributeAssignment_2
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25780);
            rule__BooleanAttributeWhereEntry__AttributeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25789);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2877:1: rule__BooleanAttributeWhereEntry__Group__3 : ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 ;
    public final void rule__BooleanAttributeWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2881:1: ( ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2882:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) ) rule__BooleanAttributeWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2882:1: ( ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2883:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2884:1: ( rule__BooleanAttributeWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2884:2: rule__BooleanAttributeWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35817);
            rule__BooleanAttributeWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35826);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2895:1: rule__BooleanAttributeWhereEntry__Group__4 : ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) ;
    public final void rule__BooleanAttributeWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2899:1: ( ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2900:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2900:1: ( ( rule__BooleanAttributeWhereEntry__Alternatives_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2901:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAlternatives_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2902:1: ( rule__BooleanAttributeWhereEntry__Alternatives_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2902:2: rule__BooleanAttributeWhereEntry__Alternatives_4
            {
            pushFollow(FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45854);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2922:1: rule__NullWhereEntry__Group__0 : ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 ;
    public final void rule__NullWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2926:1: ( ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2927:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) ) rule__NullWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2927:1: ( ( rule__NullWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2928:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2929:1: ( rule__NullWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2929:2: rule__NullWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05898);
            rule__NullWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05907);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2940:1: rule__NullWhereEntry__Group__1 : ( '.' ) rule__NullWhereEntry__Group__2 ;
    public final void rule__NullWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2944:1: ( ( '.' ) rule__NullWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2945:1: ( '.' ) rule__NullWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2945:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2946:1: '.'
            {
             before(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__NullWhereEntry__Group__15936); 
             after(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__15946);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2960:1: rule__NullWhereEntry__Group__2 : ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 ;
    public final void rule__NullWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2964:1: ( ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2965:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) ) rule__NullWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2965:1: ( ( rule__NullWhereEntry__FeatureAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2966:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2967:1: ( rule__NullWhereEntry__FeatureAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2967:2: rule__NullWhereEntry__FeatureAssignment_2
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__25974);
            rule__NullWhereEntry__FeatureAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getFeatureAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__25983);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2978:1: rule__NullWhereEntry__Group__3 : ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 ;
    public final void rule__NullWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2982:1: ( ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2983:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) ) rule__NullWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2983:1: ( ( rule__NullWhereEntry__OperatorAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2984:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2985:1: ( rule__NullWhereEntry__OperatorAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2985:2: rule__NullWhereEntry__OperatorAssignment_3
            {
            pushFollow(FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__36011);
            rule__NullWhereEntry__OperatorAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getNullWhereEntryAccess().getOperatorAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__36020);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2996:1: rule__NullWhereEntry__Group__4 : ( 'null' ) ;
    public final void rule__NullWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3000:1: ( ( 'null' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3001:1: ( 'null' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3001:1: ( 'null' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3002:1: 'null'
            {
             before(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4()); 
            match(input,37,FOLLOW_37_in_rule__NullWhereEntry__Group__46049); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3025:1: rule__ReferenceAliasWhereEntry__Group__0 : ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 ;
    public final void rule__ReferenceAliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3029:1: ( ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3030:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) ) rule__ReferenceAliasWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3030:1: ( ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3031:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3032:1: ( rule__ReferenceAliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3032:2: rule__ReferenceAliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__06094);
            rule__ReferenceAliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__06103);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3043:1: rule__ReferenceAliasWhereEntry__Group__1 : ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 ;
    public final void rule__ReferenceAliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3047:1: ( ( '.' ) rule__ReferenceAliasWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3048:1: ( '.' ) rule__ReferenceAliasWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3048:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3049:1: '.'
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__ReferenceAliasWhereEntry__Group__16132); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__16142);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3063:1: rule__ReferenceAliasWhereEntry__Group__2 : ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 ;
    public final void rule__ReferenceAliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3067:1: ( ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3068:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) ) rule__ReferenceAliasWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3068:1: ( ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3069:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3070:1: ( rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3070:2: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__26170);
            rule__ReferenceAliasWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__26179);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3081:1: rule__ReferenceAliasWhereEntry__Group__3 : ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 ;
    public final void rule__ReferenceAliasWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3085:1: ( ( '=' ) rule__ReferenceAliasWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3086:1: ( '=' ) rule__ReferenceAliasWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3086:1: ( '=' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3087:1: '='
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__36208); 
             after(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__36218);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3101:1: rule__ReferenceAliasWhereEntry__Group__4 : ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) ;
    public final void rule__ReferenceAliasWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3105:1: ( ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3106:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3106:1: ( ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3107:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3108:1: ( rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3108:2: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4
            {
            pushFollow(FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__46246);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3128:1: rule__SubselectWhereEntry__Group__0 : ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 ;
    public final void rule__SubselectWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3132:1: ( ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3133:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) ) rule__SubselectWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3133:1: ( ( rule__SubselectWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3134:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3135:1: ( rule__SubselectWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3135:2: rule__SubselectWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06290);
            rule__SubselectWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06299);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3146:1: rule__SubselectWhereEntry__Group__1 : ( '.' ) rule__SubselectWhereEntry__Group__2 ;
    public final void rule__SubselectWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3150:1: ( ( '.' ) rule__SubselectWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3151:1: ( '.' ) rule__SubselectWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3151:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3152:1: '.'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_26_in_rule__SubselectWhereEntry__Group__16328); 
             after(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16338);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3166:1: rule__SubselectWhereEntry__Group__2 : ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 ;
    public final void rule__SubselectWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3170:1: ( ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3171:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) ) rule__SubselectWhereEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3171:1: ( ( rule__SubselectWhereEntry__ReferenceAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3172:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3173:1: ( rule__SubselectWhereEntry__ReferenceAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3173:2: rule__SubselectWhereEntry__ReferenceAssignment_2
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26366);
            rule__SubselectWhereEntry__ReferenceAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getReferenceAssignment_2()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26375);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3184:1: rule__SubselectWhereEntry__Group__3 : ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 ;
    public final void rule__SubselectWhereEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3188:1: ( ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3189:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? ) rule__SubselectWhereEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3189:1: ( ( rule__SubselectWhereEntry__NotInAssignment_3 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3190:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3191:1: ( rule__SubselectWhereEntry__NotInAssignment_3 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3191:2: rule__SubselectWhereEntry__NotInAssignment_3
                    {
                    pushFollow(FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36403);
                    rule__SubselectWhereEntry__NotInAssignment_3();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSubselectWhereEntryAccess().getNotInAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36413);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3202:1: rule__SubselectWhereEntry__Group__4 : ( 'in' ) rule__SubselectWhereEntry__Group__5 ;
    public final void rule__SubselectWhereEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3206:1: ( ( 'in' ) rule__SubselectWhereEntry__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3207:1: ( 'in' ) rule__SubselectWhereEntry__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3207:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3208:1: 'in'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__SubselectWhereEntry__Group__46442); 
             after(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46452);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3222:1: rule__SubselectWhereEntry__Group__5 : ( '(' ) rule__SubselectWhereEntry__Group__6 ;
    public final void rule__SubselectWhereEntry__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3226:1: ( ( '(' ) rule__SubselectWhereEntry__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3227:1: ( '(' ) rule__SubselectWhereEntry__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3227:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3228:1: '('
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 
            match(input,35,FOLLOW_35_in_rule__SubselectWhereEntry__Group__56481); 
             after(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56491);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3242:1: rule__SubselectWhereEntry__Group__6 : ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 ;
    public final void rule__SubselectWhereEntry__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3246:1: ( ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3247:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) ) rule__SubselectWhereEntry__Group__7
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3247:1: ( ( rule__SubselectWhereEntry__SubQueryAssignment_6 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3248:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3249:1: ( rule__SubselectWhereEntry__SubQueryAssignment_6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3249:2: rule__SubselectWhereEntry__SubQueryAssignment_6
            {
            pushFollow(FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66519);
            rule__SubselectWhereEntry__SubQueryAssignment_6();
            _fsp--;


            }

             after(grammarAccess.getSubselectWhereEntryAccess().getSubQueryAssignment_6()); 

            }

            pushFollow(FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66528);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3260:1: rule__SubselectWhereEntry__Group__7 : ( ')' ) ;
    public final void rule__SubselectWhereEntry__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3264:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3265:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3265:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3266:1: ')'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7()); 
            match(input,36,FOLLOW_36_in_rule__SubselectWhereEntry__Group__76557); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3295:1: rule__AliasWhereEntry__Group__0 : ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 ;
    public final void rule__AliasWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3299:1: ( ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3300:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) ) rule__AliasWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3300:1: ( ( rule__AliasWhereEntry__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3301:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3302:1: ( rule__AliasWhereEntry__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3302:2: rule__AliasWhereEntry__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06608);
            rule__AliasWhereEntry__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasWhereEntryAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06617);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3313:1: rule__AliasWhereEntry__Group__1 : ( '=' ) rule__AliasWhereEntry__Group__2 ;
    public final void rule__AliasWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3317:1: ( ( '=' ) rule__AliasWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3318:1: ( '=' ) rule__AliasWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3318:1: ( '=' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3319:1: '='
            {
             before(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__AliasWhereEntry__Group__16646); 
             after(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16656);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3333:1: rule__AliasWhereEntry__Group__2 : ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) ;
    public final void rule__AliasWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3337:1: ( ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3338:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3338:1: ( ( rule__AliasWhereEntry__RightAliasAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3339:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3340:1: ( rule__AliasWhereEntry__RightAliasAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3340:2: rule__AliasWhereEntry__RightAliasAssignment_2
            {
            pushFollow(FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26684);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3356:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3360:1: ( ( ruleImport ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3361:1: ( ruleImport )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3361:1: ( ruleImport )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3362:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06724);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3371:1: rule__Model__DefaultQueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__DefaultQueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3375:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3376:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3376:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3377:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_16755);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3386:1: rule__Model__NamedQueriesAssignment_2 : ( ruleNamedQuery ) ;
    public final void rule__Model__NamedQueriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3390:1: ( ( ruleNamedQuery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3391:1: ( ruleNamedQuery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3391:1: ( ruleNamedQuery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3392:1: ruleNamedQuery
            {
             before(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_26786);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3401:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3405:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3406:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3406:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3407:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16817); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3416:1: rule__NamedQuery__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__NamedQuery__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3420:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3421:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3421:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3422:1: RULE_ID
            {
             before(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_06848); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3431:1: rule__NamedQuery__QueryAssignment_2 : ( ruleMQLquery ) ;
    public final void rule__NamedQuery__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3435:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3436:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3436:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3437:1: ruleMQLquery
            {
             before(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_26879);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3446:1: rule__MQLquery__SelectEntriesAssignment_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3450:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3451:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3451:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3452:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_16910);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3461:1: rule__MQLquery__SelectEntriesAssignment_2_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3465:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3466:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3466:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3467:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_16941);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3476:1: rule__MQLquery__FromEntriesAssignment_4 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3480:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3481:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3481:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3482:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_46972);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3491:1: rule__MQLquery__FromEntriesAssignment_5_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3495:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3496:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3496:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3497:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_17003);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3506:1: rule__MQLquery__WhereEntryAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntryAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3510:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3511:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3511:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3512:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17034);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3521:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3525:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3526:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3526:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3527:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3528:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3529:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07069); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3540:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3544:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3545:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3545:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3546:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3547:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3548:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17108); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3559:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3563:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3564:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3564:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3565:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3566:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3567:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07147); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3578:1: rule__FromEntry__WithoutsubtypesAssignment_1 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3582:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3583:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3583:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3584:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3585:1: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3586:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0()); 
            match(input,38,FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_17187); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3601:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3605:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3606:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3606:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3607:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37226); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3616:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3620:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3621:1: ( ruleScopeClause )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3621:1: ( ruleScopeClause )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3622:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47257);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3631:1: rule__ResourceScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ResourceScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3635:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3636:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3636:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3637:1: ( 'not' )
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3638:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3639:1: 'not'
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07293); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3654:1: rule__ResourceScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3658:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3659:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3659:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3660:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47332); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3669:1: rule__ResourceScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3673:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3674:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3674:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3675:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17363); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3684:1: rule__ElementScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ElementScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3688:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3689:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3689:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3690:1: ( 'not' )
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3691:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3692:1: 'not'
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ElementScope__NotInAssignment_07399); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3707:1: rule__ElementScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3711:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3712:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3712:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3713:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47438); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3722:1: rule__ElementScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3726:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3727:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3727:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3728:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17469); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3737:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3741:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3742:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3742:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3743:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17500);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3752:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3756:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3757:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3757:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3758:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17531);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3767:1: rule__DoubleWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3771:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3772:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3772:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3773:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3774:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3775:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07566); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3786:1: rule__DoubleWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__DoubleWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3790:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3791:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3791:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3792:1: ( RULE_ID )
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3793:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3794:1: RULE_ID
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27605); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3805:1: rule__DoubleWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__DoubleWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3809:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3810:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3810:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3811:1: ruleNumericOperator
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37640);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3820:1: rule__DoubleWhereEntry__ValueAssignment_4 : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3824:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3825:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3825:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3826:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0()); 
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47671); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3835:1: rule__LongWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3839:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3840:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3840:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3841:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3842:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3843:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07706); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3854:1: rule__LongWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LongWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3858:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3859:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3859:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3860:1: ( RULE_ID )
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3861:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3862:1: RULE_ID
            {
             before(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27745); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3873:1: rule__LongWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__LongWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3877:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3878:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3878:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3879:1: ruleNumericOperator
            {
             before(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37780);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3888:1: rule__LongWhereEntry__ValueAssignment_4 : ( RULE_SINGED_LONG ) ;
    public final void rule__LongWhereEntry__ValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3892:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3893:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3893:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3894:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0()); 
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47811); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3903:1: rule__VariableWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3907:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3908:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3908:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3909:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3910:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3911:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07846); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3922:1: rule__VariableWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3926:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3927:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3927:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3928:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3929:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3930:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27885); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3941:1: rule__VariableWhereEntry__OperatorAssignment_3 : ( ruleNumericOperator ) ;
    public final void rule__VariableWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3945:1: ( ( ruleNumericOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3946:1: ( ruleNumericOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3946:1: ( ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3947:1: ruleNumericOperator
            {
             before(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_37920);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3956:1: rule__VariableWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3960:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3961:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3961:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3962:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3963:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3964:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_47955); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3975:1: rule__VariableWhereEntry__RightAttributeAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__VariableWhereEntry__RightAttributeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3979:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3980:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3980:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3981:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3982:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3983:1: RULE_ID
            {
             before(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_67994); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3994:1: rule__StringAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3998:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3999:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3999:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4000:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4001:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4002:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_08033); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4013:1: rule__StringAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__StringAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4017:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4018:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4018:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4019:1: ( RULE_ID )
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4020:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4021:1: RULE_ID
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_28072); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4032:1: rule__StringAttributeWhereEntry__OperatorAssignment_3 : ( ruleStringOperator ) ;
    public final void rule__StringAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4036:1: ( ( ruleStringOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4037:1: ( ruleStringOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4037:1: ( ruleStringOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4038:1: ruleStringOperator
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_38107);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4047:1: rule__StringAttributeWhereEntry__PatternAssignment_4 : ( RULE_STRING ) ;
    public final void rule__StringAttributeWhereEntry__PatternAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4051:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4052:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4052:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4053:1: RULE_STRING
            {
             before(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_48138); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4062:1: rule__BooleanAttributeWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4066:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4067:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4067:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4068:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4069:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4070:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_08173); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4081:1: rule__BooleanAttributeWhereEntry__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttributeWhereEntry__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4085:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4086:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4086:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4087:1: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4088:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4089:1: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_28212); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4100:1: rule__BooleanAttributeWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__BooleanAttributeWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4104:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4105:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4105:1: ( ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4106:1: ruleBooleanOperator
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_38247);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4115:1: rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4119:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4120:1: ( ( 'true' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4120:1: ( ( 'true' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4121:1: ( 'true' )
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4122:1: ( 'true' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4123:1: 'true'
            {
             before(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0()); 
            match(input,40,FOLLOW_40_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_08283); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4138:1: rule__NullWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4142:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4143:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4143:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4144:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4145:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4146:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_08326); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4157:1: rule__NullWhereEntry__FeatureAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__NullWhereEntry__FeatureAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4161:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4162:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4162:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4163:1: ( RULE_ID )
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4164:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4165:1: RULE_ID
            {
             before(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_28365); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4176:1: rule__NullWhereEntry__OperatorAssignment_3 : ( ruleBooleanOperator ) ;
    public final void rule__NullWhereEntry__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4180:1: ( ( ruleBooleanOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4181:1: ( ruleBooleanOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4181:1: ( ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4182:1: ruleBooleanOperator
            {
             before(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38400);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4191:1: rule__ReferenceAliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4195:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4196:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4196:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4197:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4198:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4199:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08435); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4210:1: rule__ReferenceAliasWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4214:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4215:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4215:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4216:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4217:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4218:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28474); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4229:1: rule__ReferenceAliasWhereEntry__RightAliasAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceAliasWhereEntry__RightAliasAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4233:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4234:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4234:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4235:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4236:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4237:1: RULE_ID
            {
             before(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48513); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4248:1: rule__SubselectWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4252:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4253:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4253:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4254:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4255:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4256:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08552); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4267:1: rule__SubselectWhereEntry__ReferenceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__SubselectWhereEntry__ReferenceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4271:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4272:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4272:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4273:1: ( RULE_ID )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4274:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4275:1: RULE_ID
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28591); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4286:1: rule__SubselectWhereEntry__NotInAssignment_3 : ( ( 'not' ) ) ;
    public final void rule__SubselectWhereEntry__NotInAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4290:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4291:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4291:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4292:1: ( 'not' )
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4293:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4294:1: 'not'
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0()); 
            match(input,39,FOLLOW_39_in_rule__SubselectWhereEntry__NotInAssignment_38631); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4309:1: rule__SubselectWhereEntry__SubQueryAssignment_6 : ( ruleMQLquery ) ;
    public final void rule__SubselectWhereEntry__SubQueryAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4313:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4314:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4314:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4315:1: ruleMQLquery
            {
             before(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68670);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4324:1: rule__AliasWhereEntry__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4328:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4329:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4329:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4330:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4331:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4332:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08705); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4343:1: rule__AliasWhereEntry__RightAliasAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__AliasWhereEntry__RightAliasAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4347:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4348:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4348:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4349:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4350:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:4351:1: RULE_ID
            {
             before(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28744); 
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
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AttributeWhereEntry__Alternatives_in_ruleAttributeWhereEntry874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericAttributeWhereEntry__Alternatives_in_ruleNumericAttributeWhereEntry934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__0_in_ruleDoubleWhereEntry994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__0_in_ruleLongWhereEntry1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__0_in_ruleVariableWhereEntry1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__0_in_ruleStringAttributeWhereEntry1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__0_in_ruleBooleanAttributeWhereEntry1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry1260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceWhereEntry1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceWhereEntry__Alternatives_in_ruleReferenceWhereEntry1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__0_in_ruleNullWhereEntry1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry1380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__0_in_ruleReferenceAliasWhereEntry1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__0_in_ruleSubselectWhereEntry1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry1500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__0_in_ruleAliasWhereEntry1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanOperator__Alternatives_in_ruleBooleanOperator1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_rule__AttributeWhereEntry__Alternatives1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_rule__AttributeWhereEntry__Alternatives1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_rule__NumericAttributeWhereEntry__Alternatives1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_0_in_rule__BooleanAttributeWhereEntry__Alternatives_41959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanAttributeWhereEntry__Alternatives_41978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_rule__ReferenceWhereEntry__Alternatives2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__StringOperator__Alternatives2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__StringOperator__Alternatives2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__StringOperator__Alternatives2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__StringOperator__Alternatives2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__BooleanOperator__Alternatives2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__BooleanOperator__Alternatives2323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__02360 = new BitSet(new long[]{0x0000000000500022L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__12398 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22436 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_20_in_rule__Import__Group__02478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__12516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02554 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NamedQuery__Group__12592 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MQLquery__Group__02671 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_1_in_rule__MQLquery__Group__12709 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22746 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MQLquery__Group__32785 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_4_in_rule__MQLquery__Group__42823 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52860 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_2__02948 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group_5__03025 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_5_1_in_rule__MQLquery__Group_5__13063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MQLquery__Group_6__03102 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__13140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__03178 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__13215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SelectEntry__Group_1__03255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__13293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__03331 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_in_rule__FromEntry__Group__13368 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__FromEntry__Group__23407 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33445 = new BitSet(new long[]{0x0000008010000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03527 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ResourceScope__Group__13566 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ResourceScope__Group__23605 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__33644 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43682 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53719 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResourceScope__Group__63758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ResourceScope__Group_5__03808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03884 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ElementScope__Group__13923 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ElementScope__Group__23962 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__34001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__34011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__44039 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__44048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__54076 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__54086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__64115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ElementScope__Group_5__04165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04241 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14356 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14368 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_rule__WhereEntry__Group_1_1__04410 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04486 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14601 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14613 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rule__AndWhereEntry__Group_1_1__04655 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ParWhereEntry__Group__04732 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14770 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParWhereEntry__Group__24807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__AliasAssignment_0_in_rule__DoubleWhereEntry__Group__04848 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__1_in_rule__DoubleWhereEntry__Group__04857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__DoubleWhereEntry__Group__14886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__2_in_rule__DoubleWhereEntry__Group__14896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__AttributeAssignment_2_in_rule__DoubleWhereEntry__Group__24924 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__3_in_rule__DoubleWhereEntry__Group__24933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__OperatorAssignment_3_in_rule__DoubleWhereEntry__Group__34961 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__Group__4_in_rule__DoubleWhereEntry__Group__34970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleWhereEntry__ValueAssignment_4_in_rule__DoubleWhereEntry__Group__44998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__AliasAssignment_0_in_rule__LongWhereEntry__Group__05042 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__1_in_rule__LongWhereEntry__Group__05051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__LongWhereEntry__Group__15080 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__2_in_rule__LongWhereEntry__Group__15090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__AttributeAssignment_2_in_rule__LongWhereEntry__Group__25118 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__3_in_rule__LongWhereEntry__Group__25127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__OperatorAssignment_3_in_rule__LongWhereEntry__Group__35155 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__Group__4_in_rule__LongWhereEntry__Group__35164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongWhereEntry__ValueAssignment_4_in_rule__LongWhereEntry__Group__45192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__AliasAssignment_0_in_rule__VariableWhereEntry__Group__05236 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__1_in_rule__VariableWhereEntry__Group__05245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableWhereEntry__Group__15274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__2_in_rule__VariableWhereEntry__Group__15284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__AttributeAssignment_2_in_rule__VariableWhereEntry__Group__25312 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__3_in_rule__VariableWhereEntry__Group__25321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__OperatorAssignment_3_in_rule__VariableWhereEntry__Group__35349 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__4_in_rule__VariableWhereEntry__Group__35358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAliasAssignment_4_in_rule__VariableWhereEntry__Group__45386 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__5_in_rule__VariableWhereEntry__Group__45395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableWhereEntry__Group__55424 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__Group__6_in_rule__VariableWhereEntry__Group__55434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableWhereEntry__RightAttributeAssignment_6_in_rule__VariableWhereEntry__Group__65462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AliasAssignment_0_in_rule__StringAttributeWhereEntry__Group__05510 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__1_in_rule__StringAttributeWhereEntry__Group__05519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__StringAttributeWhereEntry__Group__15548 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__2_in_rule__StringAttributeWhereEntry__Group__15558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__AttributeAssignment_2_in_rule__StringAttributeWhereEntry__Group__25586 = new BitSet(new long[]{0x00000000000F0000L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__3_in_rule__StringAttributeWhereEntry__Group__25595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__OperatorAssignment_3_in_rule__StringAttributeWhereEntry__Group__35623 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__Group__4_in_rule__StringAttributeWhereEntry__Group__35632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringAttributeWhereEntry__PatternAssignment_4_in_rule__StringAttributeWhereEntry__Group__45660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AliasAssignment_0_in_rule__BooleanAttributeWhereEntry__Group__05704 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__1_in_rule__BooleanAttributeWhereEntry__Group__05713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__BooleanAttributeWhereEntry__Group__15742 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__2_in_rule__BooleanAttributeWhereEntry__Group__15752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__AttributeAssignment_2_in_rule__BooleanAttributeWhereEntry__Group__25780 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__3_in_rule__BooleanAttributeWhereEntry__Group__25789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__OperatorAssignment_3_in_rule__BooleanAttributeWhereEntry__Group__35817 = new BitSet(new long[]{0x0000010000000800L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Group__4_in_rule__BooleanAttributeWhereEntry__Group__35826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanAttributeWhereEntry__Alternatives_4_in_rule__BooleanAttributeWhereEntry__Group__45854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__AliasAssignment_0_in_rule__NullWhereEntry__Group__05898 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__1_in_rule__NullWhereEntry__Group__05907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__NullWhereEntry__Group__15936 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__2_in_rule__NullWhereEntry__Group__15946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__FeatureAssignment_2_in_rule__NullWhereEntry__Group__25974 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__3_in_rule__NullWhereEntry__Group__25983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__OperatorAssignment_3_in_rule__NullWhereEntry__Group__36011 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__NullWhereEntry__Group__4_in_rule__NullWhereEntry__Group__36020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__NullWhereEntry__Group__46049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__AliasAssignment_0_in_rule__ReferenceAliasWhereEntry__Group__06094 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__1_in_rule__ReferenceAliasWhereEntry__Group__06103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ReferenceAliasWhereEntry__Group__16132 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__2_in_rule__ReferenceAliasWhereEntry__Group__16142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__ReferenceAssignment_2_in_rule__ReferenceAliasWhereEntry__Group__26170 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__3_in_rule__ReferenceAliasWhereEntry__Group__26179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ReferenceAliasWhereEntry__Group__36208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__Group__4_in_rule__ReferenceAliasWhereEntry__Group__36218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAliasWhereEntry__RightAliasAssignment_4_in_rule__ReferenceAliasWhereEntry__Group__46246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__AliasAssignment_0_in_rule__SubselectWhereEntry__Group__06290 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__1_in_rule__SubselectWhereEntry__Group__06299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SubselectWhereEntry__Group__16328 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__2_in_rule__SubselectWhereEntry__Group__16338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__ReferenceAssignment_2_in_rule__SubselectWhereEntry__Group__26366 = new BitSet(new long[]{0x0000008010000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__3_in_rule__SubselectWhereEntry__Group__26375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__NotInAssignment_3_in_rule__SubselectWhereEntry__Group__36403 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__4_in_rule__SubselectWhereEntry__Group__36413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SubselectWhereEntry__Group__46442 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__5_in_rule__SubselectWhereEntry__Group__46452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__SubselectWhereEntry__Group__56481 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__6_in_rule__SubselectWhereEntry__Group__56491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__SubQueryAssignment_6_in_rule__SubselectWhereEntry__Group__66519 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__SubselectWhereEntry__Group__7_in_rule__SubselectWhereEntry__Group__66528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__SubselectWhereEntry__Group__76557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__AliasAssignment_0_in_rule__AliasWhereEntry__Group__06608 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__1_in_rule__AliasWhereEntry__Group__06617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__AliasWhereEntry__Group__16646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__Group__2_in_rule__AliasWhereEntry__Group__16656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasWhereEntry__RightAliasAssignment_2_in_rule__AliasWhereEntry__Group__26684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_16755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_26786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_16817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_06848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_26879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_16910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_2_16941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_46972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_5_17003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_17187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ElementScope__NotInAssignment_07399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AliasAssignment_07566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DoubleWhereEntry__AttributeAssignment_27605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__DoubleWhereEntry__OperatorAssignment_37640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleWhereEntry__ValueAssignment_47671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AliasAssignment_07706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LongWhereEntry__AttributeAssignment_27745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__LongWhereEntry__OperatorAssignment_37780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongWhereEntry__ValueAssignment_47811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AliasAssignment_07846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__AttributeAssignment_27885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__VariableWhereEntry__OperatorAssignment_37920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAliasAssignment_47955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableWhereEntry__RightAttributeAssignment_67994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AliasAssignment_08033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__StringAttributeWhereEntry__AttributeAssignment_28072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringOperator_in_rule__StringAttributeWhereEntry__OperatorAssignment_38107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringAttributeWhereEntry__PatternAssignment_48138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AliasAssignment_08173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__BooleanAttributeWhereEntry__AttributeAssignment_28212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__BooleanAttributeWhereEntry__OperatorAssignment_38247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__BooleanAttributeWhereEntry__IsTrueAssignment_4_08283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__AliasAssignment_08326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NullWhereEntry__FeatureAssignment_28365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_rule__NullWhereEntry__OperatorAssignment_38400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__AliasAssignment_08435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__ReferenceAssignment_28474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceAliasWhereEntry__RightAliasAssignment_48513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__AliasAssignment_08552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SubselectWhereEntry__ReferenceAssignment_28591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SubselectWhereEntry__NotInAssignment_38631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__SubselectWhereEntry__SubQueryAssignment_68670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__AliasAssignment_08705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasWhereEntry__RightAliasAssignment_28744 = new BitSet(new long[]{0x0000000000000002L});

}