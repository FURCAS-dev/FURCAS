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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_SIGNED_DOUBLE", "RULE_SINGED_LONG", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'import'", "':'", "'select'", "','", "'from'", "'where'", "'.'", "'withoutsubtypes'", "'as'", "'not'", "'in'", "'resources'", "'{'", "'}'", "'elements'", "'or'", "'and'", "'('", "')'", "'true'", "'false'", "'null'", "'='", "'<'", "'>'", "'<='", "'>='", "'!='", "'like'", "'notlike'"
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:165:1: ruleImport returns [EObject current=null] : ( 'import' (lv_importURI_1= RULE_STRING ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:170:6: ( ( 'import' (lv_importURI_1= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:1: ( 'import' (lv_importURI_1= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:171:2: 'import' (lv_importURI_1= RULE_STRING )
            {
            match(input,11,FOLLOW_11_in_ruleImport302); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:175:1: (lv_importURI_1= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:177:6: lv_importURI_1= RULE_STRING
            {
            lv_importURI_1=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport324); 

            		createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "importURI", lv_importURI_1, "STRING", lastConsumedNode);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:276:1: ruleMQLquery returns [EObject current=null] : ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? ) ;
    public final EObject ruleMQLquery() throws RecognitionException {
        EObject current = null;

        EObject lv_selectEntries_1 = null;

        EObject lv_selectEntries_3 = null;

        EObject lv_fromEntries_5 = null;

        EObject lv_fromEntries_7 = null;

        EObject lv_whereEntry_9 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:281:6: ( ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:1: ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:1: ( 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:282:2: 'select' (lv_selectEntries_1= ruleSelectEntry ) ( ',' (lv_selectEntries_3= ruleSelectEntry ) )* 'from' (lv_fromEntries_5= ruleFromEntry ) ( ',' (lv_fromEntries_7= ruleFromEntry ) )* ( 'where' (lv_whereEntry_9= ruleWhereEntry ) )?
            {
            match(input,13,FOLLOW_13_in_ruleMQLquery554); 

                    createLeafNode(grammarAccess.getMQLqueryAccess().getSelectKeyword_0(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:286:1: (lv_selectEntries_1= ruleSelectEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:289:6: lv_selectEntries_1= ruleSelectEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery588);
            lv_selectEntries_1=ruleSelectEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "selectEntries", lv_selectEntries_1, "SelectEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:307:2: ( ',' (lv_selectEntries_3= ruleSelectEntry ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:307:3: ',' (lv_selectEntries_3= ruleSelectEntry )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery602); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:311:1: (lv_selectEntries_3= ruleSelectEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:314:6: lv_selectEntries_3= ruleSelectEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getSelectEntriesSelectEntryParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectEntry_in_ruleMQLquery636);
            	    lv_selectEntries_3=ruleSelectEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "selectEntries", lv_selectEntries_3, "SelectEntry", currentNode);
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

                    createLeafNode(grammarAccess.getMQLqueryAccess().getFromKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:336:1: (lv_fromEntries_5= ruleFromEntry )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:339:6: lv_fromEntries_5= ruleFromEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery685);
            lv_fromEntries_5=ruleFromEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "fromEntries", lv_fromEntries_5, "FromEntry", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:357:2: ( ',' (lv_fromEntries_7= ruleFromEntry ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:357:3: ',' (lv_fromEntries_7= ruleFromEntry )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleMQLquery699); 

            	            createLeafNode(grammarAccess.getMQLqueryAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:361:1: (lv_fromEntries_7= ruleFromEntry )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:364:6: lv_fromEntries_7= ruleFromEntry
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMQLqueryAccess().getFromEntriesFromEntryParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFromEntry_in_ruleMQLquery733);
            	    lv_fromEntries_7=ruleFromEntry();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMQLqueryRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "fromEntries", lv_fromEntries_7, "FromEntry", currentNode);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:479:1: ruleFromEntry returns [EObject current=null] : ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? ) ;
    public final EObject ruleFromEntry() throws RecognitionException {
        EObject current = null;

        Token lv_withoutsubtypes_1=null;
        Token lv_alias_3=null;
        EObject lv_scopeClause_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:484:6: ( ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:1: ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:1: ( ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:485:2: ( RULE_ID ) (lv_withoutsubtypes_1= 'withoutsubtypes' )? 'as' (lv_alias_3= RULE_ID ) (lv_scopeClause_4= ruleScopeClause )?
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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:501:2: (lv_withoutsubtypes_1= 'withoutsubtypes' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:503:6: lv_withoutsubtypes_1= 'withoutsubtypes'
                    {
                    lv_withoutsubtypes_1=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleFromEntry1033); 

                            createLeafNode(grammarAccess.getFromEntryAccess().getWithoutsubtypesWithoutsubtypesKeyword_1_0(), "withoutsubtypes"); 
                        

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
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleFromEntry1056); 

                    createLeafNode(grammarAccess.getFromEntryAccess().getAsKeyword_2(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:526:1: (lv_alias_3= RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:528:6: lv_alias_3= RULE_ID
            {
            lv_alias_3=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFromEntry1078); 

            		createLeafNode(grammarAccess.getFromEntryAccess().getAliasIDTerminalRuleCall_3_0(), "alias"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "alias", lv_alias_3, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:546:2: (lv_scopeClause_4= ruleScopeClause )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=20 && LA9_0<=21)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:549:6: lv_scopeClause_4= ruleScopeClause
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFromEntryAccess().getScopeClauseScopeClauseParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleScopeClause_in_ruleFromEntry1120);
                    lv_scopeClause_4=ruleScopeClause();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFromEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "scopeClause", lv_scopeClause_4, "ScopeClause", currentNode);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:574:1: entryRuleScopeClause returns [EObject current=null] : iv_ruleScopeClause= ruleScopeClause EOF ;
    public final EObject entryRuleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScopeClause = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:574:53: (iv_ruleScopeClause= ruleScopeClause EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:575:2: iv_ruleScopeClause= ruleScopeClause EOF
            {
             currentNode = createCompositeNode(grammarAccess.getScopeClauseRule(), currentNode); 
            pushFollow(FOLLOW_ruleScopeClause_in_entryRuleScopeClause1158);
            iv_ruleScopeClause=ruleScopeClause();
            _fsp--;

             current =iv_ruleScopeClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleScopeClause1168); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:582:1: ruleScopeClause returns [EObject current=null] : (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) ;
    public final EObject ruleScopeClause() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceScope_0 = null;

        EObject this_ElementScope_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:587:6: ( (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==21) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==22) ) {
                        alt10=1;
                    }
                    else if ( (LA10_2==25) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==21) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==22) ) {
                    alt10=1;
                }
                else if ( (LA10_2==25) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("588:1: (this_ResourceScope_0= ruleResourceScope | this_ElementScope_1= ruleElementScope )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:589:5: this_ResourceScope_0= ruleResourceScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getResourceScopeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleResourceScope_in_ruleScopeClause1215);
                    this_ResourceScope_0=ruleResourceScope();
                    _fsp--;

                     
                            current = this_ResourceScope_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:599:5: this_ElementScope_1= ruleElementScope
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getScopeClauseAccess().getElementScopeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleElementScope_in_ruleScopeClause1242);
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:614:1: entryRuleResourceScope returns [EObject current=null] : iv_ruleResourceScope= ruleResourceScope EOF ;
    public final EObject entryRuleResourceScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:614:55: (iv_ruleResourceScope= ruleResourceScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:615:2: iv_ruleResourceScope= ruleResourceScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getResourceScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleResourceScope_in_entryRuleResourceScope1274);
            iv_ruleResourceScope=ruleResourceScope();
            _fsp--;

             current =iv_ruleResourceScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceScope1284); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:622:1: ruleResourceScope returns [EObject current=null] : ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) ;
    public final EObject ruleResourceScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0=null;
        Token lv_uris_4=null;
        Token lv_uris_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:627:6: ( ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:628:1: ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:628:1: ( (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:628:2: (lv_notIn_0= 'not' )? 'in' 'resources' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:628:2: (lv_notIn_0= 'not' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:630:6: lv_notIn_0= 'not'
                    {
                    lv_notIn_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleResourceScope1330); 

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

            match(input,21,FOLLOW_21_in_ruleResourceScope1353); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getInKeyword_1(), null); 
                
            match(input,22,FOLLOW_22_in_ruleResourceScope1362); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getResourcesKeyword_2(), null); 
                
            match(input,23,FOLLOW_23_in_ruleResourceScope1371); 

                    createLeafNode(grammarAccess.getResourceScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:661:1: (lv_uris_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:663:6: lv_uris_4= RULE_STRING
            {
            lv_uris_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1393); 

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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:681:2: ( ',' (lv_uris_6= RULE_STRING ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:681:3: ',' (lv_uris_6= RULE_STRING )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleResourceScope1411); 

            	            createLeafNode(grammarAccess.getResourceScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:685:1: (lv_uris_6= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:687:6: lv_uris_6= RULE_STRING
            	    {
            	    lv_uris_6=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResourceScope1433); 

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
            	    break loop12;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_ruleResourceScope1452); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:716:1: entryRuleElementScope returns [EObject current=null] : iv_ruleElementScope= ruleElementScope EOF ;
    public final EObject entryRuleElementScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementScope = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:716:54: (iv_ruleElementScope= ruleElementScope EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:717:2: iv_ruleElementScope= ruleElementScope EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementScopeRule(), currentNode); 
            pushFollow(FOLLOW_ruleElementScope_in_entryRuleElementScope1485);
            iv_ruleElementScope=ruleElementScope();
            _fsp--;

             current =iv_ruleElementScope; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElementScope1495); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:724:1: ruleElementScope returns [EObject current=null] : ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) ;
    public final EObject ruleElementScope() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_0=null;
        Token lv_uris_4=null;
        Token lv_uris_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:729:6: ( ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:730:1: ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:730:1: ( (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:730:2: (lv_notIn_0= 'not' )? 'in' 'elements' '{' (lv_uris_4= RULE_STRING ) ( ',' (lv_uris_6= RULE_STRING ) )* '}'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:730:2: (lv_notIn_0= 'not' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:732:6: lv_notIn_0= 'not'
                    {
                    lv_notIn_0=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleElementScope1541); 

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

            match(input,21,FOLLOW_21_in_ruleElementScope1564); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getInKeyword_1(), null); 
                
            match(input,25,FOLLOW_25_in_ruleElementScope1573); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getElementsKeyword_2(), null); 
                
            match(input,23,FOLLOW_23_in_ruleElementScope1582); 

                    createLeafNode(grammarAccess.getElementScopeAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:763:1: (lv_uris_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:765:6: lv_uris_4= RULE_STRING
            {
            lv_uris_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1604); 

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

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:783:2: ( ',' (lv_uris_6= RULE_STRING ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==14) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:783:3: ',' (lv_uris_6= RULE_STRING )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleElementScope1622); 

            	            createLeafNode(grammarAccess.getElementScopeAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:787:1: (lv_uris_6= RULE_STRING )
            	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:789:6: lv_uris_6= RULE_STRING
            	    {
            	    lv_uris_6=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleElementScope1644); 

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
            	    break loop14;
                }
            } while (true);

            match(input,24,FOLLOW_24_in_ruleElementScope1663); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:818:1: entryRuleWhereEntry returns [EObject current=null] : iv_ruleWhereEntry= ruleWhereEntry EOF ;
    public final EObject entryRuleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:818:52: (iv_ruleWhereEntry= ruleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:819:2: iv_ruleWhereEntry= ruleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1696);
            iv_ruleWhereEntry=ruleWhereEntry();
            _fsp--;

             current =iv_ruleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereEntry1706); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:826:1: ruleWhereEntry returns [EObject current=null] : (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) ;
    public final EObject ruleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_AndWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:831:6: ( (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:832:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:832:1: (this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:833:5: this_AndWhereEntry_0= ruleAndWhereEntry ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getAndWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1753);
            this_AndWhereEntry_0=ruleAndWhereEntry();
            _fsp--;

             
                    current = this_AndWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:841:1: ( () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:841:2: () ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:841:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:842:5: 
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

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:857:2: ( 'or' (lv_entries_3= ruleAndWhereEntry ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==26) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:857:3: 'or' (lv_entries_3= ruleAndWhereEntry )
                    	    {
                    	    match(input,26,FOLLOW_26_in_ruleWhereEntry1772); 

                    	            createLeafNode(grammarAccess.getWhereEntryAccess().getOrKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:861:1: (lv_entries_3= ruleAndWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:864:6: lv_entries_3= ruleAndWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getWhereEntryAccess().getEntriesAndWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1806);
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
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:889:1: entryRuleAndWhereEntry returns [EObject current=null] : iv_ruleAndWhereEntry= ruleAndWhereEntry EOF ;
    public final EObject entryRuleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:889:55: (iv_ruleAndWhereEntry= ruleAndWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:890:2: iv_ruleAndWhereEntry= ruleAndWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1847);
            iv_ruleAndWhereEntry=ruleAndWhereEntry();
            _fsp--;

             current =iv_ruleAndWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndWhereEntry1857); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:897:1: ruleAndWhereEntry returns [EObject current=null] : (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) ;
    public final EObject ruleAndWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteWhereEntry_0 = null;

        EObject lv_entries_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:902:6: ( (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:903:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:903:1: (this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )? )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:904:5: this_ConcreteWhereEntry_0= ruleConcreteWhereEntry ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getConcreteWhereEntryParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1904);
            this_ConcreteWhereEntry_0=ruleConcreteWhereEntry();
            _fsp--;

             
                    current = this_ConcreteWhereEntry_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:912:1: ( () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:912:2: () ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:912:2: ()
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:913:5: 
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

                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:928:2: ( 'and' (lv_entries_3= ruleConcreteWhereEntry ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==27) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:928:3: 'and' (lv_entries_3= ruleConcreteWhereEntry )
                    	    {
                    	    match(input,27,FOLLOW_27_in_ruleAndWhereEntry1923); 

                    	            createLeafNode(grammarAccess.getAndWhereEntryAccess().getAndKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:932:1: (lv_entries_3= ruleConcreteWhereEntry )
                    	    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:935:6: lv_entries_3= ruleConcreteWhereEntry
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAndWhereEntryAccess().getEntriesConcreteWhereEntryParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1957);
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
    // $ANTLR end ruleAndWhereEntry


    // $ANTLR start entryRuleConcreteWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:960:1: entryRuleConcreteWhereEntry returns [EObject current=null] : iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF ;
    public final EObject entryRuleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:960:60: (iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:961:2: iv_ruleConcreteWhereEntry= ruleConcreteWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1998);
            iv_ruleConcreteWhereEntry=ruleConcreteWhereEntry();
            _fsp--;

             current =iv_ruleConcreteWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcreteWhereEntry2008); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:968:1: ruleConcreteWhereEntry returns [EObject current=null] : (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry ) ;
    public final EObject ruleConcreteWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ParWhereEntry_0 = null;

        EObject this_AttributeWhereEntry_1 = null;

        EObject this_ReferenceWhereEntry_2 = null;

        EObject this_AliasWhereEntry_3 = null;

        EObject this_NullWhereEntry_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:973:6: ( (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )
            int alt19=5;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==17) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 33:
                            {
                            switch ( input.LA(5) ) {
                            case RULE_ID:
                                {
                                int LA19_10 = input.LA(6);

                                if ( (LA19_10==17) ) {
                                    alt19=2;
                                }
                                else if ( (LA19_10==EOF||LA19_10==RULE_ID||(LA19_10>=26 && LA19_10<=27)||LA19_10==29) ) {
                                    alt19=3;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 10, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case RULE_STRING:
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                            case 30:
                            case 31:
                                {
                                alt19=2;
                                }
                                break;
                            case 32:
                                {
                                alt19=5;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 6, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 38:
                            {
                            int LA19_7 = input.LA(5);

                            if ( ((LA19_7>=RULE_STRING && LA19_7<=RULE_SINGED_LONG)||(LA19_7>=30 && LA19_7<=31)) ) {
                                alt19=2;
                            }
                            else if ( (LA19_7==32) ) {
                                alt19=5;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 39:
                        case 40:
                            {
                            alt19=2;
                            }
                            break;
                        case 20:
                        case 21:
                            {
                            alt19=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA19_2==33) ) {
                    alt19=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("974:1: (this_ParWhereEntry_0= ruleParWhereEntry | this_AttributeWhereEntry_1= ruleAttributeWhereEntry | this_ReferenceWhereEntry_2= ruleReferenceWhereEntry | this_AliasWhereEntry_3= ruleAliasWhereEntry | this_NullWhereEntry_4= ruleNullWhereEntry )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:975:5: this_ParWhereEntry_0= ruleParWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getParWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry2055);
                    this_ParWhereEntry_0=ruleParWhereEntry();
                    _fsp--;

                     
                            current = this_ParWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:985:5: this_AttributeWhereEntry_1= ruleAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry2082);
                    this_AttributeWhereEntry_1=ruleAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_AttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:995:5: this_ReferenceWhereEntry_2= ruleReferenceWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getReferenceWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceWhereEntry_in_ruleConcreteWhereEntry2109);
                    this_ReferenceWhereEntry_2=ruleReferenceWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1005:5: this_AliasWhereEntry_3= ruleAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getAliasWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry2136);
                    this_AliasWhereEntry_3=ruleAliasWhereEntry();
                    _fsp--;

                     
                            current = this_AliasWhereEntry_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1015:5: this_NullWhereEntry_4= ruleNullWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcreteWhereEntryAccess().getNullWhereEntryParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry2163);
                    this_NullWhereEntry_4=ruleNullWhereEntry();
                    _fsp--;

                     
                            current = this_NullWhereEntry_4; 
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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1030:1: entryRuleParWhereEntry returns [EObject current=null] : iv_ruleParWhereEntry= ruleParWhereEntry EOF ;
    public final EObject entryRuleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1030:55: (iv_ruleParWhereEntry= ruleParWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1031:2: iv_ruleParWhereEntry= ruleParWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2195);
            iv_ruleParWhereEntry=ruleParWhereEntry();
            _fsp--;

             current =iv_ruleParWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParWhereEntry2205); 

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
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1038:1: ruleParWhereEntry returns [EObject current=null] : ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) ;
    public final EObject ruleParWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_WhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1043:6: ( ( '(' this_WhereEntry_1= ruleWhereEntry ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1044:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1044:1: ( '(' this_WhereEntry_1= ruleWhereEntry ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1044:2: '(' this_WhereEntry_1= ruleWhereEntry ')'
            {
            match(input,28,FOLLOW_28_in_ruleParWhereEntry2239); 

                    createLeafNode(grammarAccess.getParWhereEntryAccess().getLeftParenthesisKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getParWhereEntryAccess().getWhereEntryParserRuleCall_1(), currentNode); 
                
            pushFollow(FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2261);
            this_WhereEntry_1=ruleWhereEntry();
            _fsp--;

             
                    current = this_WhereEntry_1; 
                    currentNode = currentNode.getParent();
                
            match(input,29,FOLLOW_29_in_ruleParWhereEntry2269); 

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


    // $ANTLR start entryRuleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1068:1: entryRuleAttributeWhereEntry returns [EObject current=null] : iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF ;
    public final EObject entryRuleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1068:61: (iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1069:2: iv_ruleAttributeWhereEntry= ruleAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2302);
            iv_ruleAttributeWhereEntry=ruleAttributeWhereEntry();
            _fsp--;

             current =iv_ruleAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeWhereEntry2312); 

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
    // $ANTLR end entryRuleAttributeWhereEntry


    // $ANTLR start ruleAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1076:1: ruleAttributeWhereEntry returns [EObject current=null] : (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) ;
    public final EObject ruleAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_NumericAttributeWhereEntry_0 = null;

        EObject this_StringAttributeWhereEntry_1 = null;

        EObject this_BooleanAttributeWhereEntry_2 = null;

        EObject this_VariableWhereEntry_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1081:6: ( (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )
            int alt20=4;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==17) ) {
                    int LA20_2 = input.LA(3);

                    if ( (LA20_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 34:
                            {
                            int LA20_4 = input.LA(5);

                            if ( (LA20_4==RULE_ID) ) {
                                alt20=4;
                            }
                            else if ( ((LA20_4>=RULE_SIGNED_DOUBLE && LA20_4<=RULE_SINGED_LONG)) ) {
                                alt20=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA20_5 = input.LA(5);

                            if ( ((LA20_5>=RULE_SIGNED_DOUBLE && LA20_5<=RULE_SINGED_LONG)) ) {
                                alt20=1;
                            }
                            else if ( (LA20_5==RULE_ID) ) {
                                alt20=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA20_6 = input.LA(5);

                            if ( (LA20_6==RULE_ID) ) {
                                alt20=4;
                            }
                            else if ( ((LA20_6>=RULE_SIGNED_DOUBLE && LA20_6<=RULE_SINGED_LONG)) ) {
                                alt20=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA20_7 = input.LA(5);

                            if ( ((LA20_7>=RULE_SIGNED_DOUBLE && LA20_7<=RULE_SINGED_LONG)) ) {
                                alt20=1;
                            }
                            else if ( (LA20_7==RULE_ID) ) {
                                alt20=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                            {
                            switch ( input.LA(5) ) {
                            case 30:
                            case 31:
                                {
                                alt20=3;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt20=1;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt20=2;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt20=4;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 8, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 38:
                            {
                            switch ( input.LA(5) ) {
                            case 30:
                            case 31:
                                {
                                alt20=3;
                                }
                                break;
                            case RULE_ID:
                                {
                                alt20=4;
                                }
                                break;
                            case RULE_SIGNED_DOUBLE:
                            case RULE_SINGED_LONG:
                                {
                                alt20=1;
                                }
                                break;
                            case RULE_STRING:
                                {
                                alt20=2;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 9, input);

                                throw nvae;
                            }

                            }
                            break;
                        case 39:
                        case 40:
                            {
                            alt20=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1082:1: (this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry | this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry | this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry | this_VariableWhereEntry_3= ruleVariableWhereEntry )", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1083:5: this_NumericAttributeWhereEntry_0= ruleNumericAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getNumericAttributeWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2359);
                    this_NumericAttributeWhereEntry_0=ruleNumericAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_NumericAttributeWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1093:5: this_StringAttributeWhereEntry_1= ruleStringAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getStringAttributeWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2386);
                    this_StringAttributeWhereEntry_1=ruleStringAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_StringAttributeWhereEntry_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1103:5: this_BooleanAttributeWhereEntry_2= ruleBooleanAttributeWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getBooleanAttributeWhereEntryParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2413);
                    this_BooleanAttributeWhereEntry_2=ruleBooleanAttributeWhereEntry();
                    _fsp--;

                     
                            current = this_BooleanAttributeWhereEntry_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1113:5: this_VariableWhereEntry_3= ruleVariableWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAttributeWhereEntryAccess().getVariableWhereEntryParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2440);
                    this_VariableWhereEntry_3=ruleVariableWhereEntry();
                    _fsp--;

                     
                            current = this_VariableWhereEntry_3; 
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
    // $ANTLR end ruleAttributeWhereEntry


    // $ANTLR start entryRuleNumericAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1128:1: entryRuleNumericAttributeWhereEntry returns [EObject current=null] : iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF ;
    public final EObject entryRuleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1128:68: (iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1129:2: iv_ruleNumericAttributeWhereEntry= ruleNumericAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2472);
            iv_ruleNumericAttributeWhereEntry=ruleNumericAttributeWhereEntry();
            _fsp--;

             current =iv_ruleNumericAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2482); 

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
    // $ANTLR end entryRuleNumericAttributeWhereEntry


    // $ANTLR start ruleNumericAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1136:1: ruleNumericAttributeWhereEntry returns [EObject current=null] : (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) ;
    public final EObject ruleNumericAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_DoubleWhereEntry_0 = null;

        EObject this_LongWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1141:6: ( (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==17) ) {
                    int LA21_2 = input.LA(3);

                    if ( (LA21_2==RULE_ID) ) {
                        switch ( input.LA(4) ) {
                        case 34:
                            {
                            int LA21_4 = input.LA(5);

                            if ( (LA21_4==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else if ( (LA21_4==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA21_5 = input.LA(5);

                            if ( (LA21_5==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else if ( (LA21_5==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 36:
                            {
                            int LA21_6 = input.LA(5);

                            if ( (LA21_6==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else if ( (LA21_6==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA21_7 = input.LA(5);

                            if ( (LA21_7==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else if ( (LA21_7==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 7, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 33:
                            {
                            int LA21_8 = input.LA(5);

                            if ( (LA21_8==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else if ( (LA21_8==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 8, input);

                                throw nvae;
                            }
                            }
                            break;
                        case 38:
                            {
                            int LA21_9 = input.LA(5);

                            if ( (LA21_9==RULE_SINGED_LONG) ) {
                                alt21=2;
                            }
                            else if ( (LA21_9==RULE_SIGNED_DOUBLE) ) {
                                alt21=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 9, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1142:1: (this_DoubleWhereEntry_0= ruleDoubleWhereEntry | this_LongWhereEntry_1= ruleLongWhereEntry )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1143:5: this_DoubleWhereEntry_0= ruleDoubleWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getDoubleWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2529);
                    this_DoubleWhereEntry_0=ruleDoubleWhereEntry();
                    _fsp--;

                     
                            current = this_DoubleWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1153:5: this_LongWhereEntry_1= ruleLongWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericAttributeWhereEntryAccess().getLongWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2556);
                    this_LongWhereEntry_1=ruleLongWhereEntry();
                    _fsp--;

                     
                            current = this_LongWhereEntry_1; 
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
    // $ANTLR end ruleNumericAttributeWhereEntry


    // $ANTLR start entryRuleDoubleWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1168:1: entryRuleDoubleWhereEntry returns [EObject current=null] : iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF ;
    public final EObject entryRuleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1168:58: (iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1169:2: iv_ruleDoubleWhereEntry= ruleDoubleWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDoubleWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2588);
            iv_ruleDoubleWhereEntry=ruleDoubleWhereEntry();
            _fsp--;

             current =iv_ruleDoubleWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoubleWhereEntry2598); 

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
    // $ANTLR end entryRuleDoubleWhereEntry


    // $ANTLR start ruleDoubleWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1176:1: ruleDoubleWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) ;
    public final EObject ruleDoubleWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1181:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1182:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1182:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1182:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SIGNED_DOUBLE )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1182:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1185:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2645); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleDoubleWhereEntry2657); 

                    createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1202:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1205:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2679); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1218:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1221:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDoubleWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2716);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1239:2: (lv_value_4= RULE_SIGNED_DOUBLE )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1241:6: lv_value_4= RULE_SIGNED_DOUBLE
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SIGNED_DOUBLE,FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2742); 

            		createLeafNode(grammarAccess.getDoubleWhereEntryAccess().getValueSIGNED_DOUBLETerminalRuleCall_4_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDoubleWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_4, "SIGNED_DOUBLE", lastConsumedNode);
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
    // $ANTLR end ruleDoubleWhereEntry


    // $ANTLR start entryRuleLongWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1266:1: entryRuleLongWhereEntry returns [EObject current=null] : iv_ruleLongWhereEntry= ruleLongWhereEntry EOF ;
    public final EObject entryRuleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1266:56: (iv_ruleLongWhereEntry= ruleLongWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1267:2: iv_ruleLongWhereEntry= ruleLongWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLongWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2783);
            iv_ruleLongWhereEntry=ruleLongWhereEntry();
            _fsp--;

             current =iv_ruleLongWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongWhereEntry2793); 

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
    // $ANTLR end entryRuleLongWhereEntry


    // $ANTLR start ruleLongWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1274:1: ruleLongWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) ;
    public final EObject ruleLongWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_value_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1279:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1280:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1280:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1280:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) (lv_value_4= RULE_SINGED_LONG )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1280:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1283:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2840); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleLongWhereEntry2852); 

                    createLeafNode(grammarAccess.getLongWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1300:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1303:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongWhereEntry2874); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1316:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1319:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLongWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2911);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1337:2: (lv_value_4= RULE_SINGED_LONG )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1339:6: lv_value_4= RULE_SINGED_LONG
            {
            lv_value_4=(Token)input.LT(1);
            match(input,RULE_SINGED_LONG,FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2937); 

            		createLeafNode(grammarAccess.getLongWhereEntryAccess().getValueSINGED_LONGTerminalRuleCall_4_0(), "value"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLongWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_4, "SINGED_LONG", lastConsumedNode);
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
    // $ANTLR end ruleLongWhereEntry


    // $ANTLR start entryRuleVariableWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1364:1: entryRuleVariableWhereEntry returns [EObject current=null] : iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF ;
    public final EObject entryRuleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1364:60: (iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1365:2: iv_ruleVariableWhereEntry= ruleVariableWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2978);
            iv_ruleVariableWhereEntry=ruleVariableWhereEntry();
            _fsp--;

             current =iv_ruleVariableWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableWhereEntry2988); 

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
    // $ANTLR end entryRuleVariableWhereEntry


    // $ANTLR start ruleVariableWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1372:1: ruleVariableWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) ;
    public final EObject ruleVariableWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1377:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1378:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1378:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1378:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleNumericOperator ) ( RULE_ID ) '.' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1378:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1381:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3035); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleVariableWhereEntry3047); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1398:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1401:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3069); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1414:2: (lv_operator_3= ruleNumericOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1417:6: lv_operator_3= ruleNumericOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableWhereEntryAccess().getOperatorNumericOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3106);
            lv_operator_3=ruleNumericOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "NumericOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1435:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1438:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3132); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleVariableWhereEntry3144); 

                    createLeafNode(grammarAccess.getVariableWhereEntryAccess().getFullStopKeyword_5(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1455:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1458:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getVariableWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableWhereEntry3166); 

            		createLeafNode(grammarAccess.getVariableWhereEntryAccess().getRightAttributeEAttributeCrossReference_6_0(), "rightAttribute"); 
            	

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
    // $ANTLR end ruleVariableWhereEntry


    // $ANTLR start entryRuleStringAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1478:1: entryRuleStringAttributeWhereEntry returns [EObject current=null] : iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF ;
    public final EObject entryRuleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1478:67: (iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1479:2: iv_ruleStringAttributeWhereEntry= ruleStringAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3202);
            iv_ruleStringAttributeWhereEntry=ruleStringAttributeWhereEntry();
            _fsp--;

             current =iv_ruleStringAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3212); 

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
    // $ANTLR end entryRuleStringAttributeWhereEntry


    // $ANTLR start ruleStringAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1486:1: ruleStringAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) ;
    public final EObject ruleStringAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_pattern_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1491:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleStringOperator ) (lv_pattern_4= RULE_STRING )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1492:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1495:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3259); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleStringAttributeWhereEntry3271); 

                    createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1512:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1515:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3293); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1528:2: (lv_operator_3= ruleStringOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1531:6: lv_operator_3= ruleStringOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getStringAttributeWhereEntryAccess().getOperatorStringOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3330);
            lv_operator_3=ruleStringOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "StringOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1549:2: (lv_pattern_4= RULE_STRING )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1551:6: lv_pattern_4= RULE_STRING
            {
            lv_pattern_4=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3356); 

            		createLeafNode(grammarAccess.getStringAttributeWhereEntryAccess().getPatternSTRINGTerminalRuleCall_4_0(), "pattern"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "pattern", lv_pattern_4, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleStringAttributeWhereEntry


    // $ANTLR start entryRuleBooleanAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1576:1: entryRuleBooleanAttributeWhereEntry returns [EObject current=null] : iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF ;
    public final EObject entryRuleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAttributeWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1576:68: (iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1577:2: iv_ruleBooleanAttributeWhereEntry= ruleBooleanAttributeWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3397);
            iv_ruleBooleanAttributeWhereEntry=ruleBooleanAttributeWhereEntry();
            _fsp--;

             current =iv_ruleBooleanAttributeWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3407); 

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
    // $ANTLR end entryRuleBooleanAttributeWhereEntry


    // $ANTLR start ruleBooleanAttributeWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1584:1: ruleBooleanAttributeWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) ;
    public final EObject ruleBooleanAttributeWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_isTrue_4=null;
        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1589:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1590:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1590:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1590:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) ( (lv_isTrue_4= 'true' ) | 'false' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1590:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1593:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3454); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleBooleanAttributeWhereEntry3466); 

                    createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1610:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1613:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3488); 

            		createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getAttributeEAttributeCrossReference_2_0(), "attribute"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1626:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1629:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3525);
            lv_operator_3=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "BooleanOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1647:2: ( (lv_isTrue_4= 'true' ) | 'false' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            else if ( (LA22_0==31) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1647:2: ( (lv_isTrue_4= 'true' ) | 'false' )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1647:3: (lv_isTrue_4= 'true' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1647:3: (lv_isTrue_4= 'true' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1649:6: lv_isTrue_4= 'true'
                    {
                    lv_isTrue_4=(Token)input.LT(1);
                    match(input,30,FOLLOW_30_in_ruleBooleanAttributeWhereEntry3551); 

                            createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getIsTrueTrueKeyword_4_0_0(), "isTrue"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanAttributeWhereEntryRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "isTrue", true, "true", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1669:6: 'false'
                    {
                    match(input,31,FOLLOW_31_in_ruleBooleanAttributeWhereEntry3579); 

                            createLeafNode(grammarAccess.getBooleanAttributeWhereEntryAccess().getFalseKeyword_4_1(), null); 
                        

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
    // $ANTLR end ruleBooleanAttributeWhereEntry


    // $ANTLR start entryRuleReferenceWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1680:1: entryRuleReferenceWhereEntry returns [EObject current=null] : iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF ;
    public final EObject entryRuleReferenceWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1680:61: (iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1681:2: iv_ruleReferenceWhereEntry= ruleReferenceWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry3613);
            iv_ruleReferenceWhereEntry=ruleReferenceWhereEntry();
            _fsp--;

             current =iv_ruleReferenceWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceWhereEntry3623); 

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
    // $ANTLR end entryRuleReferenceWhereEntry


    // $ANTLR start ruleReferenceWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1688:1: ruleReferenceWhereEntry returns [EObject current=null] : (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry ) ;
    public final EObject ruleReferenceWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceAliasWhereEntry_0 = null;

        EObject this_SubselectWhereEntry_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1693:6: ( (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==17) ) {
                    int LA23_2 = input.LA(3);

                    if ( (LA23_2==RULE_ID) ) {
                        int LA23_3 = input.LA(4);

                        if ( (LA23_3==33) ) {
                            alt23=1;
                        }
                        else if ( ((LA23_3>=20 && LA23_3<=21)) ) {
                            alt23=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 23, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 23, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1694:1: (this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry | this_SubselectWhereEntry_1= ruleSubselectWhereEntry )", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1695:5: this_ReferenceAliasWhereEntry_0= ruleReferenceAliasWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReferenceWhereEntryAccess().getReferenceAliasWhereEntryParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_ruleReferenceWhereEntry3670);
                    this_ReferenceAliasWhereEntry_0=ruleReferenceAliasWhereEntry();
                    _fsp--;

                     
                            current = this_ReferenceAliasWhereEntry_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1705:5: this_SubselectWhereEntry_1= ruleSubselectWhereEntry
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getReferenceWhereEntryAccess().getSubselectWhereEntryParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSubselectWhereEntry_in_ruleReferenceWhereEntry3697);
                    this_SubselectWhereEntry_1=ruleSubselectWhereEntry();
                    _fsp--;

                     
                            current = this_SubselectWhereEntry_1; 
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
    // $ANTLR end ruleReferenceWhereEntry


    // $ANTLR start entryRuleNullWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1720:1: entryRuleNullWhereEntry returns [EObject current=null] : iv_ruleNullWhereEntry= ruleNullWhereEntry EOF ;
    public final EObject entryRuleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1720:56: (iv_ruleNullWhereEntry= ruleNullWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1721:2: iv_ruleNullWhereEntry= ruleNullWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNullWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3729);
            iv_ruleNullWhereEntry=ruleNullWhereEntry();
            _fsp--;

             current =iv_ruleNullWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullWhereEntry3739); 

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
    // $ANTLR end entryRuleNullWhereEntry


    // $ANTLR start ruleNullWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1728:1: ruleNullWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) ;
    public final EObject ruleNullWhereEntry() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1733:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1734:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1734:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1734:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_operator_3= ruleBooleanOperator ) 'null'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1734:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1737:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3786); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleNullWhereEntry3798); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1754:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1757:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNullWhereEntry3820); 

            		createLeafNode(grammarAccess.getNullWhereEntryAccess().getFeatureEStructuralFeatureCrossReference_2_0(), "feature"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1770:2: (lv_operator_3= ruleBooleanOperator )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1773:6: lv_operator_3= ruleBooleanOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNullWhereEntryAccess().getOperatorBooleanOperatorEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3857);
            lv_operator_3=ruleBooleanOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNullWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "operator", lv_operator_3, "BooleanOperator", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,32,FOLLOW_32_in_ruleNullWhereEntry3870); 

                    createLeafNode(grammarAccess.getNullWhereEntryAccess().getNullKeyword_4(), null); 
                

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
    // $ANTLR end ruleNullWhereEntry


    // $ANTLR start entryRuleReferenceAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1802:1: entryRuleReferenceAliasWhereEntry returns [EObject current=null] : iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF ;
    public final EObject entryRuleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAliasWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1802:66: (iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1803:2: iv_ruleReferenceAliasWhereEntry= ruleReferenceAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3903);
            iv_ruleReferenceAliasWhereEntry=ruleReferenceAliasWhereEntry();
            _fsp--;

             current =iv_ruleReferenceAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3913); 

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
    // $ANTLR end entryRuleReferenceAliasWhereEntry


    // $ANTLR start ruleReferenceAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1810:1: ruleReferenceAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleReferenceAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1815:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1816:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1816:1: ( ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1816:2: ( RULE_ID ) '.' ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1816:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1819:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3960); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleReferenceAliasWhereEntry3972); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1836:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1839:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3994); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }

            match(input,33,FOLLOW_33_in_ruleReferenceAliasWhereEntry4006); 

                    createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getEqualsSignKeyword_3(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1856:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1859:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4028); 

            		createLeafNode(grammarAccess.getReferenceAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_4_0(), "rightAlias"); 
            	

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
    // $ANTLR end ruleReferenceAliasWhereEntry


    // $ANTLR start entryRuleSubselectWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1879:1: entryRuleSubselectWhereEntry returns [EObject current=null] : iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF ;
    public final EObject entryRuleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubselectWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1879:61: (iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1880:2: iv_ruleSubselectWhereEntry= ruleSubselectWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubselectWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry4064);
            iv_ruleSubselectWhereEntry=ruleSubselectWhereEntry();
            _fsp--;

             current =iv_ruleSubselectWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubselectWhereEntry4074); 

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
    // $ANTLR end entryRuleSubselectWhereEntry


    // $ANTLR start ruleSubselectWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1887:1: ruleSubselectWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) ;
    public final EObject ruleSubselectWhereEntry() throws RecognitionException {
        EObject current = null;

        Token lv_notIn_3=null;
        EObject lv_subQuery_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1892:6: ( ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1893:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1893:1: ( ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')' )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1893:2: ( RULE_ID ) '.' ( RULE_ID ) (lv_notIn_3= 'not' )? 'in' '(' (lv_subQuery_6= ruleMQLquery ) ')'
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1893:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1896:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4121); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,17,FOLLOW_17_in_ruleSubselectWhereEntry4133); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getFullStopKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1913:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1916:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4155); 

            		createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getReferenceEReferenceCrossReference_2_0(), "reference"); 
            	

            }

            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1929:2: (lv_notIn_3= 'not' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==20) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1931:6: lv_notIn_3= 'not'
                    {
                    lv_notIn_3=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleSubselectWhereEntry4179); 

                            createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getNotInNotKeyword_3_0(), "notIn"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
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

            match(input,21,FOLLOW_21_in_ruleSubselectWhereEntry4202); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getInKeyword_4(), null); 
                
            match(input,28,FOLLOW_28_in_ruleSubselectWhereEntry4211); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getLeftParenthesisKeyword_5(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1958:1: (lv_subQuery_6= ruleMQLquery )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1961:6: lv_subQuery_6= ruleMQLquery
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubselectWhereEntryAccess().getSubQueryMQLqueryParserRuleCall_6_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4245);
            lv_subQuery_6=ruleMQLquery();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubselectWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "subQuery", lv_subQuery_6, "MQLquery", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,29,FOLLOW_29_in_ruleSubselectWhereEntry4258); 

                    createLeafNode(grammarAccess.getSubselectWhereEntryAccess().getRightParenthesisKeyword_7(), null); 
                

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
    // $ANTLR end ruleSubselectWhereEntry


    // $ANTLR start entryRuleAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1990:1: entryRuleAliasWhereEntry returns [EObject current=null] : iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF ;
    public final EObject entryRuleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAliasWhereEntry = null;


        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1990:57: (iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1991:2: iv_ruleAliasWhereEntry= ruleAliasWhereEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAliasWhereEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4291);
            iv_ruleAliasWhereEntry=ruleAliasWhereEntry();
            _fsp--;

             current =iv_ruleAliasWhereEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAliasWhereEntry4301); 

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
    // $ANTLR end entryRuleAliasWhereEntry


    // $ANTLR start ruleAliasWhereEntry
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:1998:1: ruleAliasWhereEntry returns [EObject current=null] : ( ( RULE_ID ) '=' ( RULE_ID ) ) ;
    public final EObject ruleAliasWhereEntry() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2003:6: ( ( ( RULE_ID ) '=' ( RULE_ID ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2004:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2004:1: ( ( RULE_ID ) '=' ( RULE_ID ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2004:2: ( RULE_ID ) '=' ( RULE_ID )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2004:2: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2007:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4348); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getAliasFromEntryCrossReference_0_0(), "alias"); 
            	

            }

            match(input,33,FOLLOW_33_in_ruleAliasWhereEntry4360); 

                    createLeafNode(grammarAccess.getAliasWhereEntryAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2024:1: ( RULE_ID )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2027:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getAliasWhereEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAliasWhereEntry4382); 

            		createLeafNode(grammarAccess.getAliasWhereEntryAccess().getRightAliasFromEntryCrossReference_2_0(), "rightAlias"); 
            	

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
    // $ANTLR end ruleAliasWhereEntry


    // $ANTLR start ruleNumericOperator
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2047:1: ruleNumericOperator returns [Enumerator current=null] : ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleNumericOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2051:6: ( ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2052:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2052:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )
            int alt25=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt25=1;
                }
                break;
            case 35:
                {
                alt25=2;
                }
                break;
            case 36:
                {
                alt25=3;
                }
                break;
            case 37:
                {
                alt25=4;
                }
                break;
            case 33:
                {
                alt25=5;
                }
                break;
            case 38:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2052:1: ( ( '<' ) | ( '>' ) | ( '<=' ) | ( '>=' ) | ( '=' ) | ( '!=' ) )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2052:2: ( '<' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2052:2: ( '<' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2052:4: '<'
                    {
                    match(input,34,FOLLOW_34_in_ruleNumericOperator4432); 

                            current = grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessThenEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2058:6: ( '>' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2058:6: ( '>' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2058:8: '>'
                    {
                    match(input,35,FOLLOW_35_in_ruleNumericOperator4447); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterThenEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2064:6: ( '<=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2064:6: ( '<=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2064:8: '<='
                    {
                    match(input,36,FOLLOW_36_in_ruleNumericOperator4462); 

                            current = grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getLessEqualEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2070:6: ( '>=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2070:6: ( '>=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2070:8: '>='
                    {
                    match(input,37,FOLLOW_37_in_ruleNumericOperator4477); 

                            current = grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2076:6: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2076:6: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2076:8: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleNumericOperator4492); 

                            current = grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getEqualEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2082:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleNumericOperator4507); 

                            current = grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getNumericOperatorAccess().getNotEqualEnumLiteralDeclaration_5(), null); 
                        

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
    // $ANTLR end ruleNumericOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2092:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2096:6: ( ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2097:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2097:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt26=1;
                }
                break;
            case 38:
                {
                alt26=2;
                }
                break;
            case 39:
                {
                alt26=3;
                }
                break;
            case 40:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2097:1: ( ( '=' ) | ( '!=' ) | ( 'like' ) | ( 'notlike' ) )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2097:2: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2097:2: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2097:4: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleStringOperator4550); 

                            current = grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2103:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2103:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2103:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleStringOperator4565); 

                            current = grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2109:6: ( 'like' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2109:6: ( 'like' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2109:8: 'like'
                    {
                    match(input,39,FOLLOW_39_in_ruleStringOperator4580); 

                            current = grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLikeEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2115:6: ( 'notlike' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2115:6: ( 'notlike' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2115:8: 'notlike'
                    {
                    match(input,40,FOLLOW_40_in_ruleStringOperator4595); 

                            current = grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNotLikeEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleBooleanOperator
    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2125:1: ruleBooleanOperator returns [Enumerator current=null] : ( ( '=' ) | ( '!=' ) ) ;
    public final Enumerator ruleBooleanOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2129:6: ( ( ( '=' ) | ( '!=' ) ) )
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2130:1: ( ( '=' ) | ( '!=' ) )
            {
            // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2130:1: ( ( '=' ) | ( '!=' ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            else if ( (LA27_0==38) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2130:1: ( ( '=' ) | ( '!=' ) )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2130:2: ( '=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2130:2: ( '=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2130:4: '='
                    {
                    match(input,33,FOLLOW_33_in_ruleBooleanOperator4638); 

                            current = grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getEqualEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2136:6: ( '!=' )
                    {
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2136:6: ( '!=' )
                    // ../org.eclipse.emf.query2.syntax/src-gen/org/eclipse/emf/query2/parser/antlr/internal/InternalQuery.g:2136:8: '!='
                    {
                    match(input,38,FOLLOW_38_in_ruleBooleanOperator4653); 

                            current = grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanOperatorAccess().getNotEqualEnumLiteralDeclaration_1(), null); 
                        

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
    // $ANTLR end ruleBooleanOperator


 

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
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery588 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_ruleMQLquery636 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleMQLquery651 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery685 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_14_in_ruleMQLquery699 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFromEntry_in_ruleMQLquery733 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_16_in_ruleMQLquery749 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleMQLquery783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectEntry_in_entryRuleSelectEntry822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectEntry832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry879 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSelectEntry892 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectEntry914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFromEntry_in_entryRuleFromEntry952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFromEntry962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1009 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleFromEntry1033 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFromEntry1056 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFromEntry1078 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_ruleFromEntry1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScopeClause_in_entryRuleScopeClause1158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScopeClause1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_ruleScopeClause1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_ruleScopeClause1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceScope_in_entryRuleResourceScope1274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceScope1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleResourceScope1330 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleResourceScope1353 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleResourceScope1362 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleResourceScope1371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1393 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleResourceScope1411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceScope1433 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleResourceScope1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElementScope_in_entryRuleElementScope1485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElementScope1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleElementScope1541 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleElementScope1564 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleElementScope1573 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleElementScope1582 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1604 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleElementScope1622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleElementScope1644 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleElementScope1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_entryRuleWhereEntry1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereEntry1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1753 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleWhereEntry1772 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_ruleWhereEntry1806 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleAndWhereEntry_in_entryRuleAndWhereEntry1847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndWhereEntry1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1904 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleAndWhereEntry1923 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_ruleAndWhereEntry1957 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleConcreteWhereEntry_in_entryRuleConcreteWhereEntry1998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcreteWhereEntry2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_ruleConcreteWhereEntry2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_ruleConcreteWhereEntry2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_ruleConcreteWhereEntry2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_ruleConcreteWhereEntry2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_ruleConcreteWhereEntry2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParWhereEntry_in_entryRuleParWhereEntry2195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParWhereEntry2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleParWhereEntry2239 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleWhereEntry_in_ruleParWhereEntry2261 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleParWhereEntry2269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeWhereEntry_in_entryRuleAttributeWhereEntry2302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeWhereEntry2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_ruleAttributeWhereEntry2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_ruleAttributeWhereEntry2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_ruleAttributeWhereEntry2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_ruleAttributeWhereEntry2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericAttributeWhereEntry_in_entryRuleNumericAttributeWhereEntry2472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericAttributeWhereEntry2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_ruleNumericAttributeWhereEntry2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_ruleNumericAttributeWhereEntry2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoubleWhereEntry_in_entryRuleDoubleWhereEntry2588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoubleWhereEntry2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2645 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleDoubleWhereEntry2657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDoubleWhereEntry2679 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleDoubleWhereEntry2716 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_SIGNED_DOUBLE_in_ruleDoubleWhereEntry2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongWhereEntry_in_entryRuleLongWhereEntry2783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongWhereEntry2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2840 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLongWhereEntry2852 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongWhereEntry2874 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleLongWhereEntry2911 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SINGED_LONG_in_ruleLongWhereEntry2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableWhereEntry_in_entryRuleVariableWhereEntry2978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableWhereEntry2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3035 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableWhereEntry3047 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3069 = new BitSet(new long[]{0x0000007E00000000L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_ruleVariableWhereEntry3106 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3132 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleVariableWhereEntry3144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableWhereEntry3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringAttributeWhereEntry_in_entryRuleStringAttributeWhereEntry3202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringAttributeWhereEntry3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3259 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleStringAttributeWhereEntry3271 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringAttributeWhereEntry3293 = new BitSet(new long[]{0x000001C200000000L});
    public static final BitSet FOLLOW_ruleStringOperator_in_ruleStringAttributeWhereEntry3330 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringAttributeWhereEntry3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAttributeWhereEntry_in_entryRuleBooleanAttributeWhereEntry3397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAttributeWhereEntry3407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3454 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleBooleanAttributeWhereEntry3466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanAttributeWhereEntry3488 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleBooleanAttributeWhereEntry3525 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_30_in_ruleBooleanAttributeWhereEntry3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBooleanAttributeWhereEntry3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceWhereEntry_in_entryRuleReferenceWhereEntry3613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceWhereEntry3623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_ruleReferenceWhereEntry3670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_ruleReferenceWhereEntry3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullWhereEntry_in_entryRuleNullWhereEntry3729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullWhereEntry3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3786 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleNullWhereEntry3798 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNullWhereEntry3820 = new BitSet(new long[]{0x0000004200000000L});
    public static final BitSet FOLLOW_ruleBooleanOperator_in_ruleNullWhereEntry3857 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleNullWhereEntry3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAliasWhereEntry_in_entryRuleReferenceAliasWhereEntry3903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAliasWhereEntry3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3960 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleReferenceAliasWhereEntry3972 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry3994 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleReferenceAliasWhereEntry4006 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAliasWhereEntry4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubselectWhereEntry_in_entryRuleSubselectWhereEntry4064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubselectWhereEntry4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4121 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSubselectWhereEntry4133 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubselectWhereEntry4155 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleSubselectWhereEntry4179 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSubselectWhereEntry4202 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSubselectWhereEntry4211 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleMQLquery_in_ruleSubselectWhereEntry4245 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSubselectWhereEntry4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAliasWhereEntry_in_entryRuleAliasWhereEntry4291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAliasWhereEntry4301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4348 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAliasWhereEntry4360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAliasWhereEntry4382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleNumericOperator4432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleNumericOperator4447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleNumericOperator4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNumericOperator4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleNumericOperator4492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNumericOperator4507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleStringOperator4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringOperator4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringOperator4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleStringOperator4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanOperator4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanOperator4653 = new BitSet(new long[]{0x0000000000000002L});

}