package org.eclipse.emf.query2.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.emf.query2.services.QueryGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalQueryParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "':'", "'from'", "','", "'select'", "'where'", "'.'", "'withoutsubtypes'", "'{'", "'}'", "'as'", "'not'", "'in'", "'resources'", "'elements'", "'or'", "'and'", "'('", "')'", "'null'", "'true'", "'false'", "'<'", "'>'", "'<='", "'>='", "'='", "'!='", "'like'", "'not like'", "'not in'"
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
    public String getGrammarFileName() { return "../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g"; }


     
     	private QueryGrammarAccess grammarAccess;
     	
        public InternalQueryParser(TokenStream input, IAstFactory factory, QueryGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:73:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:73:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:81:1: ruleModel returns [EObject current=null] : ( (lv_imports_0= ruleImport )* (lv_defaultQuery_1= ruleMQLquery )? (lv_namedQueries_2= ruleNamedQuery )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0 = null;

        EObject lv_defaultQuery_1 = null;

        EObject lv_namedQueries_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:86:6: ( ( (lv_imports_0= ruleImport )* (lv_defaultQuery_1= ruleMQLquery )? (lv_namedQueries_2= ruleNamedQuery )* ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:87:1: ( (lv_imports_0= ruleImport )* (lv_defaultQuery_1= ruleMQLquery )? (lv_namedQueries_2= ruleNamedQuery )* )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:87:1: ( (lv_imports_0= ruleImport )* (lv_defaultQuery_1= ruleMQLquery )? (lv_namedQueries_2= ruleNamedQuery )* )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:87:2: (lv_imports_0= ruleImport )* (lv_defaultQuery_1= ruleMQLquery )? (lv_namedQueries_2= ruleNamedQuery )*
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:87:2: (lv_imports_0= ruleImport )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:90:6: lv_imports_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel142);
            	    lv_imports_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "imports", lv_imports_0, "Import", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:108:3: (lv_defaultQuery_1= ruleMQLquery )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:111:6: lv_defaultQuery_1= ruleMQLquery
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefaultQueryMQLqueryParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleMQLquery_in_ruleModel181);
                    lv_defaultQuery_1=ruleMQLquery();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "defaultQuery", lv_defaultQuery_1, "MQLquery", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:129:3: (lv_namedQueries_2= ruleNamedQuery )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:132:6: lv_namedQueries_2= ruleNamedQuery
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getNamedQueriesNamedQueryParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedQuery_in_ruleModel220);
            	    lv_namedQueries_2=ruleNamedQuery();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "namedQueries", lv_namedQueries_2, "NamedQuery", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:157:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:157:48: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:158:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport258);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport268); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:165:1: ruleImport returns [EObject current=null] : ( 'import' (lv_impURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_impURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:170:6: ( ( 'import' (lv_impURI_1= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:1: ( 'import' (lv_impURI_1= RULE_STRING ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:1: ( 'import' (lv_impURI_1= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:2: 'import' (lv_impURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport302); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:175:1: (lv_impURI_1= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:177:6: lv_impURI_1= RULE_STRING
            {
            lv_impURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport324); 

            		createLeafNode(grammarAccess.getImportAccess().getImpURISTRINGTerminalRuleCall_1_0(), "impURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "impURI", lv_impURI_1, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleNamedQuery
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:202:1: entryRuleNamedQuery returns [EObject current=null] : iv_ruleNamedQuery= ruleNamedQuery EOF ;
    public final EObject entryRuleNamedQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedQuery = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:202:52: (iv_ruleNamedQuery= ruleNamedQuery EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:203:2: iv_ruleNamedQuery= ruleNamedQuery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedQueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery365);
            iv_ruleNamedQuery=ruleNamedQuery();
            _fsp--;

             current =iv_ruleNamedQuery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedQuery375); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNamedQuery


    // $ANTLR start ruleNamedQuery
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:210:1: ruleNamedQuery returns [EObject current=null] : ( (lv_name_0= RULE_ID ) ':' (lv_query_2= ruleMQLquery ) ) ;
    public final EObject ruleNamedQuery() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        EObject lv_query_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:215:6: ( ( (lv_name_0= RULE_ID ) ':' (lv_query_2= ruleMQLquery ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:216:1: ( (lv_name_0= RULE_ID ) ':' (lv_query_2= ruleMQLquery ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:216:1: ( (lv_name_0= RULE_ID ) ':' (lv_query_2= ruleMQLquery ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:216:2: (lv_name_0= RULE_ID ) ':' (lv_query_2= ruleMQLquery )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:216:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:218:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedQuery422); 

            		createLeafNode(grammarAccess.getNamedQueryAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedQueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,12,FOLLOW_12_in_ruleNamedQuery439); 

                    createLeafNode(grammarAccess.getNamedQueryAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:240:1: (lv_query_2= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:243:6: lv_query_2= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedQueryAccess().getQueryMQLqueryParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleNamedQuery473);
            lv_query_2=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedQueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "query", lv_query_2, "MQLquery", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamedQuery


    // $ANTLR start entryRuleMQLquery
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:268:1: entryRuleMQLquery returns [EObject current=null] : iv_ruleMQLquery= ruleMQLquery EOF ;
    public final EObject entryRuleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMQLquery = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:268:50: (iv_ruleMQLquery= ruleMQLquery EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:269:2: iv_ruleMQLquery= ruleMQLquery EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMQLqueryRule(), currentNode); 
            pushFollow(FOLLOW_ruleMQLquery_in_entryRuleMQLquery510);
            iv_ruleMQLquery=ruleMQLquery();
            _fsp--;

             current =iv_ruleMQLquery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMQLquery520); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleMQLquery


    // $ANTLR start ruleMQLquery
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:276:1: ruleMQLquery returns [EObject current=null] : ( 'from' (lv_fromEntries_1= ruleFromEntry ) ( ',' (lv_fromEntries_3= ruleFromEntry ) )* 'select' (lv_selectEntries_5= ruleSelectEntry ) ( ',' (lv_selectEntries_7= ruleSelectEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_fromEntries_1 = null;

        EObject lv_fromEntries_3 = null;

        EObject lv_selectEntries_5 = null;

        EObject lv_selectEntries_7 = null;

        EObject lv_whereEntry_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:281:6: ( ( 'from' (lv_fromEntries_1= ruleFromEntry ) ( ',' (lv_fromEntries_3= ruleFromEntry ) )* 'select' (lv_selectEntries_5= ruleSelectEntry ) ( ',' (lv_selectEntries_7= ruleSelectEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:1: ( 'from' (lv_fromEntries_1= ruleFromEntry ) ( ',' (lv_fromEntries_3= ruleFromEntry ) )* 'select' (lv_selectEntries_5= ruleSelectEntry ) ( ',' (lv_selectEntries_7= ruleSelectEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:1: ( 'from' (lv_fromEntries_1= ruleFromEntry ) ( ',' (lv_fromEntries_3= ruleFromEntry ) )* 'select' (lv_selectEntries_5= ruleSelectEntry ) ( ',' (lv_selectEntries_7= ruleSelectEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:2: 'from' (lv_fromEntries_1= ruleFromEntry ) ( ',' (lv_fromEntries_3= ruleFromEntry ) )* 'select' (lv_selectEntries_5= ruleSelectEntry ) ( ',' (lv_selectEntries_7= ruleSelectEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )?
            {
            match(input,13,FOLLOW_13_in_ruleMQLquery554); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:286:1: (lv_fromEntries_1= ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:289:6: lv_fromEntries_1= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery588);
            lv_fromEntries_1=ruleFromEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "fromEntries", lv_fromEntries_1, "FromEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:307:2: ( ',' (lv_fromEntries_3= ruleFromEntry ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:307:3: ',' (lv_fromEntries_3= ruleFromEntry )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery602); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:311:1: (lv_fromEntries_3= ruleFromEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:314:6: lv_fromEntries_3= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery636);
            	    lv_fromEntries_3=ruleFromEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "fromEntries", lv_fromEntries_3, "FromEntry", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleMQLquery651); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:336:1: (lv_selectEntries_5= ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:339:6: lv_selectEntries_5= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery685);
            lv_selectEntries_5=ruleSelectEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "selectEntries", lv_selectEntries_5, "SelectEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:357:2: ( ',' (lv_selectEntries_7= ruleSelectEntry ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:357:3: ',' (lv_selectEntries_7= ruleSelectEntry )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery699); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:361:1: (lv_selectEntries_7= ruleSelectEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:364:6: lv_selectEntries_7= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery733);
            	    lv_selectEntries_7=ruleSelectEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "selectEntries", lv_selectEntries_7, "SelectEntry", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:382:4: ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:382:5: 'where' (lv_whereEntry_9= ruleWhereEntry )
                    {
                    match(input,16,FOLLOW_16_in_ruleMQLquery749); 

                            createLeafNode(grammarAccess.getMQLqueryAccess().getWhereKeyword_6_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:386:1: (lv_whereEntry_9= ruleWhereEntry )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:389:6: lv_whereEntry_9= ruleWhereEntry
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getWhereEntryWhereEntryParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleWhereEntry_in_ruleMQLquery783);
                    lv_whereEntry_9=ruleWhereEntry();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "whereEntry", lv_whereEntry_9, "WhereEntry", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMQLquery


    // $ANTLR start entryRuleSelectEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:414:1: entryRuleSelectEntry returns [EObject current=null] : iv_ruleSelectEntry= ruleSelectEntry EOF ;
    public final EObject entryRuleSelectEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:414:53: (iv_ruleSelectEntry= ruleSelectEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:415:2: iv_ruleSelectEntry= ruleSelectEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSelectEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry822);
            iv_ruleSelectEntry=ruleSelectEntry();
            _fsp--;

             current =iv_ruleSelectEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectEntry832); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSelectEntry


    // $ANTLR start ruleSelectEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:422:1: ruleSelectEntry returns [EObject current=null] : ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) ;
    public final EObject ruleSelectEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:427:6: ( ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:428:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:428:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:428:2: ( RULE_ID ) ( '.' ( RULE_ID ) )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:428:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:431:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry879); 

            		createLeafNode(grammarAccess.getSelectEntryAccess().getSelectFromEntryCrossReference_0_0(), "select"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:444:2: ( '.' ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:444:3: '.' ( RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleSelectEntry892); 

                            createLeafNode(grammarAccess.getSelectEntryAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:448:1: ( RULE_ID )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:451:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSelectEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectEntry914); 

                    		createLeafNode(grammarAccess.getSelectEntryAccess().getAttributeEAttributeCrossReference_1_1_0(), "attribute"); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSelectEntry


    // $ANTLR start entryRuleFromEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:471:1: entryRuleFromEntry returns [EObject current=null] : iv_ruleFromEntry= ruleFromEntry EOF ;
    public final EObject entryRuleFromEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFromEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:471:51: (iv_ruleFromEntry= ruleFromEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:472:2: iv_ruleFromEntry= ruleFromEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFromEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleFromEntry_in_entryRuleFromEntry952);
            iv_ruleFromEntry=ruleFromEntry();
            _fsp--;

             current =iv_ruleFromEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFromEntry962); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFromEntry


    // $ANTLR start ruleFromEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:479:1: ruleFromEntry returns [EObject current=null] : ( ( RULE_ID ) ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )? 'as' (lv_alias_8= RULE_ID ) (lv_scopeClause_9= ruleScopeClause )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1=null;
        Token lv_alias_8=null;
        EObject lv_scopeClause_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:484:6: ( ( ( RULE_ID ) ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )? 'as' (lv_alias_8= RULE_ID ) (lv_scopeClause_9= ruleScopeClause )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:1: ( ( RULE_ID ) ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )? 'as' (lv_alias_8= RULE_ID ) (lv_scopeClause_9= ruleScopeClause )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:1: ( ( RULE_ID ) ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )? 'as' (lv_alias_8= RULE_ID ) (lv_scopeClause_9= ruleScopeClause )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:2: ( RULE_ID ) ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )? 'as' (lv_alias_8= RULE_ID ) (lv_scopeClause_9= ruleScopeClause )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:488:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry1009); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getTypeEClassCrossReference_0_0(), "type"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:501:2: ( (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )? )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:501:3: (lv_withoutsubtypes_1= 'withoutsubtypes' ) ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )?
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:501:3: (lv_withoutsubtypes_1= 'withoutsubtypes' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:503:6: lv_withoutsubtypes_1= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleFromEntry1034); 

                            createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0_0(), "withoutsubtypes"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "withoutsubtypes", true, "withoutsubtypes", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:522:2: ( '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==19) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:522:3: '{' ( RULE_ID ) ( ',' ( RULE_ID ) )* '}'
                            {
                            match(input,19,FOLLOW_19_in_ruleFromEntry1057); 

                                    createLeafNode(grammarAccess.getFromEntryAccess().getLeftCurlyBracketKeyword_1_1_0(), null); 
                                
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:526:1: ( RULE_ID )
                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:529:3: RULE_ID
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry1079); 

                            		createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_1_0(), "withoutsubtypesTypes"); 
                            	

                            }

                            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:542:2: ( ',' ( RULE_ID ) )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==14) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:542:3: ',' ( RULE_ID )
                            	    {
                            	    match(input,14,FOLLOW_14_in_ruleFromEntry1092); 

                            	            createLeafNode(grammarAccess.getFromEntryAccess().getCommaKeyword_1_1_2_0(), null); 
                            	        
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:546:1: ( RULE_ID )
                            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:549:3: RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry1114); 

                            	    		createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesTypesEClassCrossReference_1_1_2_1_0(), "withoutsubtypesTypes"); 
                            	    	

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);

                            match(input,20,FOLLOW_20_in_ruleFromEntry1128); 

                                    createLeafNode(grammarAccess.getFromEntryAccess().getRightCurlyBracketKeyword_1_1_3(), null); 
                                

                            }
                            break;

                    }


                    }
                    break;

            }

            match(input,21,FOLLOW_21_in_ruleFromEntry1141); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:570:1: (lv_alias_8= RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:572:6: lv_alias_8= RULE_ID
            {
            lv_alias_8=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry1163); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "alias", lv_alias_8, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:590:2: (lv_scopeClause_9= ruleScopeClause )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=22 && LA11_0<=23)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:593:6: lv_scopeClause_9= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleScopeClause_in_ruleFromEntry1205);
                    lv_scopeClause_9=ruleScopeClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "scopeClause", lv_scopeClause_9, "ScopeClause", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFromEntry


    // $ANTLR start entryRuleScopeClause
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:618:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:618:53: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:619:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause1243);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause1253); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleScopeClause


    // $ANTLR start ruleScopeClause
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:626:1: ruleScopeClause returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:631:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==23) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==25) ) {
                        alt12=2;
                    }
                    else if ( (LA12_2==24) ) {
                        alt12=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==23) ) {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==25) ) {
                    alt12=2;
                }
                else if ( (LA12_2==24) ) {
                    alt12=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("632:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:633:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceScope_in_ruleScopeClause1300);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:643:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleElementScope_in_ruleScopeClause1327);
                    this_ElementScope_1=ruleElementScope();
                    _fsp--;

                     
                            current = this_ElementScope_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleScopeClause


    // $ANTLR start entryRuleResourceScope
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:658:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:658:55: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:659:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope1359);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope1369); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleResourceScope


    // $ANTLR start ruleResourceScope
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:666:1: ruleResourceScope returns [EObject current=null] : ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0=null;
        Token lv_uris_4=null;
        Token lv_uris_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:671:6: ( ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:672:1: ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:672:1: ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:672:2: (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:672:2: (lv_notIn_0= 'not' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:674:6: lv_notIn_0= 'not'
                    {
                    lv_notIn_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleResourceScope1415); 

                            createLeafNode(grammarAccess.getResourceScopeAccess().getNotInNotKeyword_0_0(), "notIn"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "notIn", true, "not", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleResourceScope1438); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getInKeyword_1(), null); 
                
            match(input,24,FOLLOW_24_in_ruleResourceScope1447); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2(), null); 
                
            match(input,19,FOLLOW_19_in_ruleResourceScope1456); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:705:1: (lv_uris_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:707:6: lv_uris_4= RULE_STRING
            {
            lv_uris_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1478); 

            		createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_4_0(), "uris"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "uris", lv_uris_4, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:725:2: ( ',' (lv_uris_6= RULE_STRING ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==14) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:725:3: ',' (lv_uris_6= RULE_STRING )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleResourceScope1496); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:729:1: (lv_uris_6= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:731:6: lv_uris_6= RULE_STRING
            	    {
            	    lv_uris_6=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1518); 

            	    		createLeafNode(grammarAccess.getResourceScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0(), "uris"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getResourceScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "uris", lv_uris_6, "STRING", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleResourceScope1537); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleResourceScope


    // $ANTLR start entryRuleElementScope
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:760:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:760:54: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:761:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope1570);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope1580); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleElementScope


    // $ANTLR start ruleElementScope
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:768:1: ruleElementScope returns [EObject current=null] : ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0=null;
        Token lv_uris_4=null;
        Token lv_uris_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:773:6: ( ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:774:1: ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:774:1: ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:774:2: (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:774:2: (lv_notIn_0= 'not' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:776:6: lv_notIn_0= 'not'
                    {
                    lv_notIn_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleElementScope1626); 

                            createLeafNode(grammarAccess.getElementScopeAccess().getNotInNotKeyword_0_0(), "notIn"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "notIn", true, "not", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleElementScope1649); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getInKeyword_1(), null); 
                
            match(input,25,FOLLOW_25_in_ruleElementScope1658); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_2(), null); 
                
            match(input,19,FOLLOW_19_in_ruleElementScope1667); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:807:1: (lv_uris_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:809:6: lv_uris_4= RULE_STRING
            {
            lv_uris_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1689); 

            		createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_4_0(), "uris"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		add(current, "uris", lv_uris_4, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:827:2: ( ',' (lv_uris_6= RULE_STRING ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==14) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:827:3: ',' (lv_uris_6= RULE_STRING )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleElementScope1707); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:831:1: (lv_uris_6= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:833:6: lv_uris_6= RULE_STRING
            	    {
            	    lv_uris_6=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1729); 

            	    		createLeafNode(grammarAccess.getElementScopeAccess().getUrisSTRINGTerminalRuleCall_5_1_0(), "uris"); 
            	    	

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementScopeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "uris", lv_uris_6, "STRING", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_ruleElementScope1748); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getRightCurlyBracketKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleElementScope


    // $ANTLR start entryRuleWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:862:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:862:52: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:863:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1781);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry1791); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleWhereEntry


    // $ANTLR start ruleWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:870:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:875:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:876:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:876:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:877:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1838);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:885:1: ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:885:2: () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:885:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:886:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "entries", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getWhereEntryAccess().getOrWhereEntryEntriesAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:901:2: ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==26) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:901:3: 'or' (lv_entries_3= ruleAndWhereEntry )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleWhereEntry1857); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:905:1: (lv_entries_3= ruleAndWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:908:6: lv_entries_3= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1891);
                    	    lv_entries_3=ruleAndWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "entries", lv_entries_3, "AndWhereEntry", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleWhereEntry


    // $ANTLR start entryRuleAndWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:933:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:933:55: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:934:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1932);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry1942); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAndWhereEntry


    // $ANTLR start ruleAndWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:941:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:946:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:947:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:947:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:948:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1989);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:956:1: ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:956:2: () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:956:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:957:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "entries", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAndWhereEntryAccess().getAndWhereEntryEntriesAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:972:2: ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==27) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:972:3: 'and' (lv_entries_3= ruleConcreteWhereEntry )
                    	    {
                    	    match(input,27,FOLLOW_27_in_ruleAndWhereEntry2008); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:976:1: (lv_entries_3= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:979:6: lv_entries_3= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry2042);
                    	    lv_entries_3=ruleConcreteWhereEntry();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAndWhereEntryRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "entries", lv_entries_3, "ConcreteWhereEntry", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAndWhereEntry


    // $ANTLR start entryRuleConcreteWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1004:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1004:60: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1005:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry2083);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry2093); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleConcreteWhereEntry


    // $ANTLR start ruleConcreteWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1012:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_ExpressionWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1017:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1018:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1018:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_ID) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1018:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_ExpressionWhereEntry_1= ruleExpressionWhereEntry )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1019:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry2140);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1029:5: this_ExpressionWhereEntry_1= ruleExpressionWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getExpressionWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleExpressionWhereEntry_in_ruleConcreteWhereEntry2167);
                    this_ExpressionWhereEntry_1=ruleExpressionWhereEntry();
                    _fsp--;

                     
                            current = this_ExpressionWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleConcreteWhereEntry


    // $ANTLR start entryRuleParWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1044:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1044:55: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1045:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2199);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry2209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleParWhereEntry


    // $ANTLR start ruleParWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1052:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1057:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1058:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1058:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1058:2: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,28,FOLLOW_28_in_ruleParWhereEntry2243); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2265);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,29,FOLLOW_29_in_ruleParWhereEntry2273); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getRightParenthesisKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParWhereEntry


    // $ANTLR start entryRuleExpressionWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1082:1: entryRuleExpressionWhereEntry returns [EObject current=null] : iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF ;
    public final EObject entryRuleExpressionWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1082:62: (iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1083:2: iv_ruleExpressionWhereEntry= ruleExpressionWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry2306);
            iv_ruleExpressionWhereEntry=ruleExpressionWhereEntry();
            _fsp--;

             current =iv_ruleExpressionWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionWhereEntry2316); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpressionWhereEntry


    // $ANTLR start ruleExpressionWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1090:1: ruleExpressionWhereEntry returns [EObject current=null] : ( (lv_lhs_0= ruleAliasAttributeExpression ) (lv_operator_1= ruleOperator ) (lv_rhs_2= ruleExpression ) ) ;
    public final EObject ruleExpressionWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject lv_lhs_0 = null;

        Enumerator lv_operator_1 = null;

        EObject lv_rhs_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1095:6: ( ( (lv_lhs_0= ruleAliasAttributeExpression ) (lv_operator_1= ruleOperator ) (lv_rhs_2= ruleExpression ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1096:1: ( (lv_lhs_0= ruleAliasAttributeExpression ) (lv_operator_1= ruleOperator ) (lv_rhs_2= ruleExpression ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1096:1: ( (lv_lhs_0= ruleAliasAttributeExpression ) (lv_operator_1= ruleOperator ) (lv_rhs_2= ruleExpression ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1096:2: (lv_lhs_0= ruleAliasAttributeExpression ) (lv_operator_1= ruleOperator ) (lv_rhs_2= ruleExpression )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1096:2: (lv_lhs_0= ruleAliasAttributeExpression )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1099:6: lv_lhs_0= ruleAliasAttributeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getLhsAliasAttributeExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_ruleExpressionWhereEntry2375);
            lv_lhs_0=ruleAliasAttributeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "lhs", lv_lhs_0, "AliasAttributeExpression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1117:2: (lv_operator_1= ruleOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1120:6: lv_operator_1= ruleOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getOperatorOperatorEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleOperator_in_ruleExpressionWhereEntry2413);
            lv_operator_1=ruleOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_1, "Operator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1138:2: (lv_rhs_2= ruleExpression )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1141:6: lv_rhs_2= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionWhereEntryAccess().getRhsExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionWhereEntry2451);
            lv_rhs_2=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "rhs", lv_rhs_2, "Expression", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpressionWhereEntry


    // $ANTLR start entryRuleAliasAttributeExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1166:1: entryRuleAliasAttributeExpression returns [EObject current=null] : iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF ;
    public final EObject entryRuleAliasAttributeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasAttributeExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1166:66: (iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1167:2: iv_ruleAliasAttributeExpression= ruleAliasAttributeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasAttributeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression2488);
            iv_ruleAliasAttributeExpression=ruleAliasAttributeExpression();
            _fsp--;

             current =iv_ruleAliasAttributeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasAttributeExpression2498); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAliasAttributeExpression


    // $ANTLR start ruleAliasAttributeExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1174:1: ruleAliasAttributeExpression returns [EObject current=null] : ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) ;
    public final EObject ruleAliasAttributeExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1179:6: ( ( ( RULE_ID ) ( '.' ( RULE_ID ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1180:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1180:1: ( ( RULE_ID ) ( '.' ( RULE_ID ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1180:2: ( RULE_ID ) ( '.' ( RULE_ID ) )?
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1180:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1183:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasAttributeExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2545); 

            		createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1196:2: ( '.' ( RULE_ID ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1196:3: '.' ( RULE_ID )
                    {
                    match(input,17,FOLLOW_17_in_ruleAliasAttributeExpression2558); 

                            createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getFullStopKeyword_1_0(), null); 
                        
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1200:1: ( RULE_ID )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1203:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getAliasAttributeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2580); 

                    		createLeafNode(grammarAccess.getAliasAttributeExpressionAccess().getAttributeEStructuralFeatureCrossReference_1_1_0(), "attribute"); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAliasAttributeExpression


    // $ANTLR start entryRuleExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1223:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1223:52: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1224:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2618);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1231:1: ruleExpression returns [EObject current=null] : (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AliasAttributeExpression_0 = null;

        EObject this_DoubleExpression_1 = null;

        EObject this_LongExpression_2 = null;

        EObject this_StringExpression_3 = null;

        EObject this_NullExpression_4 = null;

        EObject this_BooleanExpression_5 = null;

        EObject this_QueryExpression_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1236:6: ( (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1237:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1237:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression )
            int alt23=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case RULE_SIGNED_DOUBLE:
                {
                alt23=2;
                }
                break;
            case RULE_SINGED_LONG:
                {
                alt23=3;
                }
                break;
            case RULE_STRING:
                {
                alt23=4;
                }
                break;
            case 30:
                {
                alt23=5;
                }
                break;
            case 31:
            case 32:
                {
                alt23=6;
                }
                break;
            case 28:
                {
                alt23=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1237:1: (this_AliasAttributeExpression_0= ruleAliasAttributeExpression | this_DoubleExpression_1= ruleDoubleExpression | this_LongExpression_2= ruleLongExpression | this_StringExpression_3= ruleStringExpression | this_NullExpression_4= ruleNullExpression | this_BooleanExpression_5= ruleBooleanExpression | this_QueryExpression_6= ruleQueryExpression )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1238:5: this_AliasAttributeExpression_0= ruleAliasAttributeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getAliasAttributeExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasAttributeExpression_in_ruleExpression2675);
                    this_AliasAttributeExpression_0=ruleAliasAttributeExpression();
                    _fsp--;

                     
                            current = this_AliasAttributeExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1248:5: this_DoubleExpression_1= ruleDoubleExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getDoubleExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleExpression_in_ruleExpression2702);
                    this_DoubleExpression_1=ruleDoubleExpression();
                    _fsp--;

                     
                            current = this_DoubleExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1258:5: this_LongExpression_2= ruleLongExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getLongExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongExpression_in_ruleExpression2729);
                    this_LongExpression_2=ruleLongExpression();
                    _fsp--;

                     
                            current = this_LongExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1268:5: this_StringExpression_3= ruleStringExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getStringExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringExpression_in_ruleExpression2756);
                    this_StringExpression_3=ruleStringExpression();
                    _fsp--;

                     
                            current = this_StringExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1278:5: this_NullExpression_4= ruleNullExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getNullExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullExpression_in_ruleExpression2783);
                    this_NullExpression_4=ruleNullExpression();
                    _fsp--;

                     
                            current = this_NullExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1288:5: this_BooleanExpression_5= ruleBooleanExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanExpression_in_ruleExpression2810);
                    this_BooleanExpression_5=ruleBooleanExpression();
                    _fsp--;

                     
                            current = this_BooleanExpression_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1298:5: this_QueryExpression_6= ruleQueryExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getQueryExpressionParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleQueryExpression_in_ruleExpression2837);
                    this_QueryExpression_6=ruleQueryExpression();
                    _fsp--;

                     
                            current = this_QueryExpression_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleDoubleExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1313:1: entryRuleDoubleExpression returns [EObject current=null] : iv_ruleDoubleExpression= ruleDoubleExpression EOF ;
    public final EObject entryRuleDoubleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1313:58: (iv_ruleDoubleExpression= ruleDoubleExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1314:2: iv_ruleDoubleExpression= ruleDoubleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression2869);
            iv_ruleDoubleExpression=ruleDoubleExpression();
            _fsp--;

             current =iv_ruleDoubleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleExpression2879); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDoubleExpression


    // $ANTLR start ruleDoubleExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1321:1: ruleDoubleExpression returns [EObject current=null] : (lv_value_0= RULE_SIGNED_DOUBLE ) ;
    public final EObject ruleDoubleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1326:6: ( (lv_value_0= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1327:1: (lv_value_0= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1327:1: (lv_value_0= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1329:6: lv_value_0= RULE_SIGNED_DOUBLE
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleExpression2925); 

            		createLeafNode(grammarAccess.getDoubleExpressionAccess().getValueSIGNED_DOUBLETerminalRuleCall_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "SIGNED_DOUBLE", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDoubleExpression


    // $ANTLR start entryRuleLongExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1354:1: entryRuleLongExpression returns [EObject current=null] : iv_ruleLongExpression= ruleLongExpression EOF ;
    public final EObject entryRuleLongExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1354:56: (iv_ruleLongExpression= ruleLongExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1355:2: iv_ruleLongExpression= ruleLongExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongExpression_in_entryRuleLongExpression2965);
            iv_ruleLongExpression=ruleLongExpression();
            _fsp--;

             current =iv_ruleLongExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongExpression2975); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLongExpression


    // $ANTLR start ruleLongExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1362:1: ruleLongExpression returns [EObject current=null] : (lv_value_0= RULE_SINGED_LONG ) ;
    public final EObject ruleLongExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1367:6: ( (lv_value_0= RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1368:1: (lv_value_0= RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1368:1: (lv_value_0= RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1370:6: lv_value_0= RULE_SINGED_LONG
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongExpression3021); 

            		createLeafNode(grammarAccess.getLongExpressionAccess().getValueSINGED_LONGTerminalRuleCall_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "SINGED_LONG", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLongExpression


    // $ANTLR start entryRuleStringExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1395:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1395:58: (iv_ruleStringExpression= ruleStringExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1396:2: iv_ruleStringExpression= ruleStringExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression3061);
            iv_ruleStringExpression=ruleStringExpression();
            _fsp--;

             current =iv_ruleStringExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression3071); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStringExpression


    // $ANTLR start ruleStringExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1403:1: ruleStringExpression returns [EObject current=null] : (lv_value_0= RULE_STRING ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1408:6: ( (lv_value_0= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1409:1: (lv_value_0= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1409:1: (lv_value_0= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1411:6: lv_value_0= RULE_STRING
            {
            lv_value_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringExpression3117); 

            		createLeafNode(grammarAccess.getStringExpressionAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_0, "STRING", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringExpression


    // $ANTLR start entryRuleNullExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1436:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1436:56: (iv_ruleNullExpression= ruleNullExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1437:2: iv_ruleNullExpression= ruleNullExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression3157);
            iv_ruleNullExpression=ruleNullExpression();
            _fsp--;

             current =iv_ruleNullExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression3167); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNullExpression


    // $ANTLR start ruleNullExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1444:1: ruleNullExpression returns [EObject current=null] : (lv_value_0= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1449:6: ( (lv_value_0= 'null' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1450:1: (lv_value_0= 'null' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1450:1: (lv_value_0= 'null' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1452:6: lv_value_0= 'null'
            {
            lv_value_0=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_ruleNullExpression3212); 

                    createLeafNode(grammarAccess.getNullExpressionAccess().getValueNullKeyword_0(), "value"); 
                

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", /* lv_value_0 */ input.LT(-1), "null", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNullExpression


    // $ANTLR start entryRuleBooleanExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1478:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1478:59: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1479:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3257);
            iv_ruleBooleanExpression=ruleBooleanExpression();
            _fsp--;

             current =iv_ruleBooleanExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression3267); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1486:1: ruleBooleanExpression returns [EObject current=null] : ( (lv_true_0= 'true' ) | 'false' ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_true_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1491:6: ( ( (lv_true_0= 'true' ) | 'false' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:1: ( (lv_true_0= 'true' ) | 'false' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:1: ( (lv_true_0= 'true' ) | 'false' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            else if ( (LA24_0==32) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1492:1: ( (lv_true_0= 'true' ) | 'false' )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:2: (lv_true_0= 'true' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:2: (lv_true_0= 'true' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1494:6: lv_true_0= 'true'
                    {
                    lv_true_0=(Token)input.LT(1);
                    match(input,31,FOLLOW_31_in_ruleBooleanExpression3313); 

                            createLeafNode(grammarAccess.getBooleanExpressionAccess().getTrueTrueKeyword_0_0(), "true"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "true", true, "true", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1514:6: 'false'
                    {
                    match(input,32,FOLLOW_32_in_ruleBooleanExpression3341); 

                            createLeafNode(grammarAccess.getBooleanExpressionAccess().getFalseKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanExpression


    // $ANTLR start entryRuleQueryExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1525:1: entryRuleQueryExpression returns [EObject current=null] : iv_ruleQueryExpression= ruleQueryExpression EOF ;
    public final EObject entryRuleQueryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryExpression = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1525:57: (iv_ruleQueryExpression= ruleQueryExpression EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1526:2: iv_ruleQueryExpression= ruleQueryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQueryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression3374);
            iv_ruleQueryExpression=ruleQueryExpression();
            _fsp--;

             current =iv_ruleQueryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryExpression3384); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleQueryExpression


    // $ANTLR start ruleQueryExpression
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1533:1: ruleQueryExpression returns [EObject current=null] : ( '(' (lv_value_1= ruleMQLquery ) ')' ) ;
    public final EObject ruleQueryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1538:6: ( ( '(' (lv_value_1= ruleMQLquery ) ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1539:1: ( '(' (lv_value_1= ruleMQLquery ) ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1539:1: ( '(' (lv_value_1= ruleMQLquery ) ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1539:2: '(' (lv_value_1= ruleMQLquery ) ')'
            {
            match(input,28,FOLLOW_28_in_ruleQueryExpression3418); 

                    createLeafNode(grammarAccess.getQueryExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1543:1: (lv_value_1= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1546:6: lv_value_1= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getQueryExpressionAccess().getValueMQLqueryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleQueryExpression3452);
            lv_value_1=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getQueryExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_1, "MQLquery", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,29,FOLLOW_29_in_ruleQueryExpression3465); 

                    createLeafNode(grammarAccess.getQueryExpressionAccess().getRightParenthesisKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQueryExpression


    // $ANTLR start ruleOperator
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1575:1: ruleOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1579:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1580:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1580:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )
            int alt25=10;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt25=1;
                }
                break;
            case 34:
                {
                alt25=2;
                }
                break;
            case 35:
                {
                alt25=3;
                }
                break;
            case 36:
                {
                alt25=4;
                }
                break;
            case 37:
                {
                alt25=5;
                }
                break;
            case 38:
                {
                alt25=6;
                }
                break;
            case 39:
                {
                alt25=7;
                }
                break;
            case 40:
                {
                alt25=8;
                }
                break;
            case 41:
                {
                alt25=9;
                }
                break;
            case 23:
                {
                alt25=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1580:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'not like' ) | ( 'not in' ) | ( 'in' ) )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1580:2: ( '<' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1580:2: ( '<' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1580:4: '<'
                    {
                    match(input,33,FOLLOW_33_in_ruleOperator3512); 

                            current = grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1586:6: ( '>' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1586:6: ( '>' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1586:8: '>'
                    {
                    match(input,34,FOLLOW_34_in_ruleOperator3527); 

                            current = grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1592:6: ( '<=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1592:6: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1592:8: '<='
                    {
                    match(input,35,FOLLOW_35_in_ruleOperator3542); 

                            current = grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1598:6: ( '>=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1598:6: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1598:8: '>='
                    {
                    match(input,36,FOLLOW_36_in_ruleOperator3557); 

                            current = grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1604:6: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1604:6: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1604:8: '='
                    {
                    match(input,37,FOLLOW_37_in_ruleOperator3572); 

                            current = grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1610:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1610:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1610:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleOperator3587); 

                            current = grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotEqualEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1616:6: ( 'like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1616:6: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1616:8: 'like'
                    {
                    match(input,39,FOLLOW_39_in_ruleOperator3602); 

                            current = grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getLikeEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1622:6: ( 'not like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1622:6: ( 'not like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1622:8: 'not like'
                    {
                    match(input,40,FOLLOW_40_in_ruleOperator3617); 

                            current = grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotLikeEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1628:6: ( 'not in' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1628:6: ( 'not in' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1628:8: 'not in'
                    {
                    match(input,41,FOLLOW_41_in_ruleOperator3632); 

                            current = grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getNotInEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1634:6: ( 'in' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1634:6: ( 'in' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1634:8: 'in'
                    {
                    match(input,23,FOLLOW_23_in_ruleOperator3647); 

                            current = grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOperator


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel142 = new BitSet(new long[]{0x0000000000002822L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleModel181 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_ruleModel220 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedQuery_in_entryRuleNamedQuery365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedQuery375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedQuery422 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNamedQuery439 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleNamedQuery473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMQLquery_in_entryRuleMQLquery510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMQLquery520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMQLquery554 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery588 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery636 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleMQLquery651 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery685 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery699 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery733 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_16_in_ruleMQLquery749 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry879 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSelectEntry892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1009 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_18_in_ruleFromEntry1034 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_19_in_ruleFromEntry1057 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1079 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleFromEntry1092 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1114 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleFromEntry1128 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFromEntry1141 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1163 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause1243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_ruleScopeClause1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_ruleScopeClause1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1359 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleResourceScope1415 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleResourceScope1438 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleResourceScope1447 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleResourceScope1456 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1478 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleResourceScope1496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1518 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleResourceScope1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleElementScope1626 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleElementScope1649 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleElementScope1658 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleElementScope1667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1689 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_14_in_ruleElementScope1707 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1729 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_20_in_ruleElementScope1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1838 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleWhereEntry1857 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1891 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1989 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleAndWhereEntry2008 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry2042 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry2083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_ruleConcreteWhereEntry2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry2243 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2265 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleParWhereEntry2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionWhereEntry_in_entryRuleExpressionWhereEntry2306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionWhereEntry2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_ruleExpressionWhereEntry2375 = new BitSet(new long[]{0x000003FE00800000L});
    public static final BitSet FOLLOW_ruleOperator_in_ruleExpressionWhereEntry2413 = new BitSet(new long[]{0x00000001D00000F0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionWhereEntry2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_entryRuleAliasAttributeExpression2488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasAttributeExpression2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2545 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleAliasAttributeExpression2558 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasAttributeExpression2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasAttributeExpression_in_ruleExpression2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_ruleExpression2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_ruleExpression2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_ruleExpression2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_ruleExpression2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleExpression2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_ruleExpression2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleExpression_in_entryRuleDoubleExpression2869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleExpression2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleExpression2925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongExpression_in_entryRuleLongExpression2965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongExpression2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongExpression3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression3061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression3071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringExpression3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression3157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleNullExpression3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression3257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBooleanExpression3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBooleanExpression3341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryExpression_in_entryRuleQueryExpression3374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryExpression3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleQueryExpression3418 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleQueryExpression3452 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleQueryExpression3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleOperator3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleOperator3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleOperator3542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOperator3557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOperator3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOperator3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperator3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOperator3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOperator3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleOperator3647 = new BitSet(new long[]{0x0000000000000002L});

}