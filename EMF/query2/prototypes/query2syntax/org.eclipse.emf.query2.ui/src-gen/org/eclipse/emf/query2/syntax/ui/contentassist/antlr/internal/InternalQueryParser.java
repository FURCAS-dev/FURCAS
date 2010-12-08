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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'not like'", "'not in'", "'in'", "'import'", "':'", "'from'", "'select'", "','", "'where'", "'.'", "'as'", "'{'", "'}'", "'resources'", "'elements'", "'or'", "'and'", "'('", "')'", "'withoutsubtypes'", "'not'", "'?'", "'null'", "'true'"
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


    // $ANTLR start entryRuleReplacableValue
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:509:1: entryRuleReplacableValue : ruleReplacableValue EOF ;
    public final void entryRuleReplacableValue() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:510:1: ( ruleReplacableValue EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:511:1: ruleReplacableValue EOF
            {
             before(grammarAccess.getReplacableValueRule()); 
            pushFollow(FOLLOW_ruleReplacableValue_in_entryRuleReplacableValue1021);
            ruleReplacableValue();
            _fsp--;

             after(grammarAccess.getReplacableValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReplacableValue1028); 

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
    // $ANTLR end entryRuleReplacableValue


    // $ANTLR start ruleReplacableValue
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:518:1: ruleReplacableValue : ( ( rule__ReplacableValue__ValueAssignment ) ) ;
    public final void ruleReplacableValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:522:2: ( ( ( rule__ReplacableValue__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:523:1: ( ( rule__ReplacableValue__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:523:1: ( ( rule__ReplacableValue__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:524:1: ( rule__ReplacableValue__ValueAssignment )
            {
             before(grammarAccess.getReplacableValueAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:525:1: ( rule__ReplacableValue__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:525:2: rule__ReplacableValue__ValueAssignment
            {
            pushFollow(FOLLOW_rule__ReplacableValue__ValueAssignment_in_ruleReplacableValue1054);
            rule__ReplacableValue__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getReplacableValueAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReplacableValue


    // $ANTLR start entryRuleDoubleExpression
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:537:1: entryRuleDoubleExpression : ruleDoubleExpression EOF ;
    public final void entryRuleDoubleExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:538:1: ( ruleDoubleExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:539:1: ruleDoubleExpression EOF
            {
             before(grammarAccess.getDoubleExpressionRule()); 
            pushFollow(FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1081);
            ruleDoubleExpression();
            _fsp--;

             after(grammarAccess.getDoubleExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleExpression1088); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:546:1: ruleDoubleExpression : ( ( rule__DoubleExpression__ValueAssignment ) ) ;
    public final void ruleDoubleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:550:2: ( ( ( rule__DoubleExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:551:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:551:1: ( ( rule__DoubleExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:552:1: ( rule__DoubleExpression__ValueAssignment )
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:553:1: ( rule__DoubleExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:553:2: rule__DoubleExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__DoubleExpression__ValueAssignment_in_ruleDoubleExpression1114);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:565:1: entryRuleLongExpression : ruleLongExpression EOF ;
    public final void entryRuleLongExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:566:1: ( ruleLongExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:567:1: ruleLongExpression EOF
            {
             before(grammarAccess.getLongExpressionRule()); 
            pushFollow(FOLLOW_ruleLongExpression_in_entryRuleLongExpression1141);
            ruleLongExpression();
            _fsp--;

             after(grammarAccess.getLongExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongExpression1148); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:574:1: ruleLongExpression : ( ( rule__LongExpression__ValueAssignment ) ) ;
    public final void ruleLongExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:578:2: ( ( ( rule__LongExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:579:1: ( ( rule__LongExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:579:1: ( ( rule__LongExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:580:1: ( rule__LongExpression__ValueAssignment )
            {
             before(grammarAccess.getLongExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:581:1: ( rule__LongExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:581:2: rule__LongExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__LongExpression__ValueAssignment_in_ruleLongExpression1174);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:593:1: entryRuleStringExpression : ruleStringExpression EOF ;
    public final void entryRuleStringExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:594:1: ( ruleStringExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:595:1: ruleStringExpression EOF
            {
             before(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression1201);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getStringExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression1208); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:602:1: ruleStringExpression : ( ( rule__StringExpression__ValueAssignment ) ) ;
    public final void ruleStringExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:606:2: ( ( ( rule__StringExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:607:1: ( ( rule__StringExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:607:1: ( ( rule__StringExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:608:1: ( rule__StringExpression__ValueAssignment )
            {
             before(grammarAccess.getStringExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:609:1: ( rule__StringExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:609:2: rule__StringExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringExpression__ValueAssignment_in_ruleStringExpression1234);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:621:1: entryRuleNullExpression : ruleNullExpression EOF ;
    public final void entryRuleNullExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:622:1: ( ruleNullExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:623:1: ruleNullExpression EOF
            {
             before(grammarAccess.getNullExpressionRule()); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression1261);
            ruleNullExpression();
            _fsp--;

             after(grammarAccess.getNullExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression1268); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:630:1: ruleNullExpression : ( ( rule__NullExpression__ValueAssignment ) ) ;
    public final void ruleNullExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:634:2: ( ( ( rule__NullExpression__ValueAssignment ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:635:1: ( ( rule__NullExpression__ValueAssignment ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:635:1: ( ( rule__NullExpression__ValueAssignment ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:636:1: ( rule__NullExpression__ValueAssignment )
            {
             before(grammarAccess.getNullExpressionAccess().getValueAssignment()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:637:1: ( rule__NullExpression__ValueAssignment )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:637:2: rule__NullExpression__ValueAssignment
            {
            pushFollow(FOLLOW_rule__NullExpression__ValueAssignment_in_ruleNullExpression1294);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:649:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:650:1: ( ruleBooleanExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:651:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1321);
            ruleBooleanExpression();
            _fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression1328); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:658:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Alternatives ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:662:2: ( ( ( rule__BooleanExpression__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:663:1: ( ( rule__BooleanExpression__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:663:1: ( ( rule__BooleanExpression__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:664:1: ( rule__BooleanExpression__Alternatives )
            {
             before(grammarAccess.getBooleanExpressionAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:665:1: ( rule__BooleanExpression__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:665:2: rule__BooleanExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__BooleanExpression__Alternatives_in_ruleBooleanExpression1354);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:677:1: entryRuleQueryExpression : ruleQueryExpression EOF ;
    public final void entryRuleQueryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:678:1: ( ruleQueryExpression EOF )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:679:1: ruleQueryExpression EOF
            {
             before(grammarAccess.getQueryExpressionRule()); 
            pushFollow(FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1381);
            ruleQueryExpression();
            _fsp--;

             after(grammarAccess.getQueryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryExpression1388); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:686:1: ruleQueryExpression : ( ( rule__QueryExpression__Group__0 ) ) ;
    public final void ruleQueryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:690:2: ( ( ( rule__QueryExpression__Group__0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:691:1: ( ( rule__QueryExpression__Group__0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:691:1: ( ( rule__QueryExpression__Group__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:692:1: ( rule__QueryExpression__Group__0 )
            {
             before(grammarAccess.getQueryExpressionAccess().getGroup()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:693:1: ( rule__QueryExpression__Group__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:693:2: rule__QueryExpression__Group__0
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__0_in_ruleQueryExpression1414);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:706:1: ruleOperator : ( ( rule__Operator__Alternatives ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:710:1: ( ( ( rule__Operator__Alternatives ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:711:1: ( ( rule__Operator__Alternatives ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:711:1: ( ( rule__Operator__Alternatives ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:712:1: ( rule__Operator__Alternatives )
            {
             before(grammarAccess.getOperatorAccess().getAlternatives()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:713:1: ( rule__Operator__Alternatives )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:713:2: rule__Operator__Alternatives
            {
            pushFollow(FOLLOW_rule__Operator__Alternatives_in_ruleOperator1451);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:724:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );
    public final void rule__ScopeClause__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:728:1: ( ( ruleResourceScope ) | ( ruleElementScope ) )
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
                            new NoViableAltException("724:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("724:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 1, input);

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
                        new NoViableAltException("724:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("724:1: rule__ScopeClause__Alternatives : ( ( ruleResourceScope ) | ( ruleElementScope ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:729:1: ( ruleResourceScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:729:1: ( ruleResourceScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:730:1: ruleResourceScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1486);
                    ruleResourceScope();
                    _fsp--;

                     after(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:735:6: ( ruleElementScope )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:735:6: ( ruleElementScope )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:736:1: ruleElementScope
                    {
                     before(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1503);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:746:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );
    public final void rule__ConcreteWhereEntry__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:750:1: ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) )
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
                    new NoViableAltException("746:1: rule__ConcreteWhereEntry__Alternatives : ( ( ruleParWhereEntry ) | ( ruleExpressionWhereEntry ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:751:1: ( ruleParWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:751:1: ( ruleParWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:752:1: ruleParWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1535);
                    ruleParWhereEntry();
                    _fsp--;

                     after(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:757:6: ( ruleExpressionWhereEntry )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:757:6: ( ruleExpressionWhereEntry )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:758:1: ruleExpressionWhereEntry
                    {
                     before(grammarAccess.getConcreteWhereEntryAccess().getExpressionWhereEntryParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleExpressionWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1552);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:768:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) | ( ruleReplacableValue ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:772:1: ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) | ( ruleReplacableValue ) )
            int alt3=8;
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
            case 41:
                {
                alt3=5;
                }
                break;
            case 11:
            case 42:
                {
                alt3=6;
                }
                break;
            case 36:
                {
                alt3=7;
                }
                break;
            case 40:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("768:1: rule__Expression__Alternatives : ( ( ruleAliasAttributeExpression ) | ( ruleDoubleExpression ) | ( ruleLongExpression ) | ( ruleStringExpression ) | ( ruleNullExpression ) | ( ruleBooleanExpression ) | ( ruleQueryExpression ) | ( ruleReplacableValue ) );", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:773:1: ( ruleAliasAttributeExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:773:1: ( ruleAliasAttributeExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:774:1: ruleAliasAttributeExpression
                    {
                     before(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAliasAttributeExpression_in_rule__Expression__Alternatives1584);
                    ruleAliasAttributeExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:779:6: ( ruleDoubleExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:779:6: ( ruleDoubleExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:780:1: ruleDoubleExpression
                    {
                     before(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleDoubleExpression_in_rule__Expression__Alternatives1601);
                    ruleDoubleExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:785:6: ( ruleLongExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:785:6: ( ruleLongExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:786:1: ruleLongExpression
                    {
                     before(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleLongExpression_in_rule__Expression__Alternatives1618);
                    ruleLongExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:791:6: ( ruleStringExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:791:6: ( ruleStringExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:792:1: ruleStringExpression
                    {
                     before(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleStringExpression_in_rule__Expression__Alternatives1635);
                    ruleStringExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:797:6: ( ruleNullExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:797:6: ( ruleNullExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:798:1: ruleNullExpression
                    {
                     before(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleNullExpression_in_rule__Expression__Alternatives1652);
                    ruleNullExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:803:6: ( ruleBooleanExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:803:6: ( ruleBooleanExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:804:1: ruleBooleanExpression
                    {
                     before(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleBooleanExpression_in_rule__Expression__Alternatives1669);
                    ruleBooleanExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:809:6: ( ruleQueryExpression )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:809:6: ( ruleQueryExpression )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:810:1: ruleQueryExpression
                    {
                     before(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleQueryExpression_in_rule__Expression__Alternatives1686);
                    ruleQueryExpression();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:815:6: ( ruleReplacableValue )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:815:6: ( ruleReplacableValue )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:816:1: ruleReplacableValue
                    {
                     before(grammarAccess.getExpressionAccess().getReplacableValueParserRuleCall_7()); 
                    pushFollow(FOLLOW_ruleReplacableValue_in_rule__Expression__Alternatives1703);
                    ruleReplacableValue();
                    _fsp--;

                     after(grammarAccess.getExpressionAccess().getReplacableValueParserRuleCall_7()); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:826:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );
    public final void rule__BooleanExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:830:1: ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==42) ) {
                alt4=1;
            }
            else if ( (LA4_0==11) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("826:1: rule__BooleanExpression__Alternatives : ( ( ( rule__BooleanExpression__TrueAssignment_0 ) ) | ( 'false' ) );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:831:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:831:1: ( ( rule__BooleanExpression__TrueAssignment_0 ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:832:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getTrueAssignment_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:833:1: ( rule__BooleanExpression__TrueAssignment_0 )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:833:2: rule__BooleanExpression__TrueAssignment_0
                    {
                    pushFollow(FOLLOW_rule__BooleanExpression__TrueAssignment_0_in_rule__BooleanExpression__Alternatives1735);
                    rule__BooleanExpression__TrueAssignment_0();
                    _fsp--;


                    }

                     after(grammarAccess.getBooleanExpressionAccess().getTrueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:837:6: ( 'false' )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:837:6: ( 'false' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:838:1: 'false'
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getFalseKeyword_1()); 
                    match(input,11,FOLLOW_11_in_rule__BooleanExpression__Alternatives1754); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:850:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );
    public final void rule__Operator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:854:1: ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) )
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
                    new NoViableAltException("850:1: rule__Operator__Alternatives : ( ( ( '<' ) ) | ( ( '>' ) ) | ( ( '<=' ) ) | ( ( '>=' ) ) | ( ( '=' ) ) | ( ( '!=' ) ) | ( ( 'like' ) ) | ( ( 'not like' ) ) | ( ( 'not in' ) ) | ( ( 'in' ) ) );", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:855:1: ( ( '<' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:855:1: ( ( '<' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:856:1: ( '<' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:857:1: ( '<' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:857:3: '<'
                    {
                    match(input,12,FOLLOW_12_in_rule__Operator__Alternatives1789); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:862:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:862:6: ( ( '>' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:863:1: ( '>' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:864:1: ( '>' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:864:3: '>'
                    {
                    match(input,13,FOLLOW_13_in_rule__Operator__Alternatives1810); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:869:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:869:6: ( ( '<=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:870:1: ( '<=' )
                    {
                     before(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:871:1: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:871:3: '<='
                    {
                    match(input,14,FOLLOW_14_in_rule__Operator__Alternatives1831); 

                    }

                     after(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:876:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:876:6: ( ( '>=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:877:1: ( '>=' )
                    {
                     before(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:878:1: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:878:3: '>='
                    {
                    match(input,15,FOLLOW_15_in_rule__Operator__Alternatives1852); 

                    }

                     after(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:883:6: ( ( '=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:883:6: ( ( '=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:884:1: ( '=' )
                    {
                     before(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:885:1: ( '=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:885:3: '='
                    {
                    match(input,16,FOLLOW_16_in_rule__Operator__Alternatives1873); 

                    }

                     after(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:890:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:890:6: ( ( '!=' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:891:1: ( '!=' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:892:1: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:892:3: '!='
                    {
                    match(input,17,FOLLOW_17_in_rule__Operator__Alternatives1894); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:897:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:897:6: ( ( 'like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:898:1: ( 'like' )
                    {
                     before(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:899:1: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:899:3: 'like'
                    {
                    match(input,18,FOLLOW_18_in_rule__Operator__Alternatives1915); 

                    }

                     after(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:904:6: ( ( 'not like' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:904:6: ( ( 'not like' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:905:1: ( 'not like' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:906:1: ( 'not like' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:906:3: 'not like'
                    {
                    match(input,19,FOLLOW_19_in_rule__Operator__Alternatives1936); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:911:6: ( ( 'not in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:911:6: ( ( 'not in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:912:1: ( 'not in' )
                    {
                     before(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:913:1: ( 'not in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:913:3: 'not in'
                    {
                    match(input,20,FOLLOW_20_in_rule__Operator__Alternatives1957); 

                    }

                     after(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:918:6: ( ( 'in' ) )
                    {
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:918:6: ( ( 'in' ) )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:919:1: ( 'in' )
                    {
                     before(grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9()); 
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:920:1: ( 'in' )
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:920:3: 'in'
                    {
                    match(input,21,FOLLOW_21_in_rule__Operator__Alternatives1978); 

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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:932:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:936:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:937:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02011);
            rule__Model__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02014);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:944:1: rule__Model__Group__0__Impl : ( ( rule__Model__ImportsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:948:1: ( ( ( rule__Model__ImportsAssignment_0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:949:1: ( ( rule__Model__ImportsAssignment_0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:949:1: ( ( rule__Model__ImportsAssignment_0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:950:1: ( rule__Model__ImportsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:951:1: ( rule__Model__ImportsAssignment_0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:951:2: rule__Model__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl2041);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:961:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:965:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:966:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12072);
            rule__Model__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12075);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:973:1: rule__Model__Group__1__Impl : ( ( rule__Model__DefaultQueryAssignment_1 )? ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:977:1: ( ( ( rule__Model__DefaultQueryAssignment_1 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:978:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:978:1: ( ( rule__Model__DefaultQueryAssignment_1 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:979:1: ( rule__Model__DefaultQueryAssignment_1 )?
            {
             before(grammarAccess.getModelAccess().getDefaultQueryAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:980:1: ( rule__Model__DefaultQueryAssignment_1 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:980:2: rule__Model__DefaultQueryAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__1__Impl2102);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:990:1: rule__Model__Group__2 : rule__Model__Group__2__Impl ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:994:1: ( rule__Model__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:995:2: rule__Model__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22133);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1001:1: rule__Model__Group__2__Impl : ( ( rule__Model__NamedQueriesAssignment_2 )* ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1005:1: ( ( ( rule__Model__NamedQueriesAssignment_2 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1006:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1006:1: ( ( rule__Model__NamedQueriesAssignment_2 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1007:1: ( rule__Model__NamedQueriesAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getNamedQueriesAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1008:1: ( rule__Model__NamedQueriesAssignment_2 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1008:2: rule__Model__NamedQueriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__2__Impl2160);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1024:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1028:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1029:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02197);
            rule__Import__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02200);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1036:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1040:1: ( ( 'import' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1041:1: ( 'import' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1041:1: ( 'import' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1042:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__0__Impl2228); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1055:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1059:1: ( rule__Import__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1060:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12259);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1066:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImpURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1070:1: ( ( ( rule__Import__ImpURIAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1071:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1071:1: ( ( rule__Import__ImpURIAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1072:1: ( rule__Import__ImpURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImpURIAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1073:1: ( rule__Import__ImpURIAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1073:2: rule__Import__ImpURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__1__Impl2286);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1087:1: rule__NamedQuery__Group__0 : rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1 ;
    public final void rule__NamedQuery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1091:1: ( rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1092:2: rule__NamedQuery__Group__0__Impl rule__NamedQuery__Group__1
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__0__Impl_in_rule__NamedQuery__Group__02320);
            rule__NamedQuery__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02323);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1099:1: rule__NamedQuery__Group__0__Impl : ( ( rule__NamedQuery__NameAssignment_0 ) ) ;
    public final void rule__NamedQuery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1103:1: ( ( ( rule__NamedQuery__NameAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1104:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1104:1: ( ( rule__NamedQuery__NameAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1105:1: ( rule__NamedQuery__NameAssignment_0 )
            {
             before(grammarAccess.getNamedQueryAccess().getNameAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1106:1: ( rule__NamedQuery__NameAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1106:2: rule__NamedQuery__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__0__Impl2350);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1116:1: rule__NamedQuery__Group__1 : rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2 ;
    public final void rule__NamedQuery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1120:1: ( rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1121:2: rule__NamedQuery__Group__1__Impl rule__NamedQuery__Group__2
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__1__Impl_in_rule__NamedQuery__Group__12380);
            rule__NamedQuery__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12383);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1128:1: rule__NamedQuery__Group__1__Impl : ( ':' ) ;
    public final void rule__NamedQuery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1132:1: ( ( ':' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1133:1: ( ':' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1133:1: ( ':' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1134:1: ':'
            {
             before(grammarAccess.getNamedQueryAccess().getColonKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__NamedQuery__Group__1__Impl2411); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1147:1: rule__NamedQuery__Group__2 : rule__NamedQuery__Group__2__Impl ;
    public final void rule__NamedQuery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1151:1: ( rule__NamedQuery__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1152:2: rule__NamedQuery__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedQuery__Group__2__Impl_in_rule__NamedQuery__Group__22442);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1158:1: rule__NamedQuery__Group__2__Impl : ( ( rule__NamedQuery__QueryAssignment_2 ) ) ;
    public final void rule__NamedQuery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1162:1: ( ( ( rule__NamedQuery__QueryAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1163:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1163:1: ( ( rule__NamedQuery__QueryAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1164:1: ( rule__NamedQuery__QueryAssignment_2 )
            {
             before(grammarAccess.getNamedQueryAccess().getQueryAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1165:1: ( rule__NamedQuery__QueryAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1165:2: rule__NamedQuery__QueryAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__2__Impl2469);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1181:1: rule__MQLquery__Group__0 : rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 ;
    public final void rule__MQLquery__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1185:1: ( rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1186:2: rule__MQLquery__Group__0__Impl rule__MQLquery__Group__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02505);
            rule__MQLquery__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02508);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1193:1: rule__MQLquery__Group__0__Impl : ( 'from' ) ;
    public final void rule__MQLquery__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1197:1: ( ( 'from' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1198:1: ( 'from' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1198:1: ( 'from' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1199:1: 'from'
            {
             before(grammarAccess.getMQLqueryAccess().getFromKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__MQLquery__Group__0__Impl2536); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1212:1: rule__MQLquery__Group__1 : rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 ;
    public final void rule__MQLquery__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1216:1: ( rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1217:2: rule__MQLquery__Group__1__Impl rule__MQLquery__Group__2
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12567);
            rule__MQLquery__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12570);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1224:1: rule__MQLquery__Group__1__Impl : ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) ;
    public final void rule__MQLquery__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1228:1: ( ( ( rule__MQLquery__FromEntriesAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1229:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1229:1: ( ( rule__MQLquery__FromEntriesAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1230:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1231:1: ( rule__MQLquery__FromEntriesAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1231:2: rule__MQLquery__FromEntriesAssignment_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2597);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1241:1: rule__MQLquery__Group__2 : rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 ;
    public final void rule__MQLquery__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1245:1: ( rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1246:2: rule__MQLquery__Group__2__Impl rule__MQLquery__Group__3
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22627);
            rule__MQLquery__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22630);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1253:1: rule__MQLquery__Group__2__Impl : ( ( rule__MQLquery__Group_2__0 )* ) ;
    public final void rule__MQLquery__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1257:1: ( ( ( rule__MQLquery__Group_2__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__MQLquery__Group_2__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1258:1: ( ( rule__MQLquery__Group_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1259:1: ( rule__MQLquery__Group_2__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1260:1: ( rule__MQLquery__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1260:2: rule__MQLquery__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2657);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1270:1: rule__MQLquery__Group__3 : rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 ;
    public final void rule__MQLquery__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1274:1: ( rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1275:2: rule__MQLquery__Group__3__Impl rule__MQLquery__Group__4
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32688);
            rule__MQLquery__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32691);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1282:1: rule__MQLquery__Group__3__Impl : ( 'select' ) ;
    public final void rule__MQLquery__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1286:1: ( ( 'select' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1287:1: ( 'select' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1287:1: ( 'select' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1288:1: 'select'
            {
             before(grammarAccess.getMQLqueryAccess().getSelectKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__MQLquery__Group__3__Impl2719); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1301:1: rule__MQLquery__Group__4 : rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 ;
    public final void rule__MQLquery__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1305:1: ( rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1306:2: rule__MQLquery__Group__4__Impl rule__MQLquery__Group__5
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42750);
            rule__MQLquery__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42753);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1313:1: rule__MQLquery__Group__4__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) ;
    public final void rule__MQLquery__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1317:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1318:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1318:1: ( ( rule__MQLquery__SelectEntriesAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1319:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1320:1: ( rule__MQLquery__SelectEntriesAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1320:2: rule__MQLquery__SelectEntriesAssignment_4
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2780);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1330:1: rule__MQLquery__Group__5 : rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 ;
    public final void rule__MQLquery__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1334:1: ( rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1335:2: rule__MQLquery__Group__5__Impl rule__MQLquery__Group__6
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52810);
            rule__MQLquery__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52813);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1342:1: rule__MQLquery__Group__5__Impl : ( ( rule__MQLquery__Group_5__0 )* ) ;
    public final void rule__MQLquery__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1346:1: ( ( ( rule__MQLquery__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1347:1: ( ( rule__MQLquery__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1347:1: ( ( rule__MQLquery__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1348:1: ( rule__MQLquery__Group_5__0 )*
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1349:1: ( rule__MQLquery__Group_5__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1349:2: rule__MQLquery__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2840);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1359:1: rule__MQLquery__Group__6 : rule__MQLquery__Group__6__Impl ;
    public final void rule__MQLquery__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1363:1: ( rule__MQLquery__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1364:2: rule__MQLquery__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62871);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1370:1: rule__MQLquery__Group__6__Impl : ( ( rule__MQLquery__Group_6__0 )? ) ;
    public final void rule__MQLquery__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1374:1: ( ( ( rule__MQLquery__Group_6__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1375:1: ( ( rule__MQLquery__Group_6__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1375:1: ( ( rule__MQLquery__Group_6__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1376:1: ( rule__MQLquery__Group_6__0 )?
            {
             before(grammarAccess.getMQLqueryAccess().getGroup_6()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1377:1: ( rule__MQLquery__Group_6__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1377:2: rule__MQLquery__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2898);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1401:1: rule__MQLquery__Group_2__0 : rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 ;
    public final void rule__MQLquery__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1405:1: ( rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1406:2: rule__MQLquery__Group_2__0__Impl rule__MQLquery__Group_2__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02943);
            rule__MQLquery__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02946);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1413:1: rule__MQLquery__Group_2__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1417:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1418:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1418:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1419:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_2__0__Impl2974); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1432:1: rule__MQLquery__Group_2__1 : rule__MQLquery__Group_2__1__Impl ;
    public final void rule__MQLquery__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1436:1: ( rule__MQLquery__Group_2__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1437:2: rule__MQLquery__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__13005);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1443:1: rule__MQLquery__Group_2__1__Impl : ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) ;
    public final void rule__MQLquery__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1447:1: ( ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1448:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1448:1: ( ( rule__MQLquery__FromEntriesAssignment_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1449:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesAssignment_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1450:1: ( rule__MQLquery__FromEntriesAssignment_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1450:2: rule__MQLquery__FromEntriesAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl3032);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1464:1: rule__MQLquery__Group_5__0 : rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 ;
    public final void rule__MQLquery__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1468:1: ( rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1469:2: rule__MQLquery__Group_5__0__Impl rule__MQLquery__Group_5__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__03066);
            rule__MQLquery__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03069);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1476:1: rule__MQLquery__Group_5__0__Impl : ( ',' ) ;
    public final void rule__MQLquery__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1480:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1481:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1481:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1482:1: ','
            {
             before(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__MQLquery__Group_5__0__Impl3097); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1495:1: rule__MQLquery__Group_5__1 : rule__MQLquery__Group_5__1__Impl ;
    public final void rule__MQLquery__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1499:1: ( rule__MQLquery__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1500:2: rule__MQLquery__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13128);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1506:1: rule__MQLquery__Group_5__1__Impl : ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) ;
    public final void rule__MQLquery__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1510:1: ( ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1511:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1511:1: ( ( rule__MQLquery__SelectEntriesAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1512:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1513:1: ( rule__MQLquery__SelectEntriesAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1513:2: rule__MQLquery__SelectEntriesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3155);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1527:1: rule__MQLquery__Group_6__0 : rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 ;
    public final void rule__MQLquery__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1531:1: ( rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1532:2: rule__MQLquery__Group_6__0__Impl rule__MQLquery__Group_6__1
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03189);
            rule__MQLquery__Group_6__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03192);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1539:1: rule__MQLquery__Group_6__0__Impl : ( 'where' ) ;
    public final void rule__MQLquery__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1543:1: ( ( 'where' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1544:1: ( 'where' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1544:1: ( 'where' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1545:1: 'where'
            {
             before(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0()); 
            match(input,27,FOLLOW_27_in_rule__MQLquery__Group_6__0__Impl3220); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1558:1: rule__MQLquery__Group_6__1 : rule__MQLquery__Group_6__1__Impl ;
    public final void rule__MQLquery__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1562:1: ( rule__MQLquery__Group_6__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1563:2: rule__MQLquery__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13251);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1569:1: rule__MQLquery__Group_6__1__Impl : ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) ;
    public final void rule__MQLquery__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1573:1: ( ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1574:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1574:1: ( ( rule__MQLquery__WhereEntryAssignment_6_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1575:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryAssignment_6_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1576:1: ( rule__MQLquery__WhereEntryAssignment_6_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1576:2: rule__MQLquery__WhereEntryAssignment_6_1
            {
            pushFollow(FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3278);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1590:1: rule__SelectEntry__Group__0 : rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 ;
    public final void rule__SelectEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1594:1: ( rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1595:2: rule__SelectEntry__Group__0__Impl rule__SelectEntry__Group__1
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03312);
            rule__SelectEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03315);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1602:1: rule__SelectEntry__Group__0__Impl : ( ( rule__SelectEntry__SelectAssignment_0 ) ) ;
    public final void rule__SelectEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1606:1: ( ( ( rule__SelectEntry__SelectAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1607:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1607:1: ( ( rule__SelectEntry__SelectAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1608:1: ( rule__SelectEntry__SelectAssignment_0 )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1609:1: ( rule__SelectEntry__SelectAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1609:2: rule__SelectEntry__SelectAssignment_0
            {
            pushFollow(FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3342);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1619:1: rule__SelectEntry__Group__1 : rule__SelectEntry__Group__1__Impl ;
    public final void rule__SelectEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1623:1: ( rule__SelectEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1624:2: rule__SelectEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13372);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1630:1: rule__SelectEntry__Group__1__Impl : ( ( rule__SelectEntry__Group_1__0 )? ) ;
    public final void rule__SelectEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1634:1: ( ( ( rule__SelectEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1635:1: ( ( rule__SelectEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1635:1: ( ( rule__SelectEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1636:1: ( rule__SelectEntry__Group_1__0 )?
            {
             before(grammarAccess.getSelectEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1637:1: ( rule__SelectEntry__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1637:2: rule__SelectEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3399);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1651:1: rule__SelectEntry__Group_1__0 : rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 ;
    public final void rule__SelectEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1655:1: ( rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1656:2: rule__SelectEntry__Group_1__0__Impl rule__SelectEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03434);
            rule__SelectEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03437);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1663:1: rule__SelectEntry__Group_1__0__Impl : ( '.' ) ;
    public final void rule__SelectEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1667:1: ( ( '.' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1668:1: ( '.' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1668:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1669:1: '.'
            {
             before(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__SelectEntry__Group_1__0__Impl3465); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1682:1: rule__SelectEntry__Group_1__1 : rule__SelectEntry__Group_1__1__Impl ;
    public final void rule__SelectEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1686:1: ( rule__SelectEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1687:2: rule__SelectEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13496);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1693:1: rule__SelectEntry__Group_1__1__Impl : ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) ;
    public final void rule__SelectEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1697:1: ( ( ( rule__SelectEntry__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1698:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1698:1: ( ( rule__SelectEntry__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1699:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1700:1: ( rule__SelectEntry__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1700:2: rule__SelectEntry__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3523);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1714:1: rule__FromEntry__Group__0 : rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 ;
    public final void rule__FromEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1718:1: ( rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1719:2: rule__FromEntry__Group__0__Impl rule__FromEntry__Group__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03557);
            rule__FromEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03560);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1726:1: rule__FromEntry__Group__0__Impl : ( ( rule__FromEntry__TypeAssignment_0 ) ) ;
    public final void rule__FromEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1730:1: ( ( ( rule__FromEntry__TypeAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1731:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1731:1: ( ( rule__FromEntry__TypeAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1732:1: ( rule__FromEntry__TypeAssignment_0 )
            {
             before(grammarAccess.getFromEntryAccess().getTypeAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1733:1: ( rule__FromEntry__TypeAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1733:2: rule__FromEntry__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3587);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1743:1: rule__FromEntry__Group__1 : rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 ;
    public final void rule__FromEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1747:1: ( rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1748:2: rule__FromEntry__Group__1__Impl rule__FromEntry__Group__2
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13617);
            rule__FromEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13620);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1755:1: rule__FromEntry__Group__1__Impl : ( ( rule__FromEntry__Group_1__0 )? ) ;
    public final void rule__FromEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1759:1: ( ( ( rule__FromEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1760:1: ( ( rule__FromEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1760:1: ( ( rule__FromEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1761:1: ( rule__FromEntry__Group_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1762:1: ( rule__FromEntry__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1762:2: rule__FromEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__1__Impl3647);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1772:1: rule__FromEntry__Group__2 : rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 ;
    public final void rule__FromEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1776:1: ( rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1777:2: rule__FromEntry__Group__2__Impl rule__FromEntry__Group__3
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23678);
            rule__FromEntry__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23681);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1784:1: rule__FromEntry__Group__2__Impl : ( 'as' ) ;
    public final void rule__FromEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1788:1: ( ( 'as' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1789:1: ( 'as' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1789:1: ( 'as' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1790:1: 'as'
            {
             before(grammarAccess.getFromEntryAccess().getAsKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__FromEntry__Group__2__Impl3709); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1803:1: rule__FromEntry__Group__3 : rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 ;
    public final void rule__FromEntry__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1807:1: ( rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1808:2: rule__FromEntry__Group__3__Impl rule__FromEntry__Group__4
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33740);
            rule__FromEntry__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33743);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1815:1: rule__FromEntry__Group__3__Impl : ( ( rule__FromEntry__AliasAssignment_3 ) ) ;
    public final void rule__FromEntry__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1819:1: ( ( ( rule__FromEntry__AliasAssignment_3 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1820:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1820:1: ( ( rule__FromEntry__AliasAssignment_3 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1821:1: ( rule__FromEntry__AliasAssignment_3 )
            {
             before(grammarAccess.getFromEntryAccess().getAliasAssignment_3()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1822:1: ( rule__FromEntry__AliasAssignment_3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1822:2: rule__FromEntry__AliasAssignment_3
            {
            pushFollow(FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3770);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1832:1: rule__FromEntry__Group__4 : rule__FromEntry__Group__4__Impl ;
    public final void rule__FromEntry__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1836:1: ( rule__FromEntry__Group__4__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1837:2: rule__FromEntry__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43800);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1843:1: rule__FromEntry__Group__4__Impl : ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) ;
    public final void rule__FromEntry__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1847:1: ( ( ( rule__FromEntry__ScopeClauseAssignment_4 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1848:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1848:1: ( ( rule__FromEntry__ScopeClauseAssignment_4 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1849:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1850:1: ( rule__FromEntry__ScopeClauseAssignment_4 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21||LA14_0==39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1850:2: rule__FromEntry__ScopeClauseAssignment_4
                    {
                    pushFollow(FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3827);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1870:1: rule__FromEntry__Group_1__0 : rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1 ;
    public final void rule__FromEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1874:1: ( rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1875:2: rule__FromEntry__Group_1__0__Impl rule__FromEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1__0__Impl_in_rule__FromEntry__Group_1__03868);
            rule__FromEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03871);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1882:1: rule__FromEntry__Group_1__0__Impl : ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) ;
    public final void rule__FromEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1886:1: ( ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1887:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1887:1: ( ( rule__FromEntry__WithoutsubtypesAssignment_1_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1888:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesAssignment_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1889:1: ( rule__FromEntry__WithoutsubtypesAssignment_1_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1889:2: rule__FromEntry__WithoutsubtypesAssignment_1_0
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__0__Impl3898);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1899:1: rule__FromEntry__Group_1__1 : rule__FromEntry__Group_1__1__Impl ;
    public final void rule__FromEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1903:1: ( rule__FromEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1904:2: rule__FromEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1__1__Impl_in_rule__FromEntry__Group_1__13928);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1910:1: rule__FromEntry__Group_1__1__Impl : ( ( rule__FromEntry__Group_1_1__0 )? ) ;
    public final void rule__FromEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1914:1: ( ( ( rule__FromEntry__Group_1_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1915:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1915:1: ( ( rule__FromEntry__Group_1_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1916:1: ( rule__FromEntry__Group_1_1__0 )?
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1917:1: ( rule__FromEntry__Group_1_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1917:2: rule__FromEntry__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__1__Impl3955);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1931:1: rule__FromEntry__Group_1_1__0 : rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1 ;
    public final void rule__FromEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1935:1: ( rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1936:2: rule__FromEntry__Group_1_1__0__Impl rule__FromEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__0__Impl_in_rule__FromEntry__Group_1_1__03990);
            rule__FromEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03993);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1943:1: rule__FromEntry__Group_1_1__0__Impl : ( '{' ) ;
    public final void rule__FromEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1947:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1948:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1948:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1949:1: '{'
            {
             before(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0()); 
            match(input,30,FOLLOW_30_in_rule__FromEntry__Group_1_1__0__Impl4021); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1962:1: rule__FromEntry__Group_1_1__1 : rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2 ;
    public final void rule__FromEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1966:1: ( rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1967:2: rule__FromEntry__Group_1_1__1__Impl rule__FromEntry__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__1__Impl_in_rule__FromEntry__Group_1_1__14052);
            rule__FromEntry__Group_1_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__14055);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1974:1: rule__FromEntry__Group_1_1__1__Impl : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) ;
    public final void rule__FromEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1978:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1979:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1979:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1980:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1981:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1981:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__1__Impl4082);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1991:1: rule__FromEntry__Group_1_1__2 : rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3 ;
    public final void rule__FromEntry__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1995:1: ( rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:1996:2: rule__FromEntry__Group_1_1__2__Impl rule__FromEntry__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__2__Impl_in_rule__FromEntry__Group_1_1__24112);
            rule__FromEntry__Group_1_1__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__24115);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2003:1: rule__FromEntry__Group_1_1__2__Impl : ( ( rule__FromEntry__Group_1_1_2__0 )* ) ;
    public final void rule__FromEntry__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2007:1: ( ( ( rule__FromEntry__Group_1_1_2__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2008:1: ( ( rule__FromEntry__Group_1_1_2__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2008:1: ( ( rule__FromEntry__Group_1_1_2__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2009:1: ( rule__FromEntry__Group_1_1_2__0 )*
            {
             before(grammarAccess.getFromEntryAccess().getGroup_1_1_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2010:1: ( rule__FromEntry__Group_1_1_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2010:2: rule__FromEntry__Group_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__2__Impl4142);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2020:1: rule__FromEntry__Group_1_1__3 : rule__FromEntry__Group_1_1__3__Impl ;
    public final void rule__FromEntry__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2024:1: ( rule__FromEntry__Group_1_1__3__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2025:2: rule__FromEntry__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1__3__Impl_in_rule__FromEntry__Group_1_1__34173);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2031:1: rule__FromEntry__Group_1_1__3__Impl : ( '}' ) ;
    public final void rule__FromEntry__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2035:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2036:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2036:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2037:1: '}'
            {
             before(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3()); 
            match(input,31,FOLLOW_31_in_rule__FromEntry__Group_1_1__3__Impl4201); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2058:1: rule__FromEntry__Group_1_1_2__0 : rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1 ;
    public final void rule__FromEntry__Group_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2062:1: ( rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2063:2: rule__FromEntry__Group_1_1_2__0__Impl rule__FromEntry__Group_1_1_2__1
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__0__Impl_in_rule__FromEntry__Group_1_1_2__04240);
            rule__FromEntry__Group_1_1_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__04243);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2070:1: rule__FromEntry__Group_1_1_2__0__Impl : ( ',' ) ;
    public final void rule__FromEntry__Group_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2074:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2075:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2075:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2076:1: ','
            {
             before(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0()); 
            match(input,26,FOLLOW_26_in_rule__FromEntry__Group_1_1_2__0__Impl4271); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2089:1: rule__FromEntry__Group_1_1_2__1 : rule__FromEntry__Group_1_1_2__1__Impl ;
    public final void rule__FromEntry__Group_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2093:1: ( rule__FromEntry__Group_1_1_2__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2094:2: rule__FromEntry__Group_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__FromEntry__Group_1_1_2__1__Impl_in_rule__FromEntry__Group_1_1_2__14302);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2100:1: rule__FromEntry__Group_1_1_2__1__Impl : ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) ;
    public final void rule__FromEntry__Group_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2104:1: ( ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2105:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2105:1: ( ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2106:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesAssignment_1_1_2_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2107:1: ( rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2107:2: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1
            {
            pushFollow(FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__1__Impl4329);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2121:1: rule__ResourceScope__Group__0 : rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 ;
    public final void rule__ResourceScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2125:1: ( rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2126:2: rule__ResourceScope__Group__0__Impl rule__ResourceScope__Group__1
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04363);
            rule__ResourceScope__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04366);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2133:1: rule__ResourceScope__Group__0__Impl : ( ( rule__ResourceScope__NotInAssignment_0 )? ) ;
    public final void rule__ResourceScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2137:1: ( ( ( rule__ResourceScope__NotInAssignment_0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2138:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2138:1: ( ( rule__ResourceScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2139:1: ( rule__ResourceScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getResourceScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2140:1: ( rule__ResourceScope__NotInAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2140:2: rule__ResourceScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__0__Impl4393);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2150:1: rule__ResourceScope__Group__1 : rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 ;
    public final void rule__ResourceScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2154:1: ( rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2155:2: rule__ResourceScope__Group__1__Impl rule__ResourceScope__Group__2
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14424);
            rule__ResourceScope__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14427);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2162:1: rule__ResourceScope__Group__1__Impl : ( 'in' ) ;
    public final void rule__ResourceScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2166:1: ( ( 'in' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2167:1: ( 'in' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2167:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2168:1: 'in'
            {
             before(grammarAccess.getResourceScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ResourceScope__Group__1__Impl4455); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2181:1: rule__ResourceScope__Group__2 : rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 ;
    public final void rule__ResourceScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2185:1: ( rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2186:2: rule__ResourceScope__Group__2__Impl rule__ResourceScope__Group__3
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24486);
            rule__ResourceScope__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24489);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2193:1: rule__ResourceScope__Group__2__Impl : ( 'resources' ) ;
    public final void rule__ResourceScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2197:1: ( ( 'resources' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2198:1: ( 'resources' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2198:1: ( 'resources' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2199:1: 'resources'
            {
             before(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ResourceScope__Group__2__Impl4517); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2212:1: rule__ResourceScope__Group__3 : rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 ;
    public final void rule__ResourceScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2216:1: ( rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2217:2: rule__ResourceScope__Group__3__Impl rule__ResourceScope__Group__4
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34548);
            rule__ResourceScope__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34551);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2224:1: rule__ResourceScope__Group__3__Impl : ( '{' ) ;
    public final void rule__ResourceScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2228:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2229:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2229:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2230:1: '{'
            {
             before(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ResourceScope__Group__3__Impl4579); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2243:1: rule__ResourceScope__Group__4 : rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5 ;
    public final void rule__ResourceScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2247:1: ( rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2248:2: rule__ResourceScope__Group__4__Impl rule__ResourceScope__Group__5
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44610);
            rule__ResourceScope__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__44613);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2255:1: rule__ResourceScope__Group__4__Impl : ( ( rule__ResourceScope__UrisAssignment_4 ) ) ;
    public final void rule__ResourceScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2259:1: ( ( ( rule__ResourceScope__UrisAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2260:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2260:1: ( ( rule__ResourceScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2261:1: ( rule__ResourceScope__UrisAssignment_4 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2262:1: ( rule__ResourceScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2262:2: rule__ResourceScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__4__Impl4640);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2272:1: rule__ResourceScope__Group__5 : rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6 ;
    public final void rule__ResourceScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2276:1: ( rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2277:2: rule__ResourceScope__Group__5__Impl rule__ResourceScope__Group__6
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__5__Impl_in_rule__ResourceScope__Group__54670);
            rule__ResourceScope__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__54673);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2284:1: rule__ResourceScope__Group__5__Impl : ( ( rule__ResourceScope__Group_5__0 )* ) ;
    public final void rule__ResourceScope__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2288:1: ( ( ( rule__ResourceScope__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2289:1: ( ( rule__ResourceScope__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2289:1: ( ( rule__ResourceScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2290:1: ( rule__ResourceScope__Group_5__0 )*
            {
             before(grammarAccess.getResourceScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2291:1: ( rule__ResourceScope__Group_5__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==26) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2291:2: rule__ResourceScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__5__Impl4700);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2301:1: rule__ResourceScope__Group__6 : rule__ResourceScope__Group__6__Impl ;
    public final void rule__ResourceScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2305:1: ( rule__ResourceScope__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2306:2: rule__ResourceScope__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group__6__Impl_in_rule__ResourceScope__Group__64731);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2312:1: rule__ResourceScope__Group__6__Impl : ( '}' ) ;
    public final void rule__ResourceScope__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2316:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2317:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2317:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2318:1: '}'
            {
             before(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ResourceScope__Group__6__Impl4759); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2345:1: rule__ResourceScope__Group_5__0 : rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1 ;
    public final void rule__ResourceScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2349:1: ( rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2350:2: rule__ResourceScope__Group_5__0__Impl rule__ResourceScope__Group_5__1
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group_5__0__Impl_in_rule__ResourceScope__Group_5__04804);
            rule__ResourceScope__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__04807);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2357:1: rule__ResourceScope__Group_5__0__Impl : ( ',' ) ;
    public final void rule__ResourceScope__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2361:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2362:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2362:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2363:1: ','
            {
             before(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ResourceScope__Group_5__0__Impl4835); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2376:1: rule__ResourceScope__Group_5__1 : rule__ResourceScope__Group_5__1__Impl ;
    public final void rule__ResourceScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2380:1: ( rule__ResourceScope__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2381:2: rule__ResourceScope__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ResourceScope__Group_5__1__Impl_in_rule__ResourceScope__Group_5__14866);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2387:1: rule__ResourceScope__Group_5__1__Impl : ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ResourceScope__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2391:1: ( ( ( rule__ResourceScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2392:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2392:1: ( ( rule__ResourceScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2393:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getResourceScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2394:1: ( rule__ResourceScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2394:2: rule__ResourceScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__1__Impl4893);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2408:1: rule__ElementScope__Group__0 : rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 ;
    public final void rule__ElementScope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2412:1: ( rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2413:2: rule__ElementScope__Group__0__Impl rule__ElementScope__Group__1
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04927);
            rule__ElementScope__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04930);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2420:1: rule__ElementScope__Group__0__Impl : ( ( rule__ElementScope__NotInAssignment_0 )? ) ;
    public final void rule__ElementScope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2424:1: ( ( ( rule__ElementScope__NotInAssignment_0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2425:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2425:1: ( ( rule__ElementScope__NotInAssignment_0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2426:1: ( rule__ElementScope__NotInAssignment_0 )?
            {
             before(grammarAccess.getElementScopeAccess().getNotInAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2427:1: ( rule__ElementScope__NotInAssignment_0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2427:2: rule__ElementScope__NotInAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__0__Impl4957);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2437:1: rule__ElementScope__Group__1 : rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 ;
    public final void rule__ElementScope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2441:1: ( rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2442:2: rule__ElementScope__Group__1__Impl rule__ElementScope__Group__2
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14988);
            rule__ElementScope__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14991);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2449:1: rule__ElementScope__Group__1__Impl : ( 'in' ) ;
    public final void rule__ElementScope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2453:1: ( ( 'in' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2454:1: ( 'in' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2454:1: ( 'in' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2455:1: 'in'
            {
             before(grammarAccess.getElementScopeAccess().getInKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ElementScope__Group__1__Impl5019); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2468:1: rule__ElementScope__Group__2 : rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 ;
    public final void rule__ElementScope__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2472:1: ( rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2473:2: rule__ElementScope__Group__2__Impl rule__ElementScope__Group__3
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__25050);
            rule__ElementScope__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__25053);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2480:1: rule__ElementScope__Group__2__Impl : ( 'elements' ) ;
    public final void rule__ElementScope__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2484:1: ( ( 'elements' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2485:1: ( 'elements' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2485:1: ( 'elements' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2486:1: 'elements'
            {
             before(grammarAccess.getElementScopeAccess().getElementsKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__ElementScope__Group__2__Impl5081); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2499:1: rule__ElementScope__Group__3 : rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 ;
    public final void rule__ElementScope__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2503:1: ( rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2504:2: rule__ElementScope__Group__3__Impl rule__ElementScope__Group__4
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__35112);
            rule__ElementScope__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__35115);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2511:1: rule__ElementScope__Group__3__Impl : ( '{' ) ;
    public final void rule__ElementScope__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2515:1: ( ( '{' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2516:1: ( '{' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2516:1: ( '{' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2517:1: '{'
            {
             before(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,30,FOLLOW_30_in_rule__ElementScope__Group__3__Impl5143); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2530:1: rule__ElementScope__Group__4 : rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5 ;
    public final void rule__ElementScope__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2534:1: ( rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2535:2: rule__ElementScope__Group__4__Impl rule__ElementScope__Group__5
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__45174);
            rule__ElementScope__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__45177);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2542:1: rule__ElementScope__Group__4__Impl : ( ( rule__ElementScope__UrisAssignment_4 ) ) ;
    public final void rule__ElementScope__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2546:1: ( ( ( rule__ElementScope__UrisAssignment_4 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2547:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2547:1: ( ( rule__ElementScope__UrisAssignment_4 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2548:1: ( rule__ElementScope__UrisAssignment_4 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_4()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2549:1: ( rule__ElementScope__UrisAssignment_4 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2549:2: rule__ElementScope__UrisAssignment_4
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__4__Impl5204);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2559:1: rule__ElementScope__Group__5 : rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6 ;
    public final void rule__ElementScope__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2563:1: ( rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2564:2: rule__ElementScope__Group__5__Impl rule__ElementScope__Group__6
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__5__Impl_in_rule__ElementScope__Group__55234);
            rule__ElementScope__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__55237);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2571:1: rule__ElementScope__Group__5__Impl : ( ( rule__ElementScope__Group_5__0 )* ) ;
    public final void rule__ElementScope__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2575:1: ( ( ( rule__ElementScope__Group_5__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2576:1: ( ( rule__ElementScope__Group_5__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2576:1: ( ( rule__ElementScope__Group_5__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2577:1: ( rule__ElementScope__Group_5__0 )*
            {
             before(grammarAccess.getElementScopeAccess().getGroup_5()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2578:1: ( rule__ElementScope__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2578:2: rule__ElementScope__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__5__Impl5264);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2588:1: rule__ElementScope__Group__6 : rule__ElementScope__Group__6__Impl ;
    public final void rule__ElementScope__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2592:1: ( rule__ElementScope__Group__6__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2593:2: rule__ElementScope__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ElementScope__Group__6__Impl_in_rule__ElementScope__Group__65295);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2599:1: rule__ElementScope__Group__6__Impl : ( '}' ) ;
    public final void rule__ElementScope__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2603:1: ( ( '}' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2604:1: ( '}' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2604:1: ( '}' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2605:1: '}'
            {
             before(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6()); 
            match(input,31,FOLLOW_31_in_rule__ElementScope__Group__6__Impl5323); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2632:1: rule__ElementScope__Group_5__0 : rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1 ;
    public final void rule__ElementScope__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2636:1: ( rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2637:2: rule__ElementScope__Group_5__0__Impl rule__ElementScope__Group_5__1
            {
            pushFollow(FOLLOW_rule__ElementScope__Group_5__0__Impl_in_rule__ElementScope__Group_5__05368);
            rule__ElementScope__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__05371);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2644:1: rule__ElementScope__Group_5__0__Impl : ( ',' ) ;
    public final void rule__ElementScope__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2648:1: ( ( ',' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2649:1: ( ',' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2649:1: ( ',' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2650:1: ','
            {
             before(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_26_in_rule__ElementScope__Group_5__0__Impl5399); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2663:1: rule__ElementScope__Group_5__1 : rule__ElementScope__Group_5__1__Impl ;
    public final void rule__ElementScope__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2667:1: ( rule__ElementScope__Group_5__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2668:2: rule__ElementScope__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__ElementScope__Group_5__1__Impl_in_rule__ElementScope__Group_5__15430);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2674:1: rule__ElementScope__Group_5__1__Impl : ( ( rule__ElementScope__UrisAssignment_5_1 ) ) ;
    public final void rule__ElementScope__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2678:1: ( ( ( rule__ElementScope__UrisAssignment_5_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2679:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2679:1: ( ( rule__ElementScope__UrisAssignment_5_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2680:1: ( rule__ElementScope__UrisAssignment_5_1 )
            {
             before(grammarAccess.getElementScopeAccess().getUrisAssignment_5_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2681:1: ( rule__ElementScope__UrisAssignment_5_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2681:2: rule__ElementScope__UrisAssignment_5_1
            {
            pushFollow(FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__1__Impl5457);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2695:1: rule__WhereEntry__Group__0 : rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 ;
    public final void rule__WhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2699:1: ( rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2700:2: rule__WhereEntry__Group__0__Impl rule__WhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__05491);
            rule__WhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__05494);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2707:1: rule__WhereEntry__Group__0__Impl : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2711:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2712:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2712:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2713:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl5521);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2724:1: rule__WhereEntry__Group__1 : rule__WhereEntry__Group__1__Impl ;
    public final void rule__WhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2728:1: ( rule__WhereEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2729:2: rule__WhereEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15550);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2735:1: rule__WhereEntry__Group__1__Impl : ( ( rule__WhereEntry__Group_1__0 )? ) ;
    public final void rule__WhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2739:1: ( ( ( rule__WhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2740:1: ( ( rule__WhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2740:1: ( ( rule__WhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2741:1: ( rule__WhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2742:1: ( rule__WhereEntry__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==34) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2742:2: rule__WhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5577);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2756:1: rule__WhereEntry__Group_1__0 : rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 ;
    public final void rule__WhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2760:1: ( rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2761:2: rule__WhereEntry__Group_1__0__Impl rule__WhereEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05612);
            rule__WhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05615);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2768:1: rule__WhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__WhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2772:1: ( ( () ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2773:1: ( () )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2773:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2774:1: ()
            {
             before(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2775:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2777:1: 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2787:1: rule__WhereEntry__Group_1__1 : rule__WhereEntry__Group_1__1__Impl ;
    public final void rule__WhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2791:1: ( rule__WhereEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2792:2: rule__WhereEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15673);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2798:1: rule__WhereEntry__Group_1__1__Impl : ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__WhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2802:1: ( ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2803:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2803:1: ( ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2804:1: ( ( rule__WhereEntry__Group_1_1__0 ) ) ( ( rule__WhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2804:1: ( ( rule__WhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2805:1: ( rule__WhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2806:1: ( rule__WhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2806:2: rule__WhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5702);
            rule__WhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2809:1: ( ( rule__WhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2810:1: ( rule__WhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2811:1: ( rule__WhereEntry__Group_1_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2811:2: rule__WhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5714);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2826:1: rule__WhereEntry__Group_1_1__0 : rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 ;
    public final void rule__WhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2830:1: ( rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2831:2: rule__WhereEntry__Group_1_1__0__Impl rule__WhereEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05751);
            rule__WhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05754);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2838:1: rule__WhereEntry__Group_1_1__0__Impl : ( 'or' ) ;
    public final void rule__WhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2842:1: ( ( 'or' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2843:1: ( 'or' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2843:1: ( 'or' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2844:1: 'or'
            {
             before(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0()); 
            match(input,34,FOLLOW_34_in_rule__WhereEntry__Group_1_1__0__Impl5782); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2857:1: rule__WhereEntry__Group_1_1__1 : rule__WhereEntry__Group_1_1__1__Impl ;
    public final void rule__WhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2861:1: ( rule__WhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2862:2: rule__WhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15813);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2868:1: rule__WhereEntry__Group_1_1__1__Impl : ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__WhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2872:1: ( ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2873:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2873:1: ( ( rule__WhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2874:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2875:1: ( rule__WhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2875:2: rule__WhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5840);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2889:1: rule__AndWhereEntry__Group__0 : rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 ;
    public final void rule__AndWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2893:1: ( rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2894:2: rule__AndWhereEntry__Group__0__Impl rule__AndWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05874);
            rule__AndWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05877);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2901:1: rule__AndWhereEntry__Group__0__Impl : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2905:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2906:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2906:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2907:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5904);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2918:1: rule__AndWhereEntry__Group__1 : rule__AndWhereEntry__Group__1__Impl ;
    public final void rule__AndWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2922:1: ( rule__AndWhereEntry__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2923:2: rule__AndWhereEntry__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15933);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2929:1: rule__AndWhereEntry__Group__1__Impl : ( ( rule__AndWhereEntry__Group_1__0 )? ) ;
    public final void rule__AndWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2933:1: ( ( ( rule__AndWhereEntry__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2934:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2934:1: ( ( rule__AndWhereEntry__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2935:1: ( rule__AndWhereEntry__Group_1__0 )?
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2936:1: ( rule__AndWhereEntry__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2936:2: rule__AndWhereEntry__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5960);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2950:1: rule__AndWhereEntry__Group_1__0 : rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 ;
    public final void rule__AndWhereEntry__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2954:1: ( rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2955:2: rule__AndWhereEntry__Group_1__0__Impl rule__AndWhereEntry__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05995);
            rule__AndWhereEntry__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05998);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2962:1: rule__AndWhereEntry__Group_1__0__Impl : ( () ) ;
    public final void rule__AndWhereEntry__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2966:1: ( ( () ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2967:1: ( () )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2967:1: ( () )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2968:1: ()
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2969:1: ()
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2971:1: 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2981:1: rule__AndWhereEntry__Group_1__1 : rule__AndWhereEntry__Group_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2985:1: ( rule__AndWhereEntry__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2986:2: rule__AndWhereEntry__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__16056);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2992:1: rule__AndWhereEntry__Group_1__1__Impl : ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) ;
    public final void rule__AndWhereEntry__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2996:1: ( ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2997:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2997:1: ( ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2998:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) ) ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2998:1: ( ( rule__AndWhereEntry__Group_1_1__0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:2999:1: ( rule__AndWhereEntry__Group_1_1__0 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3000:1: ( rule__AndWhereEntry__Group_1_1__0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3000:2: rule__AndWhereEntry__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6085);
            rule__AndWhereEntry__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3003:1: ( ( rule__AndWhereEntry__Group_1_1__0 )* )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3004:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            {
             before(grammarAccess.getAndWhereEntryAccess().getGroup_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3005:1: ( rule__AndWhereEntry__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3005:2: rule__AndWhereEntry__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6097);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3020:1: rule__AndWhereEntry__Group_1_1__0 : rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 ;
    public final void rule__AndWhereEntry__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3024:1: ( rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3025:2: rule__AndWhereEntry__Group_1_1__0__Impl rule__AndWhereEntry__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__06134);
            rule__AndWhereEntry__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__06137);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3032:1: rule__AndWhereEntry__Group_1_1__0__Impl : ( 'and' ) ;
    public final void rule__AndWhereEntry__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3036:1: ( ( 'and' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3037:1: ( 'and' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3037:1: ( 'and' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3038:1: 'and'
            {
             before(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0()); 
            match(input,35,FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__0__Impl6165); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3051:1: rule__AndWhereEntry__Group_1_1__1 : rule__AndWhereEntry__Group_1_1__1__Impl ;
    public final void rule__AndWhereEntry__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3055:1: ( rule__AndWhereEntry__Group_1_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3056:2: rule__AndWhereEntry__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__16196);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3062:1: rule__AndWhereEntry__Group_1_1__1__Impl : ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) ;
    public final void rule__AndWhereEntry__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3066:1: ( ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3067:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3067:1: ( ( rule__AndWhereEntry__EntriesAssignment_1_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3068:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesAssignment_1_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3069:1: ( rule__AndWhereEntry__EntriesAssignment_1_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3069:2: rule__AndWhereEntry__EntriesAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl6223);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3083:1: rule__ParWhereEntry__Group__0 : rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 ;
    public final void rule__ParWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3087:1: ( rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3088:2: rule__ParWhereEntry__Group__0__Impl rule__ParWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__06257);
            rule__ParWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__06260);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3095:1: rule__ParWhereEntry__Group__0__Impl : ( '(' ) ;
    public final void rule__ParWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3099:1: ( ( '(' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3100:1: ( '(' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3100:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3101:1: '('
            {
             before(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ParWhereEntry__Group__0__Impl6288); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3114:1: rule__ParWhereEntry__Group__1 : rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 ;
    public final void rule__ParWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3118:1: ( rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3119:2: rule__ParWhereEntry__Group__1__Impl rule__ParWhereEntry__Group__2
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__16319);
            rule__ParWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__16322);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3126:1: rule__ParWhereEntry__Group__1__Impl : ( ruleWhereEntry ) ;
    public final void rule__ParWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3130:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3131:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3131:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3132:1: ruleWhereEntry
            {
             before(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl6349);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3143:1: rule__ParWhereEntry__Group__2 : rule__ParWhereEntry__Group__2__Impl ;
    public final void rule__ParWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3147:1: ( rule__ParWhereEntry__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3148:2: rule__ParWhereEntry__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__26378);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3154:1: rule__ParWhereEntry__Group__2__Impl : ( ')' ) ;
    public final void rule__ParWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3158:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3159:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3159:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3160:1: ')'
            {
             before(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__ParWhereEntry__Group__2__Impl6406); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3179:1: rule__ExpressionWhereEntry__Group__0 : rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1 ;
    public final void rule__ExpressionWhereEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3183:1: ( rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3184:2: rule__ExpressionWhereEntry__Group__0__Impl rule__ExpressionWhereEntry__Group__1
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__0__Impl_in_rule__ExpressionWhereEntry__Group__06443);
            rule__ExpressionWhereEntry__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__06446);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3191:1: rule__ExpressionWhereEntry__Group__0__Impl : ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3195:1: ( ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3196:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3196:1: ( ( rule__ExpressionWhereEntry__LhsAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3197:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3198:1: ( rule__ExpressionWhereEntry__LhsAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3198:2: rule__ExpressionWhereEntry__LhsAssignment_0
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__0__Impl6473);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3208:1: rule__ExpressionWhereEntry__Group__1 : rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2 ;
    public final void rule__ExpressionWhereEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3212:1: ( rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3213:2: rule__ExpressionWhereEntry__Group__1__Impl rule__ExpressionWhereEntry__Group__2
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__1__Impl_in_rule__ExpressionWhereEntry__Group__16503);
            rule__ExpressionWhereEntry__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__16506);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3220:1: rule__ExpressionWhereEntry__Group__1__Impl : ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3224:1: ( ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3225:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3225:1: ( ( rule__ExpressionWhereEntry__OperatorAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3226:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3227:1: ( rule__ExpressionWhereEntry__OperatorAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3227:2: rule__ExpressionWhereEntry__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__1__Impl6533);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3237:1: rule__ExpressionWhereEntry__Group__2 : rule__ExpressionWhereEntry__Group__2__Impl ;
    public final void rule__ExpressionWhereEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3241:1: ( rule__ExpressionWhereEntry__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3242:2: rule__ExpressionWhereEntry__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__Group__2__Impl_in_rule__ExpressionWhereEntry__Group__26563);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3248:1: rule__ExpressionWhereEntry__Group__2__Impl : ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) ;
    public final void rule__ExpressionWhereEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3252:1: ( ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3253:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3253:1: ( ( rule__ExpressionWhereEntry__RhsAssignment_2 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3254:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsAssignment_2()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3255:1: ( rule__ExpressionWhereEntry__RhsAssignment_2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3255:2: rule__ExpressionWhereEntry__RhsAssignment_2
            {
            pushFollow(FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__2__Impl6590);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3271:1: rule__AliasAttributeExpression__Group__0 : rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1 ;
    public final void rule__AliasAttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3275:1: ( rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3276:2: rule__AliasAttributeExpression__Group__0__Impl rule__AliasAttributeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__0__Impl_in_rule__AliasAttributeExpression__Group__06626);
            rule__AliasAttributeExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__06629);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3283:1: rule__AliasAttributeExpression__Group__0__Impl : ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) ;
    public final void rule__AliasAttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3287:1: ( ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3288:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3288:1: ( ( rule__AliasAttributeExpression__AliasAssignment_0 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3289:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasAssignment_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3290:1: ( rule__AliasAttributeExpression__AliasAssignment_0 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3290:2: rule__AliasAttributeExpression__AliasAssignment_0
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__0__Impl6656);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3300:1: rule__AliasAttributeExpression__Group__1 : rule__AliasAttributeExpression__Group__1__Impl ;
    public final void rule__AliasAttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3304:1: ( rule__AliasAttributeExpression__Group__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3305:2: rule__AliasAttributeExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group__1__Impl_in_rule__AliasAttributeExpression__Group__16686);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3311:1: rule__AliasAttributeExpression__Group__1__Impl : ( ( rule__AliasAttributeExpression__Group_1__0 )? ) ;
    public final void rule__AliasAttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3315:1: ( ( ( rule__AliasAttributeExpression__Group_1__0 )? ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3316:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3316:1: ( ( rule__AliasAttributeExpression__Group_1__0 )? )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3317:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getGroup_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3318:1: ( rule__AliasAttributeExpression__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3318:2: rule__AliasAttributeExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__1__Impl6713);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3332:1: rule__AliasAttributeExpression__Group_1__0 : rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1 ;
    public final void rule__AliasAttributeExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3336:1: ( rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3337:2: rule__AliasAttributeExpression__Group_1__0__Impl rule__AliasAttributeExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__0__Impl_in_rule__AliasAttributeExpression__Group_1__06748);
            rule__AliasAttributeExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__06751);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3344:1: rule__AliasAttributeExpression__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AliasAttributeExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3348:1: ( ( '.' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3349:1: ( '.' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3349:1: ( '.' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3350:1: '.'
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0()); 
            match(input,28,FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__0__Impl6779); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3363:1: rule__AliasAttributeExpression__Group_1__1 : rule__AliasAttributeExpression__Group_1__1__Impl ;
    public final void rule__AliasAttributeExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3367:1: ( rule__AliasAttributeExpression__Group_1__1__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3368:2: rule__AliasAttributeExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__Group_1__1__Impl_in_rule__AliasAttributeExpression__Group_1__16810);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3374:1: rule__AliasAttributeExpression__Group_1__1__Impl : ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) ;
    public final void rule__AliasAttributeExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3378:1: ( ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3379:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3379:1: ( ( rule__AliasAttributeExpression__AttributeAssignment_1_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3380:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeAssignment_1_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3381:1: ( rule__AliasAttributeExpression__AttributeAssignment_1_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3381:2: rule__AliasAttributeExpression__AttributeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__1__Impl6837);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3395:1: rule__QueryExpression__Group__0 : rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1 ;
    public final void rule__QueryExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3399:1: ( rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3400:2: rule__QueryExpression__Group__0__Impl rule__QueryExpression__Group__1
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__0__Impl_in_rule__QueryExpression__Group__06871);
            rule__QueryExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__06874);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3407:1: rule__QueryExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__QueryExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3411:1: ( ( '(' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3412:1: ( '(' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3412:1: ( '(' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3413:1: '('
            {
             before(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__QueryExpression__Group__0__Impl6902); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3426:1: rule__QueryExpression__Group__1 : rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2 ;
    public final void rule__QueryExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3430:1: ( rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3431:2: rule__QueryExpression__Group__1__Impl rule__QueryExpression__Group__2
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__1__Impl_in_rule__QueryExpression__Group__16933);
            rule__QueryExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__16936);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3438:1: rule__QueryExpression__Group__1__Impl : ( ( rule__QueryExpression__ValueAssignment_1 ) ) ;
    public final void rule__QueryExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3442:1: ( ( ( rule__QueryExpression__ValueAssignment_1 ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3443:1: ( ( rule__QueryExpression__ValueAssignment_1 ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3443:1: ( ( rule__QueryExpression__ValueAssignment_1 ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3444:1: ( rule__QueryExpression__ValueAssignment_1 )
            {
             before(grammarAccess.getQueryExpressionAccess().getValueAssignment_1()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3445:1: ( rule__QueryExpression__ValueAssignment_1 )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3445:2: rule__QueryExpression__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__1__Impl6963);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3455:1: rule__QueryExpression__Group__2 : rule__QueryExpression__Group__2__Impl ;
    public final void rule__QueryExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3459:1: ( rule__QueryExpression__Group__2__Impl )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3460:2: rule__QueryExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QueryExpression__Group__2__Impl_in_rule__QueryExpression__Group__26993);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3466:1: rule__QueryExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__QueryExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3470:1: ( ( ')' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3471:1: ( ')' )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3471:1: ( ')' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3472:1: ')'
            {
             before(grammarAccess.getQueryExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,37,FOLLOW_37_in_rule__QueryExpression__Group__2__Impl7021); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3492:1: rule__Model__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3496:1: ( ( ruleImport ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3497:1: ( ruleImport )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3497:1: ( ruleImport )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3498:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_07063);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3507:1: rule__Model__DefaultQueryAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__Model__DefaultQueryAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3511:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3512:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3512:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3513:1: ruleMQLquery
            {
             before(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_17094);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3522:1: rule__Model__NamedQueriesAssignment_2 : ( ruleNamedQuery ) ;
    public final void rule__Model__NamedQueriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3526:1: ( ( ruleNamedQuery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3527:1: ( ruleNamedQuery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3527:1: ( ruleNamedQuery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3528:1: ruleNamedQuery
            {
             before(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_27125);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3537:1: rule__Import__ImpURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImpURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3541:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3542:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3542:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3543:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_17156); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3552:1: rule__NamedQuery__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__NamedQuery__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3556:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3557:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3557:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3558:1: RULE_ID
            {
             before(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_07187); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3567:1: rule__NamedQuery__QueryAssignment_2 : ( ruleMQLquery ) ;
    public final void rule__NamedQuery__QueryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3571:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3572:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3572:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3573:1: ruleMQLquery
            {
             before(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_27218);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3582:1: rule__MQLquery__FromEntriesAssignment_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3586:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3587:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3587:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3588:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_17249);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3597:1: rule__MQLquery__FromEntriesAssignment_2_1 : ( ruleFromEntry ) ;
    public final void rule__MQLquery__FromEntriesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3601:1: ( ( ruleFromEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3602:1: ( ruleFromEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3602:1: ( ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3603:1: ruleFromEntry
            {
             before(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_17280);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3612:1: rule__MQLquery__SelectEntriesAssignment_4 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3616:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3617:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3617:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3618:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_47311);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3627:1: rule__MQLquery__SelectEntriesAssignment_5_1 : ( ruleSelectEntry ) ;
    public final void rule__MQLquery__SelectEntriesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3631:1: ( ( ruleSelectEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3632:1: ( ruleSelectEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3632:1: ( ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3633:1: ruleSelectEntry
            {
             before(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_17342);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3642:1: rule__MQLquery__WhereEntryAssignment_6_1 : ( ruleWhereEntry ) ;
    public final void rule__MQLquery__WhereEntryAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3646:1: ( ( ruleWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3647:1: ( ruleWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3647:1: ( ruleWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3648:1: ruleWhereEntry
            {
             before(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17373);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3657:1: rule__SelectEntry__SelectAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__SelectAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3661:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3662:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3662:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3663:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3664:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3665:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getSelectFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07408); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3676:1: rule__SelectEntry__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__SelectEntry__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3680:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3681:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3681:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3682:1: ( RULE_ID )
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3683:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3684:1: RULE_ID
            {
             before(grammarAccess.getSelectEntryAccess().getAttributeEAttributeIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17447); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3695:1: rule__FromEntry__TypeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3699:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3700:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3700:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3701:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3702:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3703:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getTypeEClassIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07486); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3714:1: rule__FromEntry__WithoutsubtypesAssignment_1_0 : ( ( 'withoutsubtypes' ) ) ;
    public final void rule__FromEntry__WithoutsubtypesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3718:1: ( ( ( 'withoutsubtypes' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3719:1: ( ( 'withoutsubtypes' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3719:1: ( ( 'withoutsubtypes' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3720:1: ( 'withoutsubtypes' )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3721:1: ( 'withoutsubtypes' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3722:1: 'withoutsubtypes'
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0()); 
            match(input,38,FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_07526); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3737:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3741:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3742:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3742:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3743:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3744:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3745:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_17569); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3756:1: rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3760:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3761:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3761:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3762:1: ( RULE_ID )
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3763:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3764:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassIDTerminalRuleCall_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_17608); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3775:1: rule__FromEntry__AliasAssignment_3 : ( RULE_ID ) ;
    public final void rule__FromEntry__AliasAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3779:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3780:1: ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3780:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3781:1: RULE_ID
            {
             before(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37643); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3790:1: rule__FromEntry__ScopeClauseAssignment_4 : ( ruleScopeClause ) ;
    public final void rule__FromEntry__ScopeClauseAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3794:1: ( ( ruleScopeClause ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3795:1: ( ruleScopeClause )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3795:1: ( ruleScopeClause )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3796:1: ruleScopeClause
            {
             before(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47674);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3805:1: rule__ResourceScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ResourceScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3809:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3810:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3810:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3811:1: ( 'not' )
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3812:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3813:1: 'not'
            {
             before(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07710); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3828:1: rule__ResourceScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3832:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3833:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3833:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3834:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47749); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3843:1: rule__ResourceScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ResourceScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3847:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3848:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3848:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3849:1: RULE_STRING
            {
             before(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17780); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3858:1: rule__ElementScope__NotInAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__ElementScope__NotInAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3862:1: ( ( ( 'not' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3863:1: ( ( 'not' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3863:1: ( ( 'not' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3864:1: ( 'not' )
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3865:1: ( 'not' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3866:1: 'not'
            {
             before(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0()); 
            match(input,39,FOLLOW_39_in_rule__ElementScope__NotInAssignment_07816); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3881:1: rule__ElementScope__UrisAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3885:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3886:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3886:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3887:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47855); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3896:1: rule__ElementScope__UrisAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__ElementScope__UrisAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3900:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3901:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3901:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3902:1: RULE_STRING
            {
             before(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17886); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3911:1: rule__WhereEntry__EntriesAssignment_1_1_1 : ( ruleAndWhereEntry ) ;
    public final void rule__WhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3915:1: ( ( ruleAndWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3916:1: ( ruleAndWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3916:1: ( ruleAndWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3917:1: ruleAndWhereEntry
            {
             before(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17917);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3926:1: rule__AndWhereEntry__EntriesAssignment_1_1_1 : ( ruleConcreteWhereEntry ) ;
    public final void rule__AndWhereEntry__EntriesAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3930:1: ( ( ruleConcreteWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3931:1: ( ruleConcreteWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3931:1: ( ruleConcreteWhereEntry )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3932:1: ruleConcreteWhereEntry
            {
             before(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17948);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3941:1: rule__ExpressionWhereEntry__LhsAssignment_0 : ( ruleAliasAttributeExpression ) ;
    public final void rule__ExpressionWhereEntry__LhsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3945:1: ( ( ruleAliasAttributeExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3946:1: ( ruleAliasAttributeExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3946:1: ( ruleAliasAttributeExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3947:1: ruleAliasAttributeExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_07979);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3956:1: rule__ExpressionWhereEntry__OperatorAssignment_1 : ( ruleOperator ) ;
    public final void rule__ExpressionWhereEntry__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3960:1: ( ( ruleOperator ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3961:1: ( ruleOperator )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3961:1: ( ruleOperator )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3962:1: ruleOperator
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_18010);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3971:1: rule__ExpressionWhereEntry__RhsAssignment_2 : ( ruleExpression ) ;
    public final void rule__ExpressionWhereEntry__RhsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3975:1: ( ( ruleExpression ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3976:1: ( ruleExpression )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3976:1: ( ruleExpression )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3977:1: ruleExpression
            {
             before(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_28041);
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3986:1: rule__AliasAttributeExpression__AliasAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AliasAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3990:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3991:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3991:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3992:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3993:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:3994:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_08076); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4005:1: rule__AliasAttributeExpression__AttributeAssignment_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AliasAttributeExpression__AttributeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4009:1: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4010:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4010:1: ( ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4011:1: ( RULE_ID )
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4012:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4013:1: RULE_ID
            {
             before(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureIDTerminalRuleCall_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_18115); 
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


    // $ANTLR start rule__ReplacableValue__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4024:1: rule__ReplacableValue__ValueAssignment : ( ( '?' ) ) ;
    public final void rule__ReplacableValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4028:1: ( ( ( '?' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4029:1: ( ( '?' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4029:1: ( ( '?' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4030:1: ( '?' )
            {
             before(grammarAccess.getReplacableValueAccess().getValueQuestionMarkKeyword_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4031:1: ( '?' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4032:1: '?'
            {
             before(grammarAccess.getReplacableValueAccess().getValueQuestionMarkKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__ReplacableValue__ValueAssignment8155); 
             after(grammarAccess.getReplacableValueAccess().getValueQuestionMarkKeyword_0()); 

            }

             after(grammarAccess.getReplacableValueAccess().getValueQuestionMarkKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ReplacableValue__ValueAssignment


    // $ANTLR start rule__DoubleExpression__ValueAssignment
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4047:1: rule__DoubleExpression__ValueAssignment : ( RULE_SIGNED_DOUBLE ) ;
    public final void rule__DoubleExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4051:1: ( ( RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4052:1: ( RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4052:1: ( RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4053:1: RULE_SIGNED_DOUBLE
            {
             before(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0()); 
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment8194); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4062:1: rule__LongExpression__ValueAssignment : ( RULE_SINGED_LONG ) ;
    public final void rule__LongExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4066:1: ( ( RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4067:1: ( RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4067:1: ( RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4068:1: RULE_SINGED_LONG
            {
             before(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0()); 
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment8225); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4077:1: rule__StringExpression__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4081:1: ( ( RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4082:1: ( RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4082:1: ( RULE_STRING )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4083:1: RULE_STRING
            {
             before(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment8256); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4092:1: rule__NullExpression__ValueAssignment : ( ( 'null' ) ) ;
    public final void rule__NullExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4096:1: ( ( ( 'null' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4097:1: ( ( 'null' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4097:1: ( ( 'null' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4098:1: ( 'null' )
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4099:1: ( 'null' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4100:1: 'null'
            {
             before(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0()); 
            match(input,41,FOLLOW_41_in_rule__NullExpression__ValueAssignment8292); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4115:1: rule__BooleanExpression__TrueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanExpression__TrueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4119:1: ( ( ( 'true' ) ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4120:1: ( ( 'true' ) )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4120:1: ( ( 'true' ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4121:1: ( 'true' )
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4122:1: ( 'true' )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4123:1: 'true'
            {
             before(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0()); 
            match(input,42,FOLLOW_42_in_rule__BooleanExpression__TrueAssignment_08336); 
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
    // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4138:1: rule__QueryExpression__ValueAssignment_1 : ( ruleMQLquery ) ;
    public final void rule__QueryExpression__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4142:1: ( ( ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4143:1: ( ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4143:1: ( ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax.ui/src-gen/org/eclipse/emf/query2/syntax/ui/contentassist/antlr/internal/InternalQuery.g:4144:1: ruleMQLquery
            {
             before(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_18375);
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
    public static final BitSet FOLLOW_ruleReplacableValue_in_entryRuleReplacableValue1021 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReplacableValue1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReplacableValue__ValueAssignment_in_ruleReplacableValue1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleExpression1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DoubleExpression__ValueAssignment_in_ruleDoubleExpression1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_entryRuleLongExpression1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongExpression1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LongExpression__ValueAssignment_in_ruleLongExpression1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression1201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringExpression__ValueAssignment_in_ruleStringExpression1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression1261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullExpression__ValueAssignment_in_ruleNullExpression1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__Alternatives_in_ruleBooleanExpression1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression1381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryExpression1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__0_in_ruleQueryExpression1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Operator__Alternatives_in_ruleOperator1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_rule__ScopeClause__Alternatives1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_rule__ScopeClause__Alternatives1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_rule__ConcreteWhereEntry__Alternatives1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_rule__Expression__Alternatives1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_rule__Expression__Alternatives1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_rule__Expression__Alternatives1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_rule__Expression__Alternatives1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_rule__Expression__Alternatives1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_rule__Expression__Alternatives1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_rule__Expression__Alternatives1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReplacableValue_in_rule__Expression__Alternatives1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanExpression__TrueAssignment_0_in_rule__BooleanExpression__Alternatives1735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__BooleanExpression__Alternatives1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Operator__Alternatives1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Operator__Alternatives1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Operator__Alternatives1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Operator__Alternatives1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Operator__Alternatives1873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Operator__Alternatives1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Operator__Alternatives1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Operator__Alternatives1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Operator__Alternatives1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Operator__Alternatives1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__02011 = new BitSet(new long[]{0x0000000001000022L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__02014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_0_in_rule__Model__Group__0__Impl2041 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__12072 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__12075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__DefaultQueryAssignment_1_in_rule__Model__Group__1__Impl2102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__22133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NamedQueriesAssignment_2_in_rule__Model__Group__2__Impl2160 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__0__Impl2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImpURIAssignment_1_in_rule__Import__Group__1__Impl2286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__0__Impl_in_rule__NamedQuery__Group__02320 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1_in_rule__NamedQuery__Group__02323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__NameAssignment_0_in_rule__NamedQuery__Group__0__Impl2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__1__Impl_in_rule__NamedQuery__Group__12380 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2_in_rule__NamedQuery__Group__12383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__NamedQuery__Group__1__Impl2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__Group__2__Impl_in_rule__NamedQuery__Group__22442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedQuery__QueryAssignment_2_in_rule__NamedQuery__Group__2__Impl2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__0__Impl_in_rule__MQLquery__Group__02505 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1_in_rule__MQLquery__Group__02508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MQLquery__Group__0__Impl2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__1__Impl_in_rule__MQLquery__Group__12567 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2_in_rule__MQLquery__Group__12570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_1_in_rule__MQLquery__Group__1__Impl2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__2__Impl_in_rule__MQLquery__Group__22627 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3_in_rule__MQLquery__Group__22630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0_in_rule__MQLquery__Group__2__Impl2657 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__3__Impl_in_rule__MQLquery__Group__32688 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4_in_rule__MQLquery__Group__32691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MQLquery__Group__3__Impl2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__4__Impl_in_rule__MQLquery__Group__42750 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5_in_rule__MQLquery__Group__42753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_4_in_rule__MQLquery__Group__4__Impl2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__5__Impl_in_rule__MQLquery__Group__52810 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6_in_rule__MQLquery__Group__52813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0_in_rule__MQLquery__Group__5__Impl2840 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group__6__Impl_in_rule__MQLquery__Group__62871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0_in_rule__MQLquery__Group__6__Impl2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__0__Impl_in_rule__MQLquery__Group_2__02943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1_in_rule__MQLquery__Group_2__02946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_2__0__Impl2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_2__1__Impl_in_rule__MQLquery__Group_2__13005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__FromEntriesAssignment_2_1_in_rule__MQLquery__Group_2__1__Impl3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__0__Impl_in_rule__MQLquery__Group_5__03066 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1_in_rule__MQLquery__Group_5__03069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MQLquery__Group_5__0__Impl3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_5__1__Impl_in_rule__MQLquery__Group_5__13128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__SelectEntriesAssignment_5_1_in_rule__MQLquery__Group_5__1__Impl3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__0__Impl_in_rule__MQLquery__Group_6__03189 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1_in_rule__MQLquery__Group_6__03192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MQLquery__Group_6__0__Impl3220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__Group_6__1__Impl_in_rule__MQLquery__Group_6__13251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MQLquery__WhereEntryAssignment_6_1_in_rule__MQLquery__Group_6__1__Impl3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__0__Impl_in_rule__SelectEntry__Group__03312 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1_in_rule__SelectEntry__Group__03315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__SelectAssignment_0_in_rule__SelectEntry__Group__0__Impl3342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group__1__Impl_in_rule__SelectEntry__Group__13372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0_in_rule__SelectEntry__Group__1__Impl3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__0__Impl_in_rule__SelectEntry__Group_1__03434 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1_in_rule__SelectEntry__Group_1__03437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SelectEntry__Group_1__0__Impl3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__Group_1__1__Impl_in_rule__SelectEntry__Group_1__13496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SelectEntry__AttributeAssignment_1_1_in_rule__SelectEntry__Group_1__1__Impl3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__0__Impl_in_rule__FromEntry__Group__03557 = new BitSet(new long[]{0x0000004020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1_in_rule__FromEntry__Group__03560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__TypeAssignment_0_in_rule__FromEntry__Group__0__Impl3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__1__Impl_in_rule__FromEntry__Group__13617 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2_in_rule__FromEntry__Group__13620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__0_in_rule__FromEntry__Group__1__Impl3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__2__Impl_in_rule__FromEntry__Group__23678 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3_in_rule__FromEntry__Group__23681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__FromEntry__Group__2__Impl3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__3__Impl_in_rule__FromEntry__Group__33740 = new BitSet(new long[]{0x0000008000200002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4_in_rule__FromEntry__Group__33743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__AliasAssignment_3_in_rule__FromEntry__Group__3__Impl3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group__4__Impl_in_rule__FromEntry__Group__43800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__ScopeClauseAssignment_4_in_rule__FromEntry__Group__4__Impl3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__0__Impl_in_rule__FromEntry__Group_1__03868 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__1_in_rule__FromEntry__Group_1__03871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesAssignment_1_0_in_rule__FromEntry__Group_1__0__Impl3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1__1__Impl_in_rule__FromEntry__Group_1__13928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__0_in_rule__FromEntry__Group_1__1__Impl3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__0__Impl_in_rule__FromEntry__Group_1_1__03990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__1_in_rule__FromEntry__Group_1_1__03993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__FromEntry__Group_1_1__0__Impl4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__1__Impl_in_rule__FromEntry__Group_1_1__14052 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__2_in_rule__FromEntry__Group_1_1__14055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_1_in_rule__FromEntry__Group_1_1__1__Impl4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__2__Impl_in_rule__FromEntry__Group_1_1__24112 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__3_in_rule__FromEntry__Group_1_1__24115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__0_in_rule__FromEntry__Group_1_1__2__Impl4142 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1__3__Impl_in_rule__FromEntry__Group_1_1__34173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__FromEntry__Group_1_1__3__Impl4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__0__Impl_in_rule__FromEntry__Group_1_1_2__04240 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__1_in_rule__FromEntry__Group_1_1_2__04243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FromEntry__Group_1_1_2__0__Impl4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__Group_1_1_2__1__Impl_in_rule__FromEntry__Group_1_1_2__14302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_1_in_rule__FromEntry__Group_1_1_2__1__Impl4329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__0__Impl_in_rule__ResourceScope__Group__04363 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1_in_rule__ResourceScope__Group__04366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__NotInAssignment_0_in_rule__ResourceScope__Group__0__Impl4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__1__Impl_in_rule__ResourceScope__Group__14424 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2_in_rule__ResourceScope__Group__14427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ResourceScope__Group__1__Impl4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__2__Impl_in_rule__ResourceScope__Group__24486 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3_in_rule__ResourceScope__Group__24489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ResourceScope__Group__2__Impl4517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__3__Impl_in_rule__ResourceScope__Group__34548 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4_in_rule__ResourceScope__Group__34551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ResourceScope__Group__3__Impl4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__4__Impl_in_rule__ResourceScope__Group__44610 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5_in_rule__ResourceScope__Group__44613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_4_in_rule__ResourceScope__Group__4__Impl4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__5__Impl_in_rule__ResourceScope__Group__54670 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6_in_rule__ResourceScope__Group__54673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0_in_rule__ResourceScope__Group__5__Impl4700 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group__6__Impl_in_rule__ResourceScope__Group__64731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ResourceScope__Group__6__Impl4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__0__Impl_in_rule__ResourceScope__Group_5__04804 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1_in_rule__ResourceScope__Group_5__04807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ResourceScope__Group_5__0__Impl4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__Group_5__1__Impl_in_rule__ResourceScope__Group_5__14866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceScope__UrisAssignment_5_1_in_rule__ResourceScope__Group_5__1__Impl4893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__0__Impl_in_rule__ElementScope__Group__04927 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1_in_rule__ElementScope__Group__04930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__NotInAssignment_0_in_rule__ElementScope__Group__0__Impl4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__1__Impl_in_rule__ElementScope__Group__14988 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2_in_rule__ElementScope__Group__14991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ElementScope__Group__1__Impl5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__2__Impl_in_rule__ElementScope__Group__25050 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3_in_rule__ElementScope__Group__25053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ElementScope__Group__2__Impl5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__3__Impl_in_rule__ElementScope__Group__35112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4_in_rule__ElementScope__Group__35115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ElementScope__Group__3__Impl5143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__4__Impl_in_rule__ElementScope__Group__45174 = new BitSet(new long[]{0x0000000084000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5_in_rule__ElementScope__Group__45177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_4_in_rule__ElementScope__Group__4__Impl5204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__5__Impl_in_rule__ElementScope__Group__55234 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6_in_rule__ElementScope__Group__55237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0_in_rule__ElementScope__Group__5__Impl5264 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group__6__Impl_in_rule__ElementScope__Group__65295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ElementScope__Group__6__Impl5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__0__Impl_in_rule__ElementScope__Group_5__05368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1_in_rule__ElementScope__Group_5__05371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ElementScope__Group_5__0__Impl5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__Group_5__1__Impl_in_rule__ElementScope__Group_5__15430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ElementScope__UrisAssignment_5_1_in_rule__ElementScope__Group_5__1__Impl5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__0__Impl_in_rule__WhereEntry__Group__05491 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1_in_rule__WhereEntry__Group__05494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__Group__0__Impl5521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group__1__Impl_in_rule__WhereEntry__Group__15550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0_in_rule__WhereEntry__Group__1__Impl5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__0__Impl_in_rule__WhereEntry__Group_1__05612 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1_in_rule__WhereEntry__Group_1__05615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1__1__Impl_in_rule__WhereEntry__Group_1__15673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5702 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0_in_rule__WhereEntry__Group_1__1__Impl5714 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__0__Impl_in_rule__WhereEntry__Group_1_1__05751 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1_in_rule__WhereEntry__Group_1_1__05754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__WhereEntry__Group_1_1__0__Impl5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__Group_1_1__1__Impl_in_rule__WhereEntry__Group_1_1__15813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhereEntry__EntriesAssignment_1_1_1_in_rule__WhereEntry__Group_1_1__1__Impl5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__0__Impl_in_rule__AndWhereEntry__Group__05874 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1_in_rule__AndWhereEntry__Group__05877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__Group__0__Impl5904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group__1__Impl_in_rule__AndWhereEntry__Group__15933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0_in_rule__AndWhereEntry__Group__1__Impl5960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__0__Impl_in_rule__AndWhereEntry__Group_1__05995 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1_in_rule__AndWhereEntry__Group_1__05998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1__1__Impl_in_rule__AndWhereEntry__Group_1__16056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6085 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0_in_rule__AndWhereEntry__Group_1__1__Impl6097 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__0__Impl_in_rule__AndWhereEntry__Group_1_1__06134 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1_in_rule__AndWhereEntry__Group_1_1__06137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AndWhereEntry__Group_1_1__0__Impl6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__Group_1_1__1__Impl_in_rule__AndWhereEntry__Group_1_1__16196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndWhereEntry__EntriesAssignment_1_1_1_in_rule__AndWhereEntry__Group_1_1__1__Impl6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__0__Impl_in_rule__ParWhereEntry__Group__06257 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1_in_rule__ParWhereEntry__Group__06260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParWhereEntry__Group__0__Impl6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__1__Impl_in_rule__ParWhereEntry__Group__16319 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2_in_rule__ParWhereEntry__Group__16322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__ParWhereEntry__Group__1__Impl6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParWhereEntry__Group__2__Impl_in_rule__ParWhereEntry__Group__26378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ParWhereEntry__Group__2__Impl6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__0__Impl_in_rule__ExpressionWhereEntry__Group__06443 = new BitSet(new long[]{0x00000000003FF000L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__1_in_rule__ExpressionWhereEntry__Group__06446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__LhsAssignment_0_in_rule__ExpressionWhereEntry__Group__0__Impl6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__1__Impl_in_rule__ExpressionWhereEntry__Group__16503 = new BitSet(new long[]{0x00000710000008F0L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__2_in_rule__ExpressionWhereEntry__Group__16506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__OperatorAssignment_1_in_rule__ExpressionWhereEntry__Group__1__Impl6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__Group__2__Impl_in_rule__ExpressionWhereEntry__Group__26563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExpressionWhereEntry__RhsAssignment_2_in_rule__ExpressionWhereEntry__Group__2__Impl6590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__0__Impl_in_rule__AliasAttributeExpression__Group__06626 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__1_in_rule__AliasAttributeExpression__Group__06629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AliasAssignment_0_in_rule__AliasAttributeExpression__Group__0__Impl6656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group__1__Impl_in_rule__AliasAttributeExpression__Group__16686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__0_in_rule__AliasAttributeExpression__Group__1__Impl6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__0__Impl_in_rule__AliasAttributeExpression__Group_1__06748 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__1_in_rule__AliasAttributeExpression__Group_1__06751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__AliasAttributeExpression__Group_1__0__Impl6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__Group_1__1__Impl_in_rule__AliasAttributeExpression__Group_1__16810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AliasAttributeExpression__AttributeAssignment_1_1_in_rule__AliasAttributeExpression__Group_1__1__Impl6837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__0__Impl_in_rule__QueryExpression__Group__06871 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__1_in_rule__QueryExpression__Group__06874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__QueryExpression__Group__0__Impl6902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__1__Impl_in_rule__QueryExpression__Group__16933 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__2_in_rule__QueryExpression__Group__16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__ValueAssignment_1_in_rule__QueryExpression__Group__1__Impl6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QueryExpression__Group__2__Impl_in_rule__QueryExpression__Group__26993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QueryExpression__Group__2__Impl7021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_07063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__Model__DefaultQueryAssignment_17094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_rule__Model__NamedQueriesAssignment_27125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImpURIAssignment_17156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__NamedQuery__NameAssignment_07187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__NamedQuery__QueryAssignment_27218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_17249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_rule__MQLquery__FromEntriesAssignment_2_17280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_47311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_rule__MQLquery__SelectEntriesAssignment_5_17342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_rule__MQLquery__WhereEntryAssignment_6_17373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__SelectAssignment_07408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SelectEntry__AttributeAssignment_1_17447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__TypeAssignment_07486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__FromEntry__WithoutsubtypesAssignment_1_07526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_17569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__WithoutsubtypesTypesAssignment_1_1_2_17608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FromEntry__AliasAssignment_37643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_rule__FromEntry__ScopeClauseAssignment_47674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ResourceScope__NotInAssignment_07710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_47749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ResourceScope__UrisAssignment_5_17780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ElementScope__NotInAssignment_07816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_47855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ElementScope__UrisAssignment_5_17886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_rule__WhereEntry__EntriesAssignment_1_1_17917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_rule__AndWhereEntry__EntriesAssignment_1_1_17948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_rule__ExpressionWhereEntry__LhsAssignment_07979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperator_in_rule__ExpressionWhereEntry__OperatorAssignment_18010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ExpressionWhereEntry__RhsAssignment_28041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AliasAssignment_08076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AliasAttributeExpression__AttributeAssignment_1_18115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ReplacableValue__ValueAssignment8155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_rule__DoubleExpression__ValueAssignment8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_rule__LongExpression__ValueAssignment8225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringExpression__ValueAssignment8256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__NullExpression__ValueAssignment8292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__BooleanExpression__TrueAssignment_08336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_rule__QueryExpression__ValueAssignment_18375 = new BitSet(new long[]{0x0000000000000002L});

}