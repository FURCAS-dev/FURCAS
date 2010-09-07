package org.eclipse.emf.query2.syntax.ui.contentassist.antlr.internal; 

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
import org.eclipse.emf.query2.syntax.services.QueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
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
    public String getGrammarFileName() { return "../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g"; }


     
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:61:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:62:1: ( ruleModel EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:63:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:70:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:74:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:75:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:75:1: ( ( rule__Model__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:76:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:77:1: ( rule__Model__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:77:2: rule__Model__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:89:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:90:1: ( ruleImport EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:91:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport121);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport128); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:98:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:102:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:103:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:103:1: ( ( rule__Import__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:104:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:105:1: ( rule__Import__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:105:2: rule__Import__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:117:1: entryRuleNamedQuery : ruleNamedQuery EOF ;
    public final void entryRuleNamedQuery() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:118:1: ( ruleNamedQuery EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:119:1: ruleNamedQuery EOF
            {
             before(grammarAccess.getNamedQueryRule()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery181);
            ruleNamedQuery();
            _fsp--;

             after(grammarAccess.getNamedQueryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedQuery188); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:126:1: ruleNamedQuery : ( ( rule__NamedQuery__Group__0 ) ) ;
    public final void ruleNamedQuery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:130:2: ( ( ( rule__NamedQuery__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:131:1: ( ( rule__NamedQuery__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:131:1: ( ( rule__NamedQuery__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:132:1: ( rule__NamedQuery__Group__0 )
            {
             before(grammarAccess.getNamedQueryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:133:1: ( rule__NamedQuery__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:133:2: rule__NamedQuery__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:145:1: entryRuleMQLquery : ruleMQLquery EOF ;
    public final void entryRuleMQLquery() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:146:1: ( ruleMQLquery EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:147:1: ruleMQLquery EOF
            {
             before(grammarAccess.getMQLqueryRule()); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery241);
            ruleMQLquery();
            _fsp--;

             after(grammarAccess.getMQLqueryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery248); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:154:1: ruleMQLquery : ( ( rule__MQLquery__Group__0 ) ) ;
    public final void ruleMQLquery() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:158:2: ( ( ( rule__MQLquery__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:159:1: ( ( rule__MQLquery__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:159:1: ( ( rule__MQLquery__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:160:1: ( rule__MQLquery__Group__0 )
            {
             before(grammarAccess.getMQLqueryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:161:1: ( rule__MQLquery__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:161:2: rule__MQLquery__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:173:1: entryRuleSelectEntry : ruleSelectEntry EOF ;
    public final void entryRuleSelectEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:174:1: ( ruleSelectEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:175:1: ruleSelectEntry EOF
            {
             before(grammarAccess.getSelectEntryRule()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry301);
            ruleSelectEntry();
            _fsp--;

             after(grammarAccess.getSelectEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry308); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:182:1: ruleSelectEntry : ( ( rule__SelectEntry__Group__0 ) ) ;
    public final void ruleSelectEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:186:2: ( ( ( rule__SelectEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:187:1: ( ( rule__SelectEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:187:1: ( ( rule__SelectEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:188:1: ( rule__SelectEntry__Group__0 )
            {
             before(grammarAccess.getSelectEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:189:1: ( rule__SelectEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:189:2: rule__SelectEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:201:1: entryRuleFromEntry : ruleFromEntry EOF ;
    public final void entryRuleFromEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:202:1: ( ruleFromEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:203:1: ruleFromEntry EOF
            {
             before(grammarAccess.getFromEntryRule()); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry361);
            ruleFromEntry();
            _fsp--;

             after(grammarAccess.getFromEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry368); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:210:1: ruleFromEntry : ( ( rule__FromEntry__Group__0 ) ) ;
    public final void ruleFromEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:214:2: ( ( ( rule__FromEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:215:1: ( ( rule__FromEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:215:1: ( ( rule__FromEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:216:1: ( rule__FromEntry__Group__0 )
            {
             before(grammarAccess.getFromEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:217:1: ( rule__FromEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:217:2: rule__FromEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:229:1: entryRuleScopeClause : ruleScopeClause EOF ;
    public final void entryRuleScopeClause() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:230:1: ( ruleScopeClause EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:231:1: ruleScopeClause EOF
            {
             before(grammarAccess.getScopeClauseRule()); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause421);
            ruleScopeClause();
            _fsp--;

             after(grammarAccess.getScopeClauseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause428); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:238:1: ruleScopeClause : ( ( rule__ScopeClause__Alternatives ) ) ;
    public final void ruleScopeClause() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:242:2: ( ( ( rule__ScopeClause__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:243:1: ( ( rule__ScopeClause__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:243:1: ( ( rule__ScopeClause__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:244:1: ( rule__ScopeClause__Alternatives )
            {
             before(grammarAccess.getScopeClauseAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:245:1: ( rule__ScopeClause__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:245:2: rule__ScopeClause__Alternatives
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:257:1: entryRuleResourceScope : ruleResourceScope EOF ;
    public final void entryRuleResourceScope() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:258:1: ( ruleResourceScope EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:259:1: ruleResourceScope EOF
            {
             before(grammarAccess.getResourceScopeRule()); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope481);
            ruleResourceScope();
            _fsp--;

             after(grammarAccess.getResourceScopeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope488); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:266:1: ruleResourceScope : ( ( rule__ResourceScope__Group__0 ) ) ;
    public final void ruleResourceScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:270:2: ( ( ( rule__ResourceScope__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:271:1: ( ( rule__ResourceScope__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:271:1: ( ( rule__ResourceScope__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:272:1: ( rule__ResourceScope__Group__0 )
            {
             before(grammarAccess.getResourceScopeAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:273:1: ( rule__ResourceScope__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:273:2: rule__ResourceScope__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:285:1: entryRuleElementScope : ruleElementScope EOF ;
    public final void entryRuleElementScope() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:286:1: ( ruleElementScope EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:287:1: ruleElementScope EOF
            {
             before(grammarAccess.getElementScopeRule()); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope541);
            ruleElementScope();
            _fsp--;

             after(grammarAccess.getElementScopeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope548); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:294:1: ruleElementScope : ( ( rule__ElementScope__Group__0 ) ) ;
    public final void ruleElementScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:298:2: ( ( ( rule__ElementScope__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:299:1: ( ( rule__ElementScope__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:299:1: ( ( rule__ElementScope__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:300:1: ( rule__ElementScope__Group__0 )
            {
             before(grammarAccess.getElementScopeAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:301:1: ( rule__ElementScope__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:301:2: rule__ElementScope__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:313:1: entryRuleWhereEntry : ruleWhereEntry EOF ;
    public final void entryRuleWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:314:1: ( ruleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:315:1: ruleWhereEntry EOF
            {
             before(grammarAccess.getWhereEntryRule()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry601);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry608); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:322:1: ruleWhereEntry : ( ( rule__WhereEntry__Group__0 ) ) ;
    public final void ruleWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:326:2: ( ( ( rule__WhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:327:1: ( ( rule__WhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:327:1: ( ( rule__WhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:328:1: ( rule__WhereEntry__Group__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:329:1: ( rule__WhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:329:2: rule__WhereEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:341:1: entryRuleAndWhereEntry : ruleAndWhereEntry EOF ;
    public final void entryRuleAndWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:342:1: ( ruleAndWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:343:1: ruleAndWhereEntry EOF
            {
             before(grammarAccess.getAndWhereEntryRule()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry661);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry668); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:350:1: ruleAndWhereEntry : ( ( rule__AndWhereEntry__Group__0 ) ) ;
    public final void ruleAndWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:354:2: ( ( ( rule__AndWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:355:1: ( ( rule__AndWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:355:1: ( ( rule__AndWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:356:1: ( rule__AndWhereEntry__Group__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:357:1: ( rule__AndWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:357:2: rule__AndWhereEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:369:1: entryRuleConcreteWhereEntry : ruleConcreteWhereEntry EOF ;
    public final void entryRuleConcreteWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:370:1: ( ruleConcreteWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:371:1: ruleConcreteWhereEntry EOF
            {
             before(grammarAccess.getConcreteWhereEntryRule()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry721);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getConcreteWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry728); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:378:1: ruleConcreteWhereEntry : ( ( rule__ConcreteWhereEntry__Alternatives ) ) ;
    public final void ruleConcreteWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:382:2: ( ( ( rule__ConcreteWhereEntry__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:383:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:383:1: ( ( rule__ConcreteWhereEntry__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:384:1: ( rule__ConcreteWhereEntry__Alternatives )
            {
             before(grammarAccess.getConcreteWhereEntryAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:385:1: ( rule__ConcreteWhereEntry__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:385:2: rule__ConcreteWhereEntry__Alternatives
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:397:1: entryRuleParWhereEntry : ruleParWhereEntry EOF ;
    public final void entryRuleParWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:398:1: ( ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:399:1: ruleParWhereEntry EOF
            {
             before(grammarAccess.getParWhereEntryRule()); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry781);
            ruleParWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry788); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:406:1: ruleParWhereEntry : ( ( rule__ParWhereEntry__Group__0 ) ) ;
    public final void ruleParWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:410:2: ( ( ( rule__ParWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:411:1: ( ( rule__ParWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:411:1: ( ( rule__ParWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:412:1: ( rule__ParWhereEntry__Group__0 )
            {
             before(grammarAccess.getParWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:413:1: ( rule__ParWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:413:2: rule__ParWhereEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:425:1: entryRuleExpressionWhereEntry : ruleExpressionWhereEntry EOF ;
    public final void entryRuleExpressionWhereEntry() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:426:1: ( ruleExpressionWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:427:1: ruleExpressionWhereEntry EOF
            {
             before(grammarAccess.getExpressionWhereEntryRule()); 
            pushFollow(FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry841);
            ruleExpressionWhereEntry();
            _fsp--;

             after(grammarAccess.getExpressionWhereEntryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionWhereEntry848); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:434:1: ruleExpressionWhereEntry : ( ( rule__ExpressionWhereEntry__Group__0 ) ) ;
    public final void ruleExpressionWhereEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:438:2: ( ( ( rule__ExpressionWhereEntry__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:439:1: ( ( rule__ExpressionWhereEntry__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:439:1: ( ( rule__ExpressionWhereEntry__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:440:1: ( rule__ExpressionWhereEntry__Group__0 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:441:1: ( rule__ExpressionWhereEntry__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:441:2: rule__ExpressionWhereEntry__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:453:1: entryRuleAliasAttributeExpression : ruleAliasAttributeExpression EOF ;
    public final void entryRuleAliasAttributeExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:454:1: ( ruleAliasAttributeExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:455:1: ruleAliasAttributeExpression EOF
            {
             before(grammarAccess.getAliasAttributeExpressionRule()); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression901);
            ruleAliasAttributeExpression();
            _fsp--;

             after(grammarAccess.getAliasAttributeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasAttributeExpression908); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:462:1: ruleAliasAttributeExpression : ( ( rule__AliasAttributeExpression__Group__0 ) ) ;
    public final void ruleAliasAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:466:2: ( ( ( rule__AliasAttributeExpression__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:467:1: ( ( rule__AliasAttributeExpression__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:467:1: ( ( rule__AliasAttributeExpression__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:468:1: ( rule__AliasAttributeExpression__Group__0 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:469:1: ( rule__AliasAttributeExpression__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:469:2: rule__AliasAttributeExpression__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:481:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:482:1: ( ruleExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:483:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression961);
            ruleExpression();
            _fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression968); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:490:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:494:2: ( ( ( rule__Expression__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:495:1: ( ( rule__Expression__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:495:1: ( ( rule__Expression__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:496:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:497:1: ( rule__Expression__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:497:2: rule__Expression__Alternatives
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:509:1: entryRuleDoubleExpression : ruleDoubleExpression EOF ;
    public final void entryRuleDoubleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:510:1: ( ruleDoubleExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:511:1: ruleDoubleExpression EOF
            {
             before(grammarAccess.getDoubleExpressionRule()); 
            pushFollow(FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1021);
            ruleDoubleExpression();
            _fsp--;

             after(grammarAccess.getDoubleExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleExpression1028); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:518:1: ruleDoubleExpression : ( ( rule__DoubleExpression__ValueAssignment ) ) ;
    public final void ruleDoubleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:522:2: ( ( ( rule__DoubleExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:523:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:523:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:524:1: ( rule__DoubleExpression__ValueAssignment )
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:525:1: ( rule__DoubleExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:525:2: rule__DoubleExpression__ValueAssignment
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:537:1: entryRuleLongExpression : ruleLongExpression EOF ;
    public final void entryRuleLongExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:538:1: ( ruleLongExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:539:1: ruleLongExpression EOF
            {
             before(grammarAccess.getLongExpressionRule()); 
            pushFollow(FOLLOW_ruleLongExpression_in_entryRuleLongExpression1081);
            ruleLongExpression();
            _fsp--;

             after(grammarAccess.getLongExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongExpression1088); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:546:1: ruleLongExpression : ( ( rule__LongExpression__ValueAssignment ) ) ;
    public final void ruleLongExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:550:2: ( ( ( rule__LongExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:551:1: ( ( rule__LongExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:551:1: ( ( rule__LongExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:552:1: ( rule__LongExpression__ValueAssignment )
            {
             before(grammarAccess.getLongExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:553:1: ( rule__LongExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:553:2: rule__LongExpression__ValueAssignment
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:565:1: entryRuleStringExpression : ruleStringExpression EOF ;
    public final void entryRuleStringExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:566:1: ( ruleStringExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:567:1: ruleStringExpression EOF
            {
             before(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression1141);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getStringExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression1148); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:574:1: ruleStringExpression : ( ( rule__StringExpression__ValueAssignment ) ) ;
    public final void ruleStringExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:578:2: ( ( ( rule__StringExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:579:1: ( ( rule__StringExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:579:1: ( ( rule__StringExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:580:1: ( rule__StringExpression__ValueAssignment )
            {
             before(grammarAccess.getStringExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:581:1: ( rule__StringExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:581:2: rule__StringExpression__ValueAssignment
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:593:1: entryRuleNullExpression : ruleNullExpression EOF ;
    public final void entryRuleNullExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:594:1: ( ruleNullExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:595:1: ruleNullExpression EOF
            {
             before(grammarAccess.getNullExpressionRule()); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression1201);
            ruleNullExpression();
            _fsp--;

             after(grammarAccess.getNullExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression1208); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:602:1: ruleNullExpression : ( ( rule__NullExpression__ValueAssignment ) ) ;
    public final void ruleNullExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:606:2: ( ( ( rule__NullExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:607:1: ( ( rule__NullExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:607:1: ( ( rule__NullExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:608:1: ( rule__NullExpression__ValueAssignment )
            {
             before(grammarAccess.getNullExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:609:1: ( rule__NullExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:609:2: rule__NullExpression__ValueAssignment
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:621:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:622:1: ( ruleBooleanExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:623:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1261);
            ruleBooleanExpression();
            _fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression1268); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:630:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:634:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:635:1: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:635:1: ( ( rule__BooleanExpression__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:636:1: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:637:1: ( rule__BooleanExpression__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:637:2: rule__BooleanExpression__Alternatives
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:649:1: entryRuleQueryExpression : ruleQueryExpression EOF ;
    public final void entryRuleQueryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:650:1: ( ruleQueryExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:651:1: ruleQueryExpression EOF
            {
             before(grammarAccess.getQueryExpressionRule()); 
            pushFollow(FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1321);
            ruleQueryExpression();
            _fsp--;

             after(grammarAccess.getQueryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryExpression1328); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:658:1: ruleQueryExpression : ( ( rule__QueryExpression__Group__0 ) ) ;
    public final void ruleQueryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:662:2: ( ( ( rule__QueryExpression__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:663:1: ( ( rule__QueryExpression__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:663:1: ( ( rule__QueryExpression__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:664:1: ( rule__QueryExpression__Group__0 )
            {
             before(grammarAccess.getQueryExpressionAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:665:1: ( rule__QueryExpression__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:665:2: rule__QueryExpression__Group__0
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:678:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:682:1: ( ( ( rule__Operator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:683:1: ( ( rule__Operator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:683:1: ( ( rule__Operator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:684:1: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:685:1: ( rule__Operator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:685:2: rule__Operator__Alternatives
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:696:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__ScopeClause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:700:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==39) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==21) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==32) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==33) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("696:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("696:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==21) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==32) ) {
                    alt1=1;
                }
                else if ( (LA1_2==33) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("696:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("696:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:701:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:701:1: ( ruleResourceScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:702:1: ruleResourceScope
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:707:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:707:6: ( ruleElementScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:708:1: ruleElementScope
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:718:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:722:1: ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) )
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
                    new NoViableAltException("718:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:723:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:723:1: ( ruleParWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:724:1: ruleParWhereEntry
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:729:6: ( ruleExpressionWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:729:6: ( ruleExpressionWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:730:1: ruleExpressionWhereEntry
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:740:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:744:1: ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) )
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
                    new NoViableAltException("740:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:745:1: ( ruleAliasAttributeExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:745:1: ( ruleAliasAttributeExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:746:1: ruleAliasAttributeExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:751:6: ( ruleDoubleExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:751:6: ( ruleDoubleExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:752:1: ruleDoubleExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:757:6: ( ruleLongExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:757:6: ( ruleLongExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:758:1: ruleLongExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:763:6: ( ruleStringExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:763:6: ( ruleStringExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:764:1: ruleStringExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:769:6: ( ruleNullExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:769:6: ( ruleNullExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:770:1: ruleNullExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:775:6: ( ruleBooleanExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:775:6: ( ruleBooleanExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:776:1: ruleBooleanExpression
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:781:6: ( ruleQueryExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:781:6: ( ruleQueryExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:782:1: ruleQueryExpression
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:792:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:796:1: ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) )
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
                    new NoViableAltException("792:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:797:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:797:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:798:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getTrueAssignment_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:799:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:799:2: rule__BooleanExpression__TrueAssignment_0
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
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:803:6: ( 'false' )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:803:6: ( 'false' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:804:1: 'false'
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:816:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:820:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) )
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
                    new NoViableAltException("816:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:821:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:821:1: ( ( '<' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:822:1: ( '<' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:823:1: ( '<' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:823:3: '<'
                    {
                    match(input,12,FOLLOW_12_in_rule__Operator__Alternatives1712); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:828:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:828:6: ( ( '>' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:829:1: ( '>' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:830:1: ( '>' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:830:3: '>'
                    {
                    match(input,13,FOLLOW_13_in_rule__Operator__Alternatives1733); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:835:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:835:6: ( ( '<=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:836:1: ( '<=' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:837:1: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:837:3: '<='
                    {
                    match(input,14,FOLLOW_14_in_rule__Operator__Alternatives1754); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:842:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:842:6: ( ( '>=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:843:1: ( '>=' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:844:1: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:844:3: '>='
                    {
                    match(input,15,FOLLOW_15_in_rule__Operator__Alternatives1775); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:849:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:849:6: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:850:1: ( '=' )
                    {
                     before(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:851:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:851:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__Operator__Alternatives1796); 

                    }

                     after(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:856:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:856:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:857:1: ( '!=' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:858:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:858:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__Operator__Alternatives1817); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:863:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:863:6: ( ( 'like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:864:1: ( 'like' )
                    {
                     before(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:865:1: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:865:3: 'like'
                    {
                    match(input,18,FOLLOW_18_in_rule__Operator__Alternatives1838); 

                    }

                     after(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:870:6: ( ( 'not like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:870:6: ( ( 'not like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:871:1: ( 'not like' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:872:1: ( 'not like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:872:3: 'not like'
                    {
                    match(input,19,FOLLOW_19_in_rule__Operator__Alternatives1859); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:877:6: ( ( 'not in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:877:6: ( ( 'not in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:878:1: ( 'not in' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:879:1: ( 'not in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:879:3: 'not in'
                    {
                    match(input,20,FOLLOW_20_in_rule__Operator__Alternatives1880); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:884:6: ( ( 'in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:884:6: ( ( 'in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:885:1: ( 'in' )
                    {
                     before(grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:886:1: ( 'in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:886:3: 'in'
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:898:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:902:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:903:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01934);
            rule__Model__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01937);
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


    // $ANTLR start rule__Model__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:910:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:914:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:915:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:915:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:916:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:917:1: ( rule__Model__ImportsAssignment_0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:917:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl1964);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0__Impl


    // $ANTLR start rule__Model__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:927:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:931:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:932:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11995);
            rule__Model__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11998);
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


    // $ANTLR start rule__Model__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:939:1: rule__Model__Group__1__Impl : ( ( rule__Model__DefaultQueryAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:943:1: ( ( ( rule__Model__DefaultQueryAssignment_1 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:944:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:944:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:945:1: ( rule__Model__DefaultQueryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:946:1: ( rule__Model__DefaultQueryAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:946:2: rule__Model__DefaultQueryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__1__Impl2025);
                    rule__Model__DefaultQueryAssignment_1();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1__Impl


    // $ANTLR start rule__Model__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:956:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:960:1: ( rule__Model__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:961:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22056);
            rule__Model__Group__2__Impl();
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
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Model__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:967:1: rule__Model__Group__2__Impl : ( ( rule__Model__NamedQueriesAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:971:1: ( ( ( rule__Model__NamedQueriesAssignment_2 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:972:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:972:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:973:1: ( rule__Model__NamedQueriesAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:974:1: ( rule__Model__NamedQueriesAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:974:2: rule__Model__NamedQueriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__2__Impl2083);
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
    // $ANTLR end rule__Model__Group__2__Impl


    // $ANTLR start rule__Import__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:990:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:994:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:995:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02120);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02123);
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


    // $ANTLR start rule__Import__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1002:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1006:1: ( ( 'import' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1007:1: ( 'import' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1007:1: ( 'import' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1008:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__0__Impl2151); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0__Impl


    // $ANTLR start rule__Import__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1021:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1025:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1026:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12182);
            rule__Import__Group__1__Impl();
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
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__Import__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1032:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImpURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1036:1: ( ( ( rule__Import__ImpURIAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1037:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1037:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1038:1: ( rule__Import__ImpURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImpURIAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1039:1: ( rule__Import__ImpURIAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1039:2: rule__Import__ImpURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__1__Impl2209);
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
    // $ANTLR end rule__Import__Group__1__Impl


    // $ANTLR start rule__NamedQuery__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1053:1: rule__NamedQuery__Group__0 : rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1 ;
    public final void rule__NamedQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1057:1: ( rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1058:2: rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__0__Impl_in_rule__NamedQuery__Group__02243);
            rule__NamedQuery__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02246);
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


    // $ANTLR start rule__NamedQuery__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1065:1: rule__NamedQuery__Group__0__Impl : ( ( rule__NamedQuery__NameAssignment_0 ) ) ;
    public final void rule__NamedQuery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1069:1: ( ( ( rule__NamedQuery__NameAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1070:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1070:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1071:1: ( rule__NamedQuery__NameAssignment_0 )
            {
             before(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1072:1: ( rule__NamedQuery__NameAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1072:2: rule__NamedQuery__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__0__Impl2273);
            rule__NamedQuery__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__Group__0__Impl


    // $ANTLR start rule__NamedQuery__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1082:1: rule__NamedQuery__Group__1 : rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2 ;
    public final void rule__NamedQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1086:1: ( rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1087:2: rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__1__Impl_in_rule__NamedQuery__Group__12303);
            rule__NamedQuery__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12306);
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


    // $ANTLR start rule__NamedQuery__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1094:1: rule__NamedQuery__Group__1__Impl : ( ':' ) ;
    public final void rule__NamedQuery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1098:1: ( ( ':' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1099:1: ( ':' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1099:1: ( ':' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1100:1: ':'
            {
             before(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__NamedQuery__Group__1__Impl2334); 
             after(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NamedQuery__Group__1__Impl


    // $ANTLR start rule__NamedQuery__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1113:1: rule__NamedQuery__Group__2 : rule__NamedQuery__Group__2__Impl ;
    public final void rule__NamedQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1117:1: ( rule__NamedQuery__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1118:2: rule__NamedQuery__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__2__Impl_in_rule__NamedQuery__Group__22365);
            rule__NamedQuery__Group__2__Impl();
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
    // $ANTLR end rule__NamedQuery__Group__2


    // $ANTLR start rule__NamedQuery__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1124:1: rule__NamedQuery__Group__2__Impl : ( ( rule__NamedQuery__QueryAssignment_2 ) ) ;
    public final void rule__NamedQuery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1128:1: ( ( ( rule__NamedQuery__QueryAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1129:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1129:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1130:1: ( rule__NamedQuery__QueryAssignment_2 )
            {
             before(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1131:1: ( rule__NamedQuery__QueryAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1131:2: rule__NamedQuery__QueryAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__2__Impl2392);
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
    // $ANTLR end rule__NamedQuery__Group__2__Impl


    // $ANTLR start rule__MQLquery__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1147:1: rule__MQLquery__Group__0 : rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1151:1: ( rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1152:2: rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02428);
            rule__MQLquery__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02431);
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


    // $ANTLR start rule__MQLquery__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1159:1: rule__MQLquery__Group__0__Impl : ( 'from' ) ;
    public final void rule__MQLquery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1163:1: ( ( 'from' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1164:1: ( 'from' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1164:1: ( 'from' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1165:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group__0__Impl2459); 
             after(grammarAccess.getMQLqueryAccess().getFromKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__0__Impl


    // $ANTLR start rule__MQLquery__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1178:1: rule__MQLquery__Group__1 : rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1182:1: ( rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1183:2: rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12490);
            rule__MQLquery__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12493);
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


    // $ANTLR start rule__MQLquery__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1190:1: rule__MQLquery__Group__1__Impl : ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) ;
    public final void rule__MQLquery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1194:1: ( ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1195:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1195:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1196:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1197:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1197:2: rule__MQLquery__FromEntriesAssignment_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2520);
            rule__MQLquery__FromEntriesAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__1__Impl


    // $ANTLR start rule__MQLquery__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1207:1: rule__MQLquery__Group__2 : rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1211:1: ( rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1212:2: rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22550);
            rule__MQLquery__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22553);
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


    // $ANTLR start rule__MQLquery__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1219:1: rule__MQLquery__Group__2__Impl : ( ( rule__MQLquery__Group_2__0 )* ) ;
    public final void rule__MQLquery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1223:1: ( ( ( rule__MQLquery__Group_2__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1224:1: ( ( rule__MQLquery__Group_2__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1224:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1225:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1226:1: ( rule__MQLquery__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1226:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2580);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__2__Impl


    // $ANTLR start rule__MQLquery__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1236:1: rule__MQLquery__Group__3 : rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1240:1: ( rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1241:2: rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32611);
            rule__MQLquery__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32614);
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


    // $ANTLR start rule__MQLquery__Group__3__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1248:1: rule__MQLquery__Group__3__Impl : ( 'select' ) ;
    public final void rule__MQLquery__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1252:1: ( ( 'select' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1253:1: ( 'select' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1253:1: ( 'select' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1254:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__MQLquery__Group__3__Impl2642); 
             after(grammarAccess.getMQLqueryAccess().getSelectKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__3__Impl


    // $ANTLR start rule__MQLquery__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1267:1: rule__MQLquery__Group__4 : rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1271:1: ( rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1272:2: rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42673);
            rule__MQLquery__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42676);
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


    // $ANTLR start rule__MQLquery__Group__4__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1279:1: rule__MQLquery__Group__4__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) ;
    public final void rule__MQLquery__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1283:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1284:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1284:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1285:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1286:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1286:2: rule__MQLquery__SelectEntriesAssignment_4
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2703);
            rule__MQLquery__SelectEntriesAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__4__Impl


    // $ANTLR start rule__MQLquery__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1296:1: rule__MQLquery__Group__5 : rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1300:1: ( rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1301:2: rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52733);
            rule__MQLquery__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52736);
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


    // $ANTLR start rule__MQLquery__Group__5__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1308:1: rule__MQLquery__Group__5__Impl : ( ( rule__MQLquery__Group_5__0 )* ) ;
    public final void rule__MQLquery__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1312:1: ( ( ( rule__MQLquery__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1313:1: ( ( rule__MQLquery__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1313:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1314:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1315:1: ( rule__MQLquery__Group_5__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1315:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2763);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group__5__Impl


    // $ANTLR start rule__MQLquery__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1325:1: rule__MQLquery__Group__6 : rule__MQLquery__Group__6__Impl ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1329:1: ( rule__MQLquery__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1330:2: rule__MQLquery__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62794);
            rule__MQLquery__Group__6__Impl();
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
    // $ANTLR end rule__MQLquery__Group__6


    // $ANTLR start rule__MQLquery__Group__6__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1336:1: rule__MQLquery__Group__6__Impl : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1340:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1341:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1341:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1342:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1343:1: ( rule__MQLquery__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1343:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2821);
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
    // $ANTLR end rule__MQLquery__Group__6__Impl


    // $ANTLR start rule__MQLquery__Group_2__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1367:1: rule__MQLquery__Group_2__0 : rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1371:1: ( rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1372:2: rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02866);
            rule__MQLquery__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02869);
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


    // $ANTLR start rule__MQLquery__Group_2__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1379:1: rule__MQLquery__Group_2__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1383:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1384:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1384:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1385:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_2__0__Impl2897); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_2__0__Impl


    // $ANTLR start rule__MQLquery__Group_2__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1398:1: rule__MQLquery__Group_2__1 : rule__MQLquery__Group_2__1__Impl ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1402:1: ( rule__MQLquery__Group_2__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1403:2: rule__MQLquery__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__12928);
            rule__MQLquery__Group_2__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_2__1


    // $ANTLR start rule__MQLquery__Group_2__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1409:1: rule__MQLquery__Group_2__1__Impl : ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1413:1: ( ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1414:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1414:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1415:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1416:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1416:2: rule__MQLquery__FromEntriesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl2955);
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
    // $ANTLR end rule__MQLquery__Group_2__1__Impl


    // $ANTLR start rule__MQLquery__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1430:1: rule__MQLquery__Group_5__0 : rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1434:1: ( rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1435:2: rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__02989);
            rule__MQLquery__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02992);
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


    // $ANTLR start rule__MQLquery__Group_5__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1442:1: rule__MQLquery__Group_5__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1446:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1447:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1447:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1448:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_5__0__Impl3020); 
             after(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_5__0__Impl


    // $ANTLR start rule__MQLquery__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1461:1: rule__MQLquery__Group_5__1 : rule__MQLquery__Group_5__1__Impl ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1465:1: ( rule__MQLquery__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1466:2: rule__MQLquery__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13051);
            rule__MQLquery__Group_5__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_5__1


    // $ANTLR start rule__MQLquery__Group_5__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1472:1: rule__MQLquery__Group_5__1__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1476:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1477:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1477:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1478:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1479:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1479:2: rule__MQLquery__SelectEntriesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3078);
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
    // $ANTLR end rule__MQLquery__Group_5__1__Impl


    // $ANTLR start rule__MQLquery__Group_6__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1493:1: rule__MQLquery__Group_6__0 : rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1497:1: ( rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1498:2: rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03112);
            rule__MQLquery__Group_6__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03115);
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


    // $ANTLR start rule__MQLquery__Group_6__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1505:1: rule__MQLquery__Group_6__0__Impl : ( 'where' ) ;
    public final void rule__MQLquery__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1509:1: ( ( 'where' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1510:1: ( 'where' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1510:1: ( 'where' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1511:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,27,FOLLOW_27_in_rule__MQLquery__Group_6__0__Impl3143); 
             after(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__MQLquery__Group_6__0__Impl


    // $ANTLR start rule__MQLquery__Group_6__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1524:1: rule__MQLquery__Group_6__1 : rule__MQLquery__Group_6__1__Impl ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1528:1: ( rule__MQLquery__Group_6__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1529:2: rule__MQLquery__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13174);
            rule__MQLquery__Group_6__1__Impl();
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
    // $ANTLR end rule__MQLquery__Group_6__1


    // $ANTLR start rule__MQLquery__Group_6__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1535:1: rule__MQLquery__Group_6__1__Impl : ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) ;
    public final void rule__MQLquery__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1539:1: ( ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1540:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1540:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1541:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1542:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1542:2: rule__MQLquery__WhereEntryAssignment_6_1
            {
            pushFollow(FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3201);
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
    // $ANTLR end rule__MQLquery__Group_6__1__Impl


    // $ANTLR start rule__SelectEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1556:1: rule__SelectEntry__Group__0 : rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1560:1: ( rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1561:2: rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03235);
            rule__SelectEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03238);
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


    // $ANTLR start rule__SelectEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1568:1: rule__SelectEntry__Group__0__Impl : ( ( rule__SelectEntry__SelectAssignment_0 ) ) ;
    public final void rule__SelectEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1572:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1573:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1573:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1574:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1575:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1575:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3265);
            rule__SelectEntry__SelectAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group__0__Impl


    // $ANTLR start rule__SelectEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1585:1: rule__SelectEntry__Group__1 : rule__SelectEntry__Group__1__Impl ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1589:1: ( rule__SelectEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1590:2: rule__SelectEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13295);
            rule__SelectEntry__Group__1__Impl();
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
    // $ANTLR end rule__SelectEntry__Group__1


    // $ANTLR start rule__SelectEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1596:1: rule__SelectEntry__Group__1__Impl : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1600:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1601:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1601:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1602:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1603:1: ( rule__SelectEntry__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1603:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3322);
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
    // $ANTLR end rule__SelectEntry__Group__1__Impl


    // $ANTLR start rule__SelectEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1617:1: rule__SelectEntry__Group_1__0 : rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1621:1: ( rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1622:2: rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03357);
            rule__SelectEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03360);
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


    // $ANTLR start rule__SelectEntry__Group_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1629:1: rule__SelectEntry__Group_1__0__Impl : ( '.' ) ;
    public final void rule__SelectEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1633:1: ( ( '.' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1634:1: ( '.' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1634:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1635:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__SelectEntry__Group_1__0__Impl3388); 
             after(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SelectEntry__Group_1__0__Impl


    // $ANTLR start rule__SelectEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1648:1: rule__SelectEntry__Group_1__1 : rule__SelectEntry__Group_1__1__Impl ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1652:1: ( rule__SelectEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1653:2: rule__SelectEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13419);
            rule__SelectEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__SelectEntry__Group_1__1


    // $ANTLR start rule__SelectEntry__Group_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1659:1: rule__SelectEntry__Group_1__1__Impl : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1663:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1664:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1664:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1665:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1666:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1666:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3446);
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
    // $ANTLR end rule__SelectEntry__Group_1__1__Impl


    // $ANTLR start rule__FromEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1680:1: rule__FromEntry__Group__0 : rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1684:1: ( rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1685:2: rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03480);
            rule__FromEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03483);
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


    // $ANTLR start rule__FromEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1692:1: rule__FromEntry__Group__0__Impl : ( ( rule__FromEntry__TypeAssignment_0 ) ) ;
    public final void rule__FromEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1696:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1697:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1697:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1698:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1699:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1699:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3510);
            rule__FromEntry__TypeAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__0__Impl


    // $ANTLR start rule__FromEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1709:1: rule__FromEntry__Group__1 : rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1713:1: ( rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1714:2: rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13540);
            rule__FromEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13543);
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


    // $ANTLR start rule__FromEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1721:1: rule__FromEntry__Group__1__Impl : ( ( rule__FromEntry__Group_1__0 )? ) ;
    public final void rule__FromEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1725:1: ( ( ( rule__FromEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1726:1: ( ( rule__FromEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1726:1: ( ( rule__FromEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1727:1: ( rule__FromEntry__Group_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1728:1: ( rule__FromEntry__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1728:2: rule__FromEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__1__Impl3570);
                    rule__FromEntry__Group_1__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFromEntryAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__1__Impl


    // $ANTLR start rule__FromEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1738:1: rule__FromEntry__Group__2 : rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1742:1: ( rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1743:2: rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23601);
            rule__FromEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23604);
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


    // $ANTLR start rule__FromEntry__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1750:1: rule__FromEntry__Group__2__Impl : ( 'as' ) ;
    public final void rule__FromEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1754:1: ( ( 'as' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1755:1: ( 'as' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1755:1: ( 'as' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1756:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__FromEntry__Group__2__Impl3632); 
             after(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__2__Impl


    // $ANTLR start rule__FromEntry__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1769:1: rule__FromEntry__Group__3 : rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1773:1: ( rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1774:2: rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33663);
            rule__FromEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33666);
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


    // $ANTLR start rule__FromEntry__Group__3__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1781:1: rule__FromEntry__Group__3__Impl : ( ( rule__FromEntry__AliasAssignment_3 ) ) ;
    public final void rule__FromEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1785:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1786:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1786:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1787:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1788:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1788:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3693);
            rule__FromEntry__AliasAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group__3__Impl


    // $ANTLR start rule__FromEntry__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1798:1: rule__FromEntry__Group__4 : rule__FromEntry__Group__4__Impl ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1802:1: ( rule__FromEntry__Group__4__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1803:2: rule__FromEntry__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43723);
            rule__FromEntry__Group__4__Impl();
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
    // $ANTLR end rule__FromEntry__Group__4


    // $ANTLR start rule__FromEntry__Group__4__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1809:1: rule__FromEntry__Group__4__Impl : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1813:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1814:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1814:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1815:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1816:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21||LA14_0==39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1816:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3750);
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
    // $ANTLR end rule__FromEntry__Group__4__Impl


    // $ANTLR start rule__FromEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1836:1: rule__FromEntry__Group_1__0 : rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1 ;
    public final void rule__FromEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1840:1: ( rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1841:2: rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1__0__Impl_in_rule__FromEntry__Group_1__03791);
            rule__FromEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03794);
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


    // $ANTLR start rule__FromEntry__Group_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1848:1: rule__FromEntry__Group_1__0__Impl : ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) ;
    public final void rule__FromEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1852:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1853:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1853:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1854:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1855:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1855:2: rule__FromEntry__WithoutsubtypesAssignment_1_0
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__0__Impl3821);
            rule__FromEntry__WithoutsubtypesAssignment_1_0();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1__0__Impl


    // $ANTLR start rule__FromEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1865:1: rule__FromEntry__Group_1__1 : rule__FromEntry__Group_1__1__Impl ;
    public final void rule__FromEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1869:1: ( rule__FromEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1870:2: rule__FromEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1__1__Impl_in_rule__FromEntry__Group_1__13851);
            rule__FromEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__FromEntry__Group_1__1


    // $ANTLR start rule__FromEntry__Group_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1876:1: rule__FromEntry__Group_1__1__Impl : ( ( rule__FromEntry__Group_1_1__0 )? ) ;
    public final void rule__FromEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1880:1: ( ( ( rule__FromEntry__Group_1_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1881:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1881:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1882:1: ( rule__FromEntry__Group_1_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1883:1: ( rule__FromEntry__Group_1_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1883:2: rule__FromEntry__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__1__Impl3878);
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
    // $ANTLR end rule__FromEntry__Group_1__1__Impl


    // $ANTLR start rule__FromEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1897:1: rule__FromEntry__Group_1_1__0 : rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1 ;
    public final void rule__FromEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1901:1: ( rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1902:2: rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__0__Impl_in_rule__FromEntry__Group_1_1__03913);
            rule__FromEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03916);
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


    // $ANTLR start rule__FromEntry__Group_1_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1909:1: rule__FromEntry__Group_1_1__0__Impl : ( '{' ) ;
    public final void rule__FromEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1913:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1914:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1914:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1915:1: '{'
            {
             before(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__FromEntry__Group_1_1__0__Impl3944); 
             after(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1__0__Impl


    // $ANTLR start rule__FromEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1928:1: rule__FromEntry__Group_1_1__1 : rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2 ;
    public final void rule__FromEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1932:1: ( rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1933:2: rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__1__Impl_in_rule__FromEntry__Group_1_1__13975);
            rule__FromEntry__Group_1_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__13978);
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


    // $ANTLR start rule__FromEntry__Group_1_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1940:1: rule__FromEntry__Group_1_1__1__Impl : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) ;
    public final void rule__FromEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1944:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1945:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1945:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1946:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1947:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1947:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__1__Impl4005);
            rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1__1__Impl


    // $ANTLR start rule__FromEntry__Group_1_1__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1957:1: rule__FromEntry__Group_1_1__2 : rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3 ;
    public final void rule__FromEntry__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1961:1: ( rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1962:2: rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__2__Impl_in_rule__FromEntry__Group_1_1__24035);
            rule__FromEntry__Group_1_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__24038);
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


    // $ANTLR start rule__FromEntry__Group_1_1__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1969:1: rule__FromEntry__Group_1_1__2__Impl : ( ( rule__FromEntry__Group_1_1_2__0 )* ) ;
    public final void rule__FromEntry__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1973:1: ( ( ( rule__FromEntry__Group_1_1_2__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1974:1: ( ( rule__FromEntry__Group_1_1_2__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1974:1: ( ( rule__FromEntry__Group_1_1_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1975:1: ( rule__FromEntry__Group_1_1_2__0 )*
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1976:1: ( rule__FromEntry__Group_1_1_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1976:2: rule__FromEntry__Group_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__2__Impl4065);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1__2__Impl


    // $ANTLR start rule__FromEntry__Group_1_1__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1986:1: rule__FromEntry__Group_1_1__3 : rule__FromEntry__Group_1_1__3__Impl ;
    public final void rule__FromEntry__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1990:1: ( rule__FromEntry__Group_1_1__3__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1991:2: rule__FromEntry__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__3__Impl_in_rule__FromEntry__Group_1_1__34096);
            rule__FromEntry__Group_1_1__3__Impl();
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
    // $ANTLR end rule__FromEntry__Group_1_1__3


    // $ANTLR start rule__FromEntry__Group_1_1__3__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1997:1: rule__FromEntry__Group_1_1__3__Impl : ( '}' ) ;
    public final void rule__FromEntry__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2001:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2002:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2002:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2003:1: '}'
            {
             before(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3()); 
            match(input,31,FOLLOW_31_in_rule__FromEntry__Group_1_1__3__Impl4124); 
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
    // $ANTLR end rule__FromEntry__Group_1_1__3__Impl


    // $ANTLR start rule__FromEntry__Group_1_1_2__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2024:1: rule__FromEntry__Group_1_1_2__0 : rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1 ;
    public final void rule__FromEntry__Group_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2028:1: ( rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2029:2: rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__0__Impl_in_rule__FromEntry__Group_1_1_2__04163);
            rule__FromEntry__Group_1_1_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__04166);
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


    // $ANTLR start rule__FromEntry__Group_1_1_2__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2036:1: rule__FromEntry__Group_1_1_2__0__Impl : ( ',' ) ;
    public final void rule__FromEntry__Group_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2040:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2041:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2041:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2042:1: ','
            {
             before(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0()); 
            match(input,26,FOLLOW_26_in_rule__FromEntry__Group_1_1_2__0__Impl4194); 
             after(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__FromEntry__Group_1_1_2__0__Impl


    // $ANTLR start rule__FromEntry__Group_1_1_2__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2055:1: rule__FromEntry__Group_1_1_2__1 : rule__FromEntry__Group_1_1_2__1__Impl ;
    public final void rule__FromEntry__Group_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2059:1: ( rule__FromEntry__Group_1_1_2__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2060:2: rule__FromEntry__Group_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__1__Impl_in_rule__FromEntry__Group_1_1_2__14225);
            rule__FromEntry__Group_1_1_2__1__Impl();
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
    // $ANTLR end rule__FromEntry__Group_1_1_2__1


    // $ANTLR start rule__FromEntry__Group_1_1_2__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2066:1: rule__FromEntry__Group_1_1_2__1__Impl : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) ;
    public final void rule__FromEntry__Group_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2070:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2071:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2071:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2072:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2073:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2073:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__1__Impl4252);
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
    // $ANTLR end rule__FromEntry__Group_1_1_2__1__Impl


    // $ANTLR start rule__ResourceScope__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2087:1: rule__ResourceScope__Group__0 : rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2091:1: ( rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2092:2: rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04286);
            rule__ResourceScope__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04289);
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


    // $ANTLR start rule__ResourceScope__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2099:1: rule__ResourceScope__Group__0__Impl : ( ( rule__ResourceScope__NotInAssignment_0 )? ) ;
    public final void rule__ResourceScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2103:1: ( ( ( rule__ResourceScope__NotInAssignment_0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2104:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2104:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2105:1: ( rule__ResourceScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2106:1: ( rule__ResourceScope__NotInAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2106:2: rule__ResourceScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__0__Impl4316);
                    rule__ResourceScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__0__Impl


    // $ANTLR start rule__ResourceScope__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2116:1: rule__ResourceScope__Group__1 : rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2120:1: ( rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2121:2: rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14347);
            rule__ResourceScope__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14350);
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


    // $ANTLR start rule__ResourceScope__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2128:1: rule__ResourceScope__Group__1__Impl : ( 'in' ) ;
    public final void rule__ResourceScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2132:1: ( ( 'in' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2133:1: ( 'in' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2133:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2134:1: 'in'
            {
             before(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ResourceScope__Group__1__Impl4378); 
             after(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__1__Impl


    // $ANTLR start rule__ResourceScope__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2147:1: rule__ResourceScope__Group__2 : rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2151:1: ( rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2152:2: rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24409);
            rule__ResourceScope__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24412);
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


    // $ANTLR start rule__ResourceScope__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2159:1: rule__ResourceScope__Group__2__Impl : ( 'resources' ) ;
    public final void rule__ResourceScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2163:1: ( ( 'resources' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2164:1: ( 'resources' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2164:1: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2165:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ResourceScope__Group__2__Impl4440); 
             after(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__2__Impl


    // $ANTLR start rule__ResourceScope__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2178:1: rule__ResourceScope__Group__3 : rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2182:1: ( rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2183:2: rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34471);
            rule__ResourceScope__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34474);
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


    // $ANTLR start rule__ResourceScope__Group__3__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2190:1: rule__ResourceScope__Group__3__Impl : ( '{' ) ;
    public final void rule__ResourceScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2194:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2195:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2195:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2196:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ResourceScope__Group__3__Impl4502); 
             after(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__3__Impl


    // $ANTLR start rule__ResourceScope__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2209:1: rule__ResourceScope__Group__4 : rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5 ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2213:1: ( rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2214:2: rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44533);
            rule__ResourceScope__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__44536);
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


    // $ANTLR start rule__ResourceScope__Group__4__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2221:1: rule__ResourceScope__Group__4__Impl : ( ( rule__ResourceScope__UrisAssignment_4 ) ) ;
    public final void rule__ResourceScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2225:1: ( ( ( rule__ResourceScope__UrisAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2226:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2226:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2227:1: ( rule__ResourceScope__UrisAssignment_4 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2228:1: ( rule__ResourceScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2228:2: rule__ResourceScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__4__Impl4563);
            rule__ResourceScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__4__Impl


    // $ANTLR start rule__ResourceScope__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2238:1: rule__ResourceScope__Group__5 : rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6 ;
    public final void rule__ResourceScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2242:1: ( rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2243:2: rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__5__Impl_in_rule__ResourceScope__Group__54593);
            rule__ResourceScope__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__54596);
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


    // $ANTLR start rule__ResourceScope__Group__5__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2250:1: rule__ResourceScope__Group__5__Impl : ( ( rule__ResourceScope__Group_5__0 )* ) ;
    public final void rule__ResourceScope__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2254:1: ( ( ( rule__ResourceScope__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2255:1: ( ( rule__ResourceScope__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2255:1: ( ( rule__ResourceScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2256:1: ( rule__ResourceScope__Group_5__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2257:1: ( rule__ResourceScope__Group_5__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==26) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2257:2: rule__ResourceScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__5__Impl4623);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group__5__Impl


    // $ANTLR start rule__ResourceScope__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2267:1: rule__ResourceScope__Group__6 : rule__ResourceScope__Group__6__Impl ;
    public final void rule__ResourceScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2271:1: ( rule__ResourceScope__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2272:2: rule__ResourceScope__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__6__Impl_in_rule__ResourceScope__Group__64654);
            rule__ResourceScope__Group__6__Impl();
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
    // $ANTLR end rule__ResourceScope__Group__6


    // $ANTLR start rule__ResourceScope__Group__6__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2278:1: rule__ResourceScope__Group__6__Impl : ( '}' ) ;
    public final void rule__ResourceScope__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2282:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2283:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2283:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2284:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ResourceScope__Group__6__Impl4682); 
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
    // $ANTLR end rule__ResourceScope__Group__6__Impl


    // $ANTLR start rule__ResourceScope__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2311:1: rule__ResourceScope__Group_5__0 : rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1 ;
    public final void rule__ResourceScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2315:1: ( rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2316:2: rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group_5__0__Impl_in_rule__ResourceScope__Group_5__04727);
            rule__ResourceScope__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__04730);
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


    // $ANTLR start rule__ResourceScope__Group_5__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2323:1: rule__ResourceScope__Group_5__0__Impl : ( ',' ) ;
    public final void rule__ResourceScope__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2327:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2328:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2328:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2329:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ResourceScope__Group_5__0__Impl4758); 
             after(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ResourceScope__Group_5__0__Impl


    // $ANTLR start rule__ResourceScope__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2342:1: rule__ResourceScope__Group_5__1 : rule__ResourceScope__Group_5__1__Impl ;
    public final void rule__ResourceScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2346:1: ( rule__ResourceScope__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2347:2: rule__ResourceScope__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1__Impl_in_rule__ResourceScope__Group_5__14789);
            rule__ResourceScope__Group_5__1__Impl();
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
    // $ANTLR end rule__ResourceScope__Group_5__1


    // $ANTLR start rule__ResourceScope__Group_5__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2353:1: rule__ResourceScope__Group_5__1__Impl : ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ResourceScope__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2357:1: ( ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2358:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2358:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2359:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2360:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2360:2: rule__ResourceScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__1__Impl4816);
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
    // $ANTLR end rule__ResourceScope__Group_5__1__Impl


    // $ANTLR start rule__ElementScope__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2374:1: rule__ElementScope__Group__0 : rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2378:1: ( rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2379:2: rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04850);
            rule__ElementScope__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04853);
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


    // $ANTLR start rule__ElementScope__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2386:1: rule__ElementScope__Group__0__Impl : ( ( rule__ElementScope__NotInAssignment_0 )? ) ;
    public final void rule__ElementScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2390:1: ( ( ( rule__ElementScope__NotInAssignment_0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2391:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2391:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2392:1: ( rule__ElementScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2393:1: ( rule__ElementScope__NotInAssignment_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2393:2: rule__ElementScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__0__Impl4880);
                    rule__ElementScope__NotInAssignment_0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__0__Impl


    // $ANTLR start rule__ElementScope__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2403:1: rule__ElementScope__Group__1 : rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2407:1: ( rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2408:2: rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14911);
            rule__ElementScope__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14914);
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


    // $ANTLR start rule__ElementScope__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2415:1: rule__ElementScope__Group__1__Impl : ( 'in' ) ;
    public final void rule__ElementScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2419:1: ( ( 'in' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2420:1: ( 'in' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2420:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2421:1: 'in'
            {
             before(grammarAccess.getElementScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ElementScope__Group__1__Impl4942); 
             after(grammarAccess.getElementScopeAccess().getInKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__1__Impl


    // $ANTLR start rule__ElementScope__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2434:1: rule__ElementScope__Group__2 : rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2438:1: ( rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2439:2: rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__24973);
            rule__ElementScope__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24976);
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


    // $ANTLR start rule__ElementScope__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2446:1: rule__ElementScope__Group__2__Impl : ( 'elements' ) ;
    public final void rule__ElementScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2450:1: ( ( 'elements' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2451:1: ( 'elements' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2451:1: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2452:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__ElementScope__Group__2__Impl5004); 
             after(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__2__Impl


    // $ANTLR start rule__ElementScope__Group__3
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2465:1: rule__ElementScope__Group__3 : rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2469:1: ( rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2470:2: rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__35035);
            rule__ElementScope__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__35038);
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


    // $ANTLR start rule__ElementScope__Group__3__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2477:1: rule__ElementScope__Group__3__Impl : ( '{' ) ;
    public final void rule__ElementScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2481:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2482:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2482:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2483:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ElementScope__Group__3__Impl5066); 
             after(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__3__Impl


    // $ANTLR start rule__ElementScope__Group__4
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2496:1: rule__ElementScope__Group__4 : rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5 ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2500:1: ( rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2501:2: rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__45097);
            rule__ElementScope__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__45100);
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


    // $ANTLR start rule__ElementScope__Group__4__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2508:1: rule__ElementScope__Group__4__Impl : ( ( rule__ElementScope__UrisAssignment_4 ) ) ;
    public final void rule__ElementScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2512:1: ( ( ( rule__ElementScope__UrisAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2513:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2513:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2514:1: ( rule__ElementScope__UrisAssignment_4 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2515:1: ( rule__ElementScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2515:2: rule__ElementScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__4__Impl5127);
            rule__ElementScope__UrisAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__4__Impl


    // $ANTLR start rule__ElementScope__Group__5
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2525:1: rule__ElementScope__Group__5 : rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6 ;
    public final void rule__ElementScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2529:1: ( rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2530:2: rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__5__Impl_in_rule__ElementScope__Group__55157);
            rule__ElementScope__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__55160);
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


    // $ANTLR start rule__ElementScope__Group__5__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2537:1: rule__ElementScope__Group__5__Impl : ( ( rule__ElementScope__Group_5__0 )* ) ;
    public final void rule__ElementScope__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2541:1: ( ( ( rule__ElementScope__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2542:1: ( ( rule__ElementScope__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2542:1: ( ( rule__ElementScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2543:1: ( rule__ElementScope__Group_5__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2544:1: ( rule__ElementScope__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2544:2: rule__ElementScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__5__Impl5187);
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


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group__5__Impl


    // $ANTLR start rule__ElementScope__Group__6
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2554:1: rule__ElementScope__Group__6 : rule__ElementScope__Group__6__Impl ;
    public final void rule__ElementScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2558:1: ( rule__ElementScope__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2559:2: rule__ElementScope__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__6__Impl_in_rule__ElementScope__Group__65218);
            rule__ElementScope__Group__6__Impl();
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
    // $ANTLR end rule__ElementScope__Group__6


    // $ANTLR start rule__ElementScope__Group__6__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2565:1: rule__ElementScope__Group__6__Impl : ( '}' ) ;
    public final void rule__ElementScope__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2569:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2570:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2570:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2571:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ElementScope__Group__6__Impl5246); 
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
    // $ANTLR end rule__ElementScope__Group__6__Impl


    // $ANTLR start rule__ElementScope__Group_5__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2598:1: rule__ElementScope__Group_5__0 : rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1 ;
    public final void rule__ElementScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2602:1: ( rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2603:2: rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1
            {
            pushFollow(FOLLOW_rule__ElementScope__Group_5__0__Impl_in_rule__ElementScope__Group_5__05291);
            rule__ElementScope__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__05294);
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


    // $ANTLR start rule__ElementScope__Group_5__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2610:1: rule__ElementScope__Group_5__0__Impl : ( ',' ) ;
    public final void rule__ElementScope__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2614:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2615:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2615:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2616:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ElementScope__Group_5__0__Impl5322); 
             after(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ElementScope__Group_5__0__Impl


    // $ANTLR start rule__ElementScope__Group_5__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2629:1: rule__ElementScope__Group_5__1 : rule__ElementScope__Group_5__1__Impl ;
    public final void rule__ElementScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2633:1: ( rule__ElementScope__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2634:2: rule__ElementScope__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementScope__Group_5__1__Impl_in_rule__ElementScope__Group_5__15353);
            rule__ElementScope__Group_5__1__Impl();
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
    // $ANTLR end rule__ElementScope__Group_5__1


    // $ANTLR start rule__ElementScope__Group_5__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2640:1: rule__ElementScope__Group_5__1__Impl : ( ( rule__ElementScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ElementScope__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2644:1: ( ( ( rule__ElementScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2645:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2645:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2646:1: ( rule__ElementScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2647:1: ( rule__ElementScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2647:2: rule__ElementScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__1__Impl5380);
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
    // $ANTLR end rule__ElementScope__Group_5__1__Impl


    // $ANTLR start rule__WhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2661:1: rule__WhereEntry__Group__0 : rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2665:1: ( rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2666:2: rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__05414);
            rule__WhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__05417);
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


    // $ANTLR start rule__WhereEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2673:1: rule__WhereEntry__Group__0__Impl : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2677:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2678:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2678:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2679:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl5444);
            ruleAndWhereEntry();
            _fsp--;

             after(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group__0__Impl


    // $ANTLR start rule__WhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2690:1: rule__WhereEntry__Group__1 : rule__WhereEntry__Group__1__Impl ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2694:1: ( rule__WhereEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2695:2: rule__WhereEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15473);
            rule__WhereEntry__Group__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group__1


    // $ANTLR start rule__WhereEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2701:1: rule__WhereEntry__Group__1__Impl : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2705:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2706:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2706:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2707:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2708:1: ( rule__WhereEntry__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2708:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5500);
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
    // $ANTLR end rule__WhereEntry__Group__1__Impl


    // $ANTLR start rule__WhereEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2722:1: rule__WhereEntry__Group_1__0 : rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2726:1: ( rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2727:2: rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05535);
            rule__WhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05538);
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


    // $ANTLR start rule__WhereEntry__Group_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2734:1: rule__WhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__WhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2738:1: ( ( () ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2739:1: ( () )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2739:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2740:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2741:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2743:1: 
            {
            }

             after(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1__0__Impl


    // $ANTLR start rule__WhereEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2753:1: rule__WhereEntry__Group_1__1 : rule__WhereEntry__Group_1__1__Impl ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2757:1: ( rule__WhereEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2758:2: rule__WhereEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15596);
            rule__WhereEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group_1__1


    // $ANTLR start rule__WhereEntry__Group_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2764:1: rule__WhereEntry__Group_1__1__Impl : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2768:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2769:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2769:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2770:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2770:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2771:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2772:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2772:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5625);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2775:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2776:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2777:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2777:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5637);
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
    // $ANTLR end rule__WhereEntry__Group_1__1__Impl


    // $ANTLR start rule__WhereEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2792:1: rule__WhereEntry__Group_1_1__0 : rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2796:1: ( rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2797:2: rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05674);
            rule__WhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05677);
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


    // $ANTLR start rule__WhereEntry__Group_1_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2804:1: rule__WhereEntry__Group_1_1__0__Impl : ( 'or' ) ;
    public final void rule__WhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2808:1: ( ( 'or' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2809:1: ( 'or' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2809:1: ( 'or' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2810:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__WhereEntry__Group_1_1__0__Impl5705); 
             after(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__WhereEntry__Group_1_1__0__Impl


    // $ANTLR start rule__WhereEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2823:1: rule__WhereEntry__Group_1_1__1 : rule__WhereEntry__Group_1_1__1__Impl ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2827:1: ( rule__WhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2828:2: rule__WhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15736);
            rule__WhereEntry__Group_1_1__1__Impl();
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
    // $ANTLR end rule__WhereEntry__Group_1_1__1


    // $ANTLR start rule__WhereEntry__Group_1_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2834:1: rule__WhereEntry__Group_1_1__1__Impl : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2838:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2839:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2839:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2840:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2841:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2841:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5763);
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
    // $ANTLR end rule__WhereEntry__Group_1_1__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2855:1: rule__AndWhereEntry__Group__0 : rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2859:1: ( rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2860:2: rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05797);
            rule__AndWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05800);
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


    // $ANTLR start rule__AndWhereEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2867:1: rule__AndWhereEntry__Group__0__Impl : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2871:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2872:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2872:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2873:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5827);
            ruleConcreteWhereEntry();
            _fsp--;

             after(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2884:1: rule__AndWhereEntry__Group__1 : rule__AndWhereEntry__Group__1__Impl ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2888:1: ( rule__AndWhereEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2889:2: rule__AndWhereEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15856);
            rule__AndWhereEntry__Group__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group__1


    // $ANTLR start rule__AndWhereEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2895:1: rule__AndWhereEntry__Group__1__Impl : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2899:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2900:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2900:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2901:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2902:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2902:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5883);
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
    // $ANTLR end rule__AndWhereEntry__Group__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2916:1: rule__AndWhereEntry__Group_1__0 : rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2920:1: ( rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2921:2: rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05918);
            rule__AndWhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05921);
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


    // $ANTLR start rule__AndWhereEntry__Group_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2928:1: rule__AndWhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__AndWhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2932:1: ( ( () ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2933:1: ( () )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2933:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2934:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2935:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2937:1: 
            {
            }

             after(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2947:1: rule__AndWhereEntry__Group_1__1 : rule__AndWhereEntry__Group_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2951:1: ( rule__AndWhereEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2952:2: rule__AndWhereEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__15979);
            rule__AndWhereEntry__Group_1__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2958:1: rule__AndWhereEntry__Group_1__1__Impl : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2962:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2963:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2963:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2964:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2964:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2965:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2966:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2966:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6008);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2969:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2970:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2971:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2971:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6020);
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
    // $ANTLR end rule__AndWhereEntry__Group_1__1__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2986:1: rule__AndWhereEntry__Group_1_1__0 : rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2990:1: ( rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2991:2: rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__06057);
            rule__AndWhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__06060);
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


    // $ANTLR start rule__AndWhereEntry__Group_1_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2998:1: rule__AndWhereEntry__Group_1_1__0__Impl : ( 'and' ) ;
    public final void rule__AndWhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3002:1: ( ( 'and' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3003:1: ( 'and' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3003:1: ( 'and' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3004:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,35,FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__0__Impl6088); 
             after(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndWhereEntry__Group_1_1__0__Impl


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3017:1: rule__AndWhereEntry__Group_1_1__1 : rule__AndWhereEntry__Group_1_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3021:1: ( rule__AndWhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3022:2: rule__AndWhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__16119);
            rule__AndWhereEntry__Group_1_1__1__Impl();
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
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1


    // $ANTLR start rule__AndWhereEntry__Group_1_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3028:1: rule__AndWhereEntry__Group_1_1__1__Impl : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3032:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3033:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3033:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3034:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3035:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3035:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl6146);
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
    // $ANTLR end rule__AndWhereEntry__Group_1_1__1__Impl


    // $ANTLR start rule__ParWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3049:1: rule__ParWhereEntry__Group__0 : rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3053:1: ( rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3054:2: rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__06180);
            rule__ParWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__06183);
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


    // $ANTLR start rule__ParWhereEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3061:1: rule__ParWhereEntry__Group__0__Impl : ( '(' ) ;
    public final void rule__ParWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3065:1: ( ( '(' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3066:1: ( '(' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3066:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3067:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ParWhereEntry__Group__0__Impl6211); 
             after(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__0__Impl


    // $ANTLR start rule__ParWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3080:1: rule__ParWhereEntry__Group__1 : rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3084:1: ( rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3085:2: rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__16242);
            rule__ParWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__16245);
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


    // $ANTLR start rule__ParWhereEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3092:1: rule__ParWhereEntry__Group__1__Impl : ( ruleWhereEntry ) ;
    public final void rule__ParWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3096:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3097:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3097:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3098:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl6272);
            ruleWhereEntry();
            _fsp--;

             after(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ParWhereEntry__Group__1__Impl


    // $ANTLR start rule__ParWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3109:1: rule__ParWhereEntry__Group__2 : rule__ParWhereEntry__Group__2__Impl ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3113:1: ( rule__ParWhereEntry__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3114:2: rule__ParWhereEntry__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__26301);
            rule__ParWhereEntry__Group__2__Impl();
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
    // $ANTLR end rule__ParWhereEntry__Group__2


    // $ANTLR start rule__ParWhereEntry__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3120:1: rule__ParWhereEntry__Group__2__Impl : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3124:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3125:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3125:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3126:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__ParWhereEntry__Group__2__Impl6329); 
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
    // $ANTLR end rule__ParWhereEntry__Group__2__Impl


    // $ANTLR start rule__ExpressionWhereEntry__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3145:1: rule__ExpressionWhereEntry__Group__0 : rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1 ;
    public final void rule__ExpressionWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3149:1: ( rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3150:2: rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__0__Impl_in_rule__ExpressionWhereEntry__Group__06366);
            rule__ExpressionWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__06369);
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


    // $ANTLR start rule__ExpressionWhereEntry__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3157:1: rule__ExpressionWhereEntry__Group__0__Impl : ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3161:1: ( ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3162:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3162:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3163:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3164:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3164:2: rule__ExpressionWhereEntry__LhsAssignment_0
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__0__Impl6396);
            rule__ExpressionWhereEntry__LhsAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getLhsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__Group__0__Impl


    // $ANTLR start rule__ExpressionWhereEntry__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3174:1: rule__ExpressionWhereEntry__Group__1 : rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2 ;
    public final void rule__ExpressionWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3178:1: ( rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3179:2: rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__1__Impl_in_rule__ExpressionWhereEntry__Group__16426);
            rule__ExpressionWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__16429);
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


    // $ANTLR start rule__ExpressionWhereEntry__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3186:1: rule__ExpressionWhereEntry__Group__1__Impl : ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3190:1: ( ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3191:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3191:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3192:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3193:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3193:2: rule__ExpressionWhereEntry__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__1__Impl6456);
            rule__ExpressionWhereEntry__OperatorAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getExpressionWhereEntryAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ExpressionWhereEntry__Group__1__Impl


    // $ANTLR start rule__ExpressionWhereEntry__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3203:1: rule__ExpressionWhereEntry__Group__2 : rule__ExpressionWhereEntry__Group__2__Impl ;
    public final void rule__ExpressionWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3207:1: ( rule__ExpressionWhereEntry__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3208:2: rule__ExpressionWhereEntry__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__2__Impl_in_rule__ExpressionWhereEntry__Group__26486);
            rule__ExpressionWhereEntry__Group__2__Impl();
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
    // $ANTLR end rule__ExpressionWhereEntry__Group__2


    // $ANTLR start rule__ExpressionWhereEntry__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3214:1: rule__ExpressionWhereEntry__Group__2__Impl : ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3218:1: ( ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3219:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3219:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3220:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3221:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3221:2: rule__ExpressionWhereEntry__RhsAssignment_2
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__2__Impl6513);
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
    // $ANTLR end rule__ExpressionWhereEntry__Group__2__Impl


    // $ANTLR start rule__AliasAttributeExpression__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3237:1: rule__AliasAttributeExpression__Group__0 : rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1 ;
    public final void rule__AliasAttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3241:1: ( rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3242:2: rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__0__Impl_in_rule__AliasAttributeExpression__Group__06549);
            rule__AliasAttributeExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__06552);
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


    // $ANTLR start rule__AliasAttributeExpression__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3249:1: rule__AliasAttributeExpression__Group__0__Impl : ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) ;
    public final void rule__AliasAttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3253:1: ( ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3254:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3254:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3255:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3256:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3256:2: rule__AliasAttributeExpression__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__0__Impl6579);
            rule__AliasAttributeExpression__AliasAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getAliasAttributeExpressionAccess().getAliasAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__Group__0__Impl


    // $ANTLR start rule__AliasAttributeExpression__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3266:1: rule__AliasAttributeExpression__Group__1 : rule__AliasAttributeExpression__Group__1__Impl ;
    public final void rule__AliasAttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3270:1: ( rule__AliasAttributeExpression__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3271:2: rule__AliasAttributeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__1__Impl_in_rule__AliasAttributeExpression__Group__16609);
            rule__AliasAttributeExpression__Group__1__Impl();
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
    // $ANTLR end rule__AliasAttributeExpression__Group__1


    // $ANTLR start rule__AliasAttributeExpression__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3277:1: rule__AliasAttributeExpression__Group__1__Impl : ( ( rule__AliasAttributeExpression__Group_1__0 )? ) ;
    public final void rule__AliasAttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3281:1: ( ( ( rule__AliasAttributeExpression__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3282:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3282:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3283:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3284:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3284:2: rule__AliasAttributeExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__1__Impl6636);
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
    // $ANTLR end rule__AliasAttributeExpression__Group__1__Impl


    // $ANTLR start rule__AliasAttributeExpression__Group_1__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3298:1: rule__AliasAttributeExpression__Group_1__0 : rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1 ;
    public final void rule__AliasAttributeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3302:1: ( rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3303:2: rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__0__Impl_in_rule__AliasAttributeExpression__Group_1__06671);
            rule__AliasAttributeExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__06674);
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


    // $ANTLR start rule__AliasAttributeExpression__Group_1__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3310:1: rule__AliasAttributeExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AliasAttributeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3314:1: ( ( '.' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3315:1: ( '.' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3315:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3316:1: '.'
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__0__Impl6702); 
             after(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AliasAttributeExpression__Group_1__0__Impl


    // $ANTLR start rule__AliasAttributeExpression__Group_1__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3329:1: rule__AliasAttributeExpression__Group_1__1 : rule__AliasAttributeExpression__Group_1__1__Impl ;
    public final void rule__AliasAttributeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3333:1: ( rule__AliasAttributeExpression__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3334:2: rule__AliasAttributeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__1__Impl_in_rule__AliasAttributeExpression__Group_1__16733);
            rule__AliasAttributeExpression__Group_1__1__Impl();
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
    // $ANTLR end rule__AliasAttributeExpression__Group_1__1


    // $ANTLR start rule__AliasAttributeExpression__Group_1__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3340:1: rule__AliasAttributeExpression__Group_1__1__Impl : ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) ;
    public final void rule__AliasAttributeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3344:1: ( ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3345:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3345:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3346:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3347:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3347:2: rule__AliasAttributeExpression__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__1__Impl6760);
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
    // $ANTLR end rule__AliasAttributeExpression__Group_1__1__Impl


    // $ANTLR start rule__QueryExpression__Group__0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3361:1: rule__QueryExpression__Group__0 : rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1 ;
    public final void rule__QueryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3365:1: ( rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3366:2: rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__0__Impl_in_rule__QueryExpression__Group__06794);
            rule__QueryExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__06797);
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


    // $ANTLR start rule__QueryExpression__Group__0__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3373:1: rule__QueryExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__QueryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3377:1: ( ( '(' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3378:1: ( '(' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3378:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3379:1: '('
            {
             before(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__QueryExpression__Group__0__Impl6825); 
             after(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QueryExpression__Group__0__Impl


    // $ANTLR start rule__QueryExpression__Group__1
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3392:1: rule__QueryExpression__Group__1 : rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2 ;
    public final void rule__QueryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3396:1: ( rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3397:2: rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__1__Impl_in_rule__QueryExpression__Group__16856);
            rule__QueryExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__16859);
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


    // $ANTLR start rule__QueryExpression__Group__1__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3404:1: rule__QueryExpression__Group__1__Impl : ( ( rule__QueryExpression__ValueAssignment_1 ) ) ;
    public final void rule__QueryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3408:1: ( ( ( rule__QueryExpression__ValueAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3409:1: ( ( rule__QueryExpression__ValueAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3409:1: ( ( rule__QueryExpression__ValueAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3410:1: ( rule__QueryExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getQueryExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3411:1: ( rule__QueryExpression__ValueAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3411:2: rule__QueryExpression__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__1__Impl6886);
            rule__QueryExpression__ValueAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getQueryExpressionAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__QueryExpression__Group__1__Impl


    // $ANTLR start rule__QueryExpression__Group__2
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3421:1: rule__QueryExpression__Group__2 : rule__QueryExpression__Group__2__Impl ;
    public final void rule__QueryExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3425:1: ( rule__QueryExpression__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3426:2: rule__QueryExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__2__Impl_in_rule__QueryExpression__Group__26916);
            rule__QueryExpression__Group__2__Impl();
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
    // $ANTLR end rule__QueryExpression__Group__2


    // $ANTLR start rule__QueryExpression__Group__2__Impl
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3432:1: rule__QueryExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__QueryExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3436:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3437:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3437:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3438:1: ')'
            {
             before(grammarAccess.getQueryExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__QueryExpression__Group__2__Impl6944); 
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
    // $ANTLR end rule__QueryExpression__Group__2__Impl


    // $ANTLR start rule__Model__ImportsAssignment_0
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3458:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3462:1: ( ( ruleImport ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3463:1: ( ruleImport )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3463:1: ( ruleImport )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3464:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06986);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3473:1: rule__Model__DefaultQueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__DefaultQueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3477:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3478:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3478:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3479:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_17017);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3488:1: rule__Model__NamedQueriesAssignment_2 : ( ruleNamedQuery ) ;
    public final void rule__Model__NamedQueriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3492:1: ( ( ruleNamedQuery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3493:1: ( ruleNamedQuery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3493:1: ( ruleNamedQuery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3494:1: ruleNamedQuery
            {
             before(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_27048);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3503:1: rule__Import__ImpURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImpURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3507:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3508:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3508:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3509:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_17079); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3518:1: rule__NamedQuery__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__NamedQuery__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3522:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3523:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3523:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3524:1: RULE_ID
            {
             before(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_07110); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3533:1: rule__NamedQuery__QueryAssignment_2 : ( ruleMQLquery ) ;
    public final void rule__NamedQuery__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3537:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3538:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3538:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3539:1: ruleMQLquery
            {
             before(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_27141);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3548:1: rule__MQLquery__FromEntriesAssignment_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3552:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3553:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3553:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3554:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_17172);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3563:1: rule__MQLquery__FromEntriesAssignment_2_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3567:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3568:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3568:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3569:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_17203);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3578:1: rule__MQLquery__SelectEntriesAssignment_4 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3582:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3583:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3583:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3584:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_47234);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3593:1: rule__MQLquery__SelectEntriesAssignment_5_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3597:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3598:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3598:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3599:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_17265);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3608:1: rule__MQLquery__WhereEntryAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntryAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3612:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3613:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3613:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3614:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17296);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3623:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3627:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3628:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3628:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3629:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3630:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3631:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07331); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3642:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3646:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3647:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3647:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3648:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3649:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3650:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17370); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3661:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3665:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3666:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3666:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3667:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3668:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3669:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07409); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3680:1: rule__FromEntry__WithoutsubtypesAssignment_1_0 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3684:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3685:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3685:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3686:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3687:1: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3688:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            match(input,38,FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_07449); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3703:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3707:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3708:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3708:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3709:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3710:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3711:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_17492); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3722:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3726:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3727:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3727:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3728:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3729:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3730:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_17531); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3741:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3745:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3746:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3746:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3747:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37566); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3756:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3760:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3761:1: ( ruleScopeClause )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3761:1: ( ruleScopeClause )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3762:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47597);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3771:1: rule__ResourceScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ResourceScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3775:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3776:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3776:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3777:1: ( 'not' )
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3778:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3779:1: 'not'
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07633); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3794:1: rule__ResourceScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3798:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3799:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3799:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3800:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47672); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3809:1: rule__ResourceScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3813:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3814:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3814:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3815:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17703); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3824:1: rule__ElementScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ElementScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3828:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3829:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3829:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3830:1: ( 'not' )
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3831:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3832:1: 'not'
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ElementScope__NotInAssignment_07739); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3847:1: rule__ElementScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3851:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3852:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3852:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3853:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47778); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3862:1: rule__ElementScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3866:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3867:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3867:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3868:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17809); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3877:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3881:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3882:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3882:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3883:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17840);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3892:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3896:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3897:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3897:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3898:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17871);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3907:1: rule__ExpressionWhereEntry__LhsAssignment_0 : ( ruleAliasAttributeExpression ) ;
    public final void rule__ExpressionWhereEntry__LhsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3911:1: ( ( ruleAliasAttributeExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3912:1: ( ruleAliasAttributeExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3912:1: ( ruleAliasAttributeExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3913:1: ruleAliasAttributeExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_07902);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3922:1: rule__ExpressionWhereEntry__OperatorAssignment_1 : ( ruleOperator ) ;
    public final void rule__ExpressionWhereEntry__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3926:1: ( ( ruleOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3927:1: ( ruleOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3927:1: ( ruleOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3928:1: ruleOperator
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_17933);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3937:1: rule__ExpressionWhereEntry__RhsAssignment_2 : ( ruleExpression ) ;
    public final void rule__ExpressionWhereEntry__RhsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3941:1: ( ( ruleExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3942:1: ( ruleExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3942:1: ( ruleExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3943:1: ruleExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_27964);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3952:1: rule__AliasAttributeExpression__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3956:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3957:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3957:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3958:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3959:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3960:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_07999); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3971:1: rule__AliasAttributeExpression__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3975:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3976:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3976:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3977:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3978:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3979:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_18038); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3990:1: rule__DoubleExpression__ValueAssignment : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3994:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3995:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3995:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3996:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0()); 
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment8073); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4005:1: rule__LongExpression__ValueAssignment : ( RULE_SINGED_LONG ) ;
    public final void rule__LongExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4009:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4010:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4010:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4011:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0()); 
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment8104); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4020:1: rule__StringExpression__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4024:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4025:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4025:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4026:1: RULE_STRING
            {
             before(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment8135); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4035:1: rule__NullExpression__ValueAssignment : ( ( 'null' ) ) ;
    public final void rule__NullExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4039:1: ( ( ( 'null' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4040:1: ( ( 'null' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4040:1: ( ( 'null' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4041:1: ( 'null' )
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4042:1: ( 'null' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4043:1: 'null'
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__NullExpression__ValueAssignment8171); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4058:1: rule__BooleanExpression__TrueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanExpression__TrueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4062:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4063:1: ( ( 'true' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4063:1: ( ( 'true' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4064:1: ( 'true' )
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4065:1: ( 'true' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4066:1: 'true'
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            match(input,41,FOLLOW_41_in_rule__BooleanExpression__TrueAssignment_08215); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4081:1: rule__QueryExpression__ValueAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__QueryExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4085:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4086:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4086:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4087:1: ruleMQLquery
            {
             before(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_18254);
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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedQuery188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__0_in_ruleNamedQuery214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__0_in_ruleMQLquery274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__0_in_ruleSelectEntry334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__0_in_ruleFromEntry394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ScopeClause__Alternatives_in_ruleScopeClause454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__0_in_ruleResourceScope514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__0_in_ruleElementScope574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__0_in_ruleWhereEntry634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0_in_ruleAndWhereEntry694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcreteWhereEntry__Alternatives_in_ruleConcreteWhereEntry754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0_in_ruleParWhereEntry814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionWhereEntry848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__0_in_ruleExpressionWhereEntry874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasAttributeExpression908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__0_in_ruleAliasAttributeExpression934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Expression__Alternatives_in_ruleExpression994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleExpression1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleExpression__ValueAssignment_in_ruleDoubleExpression1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_entryRuleLongExpression1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongExpression1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongExpression__ValueAssignment_in_ruleLongExpression1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringExpression__ValueAssignment_in_ruleStringExpression1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullExpression__ValueAssignment_in_ruleNullExpression1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Alternatives_in_ruleBooleanExpression1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryExpression1328 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__01934 = new BitSet(new long[]{0x0000000001000022L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__01937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl1964 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__11995 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__11998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__1__Impl2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__2__Impl2083 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__0__Impl2151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__1__Impl2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__0__Impl_in_rule__NamedQuery__Group__02243 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__0__Impl2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1__Impl_in_rule__NamedQuery__Group__12303 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__NamedQuery__Group__1__Impl2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2__Impl_in_rule__NamedQuery__Group__22365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__2__Impl2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02428 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group__0__Impl2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12490 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22550 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2580 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32611 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MQLquery__Group__3__Impl2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42673 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52733 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2763 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02866 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_2__0__Impl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__12928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__02989 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__02992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_5__0__Impl3020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03112 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MQLquery__Group_6__0__Impl3143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03235 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SelectEntry__Group_1__0__Impl3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03480 = new BitSet(new long[]{0x0000004020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13540 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__1__Impl3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23601 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FromEntry__Group__2__Impl3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33663 = new BitSet(new long[]{0x0000008000200002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__0__Impl_in_rule__FromEntry__Group_1__03791 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__0__Impl3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__1__Impl_in_rule__FromEntry__Group_1__13851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__1__Impl3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__0__Impl_in_rule__FromEntry__Group_1_1__03913 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FromEntry__Group_1_1__0__Impl3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__1__Impl_in_rule__FromEntry__Group_1_1__13975 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__13978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__1__Impl4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__2__Impl_in_rule__FromEntry__Group_1_1__24035 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__24038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__2__Impl4065 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__3__Impl_in_rule__FromEntry__Group_1_1__34096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FromEntry__Group_1_1__3__Impl4124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__0__Impl_in_rule__FromEntry__Group_1_1_2__04163 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__04166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FromEntry__Group_1_1_2__0__Impl4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__1__Impl_in_rule__FromEntry__Group_1_1_2__14225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__1__Impl4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04286 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__0__Impl4316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14347 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResourceScope__Group__1__Impl4378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24409 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ResourceScope__Group__2__Impl4440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34471 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__3__Impl4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44533 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__44536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__4__Impl4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5__Impl_in_rule__ResourceScope__Group__54593 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__54596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__5__Impl4623 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6__Impl_in_rule__ResourceScope__Group__64654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResourceScope__Group__6__Impl4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0__Impl_in_rule__ResourceScope__Group_5__04727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__04730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResourceScope__Group_5__0__Impl4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1__Impl_in_rule__ResourceScope__Group_5__14789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__1__Impl4816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04850 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__0__Impl4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14911 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ElementScope__Group__1__Impl4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__24973 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__24976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ElementScope__Group__2__Impl5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__35035 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__35038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__3__Impl5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__45097 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__45100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__4__Impl5127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5__Impl_in_rule__ElementScope__Group__55157 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__55160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__5__Impl5187 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6__Impl_in_rule__ElementScope__Group__65218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__6__Impl5246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0__Impl_in_rule__ElementScope__Group_5__05291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__05294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ElementScope__Group_5__0__Impl5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1__Impl_in_rule__ElementScope__Group_5__15353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__1__Impl5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__05414 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__05417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl5444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05535 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5625 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5637 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05674 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__WhereEntry__Group_1_1__0__Impl5705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05797 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05918 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__15979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6008 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6020 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__06057 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__06060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__0__Impl6088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__16119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl6146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__06180 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__06183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParWhereEntry__Group__0__Impl6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__16242 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__16245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__26301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ParWhereEntry__Group__2__Impl6329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__0__Impl_in_rule__ExpressionWhereEntry__Group__06366 = new BitSet(new long[]{0x00000000003FF000L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__06369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__0__Impl6396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__1__Impl_in_rule__ExpressionWhereEntry__Group__16426 = new BitSet(new long[]{0x00000310000008F0L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__16429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__1__Impl6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__2__Impl_in_rule__ExpressionWhereEntry__Group__26486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__2__Impl6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__0__Impl_in_rule__AliasAttributeExpression__Group__06549 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__06552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__0__Impl6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__1__Impl_in_rule__AliasAttributeExpression__Group__16609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__1__Impl6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__0__Impl_in_rule__AliasAttributeExpression__Group_1__06671 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__06674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__0__Impl6702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__1__Impl_in_rule__AliasAttributeExpression__Group_1__16733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__1__Impl6760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__0__Impl_in_rule__QueryExpression__Group__06794 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__06797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__QueryExpression__Group__0__Impl6825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__1__Impl_in_rule__QueryExpression__Group__16856 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__16859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__1__Impl6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__2__Impl_in_rule__QueryExpression__Group__26916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QueryExpression__Group__2__Impl6944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_06986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_17017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_27048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_17079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_07110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_27141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_17172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_17203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_47234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_17265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_07449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_17492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_17531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ElementScope__NotInAssignment_07739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_07902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_17933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_27964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_07999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_18038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment8073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment8104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment8135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__NullExpression__ValueAssignment8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__BooleanExpression__TrueAssignment_08215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_18254 = new BitSet(new long[]{0x0000000000000002L});

}