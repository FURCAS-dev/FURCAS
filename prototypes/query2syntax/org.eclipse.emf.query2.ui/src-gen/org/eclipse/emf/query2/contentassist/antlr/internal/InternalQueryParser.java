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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'not like'", "'not in'", "'in'", "'import'", "':'", "'from'", "'select'", "','", "'where'", "'.'", "'as'", "'{'", "'}'", "'resources'", "'elements'", "'or'", "'and'", "'('", "')'", "'withoutsubtypes'", "'not'", "'null'", "'true'"
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


    // $ANTLR start entryRuleExpressionWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:1: entryRuleExpressionWhereEntry : ruleExpressionWhereEntry EOF ;
    public final void entryRuleExpressionWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:411:31: ( ruleExpressionWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:412:1: ruleExpressionWhereEntry EOF
            {
             before(grammarAccess.getExpressionWhereEntryRule()); 
            pushFollow(FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry840);
            ruleExpressionWhereEntry();
            _fsp--;

             after(grammarAccess.getExpressionWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionWhereEntry847); 

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
    // $ANTLR end entryRuleExpressionWhereEntry


    // $ANTLR start ruleExpressionWhereEntry
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:419:1: ruleExpressionWhereEntry : ( ( rule__ExpressionWhereEntry__Group__0 ) ) ;
    public final void ruleExpressionWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:423:2: ( ( ( rule__ExpressionWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__ExpressionWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:424:1: ( ( rule__ExpressionWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:425:1: ( rule__ExpressionWhereEntry__Group__0 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:1: ( rule__ExpressionWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:426:2: rule__ExpressionWhereEntry__Group__0
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__0_in_ruleExpressionWhereEntry874);
            rule__ExpressionWhereEntry__Group__0();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleExpressionWhereEntry


    // $ANTLR start entryRuleAliasAttributeExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:1: entryRuleAliasAttributeExpression : ruleAliasAttributeExpression EOF ;
    public final void entryRuleAliasAttributeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:438:35: ( ruleAliasAttributeExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:439:1: ruleAliasAttributeExpression EOF
            {
             before(grammarAccess.getAliasAttributeExpressionRule()); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression900);
            ruleAliasAttributeExpression();
            _fsp--;

             after(grammarAccess.getAliasAttributeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasAttributeExpression907); 

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
    // $ANTLR end entryRuleAliasAttributeExpression


    // $ANTLR start ruleAliasAttributeExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:446:1: ruleAliasAttributeExpression : ( ( rule__AliasAttributeExpression__Group__0 ) ) ;
    public final void ruleAliasAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:450:2: ( ( ( rule__AliasAttributeExpression__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__AliasAttributeExpression__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:451:1: ( ( rule__AliasAttributeExpression__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:452:1: ( rule__AliasAttributeExpression__Group__0 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:1: ( rule__AliasAttributeExpression__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:453:2: rule__AliasAttributeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__0_in_ruleAliasAttributeExpression934);
            rule__AliasAttributeExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAliasAttributeExpression


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:465:21: ( ruleExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:466:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression960);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression967); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:473:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:477:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:478:1: ( ( rule__Expression__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:479:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:1: ( rule__Expression__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:480:2: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_rule__Expression__Alternatives_in_ruleExpression994);
            rule__Expression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleDoubleExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:1: entryRuleDoubleExpression : ruleDoubleExpression EOF ;
    public final void entryRuleDoubleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:492:27: ( ruleDoubleExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:493:1: ruleDoubleExpression EOF
            {
             before(grammarAccess.getDoubleExpressionRule()); 
            pushFollow(FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1020);
            ruleDoubleExpression();
            _fsp--;

             after(grammarAccess.getDoubleExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleExpression1027); 

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
    // $ANTLR end entryRuleDoubleExpression


    // $ANTLR start ruleDoubleExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:500:1: ruleDoubleExpression : ( ( rule__DoubleExpression__ValueAssignment ) ) ;
    public final void ruleDoubleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:504:2: ( ( ( rule__DoubleExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:505:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:506:1: ( rule__DoubleExpression__ValueAssignment )
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:1: ( rule__DoubleExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:507:2: rule__DoubleExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DoubleExpression__ValueAssignment_in_ruleDoubleExpression1054);
            rule__DoubleExpression__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getDoubleExpressionAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleDoubleExpression


    // $ANTLR start entryRuleLongExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:1: entryRuleLongExpression : ruleLongExpression EOF ;
    public final void entryRuleLongExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:519:25: ( ruleLongExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:520:1: ruleLongExpression EOF
            {
             before(grammarAccess.getLongExpressionRule()); 
            pushFollow(FOLLOW_ruleLongExpression_in_entryRuleLongExpression1080);
            ruleLongExpression();
            _fsp--;

             after(grammarAccess.getLongExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongExpression1087); 

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
    // $ANTLR end entryRuleLongExpression


    // $ANTLR start ruleLongExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:527:1: ruleLongExpression : ( ( rule__LongExpression__ValueAssignment ) ) ;
    public final void ruleLongExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:531:2: ( ( ( rule__LongExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__LongExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:532:1: ( ( rule__LongExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:533:1: ( rule__LongExpression__ValueAssignment )
            {
             before(grammarAccess.getLongExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:1: ( rule__LongExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:534:2: rule__LongExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LongExpression__ValueAssignment_in_ruleLongExpression1114);
            rule__LongExpression__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getLongExpressionAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleLongExpression


    // $ANTLR start entryRuleStringExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:1: entryRuleStringExpression : ruleStringExpression EOF ;
    public final void entryRuleStringExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:546:27: ( ruleStringExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:547:1: ruleStringExpression EOF
            {
             before(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression1140);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getStringExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression1147); 

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
    // $ANTLR end entryRuleStringExpression


    // $ANTLR start ruleStringExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:554:1: ruleStringExpression : ( ( rule__StringExpression__ValueAssignment ) ) ;
    public final void ruleStringExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:558:2: ( ( ( rule__StringExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__StringExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:559:1: ( ( rule__StringExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:560:1: ( rule__StringExpression__ValueAssignment )
            {
             before(grammarAccess.getStringExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:1: ( rule__StringExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:561:2: rule__StringExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringExpression__ValueAssignment_in_ruleStringExpression1174);
            rule__StringExpression__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getStringExpressionAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringExpression


    // $ANTLR start entryRuleNullExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:1: entryRuleNullExpression : ruleNullExpression EOF ;
    public final void entryRuleNullExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:573:25: ( ruleNullExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:574:1: ruleNullExpression EOF
            {
             before(grammarAccess.getNullExpressionRule()); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression1200);
            ruleNullExpression();
            _fsp--;

             after(grammarAccess.getNullExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression1207); 

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
    // $ANTLR end entryRuleNullExpression


    // $ANTLR start ruleNullExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:581:1: ruleNullExpression : ( ( rule__NullExpression__ValueAssignment ) ) ;
    public final void ruleNullExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:585:2: ( ( ( rule__NullExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__NullExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:586:1: ( ( rule__NullExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:587:1: ( rule__NullExpression__ValueAssignment )
            {
             before(grammarAccess.getNullExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:1: ( rule__NullExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:588:2: rule__NullExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__NullExpression__ValueAssignment_in_ruleNullExpression1234);
            rule__NullExpression__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getNullExpressionAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNullExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:600:28: ( ruleBooleanExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:601:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1260);
            ruleBooleanExpression();
            _fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression1267); 

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
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:608:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:612:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:613:1: ( ( rule__BooleanExpression__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:614:1: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:1: ( rule__BooleanExpression__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:615:2: rule__BooleanExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Alternatives_in_ruleBooleanExpression1294);
            rule__BooleanExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanExpression


    // $ANTLR start entryRuleQueryExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:1: entryRuleQueryExpression : ruleQueryExpression EOF ;
    public final void entryRuleQueryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:627:26: ( ruleQueryExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:628:1: ruleQueryExpression EOF
            {
             before(grammarAccess.getQueryExpressionRule()); 
            pushFollow(FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1320);
            ruleQueryExpression();
            _fsp--;

             after(grammarAccess.getQueryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryExpression1327); 

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
    // $ANTLR end entryRuleQueryExpression


    // $ANTLR start ruleQueryExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:635:1: ruleQueryExpression : ( ( rule__QueryExpression__Group__0 ) ) ;
    public final void ruleQueryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:639:2: ( ( ( rule__QueryExpression__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__QueryExpression__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:640:1: ( ( rule__QueryExpression__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:641:1: ( rule__QueryExpression__Group__0 )
            {
             before(grammarAccess.getQueryExpressionAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:1: ( rule__QueryExpression__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:642:2: rule__QueryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__0_in_ruleQueryExpression1354);
            rule__QueryExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getQueryExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleQueryExpression


    // $ANTLR start ruleOperator
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:655:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:659:1: ( ( ( rule__Operator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:660:1: ( ( rule__Operator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:660:1: ( ( rule__Operator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:661:1: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:662:1: ( rule__Operator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:662:2: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_rule__Operator__Alternatives_in_ruleOperator1391);
            rule__Operator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOperator


    // $ANTLR start rule__ScopeClause__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:673:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__ScopeClause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:677:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==21) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==33) ) {
                        alt1=2;
                    }
                    else if ( (LA1_2==32) ) {
                        alt1=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("673:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("673:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==21) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==33) ) {
                    alt1=2;
                }
                else if ( (LA1_2==32) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("673:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("673:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:678:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:678:1: ( ruleResourceScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:679:1: ruleResourceScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1426);
                    ruleResourceScope();
                    _fsp--;

                     after(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:684:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:684:6: ( ruleElementScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:685:1: ruleElementScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1443);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:695:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:699:1: ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==36) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("695:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:700:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:700:1: ( ruleParWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:701:1: ruleParWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1475);
                    ruleParWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:706:6: ( ruleExpressionWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:706:6: ( ruleExpressionWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:707:1: ruleExpressionWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getExpressionWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleExpressionWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1492);
                    ruleExpressionWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getExpressionWhereEntryParserRuleCall_1()); 

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


    // $ANTLR start rule__Expression__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:717:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:721:1: ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) )
            int alt3=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case RULE_SIGNED_DOUBLE:
                {
                alt3=2;
                }
                break;
            case RULE_SINGED_LONG:
                {
                alt3=3;
                }
                break;
            case RULE_STRING:
                {
                alt3=4;
                }
                break;
            case 40:
                {
                alt3=5;
                }
                break;
            case 11:
            case 41:
                {
                alt3=6;
                }
                break;
            case 36:
                {
                alt3=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("717:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:722:1: ( ruleAliasAttributeExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:722:1: ( ruleAliasAttributeExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:723:1: ruleAliasAttributeExpression
                    {
                     before(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAliasAttributeExpression_in_rule__Expression__Alternatives1524);
                    ruleAliasAttributeExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:728:6: ( ruleDoubleExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:728:6: ( ruleDoubleExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:729:1: ruleDoubleExpression
                    {
                     before(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDoubleExpression_in_rule__Expression__Alternatives1541);
                    ruleDoubleExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:734:6: ( ruleLongExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:734:6: ( ruleLongExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:735:1: ruleLongExpression
                    {
                     before(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleLongExpression_in_rule__Expression__Alternatives1558);
                    ruleLongExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:740:6: ( ruleStringExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:740:6: ( ruleStringExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:741:1: ruleStringExpression
                    {
                     before(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleStringExpression_in_rule__Expression__Alternatives1575);
                    ruleStringExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:746:6: ( ruleNullExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:746:6: ( ruleNullExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:747:1: ruleNullExpression
                    {
                     before(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleNullExpression_in_rule__Expression__Alternatives1592);
                    ruleNullExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:752:6: ( ruleBooleanExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:752:6: ( ruleBooleanExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:753:1: ruleBooleanExpression
                    {
                     before(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleBooleanExpression_in_rule__Expression__Alternatives1609);
                    ruleBooleanExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:758:6: ( ruleQueryExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:758:6: ( ruleQueryExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:759:1: ruleQueryExpression
                    {
                     before(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleQueryExpression_in_rule__Expression__Alternatives1626);
                    ruleQueryExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6()); 

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
    // $ANTLR end rule__Expression__Alternatives


    // $ANTLR start rule__BooleanExpression__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:769:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:773:1: ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==41) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("769:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:774:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:774:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:775:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getTrueAssignment_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:776:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:776:2: rule__BooleanExpression__TrueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__BooleanExpression__TrueAssignment_0_in_rule__BooleanExpression__Alternatives1658);
                    rule__BooleanExpression__TrueAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getBooleanExpressionAccess().getTrueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:780:6: ( 'false' )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:780:6: ( 'false' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:781:1: 'false'
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getFalseKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanExpression__Alternatives1677); 
                     after(grammarAccess.getBooleanExpressionAccess().getFalseKeyword_1()); 

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
    // $ANTLR end rule__BooleanExpression__Alternatives


    // $ANTLR start rule__Operator__Alternatives
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:793:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:797:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) )
            int alt5=10;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt5=1;
                }
                break;
            case 13:
                {
                alt5=2;
                }
                break;
            case 14:
                {
                alt5=3;
                }
                break;
            case 15:
                {
                alt5=4;
                }
                break;
            case 16:
                {
                alt5=5;
                }
                break;
            case 17:
                {
                alt5=6;
                }
                break;
            case 18:
                {
                alt5=7;
                }
                break;
            case 19:
                {
                alt5=8;
                }
                break;
            case 20:
                {
                alt5=9;
                }
                break;
            case 21:
                {
                alt5=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("793:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:798:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:798:1: ( ( '<' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:799:1: ( '<' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:800:1: ( '<' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:800:3: '<'
                    {
                    match(input,12,FOLLOW_12_in_rule__Operator__Alternatives1712); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:805:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:805:6: ( ( '>' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:806:1: ( '>' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:807:1: ( '>' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:807:3: '>'
                    {
                    match(input,13,FOLLOW_13_in_rule__Operator__Alternatives1733); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:812:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:812:6: ( ( '<=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:813:1: ( '<=' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:814:1: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:814:3: '<='
                    {
                    match(input,14,FOLLOW_14_in_rule__Operator__Alternatives1754); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:819:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:819:6: ( ( '>=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:820:1: ( '>=' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:821:1: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:821:3: '>='
                    {
                    match(input,15,FOLLOW_15_in_rule__Operator__Alternatives1775); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:826:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:826:6: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:827:1: ( '=' )
                    {
                     before(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:828:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:828:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__Operator__Alternatives1796); 

                    }

                     after(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:833:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:833:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:834:1: ( '!=' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:835:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:835:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__Operator__Alternatives1817); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:840:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:840:6: ( ( 'like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:841:1: ( 'like' )
                    {
                     before(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:842:1: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:842:3: 'like'
                    {
                    match(input,18,FOLLOW_18_in_rule__Operator__Alternatives1838); 

                    }

                     after(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:847:6: ( ( 'not like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:847:6: ( ( 'not like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:848:1: ( 'not like' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:849:1: ( 'not like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:849:3: 'not like'
                    {
                    match(input,19,FOLLOW_19_in_rule__Operator__Alternatives1859); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:854:6: ( ( 'not in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:854:6: ( ( 'not in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:855:1: ( 'not in' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:856:1: ( 'not in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:856:3: 'not in'
                    {
                    match(input,20,FOLLOW_20_in_rule__Operator__Alternatives1880); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:861:6: ( ( 'in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:861:6: ( ( 'in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:862:1: ( 'in' )
                    {
                     before(grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:863:1: ( 'in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:863:3: 'in'
                    {
                    match(input,21,FOLLOW_21_in_rule__Operator__Alternatives1901); 

                    }

                     after(grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9()); 

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
    // $ANTLR end rule__Operator__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:875:1: rule__Model__Group__0 : ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:879:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:880:1: ( ( rule__Model__ImportsAssignment_0 )* ) rule__Model__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:880:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:881:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:882:1: ( rule__Model__ImportsAssignment_0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:882:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__01938);
            	    rule__Model__ImportsAssignment_0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01948);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:893:1: rule__Model__Group__1 : ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:897:1: ( ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:898:1: ( ( rule__Model__DefaultQueryAssignment_1 )? ) rule__Model__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:898:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:899:1: ( rule__Model__DefaultQueryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:900:1: ( rule__Model__DefaultQueryAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:900:2: rule__Model__DefaultQueryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__11976);
                    rule__Model__DefaultQueryAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11986);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:911:1: rule__Model__Group__2 : ( ( rule__Model__NamedQueriesAssignment_2 )* ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:915:1: ( ( ( rule__Model__NamedQueriesAssignment_2 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:916:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:916:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:917:1: ( rule__Model__NamedQueriesAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:918:1: ( rule__Model__NamedQueriesAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:918:2: rule__Model__NamedQueriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22014);
            	    rule__Model__NamedQueriesAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:934:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:938:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:939:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:939:1: ( 'import' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:940:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__02056); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02066);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:954:1: rule__Import__Group__1 : ( ( rule__Import__ImpURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:958:1: ( ( ( rule__Import__ImpURIAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:959:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:959:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:960:1: ( rule__Import__ImpURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImpURIAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:961:1: ( rule__Import__ImpURIAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:961:2: rule__Import__ImpURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__12094);
            rule__Import__ImpURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImpURIAssignment_1()); 

            }


            }

        }
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:975:1: rule__NamedQuery__Group__0 : ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 ;
    public final void rule__NamedQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:979:1: ( ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:980:1: ( ( rule__NamedQuery__NameAssignment_0 ) ) rule__NamedQuery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:980:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:981:1: ( rule__NamedQuery__NameAssignment_0 )
            {
             before(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:1: ( rule__NamedQuery__NameAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:982:2: rule__NamedQuery__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02132);
            rule__NamedQuery__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02141);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:993:1: rule__NamedQuery__Group__1 : ( ':' ) rule__NamedQuery__Group__2 ;
    public final void rule__NamedQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:997:1: ( ( ':' ) rule__NamedQuery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:998:1: ( ':' ) rule__NamedQuery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:998:1: ( ':' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:999:1: ':'
            {
             before(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__NamedQuery__Group__12170); 
             after(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12180);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1013:1: rule__NamedQuery__Group__2 : ( ( rule__NamedQuery__QueryAssignment_2 ) ) ;
    public final void rule__NamedQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1017:1: ( ( ( rule__NamedQuery__QueryAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1018:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1018:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1019:1: ( rule__NamedQuery__QueryAssignment_2 )
            {
             before(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:1: ( rule__NamedQuery__QueryAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1020:2: rule__NamedQuery__QueryAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22208);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1036:1: rule__MQLquery__Group__0 : ( 'from' ) rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1040:1: ( ( 'from' ) rule__MQLquery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1041:1: ( 'from' ) rule__MQLquery__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1041:1: ( 'from' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1042:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group__02249); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02259);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1056:1: rule__MQLquery__Group__1 : ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1060:1: ( ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) rule__MQLquery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1061:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) rule__MQLquery__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1061:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1062:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1063:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1063:2: rule__MQLquery__FromEntriesAssignment_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__12287);
            rule__MQLquery__FromEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12296);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1074:1: rule__MQLquery__Group__2 : ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1078:1: ( ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:1: ( ( rule__MQLquery__Group_2__0 )* ) rule__MQLquery__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1079:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1080:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1081:1: ( rule__MQLquery__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1081:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22324);
            	    rule__MQLquery__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22334);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1092:1: rule__MQLquery__Group__3 : ( 'select' ) rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1096:1: ( ( 'select' ) rule__MQLquery__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1097:1: ( 'select' ) rule__MQLquery__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1097:1: ( 'select' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1098:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__MQLquery__Group__32363); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32373);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1112:1: rule__MQLquery__Group__4 : ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1116:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) rule__MQLquery__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1117:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) rule__MQLquery__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1117:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1118:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1119:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1119:2: rule__MQLquery__SelectEntriesAssignment_4
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__42401);
            rule__MQLquery__SelectEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42410);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1130:1: rule__MQLquery__Group__5 : ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1134:1: ( ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1135:1: ( ( rule__MQLquery__Group_5__0 )* ) rule__MQLquery__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1135:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1136:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1137:1: ( rule__MQLquery__Group_5__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1137:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52438);
            	    rule__MQLquery__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMQLqueryAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52448);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1148:1: rule__MQLquery__Group__6 : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1152:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1153:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1153:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1154:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1155:1: ( rule__MQLquery__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1155:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62476);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1179:1: rule__MQLquery__Group_2__0 : ( ',' ) rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1183:1: ( ( ',' ) rule__MQLquery__Group_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1184:1: ( ',' ) rule__MQLquery__Group_2__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1184:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1185:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_2__02526); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02536);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1199:1: rule__MQLquery__Group_2__1 : ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1203:1: ( ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1204:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1204:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1205:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1206:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1206:2: rule__MQLquery__FromEntriesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12564);
            rule__MQLquery__FromEntriesAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_2_1()); 

            }


            }

        }
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1220:1: rule__MQLquery__Group_5__0 : ( ',' ) rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1224:1: ( ( ',' ) rule__MQLquery__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1225:1: ( ',' ) rule__MQLquery__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1225:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1226:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_5__02603); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02613);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1240:1: rule__MQLquery__Group_5__1 : ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1244:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1245:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1245:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1246:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1247:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1247:2: rule__MQLquery__SelectEntriesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__12641);
            rule__MQLquery__SelectEntriesAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_5_1()); 

            }


            }

        }
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1261:1: rule__MQLquery__Group_6__0 : ( 'where' ) rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1265:1: ( ( 'where' ) rule__MQLquery__Group_6__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1266:1: ( 'where' ) rule__MQLquery__Group_6__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1266:1: ( 'where' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1267:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,27,FOLLOW_27_in_rule__MQLquery__Group_6__02680); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }

            pushFollow(FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__02690);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1281:1: rule__MQLquery__Group_6__1 : ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1285:1: ( ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1286:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1286:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1287:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1288:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1288:2: rule__MQLquery__WhereEntryAssignment_6_1
            {
            pushFollow(FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__12718);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1302:1: rule__SelectEntry__Group__0 : ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1306:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1307:1: ( ( rule__SelectEntry__SelectAssignment_0 ) ) rule__SelectEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1307:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1308:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1309:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1309:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__02756);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__02765);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1320:1: rule__SelectEntry__Group__1 : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1324:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1325:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1325:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1326:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1327:1: ( rule__SelectEntry__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1327:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__12793);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1341:1: rule__SelectEntry__Group_1__0 : ( '.' ) rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1345:1: ( ( '.' ) rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1346:1: ( '.' ) rule__SelectEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1346:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1347:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__SelectEntry__Group_1__02833); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__02843);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1361:1: rule__SelectEntry__Group_1__1 : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1365:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1366:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1366:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1367:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1368:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1368:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__12871);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1382:1: rule__FromEntry__Group__0 : ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1386:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1387:1: ( ( rule__FromEntry__TypeAssignment_0 ) ) rule__FromEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1387:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1388:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1389:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1389:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__02909);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__02918);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1400:1: rule__FromEntry__Group__1 : ( ( rule__FromEntry__Group_1__0 )? ) rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1404:1: ( ( ( rule__FromEntry__Group_1__0 )? ) rule__FromEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1405:1: ( ( rule__FromEntry__Group_1__0 )? ) rule__FromEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1405:1: ( ( rule__FromEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1406:1: ( rule__FromEntry__Group_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1407:1: ( rule__FromEntry__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1407:2: rule__FromEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__12946);
                    rule__FromEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getGroup_1()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__12956);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1418:1: rule__FromEntry__Group__2 : ( 'as' ) rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1422:1: ( ( 'as' ) rule__FromEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1423:1: ( 'as' ) rule__FromEntry__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1423:1: ( 'as' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1424:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__FromEntry__Group__22985); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__22995);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1438:1: rule__FromEntry__Group__3 : ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1442:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1443:1: ( ( rule__FromEntry__AliasAssignment_3 ) ) rule__FromEntry__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1443:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1444:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1445:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1445:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33023);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33032);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1456:1: rule__FromEntry__Group__4 : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1460:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1461:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1461:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1462:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1463:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21||LA14_0==39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1463:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43060);
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


    // $ANTLR start rule__FromEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1483:1: rule__FromEntry__Group_1__0 : ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) rule__FromEntry__Group_1__1 ;
    public final void rule__FromEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1487:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) rule__FromEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1488:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) rule__FromEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1488:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1489:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1490:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1490:2: rule__FromEntry__WithoutsubtypesAssignment_1_0
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__03105);
            rule__FromEntry__WithoutsubtypesAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03114);
            rule__FromEntry__Group_1__1();
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
    // $ANTLR end rule__FromEntry__Group_1__0


    // $ANTLR start rule__FromEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1501:1: rule__FromEntry__Group_1__1 : ( ( rule__FromEntry__Group_1_1__0 )? ) ;
    public final void rule__FromEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1505:1: ( ( ( rule__FromEntry__Group_1_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1506:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1507:1: ( rule__FromEntry__Group_1_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1508:1: ( rule__FromEntry__Group_1_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1508:2: rule__FromEntry__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__13142);
                    rule__FromEntry__Group_1_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1__1


    // $ANTLR start rule__FromEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1522:1: rule__FromEntry__Group_1_1__0 : ( '{' ) rule__FromEntry__Group_1_1__1 ;
    public final void rule__FromEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1526:1: ( ( '{' ) rule__FromEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1527:1: ( '{' ) rule__FromEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1527:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1528:1: '{'
            {
             before(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__FromEntry__Group_1_1__03182); 
             after(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03192);
            rule__FromEntry__Group_1_1__1();
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
    // $ANTLR end rule__FromEntry__Group_1_1__0


    // $ANTLR start rule__FromEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1542:1: rule__FromEntry__Group_1_1__1 : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) rule__FromEntry__Group_1_1__2 ;
    public final void rule__FromEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1546:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) rule__FromEntry__Group_1_1__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1547:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) rule__FromEntry__Group_1_1__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1547:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1548:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1549:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1549:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__13220);
            rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_1()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__13229);
            rule__FromEntry__Group_1_1__2();
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
    // $ANTLR end rule__FromEntry__Group_1_1__1


    // $ANTLR start rule__FromEntry__Group_1_1__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1560:1: rule__FromEntry__Group_1_1__2 : ( ( rule__FromEntry__Group_1_1_2__0 )* ) rule__FromEntry__Group_1_1__3 ;
    public final void rule__FromEntry__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1564:1: ( ( ( rule__FromEntry__Group_1_1_2__0 )* ) rule__FromEntry__Group_1_1__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:1: ( ( rule__FromEntry__Group_1_1_2__0 )* ) rule__FromEntry__Group_1_1__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1565:1: ( ( rule__FromEntry__Group_1_1_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1566:1: ( rule__FromEntry__Group_1_1_2__0 )*
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1567:1: ( rule__FromEntry__Group_1_1_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1567:2: rule__FromEntry__Group_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__23257);
            	    rule__FromEntry__Group_1_1_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getFromEntryAccess().getGroup_1_1_2()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__23267);
            rule__FromEntry__Group_1_1__3();
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
    // $ANTLR end rule__FromEntry__Group_1_1__2


    // $ANTLR start rule__FromEntry__Group_1_1__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1578:1: rule__FromEntry__Group_1_1__3 : ( '}' ) ;
    public final void rule__FromEntry__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1582:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1583:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1583:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1584:1: '}'
            {
             before(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3()); 
            match(input,31,FOLLOW_31_in_rule__FromEntry__Group_1_1__33296); 
             after(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1__3


    // $ANTLR start rule__FromEntry__Group_1_1_2__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1605:1: rule__FromEntry__Group_1_1_2__0 : ( ',' ) rule__FromEntry__Group_1_1_2__1 ;
    public final void rule__FromEntry__Group_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1609:1: ( ( ',' ) rule__FromEntry__Group_1_1_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1610:1: ( ',' ) rule__FromEntry__Group_1_1_2__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1610:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1611:1: ','
            {
             before(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0()); 
            match(input,26,FOLLOW_26_in_rule__FromEntry__Group_1_1_2__03340); 
             after(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0()); 

            }

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__03350);
            rule__FromEntry__Group_1_1_2__1();
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
    // $ANTLR end rule__FromEntry__Group_1_1_2__0


    // $ANTLR start rule__FromEntry__Group_1_1_2__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1625:1: rule__FromEntry__Group_1_1_2__1 : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) ;
    public final void rule__FromEntry__Group_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1629:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1630:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1630:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1631:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1632:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1632:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__13378);
            rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1_2__1


    // $ANTLR start rule__ResourceScope__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1646:1: rule__ResourceScope__Group__0 : ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1650:1: ( ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1651:1: ( ( rule__ResourceScope__NotInAssignment_0 )? ) rule__ResourceScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1651:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1652:1: ( rule__ResourceScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1653:1: ( rule__ResourceScope__NotInAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1653:2: rule__ResourceScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03416);
                    rule__ResourceScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03426);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1664:1: rule__ResourceScope__Group__1 : ( 'in' ) rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1668:1: ( ( 'in' ) rule__ResourceScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1669:1: ( 'in' ) rule__ResourceScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1669:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1670:1: 'in'
            {
             before(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ResourceScope__Group__13455); 
             after(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13465);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1684:1: rule__ResourceScope__Group__2 : ( 'resources' ) rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1688:1: ( ( 'resources' ) rule__ResourceScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1689:1: ( 'resources' ) rule__ResourceScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1689:1: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1690:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ResourceScope__Group__23494); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23504);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1704:1: rule__ResourceScope__Group__3 : ( '{' ) rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1708:1: ( ( '{' ) rule__ResourceScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1709:1: ( '{' ) rule__ResourceScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1709:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1710:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ResourceScope__Group__33533); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33543);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1724:1: rule__ResourceScope__Group__4 : ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1728:1: ( ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1729:1: ( ( rule__ResourceScope__UrisAssignment_4 ) ) rule__ResourceScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1729:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1730:1: ( rule__ResourceScope__UrisAssignment_4 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1731:1: ( rule__ResourceScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1731:2: rule__ResourceScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43571);
            rule__ResourceScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43580);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1742:1: rule__ResourceScope__Group__5 : ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 ;
    public final void rule__ResourceScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1746:1: ( ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1747:1: ( ( rule__ResourceScope__Group_5__0 )* ) rule__ResourceScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1747:1: ( ( rule__ResourceScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1748:1: ( rule__ResourceScope__Group_5__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1749:1: ( rule__ResourceScope__Group_5__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==26) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1749:2: rule__ResourceScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53608);
            	    rule__ResourceScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getResourceScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53618);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1760:1: rule__ResourceScope__Group__6 : ( '}' ) ;
    public final void rule__ResourceScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1764:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1765:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1765:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1766:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ResourceScope__Group__63647); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1793:1: rule__ResourceScope__Group_5__0 : ( ',' ) rule__ResourceScope__Group_5__1 ;
    public final void rule__ResourceScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1797:1: ( ( ',' ) rule__ResourceScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1798:1: ( ',' ) rule__ResourceScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1798:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1799:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ResourceScope__Group_5__03697); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03707);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1813:1: rule__ResourceScope__Group_5__1 : ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ResourceScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1817:1: ( ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1818:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1818:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1819:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1820:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1820:2: rule__ResourceScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13735);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1834:1: rule__ElementScope__Group__0 : ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1838:1: ( ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1839:1: ( ( rule__ElementScope__NotInAssignment_0 )? ) rule__ElementScope__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1839:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1840:1: ( rule__ElementScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1841:1: ( rule__ElementScope__NotInAssignment_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1841:2: rule__ElementScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03773);
                    rule__ElementScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03783);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1852:1: rule__ElementScope__Group__1 : ( 'in' ) rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1856:1: ( ( 'in' ) rule__ElementScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1857:1: ( 'in' ) rule__ElementScope__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1857:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1858:1: 'in'
            {
             before(grammarAccess.getElementScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ElementScope__Group__13812); 
             after(grammarAccess.getElementScopeAccess().getInKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13822);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1872:1: rule__ElementScope__Group__2 : ( 'elements' ) rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1876:1: ( ( 'elements' ) rule__ElementScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1877:1: ( 'elements' ) rule__ElementScope__Group__3
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1877:1: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1878:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__ElementScope__Group__23851); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23861);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1892:1: rule__ElementScope__Group__3 : ( '{' ) rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1896:1: ( ( '{' ) rule__ElementScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1897:1: ( '{' ) rule__ElementScope__Group__4
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1897:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1898:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ElementScope__Group__33890); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__33900);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1912:1: rule__ElementScope__Group__4 : ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1916:1: ( ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1917:1: ( ( rule__ElementScope__UrisAssignment_4 ) ) rule__ElementScope__Group__5
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1917:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1918:1: ( rule__ElementScope__UrisAssignment_4 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1919:1: ( rule__ElementScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1919:2: rule__ElementScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__43928);
            rule__ElementScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__43937);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1930:1: rule__ElementScope__Group__5 : ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 ;
    public final void rule__ElementScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1934:1: ( ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1935:1: ( ( rule__ElementScope__Group_5__0 )* ) rule__ElementScope__Group__6
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1935:1: ( ( rule__ElementScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1936:1: ( rule__ElementScope__Group_5__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1937:1: ( rule__ElementScope__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1937:2: rule__ElementScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__53965);
            	    rule__ElementScope__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getElementScopeAccess().getGroup_5()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__53975);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1948:1: rule__ElementScope__Group__6 : ( '}' ) ;
    public final void rule__ElementScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1952:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1953:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1953:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1954:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ElementScope__Group__64004); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1981:1: rule__ElementScope__Group_5__0 : ( ',' ) rule__ElementScope__Group_5__1 ;
    public final void rule__ElementScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1985:1: ( ( ',' ) rule__ElementScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1986:1: ( ',' ) rule__ElementScope__Group_5__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1986:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:1987:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ElementScope__Group_5__04054); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 

            }

            pushFollow(FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04064);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2001:1: rule__ElementScope__Group_5__1 : ( ( rule__ElementScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ElementScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2005:1: ( ( ( rule__ElementScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2006:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2006:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2007:1: ( rule__ElementScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2008:1: ( rule__ElementScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2008:2: rule__ElementScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14092);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2022:1: rule__WhereEntry__Group__0 : ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2026:1: ( ( ruleAndWhereEntry ) rule__WhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2027:1: ( ruleAndWhereEntry ) rule__WhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2027:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2028:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04130);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04138);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2040:1: rule__WhereEntry__Group__1 : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2044:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2045:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2045:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2046:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2047:1: ( rule__WhereEntry__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2047:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14166);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2061:1: rule__WhereEntry__Group_1__0 : ( () ) rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2065:1: ( ( () ) rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2066:1: ( () ) rule__WhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2066:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2067:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2068:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2070:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04215);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2081:1: rule__WhereEntry__Group_1__1 : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2085:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2086:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2086:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2087:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2087:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2088:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2089:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2089:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14245);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2092:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2093:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2094:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2094:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14257);
            	    rule__WhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2109:1: rule__WhereEntry__Group_1_1__0 : ( 'or' ) rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2113:1: ( ( 'or' ) rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2114:1: ( 'or' ) rule__WhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2114:1: ( 'or' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2115:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__WhereEntry__Group_1_1__04299); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04309);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2129:1: rule__WhereEntry__Group_1_1__1 : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2133:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2134:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2134:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2135:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2136:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2136:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14337);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2150:1: rule__AndWhereEntry__Group__0 : ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2154:1: ( ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2155:1: ( ruleConcreteWhereEntry ) rule__AndWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2155:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2156:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04375);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04383);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2168:1: rule__AndWhereEntry__Group__1 : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2172:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2173:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2173:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2174:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2175:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2175:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14411);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2189:1: rule__AndWhereEntry__Group_1__0 : ( () ) rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2193:1: ( ( () ) rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2194:1: ( () ) rule__AndWhereEntry__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2194:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2195:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2196:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2198:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04460);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2209:1: rule__AndWhereEntry__Group_1__1 : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2213:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2214:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2214:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2215:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2215:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2216:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2217:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2217:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14490);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2220:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2221:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2222:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2222:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14502);
            	    rule__AndWhereEntry__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2237:1: rule__AndWhereEntry__Group_1_1__0 : ( 'and' ) rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2241:1: ( ( 'and' ) rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2242:1: ( 'and' ) rule__AndWhereEntry__Group_1_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2242:1: ( 'and' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2243:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,35,FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__04544); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04554);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2257:1: rule__AndWhereEntry__Group_1_1__1 : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2261:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2262:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2262:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2263:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2264:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2264:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14582);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2278:1: rule__ParWhereEntry__Group__0 : ( '(' ) rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2282:1: ( ( '(' ) rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2283:1: ( '(' ) rule__ParWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2283:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2284:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ParWhereEntry__Group__04621); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04631);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2298:1: rule__ParWhereEntry__Group__1 : ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2302:1: ( ( ruleWhereEntry ) rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2303:1: ( ruleWhereEntry ) rule__ParWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2303:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2304:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14659);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14667);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2316:1: rule__ParWhereEntry__Group__2 : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2320:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2321:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2321:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2322:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__ParWhereEntry__Group__24696); 
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


    // $ANTLR start rule__ExpressionWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2341:1: rule__ExpressionWhereEntry__Group__0 : ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) rule__ExpressionWhereEntry__Group__1 ;
    public final void rule__ExpressionWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2345:1: ( ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) rule__ExpressionWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2346:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) rule__ExpressionWhereEntry__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2346:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2347:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2348:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2348:2: rule__ExpressionWhereEntry__LhsAssignment_0
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__04737);
            rule__ExpressionWhereEntry__LhsAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getLhsAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__04746);
            rule__ExpressionWhereEntry__Group__1();
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
    // $ANTLR end rule__ExpressionWhereEntry__Group__0


    // $ANTLR start rule__ExpressionWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2359:1: rule__ExpressionWhereEntry__Group__1 : ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) rule__ExpressionWhereEntry__Group__2 ;
    public final void rule__ExpressionWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2363:1: ( ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) rule__ExpressionWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2364:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) rule__ExpressionWhereEntry__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2364:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2365:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2366:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2366:2: rule__ExpressionWhereEntry__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__14774);
            rule__ExpressionWhereEntry__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getOperatorAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__14783);
            rule__ExpressionWhereEntry__Group__2();
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
    // $ANTLR end rule__ExpressionWhereEntry__Group__1


    // $ANTLR start rule__ExpressionWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2377:1: rule__ExpressionWhereEntry__Group__2 : ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2381:1: ( ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2382:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2382:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2383:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2384:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2384:2: rule__ExpressionWhereEntry__RhsAssignment_2
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__24811);
            rule__ExpressionWhereEntry__RhsAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getRhsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__Group__2


    // $ANTLR start rule__AliasAttributeExpression__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2400:1: rule__AliasAttributeExpression__Group__0 : ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) rule__AliasAttributeExpression__Group__1 ;
    public final void rule__AliasAttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2404:1: ( ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) rule__AliasAttributeExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2405:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) rule__AliasAttributeExpression__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2405:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2406:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2407:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2407:2: rule__AliasAttributeExpression__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__04851);
            rule__AliasAttributeExpression__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getAliasAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__04860);
            rule__AliasAttributeExpression__Group__1();
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
    // $ANTLR end rule__AliasAttributeExpression__Group__0


    // $ANTLR start rule__AliasAttributeExpression__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2418:1: rule__AliasAttributeExpression__Group__1 : ( ( rule__AliasAttributeExpression__Group_1__0 )? ) ;
    public final void rule__AliasAttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2422:1: ( ( ( rule__AliasAttributeExpression__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2423:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2423:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2424:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2425:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2425:2: rule__AliasAttributeExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__14888);
                    rule__AliasAttributeExpression__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__Group__1


    // $ANTLR start rule__AliasAttributeExpression__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2439:1: rule__AliasAttributeExpression__Group_1__0 : ( '.' ) rule__AliasAttributeExpression__Group_1__1 ;
    public final void rule__AliasAttributeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2443:1: ( ( '.' ) rule__AliasAttributeExpression__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2444:1: ( '.' ) rule__AliasAttributeExpression__Group_1__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2444:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2445:1: '.'
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__04928); 
             after(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0()); 

            }

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__04938);
            rule__AliasAttributeExpression__Group_1__1();
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
    // $ANTLR end rule__AliasAttributeExpression__Group_1__0


    // $ANTLR start rule__AliasAttributeExpression__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2459:1: rule__AliasAttributeExpression__Group_1__1 : ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) ;
    public final void rule__AliasAttributeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2463:1: ( ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2464:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2464:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2465:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2466:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2466:2: rule__AliasAttributeExpression__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__14966);
            rule__AliasAttributeExpression__AttributeAssignment_1_1();
            _fsp--;


            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getAttributeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__Group_1__1


    // $ANTLR start rule__QueryExpression__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2480:1: rule__QueryExpression__Group__0 : ( '(' ) rule__QueryExpression__Group__1 ;
    public final void rule__QueryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2484:1: ( ( '(' ) rule__QueryExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2485:1: ( '(' ) rule__QueryExpression__Group__1
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2485:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2486:1: '('
            {
             before(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__QueryExpression__Group__05005); 
             after(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__05015);
            rule__QueryExpression__Group__1();
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
    // $ANTLR end rule__QueryExpression__Group__0


    // $ANTLR start rule__QueryExpression__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2500:1: rule__QueryExpression__Group__1 : ( ( rule__QueryExpression__ValueAssignment_1 ) ) rule__QueryExpression__Group__2 ;
    public final void rule__QueryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2504:1: ( ( ( rule__QueryExpression__ValueAssignment_1 ) ) rule__QueryExpression__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2505:1: ( ( rule__QueryExpression__ValueAssignment_1 ) ) rule__QueryExpression__Group__2
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2505:1: ( ( rule__QueryExpression__ValueAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2506:1: ( rule__QueryExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getQueryExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2507:1: ( rule__QueryExpression__ValueAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2507:2: rule__QueryExpression__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__15043);
            rule__QueryExpression__ValueAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getQueryExpressionAccess().getValueAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__15052);
            rule__QueryExpression__Group__2();
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
    // $ANTLR end rule__QueryExpression__Group__1


    // $ANTLR start rule__QueryExpression__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2518:1: rule__QueryExpression__Group__2 : ( ')' ) ;
    public final void rule__QueryExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2522:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2523:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2523:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2524:1: ')'
            {
             before(grammarAccess.getQueryExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__QueryExpression__Group__25081); 
             after(grammarAccess.getQueryExpressionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QueryExpression__Group__2


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2543:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2547:1: ( ( ruleImport ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2548:1: ( ruleImport )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2548:1: ( ruleImport )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2549:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_05122);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2558:1: rule__Model__DefaultQueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__DefaultQueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2562:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2563:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2563:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2564:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_15153);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2573:1: rule__Model__NamedQueriesAssignment_2 : ( ruleNamedQuery ) ;
    public final void rule__Model__NamedQueriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2577:1: ( ( ruleNamedQuery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2578:1: ( ruleNamedQuery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2578:1: ( ruleNamedQuery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2579:1: ruleNamedQuery
            {
             before(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_25184);
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


    // $ANTLR start rule__Import__ImpURIAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2588:1: rule__Import__ImpURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImpURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2592:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2593:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2593:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2594:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_15215); 
             after(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImpURIAssignment_1


    // $ANTLR start rule__NamedQuery__NameAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2603:1: rule__NamedQuery__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__NamedQuery__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2607:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2608:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2608:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2609:1: RULE_ID
            {
             before(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_05246); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2618:1: rule__NamedQuery__QueryAssignment_2 : ( ruleMQLquery ) ;
    public final void rule__NamedQuery__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2622:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2623:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2623:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2624:1: ruleMQLquery
            {
             before(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_25277);
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


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2633:1: rule__MQLquery__FromEntriesAssignment_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2637:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2638:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2638:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2639:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_15308);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_1


    // $ANTLR start rule__MQLquery__FromEntriesAssignment_2_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2648:1: rule__MQLquery__FromEntriesAssignment_2_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2652:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2653:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2653:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2654:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_15339);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__FromEntriesAssignment_2_1


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2663:1: rule__MQLquery__SelectEntriesAssignment_4 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2667:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2668:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2668:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2669:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_45370);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_4


    // $ANTLR start rule__MQLquery__SelectEntriesAssignment_5_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2678:1: rule__MQLquery__SelectEntriesAssignment_5_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2682:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2683:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2683:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2684:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_15401);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__SelectEntriesAssignment_5_1


    // $ANTLR start rule__MQLquery__WhereEntryAssignment_6_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2693:1: rule__MQLquery__WhereEntryAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntryAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2697:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2698:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2698:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2699:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_15432);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2708:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2712:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2713:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2713:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2714:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2715:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2716:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_05467); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2727:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2731:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2732:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2732:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2733:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2734:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2735:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_15506); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2746:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2750:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2751:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2751:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2752:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2753:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2754:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_05545); 
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


    // $ANTLR start rule__FromEntry__WithoutsubtypesAssignment_1_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2765:1: rule__FromEntry__WithoutsubtypesAssignment_1_0 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2769:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2770:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2770:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2771:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2772:1: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2773:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            match(input,38,FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_05585); 
             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__WithoutsubtypesAssignment_1_0


    // $ANTLR start rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2788:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2792:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2793:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2793:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2794:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2795:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2796:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_15628); 
             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1


    // $ANTLR start rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2807:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2811:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2812:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2812:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2813:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2814:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2815:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_15667); 
             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_2_1_0_1()); 

            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1


    // $ANTLR start rule__FromEntry__AliasAssignment_3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2826:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2830:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2831:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2831:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2832:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_35702); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2841:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2845:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2846:1: ( ruleScopeClause )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2846:1: ( ruleScopeClause )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2847:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_45733);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2856:1: rule__ResourceScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ResourceScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2860:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2861:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2861:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2862:1: ( 'not' )
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2863:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2864:1: 'not'
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ResourceScope__NotInAssignment_05769); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2879:1: rule__ResourceScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2883:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2884:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2884:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2885:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_45808); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2894:1: rule__ResourceScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2898:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2899:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2899:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2900:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_15839); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2909:1: rule__ElementScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ElementScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2913:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2914:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2914:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2915:1: ( 'not' )
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2916:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2917:1: 'not'
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ElementScope__NotInAssignment_05875); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2932:1: rule__ElementScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2936:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2937:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2937:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2938:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_45914); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2947:1: rule__ElementScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2951:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2952:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2952:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2953:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_15945); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2962:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2966:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2967:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2967:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2968:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_15976);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2977:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2981:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2982:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2982:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2983:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_16007);
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


    // $ANTLR start rule__ExpressionWhereEntry__LhsAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2992:1: rule__ExpressionWhereEntry__LhsAssignment_0 : ( ruleAliasAttributeExpression ) ;
    public final void rule__ExpressionWhereEntry__LhsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2996:1: ( ( ruleAliasAttributeExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2997:1: ( ruleAliasAttributeExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2997:1: ( ruleAliasAttributeExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:2998:1: ruleAliasAttributeExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_06038);
            ruleAliasAttributeExpression();
            _fsp--;

             after(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__LhsAssignment_0


    // $ANTLR start rule__ExpressionWhereEntry__OperatorAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3007:1: rule__ExpressionWhereEntry__OperatorAssignment_1 : ( ruleOperator ) ;
    public final void rule__ExpressionWhereEntry__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3011:1: ( ( ruleOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3012:1: ( ruleOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3012:1: ( ruleOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3013:1: ruleOperator
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_16069);
            ruleOperator();
            _fsp--;

             after(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__OperatorAssignment_1


    // $ANTLR start rule__ExpressionWhereEntry__RhsAssignment_2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3022:1: rule__ExpressionWhereEntry__RhsAssignment_2 : ( ruleExpression ) ;
    public final void rule__ExpressionWhereEntry__RhsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3026:1: ( ( ruleExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3027:1: ( ruleExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3027:1: ( ruleExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3028:1: ruleExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_26100);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__RhsAssignment_2


    // $ANTLR start rule__AliasAttributeExpression__AliasAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3037:1: rule__AliasAttributeExpression__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3041:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3042:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3042:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3043:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3044:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3045:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_06135); 
             after(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__AliasAssignment_0


    // $ANTLR start rule__AliasAttributeExpression__AttributeAssignment_1_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3056:1: rule__AliasAttributeExpression__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3060:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3061:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3061:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3062:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3063:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3064:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_16174); 
             after(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureIDTerminalRuleCall_1_1_0_1()); 

            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__AttributeAssignment_1_1


    // $ANTLR start rule__DoubleExpression__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3075:1: rule__DoubleExpression__ValueAssignment : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3079:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3080:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3080:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3081:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0()); 
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment6209); 
             after(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__DoubleExpression__ValueAssignment


    // $ANTLR start rule__LongExpression__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3090:1: rule__LongExpression__ValueAssignment : ( RULE_SINGED_LONG ) ;
    public final void rule__LongExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3094:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3095:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3095:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3096:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0()); 
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment6240); 
             after(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__LongExpression__ValueAssignment


    // $ANTLR start rule__StringExpression__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3105:1: rule__StringExpression__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3109:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3110:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3110:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3111:1: RULE_STRING
            {
             before(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment6271); 
             after(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringExpression__ValueAssignment


    // $ANTLR start rule__NullExpression__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3120:1: rule__NullExpression__ValueAssignment : ( ( 'null' ) ) ;
    public final void rule__NullExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3124:1: ( ( ( 'null' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3125:1: ( ( 'null' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3125:1: ( ( 'null' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3126:1: ( 'null' )
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3127:1: ( 'null' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3128:1: 'null'
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__NullExpression__ValueAssignment6307); 
             after(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 

            }

             after(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NullExpression__ValueAssignment


    // $ANTLR start rule__BooleanExpression__TrueAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3143:1: rule__BooleanExpression__TrueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanExpression__TrueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3147:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3148:1: ( ( 'true' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3148:1: ( ( 'true' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3149:1: ( 'true' )
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3150:1: ( 'true' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3151:1: 'true'
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            match(input,41,FOLLOW_41_in_rule__BooleanExpression__TrueAssignment_06351); 
             after(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 

            }

             after(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanExpression__TrueAssignment_0


    // $ANTLR start rule__QueryExpression__ValueAssignment_1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3166:1: rule__QueryExpression__ValueAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__QueryExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3170:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3171:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3171:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/contentassist/antlr/internal/InternalQuery.g:3172:1: ruleMQLquery
            {
             before(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_16390);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QueryExpression__ValueAssignment_1


 

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
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionWhereEntry847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__0_in_ruleExpressionWhereEntry874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasAttributeExpression907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__0_in_ruleAliasAttributeExpression934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleExpression1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleExpression__ValueAssignment_in_ruleDoubleExpression1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_entryRuleLongExpression1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongExpression1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongExpression__ValueAssignment_in_ruleLongExpression1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringExpression__ValueAssignment_in_ruleStringExpression1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullExpression__ValueAssignment_in_ruleNullExpression1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Alternatives_in_ruleBooleanExpression1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryExpression1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__0_in_ruleQueryExpression1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Operator__Alternatives_in_ruleOperator1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_rule__Expression__Alternatives1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_rule__Expression__Alternatives1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_rule__Expression__Alternatives1558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_rule__Expression__Alternatives1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_rule__Expression__Alternatives1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_rule__Expression__Alternatives1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_rule__Expression__Alternatives1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__TrueAssignment_0_in_rule__BooleanExpression__Alternatives1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanExpression__Alternatives1677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Operator__Alternatives1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Operator__Alternatives1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Operator__Alternatives1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Operator__Alternatives1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Operator__Alternatives1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Operator__Alternatives1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Operator__Alternatives1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Operator__Alternatives1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Operator__Alternatives1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Operator__Alternatives1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__01938 = new BitSet(new long[]{0x0000000001400022L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__11976 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__22014 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__02056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__12094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__02132 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__NamedQuery__Group__12170 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__22208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group__02249 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__12287 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__22324 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MQLquery__Group__32363 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__42401 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__52438 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__62476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_2__02526 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__12564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_5__02603 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__12641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MQLquery__Group_6__02680 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__02690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__12718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__02756 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__02765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__12793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SelectEntry__Group_1__02833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__02843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__12871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__02909 = new BitSet(new long[]{0x0000004020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__02918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__12946 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__12956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FromEntry__Group__22985 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__22995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__33023 = new BitSet(new long[]{0x0000008000200002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__43060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__03105 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__13142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FromEntry__Group_1_1__03182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__13220 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__13229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__23257 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__23267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FromEntry__Group_1_1__33296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FromEntry__Group_1_1_2__03340 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__03350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__13378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__03416 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__03426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResourceScope__Group__13455 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__13465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ResourceScope__Group__23494 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__23504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__33533 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__33543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__43571 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__43580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__53608 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__53618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResourceScope__Group__63647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResourceScope__Group_5__03697 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__03707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__13735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__03773 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__03783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ElementScope__Group__13812 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__13822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ElementScope__Group__23851 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__23861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__33890 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__33900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__43928 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__43937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__53965 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__53975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__64004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ElementScope__Group_5__04054 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__04064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__14092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__04130 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__04138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__14166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__04215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14245 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__14257 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rule__WhereEntry__Group_1_1__04299 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__04309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__14337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__04375 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__04383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__14411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__04460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14490 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__14502 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__04544 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__04554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__14582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParWhereEntry__Group__04621 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__04631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__14659 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__14667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ParWhereEntry__Group__24696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__04737 = new BitSet(new long[]{0x00000000003FF000L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__04746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__14774 = new BitSet(new long[]{0x00000310000008F0L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__14783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__24811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__04851 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__04860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__14888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__04928 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__04938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__14966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__QueryExpression__Group__05005 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__05015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__15043 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__15052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QueryExpression__Group__25081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_05122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_15153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_25184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_15215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_05246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_25277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_15308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_15339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_45370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_15401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_15432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_05467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_15506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_05545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_05585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_15628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_15667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_35702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_45733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ResourceScope__NotInAssignment_05769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_45808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_15839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ElementScope__NotInAssignment_05875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_45914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_15945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_15976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_16007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_06038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_16069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_26100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_06135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_16174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment6209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__NullExpression__ValueAssignment6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__BooleanExpression__TrueAssignment_06351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_16390 = new BitSet(new long[]{0x0000000000000002L});

}